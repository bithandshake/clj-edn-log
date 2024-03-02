
(ns edn-log.side-effects
    (:require [edn-log.config :as config]
              [io.api         :as io]
              [time.api       :as time]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn prepend-entry!
  ; @note
  ; Automatically marks the given entry with the actual timestamp.
  ;
  ; @description
  ; Prepends the given entry to a specific (or the default) log file.
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
  ; "2020-04-20T16:20:00.123Z Gone fishing\n..."
  ;
  ; @usage
  ; (prepend-entry! "Gone fishing" {:filepath "my-log.log"})
  ; =>
  ; "2020-04-20T16:20:00.123Z Gone fishing\n..."
  ;
  ; @return (string)
  ([entry]
   (prepend-entry! entry {}))

  ([entry {:keys [filepath max-lines] :or {filepath config/DEFAULT-LOG-FILEPATH max-lines config/DEFAULT-MAX-LINE-COUNT}}]
   (let [timestamp (time/timestamp-string)
         output    (str timestamp" "entry)]
        (io/prepend-to-file! filepath output {:create? true :max-line-count max-lines}))))

(defn append-entry!
  ; @note
  ; Automatically marks the given entry with the actual timestamp.
  ;
  ; @description
  ; Appends the given entry to a specific (or the default) log file.
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
  ; "...\n2020-04-20T16:20:00.123Z Gone fishing"
  ;
  ; @usage
  ; (append-entry! "Gone fishing" {:filepath "my-log.log"})
  ; =>
  ; "...\n2020-04-20T16:20:00.123Z Gone fishing"
  ;
  ; @return (string)
  ([entry]
   (append-entry! entry {}))

  ([entry {:keys [filepath max-lines] :or {filepath config/DEFAULT-LOG-FILEPATH max-lines config/DEFAULT-MAX-LINE-COUNT}}]
   (let [timestamp (time/timestamp-string)
         output    (str timestamp" "entry)]
        (io/append-to-file! filepath output {:create? true :max-line-count max-lines}))))
