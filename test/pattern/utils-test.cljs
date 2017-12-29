(ns pattern.utils-test
  (:require
    [cljs.test :refer-macros [deftest is testing]]
    [pattern.utils :as u]))

(deftest duplicate-matrix-horizontal
  (let [matrix [[1 1][1 1]]
        matrix-result [[1 1 1 1][1 1 1 1]]]
    (is (= matrix-result (u/duplicate-matrix-horizontal matrix)))))

(deftest quadriplicate-matrix-horizontal
  (let [matrix [[1 1][1 1]]
        matrix-result [[1 1 1 1 1 1 1 1][1 1 1 1 1 1 1 1]]]
    (is (= matrix-result (u/duplicate-matrix-horizontal matrix 4)))))

(deftest duplicate-matrix-vertical
  (let [matrix [[1 1][1 1]]
        matrix-result [[1 1][1 1][1 1][1 1]]]
    (is (= matrix-result (u/duplicate-matrix-vertical matrix)))))

(deftest quadriplicate-matrix-vertical
  (let [matrix [[1 1][1 1]]
        matrix-result [[1 1][1 1][1 1][1 1][1 1][1 1][1 1][1 1]]]
    (is (= matrix-result (u/duplicate-matrix-vertical matrix 4)))))
