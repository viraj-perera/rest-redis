package vipe.test.repository;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import vipe.test.domain.Customer;
import vipe.test.mapper.CustomerMapper;

import java.util.Map;

/**
 * Jedis based DAO implementation for customer domain object.
 * @author Viraj
 */
public class CustomerDAOImpl implements CustomerDAO{

    private CustomerMapper mapper;

    public CustomerDAOImpl(){
        mapper = new CustomerMapper();
    }


    @Override
    public void saveCustomer(Customer customer) {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
        Jedis jedis = pool.getResource();
        jedis.hmset("cust:"+customer.getId(), mapper.loadDataMap(customer));
        if (jedis != null) {
            jedis.close();
        }
    }

    @Override
    public Customer getCustomer(String id) {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
        Jedis jedis = pool.getResource();
        Map<String, String> result =  jedis.hgetAll("cust:"+ id);
        Customer cus = this.mapper.doLoad(id, result);

        if (jedis != null) {
            jedis.close();
        }

        return cus;
    }

    @Override
    public boolean removeCustomer(String id) {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
        Jedis jedis = pool.getResource();
        jedis.del("cust:"+id);
        if (jedis != null) {
            jedis.close();
        }
        return false;
    }

    @Override
    public void editCustomer(Customer customer) {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
        Jedis jedis = pool.getResource();
        jedis.hmset("cust:"+customer.getId(), mapper.loadDataMap(customer));
        if (jedis != null) {
            jedis.close();
        }
    }
}
