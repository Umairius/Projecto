
(ns demo
  "My app example"

  (:require
   [clojure.set :as set]
   [clojure.string :as str]))




(def tablemap (atom []))
(def tableData (atom []))






(defn create-table [tablename data]



  (reset! tablemap (conj @tablemap tablename data))
  (reset! tableData (conj @tableData ()))

  (println @tablemap))



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


  (def dataIndex (eval (/ tableIndex 2)))
  (swap! tableData update-in [dataIndex] (fn [existing-data] (into [] (conj existing-data data)))))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(defn select-records [tablename query]


  (dotimes [n (count @tablemap)]

    (if (= tablename (nth @tablemap n))
      (def tableMapIndex n)))


  (def thisTableIndex  (eval (/ tableMapIndex 2)))

  (dotimes [n (count (nth @tableData thisTableIndex))]

    (println (nth (nth @tableData thisTableIndex) n)))


  (def queryElements (flatten (vals query)))


  (def queriedValue (nth queryElements 2))
  (def recordInstance (nth @tableData thisTableIndex))

  (if (= := (nth queryElements 0))
    (dotimes [n (count (nth @tableData thisTableIndex))]

      (if (contains? (nth (nth @tableData thisTableIndex) n) (nth queryElements 1))
        (if (==  (get (nth recordInstance n) (nth queryElements 1))  queriedValue)
          (println "Record Found: " (nth (nth @tableData thisTableIndex) n)))
    ;;records of single tables have been acceessed.
        )))


  (if (= :>= (nth queryElements 0))

    (dotimes [n (count (nth @tableData thisTableIndex))]
      (if (contains? (nth (nth @tableData thisTableIndex) n) (nth queryElements 1))
        (if (>=  (get (nth recordInstance n) (nth queryElements 1))  queriedValue)
          (println "Record Found: " (nth (nth @tableData thisTableIndex) n))))))

  (if (= :<= (nth queryElements 0))

    (dotimes [n (count (nth @tableData thisTableIndex))]

      (if (contains? (nth (nth @tableData thisTableIndex) n) (nth queryElements 1))
        (if (<=  (get (nth recordInstance n) (nth queryElements 1))  queriedValue)
          (println "Record Found: " (nth (nth @tableData thisTableIndex) n))))))




  (if (= :> (nth queryElements 0))


    (dotimes [n (count (nth @tableData thisTableIndex))]

      (if (contains? (nth (nth @tableData thisTableIndex) n) (nth queryElements 1))
        (if (>  (get (nth recordInstance n) (nth queryElements 1))  queriedValue)
          (println "Record Found: " (nth (nth @tableData thisTableIndex) n))))))

  (if (= :< (nth queryElements 0))

    (dotimes [n (count (nth @tableData thisTableIndex))]

      (if (contains? (nth (nth @tableData thisTableIndex) n) (nth queryElements 1))
        (if (<  (get (nth recordInstance n) (nth queryElements 1))  queriedValue)
          (println "Record Found: " (nth (nth @tableData thisTableIndex) n)))))))





(defn delete [tableName query]
  (def queryElements (flatten (vals query)))
  (def operator (nth queryElements 0))
  (def field (nth queryElements 1))
  (def value (nth queryElements 2))

  (dotimes [n (count @tablemap)]

    (if (= tableName (nth @tablemap n))
      (def tableMapIndex n)))

  (def thisTableIndex  (eval (/ tableMapIndex 2)))
  
  (def op (nth queryElements 0))
  
  (when (= := op)
    (swap! tableData update-in [thisTableIndex] (fn [x] (vec (remove (fn [y] (if (= (get y field) value) true false)) x)))))
  (when (= :>= op)
    (swap! tableData update-in [thisTableIndex] (fn [x] (vec (remove (fn [y] (if (>= (get y field) value) true false)) x)))))
  (when (= :<= op)
    (swap! tableData update-in [thisTableIndex] (fn [x] (vec (remove (fn [y] (if (<= (get y field) value) true false)) x)))))
  (when (= :> op)
    (swap! tableData update-in [thisTableIndex] (fn [x] (vec (remove (fn [y] (if (> (get y field) value) true false)) x)))))
  (when (= :< op)
    (swap! tableData update-in [thisTableIndex] (fn [x] (vec (remove (fn [y] (if (< (get y field) value) true false)) x))))))


(create-table :employee {:id :number :first-name :string :last-name :string :salary :number})



(create-table :ducks {:id :number :first-name :string :last-name :string :salary :number :wings :number})

(create-table :applicants {:id :number :first-name :string :last-name :string :salary :number :wings :number})


(insert :employee {:id 1 :first-name "Alan" :last-name "Kay" :salary 100500})

(insert :employee {:id 2 :first-name "Alanasdasd" :last-name "Kay" :salary 1004})
(insert :employee {:id 3 :first-name "Rakesh Cristoval" :last-name "Cheens" :salary 119})

(insert :employee {:id 4 :first-name " Oval" :last-name "SSFwqfs" :salary 122})



(insert :ducks {:id 2 :first-name "HEHEHEHE" :last-name "Rakesh" :salary 123123 :wings 2242})

(insert :ducks {:id 1 :first-name "HEHEHEHE" :last-name "Rakesh" :salary 123123 :wings 2242})
(insert :ducks {:id 4 :first-name "HULUKULUKLU" :last-name "LALALLALALA" :salary 184 :wings 2242})

(insert :applicants {:id 34534 :first-name "HE" :last-name "sssssd" :salary 123122342343 :wings 2242})



(select-records :employee {:where [:> :salary 1000]})

(select-records :ducks {:where [:> :salary 1000]})



(println "Before: " @tableData)
(delete :employee {:where [:< :id 4]})
(println "After: " @tableData)