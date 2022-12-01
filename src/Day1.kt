/**
 * @author GrowlyX
 * @since 11/30/2022
 */
fun main()
{
    fun parseElfCalories(input: List<String>): List<Int>
    {
        val greatest = mutableListOf(0)

        input.forEach {
            if (it.isEmpty())
            {
                greatest += 0
                return@forEach
            }

            greatest[greatest.lastIndex] =
                greatest.last() + it.toInt()
        }

        return greatest
    }

    fun part1(input: List<String>): Int
    {
        return parseElfCalories(input).max()
    }

    fun part2(input: List<String>): Int
    {
        return parseElfCalories(input)
            .sortedDescending()
            .take(3)
            .sum()
    }

    println(part1(readInput(1, 1)))
    println(part2(readInput(1, 2)))
}
