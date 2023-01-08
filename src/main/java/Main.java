import com.github.javafaker.Faker;
import customers.CustomerUtil;
import util.Util;


import customers.CustomerRecords;

import java.util.Scanner;

public class Main {

    private static final Faker FAKER = Util.getFAKER();
    public static void main(String[] args) {
        System.out.println("From main");
        CustomerUtil customerUtil = new CustomerUtil();


        while (true){
            System.out.println("Please provide value");

            Scanner scanner  = new Scanner(System.in);

            String input = scanner.next();

            if (input.equals("x"))
                break;

            int value = Integer.parseInt(input);

            customerUtil.iterateOverRecords(value);
        }
    }




}
