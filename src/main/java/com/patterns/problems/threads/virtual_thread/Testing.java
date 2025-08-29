package com.patterns.problems.threads.virtual_thread;

import java.util.ArrayList;
import java.util.List;

public class Testing {
    public static  final int NUMBER_OF_VIRTUAL_THREADS = 1000;
    public static void main(String[] arg) throws InterruptedException {
//        notifyAll();
        Runnable runnable = () -> System.out.println("inside thread: "+ Thread.currentThread());
        List<Thread> virtualThreads = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_VIRTUAL_THREADS; i++) {
            Thread virtualThread = Thread.ofVirtual().unstarted(runnable);
            virtualThreads.add(virtualThread);
        }
        for (Thread virtualThread: virtualThreads){
            virtualThread.start();
        }
        for (Thread virtualThread: virtualThreads){
            virtualThread.join();
        }
    }
}
