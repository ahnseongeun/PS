package chapter13_strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    private static final String RED_DRAGON_EMERGES = "Red dragon emerges.";
    private static final String GREEN_DRAGON_SPOTTED = "Green dragon spotted ahead!";
    private static final String BLACK_DRAGON_LANDS = "Black dragon lands before you.";

    public static void main(String[] args) {
        log.info(GREEN_DRAGON_SPOTTED);
        var dragonSlayer = new DragonSlayer(new MeleeStrategy());
        dragonSlayer.goToBattle();
        log.info(RED_DRAGON_EMERGES);
        dragonSlayer.changeStrategy(new ProjectileStrategy());
        dragonSlayer.goToBattle();
        log.info(BLACK_DRAGON_LANDS);
        dragonSlayer.changeStrategy(new SpellStrategy());
        dragonSlayer.goToBattle();
    }
}
