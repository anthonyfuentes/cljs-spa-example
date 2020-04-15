(ns stufft.ui.components.about
  (:require [reitit.frontend.easy :as reitit-fe-easy]))

(defn render []
  [:div
   [:h1 "about"]
   [:a {:href (reitit-fe-easy/href :pages/home)} "home"]])
