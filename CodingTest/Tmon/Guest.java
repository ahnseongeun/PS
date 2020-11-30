package CodingTest.Tmon;

import java.util.ArrayList;
import java.util.List;

class Guest {
    int number;
    int hairState;
    ArrayList<String> Treatment;
    public Guest(int number,int hairState,ArrayList<String> Treatment) {
        this.number=number;
        this.hairState=hairState;
        this.Treatment=Treatment;
    }
    public int getNumber(){
        return number;
    }
    public int getHairState() {
        return hairState;
    }

    public void getHairState(int hairState) {
        this.hairState=hairState;
    }

    public List<String> getTreatment() {
        return Treatment;
    }

    public void setTreatment(ArrayList<String> Treatment) {
        this.Treatment=Treatment;
    }

}