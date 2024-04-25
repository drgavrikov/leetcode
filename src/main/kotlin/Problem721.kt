import java.util.*
import kotlin.math.min

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/accounts-merge/
 */
class Problem721 {
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val parents = IntArray(accounts.size) { it }

        val emailToNameId = hashMapOf<String, SortedSet<Int>>()
        accounts.forEachIndexed { nameId, emails ->
            emails.drop(1).forEach { email ->
                emailToNameId.putIfAbsent(email, sortedSetOf())
                emailToNameId.getValue(email).add(nameId)
            }
        }

        fun findSet(v: Int): Int {
            return if (v == parents[v]) v else findSet(parents[v])
        }

        fun unionSet(u: Int, v: Int) {
            val setU = findSet(u)
            val setV = findSet(v)
            val min = min(setU, setV)
            parents[setU] = min
            parents[setV] = min
        }

        emailToNameId.forEach { (_, nameIds) ->
            nameIds.zipWithNext().forEach { (prev, next) -> unionSet(prev, next) }
        }
        val result = Array<SortedSet<String>>(accounts.size) { sortedSetOf() }
        accounts.forEachIndexed { index, emails -> result[findSet(index)].addAll(emails.drop(1)) }

        return result
            .mapIndexed { index, emails -> listOf(accounts[index][0]) + emails }
            .filter { it.size > 1 }
            .toList()
    }
}

fun main() {
    val problem721 = Problem721()

    val accounts = listOf(
        listOf("John", "johnsmith@mail.com", "john_newyork@mail.com"),
        listOf("John", "johnsmith@mail.com", "john00@mail.com"),
        listOf("Mary", "mary@mail.com"),
        listOf("John", "johnnybravo@mail.com")
    )
    val result = listOf(
        listOf("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
        listOf("Mary", "mary@mail.com"),
        listOf("John", "johnnybravo@mail.com")
    )
    check(problem721.accountsMerge(accounts) == result) { "Test 1 failed" }
}

