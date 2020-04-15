(ns stufft.ui.routing.routes
  (:require [stufft.ui.components.about :as about]
            [stufft.ui.components.home :as home]))

(def all
  [["/"
    {:name :pages/home
     :view home/render}]
   ["/about"
    {:name :pages/about
     :view about/render}]])
