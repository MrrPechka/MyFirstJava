package bsu.rfect.java.lab1;

public class Sandwich extends Food {
    private String filing1;
    private String filing2;
    private Double calories;

    public Sandwich(String filing1, String filing2){
        super("Sandwich");
        this.filing1 = filing1;
        this.filing2 = filing2;
    }

    public boolean equals(Object obj){
        if(super.equals(obj)){
            if(!(obj instanceof Sandwich)) return false;
            return (filing1.equals(((Sandwich)obj).filing1) && filing2.equals(((Sandwich)obj).filing2));
        } else return false;
    }

    public String toString(){
        return super.toString() + "'" + filing1 + "/" +filing2 + "'";
    }

    public Double Calculate_Calories(){
        if(this.filing1.equals("ham")){
            if(this.filing2.equals("tomato"))
               return calories = 50.0;

            else if(this.filing2.equals("cheese"))
                return calories = 70.0;

            else return 0.0;
        }
        else return 0.0;
    }

    public String get_filing1(){ return filing1; }
    public void set_filing1(){ this.filing1 = filing1; }
    public String get_filing2(){ return filing2; }
    public void set_filing2(){ this.filing2 = filing2; }
    public void consume(){ System.out.println(this + "eaten"); }
}
