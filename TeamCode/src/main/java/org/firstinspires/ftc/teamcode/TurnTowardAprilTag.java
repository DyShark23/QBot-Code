package org.firstinspires.ftc.teamcode;

public class TurnTowardAprilTag {

    // Public static variables to hold wheel powers\
    public static double aptflPower;
    public static double aptfrPower;
    public static double aptblPower;
    public static double aptbrPower;
    // Call this to update the powers based on bearing
    public static void updatePowersFromBearing(double bearingDegrees) {
        // Convert bearing to radians
        double bearingRadians = Math.toRadians(bearingDegrees);

        // Swap x and y to match compass-style bearings
        double x = Math.sin(bearingRadians); // strafe
        double y = Math.cos(bearingRadians); // forward

        // Mecanum wheel formulas
        double fl = y + x;
        double fr = y - x;
        double bl = y - x;
        double br = y + x;

        // Normalize powers so none exceed 1.0
        double max = Math.max(Math.abs(fl), Math.max(Math.abs(fr),
                Math.max(Math.abs(bl), Math.abs(br))));
        if (max > 1.0) {
            fl /= max;
            fr /= max;
            bl /= max;
            br /= max;
        }

        // Store in public variables
        aptflPower = fl;
        aptfrPower = fr;
        aptblPower = bl;
        aptbrPower = br;
    }
    public void setAPTPowers(){

    }
}