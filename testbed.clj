(def counter (atom 0))
;; #'user/counter

(swap! counter inc)
;;=> 1

(swap! counter inc)


(println @counter)