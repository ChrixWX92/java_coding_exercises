package com.techreturners.exercise001;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Exercise001 {

    public String capitalizeWord(String word) {

        char[] charArray = word.toCharArray();

        if (!Character.isUpperCase(charArray[0])) {
            charArray[0] = Character.toUpperCase(charArray[0]);
        }

        return String.valueOf(charArray);

    }

    public String generateInitials(String firstName, String lastName) {

        return String.valueOf(

            new char[]{
                    Character.toUpperCase(firstName.charAt(0)),
                    '.',
                    Character.toUpperCase(lastName.charAt(0))
            }

        );

    }

    public double addVat(double originalPrice, double vatRate) {

        // Using BigDecimal as this would be standard for financial calculations. VAT is rounded down from the nearest
        // half of the lowest denomination unit in most countries, so I believe RoundingMode.HALF_DOWN would be the most
        // broadly accurate choice for this exercise, given that country information is not available.

        return new BigDecimal(originalPrice * (1 + (vatRate/100))).setScale(2, RoundingMode.HALF_DOWN).doubleValue();

    }

    public String reverse(String sentence) {

        return new StringBuilder(sentence).reverse().toString();

    }

    public int countLinuxUsers(List<User> users) {

        // Using Streams here seems like a more elegant solution than brute force iteration.

        return (int) users.stream().filter(u -> u.getType().equals("Linux")).count();

    }

}
