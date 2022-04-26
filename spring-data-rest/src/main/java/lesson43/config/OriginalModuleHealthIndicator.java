package lesson43.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
@Slf4j
public class OriginalModuleHealthIndicator implements HealthIndicator {

    @Value("${module.basic.url}")
    private URI originalModuleUri;
    private final RestTemplate restTemplate;

    public OriginalModuleHealthIndicator(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Health health() {
        try {
            restTemplate.getForObject(originalModuleUri, String.class);
            return Health.up()
                    .withDetail("description", "dependent module is reachable").build();
        } catch (Exception e) {
            log.error("Exception happens", e);
            return Health.down()
                    .withDetail("description", "dependent module is unreachable")
                    .withDetail("reason", e.getLocalizedMessage()).build();
        }
    }
}
