package CommandPackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductProcessPipelineTest {

    @Test
    void verifyAddCommand(){
        ProductProcessPipeline mockPipeline = mock(ProductProcessPipeline.class);
        SetColorCommand command = new SetColorCommand();
        doNothing().when(mockPipeline).addCommand(command);
        mockPipeline.addCommand(command);
        verify(mockPipeline,times(1)).addCommand(command);
    }

    @Test
    void verifyExecute(){
        ProductProcessPipeline mockPipeline = mock(ProductProcessPipeline.class);
        doNothing().when(mockPipeline).execute();
        mockPipeline.execute();
        verify(mockPipeline,times(1)).execute();
    }

}