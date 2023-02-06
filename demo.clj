
(ns demo
  "My app example"

  (:require
   [clojure.set :as set]
   [clojure.string :as str]))


(def tablemap (atom []))
(def tableData (atom []))

(defn create-table [tablename data]
  (reset! tablemap (conj @tablemap tablename data))
  (reset! tableData (conj @tableData []))
  (println @tablemap)
  
  )



(defn insert [tablename data]


  (dotimes [n (count @tablemap)]

    (if (= tablename (nth @tablemap n))
      (def tableIndex n)))
  (println tableIndex)



  (dotimes [n (count @tablemap)]

    (if (= tablename (nth @tablemap n))
      (def types  (vals (nth @tablemap (eval (+ n 1)))))))


  (def mapList (into [] @tablemap))

  (def recordData (into [] (vals data)))

  (dotimes [n (count types)]


    (if (= (nth types n) :string)

      (do
        (println "this data entry shud be a string")
        (if (string? (nth recordData n))
          (do
            (println "the entered type is correct"))
          (do
            (println "the entered type is incorrect"))))
      (do
        (println "this entry shud be a number")
        (if (number? (nth recordData n))
          (println "the entered type is correct")
          (println "the entered type is incorrect")))))

  (let [thisTableIndex (eval (/ tableIndex 2))]
      (swap! tableData update-in [thisTableIndex] (fn [existing-data] (into [] (conj existing-data data))))
    )
  
  )

(defn select-records [tablename query]

(let [queryElements (flatten (vals query))
      operator (nth queryElements 0)
      field (nth queryElements 1)
      value (nth queryElements 2)]
  
  (dotimes [n (count @tablemap)]
    (if (= tablename (nth @tablemap n))
      (def tableMapIndex n)))
  
(let [op operator
       thisTableIndex  (eval (/ tableMapIndex 2))
      table (nth @tableData thisTableIndex)]
  
  (cond
    (= := op) (doseq [record table]
                (when (= (get record field ) value)
                  (println "Record Found: " record)))

    (= :>= op) (doseq [record table]
                 (when (>= (get record field) value)
                   (println "Record Found: " record)))

    (= :<= op) (doseq [record table]
                 (when (<= (get record field) value)
                   (println "Record Found: " record)))

    (= :> op) (doseq [record table]
                (when (> (get record field) value)
                  (println "Record Found: " record)))

    (= :< op) (doseq [record table]
                (when (< (get record field) value)
                  (println "Record Found: " record)))
    ))

)

  
  )





(defn delete [tableName query]
(let [queryElements (flatten (vals query))
      operator (nth queryElements 0)
      field (nth queryElements 1)
      value (nth queryElements 2)]

  (dotimes [n (count @tablemap)]
    (if (= tableName (nth @tablemap n))
      (def tableMapIndex n)))
  
(let [thisTableIndex  (eval (/ tableMapIndex 2))
      op (nth queryElements 0)] 
(cond
  (= := op) (swap! tableData update-in [thisTableIndex] (fn [x] (vec (remove (fn [y] (if (= (get y field) value) true false)) x))))
  (= :>= op) (swap! tableData update-in [thisTableIndex] (fn [x] (vec (remove (fn [y] (if (>= (get y field) value) true false)) x))))
  (= :<= op) (swap! tableData update-in [thisTableIndex] (fn [x] (vec (remove (fn [y] (if (<= (get y field) value) true false)) x))))
  (= :> op) (swap! tableData update-in [thisTableIndex] (fn [x] (vec (remove (fn [y] (if (> (get y field) value) true false)) x))))
  (= :< op) (swap! tableData update-in [thisTableIndex] (fn [x] (vec (remove (fn [y] (if (< (get y field) value) true false)) x)))))
  :else nil)
  
  )
  
) 

(create-table :employee {:id :number :first-name :string :last-name :string :salary :number})



(create-table :ducks {:id :number :first-name :string :last-name :string :salary :number :wings :number})

(create-table :applicants {:id :number :first-name :string :last-name :string :salary :number :wings :number})


(insert :employee {:id 1 :first-name "Alan" :last-name "Kay" :salary 1000})

(insert :employee {:id 2 :first-name "Alanasdasd" :last-name "Kay" :salary 1000})
(insert :employee {:id 3 :first-name "Rakesh Cristoval" :last-name "Cheens" :salary 119})

(insert :employee {:id 4 :first-name " Oval" :last-name "SSFwqfs" :salary 122})



(insert :ducks {:id 2 :first-name "HEHEHEHE" :last-name "Rakesh" :salary 123123 :wings 1000})

(insert :ducks {:id 1 :first-name "HEHEHEHE" :last-name "Rakesh" :salary 123123 :wings 2242})
(insert :ducks {:id 4 :first-name "HULUKULUKLU" :last-name "LALALLALALA" :salary 184 :wings 2242})

(insert :applicants {:id 34534 :first-name "HE" :last-name "sssssd" :salary 123122342343 :wings 1000})



(select-records :employee {:where [:>= :id 1]})

(select-records :ducks {:where [:>= :id 1]})


(println @tableData)
(println "Before: " @tableData)
(delete :employee {:where [:< :id 4]})
(println "After: " @tableData)