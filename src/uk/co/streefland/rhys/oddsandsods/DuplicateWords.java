package uk.co.streefland.rhys.oddsandsods;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Rhys on 20/10/2016.
 */
public class DuplicateWords {

    public static void main(String[] args) {

        String string1 = "hello my name's rhys and I am awesome";
        String string2 = "hello my name is gareth and I am slightly less awesome";

        HashSet<String> hashSet = new HashSet();
        List<String>  duplicateWords = new ArrayList();

        String[] words1 = string1.split("\\W+");
        String[] words2 = string2.split("\\W+");

        for (String word: words1) {
            hashSet.add(word);
        }

        for (String word: words2) {
            if (!hashSet.add(word)) {
                duplicateWords.add(word);
            }
        }

        for (String word: duplicateWords) {
            System.out.println(word);
        }

    }
}
