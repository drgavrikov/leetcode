/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 */
class Problem1525 {
    fun numSplits(s: String): Int {
        val alphabetSize = 26
        val left = (0 until alphabetSize).map { 0 }.toIntArray()
        val right = (0 until alphabetSize).map { 0 }.toIntArray()

        s.forEach { ch -> right[ch - 'a']++ }
        var goodSplits = 0
        s.forEach { ch ->
            left[ch - 'a']++
            right[ch - 'a']--
            if (left.filter { it > 0 }.count() == right.filter { it > 0 }.count())
                goodSplits++
        }
        return goodSplits
    }
}

fun main() {
    val problem1525 = Problem1525()

    val actual1 = problem1525.numSplits("aacaba")
    check(actual1 == 2) { "Test 1 failed" }

    val actual2 = problem1525.numSplits("abcd")
    check(actual2 == 1) { "Test 2 failed" }
}
