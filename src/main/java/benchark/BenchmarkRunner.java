package benchark;

import customers.CustomerRecords;
import customers.CustomerUtil;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void testFillCustomer(){
        CustomerUtil customerUtil = new CustomerUtil();
        CustomerRecords customerRecords = new CustomerRecords();

//        customerUtil.fillCustomerRecords(customerRecords.getCustomers(), 1000);
    }
}
