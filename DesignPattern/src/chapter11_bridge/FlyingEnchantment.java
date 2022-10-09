package chapter11_bridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FlyingEnchantment implements Enchantment{
    @Override
    public void onActivate() {
        log.info("the item begins to glow faintly");
    }

    @Override
    public void apply() {
        log.info("the item files and strikes the enemies finally returning to owner's hand.");
    }

    @Override
    public void onDeactivate() {
        log.info("the item's glow fades.");
    }
}
