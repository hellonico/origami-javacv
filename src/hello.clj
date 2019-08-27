(ns hello
  (:import [org.bytedeco.javacv CanvasFrame OpenCVFrameConverter$ToMat])
  (:import [javax.swing WindowConstants])
  (:import [org.bytedeco.opencv.global opencv_imgcodecs]))

(defn baby-steps[filepath]
  (let[ marcel (opencv_imgcodecs/imread filepath)
          converter (OpenCVFrameConverter$ToMat.)
          canvas (CanvasFrame. "Marcel")
          _ (.setDefaultCloseOperation canvas WindowConstants/EXIT_ON_CLOSE)
          ]
    (.showImage canvas (.convert converter marcel))))

(defn -main[& args]
   (baby-steps (or (first args) "marcel.jpg")))

  
  (comment 
    (baby-steps "marcel.jpg")
    )