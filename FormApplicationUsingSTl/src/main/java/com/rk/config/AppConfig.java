package com.rk.config;

import java.util.Locale;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan(basePackages = { "com.rk", "com.rk.controller.rest", "com.rk.controller.ui" })
@PropertySource("classpath:app.properties")
@EnableWebMvc
@EnableTransactionManagement
@EnableSwagger2
public class AppConfig implements WebMvcConfigurer {
	@Autowired
	private Environment env;

	
	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.rk.controller.rest"))
				.paths(PathSelectors.regex("/restemp.*")).build();
	}

	@Bean
	public DataSource ds() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("mydriver"));
		ds.setUrl(env.getProperty("myurl"));
		ds.setUsername(env.getProperty("myuser"));
		ds.setPassword(env.getProperty("mypwd"));
		return ds;
	}

	@Bean
	public Properties prop() {
		Properties p = new Properties();
		p.put("hibernate.dialect", env.getProperty("hb.dialect"));
		p.put("hibernate.format_sql", env.getProperty("hb.format"));
		p.put("hibernate.show_sql", env.getProperty("hb.show"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("hbmddl"));
		return p;
	}

	@Bean
	public LocalSessionFactoryBean lsfb() {
		LocalSessionFactoryBean lb = new LocalSessionFactoryBean();
		lb.setDataSource(ds());
		lb.setHibernateProperties(prop());
		lb.setPackagesToScan("com.rk.modle");
		return lb;
	}

	@Bean
	public HibernateTransactionManager htm() {
		HibernateTransactionManager h = new HibernateTransactionManager();
		h.setSessionFactory(lsfb().getObject());
		return h;
	}

	@Bean
	public HibernateTemplate ht() {
		return new HibernateTemplate(lsfb().getObject());
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource r = new ReloadableResourceBundleMessageSource();
		r.setBasename("classpath:messages");
		r.setDefaultEncoding("UTF-8");
		return r;
	}

	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver c = new CookieLocaleResolver();
		c.setDefaultLocale(Locale.ENGLISH);
		c.setCookieName("mycky");
		return c;
	}

	@Bean
	public LocaleChangeInterceptor interceptor() {
		LocaleChangeInterceptor l = new LocaleChangeInterceptor();
		l.setParamName("lang");
		return l;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor());
	}

	@Bean
	public InternalResourceViewResolver iv() {
		InternalResourceViewResolver i = new InternalResourceViewResolver();
		i.setPrefix(env.getProperty("mvc.prefix"));
		i.setSuffix(env.getProperty("mvc.suffix"));
		return i;
	}
}
