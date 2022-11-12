# RocksDB

## What is RocksDB

RocksDB is a storage engine with key/value interface, where keys and values are arbitrary byte
streams. It is a C++ library. It was developed at Facebook based on LevelDB and provides
backwards-compatible support for LevelDB APIs.

RocksDB supports various storage hardware, with fast flash as the initial focus. It uses a Log
Structured Database Engine for storage, is written entirely in C++, and has a Java wrapper called
RocksJava. See [RocksJava Basics](https://github.com/facebook/rocksdb/wiki/RocksJava-Basics).

## Execute the application

```bash
mvn clean compile exec:java
```

## Reference links

- https://github.com/facebook/rocksdb/wiki
- https://github.com/facebook/rocksdb/wiki/RocksJava-Basics
- https://github.com/facebook/rocksdb/tree/main/java/samples/src/main/java