package vipe.test.config;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * A single Jedis instance is not threadsafe!
 * --> https://github.com/xetorthio/jedis/wiki/Getting-started
 * @author viraj
 */
public class JedisConfig {

    private static JedisConfig jedisConfig;

    private JedisPool jedisPool;

    private JedisConfig() {
        this.initJedisPool();
    }

    public static JedisConfig getInstance(){
        if(jedisConfig == null){
            jedisConfig = new JedisConfig();
            System.out.println("Initializing JdisConfig...");
        }
        return jedisConfig;
    }

    private void initJedisPool(){
        this.jedisPool = new JedisPool(new JedisPoolConfig(), "localhost");
        System.out.println("JedisPool is created...");
    }

    public JedisPool getJedisPool(){
        return this.jedisPool;
    }

}
