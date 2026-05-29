package com.teedy;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    
    @Test
    public void testGetGreeting() {
        App app = new App();
        assertEquals("Hello Teedy!", app.getGreeting());
    }

    @Test
    public void testAdd() {
        App app = new App();
        assertEquals(5, app.add(2, 3));
        assertEquals(0, app.add(0, 0));
        assertEquals(-1, app.add(2, -3));
    }

    @Test
    public void testMultiply() {
        App app = new App();
        assertEquals(6, app.multiply(2, 3));
        assertEquals(0, app.multiply(5, 0));
        assertEquals(-6, app.multiply(2, -3));
    }
}
