(ns aoc.2025.day01-test
  (:require [aoc.2025.day01 :as sut2]
            [clojure.test :refer :all]))

(def sample "2025/day01-sample.txt")
(def input "2025/day01.txt")
(deftest day01
  (is (= 3 (sut2/part-1 sample)))
  (is (= 1052 (sut2/part-1 input)))
  (is (= 6 (sut2/part-2 sample)))
  (is (= 6295 (sut2/part-2 input))))

