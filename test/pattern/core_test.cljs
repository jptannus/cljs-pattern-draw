(ns pattern.core-test
  (:require [doo.runner :refer-macros [doo-tests]]
            [pattern.utils-test]))

(enable-console-print!)

(doo-tests 'pattern.utils-test)
