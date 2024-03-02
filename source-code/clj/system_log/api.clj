
(ns system-log.api
    (:require [system-log.side-effects :as side-effects]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (system-log.side-effects/*)
(def prepend-entry! side-effects/prepend-entry!)
(def append-entry!  side-effects/append-entry!)
