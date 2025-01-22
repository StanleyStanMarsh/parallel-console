package ru.spbstu.telematics.java;


public class BinarySemaphore {
    private final volatile boolean isLocked;

    public BinarySemaphore() {
        this.isLocked = false;
    }

    public BinarySemaphore(boolean initialState) {
        this.isLocked = initialState;
    }

    public synchronized void acquire() throws InterruptedException {
        while(isLocked) {
            wait();
        }
        this.isLocked = true;
    }

    public void release() {

    }
}
