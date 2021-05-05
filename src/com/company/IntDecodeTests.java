package com.company;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
public class IntDecodeTests {

    @Test(expected = NumberFormatException.class)
    public void test_empty(){
        Integer.decode("");
    }

    @Test(expected = NumberFormatException.class)
    public void test_wrong_format(){
        Integer.decode("abcd");
        Integer.decode("7.33");
        Integer.decode("0,25");
    }

    @Test
    public void test_symbols(){
        assertEquals(4,  Integer.decode("+4"));
        assertEquals(6, Integer.decode("6"));
        assertEquals(-3, Integer.decode("-3"));
    }

    @Test
    public void zero_test(){
        assertEquals(0, Integer.decode("0"));
        assertEquals(0, Integer.decode("+0"));
        assertEquals(0, Integer.decode("-0"));
    }

    @Test
    public void test_radix(){
        assertEquals(62, Integer.decode("0x98"));
        assertEquals(62, Integer.decode("0X98"));
        assertEquals(62, Integer.decode("#98"));
        assertEquals(-62, Integer.decode("-#98"));
        assertEquals(-62, Integer.decode("-0X98"));
        assertEquals(-62, Integer.decode("-0x98"));
        assertEquals(142, Integer.decode("098"));
        assertEquals(-142, Integer.decode("-098"));
    }

    @Test(expected = NumberFormatException.class)
    public void test_wrong_position_symbol() {
        Integer.decode("0x-1");
        Integer.decode("0x+1");
        Integer.decode("--");
        Integer.decode("0X1-1");
    }

}
