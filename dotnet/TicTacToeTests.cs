using System.Collections.Generic;
using Xunit;

public class TicTacToeTests
{
    [Fact]
    public void GivenOneWinsFirstRowReturnsOne()
    {
        var result = Checker.Winner(new List<int>
        {
            1, 1, 1,
            0, 0, 0,
            0, 0, 0
        });
        Assert.Equal(1, result);
    }

    [Fact]
    public void GivenOneWinsSecondRowReturnsOne()
    {
        var result = Checker.Winner(new List<int>
        {
            0, 0, 0,
            1, 1, 1,
            0, 0, 0
        });
        Assert.Equal(1, result);
    }

    [Fact]
    public void GivenOneWinsFirstColumnReturnsOne()
    {
        var result = Checker.Winner(new List<int>
        {
            1, 0, 0,
            1, 0, 0,
            1, 0, 0
        });
        Assert.Equal(1, result);
    }

    [Fact]
    public void GivenOneWinsDescendingDiagonalReturnsOne()
    {
        var result = Checker.Winner(new List<int>
        {
            1, 0, 0,
            0, 1, 0,
            0, 0, 1
        });
        Assert.Equal(1, result);
    }

    [Fact]
    public void GivenOneWinsAscendingDiagonalReturnsOne()
    {
        var result = Checker.Winner(new List<int>
        {
            0, 0, 1,
            0, 1, 0,
            1, 0, 0
        });
        Assert.Equal(1, result);
    }

    [Fact]
    public void GivenTwoWinsFirstRowReturnsTwo()
    {
        var result = Checker.Winner(new List<int>
        {
            2, 2, 2,
            0, 0, 0,
            0, 0, 0
        });
        Assert.Equal(2, result);
    }

    [Fact]
    public void GivenIncompleteGameReturnsNegativeOne()
    {
        var result = Checker.Winner(new List<int>
        {
            1, 2, 1,
            1, 2, 2,
            2, 1, 0
        });
        Assert.Equal(-1, result);
    }

    [Fact]
    public void GivenCatsGameReturnsZero()
    {
        var result = Checker.Winner(new List<int>
        {
            1, 2, 1,
            1, 2, 2,
            2, 1, 1
        });
        Assert.Equal(0, result);
    }
}
