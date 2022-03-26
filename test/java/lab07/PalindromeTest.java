package lab07;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.AlphaChars;
import net.jqwik.api.constraints.Size;
import net.jqwik.api.constraints.UniqueElements;
import org.junit.jupiter.api.Test;

class PalindromeTest {

    /*
     * Try testing the following cases:
     *  - any string, followed by the reverse of that string is a palindrome.
     *  - any string, followed by a single character, then the reverse of the string is a palindrome.
     *  - Any string made up of unique characters of length 2 or greater is not a palindrome.
     *  - Any palindrome set to uppercase is still a palindrome.
     */

    @Property
    void Reverse(@ForAll String word) {
        assertThat(Palindrome.isPalindrome(word + reverse(word))).isTrue();
    }

    @Property
    void ReverseAndChar(@ForAll String word, @ForAll char c) {
        assertThat(Palindrome.isPalindrome(word + c + reverse(word))).isTrue();
    }

    static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }
}