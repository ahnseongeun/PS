package CodingTest.Tmon;

import java.util.ArrayList;
import java.util.List;

class Guest {
    int number;
    int hairState;
    int waitTime;
    ArrayList<String> Treatment;
    public Guest(int number,int hairState,int waitTime,ArrayList<String> Treatment) {
        this.number=number;
        this.hairState=hairState;
        this.waitTime=waitTime;
        this.Treatment=Treatment;
    }

    public int getWaitTime(){
        return waitTime;
    }

    public void setWaitTime(int waitTime){ this.waitTime=waitTime;}

    public int getNumber(){
        return number;
    }

    public int getHairState() {
        return hairState;
    }

    public void setHairState(int hairState) {
        this.hairState=hairState;
    }

    public List<String> getTreatment() {
        return Treatment;
    }

    public void setTreatment(ArrayList<String> Treatment) {
        this.Treatment=Treatment;
    }

}