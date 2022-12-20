/**
 * 
 */
package de.champonthis.ghs.server.web;

import java.io.File;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The Class WebConfig.
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	/*
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
	 */
	/*
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#
	 * addResourceHandlers(org.springframework.web.servlet.config.annotation.
	 * ResourceHandlerRegistry)
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/noclient.html").addResourceLocations("classpath:/public/noclient.html");

		registry.addResourceHandler("/**").addResourceLocations(
				"file:" + new File(System.getProperty("user.home"), ".ghs" + File.separator + "gloomhavensecretariat")
						.getAbsolutePath() + File.separator);
	}

}
