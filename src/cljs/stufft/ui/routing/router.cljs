(ns stufft.ui.routing.router
  (:require [reagent.core :as reagent]
            [reitit.core :as reitit]
            [reitit.frontend.easy :as reitit-fe-easy]
            [reitit.coercion.spec :as reitit-coerce :refer [coercion]]
            [stufft.ui.routing.routes :as routes]))

(defonce match
  (reagent/atom nil))

(def options
  {:data {:coercion reitit-coerce/coercion}})

(def router
  (reitit/router routes/all options))

(defn start! []
  (reitit-fe-easy/start!
    router
    #(reset! match %)
    {:use-fragment true}))
