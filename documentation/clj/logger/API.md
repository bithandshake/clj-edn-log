
# <strong>logger.api</strong> namespace
<p>Documentation of the <strong>logger/api.clj</strong> file</p>

<strong>[README](../../../README.md) > [DOCUMENTATION](../../COVER.md) > logger.api</strong>



### write!

```
@param (string) filename
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
  [filename content]
  (let [filepath  (str config/LOG-PATH "/" filename)
        timestamp (time/timestamp-string)
        output    (str timestamp " " content)]
       (io/prepend-to-file! filepath output {:max-line-count config/MAX-LINE-COUNT})))
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
