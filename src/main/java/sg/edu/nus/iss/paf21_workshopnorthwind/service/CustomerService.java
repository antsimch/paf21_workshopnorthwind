package sg.edu.nus.iss.paf21_workshopnorthwind.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf21_workshopnorthwind.model.Customer;
import sg.edu.nus.iss.paf21_workshopnorthwind.model.Order;
import sg.edu.nus.iss.paf21_workshopnorthwind.repository.CustomerRepository;

@Service
public class CustomerService {

    private CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getAllCustomers(int offset, int limit) {
        return customerRepo.getAllCustomers(offset, limit);
    }
    
    public Customer findCustomerById(int customerId) {
        return customerRepo.findCustomerById(customerId);
    }

    public List<Order> getAllOrdersByCustomerId(int customerId) {
        return customerRepo.getAllOrdersByCustomerId(customerId);
    }
}
