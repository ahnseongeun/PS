package CodingTest.이투스;

import java.util.*;

//["jack:9,10,13,9,15","jerry:7,7,14,10,17"]
/*
우선 순위는
코스수
완주한 코스 난이도
금메달 순위
코스별 완주합 시간
이름이 사전순
 */
class Player implements Comparable<Player> {
    String name;
    int courses[];
    int finishCourseCount;
    int hardestCourse;
    int courseTotalFinishTime;
    int medal[];
    public Player(String name,int courses[],int medal[],
                  int finishCourseCount,int hardestCourse,int courseTotalFinishTime){
        this.courses=courses;
        this.name=name;
        this.medal=medal;
        this.finishCourseCount=finishCourseCount;
        this.hardestCourse=hardestCourse;
        this.courseTotalFinishTime=courseTotalFinishTime;
    }

    public void setMedal(int[] medal) {
        this.medal = medal;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", courses=" + Arrays.toString(courses) +
                ", finishCourseCount=" + finishCourseCount +
                ", hardestCourse=" + hardestCourse +
                ", courseTotalFinishTime=" + courseTotalFinishTime +
                ", medal=" + Arrays.toString(medal) +
                '}'+"\n";
    }

    /*
        우선 순위는
        코스수
        완주한 코스 난이도
        금메달 순위
        코스별 완주합 시간
        이름이 사전순
         */
    @Override
    public int compareTo(Player o) {
        if(this.finishCourseCount-o.finishCourseCount>0){
            return -1;
        }else if(this.finishCourseCount-o.finishCourseCount<0){
            return 1;
        }else{
            if(this.hardestCourse-o.hardestCourse>0){
                return -1;
            }else if(this.hardestCourse-o.hardestCourse<0){
                return 1;
            }else{
                if(this.medal[0]<o.medal[0]){
                    return 1;
                }else if(this.medal[0]>o.medal[0]){
                    return -1;
                }else{
                    if(this.medal[1]<o.medal[1]){
                        return 1;
                    }else if(this.medal[1]>o.medal[1]) {
                        return -1;
                    }else{
                        if(this.medal[2]<o.medal[2]){
                            return 1;
                        }else if(this.medal[2]>o.medal[2]) {
                            return -1;
                        }else{
                            if(this.courseTotalFinishTime<o.courseTotalFinishTime){
                                return -1;
                            }else if(this.courseTotalFinishTime>o.courseTotalFinishTime){
                                return 1;
                            }else{
                                return this.name.compareTo(o.name);
                            }
                        }
                    }
                }
            }
        }
    }
}
public class Test1 {
    private static void medalCount(ArrayList<Player> list,int num) {
        int size=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).courses[num]==0) {
                continue;
            }
            size++;
        }
        int goldCount= (int) Math.ceil(size/12.0);
        int silverCount=(int) Math.ceil(size/4.0)-goldCount;
        int bronzeCount=(int) Math.ceil(size/2.0)-goldCount-silverCount;
        for(int i=0;i<list.size();i++){
            if(list.get(i).courses[num]==0) {
                continue;
            }
            if(goldCount!=0){
                int medal[]=list.get(i).medal;
                medal[0]++;
                list.get(i).setMedal(medal);
                goldCount--;
            }else if(silverCount!=0){
                int medal[]=list.get(i).medal;
                medal[1]++;
                list.get(i).setMedal(medal);
                silverCount--;
            }else if(bronzeCount!=0){
                int medal[]=list.get(i).medal;
                medal[2]++;
                list.get(i).setMedal(medal);
                bronzeCount--;
            }else{
                continue;
            }
        }
    }

    private static void courseSort(ArrayList<Player> list) {
        Collections.sort(list, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.courses[0]-o2.courses[0];
            }
        });
        medalCount(list,0);


        Collections.sort(list, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.courses[1]-o2.courses[1];
            }
        });
        medalCount(list,1);

        Collections.sort(list, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.courses[2]-o2.courses[2];
            }
        });
        medalCount(list,2);

        Collections.sort(list, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.courses[3]-o2.courses[3];
            }
        });
        medalCount(list,3);

        Collections.sort(list, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.courses[4]-o2.courses[4];
            }
        });
        medalCount(list,4);
    }

    public static void main(String[] args){
        ArrayList<Player> list=new ArrayList<>();
        String[] record={"jack:9,10,13,9,15","jerry:7,7,14,10,17","jean:0,0,11,20,0","alex:21,2,7,11,4","kevin:8,4,5,0,0","brown:3,5,16,3,18","ted:0,8,0,0,8","lala:0,12,0,7,9","hue:17,16,8,6,10","elsa:11,13,10,4,13"};
        for(int i=0;i< record.length;i++){
            String str=record[i];
            String[] str1=str.split(":");
            String name= str1[0];
            String temp[] =str1[1].split(",");
            int course1=Integer.parseInt(temp[0]);
            int course2=Integer.parseInt(temp[1]);
            int course3=Integer.parseInt(temp[2]);
            int course4=Integer.parseInt(temp[3]);
            int course5=Integer.parseInt(temp[4]);
            int courses[]={course1,course2,course3,course4,course5};
            int finishCourseCount=0;
            int hardestCourse=0;
            int courseTotalFinishTime=0;
            int medal[]=new int[3];
            for(int j=0;j<5;j++){
                if(!temp[j].equals("0")) {
                    finishCourseCount++;
                    hardestCourse=j+1;
                    courseTotalFinishTime+=Integer.parseInt(temp[j]);
                }
            }
            Player player=new Player(name,courses,medal,
                    finishCourseCount,hardestCourse, courseTotalFinishTime);
            list.add(player);
        }
        courseSort(list);
        Collections.sort(list);
        System.out.println(list.toString());
    }
}
