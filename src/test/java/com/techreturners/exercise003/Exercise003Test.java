package com.techreturners.exercise003;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class Exercise003Test {

    private Exercise003 ex003;

    @BeforeEach
    public void setup() {
        ex003 = new Exercise003();
    }

    @Test
    public void checkGetIceCreamCodeForMintChocolateChip() {
        String iceCreamFlavour = "Mint Chocolate Chip";
        int expected = 3;

        assertEquals(expected, ex003.getIceCreamCode(iceCreamFlavour));
    }

    @Test
    public void checkGetIceCreamCodeForMangoSorbet() {
        String iceCreamFlavour = "Mango Sorbet";
        int expected = 5;

        assertEquals(expected, ex003.getIceCreamCode(iceCreamFlavour));
    }

    @Test
    public void checkGetIceCreamCodeForRaspberryRipple() {
        String iceCreamFlavour = "Raspberry Ripple";
        int expected = 1;

        assertEquals(expected, ex003.getIceCreamCode(iceCreamFlavour));
    }

    @Test
    public void checkPickMultipleIceCreamFlavours() {

        String[] expected = { "Pistachio", "Raspberry Ripple", "Vanilla", "Mint Chocolate Chip", "Chocolate", "Mango Sorbet" };

        assertArrayEquals(expected, ex003.iceCreamFlavours());
    }

    // Extension tests below:

    @Test
    public void checkGetIceCreamCodeForVanilla() {

        String iceCreamFlavour = "Vanilla";
        int expected = 2;

        assertEquals(expected, ex003.getIceCreamCode(iceCreamFlavour));

    }

    @Test
    public void checkGetRandomFlavour() {

        Random random = new Random();
        int randomFlavour = random.nextInt(ex003.iceCreamFlavours.size());
        String expected = ex003.iceCreamFlavours.get(randomFlavour);

        assertEquals(expected, ex003.iceCreamFlavours()[randomFlavour]);

    }

    @Test
    public void checkGetIceCreamCodeForBubblegum() {

        String iceCreamFlavour = "Bubblegum";

        assertThrows(InvalidFlavourException.class, () -> ex003.getIceCreamCode(iceCreamFlavour));

    }


}
