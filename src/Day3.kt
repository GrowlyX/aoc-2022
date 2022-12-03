/**
 * @author GrowlyX
 * @since 12/3/2022
 */
val aToZ = 'a'..'z'
val aToZCap = 'A'..'Z'

fun main()
{
    fun part1(input: List<String>): Int
    {
        var totalPriority = 0

        input.forEach {
            // prereq- contains two chunks
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

            totalPriority += when (true)
            {
                aToZ.contains(similar) -> aToZ.indexOf(similar) + 1
                aToZCap.contains(similar) -> 26 + (aToZCap.indexOf(similar) + 1)
                else -> throw IllegalArgumentException(
                    "No match found, is the character a numeric value? ($similar)"
                )
            }
        }

        return totalPriority
    }

    fun part2(input: List<String>): Int
    {
        return -1
    }

    println(part1(readInput(3, 1)))
    println(part2(readInput(3, 2)))
}
