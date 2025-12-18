import java.util.*;

public class CountTheShapes {

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
        //Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }
        //Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited[node] = true;

        while (!stack.isEmpty()) {
            int u = stack.pop();
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    stack.push(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Map<Point, Integer> pointToId = new HashMap<>();
        int idCounter = 0;
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int x1 = sc.nextInt(), y1 = sc.nextInt();
            int x2 = sc.nextInt(), y2 = sc.nextInt();

            Point p1 = new Point(x1, y1);
            Point p2 = new Point(x2, y2);

            if (!pointToId.containsKey(p1)) {
                pointToId.put(p1, idCounter++);
            }
            if (!pointToId.containsKey(p2)) {
                pointToId.put(p2, idCounter++);
            }

            int u = pointToId.get(p1);
            int v = pointToId.get(p2);
            edges.add(new int[]{u, v});
        }

        int V = idCounter;
        int E = edges.size();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[V];
        int C = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                C++;
                dfs(i, adj, visited);
            }
        }

        // Euler’s planar graph formula → Closed figures = E - V + C
        int closedFigures = E - V + C;
        System.out.println(closedFigures);
    }
}
