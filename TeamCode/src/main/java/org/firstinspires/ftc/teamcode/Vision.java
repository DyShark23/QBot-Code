package org.firstinspires.ftc.teamcode;

import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.opencv.ColorBlobLocatorProcessor;

public class Vision extends LinearOpMode{
    double MotifID;
    double Bearing;

    @Override
    public void runOpMode() throws InterruptedException{

        AprilTagProcessor tagProcessor = new AprilTagProcessor.Builder()
                .setDrawTagID(true)
                .setDrawTagOutline(true)
                .build();
        ColorBlobLocatorProcessor colorBlobLocatorProcessor = new ColorBlobLocatorProcessor.Builder()
                .build();
        VisionPortal visionPortal = new VisionPortal.Builder()
                .addProcessors(tagProcessor, colorBlobLocatorProcessor)
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
            telemetry.addData("Camera State", visionPortal.getCameraState());
            telemetry.update();
        }
    }
}
