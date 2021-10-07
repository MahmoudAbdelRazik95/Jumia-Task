package jumia.controllers;

import jumia.models.CustomersResult;
import jumia.models.RequestOptions;
import jumia.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/getCustomers")
    public CustomersResult getAllCustomers(@RequestBody RequestOptions options) {
        return customerService.getAllCustomers(options);
    }

}
