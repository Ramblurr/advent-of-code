(ns aoc.2025.day04
  (:require
   [medley.core :as m]
   [aoc.grid :as grid]
   [aoc.core :refer [read-input-lines]]))

#_(defn print-grid [g adj]
    (grid/render-grid g (fn [_g pos item]
                          (when (= pos [8 0])
                            (tap> [pos item (get-in adj pos)]))
                          (if (= "@" item)
                            (if
                             (< (count (get adj pos)) 4)
                              "x"
                              "@")
                            "."))))

(defn has-edge? [g from to]
  (and (= "@" (g from))
       (= "@" (g to))))

(defn removeable [g adjs]
  (->> g
       (m/filter-vals #(= "@" %))
       (filter #(< (count (get adjs (first %))) 4))
       (keys)))

(defn tick [state]
  (let [g    (or (:g state) state)
        adjs (grid/adjacency-graph grid/adjacent-compass has-edge? g)
        r    (removeable g adjs)]
    #_(tap> (print-grid g adjs))
    (assoc state :g g :removeables r :can-remove (count r))))

(defn remove [state]
  (-> state
      (update :removed (fnil + 0) (:can-remove state))
      (update :g (fn [g]
                   (reduce
                    (fn [g pos]
                      (assoc g pos "."))
                    g
                    (:removeables state))))))

(defn parse [fname]
  (-> fname
      read-input-lines
      (grid/to-grid (fn [v] (if (= v "@") "@" ".")))))

(defn part-1 [fname]
  (-> fname
      parse
      tick
      :can-remove))

(defn part-2 [fname]
  (let [g        (-> fname parse)
        max-tick 10000]
    (loop [s (tick g)
           i 0]
      (let [s (tick s)]
        (cond
          (= i max-tick)          {:fail s :i i}
          (zero? (:can-remove s)) (:removed s)
          :else
          (recur (remove s) (inc i)))))))

(comment
  ;; (part-2 "2025/day04.txt") ;; rcf
  (part-1 "2025/day04.txt") ;; rcf
  (part-1 "2025/day04-sample.txt") ;; rcf
  (part-1 "2025/day04-sample.txt") ;; rcf
  (part-2 "2025/day04.txt") ;; rcf
  (part-2 "2025/day04-sample.txt") ;; rcf
  )
