(ns one-function-to-rule-them-all)

(defn concat-elements [a-seq]
  (reduce concat a-seq))

(defn str-cat [a-seq]
  (if (empty? a-seq)
    ""
    (reduce (fn [a b] (str a " " b)) a-seq)))

(defn my-interpose [x a-seq]
  (rest (reduce (fn [acc elem] (conj (conj acc x) elem)) [] a-seq)))

(defn my-count [a-seq]
  (let [counter (fn [acc elem]
                  (if (nil? elem)
                    acc
                    (inc acc)))]
    (reduce counter 0 a-seq)))

(defn my-reverse [a-seq]
  (reduce conj '() a-seq))

(defn min-max-element [a-seq]
  (vector (reduce min a-seq) (reduce max a-seq)))

(defn insert [sorted-seq n]
  (if (empty? sorted-seq)
    (seq [n])
    (if (> n (first sorted-seq))
      (cons (first sorted-seq)
            (insert (rest sorted-seq) n))
      (cons n sorted-seq))))

(defn insertion-sort [a-seq]
  (reduce insert '() a-seq))

(defn parity [a-seq]
  (reduce
    (fn [a-set elem]
      (if (contains? a-set elem)
        (disj a-set elem)
        (conj a-set elem)))
    #{} a-seq))

(defn minus
  ([x] (- x))
  ([x y] (- x y)))

(defn count-params [& params]
  (count params))

(defn my-* [& params]
  (reduce * 1 params))

(defn pred-and [& params]
  (fn [x]
    ((fn [x preds]
       (if (empty? preds)
         true
         (if ((first preds) x)
           (recur x (rest preds))
           false)))
      x params)))

(defn my-map [f a-seq]
  )