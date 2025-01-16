package ru.spbstu.telematics.java;


public class App 
{
    public static void main( String[] args )
    {
        BinarySemaphore semaphore = new BinarySemaphore();

        UserThread user1 = new UserThread(semaphore);
        Thread user1Thread = new Thread(user1, "user1");
        UserThread user2 = new UserThread(semaphore);
        Thread user2Thread = new Thread(user2, "user2");
        UserThread user3 = new UserThread(semaphore);
        Thread user3Thread = new Thread(user3, "user3");

        SystemThread system = new SystemThread(semaphore);
        Thread systemThread = new Thread(system, "system");

        user1Thread.start();
        user2Thread.start();
        systemThread.start();
        user3Thread.start();
    }
}
