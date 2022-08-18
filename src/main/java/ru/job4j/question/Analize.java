package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {
    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public static Info diff(Set<User> previous, Set<User> current) {
        int changed = 0;

        Map<Integer, String> previousMap = previous.stream().collect(
                Collectors.toMap(User::getId, User::getName));
        Map<Integer, String> currentMap = current.stream().collect(
                Collectors.toMap(User::getId, User::getName));

        long added = currentMap.entrySet()
                .stream()
                .filter(entry -> !previousMap.containsKey(entry.getKey()))
                .count();

        long deleted = previousMap.entrySet()
                .stream()
                .filter(entry -> !currentMap.containsKey(entry.getKey()))
                .count();

        for (Integer key:previousMap.keySet()) {
            if (currentMap.containsKey(key)) {
                if (!currentMap.get(key).equals(previousMap.get(key))) {
                    changed++;
                }
            }
        }

        return new Info((int) added, changed, (int) deleted);
    }
}
