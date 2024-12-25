package ru.spbstu.telematics.java;
import java.util.concurrent.Semaphore;


public class BinarySemaphore {
    private final Semaphore semaphore = new Semaphore(1);

    public void acquire() throws InterruptedException {
        semaphore.acquire();
    }

    public void release() {
        semaphore.release();
    }
}
