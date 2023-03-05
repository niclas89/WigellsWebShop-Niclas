package BuisnessObjects;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TShirt {
    private String name;
    private int id;

    private double price;
    private int sleeves;
    private int neck;
    private String size;
    private String material;
    private String color;
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    public TShirt(){
        name = "Tshirt";
    };

    public void addPropertyChangeListener(PropertyChangeListener listener){
        this.changeSupport.addPropertyChangeListener(listener);
    }

    public PropertyChangeSupport getChangeSupport() {
        return changeSupport;
    }

    public void setChangeSupport(PropertyChangeSupport changeSupport) {
        this.changeSupport = changeSupport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        this.changeSupport.firePropertyChange("Tshirt finnished",false,true);
    }

    public int getSleeves() {
        return sleeves;
    }

    public void setSleeves(int sleeves) {
        this.sleeves = sleeves;
    }

    public int getNeck() {
        return neck;
    }

    public void setNeck(int neck) {
        this.neck = neck;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
        this.changeSupport.firePropertyChange("New Tshirt being made",false,true);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
