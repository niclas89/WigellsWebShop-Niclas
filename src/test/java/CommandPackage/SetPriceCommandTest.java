package CommandPackage;

import BuisnessObjects.Pants;
import BuisnessObjects.Skirt;
import BuisnessObjects.TShirt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SetPriceCommandTest {
    @Test
    void verifySetPriceTshirt(){
        SetPriceCommand mockCommand = mock(SetPriceCommand.class);
        TShirt tShirt = new TShirt();
        doNothing().when(mockCommand).setPrice(tShirt,150);
        mockCommand.setPrice(tShirt,150);
        verify(mockCommand,times(1)).setPrice(tShirt,150);
    }
    @Test
    void verifySetPriceSkirt(){
        SetPriceCommand mockCommand = mock(SetPriceCommand.class);
        Skirt skirt = new Skirt();
        doNothing().when(mockCommand).setPrice(skirt,150);
        mockCommand.setPrice(skirt,150);
        verify(mockCommand,times(1)).setPrice(skirt,150);
    }
    @Test
    void verifySetPriceTPants(){
        SetPriceCommand mockCommand = mock(SetPriceCommand.class);
        Pants pants = new Pants();
        doNothing().when(mockCommand).setPrice(pants,150);
        mockCommand.setPrice(pants,150);
        verify(mockCommand,times(1)).setPrice(pants,150);
    }

    @Test
    void verifyExecute(){
        SetPriceCommand mockCommand = mock(SetPriceCommand.class);
        doNothing().when(mockCommand).execute();
        mockCommand.execute();
        verify(mockCommand,times(1)).execute();
    }

}