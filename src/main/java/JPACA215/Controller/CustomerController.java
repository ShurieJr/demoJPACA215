package JPACA215.Controller;

import JPACA215.Service.CustomerService;
import JPACA215.Model.Customer;
import org.springframework.data.repository.query.Param;
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
    public String getAllCustomers(Model model , @Param("keyword") String keyword){
        List<Customer> customerList= service.getAllCustomers(keyword);
        model.addAttribute("customer", customerList);
        model.addAttribute("keyword", keyword);
        return "CustomerList";
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
