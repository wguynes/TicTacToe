import unittest

from main import tic_tac_toe


class Tests(unittest.TestCase):

    def test_complete_board_with_no_winner_returns_zero(self):
        result = tic_tac_toe([
            [1, 2, 1],
            [1, 2, 2],
            [2, 1, 1]])
        self.assertEqual(0, result)

    def test_incomplete_game_with_no_winner_returns_negative_one(self):
        result = tic_tac_toe([
            [1, 2, 1],
            [1, 2, 2],
            [2, 1, 0]])
        self.assertEqual(-1, result)

    def test_one_wins_first_row_returns_one(self):
        result = tic_tac_toe([
            [1, 1, 1],
            [0, 0, 0],
            [0, 0, 0]])
        self.assertEqual(1, result)

    def test_one_wins_second_row_returns_one(self):
        result = tic_tac_toe([
            [0, 0, 0],
            [1, 1, 1],
            [0, 0, 0]])
        self.assertEqual(1, result)

    def test_one_wins_third_row_returns_one(self):
        result = tic_tac_toe([
            [0, 0, 0],
            [0, 0, 0],
            [1, 1, 1]])
        self.assertEqual(1, result)

    def test_two_wins_first_row_returns_two(self):
        result = tic_tac_toe([
            [2, 2, 2],
            [0, 0, 0],
            [0, 0, 0]])
        self.assertEqual(2, result)

    def test_one_wins_first_column_returns_one(self):
        result = tic_tac_toe([
            [1, 0, 0],
            [1, 0, 0],
            [1, 0, 0]])
        self.assertEqual(1, result)

    def test_two_wins_first_column_returns_two(self):
        result = tic_tac_toe([
            [2, 0, 0],
            [2, 0, 0],
            [2, 0, 0]])
        self.assertEqual(2, result)

    def test_one_wins_descending_diagonal_returns_one(self):
        result = tic_tac_toe([
            [1, 0, 0],
            [0, 1, 0],
            [0, 0, 1]])
        self.assertEqual(1, result)

    def test_one_wins_ascending_diagonal_returns_one(self):
        result = tic_tac_toe([
            [0, 0, 1],
            [0, 1, 0],
            [1, 0, 0]])
        self.assertEqual(1, result)


if __name__ == '__main__':
    unittest.main()