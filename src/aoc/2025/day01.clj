(ns aoc.2025.day01
  (:require
   [aoc.core :refer [read-input-lines]]
   [clojure.string :as str]))

(defn parse [s]
  [(first s) (parse-long (subs s 1))])

(defn norm [[dir n]]
  (if (= \L dir)
    (- n)
    n))

(defn turn [[cur z] n]
  (let [cur (mod (+ cur n) 100)]
    [cur (+ z (if (zero? cur) 1 0))]))

(defn part-1 [fname]
  (->>
   (read-input-lines fname)
   (map str/split-lines)
   (flatten)
   (map parse)
   (map norm)
   (reduce turn [50 0])
   second))

(defn zero-crossings [current n]
  (if (pos? n)
    (quot (+ current n) 100)
    (quot (+ (abs n) (mod (- current) 100)) 100)))

(defn turn2 [[cur z] n]
  (let [z' (zero-crossings cur n)
        cur (mod (+ cur n) 100)]
    [cur (+ z z')]))

(defn part-2 [fname]
  (->>
   (read-input-lines fname)
   (map str/split-lines)
   (flatten)
   (map parse)
   (map norm)
   (reduce turn2 [50 0])
   second))

(comment
  (part-1 "2025/day01-sample.txt") ;; rcf
  ;; => 3
  (part-1 "2025/day01.txt") ;; rcf
  ;; => 1052
  (part-2 "2025/day01-sample.txt") ;; rcf
  ;; => 6
  (part-2 "2025/day01.txt") ;; rcf
  ;; => 6295
  )
