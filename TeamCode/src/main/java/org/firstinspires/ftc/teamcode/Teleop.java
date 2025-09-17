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
        double xLeft = -gamepad1.left_stick_x;
        double xRight = -gamepad1.right_stick_x;
        double shoot = -gamepad1.left_trigger;
        double feed = -gamepad1.right_trigger;

        if (yRight+yLeft>xRight+xLeft){
            robot.backright.setPower(yRight);
            robot.frontright.setPower(yRight);
            robot.frontleft.setPower(yLeft);
            robot.backleft.setPower(yLeft);
        }
        if (xRight+xLeft>yLeft+yRight){
            robot.backright.setPower(xRight);
            robot.frontright.setPower(xRight);
            robot.frontleft.setPower(xLeft);
            robot.backleft.setPower(xLeft);
        }
        robot.shooter.setPower(shoot);
        robot.shooter2.setPower(shoot);


        telemetry.addData("Left Joystick Y", yLeft, "Left Joystick X", xLeft);
        telemetry.addData("Right Joystick Y", yRight,"Right Joystick X" xRight);
        telemetry.addData("shooter power",shoot);
        telemetry.addData("TurnMode",)
    }
}