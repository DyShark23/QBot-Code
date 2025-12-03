package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class StarterbotTeleop extends OpMode {
    public StarterBotHardware robot = new StarterBotHardware();
    @Override
    public void init() {robot.init(this.hardwareMap);}

    @Override
    public void loop() {

    }
}
