package uz.pdp.online.springbootcashing.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CasheConfig {

    @Bean
    CacheManager cacheManager() {
        ConcurrentMapCacheManager concurrentMapCacheManager = new ConcurrentMapCacheManager();
        concurrentMapCacheManager
                .setCacheNames(List.of("photos", "videos"));

        return concurrentMapCacheManager;
    }



}
