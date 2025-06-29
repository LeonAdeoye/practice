package com.leon;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        Exec.main(args);
        ArrList.main(args);
        Rec.main(args);
        DomainExtractor.main(args);
        TemperatureDiff.main(args);
        StockFiller.main(args);
        ResponseCheck.main(args);
        CustomerAges.main(args);
        TemperatureDiff.main(args);
        InventoryMerger.main(args);
        WordCounter.main(args);
        Articles.main(args);
        CategoryMap.main(args);
        DupEmails.main(args);
        LogCounter.main(args);
        GradesMap.main(args);
        RoleAggregator.main(args);
    }
}