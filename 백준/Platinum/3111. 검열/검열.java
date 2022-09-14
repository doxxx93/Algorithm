import java.io.*;
import java.util.*;

class Main {

    static String a;
    static LinkedList<Character>
        left = new LinkedList<>(),
        right = new LinkedList<>(),
        t = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        for (char c : br.readLine().toCharArray()) {
            t.add(c);
        }
        while (true) {
            if (!matchFirst()) break;
            if (!matchLast()) break;
        }
        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) sb.append(left.removeFirst());
        while (!right.isEmpty()) sb.append(right.removeFirst());
        while (true) {
            int i = sb.indexOf(a);
            if (i < 0) break;
            sb.delete(i, i + a.length());
        }
        System.out.println(sb);
    }
    
    static boolean matchFirst() {
        while (!t.isEmpty() && !contains(left.size() - a.length(), left)) {
            left.addLast(t.removeFirst());
        }
        boolean flag = contains(left.size() - a.length(), left);
        if (flag) {
            for (int i = 0; i < a.length(); i++) {
                left.removeLast();
            }
        }
        return flag;
    }

    static boolean matchLast() {
        while (!t.isEmpty() && !contains(0, right)) {
            right.addFirst(t.removeLast());
        }
        boolean flag = contains(0, right);
        if (flag) {
            for (int i = 0; i < a.length(); i++) {
                right.removeFirst();
            }
        }
        return flag;
    }

    private static boolean contains(int j, LinkedList<Character> q) {
        if (q.size() < a.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != q.get(j + i)) return false;
        }
        return true;
    }
}
