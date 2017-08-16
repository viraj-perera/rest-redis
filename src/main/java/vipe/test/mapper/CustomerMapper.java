package vipe.test.mapper;

import vipe.test.domain.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerMapper {

    public Customer doLoad(String id, Map<String, String> properties){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName(properties.get("firstName"));
        customer.setLastName(properties.get("lastName"));
        customer.setPersonalNumber(properties.get("personalNumber"));
        return customer;
    }

    public Map<String,String> loadDataMap(Customer customer) {
        Map<String, String> customerData = new HashMap<>(4);
        customerData.put("firstName", customer.getFirstName());
        customerData.put("lastName", customer.getLastName());
        customerData.put("personalNumber", customer.getPersonalNumber());
        customerData.put("id", customer.getId());
        return customerData;
    }
}
