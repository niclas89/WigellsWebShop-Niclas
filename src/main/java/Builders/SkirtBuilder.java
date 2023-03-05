package Builders;

import BuisnessObjects.Skirt;

import java.beans.PropertyChangeListener;

public class SkirtBuilder {
    private Skirt skirt = new Skirt();
    private String [] validMaterials = {"Polyester","Cotton"};
    private String [] validPatterns = {"Checkers","Circles", "Flowers"};
    private int [] validWaistS = {50,75,100};
    private  boolean  validWaist, validPattern, validMaterial;

    public boolean isValidWaist() {
        return validWaist;
    }

    public boolean isValidPattern() {
        return validPattern;
    }

    public boolean isValidMaterial() {
        return validMaterial;
    }

    public SkirtBuilder(){
        validWaist = false;
        validPattern = false;
        validMaterial = false;
    }
    public SkirtBuilder(PropertyChangeListener listener){
        validWaist = false;
        validPattern = false;
        validMaterial = false;
        skirt.addPropertyChangeListener(listener);
    }

    public SkirtBuilder addMaterial(String material){
        for (String s : validMaterials) {
            if (material.equalsIgnoreCase(s)) {
                skirt.setMaterial(material);
                validMaterial = true;
            }
        }
        return this;
    }


    public SkirtBuilder addWaist(int waist){
        for (int j : validWaistS) {
            if (waist == j) {
                skirt.setWaistline(waist);
                validWaist = true;
            }
        }

        return this;
    }

    public SkirtBuilder addPattern(String pattern){
        for (String s : validPatterns) {
            if (pattern.equalsIgnoreCase(s)) {
                skirt.setPattern(pattern);
                validPattern = true;
            }
        }
        return  this;
    }

    public Skirt build(){
        if( validWaist && validPattern && validMaterial){
            validWaist = false;
            validPattern = false;
            validMaterial = false;
            return skirt;
        }else throw new IllegalArgumentException("Invalid Configuration");
    }
}
