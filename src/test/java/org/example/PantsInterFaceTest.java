package org.example;

import TerminalInterFaces.PantsInterFace;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PantsInterFaceTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    // Method for simulating UserInput
    public void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    //Tests for material
    @org.junit.jupiter.api.Test
    void shouldReturnCotton(){
        PantsInterFace interFace = new PantsInterFace();
        provideInput("1");
        assertEquals("Cotton",interFace.material());
    }
    @org.junit.jupiter.api.Test
    void shouldReturnPolyester(){
        PantsInterFace interFace = new PantsInterFace();
        provideInput("2");
        assertEquals("Polyester",interFace.material());
    }

    // Tests for type
    @org.junit.jupiter.api.Test
    void shouldReturnRegular(){
        PantsInterFace interFace = new PantsInterFace();
        provideInput("1");
        assertEquals("Regular",interFace.type());
    }
    @org.junit.jupiter.api.Test
    void shouldReturnShorts(){
        PantsInterFace interFace = new PantsInterFace();
        provideInput("2");
        assertEquals("Shorts",interFace.type());
    }
    @org.junit.jupiter.api.Test
    void shouldReturnLongShorts(){
        PantsInterFace interFace = new PantsInterFace();
        provideInput("3");
        assertEquals("LongShorts",interFace.type());
    }

    // Tests for fit

    @org.junit.jupiter.api.Test
    void shouldReturnSlim(){
        PantsInterFace interFace = new PantsInterFace();
        provideInput("1");
        assertEquals("Slim",interFace.fit());
    }
    @org.junit.jupiter.api.Test
    void shouldReturnRegularFit(){
        PantsInterFace interFace = new PantsInterFace();
        provideInput("2");
        assertEquals("Regular",interFace.fit());
    }
    @org.junit.jupiter.api.Test
    void shouldReturnBaggy(){
        PantsInterFace interFace = new PantsInterFace();
        provideInput("3");
        assertEquals("Baggy",interFace.fit());
    }

    // Test for pantsMenu
    /*Vill testa att den kallar på alla ingående metoder 1gång samt att den den retunerar en Skirt
      Genom att simulera input från användaren för alla valen
      men vet inte hur jag ska simulera iputen då dom olika metoderna ropar på inputhandlern inviduelt
      oklart hur jag ska kunna få in flera st simulerade inputs till dessa med mellanrum så att input handlerna tar emot det .

     */


}