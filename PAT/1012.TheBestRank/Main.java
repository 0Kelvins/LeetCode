import java.util.*;

/**
 * 1012 The Best Rank
 * 不管怎么优化，后两个测试点都会超时如果有人能Java满分，希望能给我发个issue
 * PAT就此再见吧
 */
class Student {
    int ID;
    int[] score = new int[4];
    int[] rank = new int[4];
}

class Main {
    static int sortCourse;

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n, m;
        n = s.nextInt();
        m = s.nextInt();
        Student[] stu = new Student[n];
        for (int i = 0; i < n; i++) {
            stu[i] = new Student();
            stu[i].ID = s.nextInt();
            stu[i].score[1] = s.nextInt();
            stu[i].score[2] = s.nextInt();
            stu[i].score[3] = s.nextInt();
            stu[i].score[0] = (stu[i].score[1] + stu[i].score[2] + stu[i].score[3]) / 3;
        }
        for (int i = 0; i < 4; i++) {
            sortCourse = i;
            Arrays.sort(stu, new Comparator<Student>() {
                @Override
                public int compare(Student a, Student b) {
                    return b.score[sortCourse] - a.score[sortCourse];
                }
            });
            int r = 1;
            for (int j = 0; j < n; j++) {
                if (j > 0 && stu[j].score[i] != stu[j - 1].score[i])
                    r = j + 1;
                stu[j].rank[i] = r;
            }
        }

        HashMap<Integer, Student> map = new HashMap<>();
        for (Student t : stu)
            map.put(t.ID, t);

        char[] course = { 'A', 'C', 'M', 'E' };
        int checkID, bestRank, c = -1;
        for (int i = 0; i < m; i++) {
            checkID = s.nextInt();
            if (map.containsKey(checkID)) {
                Student t = map.get(checkID);
                bestRank = Integer.MAX_VALUE;
                for (int j = 0; j < 4; j++) {
                    if (t.rank[j] < bestRank) {
                        bestRank = t.rank[j];
                        c = j;
                    }
                }
                System.out.println(bestRank + " " + course[c]);
            } else
                System.out.println("N/A");
        }

        s.close();
    }
}