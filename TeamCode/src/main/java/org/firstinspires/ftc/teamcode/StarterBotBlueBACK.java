package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class StarterBotBlueBACK extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        StarterBothardware robot = new StarterBothardware();
        robot.init(this.hardwareMap);
        while (opModeIsActive()&& !isStopRequested()){
            robot.frontright.setPower();
        }
    }
}
