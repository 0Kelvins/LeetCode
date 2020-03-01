import java.util.Scanner;

/**
 * 1011 World Cup Betting
 * 换回Java了，考虑以后用C++可能会比较少，虽然两者都有我喜欢的地方
 * PAT可能再刷一些就不刷了，题目感觉都不太好，先恢复一些Java的语法感觉吧
 */
class Main {
    public static void main(String[] args) {
        double[] maxOdds = new double[3];
        char[] type = { 'W', 'T', 'L' };
        char[] bets = new char[3];
        double t;
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            maxOdds[i] = 0;
            for (int j = 0; j < 3; j++) {
                t = s.nextDouble();
                if (maxOdds[i] < t) {
                    maxOdds[i] = t;
                    bets[i] = type[j];
                }
            }
        }
        s.close();
        double profit = (maxOdds[0] * maxOdds[1] * maxOdds[2] * 0.65 - 1) * 2;
        System.out.print(bets[0] + " " + bets[1] + " " + bets[2] + " " + String.format("%.2f", profit));
    }
}