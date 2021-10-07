package jumia.services;

import jumia.dao.CustomersRepo;
import jumia.models.Customer;
import jumia.models.CustomersResult;
import jumia.models.RequestOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomersRepo repo;
    private final CustomerValidator customerValidator;
    private final static String ALL = "All";

    @Autowired
    public CustomerServiceImpl(CustomersRepo repo) {
        this.repo = repo;
        this.customerValidator = new CustomerValidator();
    }

    // A method to get all the requested customers
    public CustomersResult getAllCustomers(RequestOptions options) {
        int totalSize, filterFrom, filterTo;
        int pageSize = options.getPageSize();
        List<Customer> filteredCustomers = new ArrayList<>();
        List<Customer> customers = repo.findAll();

        for (Customer customer : customers) {
            customerValidator.validateNumber(customer);
            filteredCustomers = this.filterCustomer(options, customer, filteredCustomers);
        }

        totalSize = filteredCustomers.size();
        filterFrom = (options.getPageNumber() - 1) * pageSize;
        filterTo = Math.min(filterFrom + pageSize, totalSize);

        if (pageSize == -1){
            return new CustomersResult(filteredCustomers, filteredCustomers.size());
        }

        filteredCustomers = filteredCustomers.subList(filterFrom, filterTo);
        return new CustomersResult(filteredCustomers, totalSize);
    }

    // A method which filters the customer depending on the requested country and state
    private List<Customer> filterCustomer(RequestOptions options, Customer customer, List<Customer> filteredCustomers){
        String country = options.getCountry();
        String state = options.getState();
        String customerCountry = customer.getCountry();
        String customerState = customer.getState();

        if (country.equals(ALL) && state.equals(ALL)){
            filteredCustomers.add(customer);
        }
        else if(state.equals(ALL)){
            if (customerCountry.equals(country)) {
                filteredCustomers.add(customer);
            }
        }
        else if (country.equals(ALL)){
            if (customerState.equals(state)) {
                filteredCustomers.add(customer);
            }
        }
        else{
            if (customerCountry.equals(country) && customerState.equals(state)){
                filteredCustomers.add(customer);
            }
        }
        return filteredCustomers;
    }
}
