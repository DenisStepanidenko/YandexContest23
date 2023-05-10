package Problem1Try2;

import java.util.*;

public class Solution {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> allAnswers = new ArrayList<>();
        int n = scanner.nextInt(); // число дата-центров
        int m = scanner.nextInt(); // число серверов в каждом дата-центре
        int q = scanner.nextInt(); // число запросов

        DataCenter[] dataCenters = new DataCenter[n];
        for (int i = 0; i < n; i++) {
            dataCenters[i] = new DataCenter(i + 1, 0, m);
        }

        PriorityQueue<DataCenter> maxHeap = new PriorityQueue<>();
        PriorityQueue<DataCenter> minHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            maxHeap.add(dataCenters[i]);
            minHeap.add(dataCenters[i]);
        }

        for (int i = 0; i < q; i++) {
            String command = scanner.next();
            if (command.equals("RESET")) {
                int centerId = scanner.nextInt();
                DataCenter center = dataCenters[centerId - 1];
                center.restarts++;
                center.activeServers = m;
                Arrays.fill(center.getServers(), 1);
                maxHeap.remove(center);
                minHeap.remove(center);

                maxHeap.add(center);
                minHeap.add(center);
            } else if (command.equals("DISABLE")) {
                int centerId = scanner.nextInt();
                int serverId = scanner.nextInt();
                DataCenter center = dataCenters[centerId - 1];
                if (center.getServers()[serverId - 1] == 0) {
                    continue;
                }
                center.getServers()[serverId - 1] = 0;
                center.activeServers--;
                maxHeap.remove(center);
                minHeap.remove(center);

                maxHeap.offer(center);
                minHeap.offer(center);
                //System.out.println(Arrays.toString(center.getServers()));
            } else if (command.equals("GETMAX")) {
                DataCenter maxCenter = maxHeap.peek();
                allAnswers.add(maxCenter.id);
            } else if (command.equals("GETMIN")) {
                DataCenter minCenter = minHeap.poll();
                allAnswers.add(minCenter.id);
            }
        }

        for (int i = 0; i < allAnswers.size(); i++) {
            System.out.println(allAnswers.get(i));
        }

    }
}
class DataCenter implements Comparable<DataCenter> {
    int id;
    int restarts;
    int activeServers;
    int[] servers;

    public int[] getServers() {
        return servers;
    }

    public DataCenter(int id, int restarts, int activeServers) {
        this.id = id;
        this.restarts = restarts;
        this.activeServers = activeServers;
        servers = new int[activeServers];
        Arrays.fill(servers, 1);
    }

    public int compareTo(DataCenter other) {
        long prod1 = (long) this.restarts * this.activeServers;
        long prod2 = (long) other.restarts * other.activeServers;
        if(Long.compare(prod1, prod2) == 0){
            if(Long.compare(other.id , this.id) == 1){
                return -1;
            }
            else{
                return 1;
            }
        }
        else{
            return Long.compare(prod2, prod1);
        }
    }
}
