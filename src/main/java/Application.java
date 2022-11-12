import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;

/**
 * Copyright (C) 2022 Urban Compass, Inc.
 */

public class Application {
  private static RocksDB openRocksDB() {
    // loads the RocksDB C++ library
    RocksDB.loadLibrary();

    try (final Options options = new Options().setCreateIfMissing(true)) {
      try (final RocksDB rocksDB = RocksDB.open(options, "./rocksdb")) {
        System.out.println("Open rocksdb successfully.");
        return rocksDB;
      }
    } catch (RocksDBException e) {
      System.out.println("open rocksdb error: " + e);
      return null;
    }
  }

  public static void main(String[] args) {
    final RocksDB rocksDB = openRocksDB();
  }
}
