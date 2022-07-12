package com.epam.rd.autotasks.words;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if (sample == null || words == null) {
            return 0;
        }

        int count = 0;
        sample = sample.trim();
        for (String word: words) {
            if (word.trim().equalsIgnoreCase(sample)) {
                count++;
            }
        }

        return count;
    }

    public static String[] splitWords(String text) {
        if (text == null || text.equals(""))
            return null;

        text = text.trim();
        if (text.equals(""))
            return null;

        Pattern pattern = Pattern.compile("[ ;:?!,.]+");
        String[] split = pattern.split(text);

        if (split.length == 0)
            return null;

        String [] newSplit = new String[1];
        boolean first = false;
        if (split[0].equals("")) {
            first = true;
            newSplit = new String[split.length - 1];
            System.arraycopy(split, 1, newSplit, 0, split.length - 1);
        }

        if (split[split.length - 1].equals("")) {
            if (first) {
                String [] newSplit1 = new String[split.length - 2];
                System.arraycopy(newSplit, 0, newSplit1, 0, split.length - 2);
                return newSplit1;
            }
            else {
                String [] newSplit1 = new String[split.length - 1];
                System.arraycopy(split, 0, newSplit1, 0, split.length - 1);
                return newSplit1;
            }

        }

        if (first)
            return newSplit;
        else
            return split;
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path.equals(""))
            return null;

        Pattern unix = Pattern.compile("((~/|/)?(([a-zA-Z_ ]+|(\\.)|(\\.\\.))/)*(([a-zA-Z_ ]+\\.[a-z]+)|(([a-zA-Z_ ]+)(/?))|\\.|\\.\\.)?)|~");
        Pattern win = Pattern.compile("(C:|\\\\|C:\\\\)?(([a-zA-Z_ ]+|\\.|\\.\\.)\\\\)*(([a-zA-Z_ ]+\\.[a-z]+)|([a-zA-Z_ ]+\\\\?)|\\.|\\.\\.)?");

        Matcher winMatcher = win.matcher(path);
        Matcher unixMatcher = unix.matcher(path);
        if (!winMatcher.matches() && !unixMatcher.matches()) {
            return null;
        }

        if (!toWin) {
            Pattern begin = Pattern.compile("C:\\\\User");
            Matcher m = begin.matcher(path);
            path = m.replaceFirst("~");

            begin = Pattern.compile("C:\\\\");
            m = begin.matcher(path);
            path = m.replaceFirst("/");

            Pattern line = Pattern.compile("\\\\");
            m = line.matcher(path);
            path = m.replaceAll("/");
        }
        else {
            Pattern begin = Pattern.compile("~");
            Matcher m = begin.matcher(path);
            String newPath = path;
            if (path.charAt(0) == '~') {
                newPath = m.replaceFirst("C:\\\\User");
            }

            if (newPath.equals(path)) {
                begin = Pattern.compile("~/");
                m = begin.matcher(path);
                path = m.replaceFirst("C:\\\\");

            }
            else {
                path = newPath;
            }

            if (path.charAt(0) == '/') {
                begin = Pattern.compile("/");
                m = begin.matcher(path);
                path = m.replaceFirst("C:\\\\");
            }

            Pattern line = Pattern.compile("/");
            m = line.matcher(path);
            path = m.replaceAll("\\\\");
        }
        return path;
    }

    public static String joinWords(String[] words) {
        if (words == null || words.length == 0)
            return null;

        StringBuilder stringBuilder = new StringBuilder("");

        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("") || words[i] == null) {
                count++;
                continue;
            }

            stringBuilder.append(words[i] + ", ");
        }
        if (count == words.length)
            return null;
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return "[" + stringBuilder.toString() + "]";
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}