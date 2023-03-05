package org.example;

import TerminalInterFaces.UserInterFace;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static TerminalInterFaces.UserInterFace.inputHandler;
import static org.junit.jupiter.api.Assertions.*;

class UserInterFaceTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    // Method for simulating UserInput
    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    // Test for ChooseColor()
    @org.junit.jupiter.api.Test
    void shouldReturnBlue(){
        UserInterFace interFace = new UserInterFace();
        provideInput("1");
        assertEquals("Blue",interFace.chooseColor());
    }
    @org.junit.jupiter.api.Test
    void shouldReturnBlack(){
        UserInterFace interFace = new UserInterFace();
        provideInput("2");
        assertEquals("Black",interFace.chooseColor());
    }
    // Test for ChooseLength()
    @org.junit.jupiter.api.Test
    void shouldReturn130(){
        UserInterFace interFace = new UserInterFace();
        provideInput("1");
        assertEquals(130,interFace.chooseLength());
    }
    @org.junit.jupiter.api.Test
    void shouldReturn140(){
        UserInterFace interFace = new UserInterFace();
        provideInput("2");
        assertEquals(140,interFace.chooseLength());
    }
    @org.junit.jupiter.api.Test
    void shouldReturn150(){
        UserInterFace interFace = new UserInterFace();
        provideInput("3");
        assertEquals(150,interFace.chooseLength());
    }

    // Test for ChooseSize()
    @org.junit.jupiter.api.Test
    void shouldReturnRegular(){
        UserInterFace interFace = new UserInterFace();
        provideInput("1");
        assertEquals("Regular",interFace.chooseSize());
    }
    @org.junit.jupiter.api.Test
    void shouldReturnLarge(){
        UserInterFace interFace = new UserInterFace();
        provideInput("2");
        assertEquals("Large",interFace.chooseSize());
    }
    // Tests for inputHandler
    @org.junit.jupiter.api.Test
    void shouldReturn1(){
        UserInterFace interFace = new UserInterFace();
        provideInput("1");
        assertEquals(1,inputHandler(1,3));
    }
    @org.junit.jupiter.api.Test
    void shouldReturn2(){
        UserInterFace interFace = new UserInterFace();
        provideInput("2");
        assertEquals(2,inputHandler(1,3));
    }
    @org.junit.jupiter.api.Test
    void shouldReturn3(){
        UserInterFace interFace = new UserInterFace();
        provideInput("3");
        assertEquals(3,inputHandler(1,3));
    }
    @org.junit.jupiter.api.Test
    void shouldReturn12(){
        UserInterFace interFace = new UserInterFace();
        provideInput("12");
        assertEquals(12,inputHandler(10,13));
    }

}