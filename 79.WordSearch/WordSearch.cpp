/**
 * 79. Word Search
 * 考虑到修改board的过程可能会造成危险，使用flag来做标记，一定要&引用，不然递归会反复copy形参超时
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
private:
    int n, m, l;
    bool trace(vector<vector<char>> &board, string word, vector<vector<int>> &flag, int k, int i, int j)
    {
        if (i < 0 || i >= n || j < 0 || j >= m || flag[i][j] == 1 || word[k] != board[i][j])
            return false;
        if (++k == l)
            return true;
        flag[i][j] = 1;
        bool r = trace(board, word, flag, k, i - 1, j)     // 向上
                 || trace(board, word, flag, k, i, j - 1)  // 向左
                 || trace(board, word, flag, k, i + 1, j)  // 向下
                 || trace(board, word, flag, k, i, j + 1); // 向右
        flag[i][j] = 0;
        return r;
    }

public:
    bool exist(vector<vector<char>> &board, string word)
    {
        n = board.size();
        l = word.size();
        if (n == 0 || l == 0)
            return false;
        m = board[0].size();
        if (m == 0)
            return false;
        vector<vector<int>> flag(n, vector<int>(m, 0));
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (trace(board, word, flag, 0, i, j))
                    return true;
            }
        }
        return false;
    }
};

int main()
{
    Solution s;
    vector<vector<char>> board = {{'A', 'B', 'C', 'E'},
                                  {'S', 'F', 'C', 'S'},
                                  {'A', 'D', 'E', 'E'}};
    string words[] = {"ABCCED", "SEE", "ABCB"};
    for (int i = 0; i < 3; i++)
        cout << s.exist(board, words[i]) << endl;
    return 0;
}