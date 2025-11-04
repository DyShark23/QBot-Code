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
        // Step 1: Turn using initial search powers until the AprilTag is seen
        while (!vision.seered) {
            // Example search powers — adjust as needed for your robot's turning behavior
            robot.backleft.setPower(0.3);
            robot.backright.setPower(-0.3);
            robot.frontleft.setPower(0.3);
            robot.frontright.setPower(-0.3);

            sleep.sleepvoid(5); // Optional: short delay for responsiveness
        }

        // Step 2: Apply final alignment powers from apt
        robot.backleft.setPower(apt.aptblPower);
        robot.backright.setPower(apt.aptbrPower);
        robot.frontleft.setPower(apt.aptflPower);
        robot.frontright.setPower(apt.aptfrPower);
        // Optional: hold position briefly

        // Step 3: Stop all motors
        robot.backleft.setPower(0);
        robot.backright.setPower(0);
        robot.frontleft.setPower(0);
        robot.frontright.setPower(0);
    }
    public void TurnTowardBlueAprilTag() {
        // Step 1: Turn using initial search powers until the AprilTag is seen
        while (!vision.seeblue) {
            // Example search powers — adjust as needed for your robot's turning behavior
            robot.backleft.setPower(0.3);
            robot.backright.setPower(-0.3);
            robot.frontleft.setPower(0.3);
            robot.frontright.setPower(-0.3);

            sleep.sleepvoid(5); // Optional: short delay for responsiveness
        }

        // Step 2: Apply final alignment powers from apt
        robot.backleft.setPower(apt.aptblPower);
        robot.backright.setPower(apt.aptbrPower);
        robot.frontleft.setPower(apt.aptflPower);
        robot.frontright.setPower(apt.aptfrPower);
        // Optional: hold position briefly

        // Step 3: Stop all motors
        robot.backleft.setPower(0);
        robot.backright.setPower(0);
        robot.frontleft.setPower(0);
        robot.frontright.setPower(0);
    }

    public void PickUpGreenBall() {
        double error = vision.gcenter - 320.0;
        double strafe = Math.max(-0.3, Math.min(0.3, error / 320.0));
        double forward = 0.4;

        robot.frontleft.setPower(forward + strafe);
        robot.frontright.setPower(forward - strafe);
        robot.backleft.setPower(forward - strafe);
        robot.backright.setPower(forward + strafe);
        if (vision.gblobs.isEmpty()) {
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

    public void PickUpPurpleBall(){
        double error = vision.pcenter - 320.0;
        double strafe = Math.max(-0.3, Math.min(0.3, error / 320.0));
        double forward = 0.4;

        robot.frontleft.setPower(forward + strafe);
        robot.frontright.setPower(forward - strafe);
        robot.backleft.setPower(forward - strafe);
        robot.backright.setPower(forward + strafe);
        if (vision.pblobs.isEmpty()) {
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

        // Reset encoders
        robot.frontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Set target positions for in-place rotation
        robot.frontleft.setTargetPosition(-targetTicks);
        robot.backleft.setTargetPosition(-targetTicks);
        robot.frontright.setTargetPosition(targetTicks);
        robot.backright.setTargetPosition(targetTicks);

        // Set to run to position
        robot.frontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.frontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.backright.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Apply power
        robot.frontleft.setPower(0.5);
        robot.frontright.setPower(0.5);
        robot.backleft.setPower(0.5);
        robot.backright.setPower(0.5);

        // Wait until all motors finish
        while (robot.frontleft.isBusy() && robot.frontright.isBusy() &&
                robot.backleft.isBusy() && robot.backright.isBusy()) {
            // Optional: telemetry.addData("Spinning", "In progress");
            // telemetry.update();
        }

        // Stop all motors
        robot.frontleft.setPower(0);
        robot.frontright.setPower(0);
        robot.backleft.setPower(0);
        robot.backright.setPower(0);
    }



    @Override
    public void loop() {}
}
