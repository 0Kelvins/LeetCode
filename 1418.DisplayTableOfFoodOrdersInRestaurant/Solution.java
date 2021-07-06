import java.util.*;

/**
 * 1418. Display Table of Food Orders in a Restaurant
 * Medium
 */
public class Solution {

    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Integer> orderCount = new HashMap<>();
        Set<String> foods = new TreeSet<>();
        Set<Integer> tables = new TreeSet<>();
        for (List<String> o : orders) {
            String table = o.get(1), food = o.get(2);
            String key = table + food;
            orderCount.put(key, orderCount.getOrDefault(key, 0) + 1);
            foods.add(food);
            tables.add(Integer.valueOf(table));
        }

        List<List<String>> ans = new ArrayList<>();
        List<String> title = new ArrayList<>();
        title.add("Table");
        foods.forEach((f) -> title.add(f));
        ans.add(title);
        for (Integer t : tables) {
            List<String> tableOrders = new ArrayList<>();
            tableOrders.add(String.valueOf(t));
            for (int i = 1; i < title.size(); i++) {
                String key = t + title.get(i);
                int count = orderCount.getOrDefault(key, 0);
                tableOrders.add(String.valueOf(count));
            }
            ans.add(tableOrders);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[][][] orders = {{{"David","3","Ceviche"},{"Corina","10","Beef Burrito"},{"David","3","Fried Chicken"},{"Carla","5","Water"},{"Carla","5","Ceviche"},{"Rous","3","Ceviche"}},
                {{"James","12","Fried Chicken"},{"Ratesh","12","Fried Chicken"},{"Amadeus","12","Fried Chicken"},{"Adam","1","Canadian Waffles"},{"Brianna","1","Canadian Waffles"}},
                { { "Laura", "2", "Bean Burrito" }, { "Jhon", "2", "Beef Burrito" }, { "Melissa", "2", "Soda" } } };
        Solution s = new Solution();
        for (String[][] os : orders) {
            List<List<String>> oList = new ArrayList<>();
            Arrays.stream(os).forEach((o) -> oList.add(Arrays.asList(o)));
            List<List<String>> table = s.displayTable(oList);
            table.forEach((t) -> System.out.println(t.toString()));
            System.out.println();
        }
    }
}