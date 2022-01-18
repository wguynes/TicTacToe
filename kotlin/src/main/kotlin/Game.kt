class Game {

    private var catsGame = 0
    private var incompleteGame = -1

    private fun Array<IntArray>.copy() = map { it.clone() }.toTypedArray()

    private fun transpose(xs: Array<IntArray>): Array<IntArray> {
        val cols = xs[0].size
        val rows = xs.size
        return Array(cols) { j ->
            IntArray(rows) { i ->
                xs[i][j]
            }
        }
    }

    private fun descDiagonal(xs: Array<IntArray>): IntArray {
        val rows = xs.size
        return IntArray(rows) { i ->
            xs[i][i]
        }
    }

    private fun ascDiagonal(xs: Array<IntArray>): IntArray {
        val rows = xs.size
        return IntArray(rows) { i ->
            xs[xs.size-1-i][i]
        }
    }

    fun winner(board: Array<IntArray>): Int {

        val paths = board.copy() + transpose(board) + descDiagonal(board) + ascDiagonal(board)

        paths.forEach {
            val set = it.toHashSet();
            if (!set.contains(0) && set.count() == 1) {
                return set.first();
            }
        }

        val containsZero = board.map { it.toTypedArray() }.toTypedArray().flatten().toHashSet().contains(0)
        return if (containsZero) incompleteGame else catsGame
    }
}
