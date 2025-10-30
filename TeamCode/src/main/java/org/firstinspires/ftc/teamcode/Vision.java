package org.firstinspires.ftc.teamcode;

import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.opencv.ColorBlobLocatorProcessor;
import org.firstinspires.ftc.vision.opencv.ColorRange;
import org.firstinspires.ftc.vision.opencv.ColorSpace;
import org.opencv.core.Scalar;

public class Vision extends LinearOpMode{
    double MotifID;
    double Bearing;
    boolean SeeP;
    boolean SeeG;


    @Override
    public void runOpMode() throws InterruptedException{

        AprilTagProcessor tagProcessor = new AprilTagProcessor.Builder()
                .setDrawTagID(true)
                .setDrawTagOutline(true)
                .build();
        ColorBlobLocatorProcessor green = new ColorBlobLocatorProcessor.Builder()
                .setTargetColorRange(new ColorRange(
                        ColorSpace.HSV,
                        new Scalar(35,100,100),
                        new Scalar(85,255,255)
                ))
                .build();
        ColorBlobLocatorProcessor purple = new ColorBlobLocatorProcessor.Builder()
                .setTargetColorRange(new ColorRange(
                        ColorSpace.HSV,
                        new Scalar(125,80,80),
                        new Scalar(160,255,255)
                        )
                )
                .build();
        VisionPortal visionPortal = new VisionPortal.Builder()
                .addProcessors(tagProcessor, green, purple)
                .setCamera(hardwareMap.get(WebcamName.class,"Webcam1"))
                .setCameraResolution(new Size(640,480))
                .enableLiveView(true)
                .build();
        while (!isStopRequested()&& opModeIsActive()){
            if(tagProcessor.getDetections().size() > 0){
                AprilTagDetection tag = tagProcessor.getDetections().get(0);
                MotifID = tag.id;
                Bearing = tag.ftcPose.bearing;
            }
            if(purple.getBlobs().size()>500 && purple.getBlobs().size()<10000){
                SeeP=true;
            }
            else {
                SeeP=false;
            }
            if(green.getBlobs().size()>500 && green.getBlobs().size()<10000){
                SeeG=true;
            }
            else {
                SeeG=false;
            }
            telemetry.addData("Camera State", visionPortal.getCameraState());
            telemetry.update();
        }
    }
}
