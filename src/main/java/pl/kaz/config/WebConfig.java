package pl.kaz.config;


import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import pl.kaz.interceptor.BaseInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public  EmbeddedServletContainerCustomizer containerCustomizer (){
		
		return new EmbeddedServletContainerCustomizer(){
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container){
				ErrorPage error401Page= new ErrorPage(HttpStatus.UNAUTHORIZED,"/401.html");
				ErrorPage error404Page= new ErrorPage(HttpStatus.NOT_FOUND,"/404.html");
				ErrorPage error500Page= new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500.html");
				container.addErrorPages(error401Page,error404Page,error500Page);
			}
			
		};
	}
	

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		super.addViewControllers(registry);
        registry.addViewController("/login").setViewName("auth/login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);		
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new BaseInterceptor());
	}
	
	
	
}
