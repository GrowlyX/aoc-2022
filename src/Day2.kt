/**
 * @author GrowlyX
 * @since 12/2/2022
 */
enum class Play(val score: Int)
{
    Paper(2),
    Rock(1),
    Scissors(3);

    fun destroys() = values()
        .getOrNull(ordinal + 1)
        ?: Paper

    fun destroyedBy() = values()
        .getOrNull(ordinal - 1)
        ?: Scissors
}

val mappings = mutableMapOf(
    'A' to Play.Rock, 'B' to Play.Paper, 'C' to Play.Scissors,
    'X' to Play.Rock, 'Y' to Play.Paper, 'Z' to Play.Scissors
)

fun main()
{
    fun part1(input: List<String>): Int
    {
        var score = 0

        input.forEach {
            val enemy = mappings[it[0]]!!
            val friendly = mappings[it[2]]!!

            score += friendly.score
            score += when (true)
            {
                enemy == friendly -> 3
                friendly.destroys() == enemy -> 6
                else -> 0
            }
        }

        return score
    }

    fun part2(input: List<String>): Int
    {
        var score = 0

        input.forEach {
            val opponent = mappings[it[0]]!!

            score += when (it[2])
            {
                // requires a draw
                'Y' -> opponent.score + 3
                // requires a loss
                'X' -> opponent.destroys().score
                // requires a win
                'Z' -> opponent.destroyedBy().score + 6
                else -> 0
            }
        }

        return score
    }

    println(part1(readInput(2, 1)))
    println(part2(readInput(2, 2)))
}
