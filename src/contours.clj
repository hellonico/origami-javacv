(ns contours
  (:import [org.bytedeco.javacv CanvasFrame OpenCVFrameConverter$ToMat])
  (:import [javax.swing WindowConstants])
  (:import [org.bytedeco.opencv.opencv_core IplImage Mat MatVector Scalar])
  (:import [org.bytedeco.opencv.global opencv_imgcodecs opencv_core opencv_imgproc]))

(defn detect-objects [image]
  (let [result (.clone image) contours (MatVector.)]
    (opencv_imgproc/cvtColor image image opencv_imgproc/CV_BGR2GRAY)
    (opencv_imgproc/threshold image image 40.0 200.0 opencv_imgproc/CV_THRESH_BINARY_INV)
    (opencv_imgcodecs/imwrite "thresh_clj.jpg" image)
    (opencv_imgproc/findContours image contours opencv_imgproc/CV_RETR_LIST opencv_imgproc/CV_CHAIN_APPROX_SIMPLE)
    (dotimes [i (.size contours)]
      (let [contour (.get contours i) points (Mat.)]
        (opencv_imgproc/approxPolyDP contour points (* 0.02 (opencv_imgproc/arcLength contour true)) true)
        (opencv_imgproc/drawContours result (MatVector. points) -1 (Scalar/BLUE))))
    result))

(defn -main [& args]
  (let [marcel (Mat. (org.bytedeco.opencv.helper.opencv_imgcodecs/cvLoadImage (or (first args) "marcel.jpg")))
        result (detect-objects marcel)]
    (opencv_imgcodecs/imwrite "detected_clj.jpg" result)))