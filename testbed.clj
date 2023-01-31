
;; (def singletable (atom []))
;; (def alltables (atom [singletable]))


;; (swap! alltables (conj @(nth @alltables 0) {:duck "hehe"} ))

;; (println deref(get @alltables 0))


;; (def singletable (atom []))
;; (def alltables (atom [singletable]))

;; (swap! (nth @alltables 0) conj {:duck "hehe"})

;; (println @(nth @alltables 0))

;; (def alltables (atom [[{:id "hehesdshjsdfs222"}],[{:id "hehesdshjsdfs"}]]))


;; (println @alltables)



;; (def table (atom [[{:id "ehhehe"} {:id "he"} {:id 222 :name "Alan"}] [{:id "duck"} {:name "jehehe"}]]))

;; (println @table)

;; (swap! table update-in [0] #(concat (subvec % 0 2) (subvec % 3)))


;; (println @table)


;; (def tablelength (atom 3))

;; (println @tablelength)
;; (reset! tablelength (eval (- @tablelength 1)))
;; (println @tablelength)


;; (def my-vec [1 2 3 4 5])
;; (indexOf my-vec 3)


(def ducks [:a :b :c :d :e])

(dotimes [n (count ducks)]
  
  (println n)
  
  
  )