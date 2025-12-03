package org.firstinspires.ftc.teamcode;

import java.util.ArrayList;
import java.util.List;

public class decoder {
    public List<String> Motif = new ArrayList<>();
    public boolean seered;
    public boolean seeblue;

    private Vision vision;

    public void init(Vision visionInstance) {
        vision = visionInstance;
    }

    public void update() {
        vision.update();

        // Only fill motif when a valid tag is seen
        if (vision.motifID == 21) {
            Motif = List.of("G", "P", "P");
        } else if (vision.motifID == 22) {
            Motif = List.of("P", "G", "P");
        } else if (vision.motifID == 23) {
            Motif = List.of("P", "P", "G");
        }

        // other tag flags
        seeblue = vision.motifID == 20;
        seered = vision.motifID == 24;
    }
}
