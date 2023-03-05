package TerminalInterFaces;

import Builders.PantsBuilder;
import BuisnessObjects.Pants;

import java.beans.PropertyChangeListener;

import static TerminalInterFaces.UserInterFace.inputHandler;

public class PantsInterFace {

    public Pants pantsMenu(PropertyChangeListener listener){
        PantsBuilder builder = new PantsBuilder(listener);
        builder
                .addMaterial(material())
                .addType(type())
                .addFit(fit());

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
    public String type(){
        String type;
        System.out.println("Choose type");
        System.out.println("1:Regular    2:Shorts"+'\n'+"3:LongShorts");
        switch (inputHandler(1,3)){
            case 1: type = "Regular";
            break;
            case 2: type = "Shorts";
            break;
            default: type = "LongShorts";
        }
        return type;
    }
    public String fit(){
        String fit;
        System.out.println("Chose fit");
        System.out.println("1:Slim    2:Regular"+'\n'+"3:Baggy");
        switch (inputHandler(1,3)){
            case 1: fit = "Slim";
            break;
            case 2: fit = "Regular";
            break;
            default: fit = "Baggy";
        }
        return fit;
    }
}
