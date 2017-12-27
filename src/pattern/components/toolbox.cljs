(ns pattern.components.toolbox
  (:require
    [goog.dom :as gdom]
    [pattern.utils :as u]))

(defn extract-row-value
  [row-element]
  (loop [node (gdom/getFirstElementChild row-element)
         row []]
    (if (not= node nil)
      (recur (gdom/getNextElementSibling node) (conj row (.getAttribute node "data-value")))
      row)))

(defn extract-matrix-value
  "Extract from a given matrix HTML element its value"
  [element]
  (u/print-matrix
    (loop [node (gdom/getFirstElementChild element)
           matrix []]
      (if (not= node nil)
        (recur (gdom/getNextElementSibling node) (conj matrix (extract-row-value node)))
        matrix))))

(defn build-button
  "Build the extrac button"
  [get-element]
  [:div {:class "button"
         :on-click #(extract-matrix-value (get-element))}
        "Extractor!"])

(defn component
  "Returns the toolbox component"
  [get-element]
  [:div "Toolbox:" [build-button get-element]])
