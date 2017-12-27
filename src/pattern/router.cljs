(ns pattern.router
  (:require
    [goog.dom :as gdom]
    [pattern.pages.home :as home]
    [pattern.pages.base :as base]))
; Notes: Router do not use components only pages

(defn root-element
  "Returns the root element of the app"
  []
  (gdom/getElement "app"))

(defn show-home
  "Show the home page"
  []
  (home/render (base/content-element)))

(defn show-initial
  "Show the initial page"
  []
  (base/render (root-element))
  (show-home))
