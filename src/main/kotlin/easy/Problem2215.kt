package easy

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/find-the-difference-of-two-arrays/description/
 */
class Problem2215 {

    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        return listOf(
            (nums1.toSet() - nums2.toSet()).toList(),
            (nums2.toSet() - nums1.toSet()).toList()
        )
    }
}
