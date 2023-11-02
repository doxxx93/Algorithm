import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Deque<Integer> back = new ArrayDeque<>();
        Deque<Integer> front = new ArrayDeque<>();
        int current = 0;

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            switch(operation) {
                case "B":
                    if (!back.isEmpty()) {
                        front.addFirst(current);
                        current = back.removeLast();
                    }
                    break;

                case "F":
                    if (!front.isEmpty()) {
                        back.addLast(current);
                        current = front.removeFirst();
                    }
                    break;

                case "A":
                    front.clear();
                    if (current != 0) {
                        back.addLast(current);
                    }
                    current = Integer.parseInt(st.nextToken());
                    break;

                case "C":
                    int j = 1;
                    List<Integer> backList = new ArrayList<>(back);
                    while (j < backList.size()) {
                        if (Objects.equals(backList.get(j - 1), backList.get(j))) {
                            backList.remove(j--);
                        }
                        j++;
                    }
                    back = new ArrayDeque<>(backList);
                    break;
            }
        }

        sb.append(current).append("\n");
        sb.append(back.isEmpty() ? "-1" : formatDequeInReverseOrder(back)).append("\n");
        sb.append(front.isEmpty() ? "-1" : formatDequeInNaturalOrder(front)).append("\n");

        System.out.println(sb.toString());
        br.close();
    }

    private static String formatDequeInNaturalOrder(Deque<Integer> deque) {
        StringBuilder builder = new StringBuilder();
        for(Integer num : deque) {
            builder.append(num).append(" ");
        }
        return builder.toString().trim();
    }

    private static String formatDequeInReverseOrder(Deque<Integer> deque) {
        StringBuilder builder = new StringBuilder();
        Iterator<Integer> itr = deque.descendingIterator();
        while(itr.hasNext()){
            builder.append(itr.next()).append(" ");
        }
        return builder.toString().trim();
    }
}
