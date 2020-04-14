(ns stufft.ui.core
  (:require [reagent.core :as reagent]
            [reagent.dom :as dom]

            [reitit.core :as reitit]
            [reitit.coercion.spec :as reitit-coerce :refer [coercion]]
            [reitit.frontend.easy :as reitit-fe-easy]

            [stufft.ui.components.app :as app :refer [render]]))

; routing below
(defonce match
  (reagent/atom nil))
; routing above

; pages below
(defn current-page []
  [:div
   (if @match
     (let [view (:view (:data @match))]
       [view @match]))])

(defn home-page []
  [:div
   [:h1 "home!"]
   [:a  {:href  (reitit-fe-easy/href ::about)}  "About"]])

(defn about-page []
  [:div
   [:h1 "about"]])
; pages above

; routing below
(def routes
  [["/"
    {:name ::home
     :view home-page}]
   ["/about"
    {:name ::about
     :view about-page}]])

(def router-options
  {:data {:coercion reitit-coerce/coercion}})

(def router
  (reitit/router routes router-options))
; routing above

(defn mount-app! []
  (reitit-fe-easy/start!
    router
    (fn [m] (reset! match m))
    {:use-fragment true})
  (dom/render
    [current-page]
    (.getElementById js/document "app")))

(defn ^:dev/after-load start []
  (mount-app!))

(defn main! []
  (-> js/document
      (.addEventListener "DOMContentLoaded" mount-app!)))
