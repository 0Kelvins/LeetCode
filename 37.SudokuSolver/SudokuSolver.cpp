/**
 * 37. Sudoku Solver
 * 暴力递归
 */

#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    bool isVaild(vector<vector<char>> &board, int row, int col, char c)
    {
        for (int i = 0; i < board.size(); i++)
        {
            if (board[row][i] == c || board[i][col] == c || board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == c)
                return false;
        }
        return true;
    }

    bool doSolve(vector<vector<char>> &board)
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] == '.')
                {
                    for (char c = '1'; c <= '9'; c++)
                    {
                        if (isVaild(board, i, j, c))
                        {
                            board[i][j] = c;
                            if (doSolve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    void solveSudoku(vector<vector<char>> &board)
    {
        doSolve(board);
    }
};

int main()
{
    Solution s;
    vector<vector<char>> board = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    s.solveSudoku(board);

    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            cout << board[i][j] << " ";
        }
        cout << endl;
    }

    return 1;
}