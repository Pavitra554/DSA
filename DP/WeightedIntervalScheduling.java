package DATA_STRUCTURE.DP;

import java.util.*;

class job {
    int start;
    int end;
    int p;

    job(int start, int end, int p) {
        this.start = start;
        this.end = end;
        this.p = p;
    }
}

class sortByEndTime implements Comparator<job> {
    public int compare(job o1, job o2) {
        return o1.end - o2.end;
    }
}

public class WeightedIntervalScheduling {
    static int maxProfit(ArrayList<job> jobs) {
        // Sorting jobs according to their end time
        Collections.sort(jobs, new sortByEndTime());

        int M[] = new int[jobs.size() + 1];

        int p[] = new int[jobs.size()];
        for (int i = 1; i < jobs.size(); i++) {

            for (int j = i - 1; j >= 0; j--) {
                if (jobs.get(j).end <= jobs.get(i).start) {
                    p[i] = i - 1;
                    // break;
                }
            }
        }

        M[0] = 0;
        for (int i = 1; i < M.length; i++) {
            M[i] = Math.max(jobs.get(i - 1).p + M[p[i - 1]], M[i - 1]);
        }

        System.out.println(Arrays.toString(p));
        System.out.println(Arrays.toString(M));

        return M[jobs.size()];
    }

    public static void main(String[] args) {
        ArrayList<job> jobs = new ArrayList<job>();
        jobs.add(new job(0, 4, 20));
        jobs.add(new job(5, 9, 30));
        jobs.add(new job(1, 7, 30));
        jobs.add(new job(2, 5, 50));

        System.out.println("Maximum profit" + maxProfit(jobs));

        // for (job e : jobs) {
        // System.out.println(e.start + " " + e.end + " " + e.p);
        // }

    }
}
