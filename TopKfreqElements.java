import java.util.*;

public class TopKfreqElements {
    public static void main(String[] args) {
        String[] word = {"the","day","is","sunny","the","the","the","sunny","is","is"}; // Example input
        int k = 4; // Number of top frequent elements to find
        System.out.println("Top " + k + " frequent elements: " + topKFrequent(word, k));
    }

    private static List<String> topKFrequent(String[] word, int k) {
        if (word == null || word.length == 0 || k <= 0) {
            return List.of(); // Return an empty list if input is invalid
        }
        // Create a frequency map to count occurrences of each word
        LinkedHashMap<String, Integer> frequencyMap = new LinkedHashMap<>();
        for (String w : word) {
            frequencyMap.put(w, frequencyMap.getOrDefault(w, 0) + 1);
        }
        System.out.println(frequencyMap);
        // Sort the words by frequency and then lexicographically
        return frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().thenComparing(Map.Entry::getKey).reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();

    }
}
