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
        double aPower = 0;

        if (gamepad1.a=true){
            double aPower = 2;
        }
        if (gamepad1.a=false){
            aPower = 0;
        }

        if (gamepad1.b=true){
            bPower = 1;
        }
        if (gamepad1.b=false){
            bPower = 0;
        }

        robot.backright.setPower(yRight);
        robot.frontright.setPower(yRight);
        robot.frontleft.setPower(yLeft);
        robot.backleft.setPower(yLeft);
        robot.shooter.setPower(aPower);

        telemetry.addData("Left Joystick", yLeft);
        telemetry.addData("Right Joystick", yRight);
        telemetry.addData("shooter power",aPower );
    }
}