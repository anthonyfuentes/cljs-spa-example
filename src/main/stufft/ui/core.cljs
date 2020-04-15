(ns stufft.ui.core
  (:require [reagent.dom :as dom]
            [stufft.ui.components.app :as app :refer [render]]
            [stufft.ui.routing.router :as router]))

(defn mount-app! []
  (dom/render
    [app/render]
    (.getElementById js/document "app")))

(defn init! []
  (router/start!)
  (mount-app!))

(defn ^:dev/after-load start []
  (init!))

(defn main! []
  (-> js/document
      (.addEventListener "DOMContentLoaded" init!)))
