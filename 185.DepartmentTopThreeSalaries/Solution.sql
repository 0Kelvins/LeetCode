# 185. Department Top Three Salaries
# Hard
# 这题有点难。需要换思路通过数量来比较确定记录是否符合要求
# 还有case问题，Department 表可能为空，但 Employee 表不空，故不能用 LEFT JOIN

SELECT d.`Name` as Department, e.`Name` as Employee, e.Salary
FROM Employee e JOIN Department d ON e.DepartmentId = d.Id
WHERE 3 > (
    SELECT COUNT(DISTINCT c.Salary) # 比该员工工资高的部门工资级别数量
    FROM Employee c
    WHERE c.Salary > e.Salary
    AND c.DepartmentId = e.DepartmentId 
)