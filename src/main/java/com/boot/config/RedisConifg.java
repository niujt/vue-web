package com.boot.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Configuration
@EnableCaching
@AutoConfigureAfter(RedisConifg.class)
public class RedisConifg {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.timeout}")
    private int timeout;

    /**
     * 配置自定义redisTemplate
     * @param connectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setValueSerializer(jackson2JsonRedisSerializer());
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jackson2JsonRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }
    /**
     * json序列化
     * @return
     */
    @Bean
    public RedisSerializer<Object> jackson2JsonRedisSerializer() {
        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(mapper);
        return serializer;
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
        //设置缓存有效期一分钟
        RedisCacheConfiguration redisCacheConfiguration=RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration.entryTtl(Duration.ofMinutes(1))
        //key为String序列化
            .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
        //value为json 序列化
            .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer()))
        //不设置空值
            .disableCachingNullValues();
        //设置一个初始化的缓存空间set集合
        Set<String> cacheNames=new HashSet<>();
        cacheNames.add("timeGroup");
        cacheNames.add("city");
        //对每个缓存空间应用不同的配置
        Map<String,RedisCacheConfiguration> configMap=new HashMap<>();
        configMap.put("timeGroup",redisCacheConfiguration);
        configMap.put("city",redisCacheConfiguration.entryTtl(Duration.ofSeconds(120)));
        //使用自定义缓存的配置初始化一个cacheManager
        RedisCacheManager cacheManager=RedisCacheManager.builder(redisConnectionFactory).initialCacheNames(cacheNames).withInitialCacheConfigurations(configMap).build();


        return  cacheManager;

    }

}
