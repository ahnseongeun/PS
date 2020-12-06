package HackerRanker.JavaSkillTest;

import javax.swing.*;

interface  Syrupable{
    void getSugary();
}

abstract class Pancake implements Syrupable{}

class BlueBerryPancake extends Pancake{

    public void getSugary() {

    }
}

class TestBlueBerryPancake extends BlueBerryPancake{

    public void getSugary(int s) {

    }
}
public class Test4 {
}
