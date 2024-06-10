package JPACA215.Service;


import JPACA215.Model.Customer;
import JPACA215.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }
//oprations
    public List<Customer> getAllCustomers(String keyword){
       if(keyword != null){
           return repository.search(keyword);
       }
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
