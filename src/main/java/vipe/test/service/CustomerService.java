package vipe.test.service;

import vipe.test.domain.Customer;

public interface CustomerService {

    public Customer getCustomer(String id);

    public void saveCustomer(Customer customer);

    public void removeCustomer(String id);

    void editCustomer(Customer customer);
}
