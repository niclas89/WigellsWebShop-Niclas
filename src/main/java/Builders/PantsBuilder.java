package Builders;

import BuisnessObjects.Pants;

import java.beans.PropertyChangeListener;

public class PantsBuilder {
  private Pants pants = new Pants();
  private String [] validMaterials = {"Cotton","Polyester"};
  private String [] validTypes = {"Regular", "Shorts", "LongShorts"};
  private String [] validFits = {"Slim", "Regular", "Baggy"};
  private int [] validLengths = {130,140,150};

  private boolean validMaterial, validType, validFit;

  public PantsBuilder(PropertyChangeListener listener){
      validMaterial = false;
      validType = false;
      validFit = false;
      pants.addPropertyChangeListener(listener);
  }
  public PantsBuilder(){
      validMaterial = false;
      validType = false;
      validFit = false;
  }

    public boolean isValidMaterial() {
        return validMaterial;
    }

    public boolean isValidType() {
        return validType;
    }

    public boolean isValidFit() {
        return validFit;
    }

    public PantsBuilder addMaterial(String material){
        for (String s : validMaterials) {
            if (material.equalsIgnoreCase(s)) {
                pants.setMaterial(material);
                validMaterial = true;
            }
        }
      return this;
  }

  public PantsBuilder addType(String type){
      for (String s : validTypes) {
          if (type.equalsIgnoreCase(s)) {
              pants.setType(type);
              validType = true;
          }
      }
      return this;
  }

  public PantsBuilder addFit(String fit){
      for (String s : validFits) {
          if (fit.equalsIgnoreCase(s)) {
              pants.setFit(fit);
              validFit = true;
          }
      }
      return this;
  }

  public Pants build(){
      if(validMaterial && validType && validFit ){
          return pants;
      }else throw new IllegalArgumentException("Invalid Configuration");
  }




}
