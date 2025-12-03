package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import java.util.Objects;

@Autonomous(name = "red")
public class red extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        decoder decoder = new decoder();
        functions functions = new functions();
        Vision vision = new Vision();
        hardware robot = new hardware();
        sleep s = new sleep();

        functions.init(hardwareMap, vision);
        vision.init(hardwareMap);
        decoder.init(vision);
        robot.init(hardwareMap);

        // initialize motors to 0 power at init
        robot.frontright.setPower(0);
        robot.frontleft.setPower(0);
        robot.backright.setPower(0);
        robot.backleft.setPower(0);

        waitForStart();

        // spin until motif has 3 entries
        while (decoder.Motif.isEmpty()){
            functions.spinDoubleDegrees(10);
            decoder.update();
        }

        // stop spinning
        robot.frontright.setPower(0);
        robot.backright.setPower(0);
        robot.frontleft.setPower(0);
        robot.backleft.setPower(0);

        // now safe to use motif
        if (decoder.Motif.size() >= 3) {
            String Index1 = decoder.Motif.get(0);
            String Index2 = decoder.Motif.get(1);
            String Index3 = decoder.Motif.get(2);

            while (!isStopRequested() && opModeIsActive()) {
                if (Objects.equals(Index1, "P")) {
                    if (!vision.seePurple) {
                        functions.spinDoubleDegrees(90);
                    }
                } else {
                    if (!vision.seeGreen) {
                        functions.spinDoubleDegrees(90);
                    }
                }

                if (Objects.equals(Index2, "P")) {
                    if (!vision.seePurple) {
                        functions.spinDoubleDegrees(90);
                    }
                } else {
                    if (!vision.seeGreen) {
                        functions.spinDoubleDegrees(90);
                    }
                }

                if (Objects.equals(Index3, "P")) {
                    if (!vision.seePurple) {
                        functions.spinDoubleDegrees(90);
                    }
                } else {
                    if (!vision.seeGreen) {
                        functions.spinDoubleDegrees(90);
                    }
                }

                functions.TurnTowardRedAprilTag();
                functions.spinDoubleDegrees(180);

                telemetry.addData("Sho1", functions.rpmFromDistance(vision.x, vision.y, vision.z));
                telemetry.addData("sho2", -functions.rpmFromDistance(vision.x, vision.y, vision.z));
                telemetry.update();

                s.sleepvoid(5);
            }
        }
    }
}
