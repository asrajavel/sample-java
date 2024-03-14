package org.parallelismm2;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();

        new Thread(new Producer(printQueue), "Producer1").start();
        new Thread(new Producer(printQueue), "Producer2").start();

        new Thread(new Consumer(printQueue), "Consumer1").start();
        new Thread(new Consumer(printQueue), "Consumer2").start();
        new Thread(new Consumer(printQueue), "Consumer3").start();

        System.out.println();

    }
}

class Producer implements Runnable {
    private final PrintQueue printQueue;

    public Producer(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @SneakyThrows
    public void run() {
        for (int i = 0; i < 2; i++) {
            Thread.sleep(1000);
            System.out.printf(Thread.currentThread().getName() + " job %d\n", i);
            printQueue.add(Thread.currentThread().getName() + " " + i);
        }
    }
}

class Consumer implements Runnable {
    private final PrintQueue printQueue;

    public Consumer(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @SneakyThrows
    public void run() {
        for (;;) {
            System.out.printf(Thread.currentThread().getName() + " job: %s\n", printQueue.remove());
        }
    }
}

class PrintQueue {
    private final Queue<String> queue =
            new PriorityQueue<>();

    public synchronized void add(String j) {
        queue.add(j);
        notifyAll(); // Tell waiters: print job added
    }

    public synchronized String remove()
            throws InterruptedException {
        System.out.println("HII - " + Thread.currentThread().getName());
        //this example shows why you need while instead of if condition
        // if we want to use if, then we need to use notify instead of notifyAll I think
        while (queue.size() == 0) {
            System.out.println("STUCK - " + Thread.currentThread().getName());
            wait(); // Wait for a print job
        }
        System.out.println("BYE - " + Thread.currentThread().getName());
        return queue.remove();
    }
}