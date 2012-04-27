(ns prime.core
  (:gen-class))

(defn quick-prime[number]
  "Checks if number is automatically prime or 1. Does this by dividing it by 2,3,5 if that fails then it returns false"

  (if (= number 1)
    (println "Why do you want to know if 1 is prime, you crazy monkey!")
    (doseq [i [2 3 5]]
      (if (= (= (rem number i) 0) false)
        true
        (do
          "Break"
          false
        )
      )
    )
  )
)

(defn prime-calc[number]
  "Calculates if the number is prime by looking at all of the numbers between 7 and the square root of the number.
  This could be improved by skipping over numbers which are divisible by 2 or 3 or 5 already."

  (loop [i 7]
    (when (< i (Math/sqrt number))
      (doseq [j [2 3 5]]
        (if (= (rem i j) 0) 
         (recur (inc i))
        )
      )
      (
        (if (= (= (rem number i) 0) false)
          (recur (inc i))
          (do
            (println (str "Not prime @ " i))
            "Break"
          )
        )
      )
    )
  )
)

(defn prime[number]
  (if (= (quick-prime number) false)
    (prime-calc number)
  )
)

(defn -main[number] (prime number))
