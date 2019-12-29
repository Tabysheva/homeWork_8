import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String[]> dictionary = new HashMap<>();
        dictionary.put("Красивый", new String[]{"прекрасный", "чудесный", "великолепный", "симпотичный"});
        dictionary.put("дом", new String[]{"квартира", "жилище", "аппартементы", "хижина"});
        dictionary.put("человек", new String[]{"личность", "персона", "хомосапиенс", "индивидиум"});

        HashMap<String, String[]> bigDictionary = new HashMap<>();

        Set<String> keys = dictionary.keySet();
        Iterator<String> iter = keys.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            String[] values = dictionary.get(key);
            bigDictionary.put(key, values);
            for (int i = 0; i < values.length; i++) {
                String newKey = values[i];
                ArrayList<String> newValues = new ArrayList<>(values.length);
                newValues.addAll(Arrays.asList(values));
                newValues.remove(newKey);
                newValues.add(key);
                String[] values2 = new String[newValues.size()];
                values2 = newValues.toArray(values2);
                bigDictionary.put(newKey, values2);
            }
        }
        System.out.println("Введите слово");
        Scanner sc = new Scanner(System.in
        );
        String word = sc.nextLine();
        String[] synonyms = bigDictionary.get(word);

        for (String e : synonyms) {
            System.out.println(e);

        }

    }
}

