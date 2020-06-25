import java.util.*;

class MergeInterval {
    class Interval {
        int start, end;

        public Interval(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[ " + this.start + " , " + this.end + " ]";
        }
    }

    public static ArrayList<Interval> insertNewInterval(ArrayList<Interval> intervals, Interval newInterval) {
        if (intervals == null) {
            intervals = new ArrayList<Interval>();
            intervals.add(newInterval);
        } else if (intervals.size() == 0) {
            intervals.add(newInterval);
        } else {
            int i = 0;
            while (i < intervals.size()) {
                Interval current = intervals.get(i);
                if (current.end < newInterval.start) {
                    i++;
                    continue;
                } else if (newInterval.end < current.start) {
                    intervals.add(i, newInterval);
                    break;
                } else {
                    newInterval.start = Math.min(newInterval.start, current.start);
                    newInterval.end = Math.max(newInterval.end, current.end);
                    intervals.remove(i);
                }
            }
            if (i == intervals.size()) {
                intervals.add(newInterval);
            }
        }
        return intervals;
    }
    public static void main(final String[] args) throws Exception {
        final Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of testcases : ");
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            MergeInterval ob = new MergeInterval();
            ArrayList<Interval> intervals = new ArrayList<>();
            System.out.print("Enter number of intervals : ");
            int N = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < N; i++) {
                System.out.print("Enter start and end of the " + ( i + 1 ) + " interval (separated by single space) : ");
                int start = sc.nextInt();
                int end = sc.nextInt();
                Interval newInterval = ob.new Interval(start, end);
                intervals.add(newInterval);
                sc.nextLine();
            }
            System.out.print("Enter start and end of the interval to be inserted (separated by single space) : ");
            int start = sc.nextInt();
            int end = sc.nextInt();
            Interval newInterval = ob.new Interval(start, end);
            System.out.println("Before insertion intervals are : ");
            for (Interval interval : intervals) {
                System.out.println(interval);
            }
            intervals = insertNewInterval(intervals, newInterval);
            System.out.println("After insertion intervals are : ");
            for (Interval interval : intervals) {
                System.out.println(interval);
            }
        }
        sc.close();
    }
}