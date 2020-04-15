(ns stufft.ui.components.simple-ul)

(defn render [li-count]
  [:ul
   (for [n (range li-count)]
     [:li {:key n} (+ n 1)])])
