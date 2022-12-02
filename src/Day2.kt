/**
 * @author GrowlyX
 * @since 12/2/2022
 */
fun main()
{
    enum class Play(
        val score: Int,
        val destroys: List<Play>
    )
    {
        Rock(1, listOf(
            Play.Scissors
        )),
        
        Paper(2, listOf(
            Play.Rock
        )), 
        
        Scissors(3, listOf(
            Play.Paper
        ))
    }

    fun part1(input: List<String>): Int
    {
        val mappings = mutableMapOf(
            'A' to Play.Rock,
            'B' to Play.Paper,
            'C' to Play.Scissors,
            'X' to Play.Rock,
            'Y' to Play.Paper,
            'Z' to Play.Scissors
        )

        var score = 0

        input.forEach {
            val first = mappings[it[0]]!!
            val second = mappings[it[2]]!!

            score += first.score

            if (first == second)
            {
                score += 3
                return@forEach
            }

            if (second in first.destroys)
            {
                score += 6
                return@forEach
            }

            if (first in second.destroys)
            {
                score += 0
            }
        }

        return score
    }

    fun part2(input: List<String>): Int
    {
        return -1
    }

    println(part1(readInput(2, 1)))
    println(part2(readInput(1, 2)))
}
