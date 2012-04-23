(ns prime.core
	(:gen-class))

(defn not-auto-prime[number]
	(if (= number 1)
		(println "Why do you want to know if 1 is prime, you crazy monkey!")
		(doseq [i [2 3 5]]
			(if (= (rem number i) 0)
				(println (str "Not prime, multiple of " i))
				nil
			)
		)
	)
)

(defn prime-calc[number]
	"Calculates if the number is prime by looking at all of the numbers between 3 and the square root of the number.
	This could be improved by skipping over numbers which are divisible by 2 or 3 or 5 already."
	(def s 
		(if (<= 8 number)
			(+ (int (Math/sqrt number)) 1)
			number
		)
	)

	(loop [i 6]
		(when (<= i s)
			(doseq [t [2 3 5]]
				(if (= (rem i t) 0)
					(recur(inc i))
				)
			)
			(if (= (= (rem number i) 0) false)
				(if (= i s)
					(println "Prime")
					(recur (inc i)))
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
