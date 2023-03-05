package org.example;

import TerminalInterFaces.SkirtInterFace;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SkirtInterFaceTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    // Method for simulating UserInput
    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
    // tests for material
    @org.junit.jupiter.api.Test
    void shouldReturnCotton(){
        SkirtInterFace interFace = new SkirtInterFace();
        provideInput("1");
        assertEquals("Cotton",interFace.material());
    }
    @org.junit.jupiter.api.Test
    void shouldReturnPolyester(){
        SkirtInterFace interFace = new SkirtInterFace();
        provideInput("2");
        assertEquals("Polyester",interFace.material());
    }

    // Tests for waist
    @org.junit.jupiter.api.Test
    void shouldReturn50(){
        SkirtInterFace interFace = new SkirtInterFace();
        provideInput("1");
        assertEquals(50,interFace.waist());
    }
    @org.junit.jupiter.api.Test
    void shouldReturn75(){
        SkirtInterFace interFace = new SkirtInterFace();
        provideInput("2");
        assertEquals(75,interFace.waist());
    }
    @org.junit.jupiter.api.Test
    void shouldReturn100(){
        SkirtInterFace interFace = new SkirtInterFace();
        provideInput("3");
        assertEquals(100,interFace.waist());
    }
    // Tests for pattern
    @org.junit.jupiter.api.Test
    void shouldReturnCheckers(){
        SkirtInterFace interFace = new SkirtInterFace();
        provideInput("1");
        assertEquals("Checkers",interFace.pattern());
    }
    @org.junit.jupiter.api.Test
    void shouldReturnCircles(){
        SkirtInterFace interFace = new SkirtInterFace();
        provideInput("2");
        assertEquals("Circles",interFace.pattern());
    }
    @org.junit.jupiter.api.Test
    void shouldReturnFlowers(){
        SkirtInterFace interFace = new SkirtInterFace();
        provideInput("3");
        assertEquals("Flowers",interFace.pattern());
    }

    // Test for skirtMenu
    /*Vill testa att den kallar på alla ingående metoder 1gång samt att den den retunerar en Skirt
      Genom att simulera input från användaren för alla valen
      men vet inte hur jag ska simulera iputen då dom olika metoderna ropar på inputhandlern inviduelt
      oklart hur jag ska kunna få in flera st simulerade inputs till dessa med mellanrum så att input handlerna .

     */
}