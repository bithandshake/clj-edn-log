
;; -- Namespace ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

(ns logger.side-effects
    (:require [io.api        :as io]
              [logger.config :as config]
              [time.api      :as time]))



;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn write!
  ; @param (string) filename
  ; @param (*) content
  [filename content]
  (let [filepath  (str config/LOG-PATH "/" filename)
        timestamp (time/timestamp-string)
        output    (str timestamp " " content)]
       (io/prepend-to-file! filepath output {:max-line-count config/MAX-LINE-COUNT})))
