package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.util.Objects;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "auto26")
public class Autonomous extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        decoder decoder = new decoder();
        functions functions = new functions();
        Vision vision = new Vision();
        hardware robot = new hardware();
        if (decoder.Motif.isEmpty()){
            robot.frontright.setPower(2);
            robot.frontleft.setPower(2);
            robot.backright.setPower(2);
            robot.backleft.setPower(2);
        }
        String Index1 = decoder.Motif.get(0);
        String Index2 = decoder.Motif.get(1);
        String Index3 = decoder.Motif.get(2);

        }


}
