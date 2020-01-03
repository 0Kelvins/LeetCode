/**
 * 36. Valid Sudoku
 */

#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    bool isValidSudoku(vector<vector<char>> &board)
    {
        bool row[9][10] = {0};   // 行使用数字标记
        bool col[9][10] = {0};   // 列使用数字标记
        bool block[9][10] = {0}; // 每个3*3块使用数字标记

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] == '.')
                    continue;
                int num = board[i][j] - '0';
                int b = (i / 3) * 3 + j / 3; // 所在块号
                if (row[i][num] || col[j][num] || block[b][num])
                {
                    // cout << i + 1 << " " << j + 1 << " " << board[i][j] << " " << b << endl;
                    // for (int i = 0; i < 9; i++)
                    // {
                    //     for (int j = 1; j < 10; j++)
                    //     {
                    //         cout << row[i][j] << " ";
                    //     }
                    //     cout << endl;
                    // }
                    // cout << endl;
                    // for (int i = 0; i < 9; i++)
                    // {
                    //     for (int j = 1; j < 10; j++)
                    //     {
                    //         cout << col[i][j] << " ";
                    //     }
                    //     cout << endl;
                    // }
                    // cout << endl;
                    // for (int i = 0; i < 9; i++)
                    // {
                    //     for (int j = 1; j < 10; j++)
                    //     {
                    //         cout << block[i][j] << " ";
                    //     }
                    //     cout << endl;
                    // }
                    return false;
                }
                else
                {
                    row[i][num] = true;
                    col[j][num] = true;
                    block[b][num] = true;
                }
            }
        }

        return true;
    }
};

int main()
{
    Solution s;
    vector<vector<char>> board1 = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    cout << (s.isValidSudoku(board1) ? "true" : "false") << endl;

    vector<vector<char>> board2 = {
        {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    cout << (s.isValidSudoku(board2) ? "true" : "false") << endl;

    return 0;
}