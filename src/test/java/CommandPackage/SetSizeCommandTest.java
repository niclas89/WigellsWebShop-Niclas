package CommandPackage;

import BuisnessObjects.Pants;
import BuisnessObjects.Skirt;
import BuisnessObjects.TShirt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SetSizeCommandTest {
    @Test
    void verifySetSizeTshirt(){
        SetSizeCommand mockCommand = mock(SetSizeCommand.class);
        TShirt tShirt = new TShirt();
        doNothing().when(mockCommand).setSize(tShirt,"Regular");
        mockCommand.setSize(tShirt,"Regular");
        verify(mockCommand,times(1)).setSize(tShirt,"Regular");
    }
    @Test
    void verifySetSizeSkirt(){
        SetSizeCommand mockCommand = mock(SetSizeCommand.class);
        Skirt Skirt = new Skirt();
        doNothing().when(mockCommand).setSize(Skirt,"Regular");
        mockCommand.setSize(Skirt,"Regular");
        verify(mockCommand,times(1)).setSize(Skirt,"Regular");
    }
    @Test
    void verifySetSizePants(){
        SetSizeCommand mockCommand = mock(SetSizeCommand.class);
        Pants pants = new Pants();
        doNothing().when(mockCommand).setSize(pants,"Regular");
        mockCommand.setSize(pants,"Regular");
        verify(mockCommand,times(1)).setSize(pants,"Regular");
    }
    @Test
    void verifyExecute(){
        SetSizeCommand mockCommand = mock(SetSizeCommand.class);
        doNothing().when(mockCommand).execute();
        mockCommand.execute();
        verify(mockCommand,times(1)).execute();
    }



}