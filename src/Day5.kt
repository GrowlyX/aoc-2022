/**
 * @author GrowlyX
 * @since 12/2/2022
 */
fun main()
{
    fun parseAndReturnLastChars(
        input: List<String>, retainOrder: Boolean = false
    ): List<Char>
    {
        val containerListIndex = input
            .indexOfFirst {
                it[1] == '1'
            }

        if (containerListIndex == -1)
        {
            throw IllegalStateException(
                "No container list line found ( 1 2 3 ...)"
            )
        }

        val directions = input
            .subList(
                fromIndex = containerListIndex + 2,
                toIndex = input.lastIndex + 1
            )

        val containerListString = input[containerListIndex]
        val containerList = containerListString[containerListString.length - 2].digitToInt()

        val crateContainers = mutableListOf<MutableList<Char>>()

        for (container in 1..containerList)
        {
            val index = 1 + (4 * (container - 1))
            val characters = mutableListOf<Char>()

            for (row in 0 until containerListIndex)
            {
                val crate = input[row]
                    .getOrNull(index)
                    ?: ' '

                if (crate !== ' ')
                {
                    characters += crate
                }
            }

            characters.reverse()
            crateContainers += characters
        }

        for (direction in directions)
        {
            val parsed = direction.split(" ")

            val toRemove = parsed[1].toInt()
            val removeFrom = parsed[3].toInt() - 1
            val relocateTo = parsed[5].toInt() - 1

            val takenFromContainer = crateContainers[removeFrom]

            crateContainers[relocateTo] +=
                takenFromContainer.takeLast(toRemove).let {
                    if (retainOrder) it else it.reversed()
                }

            (1..toRemove).forEach { _ ->
                takenFromContainer.removeLastOrNull()
            }
        }

        return crateContainers.map { it.last() }
    }

    fun part1(input: List<String>) =
        parseAndReturnLastChars(input)
            .joinToString("")

    fun part2(input: List<String>) =
        parseAndReturnLastChars(input, retainOrder = true)
            .joinToString("")

    println(part1(readInput(5, 1)))
    println(part2(readInput(5, 2)))
}
