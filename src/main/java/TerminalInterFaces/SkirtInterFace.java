package TerminalInterFaces;

import Builders.SkirtBuilder;
import BuisnessObjects.Skirt;

import java.beans.PropertyChangeListener;

import static TerminalInterFaces.UserInterFace.inputHandler;

public class SkirtInterFace {

    public Skirt skirtMenu(PropertyChangeListener listener){
        SkirtBuilder builder = new SkirtBuilder(listener);
        builder
                .addMaterial(material())
                .addWaist(waist())
                .addPattern(pattern());
        return builder.build();
    }
    public String material(){
        String material;
        System.out.println("Choose Material");
        System.out.println("1:Cotton    2:Polyester");
        if(inputHandler(1,2) == 1){
            material = "Cotton";
        }else material = "Polyester";
        return material;
    }

    public int waist(){
        System.out.println("Choose waist Size");
        System.out.println("1:50cm    2:75cm");
        System.out.println("3:100cm");
        int waist;
        switch (inputHandler(1,3)){
            case 1: waist = 50;
            break;
            case 2: waist = 75;
            break;
            default: waist = 100;
        }
        return waist;
    }

    public String pattern(){
        System.out.println("Choose Pattern");
        System.out.println("1:Checkers    2:Circles");
        System.out.println("3:Flowers");
        String pattern;
        switch (inputHandler(1,3)){
            case 1: pattern = "Checkers";
            break;
            case 2: pattern = "Circles";
            break;
            default: pattern = "Flowers";
        }
        return pattern;
    }
}
