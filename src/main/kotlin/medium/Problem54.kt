package medium

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/spiral-matrix/
 */
class Problem54 {

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val n = matrix.size
        val m = matrix[0].size

        val result = mutableListOf<Int>()

        var top = 0
        var bottom = n - 1
        var left = 0
        var rigth = m - 1

        while (true) {
            for (col in left..rigth) result.add(matrix[top][col])
            top++
            if (top > bottom) break

            for (row in top..bottom) result.add(matrix[row][rigth])
            rigth--
            if (left > rigth) break

            for (col in rigth downTo left) result.add(matrix[bottom][col])
            bottom--
            if (top > bottom) break

            for (row in bottom downTo top) result.add(matrix[row][left])
            left++
            if (left > rigth) break
        }
        return result
    }
}
