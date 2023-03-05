package BuisnessObjects;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Pants {
    private String name;
    private int id;

    private double price;
    private int length;
    private String size;
    private String fit;
    private String material;
    private String color;

    private String type;
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);




    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);

    }

    public Pants(){
        this.name = "Pants";
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        this.changeSupport.firePropertyChange("Pants finnished",false ,true);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.changeSupport.firePropertyChange("New pants being made",false,true);
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
