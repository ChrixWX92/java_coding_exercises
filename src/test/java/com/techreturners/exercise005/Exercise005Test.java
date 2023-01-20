package com.techreturners.exercise005;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise005Test {

    private Exercise005 ex005;

    @BeforeEach
    public void setup() {
        ex005 = new Exercise005();
    }

    @Test
    public void checkEmptySentenceIsNotAPangram() {
        assertFalse(ex005.isPangram(""));
    }

    @Test
    public void checkPerfectLowerCaseSentenceIsAPangram() {
        assertTrue(ex005.isPangram("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void checkPerfectUpperCaseSentenceIsAPangram() {
        assertTrue(ex005.isPangram("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

    @Test
    public void checkSentenceWithLowerCaseIsAPangram() {
        assertTrue(ex005.isPangram("the quick brown fox jumps over the lazy dog"));
    }

    @Test
    public void checkSentenceWithMixedUpperAndLowerCaseIsAPangram() {
        assertTrue(ex005.isPangram("The Five boXing wiZards Jump QuicklY"));
    }

    @Test
    public void checkSentenceWithMissingLetterXIsNotAPangram() {
        assertFalse(ex005.isPangram("the quick brown fo jumps over the lazy dog"));
    }

    @Test
    public void checkSentenceWithMissingLetterHIsNotAPangram() {
        assertFalse(ex005.isPangram("five boxing wizards jump quickly at it"));
    }

    @Test
    public void checkSentenceWithUnderscoresIsAPangram() {
        assertTrue(ex005.isPangram("the_quick_brown_fox_jumps_over_the_lazy_dog"));
    }

    @Test
    public void checkSentenceWithNumbersIsAPangram() {
        assertTrue(ex005.isPangram("the 1 quick brown fox jumps over the 2 lazy dogs"));
    }

    // Additional tests below:

    @Test
    public void checkEmptyStringIsAPangram() {
        assertFalse(ex005.isPangram(""));
    }

    @Test
    public void checkDoubledStringIsAPangram() {
        String testString ="The quick brown fox jumps over the lazy dog.";
        testString = testString.concat(testString);
        assertTrue(ex005.isPangram(testString));
    }

    @Test
    public void checkASCIIIsAPangram() {
        String asciiString = new String("The quick brown fox jumps over the lazy dog.".getBytes(StandardCharsets.US_ASCII));
        assertTrue(ex005.isPangram(asciiString));
    }

    @Test
    public void checkUTF8IsAPangram() {
        String utf8String = new String("The quick brown fox jumps over the lazy dog.".getBytes(StandardCharsets.UTF_8));
        assertTrue(ex005.isPangram(utf8String));
    }

    @Test
    public void checkUTF16IsAPangram() {
        String utf16String = new String("The quick brown fox jumps over the lazy dog.".getBytes(StandardCharsets.UTF_16));
        assertTrue(ex005.isPangram(utf16String));
    }

    @Test
    public void checkUTF32IsAPangram() {
        String utf32String = null;
        try {
            utf32String = new String("The quick brown fox jumps over the lazy dog.".getBytes("UTF-32"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        assert utf32String != null;
        assertTrue(ex005.isPangram(utf32String));
    }

    @Test
    public void checkStringWithFourByteCharactersIsAPangram() {
        String testString = "\uD808\uDE19The \uD808\uDEBCquick \uD809\uDC2Bbrown \uD809\uDC6Efox \uD809\uDC74jumps over the lazy dog.";
        assertTrue(ex005.isPangram(testString));
    }

    //@Disabled You may want to disable this test if your JVM's heap size doesn't support the below array
    @Test
    public void checkBloatedStringIsAPangram() {

        char[] maxArray = new char[Integer.MAX_VALUE/8];
        Arrays.fill(maxArray, 'A');
        String maxString = Arrays.toString(maxArray).concat("The quick brown fox jumps over the lazy dog.");
        assertTrue(ex005.isPangram(maxString));

    }

}
