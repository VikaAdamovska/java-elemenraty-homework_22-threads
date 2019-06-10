package org.hillel.homework;

import javafx.scene.chart.PieChart;

import java.util.Date;

public class ThirdThread implements Runnable {

    public void run() {
        System.out.println(String.format("\r\nNew thread name is : %s started!", Thread.currentThread().getName()));
        for (int i = 6; i < 11; i++) {
            System.out.println(String.format("%s is working... : %d and time - %d", Thread.currentThread().getName(), i, new Date().getTime()));
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Thread has been interrupted");
            }
        }
        System.out.println(String.format("New thread %s finished!", Thread.currentThread().getName()));
    }
}
