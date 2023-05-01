
# logger.api Clojure namespace

##### [README](../../../README.md) > [DOCUMENTATION](../../COVER.md) > logger.api

### Index

- [write!](#write)

### write!

```
@param (string)(opt) filepath
Default: "environment/log/default.log"
@param (*) content
```

```
@usage
(write! "Gone fishing")
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
         output    (str timestamp" "content)]
        (io/prepend-to-file! filepath output {:create? true :max-line-count config/DEFAULT-MAX-LINE-COUNT}))))
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

---

This documentation is generated with the [clj-docs-generator](https://github.com/bithandshake/clj-docs-generator) engine.

