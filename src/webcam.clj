(ns webcam)
(import [org.bytedeco.javacv CanvasFrame])
(import [org.bytedeco.javacv FrameGrabber])

(defn -main[& args]
    (let [ grabber (FrameGrabber/createDefault 0)
           canvas (CanvasFrame. "Webcam")]
    (.start grabber)
    (while (.isVisible canvas)
       (.showImage canvas (.grab grabber)))
    (.close grabber)))

(-main)