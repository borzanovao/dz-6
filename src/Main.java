import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] wordslist = new String[]{"mama", "brother", "papa", "dodo", "poor"};
        Set<Character> result = searchDoubleLetters(wordslist);
        System.out.print("Unique symbols are: ");
        for (Character uniqueSymbols : result) {
            System.out.print(" " + uniqueSymbols);
        }

    }

    public static Set<Character> searchDoubleLetters(String[] wordslist) {

        List<String> doubleSymbols = new ArrayList<>();

        for (String analysisWord : wordslist) {
            char[] symbol = analysisWord.toCharArray();

            Map<Character, Integer> mapCounter = new HashMap<>();
            for (Character key : symbol) {
                if (mapCounter.containsKey(key)) {
                    Integer value = mapCounter.get(key) + 1;
                    mapCounter.put(key, value);
                } else {
                    mapCounter.put(key, 1);
                }
            }

            boolean isDoubleLetters = true;
            for (Character key : mapCounter.keySet()) {
                if (mapCounter.get(key) % 2 != 0) {
                    isDoubleLetters = false;
                    break;
                }
            }

            if (isDoubleLetters) {
                doubleSymbols.add(analysisWord);
                if (doubleSymbols.size() == 2) {
                    break;
                }
            }
        }
        Set<Character> mySet = new HashSet<>();


        int count = doubleSymbols.size();
        String word;
        int i = 0;
        while (i < count) {
            word = doubleSymbols.get(i++);

            for (Character character : word.toCharArray()) {
                mySet.add(character);
            }
        }
        return mySet;
    }

}
