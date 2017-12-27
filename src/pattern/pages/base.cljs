(ns pattern.pages.base
  (:require
    [reagent.core :as r]
    [goog.dom :as gdom]
    [pattern.components.header :as header]
    [pattern.components.footer :as footer]))

(defn build-content-element
  "Build the HTML of the content"
  []
  [:div {:class "content"}])

(defn content-element
  "Return the content element"
  []
  (gdom/getElementByClass "content"))

(defn build
  "Build the base component for the all contained pages"
  []
  (fn []
    [:div {:class "all"}
     [header/component]
     [build-content-element]
     [footer/component]]))

(defn render
  "Render the base HTML of the app"
  [element]
  (r/render [build] element))
