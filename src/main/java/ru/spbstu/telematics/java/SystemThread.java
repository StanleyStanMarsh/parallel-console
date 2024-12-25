package ru.spbstu.telematics.java;

public class SystemThread extends Thread {
    private final BinarySemaphore semaphore;

    public SystemProcessThread(BinarySemaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
    }
}