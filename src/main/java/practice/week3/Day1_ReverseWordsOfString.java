package practice.week3;

import jdk.nashorn.internal.runtime.options.Option;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1_ReverseWordsOfString {
    public String reverseWords(String s) {
        List<String> list = Stream.of(s.trim().split("\\s"))
                .map(x -> x.trim()).filter(x -> x.length()!=0)
            .collect(Collectors.toList());
        System.out.println(list);
//        StringBuilder sb = new StringBuilder();
        Collections.reverse(list);
        System.out.println(list);
        Optional<String> res = list.stream().reduce((x, y) -> x + " " + y);

        return res.orElse("");
    }

    public static void main(String[] args) {
        String reversed = new Day1_ReverseWordsOfString().reverseWords("sky is blue");
        System.out.println(reversed);
        System.out.println(reversed.length());
        System.out.println("sky is blue".length());
    }
}
