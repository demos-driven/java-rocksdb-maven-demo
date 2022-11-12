import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;

/**
 * Copyright (C) 2022 Urban Compass, Inc.
 */

public class Application {

  private static final RocksDB rocksDB = openRocksDB();

  private static RocksDB openRocksDB() {
    // loads the RocksDB C++ library
    RocksDB.loadLibrary();

    try (final Options options = new Options().setCreateIfMissing(true)) {
      final RocksDB rocksDB = RocksDB.open(options, "./rocksdb");
      System.out.println("Open rocksdb successfully.");
      return rocksDB;
    } catch (RocksDBException e) {
      System.err.println("open rocksdb error: " + e);
      return null;
    }
  }

  private static void createCollection() throws RocksDBException {
    String collectionId = "1";
    String collection = "{'name':'Litong Collection Demo1'}";

    final byte[] value = rocksDB.get(collectionId.getBytes());
    if (value == null) {
      rocksDB.put(collectionId.getBytes(), collection.getBytes());
    }
  }

  private static void readCollection() throws RocksDBException {
    String collectionId = "1";
    final byte[] value = rocksDB.get(collectionId.getBytes());
    if (value != null) {
      System.out.printf("collectionId %s => %s%n", collectionId, new String(value));
    } else {
      System.out.printf("collectionId %s not exist%n", collectionId);
    }
  }

  private static void updateCollection() throws RocksDBException {
    String collectionId = "1";
    String collection = "{'collectionId':'1','name':'Litong Collection Demo1'}";
    rocksDB.put(collectionId.getBytes(), collection.getBytes());
  }

  private static void deleteCollection() throws RocksDBException {
    String collectionId = "1";
    rocksDB.delete(collectionId.getBytes());
  }

  public static void main(String[] args) throws RocksDBException {
    assert rocksDB != null;

    createCollection();
    readCollection();

    updateCollection();
    readCollection();

    deleteCollection();
    readCollection();

    rocksDB.close();
    System.out.println("Close rocksdb successfully.");
  }
}
