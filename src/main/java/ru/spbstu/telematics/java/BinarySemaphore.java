package ru.spbstu.telematics.java;


public class BinarySemaphore {
    private final volatile boolean isLocked;

    public BinarySemaphore() {
        this.isLocked = false;
    }

    public BinarySemaphore(boolean initialState) {
        this.isLocked = initialState;
    }

    public void acquire() throws InterruptedException {
        
    }

    public void release() {

    }
}
