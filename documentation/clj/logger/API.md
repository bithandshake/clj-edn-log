
# <strong>logger.api</strong> namespace
<p>Documentation of the <strong>logger/api.clj</strong> file</p>

<strong>[README](../../../README.md) > [DOCUMENTATION](../../COVER.md) > logger.api</strong>



### write!

```
@param (string)(opt) filepath
Default: "environment/log/default.log"
@param (*) content
```

```
@usage
(write! "my-log.log" "Gone fishing")
```

<details>
<summary>Source code</summary>

```
(defn write!
  ([content]
   (write! DEFAULT-LOG-FILEPATH content))

  ([filepath content]
   (let [timestamp (time/timestamp-string)
         output    (str timestamp " " content)]
        (io/prepend-to-file! filepath output {:create? true :max-line-count config/MAX-LINE-COUNT}))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [logger.api :as logger :refer [write!]]))

(logger/write! ...)
(write!        ...)
```

</details>
