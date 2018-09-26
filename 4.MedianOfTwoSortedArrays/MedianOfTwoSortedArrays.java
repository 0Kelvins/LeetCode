class Solution {
    /*归并排序*/
    public static int[] merge(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        int m = a.length;
        int n = b.length;

        int[] t = new int[m + n];
        while (i < m && j < n) {
            if (a[i] < b[j]) {
                t[k++] = a[i++];
            }
            else {
                t[k++] = b[j++];
            }
        }
        while(i < m) {
            t[k++] = a[i++];
        }
        while(j < n) {
            t[k++] = b[j++];
        }

        return t;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] t = merge(nums1, nums2);
        if (t.length % 2 == 1)
            return t[t.length/2];
        return (double)(t[t.length/2 - 1] + t[t.length/2]) / 2.0;
    }

    /*二分查找*/ 
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) { // 保证 m <= n
            return findMedianSortedArrays(nums2, nums1);
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j - 1] > nums1[i])
                iMin = iMin + 1; // i is too small
            else if (i > iMin && nums1[i - 1] > nums2[j])
                iMax = iMax - 1; // i is too big
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0)
                    maxLeft = nums2[j - 1];
                else if (j == 0)
                    maxLeft = nums1[i - 1];
                else
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                if ((m + n) % 2 == 1)
                    return maxLeft;

                int minRight = 0;
                if (i == m)
                    minRight = nums2[j];
                else if (j == n)
                    minRight = nums1[i];
                else
                    minRight = Math.min(nums2[j], nums1[i]);

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 3 };
        int[] nums2 = {};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}