package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class functions extends OpMode {
    public hardware robot = new hardware();
    public TurnTowardAprilTag apt = new TurnTowardAprilTag();
    public sleep sleep = new sleep();
    public Vision vision = new Vision();

    @Override
    public void init() {
        robot.init(this.hardwareMap);
    }

    public void TurnTowardRedAprilTag() {
        while (!vision.seeRedTag) {
            robot.backleft.setPower(0.3);
            robot.backright.setPower(-0.3);
            robot.frontleft.setPower(0.3);
            robot.frontright.setPower(-0.3);
            sleep.sleepvoid(5);
        }

        robot.backleft.setPower(apt.aptblPower);
        robot.backright.setPower(apt.aptbrPower);
        robot.frontleft.setPower(apt.aptflPower);
        robot.frontright.setPower(apt.aptfrPower);

        robot.backleft.setPower(0);
        robot.backright.setPower(0);
        robot.frontleft.setPower(0);
        robot.frontright.setPower(0);
    }

    public void TurnTowardBlueAprilTag() {
        while (!vision.seeBlueTag) {
            robot.backleft.setPower(0.3);
            robot.backright.setPower(-0.3);
            robot.frontleft.setPower(0.3);
            robot.frontright.setPower(-0.3);
            sleep.sleepvoid(5);
        }

        robot.backleft.setPower(apt.aptblPower);
        robot.backright.setPower(apt.aptbrPower);
        robot.frontleft.setPower(apt.aptflPower);
        robot.frontright.setPower(apt.aptfrPower);

        robot.backleft.setPower(0);
        robot.backright.setPower(0);
        robot.frontleft.setPower(0);
        robot.frontright.setPower(0);
    }

    public void PickUpGreenBall() {
        double error = vision.greenCenter - 320.0;
        double strafe = Math.max(-0.3, Math.min(0.3, error / 320.0));
        double forward = 0.5;

        robot.frontleft.setPower(forward + strafe);
        robot.frontright.setPower(forward - strafe);
        robot.backleft.setPower(forward - strafe);
        robot.backright.setPower(forward + strafe);

        if (!vision.seeGreen) {
            sleep.sleepvoid(2);
            robot.frontleft.setPower(0);
            robot.frontright.setPower(0);
            robot.backleft.setPower(0);
            robot.backright.setPower(0);
            robot.intake.setPower(2);
            robot.intake2.setPower(2);
            sleep.sleepvoid(5);
            robot.intake.setPower(0);
            robot.intake2.setPower(0);
        }
    }

    public void PickUpPurpleBall() {
        double error = vision.purpleCenter - 320.0;
        double strafe = Math.max(-0.3, Math.min(0.3, error / 320.0));
        double forward = 0.4;

        robot.frontleft.setPower(forward + strafe);
        robot.frontright.setPower(forward - strafe);
        robot.backleft.setPower(forward - strafe);
        robot.backright.setPower(forward + strafe);

        if (!vision.seePurple) {
            robot.frontleft.setPower(0);
            robot.frontright.setPower(0);
            robot.backleft.setPower(0);
            robot.backright.setPower(0);
            robot.intake.setPower(2);
            robot.intake2.setPower(2);
            sleep.sleepvoid(5);
            robot.intake.setPower(0);
            robot.intake2.setPower(0);
        }
    }

    public void spinDoubleDegrees(double degrees) {
        double ticksPerDegree = 537.6;
        int targetTicks = (int)(degrees * 2 * ticksPerDegree);

        robot.frontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.frontleft.setTargetPosition(-targetTicks);
        robot.backleft.setTargetPosition(-targetTicks);
        robot.frontright.setTargetPosition(targetTicks);
        robot.backright.setTargetPosition(targetTicks);

        robot.frontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backright.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.frontleft.setPower(0.5);
        robot.frontright.setPower(0.5);
        robot.backleft.setPower(0.5);
        robot.backright.setPower(0.5);

        while (robot.frontleft.isBusy() && robot.frontright.isBusy() &&
                robot.backleft.isBusy() && robot.backright.isBusy()) {
            // Optional: telemetry.addData("Spinning", "In progress");
            // telemetry.update();
        }

        robot.frontleft.setPower(0);
        robot.frontright.setPower(0);
        robot.backleft.setPower(0);
        robot.backright.setPower(0);
    }

    @Override
    public void loop() {}
}
