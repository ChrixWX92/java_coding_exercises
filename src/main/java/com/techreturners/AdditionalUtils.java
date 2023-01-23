package com.techreturners;

public class AdditionalUtils {

    /**
     * Accidentally wrote this one after misunderstanding the requirements of the first method of Exercise 1.
     * @param sentence - Originally called 'word'. The input String to have each of its space-separated words capitalised.
     * @return The input string altered so that the first letter of every word is capitalised.
     */

    public static String capitalizeWords(String sentence) {

        char[] charArray =  sentence.toCharArray();

        for (int i = 0 ; i < charArray.length ; i++) {
            // Checks the first character, or every character that immediately follows a space
            if (i == 0 || charArray[i-1] == ' ') {
                if (!Character.isUpperCase(charArray[i])) {
                    charArray[i] = Character.toUpperCase(charArray[i]);
                }
            }
        }

        return String.valueOf(charArray);

    }

}
