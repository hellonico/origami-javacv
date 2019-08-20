(ns wc) 
; https://github.com/sarxos/webcam-capture/blob/master/webcam-capture/src/example/java/WebcamPanelExample.java

(import [javax.swing JFrame])
(import [com.github.sarxos.webcam Webcam WebcamPanel WebcamResolution])

(def webcam (Webcam/getWebcams 1000))
(println webcam)
(.setViewSize webcam (.getSize WebcamResolution/VGA))
(def panel (WebcamPanel. webcam))
		; WebcamPanel panel = new WebcamPanel(webcam);
		panel.setFPSDisplayed(true);
		panel.setDisplayDebugInfo(true);
		panel.setImageSizeDisplayed(true);
		panel.setMirrored(true);

		JFrame window = new JFrame("Test webcam panel");
		window.add(panel);
		window.setResizable(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
	}
}