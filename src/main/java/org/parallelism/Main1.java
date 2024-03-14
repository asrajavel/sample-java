package org.parallelism;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

public class Main1 {
    @SneakyThrows
    public static void main(String[] args) {


        Sleeper sleeper = new Sleeper();
        sleeper.setName("sleeper");
        sleeper.start();
        System.out.println();
        Thread.sleep(8000);
        sleeper.interrupt();
        System.out.println();

        Thread.sleep(8000);
        sleeper.start();
    }
}

@Slf4j
class Sleeper extends Thread {

    @Override
    public void run() {
        Integer i = 0;
        System.out.println("started");
        while (true) i++;
//        System.out.println("finished " + i);
    }
}