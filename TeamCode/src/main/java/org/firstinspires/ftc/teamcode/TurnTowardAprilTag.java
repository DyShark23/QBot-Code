package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Vision;

public class TurnTowardAprilTag {
    public hardware robot = new hardware();

    // Public static variables to hold wheel powers
    public static double aptflPower;
    public static double aptfrPower;
    public static double aptblPower;
    public static double aptbrPower;

    // Updates wheel powers based on bearing angle
    public static void updatePowersFromBearing(double bearingDegrees) {
        double bearingRadians = Math.toRadians(bearingDegrees);
        double x = Math.sin(bearingRadians); // strafe
        double y = Math.cos(bearingRadians); // forward

        double fl = y + x;
        double fr = y - x;
        double bl = y - x;
        double br = y + x;

        double max = Math.max(Math.abs(fl), Math.max(Math.abs(fr),
                Math.max(Math.abs(bl), Math.abs(br))));
        if (max > 1.0) {
            fl /= max;
            fr /= max;
            bl /= max;
            br /= max;
        }

        aptflPower = fl;
        aptfrPower = fr;
        aptblPower = bl;
        aptbrPower = br;
    }

    // Call this to turn toward a specific AprilTag ID
    public static void TurnToward(int apriltagID) {
        Vision vision = new Vision();

        // Check if bearing is valid (assuming -999 means "no tag detected")
        if (vision.bearing != -999) {
            updatePowersFromBearing(vision.bearing);
        } else {
            // Stop movement if no valid bearing
            aptflPower = 0;
            aptfrPower = 0;
            aptblPower = 0;
            aptbrPower = 0;
        }
    }
}
