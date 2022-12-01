/**
 * @author GrowlyX
 * @since 11/30/2022
 */
fun main()
{
    fun part1(input: List<String>): Int
    {
        val greatest = mutableListOf(0)

        input.forEach {
            if (it.isEmpty())
            {
                greatest += 0
                return@forEach
            }

            greatest[greatest.size - 1] =
                greatest.last() + it.toInt()
        }

        return greatest.max()
    }

    fun part2(input: List<String>): Int
    {
        val greatest = mutableListOf(0)

        input.forEach {
            if (it.isEmpty())
            {
                greatest += 0
                return@forEach
            }

            greatest[greatest.size - 1] =
                greatest.last() + it.toInt()
        }

        return greatest
            .sortedByDescending { it }
            .take(3)
            .sum()
    }

    println(part1(readInput(1, 1)))
    println(part2(readInput(1, 2)))
}
