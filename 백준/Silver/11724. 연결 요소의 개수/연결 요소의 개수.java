import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	static int nVertex , nEdge ; // vertex, edge 초기화
	static int[][] map; //
	static boolean[] connected;

	public void solve() {
		Scanner sc = new Scanner(System.in);
		nVertex = sc.nextInt(); // vertex 입력
		nEdge = sc.nextInt(); // edge 입력
		sc.nextLine();

		map = new int[nVertex + 1][nVertex + 1];
		connected = new boolean[nVertex + 1];

		for (int i = 0; i < nEdge; ++i) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			sc.nextLine();

			map[from][to] = 1;
			map[to][from] = 1;

		}

		for (int i = 1; i < nVertex; ++i) {
			for (int j = 1; j < nVertex; ++j) {
				if (map[i][j] == 1) {
					Deque<Integer> queue = new ArrayDeque<>();
					queue.add(i);

					bfs(queue);
				}
			}
		}
		int r = 0;
		for (boolean b : connected) {
			if (b == false)
				r++;
		}
		r -= 1;
		System.out.println(r);
	}

	public void bfs(Deque<Integer> queue) {
		while(queue.size()>0) {
			int from = queue.pop();
		

			for (int to = 1; to <= nVertex; ++to) {
				if (map[from][to] == 1) {
					map[from][to] = 0;
					map[to][from] = 0;
	
					if (!queue.contains(to)) {
						queue.add(to);
						connected[to] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		main.solve();
		
	}

}
