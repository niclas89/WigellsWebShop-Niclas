package org.example;

import TerminalInterFaces.TshirtInterFace;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TshirtInterFaceTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    // Method for simulating UserInput
    public void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }


    // Tests for sleeveLength
    @org.junit.jupiter.api.Test
    void shouldReturn10(){
        TshirtInterFace interFace = new TshirtInterFace();
        provideInput("1");
        assertEquals(10,interFace.sleeveLength());
    }
    @org.junit.jupiter.api.Test
    void shouldReturn15(){
        TshirtInterFace interFace = new TshirtInterFace();
        provideInput("2");
        assertEquals(15,interFace.sleeveLength());
    }
    @org.junit.jupiter.api.Test
    void shouldReturn20(){
        TshirtInterFace interFace = new TshirtInterFace();
        provideInput("3");
        assertEquals(20,interFace.sleeveLength());
    }

    // Tests for neckLength
    @org.junit.jupiter.api.Test
    void shouldReturn30(){
        TshirtInterFace interFace = new TshirtInterFace();
        provideInput("1");
        assertEquals(30,interFace.neckLength());
    }
    @org.junit.jupiter.api.Test
    void shouldReturn40(){
        TshirtInterFace interFace = new TshirtInterFace();
        provideInput("2");
        assertEquals(40,interFace.neckLength());
    }
    @org.junit.jupiter.api.Test
    void shouldReturn50(){
        TshirtInterFace interFace = new TshirtInterFace();
        provideInput("3");
        assertEquals(50,interFace.neckLength());
    }

    // tests for material
    @org.junit.jupiter.api.Test
    void shouldReturnCotton(){
        TshirtInterFace interFace = new TshirtInterFace();
        provideInput("1");
        assertEquals("Cotton",interFace.material());
    }
    @org.junit.jupiter.api.Test
    void shouldReturnPolyester(){
        TshirtInterFace interFace = new TshirtInterFace();
        provideInput("2");
        assertEquals("Polyester",interFace.material());
    }

    // Test for tShirtMenu
    /*Vill testa att den kallar p?? alla ing??ende metoder 1g??ng samt att den den retunerar en Tshirt
      Genom att simulera input fr??n anv??ndaren f??r alla valen
      K??r en ny thread  som skriver in massa input med den klickar inte alltid med inputHandlern
      men n??r dom timar r??tt s?? g??r testet igenom, vilket ??r cirka 50% av tiden, inte en bra l??sning!,
      Men k??r man alla test samtidigt s?? kan TestThread ge fel input till andra test s?? dom inte g??r igenom.
     */
    @org.junit.jupiter.api.Test
    void shouldReturnTshirt(){
        /*TestThread thread = new TestThread();
        TshirtInterFace interFace = new TshirtInterFace();
        TShirt tShirt;
        CEO ceo = new CEO();
        thread.start();
       tShirt = interFace.TshirtMenu(ceo);
       assertTrue(tShirt.getClass() == TShirt.class);

         */
    }








}