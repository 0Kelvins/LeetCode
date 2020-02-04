/**
 * 74. Search a 2D Matrix
 * 先对列首进行二分查找，再查找对应行会更快一点，但是复杂度量级一样
 */
#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    bool searchMatrix(vector<vector<int>> &matrix, int target)
    {
        int n = matrix.size();
        if (n == 0)
            return false;
        int m = matrix[0].size();
        if (m == 0 || target < matrix[0][0] || target > matrix[n - 1][m - 1])
            return false;
        int low = 0, high = n * m - 1;
        while (low < high) // 注意循环条件
        {
            int mid = (low + high + 1) / 2; // 向上取整
            if (target < matrix[mid / m][mid % m])
                high = mid - 1;
            else
                low = mid;
        }
        return target == matrix[low / m][low % m];
    }
};

int main()
{
    Solution s;
    vector<vector<int>> matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
    cout << s.searchMatrix(matrix, 3) << endl;
    cout << s.searchMatrix(matrix, 13) << endl;
    return 0;
}