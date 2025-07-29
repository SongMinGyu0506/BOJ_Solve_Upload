
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int idx = 0; idx < schedules.length; idx++) {
            int schedule = schedules[idx];
            int[] timelog = timelogs[idx];
            answer += getGiftCheck(schedule,timelog,startday);
        }
        return answer;
    }
    
    public int getGiftCheck(int schedule, int[] timelog, int startday) {
        int checkDay = startday;
        int idx = 0;
        while(true) {
            if(checkDay != 6 && checkDay != 7) {
                int time = timelog[idx];
                int maxSchedule = schedule+10;
                if(maxSchedule % 100 > 59) {
                    int modMin = (maxSchedule % 10);
                    maxSchedule = (maxSchedule/100 + 1) * 100 + modMin;
                }
                if(time > maxSchedule) {
                    return 0;
                }
            }
            idx++;
            checkDay++;
            checkDay = (checkDay % 8);
            if(checkDay == 0) checkDay = 1;
            if(checkDay == startday) break;
        }
        return 1;
    }
}
