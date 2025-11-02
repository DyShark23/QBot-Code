package org.firstinspires.ftc.teamcode;

public class sleep {
    public void sleepvoid(long sec){
        try {
            Thread.sleep(sec*1000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle the exception if the thread is interrupted
        }

    }
}
