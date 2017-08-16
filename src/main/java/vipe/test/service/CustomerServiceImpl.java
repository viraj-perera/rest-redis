package vipe.test.service;

import vipe.test.domain.Customer;
import vipe.test.repository.CustomerDAO;
import vipe.test.repository.CustomerDAOImpl;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    public CustomerServiceImpl(){
        this.customerDAO = new CustomerDAOImpl();
    }

    @Override
    public Customer getCustomer(String id) {
        System.out.println("Customer is being loaded... [id="+id+"]");
        long starTime =System.currentTimeMillis();
        System.out.println("time in millis [START]: "+starTime);
        Customer customer = customerDAO.getCustomer(id.toString());
        long endTime =System.currentTimeMillis();
        System.out.println("time in millis [END]: "+endTime);
        System.out.println("Elapsed time: "+ (endTime - starTime));
        return customer;
    }

    @Override
    public void saveCustomer(Customer customer) {
        System.out.println("Saving customer..[id="+customer.getId()+"]");
        customerDAO.saveCustomer(customer);
    }

    @Override
    public void removeCustomer(String id) {
        System.out.println("Removing customer..[id="+id+"]");
        customerDAO.removeCustomer(id);
    }

    @Override
    public void editCustomer(Customer customer) {
        System.out.println("Editing customer..[id="+customer.getId()+"]");
        customerDAO.editCustomer(customer);
    }
}
