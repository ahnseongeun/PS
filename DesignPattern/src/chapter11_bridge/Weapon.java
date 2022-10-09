package chapter11_bridge;


public interface Weapon {

    void wield();

    void swing();

    void unwield();

    Enchantment getEnchantment();
}
