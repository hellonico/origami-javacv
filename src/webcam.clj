(ns webcam
(:import [org.bytedeco.javacv CanvasFrame])
(:import [org.bytedeco.javacv FrameGrabber]))

(defn -main[& args]
    (let [ grabber (FrameGrabber/createDefault 0)
        ;    canvas (CanvasFrame. "Webcam")
        canvas (CanvasFrame. "Marcel" 0 nil)
           ]
    (.start grabber)
    (while (.isVisible canvas)
       (.showImage canvas (.grab grabber)))
    (.close grabber)))


(comment
    (-main)
    
    )