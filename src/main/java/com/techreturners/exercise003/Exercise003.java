package com.techreturners.exercise003;

import java.util.List;

public class Exercise003 {

    List<String> iceCreamFlavours = List.of(

        "Pistachio",
        "Raspberry Ripple",
        "Vanilla",
        "Mint Chocolate Chip",
        "Chocolate",
        "Mango Sorbet"

    );

    int getIceCreamCode(String iceCreamFlavour) throws InvalidFlavourException {

        if (iceCreamFlavours.contains(iceCreamFlavour))
            return iceCreamFlavours.indexOf(iceCreamFlavour);
        else
            throw new InvalidFlavourException("No encoding available for \"" + iceCreamFlavour + "\".");

    }

    String[] iceCreamFlavours() {
        return iceCreamFlavours.toArray(new String[0]);
    }

}
