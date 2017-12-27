(ns pattern.components.canvas
  (:require
    [reagent.core :as reagent]
    [goog.dom :as gdom]))

; ==========================================================
; Block Styling
; ==========================================================
; Define the class names for the blocks used
(def matrix-class "matrix")
(def row-class (str matrix-class "-row"))
(def cell-class (str row-class "-cell"))
(def cell-painted-class (str cell-class "-painted"))

(def cell-size 15)
(def cell-border-size 1)
(def cell-full-size (+ cell-size (* 2 cell-border-size)))

(defn get-cell-style
  "Get the cell style according to it's value"
  [value]
  {:style {:height (str cell-size "px")
           :width (str cell-size "px")}})

(defn toggle-cell-value
  [value]
  (if (= @value 1)
    (swap! value dec)
    (swap! value inc)))

; ==========================================================
; Block Building
; ==========================================================
(defn get-matrix-width
  "Return the width of a matrix"
  [matrix]
  (let [[row & rest] matrix]
    (* cell-full-size (count row))))

(defn build-matrix-element
  "Build the matrix HTML element"
  [matrix]
  [:div {:class matrix-class :style {:width (str (get-matrix-width matrix) "px")}}])

(defn build-row-element
  "Build the row HTML element"
  [row]
  [:div {:class row-class :style {:height (str cell-full-size "px")}}])

; ==========================================================
; Block Drawing
; ==========================================================
(defn build-cell
  "Draw a cell"
  [value]
  (let [current-value (reagent/atom value)]
    (fn []
      [:div (conj
              (get-cell-style @current-value)
              {:class (str cell-class
                        (if (= @current-value 1)
                          (str " " cell-painted-class)))}
              {:on-click #(toggle-cell-value current-value)}
              {:data-value @current-value})])))

(defn build-row
  "Draw a row of cell s"
  [cells]
  (reduce (fn [row cell]
            (into row [[build-cell cell]]))
          (build-row-element cells)
          cells))

(defn build-matrix
  "Draw a matrix with rows and cells"
  [rows]
  (reduce (fn [matrix row]
            (into matrix [(build-row row)]))
          (build-matrix-element rows)
          rows))

(defn component
  "Returns the canvas component"
  [matrix]
  (build-matrix matrix))

(defn element
  []
  (gdom/getElementByClass matrix-class))
