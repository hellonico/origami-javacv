(defproject javacvj "0.1.0-SNAPSHOT"
  :java-source-paths ["java"]
  :main HelloCv
  :plugins [[lein-auto "0.1.3"][lein-jupyter "0.1.16"]]
  :auto {:default {:file-pattern #"\.(java)$"}}
  :repositories [["vendredi" "https://repository.hellonico.info/repository/hellonico/"]]
  :dependencies [[org.clojure/clojure "1.10.0"]
                  [org.bytedeco/javacv-platform "1.5.1"]
                ;  [origami/origami "4.1.1-3"]
                 ])
