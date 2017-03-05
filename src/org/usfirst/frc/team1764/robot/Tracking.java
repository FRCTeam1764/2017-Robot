package org.usfirst.frc.team1764.robot;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Tracking extends Thread {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private VideoCapture capture = null;
	private Mat frame;
	private Mat filtered;
	private boolean saved = false;
	private boolean shouldStop = false;
	private static double s_center = 320.0;
	private static double width = 320.0;
	private static double height = 240.0;
	
	static {
		
	}
	
	public static double getCenter()
	{
		return (s_center - width/2.0)/width;
	}
	
	public Tracking() {
		System.out.println("opening camera");
	}
	
	public void open() {
		saved = false;
		if (capture != null)
			return;
		capture = new VideoCapture();
		capture.set(Videoio.CAP_PROP_FRAME_WIDTH, width);
		capture.set(Videoio.CAP_PROP_FRAME_HEIGHT, height);
		capture.set(Videoio.CAP_PROP_FRAME_COUNT, 15);
		capture.open(1);
	}
	
	public void stopTracking() {
        shouldStop = true;
	}
    
    public void run() {
    	open();
    	System.out.println("tracking");
        readFrame();
    }
    
    public double trackObject(Mat img)
    {
    	if (!saved) {
            Imgcodecs.imwrite("/pics/image.png", img);
            saved = true;
    	}
    	List<MatOfPoint> contours = new ArrayList<>();
    	Imgproc.findContours(img, contours, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
    	
    	double center = 0.0;
    	double count = 0.0;
    	
    	for (MatOfPoint contour: contours) {
    		MatOfPoint2f contour2f = new MatOfPoint2f();
    		MatOfPoint2f approx = new MatOfPoint2f();
    		
    		contour.convertTo(contour2f, CvType.CV_32FC2);
    		double epsilon = Imgproc.arcLength(contour2f, true) * 0.1f;
    		Imgproc.approxPolyDP(contour2f, approx, epsilon, true);
    		
    		if (approx.toList().size() == 4)
    		{
    			double area = Imgproc.contourArea(approx);
    			if (area < 300)
    				continue;
    			
    			Rect bounds = Imgproc.boundingRect(contour);
    			if (bounds.width > bounds.height)
    				continue;
    			
    			for (Point point: approx.toList()) {
    				center += point.x;
    				count += 1.0;
    			}
    		}
    	}
    	s_center = center/count;
    	SmartDashboard.putDouble("Center", s_center);
    	SmartDashboard.putDouble("Things", count);
    	return center/count;
    }
    
    public void readFrame() {
		System.out.println(capture.isOpened());
		frame = new Mat();
		filtered = new Mat();
    	while (capture.read(frame) && !shouldStop)
    	{
    		if (frame.empty())
    			System.out.println("Empty Frame");
    		
    		Core.inRange(frame, new Scalar(220f, 220f, 220f), new Scalar(255f, 255f, 255f), filtered);
    	    trackObject(filtered);
    	}
    }
}

