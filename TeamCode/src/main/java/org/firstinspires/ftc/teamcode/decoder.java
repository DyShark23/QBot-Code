package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.util.Arrays;
import java.util.List;

public class decoder extends OpMode {
    @Override
    public void init() {}
     public List<String> Motif;


    public String MotifUR;
    public boolean seered;
    public boolean seeblue;
    public void loop(){
        Vision vision = new Vision();
        if (vision.motifID==21){
            Motif = "GPP";
        }
        if (vision.motifID==22){
            MotifUR = "PGP";
        }
        if (vision.motifID==23){
            Motif = "PPG";
        }
        seeblue= vision.motifID == 20;
        seered= vision.motifID == 24;

    }
}
