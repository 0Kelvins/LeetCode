/**
 * 1005 Spell It Right
 */
#include <iostream>
#include <vector>
using namespace std;

int main()
{
    string n;
    cin >> n;
    int nlen = n.size(), sum = 0;
    for (int i = 0; i < nlen; i++)
        sum += n[i] - '0';
    string numbers[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    vector<int> nums;
    while (sum)
    {
        nums.push_back(sum % 10);
        sum /= 10;
    }
    int numsSize = nums.size();
    for (int i = numsSize - 1; i > 0; i--)
        cout << numbers[nums[i]] << " ";
    if (numsSize)
        cout << numbers[nums[0]];
    else
        cout << "zero";
    return 0;
}