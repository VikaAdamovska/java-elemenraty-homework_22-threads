package org.hillel.homework;

public class SecondThread extends Thread {

    public SecondThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(String.format("\r\nNew thread started!\r\nIt name is %s", this.getName()));
        for (int i = 1; i < 6; i++) {
            System.out.println(String.format("%s is working... : %d", this.getName(), i));
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Thread has been interrupted");
            }
        }
        System.out.println(String.format("New thread %s finished!", this.getName()));
    }
}
