package de.champonthis.ghs.server;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@SpringBootApplication
@EnableScheduling
@PropertySource("classpath:default.properties")
@PropertySource(value = "file:///${user.home}/.ghs/application.properties", ignoreResourceNotFound = true)
public class Application {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
		if (!Arrays.asList(args).contains("-Djava.awt.headless=true")) {
			builder.headless(false);
		}
		builder.run(args);
	}

	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		File ghsFolder = new File(System.getProperty("user.home"), ".ghs");
		if (!ghsFolder.exists()) {
			ghsFolder.mkdirs();
		} else if (ghsFolder.isFile()) {
			System.err.println("ghs folder is file!");
		}

		File propertiesFile = new File(System.getProperty("user.home"),
				".ghs" + File.separator + "application.properties");

		migrateToUserDir(propertiesFile);

		if (!propertiesFile.exists()) {
			try {
				propertiesFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		PropertySourcesPlaceholderConfigurer properties = new PropertySourcesPlaceholderConfigurer();
		properties.setLocation(new FileSystemResource(propertiesFile.getAbsolutePath()));
		properties.setIgnoreResourceNotFound(false);
		properties.setLocalOverride(true);
		return properties;
	}

	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(1);
		threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
		return threadPoolTaskScheduler;
	}

	private void migrateToUserDir(File propertiesFile) {
		File oldPropertiesFile = new File("application.properties");
		if (oldPropertiesFile.exists()) {
			try {
				Files.move(oldPropertiesFile.toPath(), propertiesFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
