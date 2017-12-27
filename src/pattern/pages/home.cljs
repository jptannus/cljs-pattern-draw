(ns pattern.pages.home
  (:require
    [reagent.core :as r]
    [pattern.components.canvas :as canvas]
    [pattern.components.toolbox :as toolbox]))

(def bolivia-matrix [
                     [1 1 0 0 0 1 0 0 0 1]
                     [0 1 0 0 1 0 1 0 0 1]
                     [1 1 0 1 0 0 0 1 0 1]
                     [0 0 1 0 1 1 1 0 1 0]
                     [0 1 0 0 1 0 1 0 0 1]
                     [1 0 0 0 1 1 1 0 0 0]])


(defn build
  "Build the Home page HTML structure"
  []
  (fn []
    [:div
     [toolbox/component canvas/element]
     [canvas/component bolivia-matrix]]))

(defn render
  "Render the Home page in the given element"
  [element]
  (r/render [build] element))
