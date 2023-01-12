package by.tms.utils;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ThreadUtils {
    public static void startedThreads(List<Thread> threads) {
        threads.forEach(thread -> {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Exception " + e.getMessage());
            }
        });
    }
}