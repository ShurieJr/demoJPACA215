package JPACA215;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }
//oprations
    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }

    public Customer getCustomerById(int id){
        return repository.findById(id).orElse(null);
    }

    public void InsertCustomer(Customer customer){
        repository.save(customer);
    }
    public void updateCustomer(Customer customer){
        repository.save(customer);
    }
    public void deleteCustomer(int id){
        repository.deleteById(id);
    }
}
