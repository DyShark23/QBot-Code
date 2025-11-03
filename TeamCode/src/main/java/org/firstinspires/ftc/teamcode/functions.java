package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class functions extends OpMode {
    public hardware robot = new hardware();
    public TurnTowardAprilTag apt = new TurnTowardAprilTag();
    public sleep sleep = new sleep();
    public Vision vision = new Vision();
    @Override
    public void init() {
        robot.init(this.hardwareMap);
    }
    public void TurnTowardAprilTag() {
        robot.backleft.setPower(apt.aptblPower);
        robot.backright.setPower(apt.aptbrPower);
        robot.frontleft.setPower(apt.aptflPower);
        robot.frontright.setPower(apt.aptfrPower);
        sleep.sleepvoid(5);
        robot.frontleft.setPower(0);
        robot.frontright.setPower(0);
        robot.backleft.setPower(0);
        robot.backright.setPower(0);

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

    @Override
    public void loop() {}
}
