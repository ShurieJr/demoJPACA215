package JPACA215;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }
    //requests

    @GetMapping("/")
    public String homepage(){
        return "home";
    }
    @GetMapping("/Register")
    public String register(){
        return "RegisterCustomer";  //view name
    }
    //get mapping
    @GetMapping("/all")
    public ModelAndView getAllCustomers(){
        List<Customer> customerList= service.getAllCustomers();
        return new ModelAndView("CustomerList","customer", customerList);
    }




    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id){
        return service.getCustomerById(id);
    }

    //post mapping
    @PostMapping("/save")
    public String insertCustomer(@ModelAttribute Customer customer){
        service.InsertCustomer(customer);
        return "redirect:/all";
    }

    //update
    @RequestMapping("/Edit/{id}")
    public String updateCustomer(@PathVariable int id,
                               Model model){
     Customer customer = service.getCustomerById(id);
     model.addAttribute("customer", customer);
     return "EditCustomer";

    }

    ///delete
    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id){
        service.deleteCustomer(id);
        return "redirect:/all";
    }
}
