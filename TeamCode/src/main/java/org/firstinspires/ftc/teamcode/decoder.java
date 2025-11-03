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
        if (vision.MotifID==21){
            MotifUR = "GPP";
        }
        if (vision.MotifID==22){
            MotifUR = "PGP";
        }
        if (vision.MotifID==23){
            MotifUR = "PPG";
        }
        seeblue= vision.MotifID == 20;
        seered= vision.MotifID == 24;
        String MotifBF = new StringBuilder(MotifUR).reverse().toString();
        Motif = Arrays.asList(MotifBF.split(""));

    }
}
