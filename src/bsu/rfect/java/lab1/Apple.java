package bsu.rfect.java.lab1;

public class Apple extends Food {

    private String size;
    private Double calories;

    public Apple(String size) {
        super("Apple");
        this.size = size;
    }

    public Double Calculate_Calories(){
        if(this.size.equals("big")){ return calories = 15.0; }
        else if(this.size.equals("small")){ return calories = 10.0; }
        else return 0.0;
    }
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            if (!(obj instanceof Apple)) return false;
            return size.equals(((Apple)obj).size);
        } else return false;
    }

    public String toString() { return super.toString() + " size '" + size + "'"; }
    public void consume() { System.out.println(this + " eaten"); }
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
}
