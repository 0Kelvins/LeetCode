/**
 * 83. Remove Duplicates from Sorted List
 */
#include <iostream>
#include <vector>
using namespace std;

// Definition for singly-linked list.
struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution
{
public:
    ListNode *deleteDuplicates(ListNode *head)
    {
        ListNode *p = head;
        while (p)
        {
            if (p->next && p->val == p->next->val)
                p->next = p->next->next;
            else
                p = p->next;
        }
        return head;
    }
};

int main()
{
    Solution s;
    vector<int> nums = {1, 3, 3, 4, 4};
    ListNode *head = new ListNode(nums[0]);
    ListNode *p = head, *q;
    for (int i = 1; i < nums.size(); i++)
    {
        q = new ListNode(nums[i]);
        p->next = q;
        p = p->next;
    }
    ListNode *r = s.deleteDuplicates(head);
    while (r)
    {
        cout << r->val << " ";
        r = r->next;
    }
    return 0;
}