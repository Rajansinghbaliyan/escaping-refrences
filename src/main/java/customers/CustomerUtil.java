package customer;

import com.github.javafaker.Faker;
import org.openjdk.jmh.annotations.Benchmark;
import util.Util;

import java.util.Map;
import java.util.stream.IntStream;

public class CustomerUtil {
    private final Faker FAKER = Util.getFAKER();

    @Benchmark
    public void fillCustomerRecords(Map<String, Customer> records, int noOfCustomers) {
        IntStream
                .rangeClosed(0, noOfCustomers)
                .mapToObj(i -> new Customer(
                        (int) (Math.random() * 1000),
                        FAKER.name().firstName(),
                        FAKER.commerce().department()
                ))
                .forEach(customer -> records.put(customer.getName(),customer));
    }
}
