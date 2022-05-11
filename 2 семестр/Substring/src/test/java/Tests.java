import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.util.stream.IntStream;

public class Tests {
    Utils.TestCases[] testCases = {
            new Utils.TestCases("персональные данные",           "данные",          new Integer[]{13}),
            new Utils.TestCases("метадата",                      "дата",            new Integer[]{4}),
            new Utils.TestCases("персональные данные переданы",  "дан",             new Integer[]{13, 24}),
            new Utils.TestCases("ддддддд",                       "д",               new Integer[]{0, 1, 2, 3, 4, 5, 6}),
            new Utils.TestCases("дададад",                       "д",               new Integer[]{0, 2, 4, 6}),
            new Utils.TestCases("abababababa",                   "aba",             new Integer[]{0, 2, 4, 6, 8}),
            new Utils.TestCases("abababababa",                   "ab",              new Integer[]{0, 2, 4, 6, 8}),
            new Utils.TestCases("aaaaaaaaaaa",                   "aaa",             new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8}),
            new Utils.TestCases("Pabcabcabcabcabc",              "abcabcabcabcabc", new Integer[]{1}),
            new Utils.TestCases("get set put yet pet wet let",   "et",              new Integer[]{1, 5, 13, 17, 21, 25}),
            new Utils.TestCases("",                              "",                new Integer[]{}),
//            new Utils.TestCases("aaa",                           "",                new Integer[]{}), // may expect Exception or empty Array
            new Utils.TestCases("aaabbbcccaabbccabc",            "aab",             new Integer[]{1, 9}),
            new Utils.TestCases("aaaaaaaaaaaaaaaaaa",            "b",               new Integer[]{}),
            new Utils.TestCases("abcabcabbcabcabcabcab",         "abcab",           new Integer[]{0, 3, 10, 13, 16}),
            new Utils.TestCases("TEXT IN UPPER CASE",            "text",            new Integer[]{}),
            new Utils.TestCases("русский текст and english text"," ",               new Integer[]{7, 13, 17, 25}),
            new Utils.TestCases("русская 'а' and english 'a'",   "a",               new Integer[]{12, 25}),
            new Utils.TestCases("text",                          "texttext",        new Integer[]{}),
            new Utils.TestCases("AABAACAADAABAABA",              "AABA",            new Integer[]{0, 9, 12}),
            // FIXME: maybe should to remove this last crazy test :)
            new Utils.TestCases(
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+
                            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "a",
                    IntStream.rangeClosed(0, 255).boxed().toList().toArray(new Integer[0])),
            new Utils.TestCases(
                    "Какой то большой текст об очень интересных вещах. Кажется, что это" +
                            "просто текст для теста, но может это что то больше. Ведь этот "+
                            "небольшой абзац мог быть частью какой то книги о теории тестир-" +
                            "ровании. Может это абзац из теории TDD. А может это вообще нахо-" +
                            "дится в официальной документации JUnit... Или все же это просто " +
                            "тест в очередной лабараторной студента по программированию",
                    "те", new Integer[]{17, 34, 73, 83, 177, 184, 219, 319})
    };

    @Test
    @DisplayName("Should be true")
    void Substring_test_0() {
    }

    @Test
    @DisplayName("BoyerMoore: All in one")
    void Substring_boyerMoore_allInOne() {
        for(Utils.TestCases test : testCases) {
            Assertions.assertArrayEquals(test.expected, SubstringSearch.boyerMoore(test.string, test.pattern));
        }
        Assertions.assertThrows(NullPointerException.class, () ->
                SubstringSearch.boyerMoore("null", null));
        Assertions.assertThrows(NullPointerException.class, () ->
                SubstringSearch.boyerMoore(null, "null"));
        Assertions.assertThrows(NullPointerException.class, () ->
                SubstringSearch.boyerMoore(null, null));
    }

    @Test
    @DisplayName("RabinKarp: All in one (.polynomialHash)")
    void Substring_rabinKarp_allInOne_polynomialHash() throws NoSuchAlgorithmException {
        for(Utils.TestCases test : testCases) {
            Assertions.assertArrayEquals(test.expected, SubstringSearch.rabinKarp(test.string, test.pattern));
        }
        Assertions.assertThrows(NullPointerException.class, () ->
                SubstringSearch.rabinKarp("null", null));
        Assertions.assertThrows(NullPointerException.class, () ->
                SubstringSearch.rabinKarp(null, "null"));
        Assertions.assertThrows(NullPointerException.class, () ->
                SubstringSearch.rabinKarp(null, null));
    }

    @Test
    @DisplayName("RabinKarp: All in one (.hashCode)")
    void Substring_rabinKarp_allInOne_hashCode() {
        for(Utils.TestCases test : testCases) {
            Assertions.assertArrayEquals(test.expected, SubstringSearch.rabinKarp(test.string, test.pattern, String::hashCode));
        }
        Assertions.assertThrows(NullPointerException.class, () ->
                SubstringSearch.rabinKarp("null", null, String::hashCode));
        Assertions.assertThrows(NullPointerException.class, () ->
                SubstringSearch.rabinKarp(null, "null", String::hashCode));
        Assertions.assertThrows(NullPointerException.class, () ->
                SubstringSearch.rabinKarp("null", "null", null));
        Assertions.assertThrows(NullPointerException.class, () ->
                SubstringSearch.rabinKarp(null, null, String::hashCode));
    }

    @Test
    @DisplayName("KnuthMorrisPratt: All in one")
    void Substring_knuthMorrisPratt_allInOne() {
        for(Utils.TestCases test : testCases) {
            Assertions.assertArrayEquals(test.expected, SubstringSearch.knuthMorrisPratt(test.string, test.pattern));
        }
        Assertions.assertThrows(NullPointerException.class, () ->
                SubstringSearch.knuthMorrisPratt("null", null));
        Assertions.assertThrows(NullPointerException.class, () ->
                SubstringSearch.knuthMorrisPratt(null, "null"));
        Assertions.assertThrows(NullPointerException.class, () ->
                SubstringSearch.knuthMorrisPratt(null, null));
    }

    @Test
    @DisplayName("FiniteAutomata: All in one")
    void Substring_finiteAutomata_allInOne() {
        for(Utils.TestCases test : testCases) {
            Assertions.assertArrayEquals(test.expected, SubstringSearch.finiteAutomata(test.string, test.pattern));
        }
        Assertions.assertThrows(NullPointerException.class, () ->
                SubstringSearch.finiteAutomata("null", null));
        Assertions.assertThrows(NullPointerException.class, () ->
                SubstringSearch.finiteAutomata(null, "null"));
        Assertions.assertThrows(NullPointerException.class, () ->
                SubstringSearch.finiteAutomata(null, null));
    }
}
