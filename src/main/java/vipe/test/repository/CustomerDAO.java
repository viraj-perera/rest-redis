package vipe.test.repository;

import vipe.test.domain.Customer;

public interface CustomerDAO {

    void saveCustomer(Customer customer);

    Customer getCustomer(String id);

    boolean removeCustomer(String id);

    void editCustomer(Customer customer);
}
