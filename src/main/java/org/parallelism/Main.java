package org.parallelism;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<?> submit1 = executorService.submit(new ParameterizedTask(1));
        Future<?> submit2 = executorService.submit(new ParameterizedTaskNew(2));

        submit1.get();
        submit2.get();
    }
}

class ParameterizedTask implements Runnable {
    private final int taskNumber;

    public ParameterizedTask(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Task " + taskNumber + ": " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class ParameterizedTaskNew implements Runnable {
    private final int taskNumber;

    public ParameterizedTaskNew(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        throw new RuntimeException("qwert");
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Task " + taskNumber + ": " + i);
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }
}