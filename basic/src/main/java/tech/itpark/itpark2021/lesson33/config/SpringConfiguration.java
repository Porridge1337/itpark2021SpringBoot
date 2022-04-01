package tech.itpark.itpark2021.lesson33.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.net.URL;

@Data
@Configuration
@ConfigurationProperties("cbr")
@EnableConfigurationProperties
public class SpringConfiguration {

    private URL url;

}
