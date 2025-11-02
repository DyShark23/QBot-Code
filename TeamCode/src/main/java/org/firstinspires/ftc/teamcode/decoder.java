package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
public class decoder extends OpMode {
    @Override
    public void init() {}


    public String Motif;
    public boolean seered;
    public boolean seeblue;
    public void loop(){
        Vision vision = new Vision();
        if (vision.MotifID==21){
            Motif = "GPP";
        }
        if (vision.MotifID==22){
            Motif = "PGP";
        }
        if (vision.MotifID==23){
            Motif = "PPG";
        }
        seeblue= vision.MotifID == 20;
        seered= vision.MotifID == 24;

    }
}
