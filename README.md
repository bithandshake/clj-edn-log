
# logger-api

### Overview

The <strong>logger-api</strong> is a simple log file writer for Clojure projects.

### deps.edn

```
{:deps {bithandshake/logger-api {:git/url "https://github.com/bithandshake/logger-api"
                                 :sha     "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"}}
```

### Current version

Check out the latest commit on the [release branch](https://github.com/bithandshake/logger-api/tree/release).

### Documentation

The <strong>logger-api</strong> functional documentation is [available here](documentation/COVER.md).

### Changelog

You can track the changes of the <strong>logger-api</strong> library [here](CHANGES.md).

### Index

- [How to write into a log file?](#how-to-write-into-a-log-file)

# Usage

### How to write into a log file?

The [`logger.api/write!`](documentation/clj/logger/API.md) function writes into
a log file.

- If you don't pass the log file's path, the default log file will be used.
  ('environment/log/default.log')

```
(write! "Gone fishing")
```

```
(write! "my-log.log" "Gone fishing")
```
