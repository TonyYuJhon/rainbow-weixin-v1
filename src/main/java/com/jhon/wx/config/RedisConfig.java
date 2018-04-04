package com.jhon.wx.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * <p>功能描述</br></p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName rainbow-weixin
 * @date 2018/3/26 22:55
 */
@Data
@Configuration
@EnableAutoConfiguration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {

  private String host;

  private int port;

  private int timeout;

  @Bean
  public JedisPool redisPoolFactory() {
    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);
    return jedisPool;
  }
}
