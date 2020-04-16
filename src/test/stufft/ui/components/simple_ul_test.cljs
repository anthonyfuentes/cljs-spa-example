(ns stufft.ui.components.simple-ul-test
  (:require [cljs.test :refer (deftest is)]
            ["enzyme-adapter-react-16.3" :as enzyme-adapter]
            ["enzyme" :as enzyme :refer [shallow]]
            [reagent.core :as reagent :refer [as-element]]
            [stufft.ui.components.simple-ul :as ul :refer [render]]))

(enzyme/configure
  (clj->js {:adapter (enzyme-adapter.)}))

(defn shallow-render [n]
  (-> (ul/render n) as-element shallow))

(deftest renders-successfully
  (shallow-render 3))

(deftest has-simple-ul-class
  (-> (shallow-render 1)
      (.hasClass "simple-ul")
      is))

(deftest renders-n-many-li
  (let [n 4]
    (-> (shallow-render n)
        (.find "li")
        .-length
        (= n)
        is)))
