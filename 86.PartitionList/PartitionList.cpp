/**
 * 86. Partition List
 * 直接两个临时链表，简单粗暴，省得删来删去各种边界
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
    ListNode *partition(ListNode *head, int x)
    {
        ListNode *p, *q, *i;
        ListNode *h1 = new ListNode(-1), *h2 = new ListNode(-1);
        i = head;
        p = h1;
        q = h2;
        while (i)
        {
            if (i->val < x)
            {
                p->next = i;
                p = p->next;
            }
            else
            {
                q->next = i;
                q = q->next;
            }
            i = i->next;
        }
        p->next = h2->next;
        q->next = NULL;
        return h1->next;
    }
};

int main()
{
    Solution s;
    vector<int> nums = {3, 2, 1};
    ListNode *head = new ListNode(-1);
    ListNode *p = head, *q;
    for (int i = 0; i < nums.size(); i++)
    {
        q = new ListNode(nums[i]);
        p->next = q;
        p = p->next;
    }
    ListNode *r = s.partition(head->next, 3);
    while (r)
    {
        cout << r->val << " ";
        r = r->next;
    }
    return 0;
}