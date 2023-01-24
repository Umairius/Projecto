
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

;; (reset! (nth @alltables 0) [(conj (nth @alltables 0) {:id "hehe"})])

;; (println @alltables)

(def alltables (atom [[{:id "hehesdshjsdfs222"}],[{:id "hehesdshjsdfs"}]]))

(println @alltables)

(swap! alltables update-in [0] conj {:id "hehe"})

(println @alltables)
