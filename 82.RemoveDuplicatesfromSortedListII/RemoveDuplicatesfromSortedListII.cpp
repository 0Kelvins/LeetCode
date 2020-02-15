/**
 * 82. Remove Duplicates from Sorted List II
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
        if (!head || !head->next)
            return head;
        ListNode *r = new ListNode(-1);
        r->next = head;
        ListNode *p = r, *q = r->next;
        while (q)
        {
            if (q->next != NULL && q->val == q->next->val)
            {
                int t = q->val;
                while (q != NULL && q->val == t)
                    q = q->next;
                p->next = q;
            }
            else
            {
                p = q; // 指向q对q继续进行重复判断
                q = q->next;
            }
        }
        return r->next;
    }
};

int main()
{
    Solution s;
    vector<int> nums = {3, 3, 4, 4, 5};
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