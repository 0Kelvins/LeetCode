## 6. ZigZag Conversion
 
**题目地址：** https://leetcode.com/problems/zigzag-conversion/description/

### 题意
将字符串，如`ABCDEFGHIJKLMNO`曲折（ `ZigZag` ）排列 `n` 行，如：
```
// n = 4
A     G     M
B   F H   L N
C E   I K   O
D     J

// n = 2
A C E G
B D F ...
```

字母位置间关系如下，参考[If you are confused with zigzag pattern,come and see! —— HelloKenLee的回答](https://discuss.leetcode.com/topic/22925/if-you-are-confused-with-zigzag-pattern-come-and-see)：
```
// n = numRows

Δ=2n-2    1                           2n-1                         4n-3
Δ=        2                     2n-2  2n                    4n-4   4n-2
Δ=        3               2n-3        2n+1              4n-5       .
Δ=        .           .               .               .            .
Δ=        .       n+2                 .           3n               .
Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
Δ=2n-2    n                           3n-2                         5n-4
```

### 解题思路
找规律。