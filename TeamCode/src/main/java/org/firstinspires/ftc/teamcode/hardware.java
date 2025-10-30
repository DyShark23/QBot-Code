package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class hardware {
    public DcMotor frontleft; //Tell Java that there is a DcMotor In the front left. This is a wheel
    public DcMotor backleft; //Tell Java that there is a DcMotor In the back left. This is a wheel
    public DcMotor frontright; //Tell Java that there is a DcMotor In the front right. This is a wheel
    public DcMotor backright; //Tell Java that there is a DcMotor In the back right. This is a wheel
    public DcMotor shooter;//Tell Java that there is a new motor called shooter. This will shoot the ball out.
    public DcMotor shooter2;//Tell Java that there is a new motor called shooter2. This will shoot the ball out.
    public DcMotor intake;//def intake
    public DcMotor intake2; //def intake 2

    public void init(HardwareMap hardwareMap) {
        frontleft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontleft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontleft.setPower(0);

        frontright = hardwareMap.get(DcMotor.class, "frontRight");
        frontright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontright.setPower(0);

        backleft = hardwareMap.get(DcMotor.class, "backLeft");
        backleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);backleft.setPower(0);

        backright = hardwareMap.get(DcMotor.class, "backRight");
        backright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backright.setPower(0);

        shooter = hardwareMap.get(DcMotor.class, "shooter");
        shooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shooter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        shooter.setPower(0);

        shooter2 = hardwareMap.get(DcMotor.class, "shooter2");
        shooter2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shooter2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        shooter2.setPower(0);

        intake = hardwareMap.get(DcMotor.class,"intake");
        intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intake.setPower(0);

        intake2 = hardwareMap.get(DcMotor.class,"intake2");
        intake2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intake2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intake2.setPower(0);

    }
}

