## 383. Ransom Note
[link](https://leetcode.com/problems/ransom-note/description/)
*easy*
> magazine为字母库，ransomNote为目标串，使用字母库字母构建目标串，每个字母只能用一次
> 求字母库是否能构建目标串

解：统计每种字符个数，用来构建目标串，字符不够构建返回错误，否则可以构建