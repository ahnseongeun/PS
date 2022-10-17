package chapter12_builder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args) {

        // static class는 공유되는 것이 아닌지??...
        var mage = new Hero.Builder(Profession.MAGE, "Riobard")
            .withHairColor(HairColor.BLACK)
            .withWeapon(Weapon.DAGGER)
            .build();
        log.info(mage.toString());

        var warrior = new Hero.Builder(Profession.WARRIOR, "Amberji11")
                .withHairColor(HairColor.BLOND)
                .withHairType(HairType.LONG_CURLY)
                .withArmor(Armor.CHAIN_MAIL)
                .withWeapon(Weapon.SWORD)
                .build();
        log.info(warrior.toString());

        var thief = new Hero.Builder(Profession.THIEF, "Desmond")
                .withHairType(HairType.BALD)
                .withWeapon(Weapon.BOW)
                .build();
        log.info(thief.toString());
    }
}
