package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp (name = "Teleopv1")
public class Teleop extends OpMode {
    public hardware robot = new hardware();

    @Override
    public void init(){robot.init(this.hardwareMap);}

    @Override
    public void loop(){
        double yLeft = -gamepad1.left_stick_y;
        double yRight = -gamepad1.right_stick_y;
        double shoot = -gamepad1.left_trigger;
        double feed = -gamepad1.right_trigger;

        robot.backright.setPower(yRight);
        robot.frontright.setPower(yRight);
        robot.frontleft.setPower(yLeft);
        robot.backleft.setPower(yLeft);
        robot.shooter.setPower(shoot);
        robot.shooter2.setPower(shoot);


        telemetry.addData("Left Joystick", yLeft);
        telemetry.addData("Right Joystick", yRight);
        telemetry.addData("shooter power",shoot);
    }
}