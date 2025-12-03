package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class StarterBotHardware {
    public CRServo l;
    public CRServo r;
    public DcMotor launch;
    public DcMotor dl;
    public DcMotor dr;
    public void init(HardwareMap hardwareMap) {
        l = hardwareMap.get(CRServo.class, "l");
        l.setDirection(DcMotorSimple.Direction.REVERSE);
        l.setPower(0);

        r = hardwareMap.get(CRServo.class, "r");
        r.setPower(0);

        dl = hardwareMap.get(DcMotor.class, "dl");
        dl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        dl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        dl.setDirection(DcMotorSimple.Direction.REVERSE);
        dl.setPower(0);

        dr = hardwareMap.get(DcMotor.class, "dr");
        dr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        dr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        dr.setPower(0);
        launch = hardwareMap.get(DcMotor.class, "frontLeft");
        launch.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        launch.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        launch.setDirection(DcMotorSimple.Direction.REVERSE);
        launch.setPower(0);


    }
}
