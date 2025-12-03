(ns aoc.2025.day03-test
  (:require [aoc.2025.day03 :as sut]
            [clojure.test :refer [deftest is testing]]))

(def sample "2025/day03-sample.txt")
(def input "2025/day03.txt")
(deftest day03
  (is (= 357 (sut/part-1 sample)))
  (is (= 17435 (sut/part-1 input)))
  (is (= 3121910778619 (sut/part-2 sample)))
  (is (= 172886048065379 (sut/part-2 input))))
