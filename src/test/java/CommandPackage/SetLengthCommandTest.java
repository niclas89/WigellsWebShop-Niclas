package CommandPackage;

import BuisnessObjects.Pants;
import BuisnessObjects.TShirt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SetLengthCommandTest {
    @Test
    void verifySetLength(){
        SetLengthCommand mockCommand = mock(SetLengthCommand.class);
        Pants pants = new Pants();
        doNothing().when(mockCommand).setLength(pants,130);
        mockCommand.setLength(pants,130);
        verify(mockCommand,times(1)).setLength(pants,130);
    }

    @Test
    void verifyExecute(){
        SetLengthCommand mockCommand = mock(SetLengthCommand.class);
        doNothing().when(mockCommand).execute();
        mockCommand.execute();
        verify(mockCommand,times(1)).execute();
    }

}