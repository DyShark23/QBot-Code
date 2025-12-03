package org.firstinspires.ftc.teamcode;

import android.util.Size;
import com.qualcomm.robotcore.hardware.HardwareMap;

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

public class Vision {

    public double motifID = -1;
    public double bearing = 0;
    public boolean seePurple = false;
    public boolean seeGreen = false;
    public double greenCenter = -1;
    public double purpleCenter = -1;
    public boolean seeRedTag = false;
    public boolean seeBlueTag = false;
    public double x, y, z;

    private AprilTagProcessor tagProcessor;
    private ColorBlobLocatorProcessor greenProcessor;
    private ColorBlobLocatorProcessor purpleProcessor;
    private VisionPortal visionPortal;

    public void init(HardwareMap hardwareMap) {
        tagProcessor = new AprilTagProcessor.Builder()
                .setDrawTagID(true)
                .setDrawTagOutline(true)
                .build();

        greenProcessor = new ColorBlobLocatorProcessor.Builder()
                .setTargetColorRange(new ColorRange(
                        ColorSpace.HSV,
                        new Scalar(35, 50, 70),
                        new Scalar(90, 255, 255)
                ))
                .setContourMode(ColorBlobLocatorProcessor.ContourMode.ALL_FLATTENED_HIERARCHY)
                .build();

        purpleProcessor = new ColorBlobLocatorProcessor.Builder()
                .setTargetColorRange(new ColorRange(
                        ColorSpace.HSV,
                        new Scalar(135, 100, 100),
                        new Scalar(155, 255, 255)
                ))
                .setContourMode(ColorBlobLocatorProcessor.ContourMode.ALL_FLATTENED_HIERARCHY)
                .build();

        visionPortal = new VisionPortal.Builder()
                .addProcessors(tagProcessor, greenProcessor, purpleProcessor)
                .setCamera(hardwareMap.get(WebcamName.class, "Webcam1"))
                .setCameraResolution(new Size(640, 480))
                .enableLiveView(true)
                .build();
    }

    public void update() {
        List<AprilTagDetection> detections = tagProcessor.getDetections();
        if (detections != null && !detections.isEmpty()) {
            AprilTagDetection tag = detections.get(0);
            motifID = tag.id;
            bearing = tag.ftcPose.bearing;
            seeRedTag = tag.id == 24;
            seeBlueTag = tag.id == 20;
            x = tag.rawPose.x;
            y = tag.rawPose.y;
            z = tag.rawPose.z;
        } else {
            seeRedTag = false;
            seeBlueTag = false;
        }

        List<ColorBlobLocatorProcessor.Blob> greenBlobs = greenProcessor.getBlobs();
        ColorBlobLocatorProcessor.Blob bestGreenBlob = null;
        double maxGreenArea = 0;

        if (greenBlobs != null) {
            for (ColorBlobLocatorProcessor.Blob blob : greenBlobs) {
                if (blob != null && blob.getBoxFit() != null) {
                    double area = blob.getBoxFit().size.area();
                    if (area > maxGreenArea) {
                        maxGreenArea = area;
                        bestGreenBlob = blob;
                    }
                }
            }
        }

        if (bestGreenBlob != null && bestGreenBlob.getBoxFit() != null) {
            greenCenter = bestGreenBlob.getBoxFit().center.x;
            seeGreen = maxGreenArea > 800;
        } else {
            greenCenter = -1;
            seeGreen = false;
        }

        List<ColorBlobLocatorProcessor.Blob> purpleBlobs = purpleProcessor.getBlobs();
        ColorBlobLocatorProcessor.Blob bestPurpleBlob = null;
        double maxPurpleArea = 0;

        if (purpleBlobs != null) {
            for (ColorBlobLocatorProcessor.Blob blob : purpleBlobs) {
                if (blob != null && blob.getBoxFit() != null) {
                    double area = blob.getBoxFit().size.area();
                    if (area > maxPurpleArea) {
                        maxPurpleArea = area;
                        bestPurpleBlob = blob;
                    }
                }
            }
        }

        if (bestPurpleBlob != null && bestPurpleBlob.getBoxFit() != null) {
            purpleCenter = bestPurpleBlob.getBoxFit().center.x;
            seePurple = maxPurpleArea > 800;
        } else {
            purpleCenter = -1;
            seePurple = false;
        }
    }

    public VisionPortal.CameraState getCameraState() {
        return visionPortal.getCameraState();
    }
}
