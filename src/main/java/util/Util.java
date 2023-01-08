package util;

import com.github.javafaker.Faker;

public class Util {
    private static final Faker FAKER = Faker.instance();

    public static Faker getFAKER() {
        return FAKER;
    }
}
