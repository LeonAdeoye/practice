package com.leon;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;

// Merge two lists of (itemId, quantity) into a single Map<String, Integer> summing quantities per item.
public class InventoryMerger {
    private record Inventory(String itemId, int quantity) {}
    private Inventory[] first = {new Inventory("item1", 10), new Inventory("item2", 20), new Inventory("item3", 30)};
    private Inventory[] second = {new Inventory("item1", 27), new Inventory("item2", 2), new Inventory("item3", 5)};

    public void merge()
    {
        List<Inventory> invents = new ArrayList<>();
        Stream.of(first).forEach(inventory -> invents.add(inventory));
        Stream.of(second).forEach(inventory -> invents.add(inventory));
        invents.stream().collect(Collectors.groupingBy(Inventory::itemId)).values()
            .forEach(inventories -> System.out.println(inventories.get(0).itemId() + ": " + inventories.stream().collect(Collectors.summarizingInt(Inventory::quantity)).getSum()));
    }

    public void merge2()
    {
        Map<String, Integer> inventoryMap = Stream.concat(Arrays.stream(first), Arrays.stream(second))
                .collect(Collectors.toMap(
                        Inventory::itemId,
                        Inventory::quantity,
                        Integer::sum
                ));

        inventoryMap.forEach((key, val) -> System.out.println(key + ": " + val));
    }

    public static void main(String... args)
    {
        InventoryMerger im = new InventoryMerger();
        im.merge();
        im.merge2();
    }


}
