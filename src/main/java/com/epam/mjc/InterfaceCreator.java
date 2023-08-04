package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String str : x) {
                if (!Character.isUpperCase(str.charAt(0))) return false;
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> lst = new ArrayList<>();
            for (Integer number : x) {
                if (number % 2 == 0) {
                    lst.add(number);
                }
            }
            x.addAll(lst);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> filteredString = new ArrayList<>();
            for (String str : values) {
                if (Character.isUpperCase(str.charAt(0)) && str.endsWith(".") && str.split(" ").length > 3) {
                    filteredString.add(str);
                }
            }
            return filteredString;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for (String str : x) {
                map.put(str, str.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x, y) -> {
            List<Integer> combinedList = new ArrayList<>();
            combinedList.addAll(x);
            combinedList.addAll(y);
            return combinedList;
        };
    }
}
