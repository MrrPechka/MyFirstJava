package bsu.rfect.java.lab1;

public class Cheese extends Food {
    private Double calories;

    public Cheese() {
        super("Cheese");
    }
    public void consume() {
        System.out.println(this + " eaten");
    }

    public Double Calculate_Calories(){
        if(this.name == "Cheese"){ return calories = 20.0; }
        else return 0.0;
    }
}

