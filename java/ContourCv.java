import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.IplImage;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.MatVector;
import org.bytedeco.opencv.opencv_core.Scalar;

import java.util.stream.LongStream;

import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.helper.opencv_imgcodecs.cvLoadImage;

public class ContourCv {

    private static Mat detectObjects(Mat srcImage) {
        Mat resultImage = srcImage.clone();
        cvtColor(srcImage, srcImage, CV_BGR2GRAY);
        threshold(srcImage, srcImage, 40, 200, CV_THRESH_BINARY_INV);
        opencv_imgcodecs.imwrite("thresh.jpg", srcImage);

        MatVector contours = new MatVector();
        findContours(srcImage, contours, CV_RETR_LIST, CV_CHAIN_APPROX_SIMPLE);

        LongStream.range(0, contours.size()).mapToObj(contours::get).forEach(contour -> {
            Mat points = new Mat();
            approxPolyDP(contour, points, arcLength(contour, true) * 0.02, true);
            drawContours(resultImage, new MatVector(points), -1, Scalar.BLUE);
        });

        return resultImage;
    }

    public static void main(String[] args) {
        IplImage marcel_ = args.length > 0 ? cvLoadImage(args[0]) : cvLoadImage("colordetectimage1.jpg");
        Mat marcel = new Mat(marcel_);
        Mat resultImage = detectObjects(marcel);
        opencv_imgcodecs.imwrite("detected.jpg", resultImage);
    }
}
