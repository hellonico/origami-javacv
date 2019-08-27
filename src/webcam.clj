(ns webcam
  (:import [org.bytedeco.javacv FrameGrabber CanvasFrame]))

(defn -main [& args]
  (let [grabber (FrameGrabber/createDefault 0)
        canvas (if (first args) (CanvasFrame. "Marcel" 0 nil) (CanvasFrame. "Webcam")) ]
    (.start grabber)
    (while (.isVisible canvas)
      (.showImage canvas (.grab grabber)))
    (.close grabber)))