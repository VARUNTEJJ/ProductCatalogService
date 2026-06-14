package in.varun.productcatalogservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    /*
    In cofigurations, we tell spring to create some library object and keep it /
    manage it's lifecycle
     */

    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}
