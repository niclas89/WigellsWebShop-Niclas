package Builders;

import BuisnessObjects.CEO;
import BuisnessObjects.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class TShirtBuilderTest {


    // Tests for material
    @org.junit.jupiter.api.Test
    void CottonShouldReturnTrue() {
        CEO ceo = new CEO();
        TShirtBuilder builder = new TShirtBuilder(ceo);
        builder.addMaterial("Cotton");
        assertTrue(builder.isValidMaterial());
    }
    @org.junit.jupiter.api.Test
    void polyesterShouldReturnTrue() {
        CEO ceo = new CEO();
        TShirtBuilder builder = new TShirtBuilder(ceo);
        builder.addMaterial("Polyester");
        assertTrue(builder.isValidMaterial());
    }
    @org.junit.jupiter.api.Test
    void woolShouldReturnFalse() {
        CEO ceo = new CEO();
        TShirtBuilder builder = new TShirtBuilder(ceo);
        builder.addMaterial("Wool");
        assertEquals(false,builder.isValidMaterial());
    }

    // Tests for sleeves
    @org.junit.jupiter.api.Test
    void nineShouldReturnFalse() {
        CEO ceo = new CEO();
        TShirtBuilder builder = new TShirtBuilder(ceo);
        builder.addSleve(9);
        assertEquals(false,builder.isValidSleeve());
    }
    @org.junit.jupiter.api.Test
    void teenShouldReturnTrue() {
        CEO ceo = new CEO();
        TShirtBuilder builder = new TShirtBuilder(ceo);
        builder.addSleve(10);
        assertTrue(builder.isValidSleeve());
    }
    @org.junit.jupiter.api.Test
    void fiftenShouldReturnTrue() {
        CEO ceo = new CEO();
        TShirtBuilder builder = new TShirtBuilder(ceo);
        builder.addSleve(15);
        assertTrue(builder.isValidSleeve());
    }
    @org.junit.jupiter.api.Test
    void twentyShouldReturnTrue() {
        CEO ceo = new CEO();
        TShirtBuilder builder = new TShirtBuilder(ceo);
        builder.addSleve(20);
        assertTrue(builder.isValidSleeve());
    }
    @org.junit.jupiter.api.Test
    void twentyOneShouldReturnFalse() {
        CEO ceo = new CEO();
        TShirtBuilder builder = new TShirtBuilder(ceo);
        builder.addSleve(21);
        assertEquals(false,builder.isValidSleeve());
    }

    // tests for NeckLength
    @org.junit.jupiter.api.Test
    void twentyNineoneShouldReturnFalse() {
        CEO ceo = new CEO();
        TShirtBuilder builder = new TShirtBuilder(ceo);
        builder.addNeck(29);
        assertEquals(false,builder.isValidSleeve());
    }
    @org.junit.jupiter.api.Test
    void thirtyShouldReturnTrue() {
        CEO ceo = new CEO();
        TShirtBuilder builder = new TShirtBuilder(ceo);
        builder.addNeck(30);
        assertTrue(builder.isValidNeck());
    }
    @org.junit.jupiter.api.Test
    void fortyShouldReturnTrue() {
        CEO ceo = new CEO();
        TShirtBuilder builder = new TShirtBuilder(ceo);
        builder.addNeck(40);
        assertTrue(builder.isValidNeck());
    }
    @org.junit.jupiter.api.Test
    void fiftyShouldReturnTrue() {
        CEO ceo = new CEO();
        TShirtBuilder builder = new TShirtBuilder(ceo);
        builder.addNeck(50);
        assertTrue(builder.isValidNeck());
    }
    @org.junit.jupiter.api.Test
    void fiftyoneShouldReturnFalse() {
        CEO ceo = new CEO();
        TShirtBuilder builder = new TShirtBuilder(ceo);
        builder.addSleve(51);
        assertEquals(false,builder.isValidSleeve());
    }

    // Tests for build Method
    @org.junit.jupiter.api.Test
    void builderShouldThrowException() {
        CEO ceo = new CEO();
        TShirtBuilder builder = new TShirtBuilder(ceo);
        assertThrows(IllegalArgumentException.class,() -> builder.build());
    }
    @org.junit.jupiter.api.Test
    void builderShouldReturnTshirt() {
        CEO ceo = new CEO();
        TShirt tshirt;
        TShirtBuilder builder = new TShirtBuilder(ceo);
        builder.addMaterial("Cotton");
        builder.addSleve(15);
        builder.addNeck(36);
        tshirt = builder.build();
        assertEquals("Cotton",tshirt.getMaterial());
        assertEquals(15,tshirt.getSleeves());
        assertEquals(36,tshirt.getNeck());

    }








}