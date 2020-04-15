(ns stufft.ui.components.app
  (:require [stufft.ui.routing.router :as router]))

(defn render []
  [:div
   (if @router/match
     (let [view (:view (:data @router/match))]
       [view @router/match]))])
