package customer;

import java.util.Map;
import java.util.TreeMap;

public class CustomerRecords{
    private final Map<String, Customer> records;

    public CustomerRecords(Map<String, customer.Customer> records) {
        this.records = records;
    }
}
