package CodingTest.Tmon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TODO 리팩토리 처리

/* input입력 값
1
1
5
{"머릿결" : "5", "시술목록" : "커트, 파마, 염색"}
{"머릿결" : "2", "시술목록" : "파마, 염색"}
{"머릿결" : "0", "시술목록" : "드라이, 클리닉"}
{"머릿결" : "1", "시술목록" : "커트, 드라이"}
{"머릿결" : "3", "시술목록" : "염색"}
output: 3시간 40분(220) 98만원

1
1
5
{"머릿결" : "5", "시술목록" : "드라이, 클리닉, 파마, 염색, 커트"}
{"머릿결" : "2", "시술목록" : "드라이, 클리닉, 파마, 염색, 커트"}
{"머릿결" : "0", "시술목록" : "드라이, 클리닉, 파마, 염색, 커트"}
{"머릿결" : "1", "시술목록" : "드라이, 클리닉, 파마, 염색, 커트"}
{"머릿결" : "3", "시술목록" : "드라이, 클리닉, 파마, 염색, 커트"}

1
1
5
{"머릿결" : "5", "시술목록" : "커트, 클리닉, 파마, 염색, 드라이"}
{"머릿결" : "2", "시술목록" : "커트, 클리닉, 파마, 염색, 드라이"}
{"머릿결" : "0", "시술목록" : "커트, 클리닉, 파마, 염색, 드라이"}
{"머릿결" : "1", "시술목록" : "커트, 클리닉, 파마, 염색, 드라이"}
{"머릿결" : "3", "시술목록" : "커트, 클리닉, 파마, 염색, 드라이"}


멀티 큐를 사용해야겠다.

       2 / directorSkills.add("파마");directorSkills.add("염색");directorSkills.add("드라이");directorSkills.add("커트");

       1 / managerSkills.add("파마");managerSkills.add("염색");managerSkills.add("커트");

       1 / dyeingSkills.add("염색");dyeingSkills.add("커트");dyeingSkills.add("클리닉");
*/
/*
        map.put("파마", new HairInformation(120, -2,200000));
        map.put("클리닉", new HairInformation(30, +2,100000));
        map.put("염색", new HairInformation(60, -2,120000));
        map.put("커트", new HairInformation(20, 0,50000));
        map.put("드라이", new HairInformation(40, -1,70000));
*/

//머릿결 상태 0 와 원하는 시술이 {염색, 커트, 클리닉} -- 손님


public class Main {
    private static HashMap<String, HairDesigner> ManagerInformation_Setting( ) {//미용사 값 설정
        HashMap<String , HairDesigner> totalList= new HashMap<String, HairDesigner>();

        ArrayList<String> directorSkills=new ArrayList<String>();
        directorSkills.add("파마");directorSkills.add("염색");directorSkills.add("드라이");directorSkills.add("커트");

        ArrayList<String> managerSkills=new ArrayList<String>();
        managerSkills.add("파마");managerSkills.add("염색");managerSkills.add("커트");

        ArrayList<String> dyeingSkills=new ArrayList<String>();
        dyeingSkills.add("염색");dyeingSkills.add("커트");dyeingSkills.add("클리닉");

        totalList.put("원장님", new HairDesigner(directorSkills));
        totalList.put("실장님", new HairDesigner(managerSkills));
        totalList.put("디자이너", new HairDesigner(dyeingSkills));
        return totalList;
    }

    private static HashMap<String, HairInformation> HairInformation_Setting() {
        HashMap<String , HairInformation> map= new HashMap<String, HairInformation>();
        map.put("파마", new HairInformation(120, -2,200000));
        map.put("클리닉", new HairInformation(30, +2,100000));
        map.put("염색", new HairInformation(60, -2,120000));
        map.put("커트", new HairInformation(20, 0,50000));
        map.put("드라이", new HairInformation(40, -1,70000));
        return map;
    }

