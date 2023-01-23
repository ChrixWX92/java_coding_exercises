package com.techreturners.exercise005;

public class Exercise005 {

    public boolean isPangram(String input) {

        int alphabetSize = 26;

        // Java's IntStream functionality allows for this entire operation in one line, which is pretty sweet. 🤘

        return input.toLowerCase() // Converting everything to lower case, since the exercise isn't case-sensitive.
                .chars() // This method gives us an IntStream of the equivalent int values of the input String's chars (mostly just doing this so I can work with IntStream).
                .filter(character -> (character >= 'a' && character <= 'z')) // Filtering only values between 97 and 122 (char (ASCII) equivalents 'a' through 'z').
                .distinct() // Keeping only distinct characters so duplicates don't affect the count.
                .count() == alphabetSize; // <--- Returning the result of this boolean.

    }

}
