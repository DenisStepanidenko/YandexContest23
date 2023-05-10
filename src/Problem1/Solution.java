package Problem1;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /*
        List<Integer> allAnswers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();

        DataCenter[] dataCenters = new DataCenter[n];
        for (int i = 0; i < n; i++) {
            dataCenters[i] = new DataCenter(0, m);
        }

        for (int i = 0; i < q; i++) {
            String type = scanner.next();
            if (type.equals("RESET")) {
                int index = scanner.nextInt() - 1;
                dataCenters[index].reset();
            } else if (type.equals("DISABLE")) {
                int index = scanner.nextInt() - 1;
                int j = scanner.nextInt();
                dataCenters[index].disable(j);
            } else if (type.equals("GETMAX")) {
                allAnswers.add(getMax(dataCenters));

            } else {
                allAnswers.add(getMin(dataCenters));

            }

        }

        for (int j = 0; j < allAnswers.size(); j++) {
            System.out.println(allAnswers.get(j));
        }

    }

    public static int getMax(DataCenter[] dataCenters) { // получаем наибольшее произведение
        long max = -1;
        int maxNumber = 0; // индекс, который мы вернём
        for (int i = 0; i < dataCenters.length; i++) {
            if (((long) dataCenters[i].getR() * dataCenters[i].getA()) > max) {
                max = (long) dataCenters[i].getR() * dataCenters[i].getA();
                maxNumber = i + 1;
                // отметим что при таком подходе мы всегда вернём наименьший номер дата центра в случае неоднозначности
            }
        }
        return maxNumber;





    }

    public static int getMin(DataCenter[] dataCenters) {
        long min = Integer.MAX_VALUE;
        int minNumber = 0; // индекс который мы вернём
        for (int i = 0; i < dataCenters.length; i++) {
            if (((long) dataCenters[i].getR() * dataCenters[i].getA()) < min) {
                min = (long) dataCenters[i].getR() * dataCenters[i].getA();
                minNumber = i + 1;
                // отметим что при таком подходе мы всегда вернём наименьший номер дата центра в случае неоднозначности
            }
        }
        return minNumber;
    }

         */

    }

    class DataCenter {
        int r; // число перезапусков
        int a; // число рабочих серверов
        int[] servers; // массив серверов, нужен для того, чтобы случайно не посчитать уже выключенный сервер

        public DataCenter(int r, int a) {
            this.r = r;
            this.a = a;
            servers = new int[a];
            Arrays.fill(servers, 1); // 1 - сервер работает
        }

        public int getR() {
            return r;
        }

        public int getA() {
            return a;
        }

        public void reset() {
            r++;
            Arrays.fill(servers, 1); // все сервера снова включены
            a = servers.length; // все сервера стали рабочими
        }

        public void disable(int j) { // j - номер сервера, который выключился
            for (int i = 0; i < servers.length; i++) {
                if ((i + 1) == j) {
                    if (servers[i] == 1) {
                        servers[i] = 0;
                        a--;
                    }
                    break;
                }
            }
        }
    }
}