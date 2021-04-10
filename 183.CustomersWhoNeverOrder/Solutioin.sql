# 183. Customers Who Never Order
# Easy

# 自己写的这个最快，应该是订单表重复的项目特别多，筛选出来会更快。
SELECT c.`Name` as Customers
FROM Customers c
WHERE c.Id NOT IN (
    SELECT CustomerId
    FROM Orders
    GROUP BY CustomerId
)

SELECT c.`Name` as Customers
FROM Customers c
WHERE c.Id NOT IN (
    SELECT DISTINCT CustomerId
    FROM Orders
)

SELECT c.`Name` as Customers
FROM Customers c LEFT JOIN Orders o ON c.Id = o.CustomerId
WHERE o.Id IS NULL  # 判断空用 IS ！！！
