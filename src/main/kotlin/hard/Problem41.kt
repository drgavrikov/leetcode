package hard

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/first-missing-positive/description/
 */
class Problem41 {

    fun firstMissingPositive(nums: IntArray): Int {
        var index = 0
        while (index < nums.size) {
            val correct = nums[index] - 1
            if (nums[index] in 1 .. nums.size && nums[index] != nums[correct]) {
                val temp = nums[index]
                nums[index] = nums[correct]
                nums[correct] = temp
            } else index++
        }

        for (i in nums.indices) {
            if (i + 1 != nums[i]) return i + 1
        }
        return nums.size + 1
    }
}
