package jumia.models;

import java.io.Serializable;
import java.util.List;

public class CustomersResult implements Serializable {
    private List<Customer> customers;
    private int totalSize;

    public CustomersResult(List<Customer> customers, int totalSize) {
        this.customers = customers;
        this.totalSize = totalSize;
    }

    public List<Customer> getCustomers() { return customers; }

    public int getTotalSize() { return totalSize; }
}
