package CommandPackage;

import BuisnessObjects.Pants;
import BuisnessObjects.Skirt;
import BuisnessObjects.TShirt;

public class SetPriceCommand implements ProductCommand{
    private TShirt shirt;
    private Pants pants;
    private Skirt skirt;
    private int price;

    private int objectType = 0;

    public void setPrice(TShirt shirt,int price){
        this.shirt = shirt;
        this.price = price;
        objectType = 1;
    }
    public void setPrice(Pants pants,int price){
        this.pants = pants;
        this.price = price;
        objectType = 2;
    }
    public void setPrice(Skirt skirt,int price){
        this.skirt = skirt;
        this.price = price;
        objectType = 3;

    }



    @Override
    public void execute() {
        switch (objectType){
            case 1:
                System.out.println("Shirt price set to:"  + price);
                shirt.setPrice(price);
                break;
            case 2:
                System.out.println("Pants price set to:" + price);
                pants.setPrice(price);
                break;
            case 3:
                System.out.println("Skirt price set to:" + price);
                skirt.setPrice(price);
                break;
        }
    }
}
