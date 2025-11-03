package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.util.Objects;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "red")
public class red extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        decoder decoder = new decoder();
        functions functions = new functions();
        Vision vision = new Vision();
        hardware robot = new hardware();
        sleep s = new sleep();
        if (decoder.Motif.isEmpty()) {
            robot.frontright.setPower(2);
            robot.frontleft.setPower(2);
            robot.backright.setPower(2);
            robot.backleft.setPower(2);
            s.sleepvoid(3);
            robot.frontright.setPower(0);
            robot.frontleft.setPower(0);
            robot.backright.setPower(0);
            robot.backleft.setPower(0);
        }
        if (decoder.Motif.isEmpty()) {
            s.sleepvoid(3);
            robot.frontright.setPower(-2);
            robot.frontleft.setPower(2);
            robot.backright.setPower(2);
            robot.backleft.setPower(-2);
            s.sleepvoid(1);
            functions.spinDoubleDegrees(180);

        }
        String Index1 = decoder.Motif.get(0);
        String Index2 = decoder.Motif.get(1);
        String Index3 = decoder.Motif.get(2);
        while (!isStopRequested() && opModeIsActive()) {
            if (Objects.equals(Index1, "P")) {
                if (!vision.SeeP) {
                    functions.spinDoubleDegrees(180);
                }
                if (!vision.SeeP) {
                    functions.spinDoubleDegrees(90);
                }
                if (!vision.SeeP) {
                    functions.spinDoubleDegrees(180);
                }
                functions.PickUpPurpleBall();
            } else {
                if (!vision.SeeG) {
                    functions.spinDoubleDegrees(180);
                }
                if (!vision.SeeG) {
                    functions.spinDoubleDegrees(90);
                }
                if (!vision.SeeG) {
                    functions.spinDoubleDegrees(180);
                }
                functions.PickUpGreenBall();
            }
            if (Objects.equals(Index2, "P")) {
                if (!vision.SeeP) {
                    functions.spinDoubleDegrees(180);
                }
                if (!vision.SeeP) {
                    functions.spinDoubleDegrees(90);
                }
                if (!vision.SeeP) {
                    functions.spinDoubleDegrees(180);
                }
                functions.PickUpPurpleBall();
            } else {
                if (!vision.SeeG) {
                    functions.spinDoubleDegrees(180);
                }
                if (!vision.SeeG) {
                    functions.spinDoubleDegrees(90);
                }
                if (!vision.SeeG) {
                    functions.spinDoubleDegrees(180);
                }
                functions.PickUpGreenBall();
            }
            if (Objects.equals(Index3, "P")) {
                if (!vision.SeeP) {
                    functions.spinDoubleDegrees(180);
                }
                if (!vision.SeeP) {
                    functions.spinDoubleDegrees(90);
                }
                if (!vision.SeeP) {
                    functions.spinDoubleDegrees(180);
                }
                functions.PickUpPurpleBall();
            } else {
                if (!vision.SeeG) {
                    functions.spinDoubleDegrees(180);
                }
                if (!vision.SeeG) {
                    functions.spinDoubleDegrees(90);
                }
                if (!vision.SeeG) {
                    functions.spinDoubleDegrees(180);
                }
                functions.PickUpGreenBall();


            }
            functions.TurnTowardRedAprilTag();
            robot.shooter.setPower(2);
            robot.shooter2.setPower(-2);
            s.sleepvoid(5);

        }
    }
}
