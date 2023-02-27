package charityorganization.__dev__;

import charityorganization.__worker__.InitializeWorker;

public class Initialize {

    public static void main(String[] args) {
        try {
            InitializeWorker.personTableName = "person";

            InitializeWorker.initializePostgresDatabase("charity", "postgres");
        } catch (Exception e) {
            throw new RuntimeException("685BFvOL3B :: could not initialized ", e);
        }
    }
}
