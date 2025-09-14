package org.firstinspires.ftc.teamcode;

import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

public class Vision extends LinearOpMode {
    public double MotifID;
    @Override
    public void runOpMode() throws InterruptedException{
        AprilTagProcessor tagProcessor = new AprilTagProcessor.Builder()
                .setDrawTagOutline(true)
                .build();
        VisionPortal visionPortal = new VisionPortal.Builder()
                .addProcessor(tagProcessor)
                .setCamera(hardwareMap.get(WebcamName.class,"WebCam1"))
                .setCameraResolution(new Size(640,480))
                .build();


        while (!isStopRequested()&& opModeIsActive()){
           if(tagProcessor.getDetections().size() > 0){
               AprilTagDetection tag = tagProcessor.getDetections().get(0);
               MotifID = tag.id;
           }
    }
}

}
