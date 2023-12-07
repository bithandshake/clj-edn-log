
(ns edn-log.api
    (:require [edn-log.side-effects :as side-effects]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (edn-log.side-effects)
(def write! side-effects/write!)
