(ns smooth
    (:import [org.bytedeco.javacv CanvasFrame OpenCVFrameConverter$ToMat])
    (:import [javax.swing WindowConstants])
    (:import [org.bytedeco.opencv.opencv_core Size])
    (:import [org.bytedeco.opencv.global opencv_imgcodecs opencv_imgproc]))

(defn -main[& args]
(let[marcel (opencv_imgcodecs/imread "marcel.jpg")
     canvas (CanvasFrame. "Marcel" 0 nil)
     converter (OpenCVFrameConverter$ToMat.)]
    (opencv_imgproc/GaussianBlur marcel marcel (Size. 5 5) 0.0)
    (opencv_imgproc/cvtColor marcel marcel opencv_imgproc/COLOR_BGR2GRAY)
    (.showImage canvas (.convert converter marcel))
    (opencv_imgcodecs/imwrite "output.jpg" marcel)))

; ALT-F4 to close
(comment
(-main)

)