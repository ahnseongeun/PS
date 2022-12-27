package chapter15_proxy;

public class IvoryTower implements  WizardTower{
    @Override
    public void enter(Wizard wizard) {
        System.out.println(wizard + " enters the tower.");
    }
}
