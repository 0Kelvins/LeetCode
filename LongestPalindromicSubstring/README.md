## 5. Longest Palindromic Substring

题目：[地址](https://leetcode.com/problems/longest-palindromic-substring/description/)

*normal - hard*

### 参考：
* [Manacher’s Algorithm解法](https://articles.leetcode.com/longest-palindromic-substring-part-ii/)
* [Manacher’s Algorithm中文详解](www.felix021.com/blog/read.php?2040)

## 主要逻辑
1. 将字符串进行预处理，间隔插入符号，统一变成奇数长度回文串`t`，定义一个与`t`同大小的数组`P`存储每个字符为中心的回文串长度
2. 遍历`t`，定义：`i`为当前字符下标，`center`为最近记录的回文串的中心，`i_mirror`为`i`的关于`center`的镜像下标，`right`最近记录的回文串的右边界下标
    
    2.1. 判断当前字符是否在当前记录的回文串的范围内（`i < right`），若在，则 当前字符为中心的回文串最小长度`P[i]` 为`min(right-i, P[i_mirror])`，否则`P[i]`先置0

    2.2. 跳过`i`的`P[i]`范围内回文串的判断，判断`P[i]`范围外侧字符是否在回文串内，若在内则`P[i]++`

    2.3. 若`i`为中心的回文串右边界大于最近记录的回文串的`right`，则替换`center`为`i`，`right`为`i + P[i]`
3. 遍历`P`找出最长子串，返回折算回原字符串的下标

### 小结
看第一篇参考里的代码，感觉到很多细节，很精简，要多学习学习。

这个算法我是看了半天才大概明白的（想多看看英文，emm...一长就感觉看不懂了呢）。要注意先弄清楚，各个定义的变量，还有条件，然后就逻辑清晰了。

比较容易想到的一半逻辑是遍历然后挨个字符为中心求回文串，就是一开始想得还是太简单了，没有考虑到奇偶长度，看了这个算法才意识到。