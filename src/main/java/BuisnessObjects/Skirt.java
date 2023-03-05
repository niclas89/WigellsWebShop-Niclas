package BuisnessObjects;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Skirt {
    private String name;
    private int id;
    private double price;
    private int waistline;
    private String size;
    private String material;
    private String pattern;
    private String color;

    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);



    public Skirt(){
        name = "Skirt";
    };
    public void addPropertyChangeListener(PropertyChangeListener listener){
        this.changeSupport.addPropertyChangeListener(listener);
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
        this.changeSupport.firePropertyChange("Skirt finnished",false,true);
    }

    public int getWaistline() {
        return waistline;
    }

    public void setWaistline(int waistline) {
        this.waistline = waistline;
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
        this.changeSupport.firePropertyChange("New Skirt being made",false, true);
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
