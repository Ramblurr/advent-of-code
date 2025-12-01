(ns aoc.2026.day01-test
  (:require [aoc.2026.day01 :as sut2]
            [clojure.test :refer :all]))

(def sample "2026/day01-sample.txt")
(def sample2 "2026/day01-sample2.txt")
(def input "2026/day01.txt")
(deftest day01
  (is (= 3 (sut2/part-1 sample)))
  )
