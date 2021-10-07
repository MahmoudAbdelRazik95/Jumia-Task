package jumia.services;

import jumia.models.CustomersResult;
import jumia.models.RequestOptions;

public interface CustomerService {

     CustomersResult getAllCustomers(RequestOptions options);
}
