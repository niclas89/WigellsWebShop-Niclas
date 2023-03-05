package CommandPackage;

import BuisnessObjects.Pants;
import BuisnessObjects.Skirt;
import BuisnessObjects.TShirt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SetColorCommandTest {

    @Test
    void verifySetColorTShirt(){
        SetColorCommand command = mock(SetColorCommand.class);
        TShirt tShirt = new TShirt();
        doNothing().when(command).setColor(tShirt,"Black");
        command.setColor(tShirt,"Black");
        verify(command,times(1)).setColor(tShirt,"Black");
    }
    @Test
    void verifySetColorSkirt(){
        SetColorCommand command = mock(SetColorCommand.class);
        Pants pants = new Pants();
        doNothing().when(command).setColor(pants,"Black");
        command.setColor(pants,"Black");
        verify(command,times(1)).setColor(pants,"Black");
    }
    @Test
    void verifySetColorPants(){
        SetColorCommand command = mock(SetColorCommand.class);
        Skirt skirt = new Skirt();
        doNothing().when(command).setColor(skirt,"Blue");
        command.setColor(skirt,"Blue");
        verify(command,times(1)).setColor(skirt,"Blue");
    }
    @Test
    void verifyExecute(){
        SetColorCommand command = mock(SetColorCommand.class);
        command.execute();
        verify(command,times(1)).execute();
    }



}