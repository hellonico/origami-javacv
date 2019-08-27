(defproject javacvj "0.1.0-SNAPSHOT"
  :java-source-paths ["java"]
  :aot :all
  :main HelloCv
  :plugins [[lein-auto "0.1.3"][lein-jupyter "0.1.16"]]
  :auto {:default {:file-pattern #"\.(java)$"}}
  :repositories [["vendredi" "https://repository.hellonico.info/repository/hellonico/"]]
  :aliases {
  	"clj.webcam" ["run" "-m" "webcam"]
    "clj.hello" ["run" "-m" "hello"]
    "clj.smooth" ["run" "-m" "smooth"]
    "clj.contours" ["run" "-m" "contours"]

    "java.hello" ["run" "-m" "HelloCv"]
    "java.contour" ["run" "-m" "ContourCv"]
    "java.hough" ["run" "-m" "HoughLines"]
  }
  :dependencies [
    ; don't use [org.clojure/clojure "1.10.0"]
    [org.clojure/clojure "1.10.1"]
                  [org.bytedeco/javacv-platform "1.5.1"]
                ;  [origami/origami "4.1.1-3"]
                 ])