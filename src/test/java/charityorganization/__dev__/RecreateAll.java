package charityorganization.__dev__;

import charityorganization.__worker__.RecreateWorker;

public class RecreateAll {

    public static void main(String[] args) {
        try {
            RecreateWorker.recreatePostgresDatabase("charity", "postgres");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
