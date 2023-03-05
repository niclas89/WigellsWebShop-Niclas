package CommandPackage;

import BuisnessObjects.Pants;
import BuisnessObjects.Skirt;
import BuisnessObjects.TShirt;

public class SetSizeCommand implements ProductCommand {
    private TShirt shirt;
    private Pants pants;
    private Skirt skirt;
    private String size;

    private int objectType = 0;

    public void setSize(TShirt shirt,String size){
        this.shirt = shirt;
        this.size = size;
        objectType = 1;
    }
    public void setSize(Pants pants,String size){
        this.pants = pants;
        this.size = size;
        objectType = 2;
    }
    public void setSize(Skirt skirt,String size){
        this.skirt = skirt;
        this.size = size;
        objectType = 3;

    }



    @Override
    public void execute() {
        switch (objectType){
            case 1: shirt.setSize(size);
                System.out.println("Shirt size set to:"  + size);
                break;
            case 2: pants.setSize(size);
                System.out.println("Pants size set to:" + size);
                break;
            case 3: skirt.setSize(size);
                System.out.println("Skirt size set to:" + size);
                break;
        }
    }
}
