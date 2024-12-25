package ru.spbstu.telematics.java;

public class UserThread implements Runnable {
    private final BinarySemaphore semaphore;

    public UserThread(BinarySemaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
    }
}