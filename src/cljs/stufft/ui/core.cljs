(ns stufft.ui.core
  (:require [reagent.dom :as dom]
            [stufft.ui.components.app :as app :refer [render]]))

(defn mount-app! []
  (dom/render
    [app/render]
    (.getElementById js/document "app")))

(defn ^:dev/after-load start []
  (mount-app!))

(defn main! []
  (-> js/document
      (.addEventListener "DOMContentLoaded" mount-app!)))
