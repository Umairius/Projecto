
(ns demo
  "My app example"
  
  (:require
   [clojure.set :as set]
   [clojure.string :as str]))




(def tablemap(atom []))
;;We can store the data by fetching the index of the tablemap and insert the record map into the list of records


;; (def singletable(atom []))
(def tableData (atom []) )






(defn create-table [tablename data]

  
  
  (reset! tablemap (conj @tablemap tablename data))
  (reset! tableData (conj @tableData ()))
  
  (println @tablemap)
  
  
  
  )

  ;; (println @Table)
  

(defn insert [tablename data]

;; (println tablename data)
  
  
  ;;search for table
  
  
    ;; loop over the tablemap elements and store the index of the correct element
  (dotimes [n (count @tablemap)]
    
    (if (= tablename (nth @tablemap n))
      (def tableIndex n)
      )
    
    )
  (println tableIndex)
  
  
  
  (dotimes [n (count @tablemap)]
    
    (if (= tablename (nth @tablemap n))
      (def types  (vals (nth @tablemap (eval (+ n 1))))) 
      )
    
    )
  
  (println types)

  
  ;; (println "this is types: "types)
  
  ;; (println @tablemap)
  (def mapList (into [] @tablemap))
  
  ;; (println mapList)
  
  (def recordData (into [] (vals data)))
  ;; (println recordData)
  
  (dotimes [n (count types)]
    
    ;; (println (nth types n))
    
    (if (= (nth types n) :string)
      
      (do
        (println "this data entry shud be a string") 
        
        (if (string? (nth recordData n)) 
          (do 
            (println "the entered type is correct")
            )
          (do 
            (println "the entered type is incorrect") 
            )
          
          
          
          
          )
        
        
        )
      (do
        
        (println "this entry shud be a number")
        (if (number? (nth recordData n))
          (println "the entered type is correct")
          (println "the entered type is incorrect")
          
          )
        
        
        )
      
      )
    
    
    
    ;; (print "this is table index" tableIndex)
    
    )
  
  
  (def dataIndex (eval (/ tableIndex 2)))
  
  (println "This is all the tables" @tableData)
  
  
  
  (swap! tableData update-in [dataIndex] conj data)
  (println "This is all the tables" @tableData)  
  
  
  )


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(defn select-records [tablename query]

  
  (dotimes [n (count @tablemap)]

    (if (= tablename (nth @tablemap n))
      (def tableMapIndex n)))
  
  ;; (println tableMapIndex)
  
  
  (def thisTableIndex  (eval (/ tableMapIndex 2)))
  
  ;; (println thisTableIndex)
  
  
  (dotimes [n (count (nth @tableData thisTableIndex))]
    
    (println (nth (nth @tableData thisTableIndex) n))
    
    ;;records of single tables have been acceessed.
    
    
    )
 
  
  (println "this is the query: "query)
  
  (def queryElements (flatten (vals query)))
  
  (println queryElements )
  (println "this is query elements: "(nth queryElements 0))
  
  
  (def queriedValue (nth queryElements 2)) 
  (def recordInstance (nth @tableData thisTableIndex))
  
  (if (= := (nth queryElements 0)) 
    
    
     (dotimes [n (count (nth @tableData thisTableIndex))]
       
       (if (contains? (nth (nth @tableData thisTableIndex) n) (nth queryElements 1)) 
         (if (==  (get (nth recordInstance n) (nth queryElements 1))  queriedValue) 
           (println "Record Found: "(nth (nth @tableData thisTableIndex) n) ) 
         )
    ;;records of single tables have been acceessed.
       )
    )
     
  )
    
    
    (if (= :>= (nth queryElements 0))

          (dotimes [n (count (nth @tableData thisTableIndex))]
            (if (contains? (nth (nth @tableData thisTableIndex) n) (nth queryElements 1))
              (if (>=  (get (nth recordInstance n) (nth queryElements 1))  queriedValue)
                (println "Record Found: " (nth (nth @tableData thisTableIndex) n)))
    ;;records of single tables have been acceessed.
              ))
      
      )
  
    (if (= :<= (nth queryElements 0))

           (dotimes [n (count (nth @tableData thisTableIndex))]

            (if (contains? (nth (nth @tableData thisTableIndex) n) (nth queryElements 1))
              (if (<=  (get (nth recordInstance n) (nth queryElements 1))  queriedValue)
                (println "Record Found: " (nth (nth @tableData thisTableIndex) n)))
    ;;records of single tables have been acceessed.
              )
             
             )
      
      )
  
      

  
    (if (= :> (nth queryElements 0))


           (dotimes [n (count (nth @tableData thisTableIndex))]

             (if (contains? (nth (nth @tableData thisTableIndex) n) (nth queryElements 1))
               (if (>  (get (nth recordInstance n) (nth queryElements 1))  queriedValue)
                 (println "Record Found: " (nth (nth @tableData thisTableIndex) n)))
    ;;records of single tables have been acceessed.
               )
             )
      
      )
  
    (if (= :< (nth queryElements 0))

           (dotimes [n (count (nth @tableData thisTableIndex))]

             (if (contains? (nth (nth @tableData thisTableIndex) n) (nth queryElements 1))
               (if (<  (get (nth recordInstance n) (nth queryElements 1))  queriedValue)
                 (println "Record Found: " (nth (nth @tableData thisTableIndex) n)))
    ;;records of single tables have been acceessed.
               ))
      
      
      
      )
  
    
    
)





