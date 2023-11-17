import java.util.*;
import java.io.*;


public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static int[] problemScore;
	public static int[][] people;
	public static int[] peopleResultScore;
	
	public static int N,T,P;
	
	public static int answerScore,answerRank;
	
	public static class PeopleInfo {
		int peopleNumber;
		int scoreResult;
		int clearProblemCnt;
		
		public PeopleInfo(int p, int s, int c) {
			this.peopleNumber = p;
			this.scoreResult = s;
			this.clearProblemCnt = c;
		}
	}
	public static PeopleInfo[] result;
	
	public static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		people = new int[N][T];
		problemScore = new int[T];
		peopleResultScore = new int[N];
		result = new PeopleInfo[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < T; j++) {
				people[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < T; j++) {
				if(people[i][j] == 0) {
					problemScore[j]++;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			result[i] = new PeopleInfo(i+1, 0, 0);
			for(int j = 0; j < T; j++) {
				if(people[i][j] == 1) {
					result[i].scoreResult += problemScore[j];
					result[i].clearProblemCnt++;
				}
			}
		}
		answerScore = 0;
		answerRank = 0;
	}

	public static void sol() throws Exception {
		PeopleInfo target = result[P-1];
		int betterScorePeopleCnt = 0;
		for(PeopleInfo p : result) {
			if(p.scoreResult > target.scoreResult) {
				betterScorePeopleCnt++;
			}
		}
		int betterProblemCntPeopleCnt = 0;
		for(PeopleInfo p : result) {
			if(p.scoreResult == target.scoreResult && p.clearProblemCnt > target.clearProblemCnt) {
				betterProblemCntPeopleCnt++;
			}
		}
		int smallNumberPeople = 0;
		for(PeopleInfo p : result) {
			if(p.scoreResult == target.scoreResult && p.clearProblemCnt == target.clearProblemCnt && p.peopleNumber < target.peopleNumber) {
				smallNumberPeople++;
			}
		}
		answerScore = target.scoreResult;
		answerRank = betterScorePeopleCnt + betterProblemCntPeopleCnt + smallNumberPeople + 1;
	}

	public static void output(int tc) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("#").append(tc).append(" ").append(answerScore).append(" ").append(answerRank).append("\n");
		bw.write(sb.toString());
	}

	public static void terminate() throws Exception {
		bw.flush();
		bw.close();
		br.close();
	}

	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			input();
			sol();
			output(i);
		}
		terminate();
	}
}