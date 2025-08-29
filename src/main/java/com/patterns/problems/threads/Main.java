package com.patterns.problems.threads;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(() -> {
//            System.out.println("We are in thread: "+Thread.currentThread().getName());
//        });
//        thread.setName("test");
//        thread.setPriority(Thread.MAX_PRIORITY);
//
//        System.out.println("We are in thread: "+Thread.currentThread().getName() + " before");
//        thread.start();
//        System.out.println("We are in thread: "+Thread.currentThread().getName() + " after");
//
//        Thread.sleep(10000);

        Thread thread = new NewThread();
        thread.start();
    }

    private static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("We are in thread: " + this.getName());
        }
    }
}
