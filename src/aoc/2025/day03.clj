(ns aoc.2025.day03
  (:require
   [clojure.string :as str]
   [aoc.core :refer [read-input pull-digits]]))

(defn digits->num
  "converts a vector of single digits into a number.
  e.g., [9 8] -> 98, [1 2 3] -> 123"
  [v]
  (reduce (fn [acc d] (+ (* acc 10) d)) 0 v))

(defn joltage
  [bank n]
  ;; fill positions left to right, we want leftmost digits to be as big as possible
  ;; calculate k, the num of elements i can consider for the next pick
  ;; because i must have n - 1 digits left after the pick
  ;; k = remaining - n + 1
  (loop [remaining (vec bank)
         n         n
         result    []]
    (if (zero? n)
      result
      (let [;; i can pick from the first k elements, leave enough for the remaning picks
            k      (- (count remaining) n -1)
            window (subvec remaining 0 k)
            best   (reduce max window)
            idx    (.indexOf remaining best)]
        (recur (subvec remaining (inc idx))
               (dec n)
               (conj result best))))))

(defn solve [fname n]
  (->>
   (read-input fname)
   (str/split-lines)
   (map pull-digits)
   (map #(joltage % n))
   (map digits->num)
   (reduce +)))

(defn part-1 [fname]
  (solve fname 2))

(defn part-2 [fname]
  (solve fname 12))

(comment

  (part-1 "2025/day03-sample.txt") ;; rcf
  ;; => 357
  (part-1 "2025/day03.txt") ;; rcf
  ;; => 17435
  (part-2 "2025/day03-sample.txt") ;; rcf
  ;; => 3121910778619
  (part-2 "2025/day03.txt") ;; rcf
  ;; => 172886048065379
  )
