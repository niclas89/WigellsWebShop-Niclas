package Builders;

import BuisnessObjects.CEO;
import BuisnessObjects.Pants;

import static org.junit.jupiter.api.Assertions.*;

class PantsBuilderTest {


    // Tests for material
    @org.junit.jupiter.api.Test
    void CottonShouldReturnTrue() {
        CEO ceo = new CEO();
        PantsBuilder builder = new PantsBuilder(ceo);
        builder.addMaterial("Cotton");
        assertTrue(builder.isValidMaterial());
    }
    @org.junit.jupiter.api.Test
    void PolyesterShouldReturnTrue() {
        CEO ceo = new CEO();
        PantsBuilder builder = new PantsBuilder(ceo);
        builder.addMaterial("Polyester");
        assertTrue(builder.isValidMaterial());
    }
    @org.junit.jupiter.api.Test
    void WoolShouldReturnFalse() {
        CEO ceo = new CEO();
        PantsBuilder builder = new PantsBuilder(ceo);
        builder.addMaterial("Wool");
        assertEquals(false,builder.isValidMaterial());
    }


     // Tests for type

    @org.junit.jupiter.api.Test
    void RegularShouldReturnTrue() {
        CEO ceo = new CEO();
        PantsBuilder builder = new PantsBuilder(ceo);
        builder.addType("Regular");
        assertTrue(builder.isValidType());
    }
    @org.junit.jupiter.api.Test
    void ShortsShouldReturnTrue() {
        CEO ceo = new CEO();
        PantsBuilder builder = new PantsBuilder(ceo);
        builder.addType("Shorts");
        assertTrue(builder.isValidType());
    }
    @org.junit.jupiter.api.Test
    void LongShortsShouldReturnTrue() {
        CEO ceo = new CEO();
        PantsBuilder builder = new PantsBuilder(ceo);
        builder.addType("LongShorts");
        assertTrue(builder.isValidType());
    }
    // Tests for fit
    @org.junit.jupiter.api.Test
    void slimShouldReturnTrue() {
        CEO ceo = new CEO();
        PantsBuilder builder = new PantsBuilder(ceo);
        builder.addFit("Slim");
        assertTrue(builder.isValidFit());
    }
    @org.junit.jupiter.api.Test
    void baggyShouldReturnTrue() {
        CEO ceo = new CEO();
        PantsBuilder builder = new PantsBuilder(ceo);
        builder.addFit("Baggy");
        assertTrue(builder.isValidFit());
    }
    @org.junit.jupiter.api.Test
    void regularShouldReturnTrue() {
        CEO ceo = new CEO();
        PantsBuilder builder = new PantsBuilder(ceo);
        builder.addFit("Regular");
        assertTrue(builder.isValidFit());
    }
    @org.junit.jupiter.api.Test
    void testShouldReturnFalse() {
        CEO ceo = new CEO();
        PantsBuilder builder = new PantsBuilder(ceo);
        builder.addFit("Test");
        assertEquals(false,builder.isValidFit());
    }

    // Test for build method
    @org.junit.jupiter.api.Test
    void builderShouldThrowException() {
        // Pants are not configured correctly and builder should throw IllegalArgumentException
        CEO ceo = new CEO();
        PantsBuilder builder = new PantsBuilder(ceo);
        assertThrows(IllegalArgumentException.class,() -> builder.build() );
    }
    @org.junit.jupiter.api.Test
    void builderShouldReturnPants() {
        // Pants are not configured correctly and builder should throw IllegalArgumentException
        CEO ceo = new CEO();
        Pants pants;
        PantsBuilder builder = new PantsBuilder(ceo);
       builder.addMaterial("Cotton");
       builder.addType("Shorts");
       builder.addFit("Slim");
        pants = builder.build();
        assertEquals("Cotton",pants.getMaterial());
        assertEquals("Shorts",pants.getType());
        assertEquals("Slim",pants.getFit());
    }

}