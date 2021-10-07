package jumia.services;

import jumia.models.Customer;
import jumia.models.CustomersResult;
import jumia.models.RequestOptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    private RequestOptions options;
    private static final int PAGE_NUMBER = 1;
    private static final int PAGE_SIZE = 10;
    private static final String COUNTRY = "Morocco";
    private static final String STATE = "Not Valid";
    private static final List<String> EXPECTED_CUSTOMER_NAMES
        =  Arrays.asList("Walid Hammadi", "Younes Boutikyad", "Houda Houda");

    @Test
    void getAllCustomersTest() {
        options = new RequestOptions(PAGE_NUMBER, PAGE_SIZE, COUNTRY, STATE);
        CustomersResult customersResult = customerService.getAllCustomers(options);
        List<String> namesResult = new ArrayList<>();

        Assert.assertTrue(customersResult.getTotalSize() > 0);
        for (Customer customer : customersResult.getCustomers()) {
            namesResult.add(customer.getName());
        }
        Assert.assertEquals(EXPECTED_CUSTOMER_NAMES, namesResult);
    }
}