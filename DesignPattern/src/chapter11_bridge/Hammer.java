package chapter11_bridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hammer implements Weapon{

    private final Enchantment enchantment;

    public Hammer(FlyingEnchantment flyingEnchantment) {
        this.enchantment = flyingEnchantment;
    }

    @Override
    public void wield() {
        log.info("The hammer is wielded.");
        enchantment.onActivate();
    }

    @Override
    public void swing() {
        log.info("The hammer is swung");
        enchantment.apply();
    }

    @Override
    public void unwield() {
        log.info("The hammer is unwielded");
        enchantment.onDeactivate();
    }

    @Override
    public Enchantment getEnchantment() {
        return enchantment;
    }
}
