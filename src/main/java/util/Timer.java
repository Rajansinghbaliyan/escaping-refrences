package util;

import java.util.Date;

public class Timer {
    private final Date start = new Date();
    private Date end;

    public Timer() {
        System.out.println("Timer started");
    }

    public void printTimeDifference(){
        end  = new Date();
        System.out.println("Time taken: " + (end.getTime() - start.getTime()));
    }
}
