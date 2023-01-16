
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
    ;; (println (class (n :salary)))
    
    
    (if (contains? n :salary)
       (if  (= 1000  (Integer/parseInt (get n :salary)))
         (println "Record Found: " n)
         (println "No Records Found")) 
      (println "key not found");
      )
   
    
    )
  
)





(defn deleteRecords [key]
  
  
  (defn remove-indexed [v n]
    (into (subvec v 0 n) (subvec v (inc n))))
  
   (doseq [n @Table]

    ;; (println @Table)
    ;; (println (get n :id))
    

    (println (class (get key 2)))
    (if (contains? n (keyword (get key 0)))
      (if (=  (Integer/parseInt (get key 2)) (Integer/parseInt (get n :salary)))
        
        (do
          (reset! Table (remove-indexed @Table (.indexOf @Table n)))
          (println n " has been employeeted"))
        )
      
      )
    
    
    
    )
         
         
         
         
         )
  
(createTable)
;; (selectRecords["salary" "equals" 1000])


(println @Table)
(deleteRecords["salary" "equals" "1"])
(println @Table)