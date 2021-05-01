import java.util.*;

/**
 * 690. Employee Importance
 * Easy
 * bfs
 */
public class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        Deque<Integer> queue = new LinkedList<>();
        queue.add(id);
        int sum = 0;
        while (!queue.isEmpty()) {
            int t = queue.remove();
            Employee et = map.get(t);
            sum += et.importance;
            if (et.subordinates == null) {
                continue;
            }
            for (Integer i : et.subordinates) {
                queue.add(i);
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 5;
        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;
        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 3;

        e1.subordinates = new ArrayList<>();
        e1.subordinates.add(2);
        e1.subordinates.add(3);
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        System.out.println(s.getImportance(employees, 1));
    }
}

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};