(ns aoc.2025.day04-test
  (:require [aoc.2025.day04 :as sut]
            [clojure.test :refer [deftest is testing]]))

(def sample "2025/day04-sample.txt")
(def input "2025/day04.txt")
(deftest day04
  (is (= 13 (sut/part-1 sample)))
  (is (= 1537 (sut/part-1 input)))
  (is (= 43 (sut/part-2 sample)))
  (is (= 8707 (sut/part-2 input))))
