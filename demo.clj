
(ns demo
  "My app example"
  
  (:require
   [clojure.set :as set]
   [clojure.string :as str]))








(defn createRecord[]
  
  

(let  [numOfFields 1]


  (def record (atom {}))

  ;; (println @record)
  (dotimes [n numOfFields]

    (println "Enter field and value:")


    (let [field (read-line)]

      (let [value (read-line)]
        
        
        (reset! record (assoc @record (keyword field) value))))

    ;; (println @record)
    ))
  
  
  )


(defn createTable []

  
  (def Table (atom []))
  
  

  ;; (println @Table)

  (def numOfRecords 2)

  (dotimes [n numOfRecords]


    (createRecord)
    (reset! Table (conj @Table @record)))

  ;; (println @Table)
  )




(defn selectRecords [key]

  ;; (println key)
  (doseq [n @Table]

    ;; (println (contains? n (keyword (get key 0))))))
    ;; (println n)
    
    
    ;; (println (get n  (Integer/parseInt :salary)))
    ;; (println (and contains? n (keyword (get key 0)) (= 10000 (Integer/parseInt (get n :salary))))) 
    
    
    (if  (and contains? n (keyword (get key 0)) ( = 10000 (Integer/parseInt (get n :salary))))
      
      (println "salary is 10000")
      
      )
    
  )
  
)



(defn deleteRecords [key]
  
  
  
  
  
  
  
  
  )






(createTable)
(selectRecords["salary" "equals" 1000])