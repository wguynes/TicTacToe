using System.Collections.Generic;
using System.Linq;

public static class Checker
{
    private const int BoardDimension = 3;
    private const int IncompleteGame = -1;
    private const int CatsGame = 0;

    public static int Winner(IEnumerable<int> board)
    {
        var boardList = board.ToList();
        var pathsToCheck = new List<IEnumerable<int>>
        {
            GetRow(boardList, 0),
            GetRow(boardList, 1),
            GetRow(boardList, 2),
            GetColumn(boardList, 0),
            GetColumn(boardList, 1),
            GetColumn(boardList, 2),
            GetDescendingDiagonal(boardList),
            GetAscendingDiagonal(boardList)
        };

        // ReSharper disable once ForeachCanBePartlyConvertedToQueryUsingAnotherGetEnumerator
        foreach (var path in pathsToCheck)
        {
            var list = path.ToList();
            if (ContainsAZero(list))
            {
                continue;
            }

            var sum = list.Sum();
            if (sum % BoardDimension == 0)
            {
                return sum / BoardDimension;
            }
        }

        return ContainsAZero(boardList) ? IncompleteGame : CatsGame;
    }

    private static IEnumerable<int> GetRow(IEnumerable<int> boardList, int rowIndex)
    {
        return boardList.Where((_, i) => i / BoardDimension == rowIndex);
    }

    private static IEnumerable<int> GetColumn(IEnumerable<int> boardList, int columnIndex)
    {
        return boardList.Where((_, i) => i % BoardDimension == columnIndex);
    }

    private static IEnumerable<int> GetDescendingDiagonal(IEnumerable<int> boardList)
    {
        return boardList.Where((_, i) => i % BoardDimension == i / BoardDimension);
    }

    private static IEnumerable<int> GetAscendingDiagonal(IEnumerable<int> boardList)
    {
        return boardList.Where((_, i) => BoardDimension - 1 - i % BoardDimension == i / BoardDimension);
    }

    private static bool ContainsAZero(IEnumerable<int> row)
    {
        return row.Any(x => x == 0);
    }
}
