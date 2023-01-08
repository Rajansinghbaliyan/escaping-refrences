package customers;

import com.github.javafaker.Faker;
import util.Timer;
import util.Util;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class CustomerUtil {
    private final Faker FAKER = Util.getFAKER();
    private final CustomerRecords customerRecords = new CustomerRecords();

    public void iterateOverRecords(int noOfCustomer) {

//        customerRecords.fillRecords(noOfCustomer);

        customerRecords.addCustomer(new Customer(0, "James", "Tech"));

        iterateOverCollection(
                customerRecords
                        .getCustomers()
                        .stream()
                        .map(c -> (ReadOnlyCustomer) c),
                "Stream with Original collection"
        );

        iterateOverCollection(
                customerRecords
                        .getImmutableCustomer()
                        .stream(),
                "Stream with Immutable collection"
        );

        iterateOverCollection(
                customerRecords
                        .getCopyOf()
                        .stream()
                        .map(c -> (ReadOnlyCustomer) c),
                "Stream with Copy of collection"
        );

//        Optional<ReadOnlyCustomer> james = customerRecords
//                .getImmutableCustomer()
//                .stream()
//                .filter(c -> {
//                    System.out.println("Inside filter");
//                     return c.getName().startsWith("Ja");
//                })
//                .findFirst();
//
//        james.ifPresent(j -> {
//            System.out.println(j);
//            j = new Customer(0,"hello","hello");
//        });
//
//
//        customerRecords
//                .getImmutableCustomer()
//                .stream()
//                .filter(c -> c.getName().equals("hello"))
//                .findFirst()
//                .ifPresent(c -> System.out.println(c));

        ReadOnlyCustomer readOnlyCustomer = customerRecords.find("James");

        Customer customer = (Customer) readOnlyCustomer;

        customer.setName("James Changed");

        System.out.println(customerRecords);



    }

    public void iterateOverCollection(Stream<ReadOnlyCustomer> stream, String msg) {
        System.out.println(msg);
        Timer timer = new Timer();

        AtomicInteger counter = new AtomicInteger();

        stream
                .peek(c -> counter.set(counter.get() + 1))
                .filter(c -> c.getName().startsWith("Jamesdfsgsdfg"))
                .findFirst()
                .ifPresent(c -> System.out.println(c.getName()));


        System.out.println("Counter is: " + counter);

        timer.printTimeDifference();
    }
}
