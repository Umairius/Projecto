









(defn createRecord[]
  
  

(let  [numOfFields 1]


  (def record (atom {}))


  (dotimes [n numOfFields]

    (println "Enter field and value:")


    (let [field (read-line)]

      (let [value (read-line)]

        (swap! record assoc field value)))
    
    
    (println @record)))
  
  
  )


(defn createTable []


  (def Table (atom (list)))

  
  (def numOfRecords 1)

  (dotimes [n numOfRecords]
    
    (swap! Table conj Table (createRecord))
    )

  
  (println "-----------hehe---------------")
  
  (print deref Table)
  
  )





(createTable)