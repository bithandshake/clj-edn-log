
(ns edn-log.api
    (:require [edn-log.side-effects :as side-effects]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (edn-log.side-effects/*)
(def prepend-entry! side-effects/prepend-entry!)
(def append-entry!  side-effects/append-entry!)
