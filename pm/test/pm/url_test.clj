(ns pm.url-test
  (:require [clojure.test :refer :all]
            [pm.url :refer :all]))

(deftest test-url-encode
  (is (= (url-encode "foo/bar") "foo%2Fbar"))
  (is (= (url-encode "foo bar") "foo+bar")))

(deftest test-query-string
  (is (= (query-string {:q "foo/bar"}) "q=foo%2Fbar"))
  (is (= (query-string {:q "foo/bar" :p "a b"}) "q=foo%2Fbar&p=a+b"))
  (let [mapping {:q "foo.io" :p "pass" "user:" "xavier" "cat:" "game"}
        expected "q=foo.io&p=pass&user%3A=xavier&cat%3A=game"]
    (is (= (query-string mapping) expected))))
