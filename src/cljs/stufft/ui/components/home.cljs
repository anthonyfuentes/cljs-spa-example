(ns stufft.ui.components.home
  (:require [reitit.frontend.easy :as reitit-fe-easy]))

(defn render []
  [:div
   [:h1 "home!"]
   [:a {:href (reitit-fe-easy/href :pages/about)} "about"]])
