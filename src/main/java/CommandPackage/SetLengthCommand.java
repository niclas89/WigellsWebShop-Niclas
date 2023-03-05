package CommandPackage;

import BuisnessObjects.Pants;

public class SetLengthCommand implements ProductCommand{
    private Pants pants;
    private int length;


    public void setLength(Pants pants,int length){
        this.pants = pants;
        this.length = length;
    }


    @Override
    public void execute() {
        pants.setLength(length);
        System.out.println("Pants:" +" Length set to:" + length +"Cm" );
    }
}