    private static int[] total(List<Guest> guestList,
                               HashMap<String, HairInformation> hairList,
                               HashMap<String, HairDesigner> managerList,
                               int director_count, //1
                               int manager_count, //2
                               int designer_count){//3
        int total_time = 0;
        int total_price = 0;
        int director_cnt=0;
        int manager_cnt=0;
        int designer_cnt=0;
        int flag=0;
        Queue<int[]> q= new LinkedList<>();
        while(true) {
            total_time++;//1분씩 증가
            if(total_time==10000)
                break;
            System.out.println("total_time "+total_time);
            ArrayList<Integer> guestCheck=new ArrayList<>();
            int size=q.size();
            if(!q.isEmpty()) {
                for(int i=0;i<size;i++) { //1분씩 감속 하면서 머리 시간이 다되면 q에 삽입 하지 않는다.
                    int instance[]=q.poll();
                    if(instance[2]==0) { //머리 시간이 다됬다.
                        if(instance[1]==1){
                            director_cnt--;
                        }else if(instance[1]==2){
                            manager_cnt--;
                        }else {
                            designer_cnt--;
                        }
                    }else {
                        instance[2]-=1;
                        guestCheck.add(instance[0]);
                        q.add(new int[] {instance[0],instance[1],instance[2]});
                    }
                }
            }
            if(total_time!=1) {
                guestList.sort(Comparator.comparingInt(o -> o.waitTime));
                Collections.reverse(guestList);
            }
            for(Guest guest:guestList) {
                int guest_number=guest.getNumber();
                int guest_hairState=guest.hairState; //손님 머리결 상태
                int guest_designer=0;//1은 디자이너 ,2은 실장 ,3은 원장
                if(guestCheck.contains(guest_number)) {
                    continue;
                }
                int waitTime=guest.getWaitTime();
                guest.setWaitTime(++waitTime);
                if(guest.Treatment.isEmpty()) { //요구 조건이 끝나거나 할수 없는 손님 검사
                    System.out.println("guest"+guest_number+"의 요구 조건이 비었습니다.");
                    flag++;
                }else {
                    System.out.println("guest: "+guest_number);
                    System.out.println("guest_hairState: "+guest_hairState);
                    System.out.println("guest_requirement: "+hairList.get(guest.Treatment.get(0)).getStatePlus());
                    System.out.println("guest_Treatment: "+guest.Treatment);
                    if(guest_hairState+hairList.get(guest.Treatment.get(0)).getStatePlus()>=0) { //머리결 상태 점검
                        System.out.println("머리결 상태 좋음");
                        if(guest.Treatment.get(0).equals("클리닉")) { //디자이너
                            if(designer_cnt<designer_count){
                                designer_cnt++;
                                guest_designer=1;
                            }
                        }else if(guest.Treatment.get(0).equals("염색")){ //디자이너,실장, 원장
                            if(designer_cnt<designer_count){
                                designer_cnt++;
                                guest_designer=1;
                            }else if(manager_cnt<manager_count){
                                manager_cnt++;
                                guest_designer=2;
                            } else if(director_cnt<director_count){
                                director_cnt++;
                                guest_designer=3;
                            }
                        }else if(guest.Treatment.get(0).equals("파마")){ //실장, 원장
                            if(manager_cnt<manager_count){
                                manager_cnt++;
                                guest_designer=2;
                            }else if(director_cnt<director_count){
                                director_cnt++;
                                guest_designer=3;
                            }
                        }else if(guest.Treatment.get(0).equals("드라이")){ //원장
                            if(director_cnt<director_count){
                                director_cnt++;
                                guest_designer=3;
                            }
                        }else{//커트 디자이너,실장, 원장
                            if(designer_cnt<designer_count){
                                designer_cnt++;
                                guest_designer=1;
                            }else if(manager_cnt<manager_count){
                                manager_cnt++;
                                guest_designer=2;
                            } else if(director_cnt<director_count){
                                director_cnt++;
                                guest_designer=3;
                            }
                        }
                        if(guest_designer==0) {
                            continue;
                        }else{
                            //디자이너 카운트와 머리에 걸리는 시간 담을 예정
                            guest.setWaitTime(0);
                            System.out.println("머리 작업 추가");
                            guest.setHairState(guest_hairState+hairList.get(guest.Treatment.get(0)).getStatePlus());
                            total_price+=hairList.get(guest.Treatment.get(0)).getPrice();
                            System.out.println("guest: "+guest.getNumber()+" "+guest.Treatment.get(0));
                            q.add(new int[] {guest.getNumber(),guest_designer,hairList.get(guest.Treatment.get(0)).getMinute()-1});
                            ArrayList<String> list=new ArrayList<>();
                            list=guest.Treatment;
                            //System.out.println("list_size"+list.size());
                            list.remove(0);
                            //System.out.println("list_size"+list.size());
                            //guest.Treatment.remove(0);
                            guest.setTreatment(list);
                        }
                    }else { //머리결상태가 음수라면
                        if(!guest.Treatment.isEmpty()&&guest.Treatment.contains("커트")){
                                //커트 우선순위 정해서 디자이너 배분
                                if(designer_cnt<designer_count){
                                    designer_cnt++;
                                    guest_designer=1;
                                }else if(manager_cnt<manager_count){
                                    manager_cnt++;
                                    guest_designer=2;
                                } else if(director_cnt<director_count){
                                    director_cnt++;
                                    guest_designer=3;
                                }
                                if(guest_designer==0)
                                    continue;
                                int idx= guest.Treatment.indexOf("커트");
                                System.out.println("커트 추가");
                                guest.setWaitTime(0);
                                q.add(new int[] {guest.getNumber(),guest_designer,hairList.get(guest.Treatment.get(idx)).getMinute()-1});
                                guest.setHairState(guest_hairState+hairList.get(guest.Treatment.get(idx)).getStatePlus());
                                total_price+=hairList.get(guest.Treatment.get(idx)).getPrice();
                                ArrayList<String> list=new ArrayList<>();
                                list=guest.Treatment;
                                list.remove(idx);
                                guest.setTreatment(list);

                        }else if(!guest.Treatment.isEmpty()&&guest.Treatment.contains("클리닉")) {
                            System.out.println("여기들어오면안됨");
                            if (director_cnt < director_count) {
                                designer_cnt++;
                                guest_designer = 3;
                                int idx = 0;
                                for (int i = 0; i < guest.Treatment.size(); i++) {
                                    if (guest.Treatment.get(i).equals("클리닉")) {
                                        idx = i;
                                        break;
                                    }
                                }
                                if(guest_designer==0)
                                    continue;
                                System.out.println("클리닉 추가");
                                guest.setWaitTime(0);
                                q.add(new int[]{guest.getNumber(), guest_designer, hairList.get(guest.Treatment.get(idx)).getMinute() - 1});
                                guest.setHairState(guest_hairState + hairList.get(guest.Treatment.get(idx)).getStatePlus());
                                total_price += hairList.get(guest.Treatment.get(idx)).getPrice();
                                ArrayList<String> list = new ArrayList<>();
                                list = guest.Treatment;
                                list.remove(idx);
                                guest.setTreatment(list);
                            }
                        }else if(!guest.Treatment.isEmpty()&&guest.Treatment.contains("드라이")){
                                int idx= guest.Treatment.indexOf("드라이");
                                if(director_cnt<director_count){
                                    director_cnt++;
                                    guest_designer=3;
                                }
                                if(guest_designer==0)
                                    continue;
                                if(guest_hairState+hairList.get(guest.Treatment.get(idx)).getStatePlus()>=0){
                                    System.out.println("드라이 추가");
                                    guest.setWaitTime(0);
                                    q.add(new int[] {guest.getNumber(),guest_designer,hairList.get(guest.Treatment.get(idx)).getMinute()-1});
                                    guest.setHairState(guest_hairState+hairList.get(guest.Treatment.get(idx)).getStatePlus());
                                    total_price+=hairList.get(guest.Treatment.get(idx)).getPrice();
                                    ArrayList<String> list=new ArrayList<>();
                                    list=guest.Treatment;
                                    list.remove(idx);
                                    guest.setTreatment(list);
                                }
                            }else{
                                    flag++;
                            }

                    }
                }

            }
            //System.out.println("flag: "+flag);
            if(flag==guestList.size()){
                guestList.sort(Comparator.comparingInt(o -> o.getNumber()));
                for(int i=1;i<=guestList.size();i++){
                    System.out.println("guest"+i+": "+guestList.get(i-1).Treatment);
                }
                break;
            }
            flag=0;
        }

        int[] totalNum= {total_time,total_price};
        // TODO Auto-generated method stub
        return totalNum;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int director_count=2;// 원장 두명 고정
        int manager_count=Integer.parseInt(input.readLine());// 실장 n명
        int designer_count=Integer.parseInt(input.readLine());// 디자이너 m명
        int guest_count=Integer.parseInt(input.readLine());//손님수 k명
        //미용실 직원 스킬 설정
        HashMap<String, HairDesigner> ManagerList= ManagerInformation_Setting();
        //손님 정보
        List<Guest> guestList=new ArrayList<Guest>();
        //시술 정보
        HashMap<String, HairInformation> HairList= HairInformation_Setting();

        //손님 정보 입력
        for(int i=0;i<guest_count;i++) {
            String str= input.readLine();
            int hairState=str.charAt(10)-'0'; //머리결 상태
            ArrayList<String> Treatment =new ArrayList<String>(Arrays.asList(str.substring(24,str.length()-2).split(", ")));
            guestList.add(new Guest(i+1,hairState, 0,Treatment));
        }
        int[] result=total(guestList,HairList,ManagerList,director_count,manager_count,designer_count);
        System.out.println("총시간"+(result[0]-1));
        System.out.println("총수익"+result[1]);
    }
}

