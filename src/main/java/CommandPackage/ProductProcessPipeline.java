package CommandPackage;

import java.util.ArrayList;

public class ProductProcessPipeline {
    private ArrayList<ProductCommand> pipeLine = new ArrayList<>();

    public void addCommand(ProductCommand command){
        pipeLine.add(command);
    }

    public void execute(){
        for(ProductCommand command:pipeLine){
            command.execute();
            try{
                Thread.sleep(1000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
                execute();
            }

        }
        pipeLine.clear();
    }
}