(defn delete [tableName query]


  (def queryElements (flatten (vals query)))
  (println queryElements)
  (def operator (nth queryElements 0))
  (def field (nth queryElements 1))
  (def value (nth queryElements 2))
  ;; (def newTable ())
  
    
  (def queriedValue (nth queryElements 2))
(def recordInstance (nth @tableData thisTableIndex))
  (println recordInstance)
    
  (dotimes [n (count @tablemap)]

    (if (= tableName (nth @tablemap n))
      (def tableMapIndex n)))

  ;; (println tableMapIndex)


(def thisTableIndex  (eval (/ tableMapIndex 2)))
  
  (def newTable (nth @tableData thisTableIndex))
  
   (if (= := (nth queryElements 0))
     
     (do 
       
          (println "Equal to")

(dotimes [n (count (nth @tableData thisTableIndex))]


  ;; (println (nth (nth @tableData thisTableIndex) n))
;; (println (get (nth (nth @tableData thisTableIndex) n) field ))
  
  (if (= (get (nth (nth @tableData thisTableIndex) n) field) value)
    
    (println "Yeet this record: " (nth (nth @tableData thisTableIndex) n) )
    
    
    
    

    
    )
  
  )
       
  
       
       )
  
     
     
     )
  
  
    



  
  
  )





  
(create-table :employee {:id :number :first-name :string :last-name :string :salary :number})



(create-table :ducks {:id :number :first-name :string :last-name :string :salary :number :wings :number})

(create-table :applicants {:id :number :first-name :string :last-name :string :salary :number :wings :number})


(insert :employee {:id 1 :first-name "Alan" :last-name "Kay" :salary 100500})

(insert :employee {:id 2 :first-name "Alanasdasd" :last-name "Kay" :salary 1004})
(insert :employee {:id 3 :first-name "Rakesh Cristoval" :last-name "Cheens" :salary 119})





(insert :ducks {:id 2 :first-name "HEHEHEHE" :last-name "Rakesh" :salary 123123 :wings 2242})

(insert :ducks {:id 1 :first-name "HEHEHEHE" :last-name "Rakesh" :salary 123123 :wings 2242})
(insert :ducks {:id 4 :first-name "HULUKULUKLU" :last-name "LALALLALALA" :salary 184 :wings 2242})

(insert :applicants {:id 34534 :first-name "HE" :last-name "sssssd" :salary 123122342343 :wings 2242})



(select-records :employee {:where [:> :salary 1000]})

(select-records :ducks{:where [:> :salary 1000]})



;; (println @tableData)
(delete :employee {:where [:= :id 1]})
;; (println @tableData)




;; (selectRecords["salary" "equals" 1000])
;; (println @Table)
;; (deleteRecords["salary" "equals" "1"])
;; (println @Table)


;; rn the code works perfectly to create arbitrary records in a table of aribitrary length
;; now i just need to figure out a way to include type checking by using a global variable
;; and make each table have its own type checking using one global variable