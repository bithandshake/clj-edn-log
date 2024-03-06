
(ns system-log.side-effects
    (:require [io.api            :as io]
              [system-log.config :as config]
              [time.api          :as time]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn prepend-entry!
  ; @note
  ; Automatically marks the given entry with the actual timestamp.
  ;
  ; @description
  ; - Prepends the given log entry to a specific (or the default) log file.
  ; - Returns the content of the updated log file.
  ;
  ; @param (*) entry
  ; @param (map)(opt) options
  ; {:filepath (string)(opt)
  ;   Default: "environment/log/default.log"
  ;  :max-lines (integer)(opt)
  ;   Default: 4096}
  ;
  ; @usage
  ; (prepend-entry! "Gone fishing")
  ; =>
  ; "2020-04-20T16:20:00.123Z\nGone fishing\n..."
  ;
  ; @usage
  ; (prepend-entry! "Gone fishing" {:filepath "my-log.log"})
  ; =>
  ; "2020-04-20T16:20:00.123Z\nGone fishing\n..."
  ;
  ; @return (string)
  ([entry]
   (prepend-entry! entry {}))

  ([entry {:keys [filepath max-lines] :or {filepath config/DEFAULT-LOG-FILEPATH max-lines config/DEFAULT-MAX-LINE-COUNT}}]
   (let [timestamp (time/timestamp-string)
         output    (str timestamp"\n"entry)]
        (io/prepend-to-file! filepath output {:create? true :max-line-count max-lines}))))

(defn append-entry!
  ; @note
  ; Automatically marks the given entry with the actual timestamp.
  ;
  ; @description
  ; - Appends the given log entry to a specific (or the default) log file.
  ; - Returns the content of the updated log file.
  ;
  ; @param (*) entry
  ; @param (map)(opt) options
  ; {:filepath (string)(opt)
  ;   Default: "environment/log/default.log"
  ;  :max-lines (integer)(opt)
  ;   Default: 4096}
  ;
  ; @usage
  ; (append-entry! "Gone fishing")
  ; =>
  ; "...\n2020-04-20T16:20:00.123Z\nGone fishing"
  ;
  ; @usage
  ; (append-entry! "Gone fishing" {:filepath "my-log.log"})
  ; =>
  ; "...\n2020-04-20T16:20:00.123Z\nGone fishing"
  ;
  ; @return (string)
  ([entry]
   (append-entry! entry {}))

  ([entry {:keys [filepath max-lines] :or {filepath config/DEFAULT-LOG-FILEPATH max-lines config/DEFAULT-MAX-LINE-COUNT}}]
   (let [timestamp (time/timestamp-string)
         output    (str timestamp"\n"entry)]
        (io/append-to-file! filepath output {:create? true :max-line-count max-lines}))))
