
# clj-edn-log

### Overview

The <strong>clj-edn-log</strong> is a simple log file writer for Clojure projects.

### deps.edn

```
{:deps {bithandshake/clj-edn-log {:git/url "https://github.com/bithandshake/clj-edn-log"
                                  :sha     "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"}}
```

### Current version

Check out the latest commit on the [release branch](https://github.com/bithandshake/clj-edn-log/tree/release).

### Documentation

The <strong>clj-edn-log</strong> functional documentation is [available here](documentation/COVER.md).

### Changelog

You can track the changes of the <strong>clj-edn-log</strong> library [here](CHANGES.md).

# Usage

> Some parameters of the following functions and some further functions are not discussed in this file.
  To learn more about the available functionality, check out the [functional documentation](documentation/COVER.md)!

### Index

- [How to write into a log file?](#how-to-write-into-a-log-file)

### How to write into a log file?

The [`edn-log.api/write!`](documentation/clj/edn-log/API.md#write) function writes into
a log file.

- If you don't pass the log file's path, the default log file will be used:
  `environment/log/default.log`

```
(write! "Gone fishing")
```

```
(write! "my-log.log" "Gone fishing")
```

The maximum line count of log files is 500 and when it reached, the writer uses
FIFO to put the new content into a full up log file.
