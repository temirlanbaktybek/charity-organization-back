package charityorganization.__dev__;

import charityorganization.been.RecreateWorker;

public class RecreateAll {

    public static void main(String[] args) {
        try {
            RecreateWorker.recreatePostgresDatabase("sandbox", "sandbox");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
