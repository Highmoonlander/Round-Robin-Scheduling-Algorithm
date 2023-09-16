import java.util.Scanner;

public class RoundRobin {
    static void roundRobin(int n, int[] at, int[] bt) {
        int[] wt = new int[n];
        int[] ct = new int[n];
        int[] tat = new int[n];
        int[] rt = new int[n];
        int currentTime = 0, completed = 0;
        int tq;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the time quantum: ");
        tq = sc.nextInt();
        for (int i = 0; i < n; i++) {
            rt[i] = bt[i];
        }
        while (completed != n) {
            for (int i = 0; i < n; i++) {
                if (at[i] <= currentTime && rt[i] > 0) {
                    if (rt[i] >= tq) {
                        currentTime += tq;
                        rt[i] -= tq;
                    } else {
                        currentTime += rt[i];
                        rt[i] = 0;
                    }
                    if (rt[i] == 0) {
                        ct[i] = currentTime;
                        tat[i] = ct[i] - at[i];
                        wt[i] = tat[i] - bt[i];
                        completed++;
                    }
                }
            }
        }
        float awt = 0.0f;
        float atat = 0.0f;
        System.out.println("pid\tat\tbt\twt\tct\ttat");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\n", i + 1, at[i], bt[i], wt[i], ct[i], tat[i]);
            awt += wt[i];
            atat += tat[i];
        }
        System.out.printf("avg wt = %.2f\n", awt / n);
        System.out.printf("avd atat = %.2f", atat / n);
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        n = sc.nextInt();
        int[] at = new int[n];
        int[] bt = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter the at and bt of %dth process: ", i + 1);
            at[i] = sc.nextInt();
            bt[i] = sc.nextInt();
        }
        roundRobin(n, at, bt);
    }
}
