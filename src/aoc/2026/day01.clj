(ns aoc.2026.day01
  (:require [aoc.core :refer [read-input-lines map-all pull-digits re-pos]]
            [medley.core :as m]
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

(comment
  (part-1 "2026/day01-sample.txt") ;; rcf
  ;; => 3
  (part-1 "2026/day01.txt") ;; rcf
  ;; => 1052
  )

