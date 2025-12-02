(ns aoc.2025.day02-test
  (:require [aoc.2025.day02 :as sut]
            [clojure.test :refer [deftest is testing]]))

(def sample "2025/day02-sample.txt")
(def input "2025/day02.txt")
(deftest day02
  (is (= 1227775554 (sut/part-1 sample)))
  (is (= 24747430309 (sut/part-1 input)))
  (is (= 4174379265 (sut/part-2 sample)))
  (is (= 30962646823 (sut/part-2 input))))
