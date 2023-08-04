package com.epam.rd.autotasks;


import java.util.*;

public class Words {

    public String countWords(List<String> lines) {
        StringTokenizer tokenizerForLines = new StringTokenizer(lines.toString(), "[] .,‘’(“—/:?!;*)'\\\"-");

        Map<String, Integer> countWordsMap = new HashMap<>();

        while (tokenizerForLines.hasMoreTokens()) {
            String str = tokenizerForLines.nextToken().toLowerCase();
            if (str.length() > 3) {
                Integer value = countWordsMap.getOrDefault(str, 0);
                countWordsMap.put(str, ++value);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(countWordsMap.entrySet());

        //sort
        list.sort(Map.Entry.<String, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey()));

        //join string together
        StringJoiner joinedString = new StringJoiner("\n");
        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getValue() > 9) {
                joinedString.add(entry.getKey() + " - " + entry.getValue());
            }
        }
        return joinedString.toString();
    }
}