package customers;

import com.github.javafaker.Faker;
import util.Util;

import java.util.*;
import java.util.stream.IntStream;

public class CustomerRecords {
    private final Faker FAKER = Util.getFAKER();
    private final List<Customer> list;

    public CustomerRecords() {
        this.list = new ArrayList<>();
    }

    public void fillRecords(int noOfCustomers) {
        IntStream
                .rangeClosed(0, noOfCustomers)
                .mapToObj(i -> new Customer(
                        (int) (Math.random() * 1000),
                        FAKER.name().firstName(),
                        FAKER.commerce().department()
                ))
                .forEach(list::add);

    }

    public void addCustomer(Customer customer) {
        list.add(customer);
    }

    public List<Customer> getCustomers() {
        return this.list;
    }

    public List<ReadOnlyCustomer> getImmutableCustomer() {
        return List.copyOf(this.list);
    }

    public List<Customer> getCopyOf() {
        return new LinkedList<>(this.list);
    }

    public ReadOnlyCustomer find(String name){
        Customer customer = null;

        for(Customer c: list){
            if ( c.getName().equals(name)){
                System.out.println("Found name: " + name);
                customer = c;
            }

        }
        return new Customer(customer);
    }

    @Override
    public String toString() {
        return "customer.CustomerRecords{" +
                "list=" + list +
                '}';
    }
}