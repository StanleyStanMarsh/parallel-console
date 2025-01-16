package ru.spbstu.telematics.java;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppTest {
    private BinarySemaphore semaphore;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @Before
    public void setUp() {
        semaphore = new BinarySemaphore();
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testSingleUserAccess() throws InterruptedException {
        UserThread userThread = new UserThread(semaphore);
        Thread thread = new Thread(userThread);
        thread.start();
        thread.join();

        String output = outputStream.toString();
        assertTrue("Пользователь должен начать работу с консолью", 
            output.contains("начал взаимодействие с консолью"));
        assertTrue("Пользователь должен закончить работу с консолью", 
            output.contains("закончил взаимодействие с консолью"));
    }

    @Test
    public void testSystemAccess() throws InterruptedException {
        SystemThread systemThread = new SystemThread(semaphore);
        Thread thread = new Thread(systemThread);
        thread.start();
        thread.join();

        String output = outputStream.toString();
        assertTrue("Системный процесс должен начать работу с консолью", 
            output.contains("Системный процесс"));
        assertTrue("Системный процесс должен закончить работу", 
            output.contains("закончил взаимодействие с консолью"));
    }

    @Test
    public void testMultipleUsers() throws InterruptedException {
        Thread[] threads = new Thread[3];
        
        for (int i = 0; i < 3; i++) {
            UserThread userThread = new UserThread(semaphore);
            threads[i] = new Thread(userThread, "user" + (i + 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        String output = outputStream.toString();
        // Проверяем, что все пользователи получили доступ к консоли
        for (int i = 1; i <= 3; i++) {
            assertTrue("Пользователь " + i + " должен получить доступ к консоли",
                output.contains("user" + i));
        }
    }

    @Test
    public void testSystemAndUserInteraction() throws InterruptedException {
        SystemThread systemThread = new SystemThread(semaphore);
        UserThread userThread = new UserThread(semaphore);
        
        Thread sysThread = new Thread(systemThread, "system");
        Thread usrThread = new Thread(userThread, "user");
        
        sysThread.start();
        usrThread.start();
        
        sysThread.join();
        usrThread.join();

        String output = outputStream.toString();
        assertTrue("Должно быть взаимодействие системного процесса", 
            output.contains("Системный процесс"));
        assertTrue("Должно быть взаимодействие пользователя", 
            output.contains("Пользователь"));
    }
}