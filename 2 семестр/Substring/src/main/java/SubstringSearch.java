import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.function.ToIntFunction;
import java.security.MessageDigest;

public class SubstringSearch {

    private SubstringSearch() {
    }

    public static Integer[] boyerMoore(String string, String substring) {
        Objects.requireNonNull(string);
        Objects.requireNonNull(substring);
        int patternLength = substring.length();
        int stringLength = string.length();

        if (patternLength > stringLength || stringLength == 0) {
            return new Integer[0];
        }
        if (patternLength == 0) {
            throw new IllegalArgumentException("Pattern length should be > 0");
        }

        Map<Character, Integer> offsetMap = new HashMap<>();

        for (int i = 1; i <= patternLength - 1; i++) {
            char ch = substring.charAt(patternLength - i - 1);
            if (!offsetMap.containsKey(ch)) {
                offsetMap.put(ch, i);
            }
        }
        char ch = substring.charAt(patternLength - 1);
        if (!offsetMap.containsKey(ch)) {
            offsetMap.put(ch, patternLength);
        }

        List<Integer> result = new ArrayList<>();
        int i = patternLength - 1;
        while (i < stringLength) {
            if (string.charAt(i) == substring.charAt(patternLength - 1)) {
                if (helperBoyerMoore(string, i, substring)) {
                    result.add(i - patternLength + 1);
                    i++;
                } else {
                    i += offsetMap.get(substring.charAt(patternLength - 1));
                }
            } else {
                i += offsetMap.getOrDefault(string.charAt(i), patternLength);
            }
        }

        return result.toArray(new Integer[0]);
    }

    private static boolean helperBoyerMoore(String string, int index, String pattern) {
        for (int i = pattern.length() - 1; i >= 0; i--) {
            if (string.charAt(index) == pattern.charAt(i)) {
                index--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static Integer[] rabinKarp(String string, String substring, ToIntFunction<String> hashFunction) {
        Objects.requireNonNull(string);
        Objects.requireNonNull(substring);
        Objects.requireNonNull(hashFunction);
        int substringLength = substring.length();
        int stringLength = string.length();

        if (substringLength > stringLength || stringLength == 0) {
            return new Integer[0];
        }
        if (substringLength == 0) {
            throw new IllegalArgumentException("Pattern length should be > 0");
        }

        Integer hashSubstring = hashFunction.applyAsInt(substring);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= stringLength - substringLength; i++) {
            String sub = string.substring(i, i + substringLength);
            Integer hashSub = hashFunction.applyAsInt(sub);
            boolean test = sub.equals(substring);
            if (hashSubstring.equals(hashSub)) {
                result.add(i);
            }
        }
        return result.toArray(new Integer[0]);
    }

    public static Integer[] rabinKarp(String string, String substring) throws NoSuchAlgorithmException {
        Objects.requireNonNull(string);
        Objects.requireNonNull(substring);
        int substringLength = substring.length();
        int stringLength = string.length();

        if (substringLength > stringLength || stringLength == 0) {
            return new Integer[0];
        }
        if (substringLength == 0) {
            throw new IllegalArgumentException("Pattern length should be > 0");
        }
        BigInteger fixPrime = BigInteger.valueOf(47);
        BigInteger hashSubstring = hashRabinKarp(substring, fixPrime);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= stringLength - substringLength; i++) {
            if (hashSubstring.equals(
                    hashRabinKarp(string.substring(i, i + substringLength), fixPrime)
            )) {
                result.add(i);
            }
        }
        return result.toArray(new Integer[0]);
    }

    public static BigInteger hashRabinKarp(String string, BigInteger prime) throws NoSuchAlgorithmException {
        Iterator<Integer> iterator = string.chars().iterator();
        BigInteger d = BigInteger.valueOf(26);
        BigInteger result = BigInteger.ZERO;
        BigInteger subsum = BigInteger.ZERO;
        int m = string.length();
        for (int i = 0; i < m; i++) {
            int n = iterator.next();
            subsum = d.multiply(subsum).add(BigInteger.valueOf(n)).mod(prime); // p^m-i-1 * ci
            result = result.add(subsum);
        }
        return result;
    }

    public static Integer[] knuthMorrisPratt(String string, String pattern) {
        Objects.requireNonNull(string);
        Objects.requireNonNull(pattern);
        int patternLength = pattern.length();
        int stringLength = string.length();

        if (patternLength > stringLength || stringLength == 0) {
            return new Integer[0];
        }
        if (patternLength == 0) {
            throw new IllegalArgumentException("Pattern length should be > 0");
        }
        List<Integer> result = new ArrayList<>();
        int[] prefTable = getPrefixTableKnuthMorrisPratt(pattern);
        int pointer = 0;
        for (int i = 0; i < stringLength; i++) {
            while (true) {
                if (pattern.charAt(pointer) == string.charAt(i)) {
                    pointer++;
                    if (pointer == patternLength) {
                        i = i + 1 - patternLength;
                        result.add(i);
                        pointer = 0;
                    }
                    break;
                }
                if (pointer == 0) {
                    break;
                }
                pointer = prefTable[pointer - 1];
            }
        }

        return result.toArray(new Integer[0]);
    }

    private static int[] getPrefixTableKnuthMorrisPratt(String str) {
        int[] table = new int[str.length()];
        int k = 0;
        for (int i = 1; i < str.length(); i++) {
            while (k > 0 && str.charAt(i) != str.charAt(k)) {
                k = table[k - 1];
            }
            if (str.charAt(i) == str.charAt(k)) {
                k++;
            }
            table[i] = k;
        }

        return table;
    }

    public static Integer[] finiteAutomata(String string, String pattern) {
        Objects.requireNonNull(string);
        Objects.requireNonNull(pattern);
        int patternLength = pattern.length();
        int stringLength = string.length();

        if (patternLength > stringLength || stringLength == 0) {
            return new Integer[0];
        }
        if (patternLength == 0) {
            throw new IllegalArgumentException("Pattern length should be > 0");
        }

        // get state table
        char[] chars = pattern.toCharArray();
        Set<Character> charsSet = new HashSet<>();
        for(char c : chars) {
            charsSet.add(c);
        }
        List<Character> uniqueCharsList = new ArrayList<>(charsSet);
        int uniqueChars = charsSet.size();

        int[][] stateTable = new int[patternLength + 1][uniqueChars];

        for(int state = 0; state < patternLength; state++) {
            for(int i = 0; i < uniqueChars; i++) {
                stateTable[state][i] = getNextState(pattern, state, uniqueCharsList.get(i));
            }
        }

        List<Integer> result = new ArrayList<>();
        int state = 0;
        for(int i = 0; i < stringLength; i++) {
            if (!charsSet.contains(string.charAt(i))) {
                state = 0;
                continue;
            }

            state = stateTable[state][uniqueCharsList.indexOf(string.charAt(i))];
            if (state == patternLength) {
                i = i - patternLength + 1;
                result.add(i);
                state = 0;
            }
        }

        return result.toArray(new Integer[0]);
    }

    private static int getNextState(String str, int state, char ch) {

        if (state < str.length() && ch == str.charAt(state)) {
            return state + 1;
        }

        for(int newState = state; newState > 0; newState--) {
            if (str.charAt(newState - 1) == ch) {
                int i;
                for(i = 0; i < newState - 1; i++) {
                    if (str.charAt(i) != str.charAt(state - newState + 1 + i)) {
                        break;
                    }
                }
                if (i == newState - 1) {
                    return newState;
                }
            }
        }

        return 0;
    }

}
