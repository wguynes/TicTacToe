import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.forAll

class GameTests : DescribeSpec({
    describe("game") {

        val game = Game()
        val arbPlayers: Arb<Int> = Arb.int(1..2)

        it("winner returns player if player wins first row") {
            forAll(arbPlayers) { player ->
                game.winner(
                    arrayOf(
                        intArrayOf(player, player, player),
                        intArrayOf(0, 0, 0),
                        intArrayOf(0, 0, 0)
                    )
                ) == player
            }
        }

        it("winner returns player if player wins second row") {
            forAll(arbPlayers) { player ->
                game.winner(
                    arrayOf(
                        intArrayOf(0, 0, 0),
                        intArrayOf(player, player, player),
                        intArrayOf(0, 0, 0)
                    )
                ) == player
            }
        }

        it("winner returns player if player wins third row") {
            forAll(arbPlayers) { player ->
                game.winner(
                    arrayOf(
                        intArrayOf(0, 0, 0),
                        intArrayOf(0, 0, 0),
                        intArrayOf(player, player, player)
                    )
                ) == player
            }
        }

        it("winner returns player if player wins first column") {
            forAll(arbPlayers) { player ->
                game.winner(
                    arrayOf(
                        intArrayOf(player, 0, 0),
                        intArrayOf(player, 0, 0),
                        intArrayOf(player, 0, 0)
                    )
                ) == player
            }
        }

        it("winner returns player if player wins second column") {
            forAll(arbPlayers) { player ->
                game.winner(
                    arrayOf(
                        intArrayOf(0, player, 0),
                        intArrayOf(0, player, 0),
                        intArrayOf(0, player, 0)
                    )
                ) == player
            }
        }

        it("winner returns player if player wins third column") {
            forAll(arbPlayers) { player ->
                game.winner(
                    arrayOf(
                        intArrayOf(0, 0, player),
                        intArrayOf(0, 0, player),
                        intArrayOf(0, 0, player)
                    )
                ) == player
            }
        }

        it("winner returns player if player wins descending diagonal") {
            forAll(arbPlayers) { player ->
                game.winner(
                    arrayOf(
                        intArrayOf(player, 0, 0),
                        intArrayOf(0, player, 0),
                        intArrayOf(0, 0, player)
                    )
                ) == player
            }
        }

        it("winner returns player if player wins ascending diagonal") {
            forAll(arbPlayers) { player ->
                game.winner(
                    arrayOf(
                        intArrayOf(0, 0, player),
                        intArrayOf(0, player, 0),
                        intArrayOf(player, 0, 0)
                    )
                ) == player
            }
        }

        it("winner returns zero if cats game") {
            val board: Array<IntArray> = arrayOf(
                intArrayOf(2, 1, 1),
                intArrayOf(1, 2, 2),
                intArrayOf(1, 2, 1),
            )

            game.winner(board) shouldBe 0
        }

        it("winner returns negative one if incomplete game") {
            val board: Array<IntArray> = arrayOf(
                intArrayOf(2, 1, 1),
                intArrayOf(1, 2, 2),
                intArrayOf(1, 2, 0),
            )

            game.winner(board) shouldBe -1
        }
    }
})
