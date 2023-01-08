package string_practise;

public class Main {
    public static void main(String[] args) {
        String one  = "hel" + "lo";
        String two = "hello";

        String three = "hellohello";
        String four = one + two;

        //could place the string into pool explicitly
        four.intern();

        System.out.println(one.equals(two));
        System.out.println(one == two);

        System.out.println(three == four);
    }
}
