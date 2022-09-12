package chapter3_active_object;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


class ActiveCreatureTest {

    @Test
    void executionTest() throws InterruptedException {
        ActiveCreature orc = new Orc("orc1");
        assertEquals("orc1", orc.name());
        assertEquals(0,orc.getStatus());
        orc.eat();
        assertEquals(0,orc.getStatus());
        orc.roam();
        assertEquals(0,orc.getStatus());
        orc.kill(0);
        assertEquals(0,orc.getStatus());
    }
}
