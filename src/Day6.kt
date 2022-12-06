/**
 * @author GrowlyX
 * @since 12/2/2022
 */
fun main()
{
    fun parseWithMaxCharIndex(
        input: List<String>, mci: Int
    ): Int
    {
        val text = input.first()
        var selected = -1

        for (index in mci..text.length - 1)
        {
            val indices = ((index - mci)..index).toList()
            val mappedToChars = indices
                .map { text[it] }
                .toSet()

            if (mappedToChars.size == mci + 1)
            {
                selected = index + 1
                break
            }
        }

        return selected
    }

    fun part1(input: List<String>) = parseWithMaxCharIndex(input, 3)
    fun part2(input: List<String>) = parseWithMaxCharIndex(input, 13)

    println(part1(readInput(6, 1)))
    println(part2(readInput(6, 2)))
}
