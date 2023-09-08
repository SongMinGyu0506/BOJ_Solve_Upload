import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static long[] arr,tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        //System.out.println(Arrays.toString(arr));

        tree = new long[N*4];
        init(1,N,1);

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long diff = c - arr[b];
                arr[b] = c;
                update(1,N,1,b,diff);
            } else {
                sb.append(sum(1,N,1,b,c)+"\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static long init(int start, int end, int node) {
        if(start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start+end) / 2;
        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }

    public static long sum(int start, int end, int node, int left, long right) {
        //해당 조건에 해당된다면 찾아야할 범위를 벗어나므로 0으로 반환
        if (left > end || right < start) {
            return 0;
        }
        //(left,right)가 구해야할 구간 합의 범위, start,end가 해당 노드가 (start,end)index의 합
        //따라서, start의 값이 left보다 크거나 작고, end의 값이 right보다 작거나 같으면 따로 노드 이동 없이 해당 노드가 필요하므로 바로 사용한다.
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start+end) / 2;
        return sum(start,mid,node*2,left,right) + sum(mid+1,end,node*2+1,left,right);
    }

    public static void update(int start, int end, int node, int idx, long diff) {
        //변경 해야할 노드가 아님
        if (idx > end || idx < start) {
            return;
        }

        //트리 맨 윗단계부터 구간 합 변경
        tree[node] += diff;

        //리프노드 도착(이미 변경했기 때문에 변경없음)
        if(start == end) return;

        int mid = (start+end)/2;
        update(start, mid, node*2, idx, diff);
        update(mid+1, end, node*2+1, idx, diff);
    }
}
