(ns prime.core
  (:gen-class))

(defn not-auto-prime[number]
  "Checks if number is automatically prime or 1. Does this by dividing it by 2,3,5 if that fails then it returns false"
  (if (= number 1)
    (println "Why do you want to know if 1 is prime, you crazy monkey!")
    (doseq [i [2 3 5]]
      (if (= (rem number i) 0)
        (println (str "Not prime, multiple of " i))
      )
    )
  )
)

(defn prime-calc[number]
  "Calculates if the number is prime by looking at all of the numbers between 7 and the square root of the number.
  This could be improved by skipping over numbers which are divisible by 2 or 3 or 5 already."

  (println "Not divisible by 2, 3, or 5; Checking for primes...")

  (loop [i 7]
    (when (< i number)
      (doseq [j [2 3 5]]
        (if (= (rem i j) 0) 
          (do
            (inc i)
            (println)
          )
        ) 
      )
      (println (str "checking @ " i))
      (if (= (= (rem number i) 0) false)
        (if (= i s)
          (println (str "Couldn't find anything, looks like we're prime @ " number))
          (recur (inc i))
        )
        (println (str "Looks like we're no longer prime @ " i))
      )
    )
  )
)

(defn prime[number]
  (if (= (not-auto-prime number) nil)
    (prime-calc number)
  )
)

(defn -main[number] (prime number))
