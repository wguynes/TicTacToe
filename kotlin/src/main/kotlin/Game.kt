class Game {

    private var catsGame = 0
    private var incompleteGame = -1

    private fun Array<IntArray>.copy() = map { it.clone() }.toTypedArray()

    private fun transpose(originalArray: Array<IntArray>): Array<IntArray> {
        val cols = originalArray[0].size
        val rows = originalArray.size
        return Array(cols) { j ->
            IntArray(rows) { i ->
                originalArray[i][j]
            }
        }
    }

    private fun descDiagonal(originalArray: Array<IntArray>): IntArray {
        return IntArray(originalArray.size) { i ->
            originalArray[i][i]
        }
    }

    private fun ascDiagonal(originalArray: Array<IntArray>): IntArray {
        return IntArray(originalArray.size) { i ->
            originalArray[originalArray.size - 1 - i][i]
        }
    }

    fun winner(board: Array<IntArray>): Int {

        val paths = board.copy() + transpose(board) + descDiagonal(board) + ascDiagonal(board)

        paths.forEach {
            val set = it.toHashSet()
            if (!set.contains(0) && set.count() == 1) {
                return set.first()
            }
        }

        val containsZero = board.map { it.toTypedArray() }.toTypedArray().flatten().toHashSet().contains(0)
        return if (containsZero) incompleteGame else catsGame
    }
}
