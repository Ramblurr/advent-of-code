(ns aoc.2025.day05-test
  (:require [aoc.2025.day05 :as sut]
            [clojure.test :refer [deftest is testing]]))

(def sample "2025/day05-sample.txt")
(def input "2025/day05.txt")
(deftest day05
  (is (= 3 (sut/part-1 sample)))
  (is (= 623 (sut/part-1 input)))
  (is (= 14 (sut/part-2 sample)))
  (is (= 353507173555373 (sut/part-2 input))))
