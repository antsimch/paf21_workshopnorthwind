package sg.edu.nus.iss.paf21_workshopnorthwind.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.paf21_workshopnorthwind.model.Customer;
import sg.edu.nus.iss.paf21_workshopnorthwind.model.Order;
import sg.edu.nus.iss.paf21_workshopnorthwind.service.CustomerService;

@RestController
@RequestMapping(path = "/api")
public class CustomerController {
    
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers", produces = "application/json")
    public ResponseEntity<List<Customer>> getAllCustomers(
                @RequestParam(defaultValue = "0") int offset, 
                @RequestParam(defaultValue = "5") int limit) {
        
        List<Customer> customers = new ArrayList<>();
        customers = customerService.getAllCustomers(offset, limit);
        
        if (customers.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(customers);
        }
    }

    @GetMapping(path = "/customer/{customerId}")
    public ResponseEntity<Customer> getCustomerById(
                @PathVariable int customerId) {

        Customer customer = customerService
                .findCustomerById(customerId);

        if (customer == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(customer);
        }
    }

    @GetMapping(path = "/customer/{customerId}/orders")
    public ResponseEntity<List<Order>> getAllOrdersForCustomerId(
            @PathVariable int customerId) {
        
        List<Order> orders = new ArrayList<>();
        orders = customerService.getAllOrdersByCustomerId(customerId);
        return ResponseEntity.ok().body(orders);
    }
}
