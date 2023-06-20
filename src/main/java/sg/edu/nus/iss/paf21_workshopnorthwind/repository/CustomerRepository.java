package sg.edu.nus.iss.paf21_workshopnorthwind.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf21_workshopnorthwind.model.Customer;
import sg.edu.nus.iss.paf21_workshopnorthwind.model.Order;

@Repository
public class CustomerRepository {
    
    private JdbcTemplate template;

    private final String findAllLimitOffsetSQL = 
            "select * from customers limit ? offset ?";

    private final String findByIdSQL = 
            "select * from customers where id = ?";

    private final String findAllOrdersByCustomerIdSQL =
            "select * from orders where customer_id = ?";

    public CustomerRepository(JdbcTemplate template) {
        this.template = template;
    }

    public List<Customer> getAllCustomers(int offset, int limit) {
        return template.query(findAllLimitOffsetSQL, 
                BeanPropertyRowMapper
                .newInstance(Customer.class), 
                limit, offset);
    }

    public Customer findCustomerById(int customerId) {
        return template.queryForObject(findByIdSQL, 
                BeanPropertyRowMapper
                .newInstance(Customer.class), 
                customerId);
    }

    public List<Order> getAllOrdersByCustomerId(int customerId) {
        return template.query(findAllOrdersByCustomerIdSQL,
                BeanPropertyRowMapper
                .newInstance(Order.class), 
                customerId);
    }
}
