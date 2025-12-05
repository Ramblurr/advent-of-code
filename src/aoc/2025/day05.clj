(ns aoc.2025.day05
  (:require
   [medley.core :as m]
   [aoc.core :refer [read-input-lines pull-ints]]))

(defn parse [fname]
  (-> (->> fname
           read-input-lines
           (map pull-ints)
           (split-with seq))
      (update 1 #(map first (rest %)))))

(defn in-range? [[start end] n]
  (<= start n end))

(defn count-in-ranges [ranges n]
  (count (filter #(in-range? % n) ranges)))

(defn by-count-in-ranges [[ranges nums]]
  (into {}
        (for [n nums]
          [n (count-in-ranges ranges n)])))

(defn part-1 [fname]
  (->> fname
       parse
       by-count-in-ranges
       (m/filter-vals pos?)
       count))

(defn merge-range [[s1 e1] [s2 e2]]
  (when (<= s2 (inc e1))
    ;; they overlap so merge them into one
    [(min s1 s2) (max e1 e2)]))

(defn merge-ranges [rs]
  ;; the idea is to take the list of ranges, which may overlap
  ;; and simplify it so there are no overlapping ranges
  ;; by sorting them them by start value
  ;; and merging them using merge-range
  (let [sorted (sort-by first rs)]
    (reduce (fn [acc r]
              (let [last-r (peek acc)]
                (if-let [m (merge-range last-r r)]
                  (conj (pop acc) m)
                  (conj acc r))))
            [(first sorted)]
            sorted)))

(defn part-2 [fname]
  (->> fname
       parse
       first
       (merge-ranges)
       (map #(inc (- (second %) (first %))))
       (reduce +)))

(comment
  (part-1 "2025/day05-sample.txt") ;; rcf
  ;; => 3
  (part-1 "2025/day05.txt") ;; rcf
  ;; 377 is too low
  ;; => 623
  (part-2 "2025/day05-sample.txt") ;; rcf
  ;; => 14
  (part-2 "2025/day05.txt") ;; rcf
  ;; => 353507173555373
  (part-2 "2025/day05-sample.txt") ;; rcf
  )

