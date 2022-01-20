from enum import Enum

INCOMPLETE_GAME = -1
CATS_GAME = 0
DIMENSION_OF_BOARD = 3


class Direction(Enum):
    DESCENDING = 1
    ASCENDING = 2


def tic_tac_toe(board):
    possible_win_paths = [
        *board,
        *transpose(board),
        diagonal_to_list(board, Direction.DESCENDING),
        diagonal_to_list(board, Direction.ASCENDING)
    ]

    for path in possible_win_paths:
        winner = find_any_winner(path)
        if winner is not None:
            return winner

    all_board_spaces = [x for row in board for x in row]
    return INCOMPLETE_GAME if 0 in all_board_spaces else CATS_GAME


def diagonal_to_list(board, direction):
    return [board[i if direction == Direction.DESCENDING else DIMENSION_OF_BOARD - 1 - i][i]
            for i in range(DIMENSION_OF_BOARD)]


def transpose(board):
    return [[board[j][i] for j in range(DIMENSION_OF_BOARD)] for i in range(DIMENSION_OF_BOARD)]


def find_any_winner(values):
    if 0 not in values:
        value_set = set(values)
        if len(value_set) == 1:
            return next(iter(value_set), None)

    return None
