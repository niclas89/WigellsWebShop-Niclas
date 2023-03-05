package org.example;

import BuisnessObjects.CEO;
import BuisnessObjects.TShirt;
import CommandPackage.SetSizeCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class ShoppingCartTest {


    @Test
    void verifyStart(){
        ShoppingCart mockCart = mock(ShoppingCart.class);
        doNothing().when(mockCart).start();
        mockCart.start();
        verify(mockCart,times(1)).start();
    }

    @Test
    void verifNewProduct(){
        ShoppingCart mockCart = mock(ShoppingCart.class);
        doNothing().when(mockCart).newProduct(1);
        mockCart.newProduct(1);
        verify(mockCart,times(1)).newProduct(1);
    }


    /*vill testa att den retunera rätt typ av objekt beronde på input
     Men då den får sitt objekt från att att skapa ett TShirtInterFace och ropa på dennas tShirtMenu som kräver userinput
     i flera steg för att bygga ihop en Tshirt så skulle man behöva simulera flertalet UserInputs som måste tima med kallandet på
     dessa metoder, vilket är över mina testkunskaper

     */
    @Test
    void verifyChoosenProduct(){
        CEO ceo = new CEO();
        ShoppingCart shoppingCart = new ShoppingCart();
        //assertEquals(TShirt.class, shoppingCart.choosenProductInterFace(1,ceo));
    }
    @Test
    void verifyAddProduct(){
        TShirt tshirt = new TShirt();
        ShoppingCart mockCart =  mock(ShoppingCart.class);
        doNothing().when(mockCart).addProduct(tshirt);
        mockCart.addProduct(tshirt);
        verify(mockCart,times(1)).addProduct(tshirt);
    }
    @Test
    void verifyCompleteOrder(){
        ShoppingCart mockCart =  mock(ShoppingCart.class);
        doNothing().when(mockCart).completeOrder();
        mockCart.completeOrder();
        verify(mockCart,times(1)).completeOrder();
    }
    @Test
    void verifyCreateReceipt(){
        ShoppingCart mockCart =  mock(ShoppingCart.class);
        doNothing().when(mockCart).CreateReceipt();
        mockCart.CreateReceipt();
        verify(mockCart,times(1)).CreateReceipt();
    }
    @Test
    void verifyBuildReceipt(){
        ShoppingCart mockCart = mock(ShoppingCart.class);
        doNothing().when(mockCart).buildReceipt("Test");
        mockCart.buildReceipt("Test");
        verify(mockCart,times(1)).buildReceipt("Test");
    }

    @Test
    void verifyPrintReceipt(){
        ShoppingCart mockCart = mock(ShoppingCart.class);
        doNothing().when(mockCart).printReceipt();
        mockCart.printReceipt();
        verify(mockCart,times(1)).printReceipt();
    }
    @Test
    void verifyPrintShoppingCart(){
        ShoppingCart mockCart = mock(ShoppingCart.class);
        doNothing().when(mockCart).printShoppingCart();
        mockCart.printShoppingCart();
        verify(mockCart,times(1)).printShoppingCart();
    }




}