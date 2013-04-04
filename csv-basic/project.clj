(defproject csv-basic "0.1.0-SNAPSHOT"
  :description "Just messing around with using the incanter library for
               reading in a CSV. May later use the knowledge learned from
               this to make a util for the FSAE team, as all of our car
               data is logged in a CSV."
  :url "http://joshashby.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [incanter "1.4.1"]
                 [org.jfree/jfreechart "1.0.14"]]
  :plugins [[lein-bin "0.3.2"]]
  :main csv_basic.core
  :aot [csv_basic.core])
