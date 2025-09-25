package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp (name = "TeleopALl")
public class Teleop extends OpMode {
    public hardware robot = new hardware();

    @Override
    public void init(){robot.init(this.hardwareMap);}

    @Override
    public void loop(){
        double fwd = gamepad1.right_stick_y;
        double str = gamepad1.right_stick_x;
        double rot = gamepad1.left_stick_x;
        double FL = fwd+str+rot;
        double FR = fwd-str-rot;
        double RL = fwd-str+rot;
        double RR = fwd+str-rot;
        double shoot = -gamepad1.left_trigger;

        robot.backright.setPower(RR);
        robot.frontright.setPower(FR);
        robot.frontleft.setPower(FL);
        robot.backleft.setPower(RL);
        robot.shooter.setPower(shoot);
        robot.shooter2.setPower(shoot);

        telemetry.addData("RR",RR);
        telemetry.addData("FR", FR);
        telemetry.addData("FL", FL);
        telemetry.addData("RL", RL);
    }
}