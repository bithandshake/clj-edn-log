
(ns logger.side-effects
    (:require [io.api        :as io]
              [logger.config :as config]
              [time.api      :as time]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn write!
  ; @param (string)(opt) filepath
  ; Default: "environment/log/default.log"
  ; @param (*) content
  ;
  ; @usage
  ; (write! "my-log.log" "Gone fishing")
  ([content]
   (write! config/DEFAULT-LOG-FILEPATH content))

  ([filepath content]
   (let [timestamp (time/timestamp-string)
         output    (str timestamp " " content)]
        (io/prepend-to-file! filepath output {:create? true :max-line-count config/MAX-LINE-COUNT}))))
