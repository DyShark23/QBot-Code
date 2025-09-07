package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class hardware {
    public DcMotor frontleft; //Tell Java that there is a DcMotor In the front left
    public DcMotor backleft; //Tell Java that there is a DcMotor In the back left
    public DcMotor frontright; //Tell Java that there is a DcMotor In the front right
    public DcMotor backright; //Tell Java that there is a DcMotor In the back right.
    public void init(HardwareMap hardwareMap){
        frontleft = hardwareMap.get(DcMotor.class,"frontLeft");
        frontleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frontright = hardwareMap.get(DcMotor.class,"frontRight");
        frontright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontright.setPower(0);

        backleft = hardwareMap.get(DcMotor.class,"backLeft");
        backleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backleft.setPower(0);

        backright = hardwareMap.get(DcMotor.class,"backRight");
        backright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backright.setPower(0);
    }
}
