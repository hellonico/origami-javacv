(ns hello
  (:import [org.bytedeco.javacv CanvasFrame OpenCVFrameConverter$ToMat])
  (:import [javax.swing WindowConstants])
  (:import [org.bytedeco.opencv.global opencv_imgcodecs]))

(defn -main[& args]
    (let[ marcel (opencv_imgcodecs/imread "marcel.jpg")
          converter (OpenCVFrameConverter$ToMat.)
          canvas (CanvasFrame. "Marcel")
          _ (.setDefaultCloseOperation canvas WindowConstants/EXIT_ON_CLOSE)
          ]
    (.showImage canvas (.convert converter marcel))))

; (-main)