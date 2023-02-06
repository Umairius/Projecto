
(def hehe (atom  [
           [
            {:id 1 :name "Baklulul"}
            {:id 2 :name "rakesh"}
            {:id 3 :name "Panjeet"}
            ] 
           
           [{:id 1 :name "Huihui"}
            {:id 2 :name "Updog"}
            ] 
           
           [{:id 1 :name "huehue"} 
            {:id 2 :name "Zarn"}
            ]
           ]
)
  )

(println @hehe)
(swap! hehe update-in [0] (fn [x] (vec (remove (fn [y] (if (> (get y :id) 1) true false)) x))))
(println @hehe)