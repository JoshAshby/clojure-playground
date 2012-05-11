(ns pe1.core 
  (:gen-class))

(def how-far 1000)
(def total 0)

(defn sum[]
  (doseq [i (range 3 how-far)]
    (if (or (= (rem i 3) 0) (= (rem i 5) 0)) (do (def total (+ total i)) (println (str "i: " i))))
    )
  (println (str "Total: " total))
  )

(defn -main
  "sum of multiples of 3, 5 below how-far"
  []
  (sum))
