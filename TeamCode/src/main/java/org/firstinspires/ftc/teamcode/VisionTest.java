package org.firstinspires.ftc.teamcode;

import android.util.Size;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
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

@Autonomous(name = "Vision Test Final Fixed")
public class VisionTest extends LinearOpMode {
    public hardware robot = new hardware();
    public sleep s = new sleep();
    double motifID = -1;
    double bearing = 0;
    boolean seePurple = false;
    boolean seeGreen = false;
    double greenCenter = -1;
    double purpleCenter = -1;
    boolean seeRedTag = false;
    boolean seeBlueTag = false;

    @Override
    public void runOpMode() throws InterruptedException {

        // AprilTag processor
        AprilTagProcessor tagProcessor = new AprilTagProcessor.Builder()
                .setDrawTagID(true)
                .setDrawTagOutline(true)
                .build();

        // Green blob processor — FTC recommended range
        ColorBlobLocatorProcessor greenProcessor = new ColorBlobLocatorProcessor.Builder()
                .setTargetColorRange(new ColorRange(
                        ColorSpace.HSV,
                        new Scalar(35, 50, 70),
                        new Scalar(90, 255, 255)
                ))
                .setContourMode(ColorBlobLocatorProcessor.ContourMode.ALL_FLATTENED_HIERARCHY)
                .build();

        // Purple blob processor — tightened to avoid pinks
        ColorBlobLocatorProcessor purpleProcessor = new ColorBlobLocatorProcessor.Builder()
                .setTargetColorRange(new ColorRange(
                        ColorSpace.HSV,
                        new Scalar(135, 100, 100),
                        new Scalar(155, 255, 255)
                ))
                .setContourMode(ColorBlobLocatorProcessor.ContourMode.ALL_FLATTENED_HIERARCHY)
                .build();

        // Vision portal setup
        VisionPortal visionPortal = new VisionPortal.Builder()
                .addProcessors(tagProcessor, greenProcessor, purpleProcessor)
                .setCamera(hardwareMap.get(WebcamName.class, "Webcam1"))
                .setCameraResolution(new Size(640, 480))
                .enableLiveView(true)
                .build();

        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {

            // AprilTag detection
            List<AprilTagDetection> detections = tagProcessor.getDetections();
            if (detections != null && !detections.isEmpty()) {
                AprilTagDetection tag = detections.get(0);
                motifID = tag.id;
                bearing = tag.ftcPose.bearing;
                seeRedTag = tag.id == 24;
                seeBlueTag = tag.id == 20;
            } else {
                seeRedTag = false;
                seeBlueTag = false;
            }

            // Green blob detection with full null safety
            List<ColorBlobLocatorProcessor.Blob> greenBlobs = greenProcessor.getBlobs();
            ColorBlobLocatorProcessor.Blob bestGreenBlob = null;
            double maxGreenArea = 0;

            if (greenBlobs != null) {
                for (ColorBlobLocatorProcessor.Blob blob : greenBlobs) {
                    if (blob != null) {
                        RotatedRect box = blob.getBoxFit();
                        if (box != null) {
                            double area = box.size.area();
                            if (area > maxGreenArea) {
                                maxGreenArea = area;
                                bestGreenBlob = blob;
                            }
                        }
                    }
                }
            }

            if (bestGreenBlob != null && bestGreenBlob.getBoxFit() != null) {
                RotatedRect box = bestGreenBlob.getBoxFit();
                greenCenter = box.center.x;
                seeGreen = maxGreenArea > 800;
            } else {
                greenCenter = -1;
                seeGreen = false;
            }

            // Purple blob detection with full null safety
            List<ColorBlobLocatorProcessor.Blob> purpleBlobs = purpleProcessor.getBlobs();
            ColorBlobLocatorProcessor.Blob bestPurpleBlob = null;
            double maxPurpleArea = 0;

            if (purpleBlobs != null) {
                for (ColorBlobLocatorProcessor.Blob blob : purpleBlobs) {
                    if (blob != null) {
                        RotatedRect box = blob.getBoxFit();
                        if (box != null) {
                            double area = box.size.area();
                            if (area > maxPurpleArea) {
                                maxPurpleArea = area;
                                bestPurpleBlob = blob;
                            }
                        }
                    }
                }
            }

            if (bestPurpleBlob != null && bestPurpleBlob.getBoxFit() != null) {
                RotatedRect box = bestPurpleBlob.getBoxFit();
                purpleCenter = box.center.x;
                seePurple = maxPurpleArea > 800;
            } else {
                purpleCenter = -1;
                seePurple = false;
            }

            // Telemetry
            telemetry.addData("Camera State", visionPortal.getCameraState());
            telemetry.addData("AprilTag ID", motifID);
            telemetry.addData("Bearing", bearing);
            telemetry.addData("See Red Tag", seeRedTag);
            telemetry.addData("See Blue Tag", seeBlueTag);
            telemetry.addData("Green Blob Area", maxGreenArea);
            telemetry.addData("Purple Blob Area", maxPurpleArea);
            telemetry.addData("See Green", seeGreen);
            telemetry.addData("See Purple", seePurple);
            telemetry.addData("Green Center", greenCenter);
            telemetry.addData("Purple Center", purpleCenter);
            telemetry.update();
            if (seeGreen){
                robot.frontright.setPower(3);
                s.sleepvoid(3);
                robot.frontright.setPower(0);

            }
            if (seePurple){
                robot.backleft.setPower(3);
                s.sleepvoid(3);
                robot.backleft.setPower(0);
            }
        }
    }
}
