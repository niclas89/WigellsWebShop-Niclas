package TerminalInterFaces;

import Builders.TShirtBuilder;
import BuisnessObjects.TShirt;

import java.beans.PropertyChangeListener;

import static TerminalInterFaces.UserInterFace.inputHandler;

public class TshirtInterFace {
    public TShirt TshirtMenu(PropertyChangeListener listener) {
        TShirtBuilder tShirtBuilder = new TShirtBuilder(listener);
        tShirtBuilder
                .addMaterial(material())
                .addSleve(sleeveLength())
                .addNeck(neckLength());
        return tShirtBuilder.build();
    }

    public int sleeveLength() {
        int sleeve = 0;
        System.out.println("Choose sleeve Length ");
        System.out.println("1: 10cm    2:15cm");
        System.out.println("3: 20cm");
        switch (inputHandler(1,3)) {
            case 1: sleeve = 10;
            break;
            case 2: sleeve = 15;
            break;
            case 3: sleeve = 20;
        }
        return sleeve;
    }

    public int neckLength(){
        int neck = 0;
        System.out.println("Choose Neck Length");
        System.out.println("1: 30cm    2:40cm");
        System.out.println("3: 50cm");
        switch (inputHandler(1,3)){
            case 1: neck = 30;
            break;
            case 2: neck = 40;
            break;
            case 3: neck = 50;

        }
        return neck;
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



}
