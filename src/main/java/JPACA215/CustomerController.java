package JPACA215;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }
    //requests
    //get mapping
    @GetMapping("/all")
    public List<Customer> getAllCustomers(){
        return service.getAllCustomers();
    }
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id){
        return service.getCustomerById(id);
    }

    //post mapping
    @PostMapping
    public void insertCustomer(@RequestBody Customer customer){
        service.InsertCustomer(customer);
    }

    //update
    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable int id,
                               @RequestBody Customer customer){
        customer.setId(id);
        service.updateCustomer(customer);
    }

    ///delete
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id){
        service.deleteCustomer(id);
    }
}
