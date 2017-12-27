(ns pattern.utils
  (:require
    [clojure.string :as string]))

(defn duplicate-matrix-horizontal
  "Duplicate a matrix horizontally a number of times"
  ([matrix]
   (duplicate-matrix-horizontal matrix 2))
  ([matrix times]
   (let [result
         (vec (map
                #(vec (flatten (repeat times %1)))
                matrix))]
     (println (str "Duplicated horizontally matrix => " result))
     result)))

(defn duplicate-matrix-vertical
  "Duplicate a matrix vertically a number of times"
  ([matrix]
   (duplicate-matrix-vertical matrix 2))
  ([matrix times]
   (let [result
         (vec (reduce into (repeat times matrix)))]
     (println (str "Duplicated vertically matrix => " result))
     result)))

(defn print-matrix
  "Print a matrix in the console"
  [matrix]
  (println (str
             (loop [[first & rest] matrix
                    result "["]
               (if (not= first nil)
                 (recur rest (str result "\n  [" (string/join " " first) "]"))
                 result))
            "\n]")))
