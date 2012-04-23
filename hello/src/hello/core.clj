(ns hello.core 
	(:gen-class))

(defn greet[who] 
	(println 
		(str "Hello, "who"!")
	)
)

(defn -main[who] (greet who))
