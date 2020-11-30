package CodingTest.Tmon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/* input입력 값
1
1
5
{"머릿결" : "5", "시술목록" : "커트, 파마, 염색"}
{"머릿결" : "2", "시술목록" : "파마, 염색"}
{"머릿결" : "0", "시술목록" : "드라이, 클리닉"}
{"머릿결" : "1", "시술목록" : "커트, 드라이"}
{"머릿결" : "3", "시술목록" : "염색"}
*/


//머릿결 상태 0 와 원하는 시술이 {염색, 커트, 클리닉} -- 손님


public class Main {
    private static HashMap<String, HairDesigner> ManagerImformation_Setting( ) {//미용사 값 설정
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

    private static HashMap<String, HairInformation> HairImformation_Setting() {
        HashMap<String , HairInformation> map= new HashMap<String, HairInformation>();
        map.put("파마", new HairInformation(120, -2,200000));
        map.put("클리닉", new HairInformation(30, +2,100000));
        map.put("염색", new HairInformation(60, -2,120000));
        map.put("커트", new HairInformation(20, -1,50000));
        map.put("드라이", new HairInformation(40, 0,70000));
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
            if(total_time==1000)
                break;
            total_time++;//1분씩 증가
            System.out.println("total_time "+total_time);
            ArrayList<Integer> list1=new ArrayList<>();
            if(!q.isEmpty()) {
                for(int i=0;i<q.size();i++) { //1분씩 감속 하면서 머리 시간이 다되면 q에 삽입 하지 않는다.
                    int instance[]=q.poll();
                    if(instance[2]==0) {
                        continue;
                    }else {
                        instance[2]-=1;
                        list1.add(instance[0]);
                        q.add(new int[] {instance[0],instance[1],instance[2]});
                    }
                }
            }
            for(Guest guest:guestList) {
                int guest_number=guest.getNumber();
                int guest_hairState=guest.hairState; //손님 머리결 상태
                int guest_designer=0;//1은 디자이너 ,2은 실장 ,3은 원장
                if(list1.contains((Integer)guest_number))
                    continue;
                if(guest.Treatment.isEmpty()) { //요구 조건이 끝나거나 할수 없는 손님 검사
                    System.out.println("guest_null"+guest_number);
                    flag++;
                }else {
                    System.out.println("guest"+guest_number);
                    System.out.println("guest_Treatment"+guest.Treatment);
                    if(guest_hairState-hairList.get(guest.Treatment.get(0)).getStatePlus()>=0) { //머리결 상태 점검
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
                            q.add(new int[] {guest.getNumber(),guest_designer,hairList.get(guest.Treatment.get(0)).getMinute()});
                            ArrayList<String> list=new ArrayList<>();
                            list=guest.Treatment;
                            System.out.println("list_size"+list.size());
                            list.remove(0);
                            System.out.println("list_size"+list.size());
                            //guest.Treatment.remove(0);
                            guest.setTreatment(list);
                        }
                    }else { //머리가 음수라면
                        System.out.println(!guest.Treatment.isEmpty());
                        System.out.println(guest.Treatment.contains("클리닉"));
                        if(!guest.Treatment.isEmpty()&&guest.Treatment.contains("클리닉")){
                            System.out.println("여기들어오면안됨");
                            if(designer_cnt<designer_count){
                                designer_cnt++;
                                guest_designer=1;
                                int idx=0;
                                for(int i=0;i<guest.Treatment.size();i++) {
                                    if(guest.Treatment.get(i).equals("클리닉")){
                                        idx=i;
                                        break;
                                    }
                                }
                                q.add(new int[] {guest.getNumber(),guest_designer,hairList.get(guest.Treatment.get(idx)).getMinute()});
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
            System.out.println(flag);
            if(flag==guestList.size())
                break;
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
        HashMap<String, HairDesigner> ManagerList= ManagerImformation_Setting();
        //손님 정보
        List<Guest> guestList=new ArrayList<Guest>();
        //시술 정보
        HashMap<String, HairInformation> HairList=HairImformation_Setting();

        //손님 정보 입력
        for(int i=0;i<guest_count;i++) {
            String str= input.readLine();
            int hairState=str.charAt(10)-'0'; //머리결 상태
            ArrayList<String> Treatment =new ArrayList<String>(Arrays.asList(str.substring(24,str.length()-2).split(", ")));
            //Treatment= (ArrayList<String>) Arrays.asList(str.substring(24,str.length()-2).split(", ")); //시술 순서
            guestList.add(new Guest(i+1,hairState, Treatment));
        }
        int[] result=total(guestList,HairList,ManagerList,director_count,manager_count,designer_count);
        System.out.println("총시간"+result[0]);
        System.out.println("총수익"+result[1]);
    }
}