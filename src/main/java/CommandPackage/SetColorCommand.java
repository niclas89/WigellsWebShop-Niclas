package CommandPackage;

import BuisnessObjects.Pants;
import BuisnessObjects.Skirt;
import BuisnessObjects.TShirt;

public class SetColorCommand implements ProductCommand {
     private TShirt shirt;
     private Pants pants;
     private Skirt skirt;
     private String color;

     private int objectType = 0;

    public void setColor(TShirt shirt,String color){
        this.shirt = shirt;
        this.color = color;
        objectType = 1;
    }
    public void setColor(Pants pants,String color){
        this.pants = pants;
        this.color = color;
        objectType = 2;
    }
    public void setColor(Skirt skirt,String color){
        this.skirt = skirt;
        this.color = color;
        objectType = 3;

    }


    @Override
    public void execute() {
        switch (objectType){
            case 1: shirt.setColor(color);
                System.out.println("Shirt color set to:"  + color);
            break;
            case 2: pants.setColor(color);
                System.out.println("Pants color set to:" + color);
            break;
            case 3: skirt.setColor(color);
                System.out.println("Skirt color set to:" + color);
            break;
        }
    }
}
