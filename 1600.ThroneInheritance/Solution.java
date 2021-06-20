import java.util.*;

/**
 * 1600. Throne Inheritance
 * Medium
 */
class ThroneInheritance {

    private Person king;
    private Map<String, Person> map;

    public ThroneInheritance(String kingName) {
        this.king = new Person(kingName);
        this.map = new HashMap<>();
        this.map.put(kingName, king);
    }

    public void birth(String parentName, String childName) {
        Person parent = this.map.get(parentName);
        Person child = new Person(childName);
        parent.children.add(child);
        this.map.put(childName, child);
    }

    public void death(String name) {
        this.map.get(name).isALive = false;
    }

    private void preOrder(List<String> inheritanceOrder, Person person) {
        if (person.isALive) {
            inheritanceOrder.add(person.name);
        }
        for (Person p : person.children) {
            preOrder(inheritanceOrder, p);
        }
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        preOrder(order, king);
        return order;
    }
}

class Person {
    String name;
    boolean isALive;
    List<Person> children;

    Person() {
        this.isALive = true;
        this.children = new ArrayList<>();
    }
    
    Person(String name) {
        this.name = name;
        this.isALive = true;
        this.children = new ArrayList<>();
    }
}

public class Solution {
    public static void main(String[] args) {
        ThroneInheritance t = new ThroneInheritance("king"); // order: king
        t.birth("king", "andy"); // order: king > andy
        t.birth("king", "bob"); // order: king > andy > bob
        t.birth("king", "catherine"); // order: king > andy > bob > catherine
        t.birth("andy", "matthew"); // order: king > andy > matthew > bob > catherine
        t.birth("bob", "alex"); // order: king > andy > matthew > bob > alex > catherine
        t.birth("bob", "asha"); // order: king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder().toString()); // return ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
        t.death("bob"); // order: king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder().toString()); // return ["king", "andy", "matthew", "alex", "asha", "catherine"]
    }
}