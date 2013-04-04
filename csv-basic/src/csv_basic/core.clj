(ns csv_basic.core
  (:gen-class)
  (:use (incanter core io charts)
        [seesaw.core :only [frame
                            ;label
                            scrollable
                            left-right-split
                            button
                            listen
                            native!
                            config!
                            pack!
                            show!]])
  (:import [org.jfree.chart ChartPanel]))

(defn readCSV[datafileName]
;  (def data (to-matrix (read-dataset datafileName :header true :delim \space))))
  (def data (read-dataset datafileName :header true :delim \space)))

(defn -main[& args]
  (readCSV "datafile.csv")

  (native!)
  (def f (frame :title "Chart Test"))

  (defn display [content]
    (config! f :content content)
    content)

  (def plot (ChartPanel. (with-data data (xy-plot ($ :x) ($ :y)))))
  ;(def lbl (label "I'm another label"))

  (def b (button :text "Exit"))
  (listen b :action (fn [e] (System/exit 0)))

  (def split (left-right-split (scrollable b) (scrollable plot) :divider-location 1/3))
  (display split)
  (-> f pack! show!))
