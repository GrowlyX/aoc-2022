/**
 * @author GrowlyX
 * @since 12/2/2022
 */
fun main()
{
    fun part1(input: List<String>): Int
    {
        val text = input.first()
        var selected = -2

        for (index in 3..text.length - 1)
        {
            val indices = ((index - 3)..index).toList()
            val mappedToChars = indices
                .map { text[it] }
                .toSet()

            if (mappedToChars.size == 4)
            {
                selected = index
                break
            }
        }

        return selected
    }

    fun part2(input: List<String>): Int
    {
        return -1
    }

    println(part1(readInput(6, 1)))
    println(part2(readInput(6, 2)))
}
