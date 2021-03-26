/**
 * 1603. Design Parking System
 * Easy
 * 热身题都算不上吧
 */
class ParkingSystem {
    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                return big > 0 && big-- > 0;
            case 2:
                return medium > 0 && medium-- > 0;
            case 3:
                return small > 0 && small-- > 0;
            default:
                return false;
        }
    }
}

public class Solution {
    private static final int BIG = 1;
    private static final int MEDIUM = 2;
    private static final int SMALL = 3;

    public static void main(String[] args) {
        // Your ParkingSystem object will be instantiated and called as such:
        ParkingSystem ps = new ParkingSystem(1, 1, 0);
        System.out.println(ps.addCar(BIG));
        System.out.println(ps.addCar(MEDIUM));
        System.out.println(ps.addCar(SMALL));
        System.out.println(ps.addCar(BIG));
        
    }
}