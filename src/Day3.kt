/**
 * @author GrowlyX
 * @since 12/3/2022
 */
val aToZ = 'a'..'z'
val aToZCap = 'A'..'Z'

fun main()
{
    fun calculatePriority(char: Char) =
        when (true)
        {
            aToZ.contains(char) -> aToZ.indexOf(char) + 1
            aToZCap.contains(char) -> 26 + (aToZCap.indexOf(char) + 1)
            else -> throw IllegalArgumentException(
                "No match found, is the character a numeric value? ($char)"
            )
        }

    fun part1(input: List<String>): Int
    {
        var totalPriority = 0

        input.forEach {
            val chunks = it.chunked(it.length / 2)

            val first = chunks[0]
            val second = chunks[1]

            var similar = ' '

            for (char in first)
            {
                if (second.contains(char))
                {
                    similar = char
                    break
                }
            }

            totalPriority += calculatePriority(similar)
        }

        return totalPriority
    }

    fun part2(input: List<String>): Int
    {
        var totalPriority = 0

        input.chunked(3)
            .forEach { chunk ->
                var similar = ' '

                for (char in chunk.first())
                {
                    if (chunk.all { it.contains(char) })
                    {
                        similar = char
                        break
                    }
                }

                totalPriority += calculatePriority(similar)
            }

        return totalPriority
    }

    println(part1(readInput(3, 1)))
    println(part2(readInput(3, 2)))
}
