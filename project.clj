(defproject thrift-clj "0.1.0-alpha3"
  :description "Clojure and Thrift working hand in hand."
  :url "https://github.com/xsc/thrift-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.logging "0.2.6"]
                 [org.reflections/reflections "0.9.9-RC1"]
                 [org.apache.thrift/libthrift "0.9.0"]
                 [javax.servlet/servlet-api "2.5"]
                 [org.slf4j/slf4j-log4j12 "1.5.2"]
                 [potemkin "0.2.1"]]

  :test-paths ["test/clj"]

  :profiles {:dev {:dependencies [[midje "1.5.1"]]
                   :plugins [[lein-midje "3.0.0"]]}
             :test-thriftc {:plugins [[lein-thriftc "0.1.0"]]
                            :prep-tasks ["thriftc"]
                            :thriftc {:source-paths ["test/thrift"]}}
             :test-java {:java-source-paths ["test/java"]}}
  
  :aliases {"midje-with-thrift" ["with-profile" "dev,test-thriftc" "midje"]
            "midje-with-java" ["with-profile" "dev,test-java" "midje"]})
