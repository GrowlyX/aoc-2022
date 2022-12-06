/**
 * @author GrowlyX
 * @since 12/2/2022
 */
fun main()
{
    fun parseIntoUniqueCharRanged(
        input: List<String>, range: Int
    ): Int
    {
        val text = input.firstOrNull()
            ?: return -2

        for (index in range until text.length)
        {
            val indices = (index - range)..index
            val characters = indices
                .distinctBy { text[it] }

            if (characters.size == range + 1)
            {
                return index + 1
            }
        }

        return -1
    }

    fun part1(input: List<String>) =
        parseIntoUniqueCharRanged(input, 3)
    fun part2(input: List<String>) =
        parseIntoUniqueCharRanged(input, 13)

    println(part1(readInput(6, 1)))
    println(part2(readInput(6, 2)))
}
