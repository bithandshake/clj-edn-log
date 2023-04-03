
# clj-logger

### Overview

The <strong>clj-logger</strong> is a simple log file writer for Clojure projects.

### deps.edn

```
{:deps {bithandshake/clj-logger {:git/url "https://github.com/bithandshake/clj-logger"
                                 :sha     "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"}}
```

### Current version

Check out the latest commit on the [release branch](https://github.com/bithandshake/clj-logger/tree/release).

### Documentation

The <strong>clj-logger</strong> functional documentation is [available here](documentation/COVER.md).

### Changelog

You can track the changes of the <strong>clj-logger</strong> library [here](CHANGES.md).

### Index

- [How to write into a log file?](#how-to-write-into-a-log-file)

# Usage

### How to write into a log file?

The [`logger.api/write!`](documentation/clj/logger/API.md#write) function writes into
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
