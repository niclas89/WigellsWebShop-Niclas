package Builders;

import BuisnessObjects.TShirt;
import java.beans.PropertyChangeListener;


public class TShirtBuilder {
    private TShirt tShirt = new TShirt();
    private String [] validMaterials = {"Cotton","Polyester"};
    private boolean validSleeve, validNeck, validMaterial;

    public TShirtBuilder(PropertyChangeListener listener){
        validSleeve = false;
        validNeck = false;
        validMaterial = false;
        tShirt.addPropertyChangeListener(listener);
    }
    public TShirtBuilder(){
        validSleeve = false;
        validNeck = false;
        validMaterial = false;
    }

    public boolean isValidSleeve() {
        return validSleeve;
    }

    public boolean isValidNeck() {
        return validNeck;
    }

    public boolean isValidMaterial() {
        return validMaterial;
    }

    public TShirtBuilder addSleve(int sleveLength){
      if(sleveLength >= 10 && sleveLength <= 20){
          tShirt.setSleeves(sleveLength);
          validSleeve = true;
      }
      return this;
  }
  public TShirtBuilder addNeck(int neckSize){
      if(neckSize >= 30 && neckSize <= 50){
          tShirt.setNeck(neckSize);
          validNeck = true;
      }
      return this;
  }
  public TShirtBuilder addMaterial(String material){
      for (String s : validMaterials) {
          if (material.equalsIgnoreCase(s)) {
              tShirt.setMaterial(material);
              validMaterial = true;
          }
      }
      return this;

  }
  public TShirt build(){
      if(validNeck && validSleeve && validMaterial) {
          return tShirt;
      }else throw new IllegalArgumentException("Invalid Configuration");
  }
}
