package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class functions extends OpMode {
    public hardware robot = new hardware();
    public TurnTowardAprilTag apt = new TurnTowardAprilTag();
    @Override
    public void init() {
        robot.init(this.hardwareMap);
    }
    public void TurnTowardAprilTag() {
        robot.backleft.setPower(apt.aptblPower);
        robot.backright.setPower(apt.aptbrPower);
        robot.frontleft.setPower(apt.aptflPower);
        robot.frontright.setPower(apt.aptfrPower);

    }
    public void PickUpGreenBall(){
        //placeholder
    }
    public void PickUpPurpleBall(){
        //placeholder
    }

    @Override
    public void loop() {}
}
