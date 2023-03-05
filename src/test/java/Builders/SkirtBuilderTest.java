package Builders;

import BuisnessObjects.CEO;
import BuisnessObjects.Skirt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkirtBuilderTest {

    @org.junit.jupiter.api.Test
    void CottonShouldReturnTrue() {
        CEO ceo = new CEO();
        SkirtBuilder builder = new SkirtBuilder(ceo);
        builder.addMaterial("Cotton");
        assertEquals(true,builder.isValidMaterial());
    }
    @org.junit.jupiter.api.Test
    void PolyesterShouldReturnTrue() {
        CEO ceo = new CEO();
        SkirtBuilder builder = new SkirtBuilder(ceo);
        builder.addMaterial("Polyester");
        assertEquals(true,builder.isValidMaterial());
    }
    @org.junit.jupiter.api.Test
    void WoolShouldReturnFalse() {
        CEO ceo = new CEO();
        SkirtBuilder builder = new SkirtBuilder(ceo);
        builder.addMaterial("Wool");
        assertEquals(false,builder.isValidMaterial());
    }
    @Test
    void fortyFiveShouldReturnFalse(){
        CEO ceo = new CEO();
        SkirtBuilder builder = new SkirtBuilder(ceo);
        builder.addWaist(45);
        assertEquals(false,builder.isValidWaist());

    }

    @Test
    void fiftyShouldReturnTrue(){
        CEO ceo = new CEO();
        SkirtBuilder builder = new SkirtBuilder(ceo);
        builder.addWaist(50);
        assertEquals(true,builder.isValidWaist());

    }
    @Test
    void seventyFiveShouldReturnTrue(){
        CEO ceo = new CEO();
        SkirtBuilder builder = new SkirtBuilder(ceo);
        builder.addWaist(75);
        assertEquals(true,builder.isValidWaist());

    }
    @Test
    void oneHundredShouldReturnTrue(){
        CEO ceo = new CEO();
        SkirtBuilder builder = new SkirtBuilder(ceo);
        builder.addWaist(100);
        assertEquals(true,builder.isValidWaist());

    }
    @Test
    void oneHundredtenShouldReturnFalse(){
        CEO ceo = new CEO();
        SkirtBuilder builder = new SkirtBuilder(ceo);
        builder.addWaist(110);
        assertEquals(false,builder.isValidWaist());
    }

    @Test
    void checkersShouldReturnTrue() {
        CEO ceo = new CEO();
        SkirtBuilder builder = new SkirtBuilder(ceo);
        builder.addPattern("Checkers");
        assertEquals(true,builder.isValidPattern());
    }
    @Test
    void flowersShouldReturnTrue() {
        CEO ceo = new CEO();
        SkirtBuilder builder = new SkirtBuilder(ceo);
        builder.addPattern("flowers");
        assertEquals(true,builder.isValidPattern());
    }
    @Test
    void circlesShouldReturnTrue() {
        CEO ceo = new CEO();
        SkirtBuilder builder = new SkirtBuilder(ceo);
        builder.addPattern("Circles");
        assertEquals(true,builder.isValidPattern());
    }
    @Test
    void squaresShouldReturnFalse() {
        CEO ceo = new CEO();
        SkirtBuilder builder = new SkirtBuilder(ceo);
        builder.addPattern("Squares");
        assertEquals(false,builder.isValidPattern());
    }

    @org.junit.jupiter.api.Test
    void builderShouldThrowException() {
        // Pants are not configured correctly and builder should throw IllegalArgumentException
        CEO ceo = new CEO();
        SkirtBuilder builder = new SkirtBuilder(ceo);
        assertThrows(IllegalArgumentException.class,() -> builder.build() );
    }
    @org.junit.jupiter.api.Test
    void builderShouldReturnSkirt() {
        // Pants are not configured correctly and builder should throw IllegalArgumentException
        CEO ceo = new CEO();
        Skirt skirt ;
        SkirtBuilder builder = new SkirtBuilder(ceo);
        builder.addMaterial("Cotton");
        builder.addWaist(50);
        builder.addPattern("Checkers");
        skirt = builder.build();
        assertEquals("Checkers",skirt.getPattern());
        assertEquals("Cotton",skirt.getMaterial());
        assertEquals(50,skirt.getWaistline());
    }

    @Test
    void build() {
    }
}