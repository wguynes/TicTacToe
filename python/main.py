INCOMPLETE_GAME = -1
CATS_GAME = 0
DIMENSION_OF_BOARD = 3


def tic_tac_toe(board):

    paths = [
        *board,
        *[[board[j][i] for j in range(DIMENSION_OF_BOARD)] for i in range(3)],
        [board[i][i] for i in range(DIMENSION_OF_BOARD)],
        [board[DIMENSION_OF_BOARD-1-i][i] for i in range(DIMENSION_OF_BOARD)]
    ]

    for row in paths:
        winner = find_any_winner(row)
        if winner is not None:
            return winner

    list_of_all_board_spaces = [x for row in board for x in row]
    if contains_a_zero(list_of_all_board_spaces):
        return INCOMPLETE_GAME

    return CATS_GAME


def find_any_winner(values):
    if not contains_a_zero(values):
        sum_of_values = sum(values)
        if sum_of_values % DIMENSION_OF_BOARD == 0:
            return sum_of_values / DIMENSION_OF_BOARD
    return None


def contains_a_zero(values):
    return any([x == 0 for x in values])
