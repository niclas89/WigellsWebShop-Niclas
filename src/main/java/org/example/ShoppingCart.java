package org.example;

import BuisnessObjects.*;
import CommandPackage.*;
import TerminalInterFaces.PantsInterFace;
import TerminalInterFaces.SkirtInterFace;
import TerminalInterFaces.TshirtInterFace;
import TerminalInterFaces.UserInterFace;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ShoppingCart {
    private final ArrayList<Object> products = new ArrayList<>();
    private ProductProcessPipeline pipeline = new ProductProcessPipeline();

    private String receipt;
    private int productId;
    private CEO ceo = new CEO();
    private Customer customer;
    private boolean newCustomer;
    private UserInterFace userInterFace = new UserInterFace();

    public ShoppingCart(){
        newCustomer = true;
    }


    /*
       Start metod
       Som anropar interface för att ta emot namn på användaren vid första körningen,
       Därefter använder den sig av UserInterFace start metod för att avgöra vad användaren vill göra
     */
    public void start(){
        if(newCustomer) {
            customer = new Customer();
            customer.setId(1);
            customer.setName(userInterFace.usersName());
            newCustomer = false;
        }
        switch (userInterFace.start()){
            case 1:
                newProduct(userInterFace.productList());
                break;
            case 2:
                 printShoppingCart();
                 start();
                break;
            case 3:
                System.exit(0);
        }
    }
           /* Metod som skapar upp nya produkter enligt användarens val
              Den tar emot en int som representerar ett produktval, denna vidarebefodras till choosenProductInterFace
              som startar motsvarande terminalInterface så att användaren kan anpassa sitt plagg.
              newProduct tar emot det startade plagget från choosenProductInterFace kontroller vilken typ av plagg
              det är och använder sig sedan av UserInterFace som har metoder för att ta emot val för properties som delas
              mellan plaggen  för att skapa sina commands och dessa läggs sedan till i pipelinen.
              Slutligen får användaren välja mellan att köpa flera plagg, iståfall hoppar den tillbaka till start().
              Alternativt att genomföra köpet och då anropas completeOrder()
            */
    public void newProduct(int choice){
        productId ++;
        SetColorCommand setColorCommand = new SetColorCommand();
        SetSizeCommand setSizeCommand = new SetSizeCommand();
        SetPriceCommand setPriceCommand = new SetPriceCommand();
        Object product = choosenProductInterFace(choice,ceo);
        String productType = product.getClass().getName().substring(product.getClass().getName().indexOf('.')+1);
        switch (productType){
            case "TShirt":
                TShirt shirt = (TShirt) product;
                shirt.setId(productId);
                addProduct(shirt);
                setColorCommand.setColor(shirt, userInterFace.chooseColor());
                setSizeCommand.setSize(shirt, userInterFace.chooseSize());
                setPriceCommand.setPrice(shirt,150);
                break;
            case "Skirt":
                Skirt skirt = (Skirt) product;
                skirt.setId(productId);
                addProduct(skirt);
                setColorCommand.setColor(skirt, userInterFace.chooseColor());
                setSizeCommand.setSize(skirt, userInterFace.chooseSize());
                setPriceCommand.setPrice(skirt, 250);
                break;
            case "Pants":
                Pants pants = (Pants) product;
                pants.setId(productId);
                addProduct(pants);
                SetLengthCommand setLengthCommand = new SetLengthCommand();
                setLengthCommand.setLength(pants, userInterFace.chooseLength());
                pipeline.addCommand(setLengthCommand);
                setColorCommand.setColor(pants, userInterFace.chooseColor());
                setSizeCommand.setSize(pants, userInterFace.chooseSize());
                setPriceCommand.setPrice(pants,400);
                break;
        }
        pipeline.addCommand(setColorCommand);
        pipeline.addCommand(setSizeCommand);
        pipeline.addCommand(setPriceCommand);

        if (userInterFace.completePurchase(products.size()) == 1){
            completeOrder();
        }else {
           start();
        }

    }

    // Tar emot en int som motsvarar ett plagg och startar därefter motsvarande terminalInterFace
    // Retunerar den påbörjade produkten
    public Object choosenProductInterFace(int product, PropertyChangeListener listener){

        switch (product){
            case 1:
                TshirtInterFace tshirtInterFace = new TshirtInterFace();
                TShirt tshirt = tshirtInterFace.TshirtMenu(listener);
                return  tshirt;
            case 2:
                SkirtInterFace skirtInterFace = new SkirtInterFace();
                Skirt skirt = skirtInterFace.skirtMenu(listener);
                return skirt;
            default:
                PantsInterFace pantsInterFace = new PantsInterFace();
                Pants pants = pantsInterFace.pantsMenu(listener);
                return pants;
        }
    }


    public void addProduct(Object product){
        products.add(product);
    }

    // Genomför dom nödvändiga stegen för att fullgöra beställningen
    public void completeOrder() {
        pipeline.execute();
        CreateReceipt();
        System.out.println();
        printReceipt();
        products.clear();
    }

    // Formarterar kvittot utifrån produkterna i products
    public void CreateReceipt(){
        this.receipt = "";
        buildReceipt("Wigells Webshop" + '\n' + "Wigells Street 24  Stockholm" + '\n' + "wigells@support.com" + '\n' + "Customer:" + customer.getName() + '\n');
        double totalPrice = 0;
        double salesTax = 0;
        for(Object product: products){
           String productType = product.getClass().getName().substring(product.getClass().getName().indexOf('.')+1);
           switch (productType){
               case "Pants":
                   Pants pants = (Pants) product;
                   totalPrice += pants.getPrice();
                   buildReceipt(pants.getName() + " " + pants.getType() + " " + pants.getMaterial() + " "+ pants.getSize() +
                           " " + pants.getFit() + " " + pants.getColor() + " " + pants.getPrice() + '\n' );
                   break;
               case "TShirt":
                   TShirt tshirt = (TShirt) product;
                   totalPrice += tshirt.getPrice();
                   buildReceipt(tshirt.getName() + " " + tshirt.getMaterial() + " " + tshirt.getSize()
                   + " " + tshirt.getColor() + " Price:" + tshirt.getPrice()+ '\n');
                   break;
               case "Skirt":
                   Skirt skirt = (Skirt) product;
                   totalPrice += skirt.getPrice();
                   buildReceipt(skirt.getName() + " " + skirt.getMaterial() + " " + skirt.getSize() + " " + skirt.getPattern() + " " +
                           skirt.getColor() + " Price:" + skirt.getPrice() + '\n' );
                   break;

           }

        }
        salesTax = (totalPrice * 0.25);
        buildReceipt("Total price before taxes:" + (totalPrice*0.75) + '\n' +
                "Sales tax:" + salesTax + '\n' + "TotalPrice:" + totalPrice );
    }
    public void buildReceipt(String a){
        this.receipt += a;
    }
    public void printReceipt(){
        System.out.println(receipt);
    }

    // Formaterar en utskrift för att visa produkterna i kundkorgen
    public void printShoppingCart(){
    int i = 1;
    String out = "Shopping cart" +'\n';
    Pants pants;
    Skirt skirt;
    TShirt tShirt;
    for(Object product:products){
        String productType = product.getClass().getName().substring(product.getClass().getName().indexOf('.')+1);
        switch (productType){
            case "Pants":
                pants = (Pants) product;
                out +=  i + ": "+ pants.getName() + " " + pants.getFit() +    '\n';
                break;
            case "Skirt":
                 skirt = (Skirt) product;
                 out += i + ": " + skirt.getName() + " " + skirt.getPattern() +   '\n';
                 break;
            case "TShirt":
                 tShirt = (TShirt) product;
                 out += i + ": " + tShirt.getName() +  '\n';
                 break;
        }
        i++;
    }
        if(out.length()<15){
            out = "Your cart is empty";
        }
        System.out.println(out);

}


}
