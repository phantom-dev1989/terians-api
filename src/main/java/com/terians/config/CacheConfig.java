/*
package com.terians.config;

import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*/
/**
 * Created by stromero on 1/22/2015.
 *//*

@Configuration
@EnableCaching
static class CacheConfig implements CachingConfigurer {

    @Bean
    @Override
    static CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager());
    }

    @Bean(destroyMethod = "shutdown")
    static net.sf.ehcache.CacheManager ehCacheManager() {

        CacheConfiguration cacheConfiguration = new CacheConfiguration();
        cacheConfiguration.setName("teriansCache");
        cacheConfiguration.setMemoryStoreEvictionPolicy("LRU");
        cacheConfiguration.setMaxEntriesLocalHeap(1000);

        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        config.addCache(cacheConfiguration);

        return net.sf.ehcache.CacheManager.newInstance(config);
    }

    @Bean
    @Override
    static KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }
}
*/
