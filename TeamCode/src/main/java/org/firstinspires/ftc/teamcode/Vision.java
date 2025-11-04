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
import org.opencv.core.RotatedRect;
import org.opencv.core.Scalar;

import java.util.List;

public class Vision extends LinearOpMode{
    double MotifID;
    double Bearing;
    boolean SeeP;
    boolean SeeG;
    double gcenter;
    double pcenter;
    boolean seered;
    boolean seeblue;
    List<ColorBlobLocatorProcessor.Blob> gblobs;
    List<ColorBlobLocatorProcessor.Blob> pblobs;



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
                        )
                )
                .setContourMode(ColorBlobLocatorProcessor.ContourMode.ALL_FLATTENED_HIERARCHY)
                .build();
        ColorBlobLocatorProcessor purple = new ColorBlobLocatorProcessor.Builder()
                .setTargetColorRange(new ColorRange(
                        ColorSpace.HSV,
                        new Scalar(125,80,80),
                        new Scalar(160,255,255)
                        )
                )
                .setContourMode(ColorBlobLocatorProcessor.ContourMode.ALL_FLATTENED_HIERARCHY)
                .build();
        VisionPortal visionPortal = new VisionPortal.Builder()
                .addProcessors(tagProcessor, green, purple)
                .setCamera(hardwareMap.get(WebcamName.class,"Webcam1"))
                .setCameraResolution(new Size(640,480))
                .enableLiveView(true)
                .build();
        while (!isStopRequested()&& opModeIsActive()){
            if(!tagProcessor.getDetections().isEmpty()){
                AprilTagDetection tag = tagProcessor.getDetections().get(0);
                MotifID = tag.id;
                Bearing = tag.ftcPose.bearing;
            }
            seered= tagProcessor.getDetections().get(0).id == 24;
            seeblue= tagProcessor.getDetections().get(0).id == 20;
            SeeP= purple.getBlobs().size() > 500 && purple.getBlobs().size() < 10000;
            SeeG= green.getBlobs().size() > 500 && green.getBlobs().size() < 10000;
            gblobs = green.getBlobs();
            pblobs = purple.getBlobs();
            ColorBlobLocatorProcessor.Blob greenBlob = gblobs.isEmpty() ? null : gblobs.get(0);
            ColorBlobLocatorProcessor.Blob purpleBlob = pblobs.isEmpty() ? null : pblobs.get(0);
            assert greenBlob != null;
            RotatedRect boxg = greenBlob.getBoxFit();
            gcenter =  boxg.center.x;
            assert purpleBlob != null;
            RotatedRect boxp = purpleBlob.getBoxFit();
            pcenter = boxp.center.x;



            telemetry.addData("Camera State", visionPortal.getCameraState());
            telemetry.update();
        }
    }
}
