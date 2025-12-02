(ns aoc.2025.day02
  (:require
   [aoc.core :refer [read-input pull-ints]]))

(defn day02 [fname re]
  (->>
   (read-input fname)
   (pull-ints)
   (partition 2)
   (mapcat #(range (first %) (inc (second %))))
   (map str)
   (map #(re-find re %))
   (remove nil?)
   (map first)
   (map parse-long)
   (reduce + 0)))

(defn part-1 [fname]
  (day02 fname #"^(\d+)\1$"))

(defn part-2 [fname]
  (day02 fname #"^(.+)\1+$"))

(comment

  (part-1 "2025/day02-sample.txt") ;; rcf
  ;; => 1227775554
  (part-1 "2025/day02.txt") ;; rcf
  ;; => 24747430309
  (part-2 "2025/day02-sample.txt") ;; rcf
  ;; => 4174379265
  (part-2 "2025/day02.txt") ;; rcf
  ;; => 30962646823
  )
