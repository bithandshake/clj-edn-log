
# <strong>logger.api</strong> namespace

<strong>[README](../../../README.md) > [DOCUMENTATION](../../COVER.md) > </strong>source-code/clj/logger/api.clj

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
   (write! config/DEFAULT-LOG-FILEPATH content))

  ([filepath content]
   (let [timestamp (time/timestamp-string)
         output    (str timestamp " " content)]
        (io/prepend-to-file! filepath output {:create? true :max-line-count config/MAX-LINE-COUNT}))))
```

</details>

<details>
<summary>Require</summary>

```
(ns my-namespace (:require [logger.api :refer [write!]]))

(logger.api/write! ...)
(write!            ...)
```

</details>
