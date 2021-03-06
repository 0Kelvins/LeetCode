### 自下而上的动态规划

字符串：`ab`，表达式 `.*`

初始化 `dp[3][3]` 数组，如下，只有结束符匹配为`T`：

|   | . | * | $ |
| - | - | - | - |
| a |   |   | F |
| b |   |   | F |
| $ |   |   | T |

i = 2，j = 1时，`$` 匹配 `*` ，表达式下标j+1=2，后面不会有 `*` 了，所以直接匹配，结束符匹配表达式结果为 `false`（这里直接按最后一行结束符，直接匹配视为 `false` 了）

```java
dp[2][1] = (i < 2 && ('*' == '$' || '*' == '.')) && dp[3][2] = i < 2 = false;
```

|   | . | * | $ |
| - | - | - | - |
| a |   |   | F |
| b |   |   | F |
| $ |   | F | T |

i = 2，j = 0时，`$` 匹配 `.` ，表达式匹配 `.*`（不为最后一个表达式字符，后面为 `*` ），依照`.*`规则匹配，这里和表达式j+2下标 `$` 匹配，于是结果为 `true`

```java
dp[2][0] = dp[2][2] || (i < 2 && ('.' == '$' || '.' == '.')) && dp[3][0] = dp[2][2] = true;
```

|   | . | * | $ |
| - | - | - | - |
| a |   |   | F |
| b |   |   | F |
| $ | T | F | T |

从下往上，从后往前，最后完成结果 `dp[0][0] = true`

|   | . | * | $ |
| - | - | - | - |
| a | T | F | F |
| b | T | F | F |
| $ | T | F | T |

### 记

有空还是要写写算法题，应该能少做一些无用功，至少能让思维活跃点，不是都是复制粘贴。