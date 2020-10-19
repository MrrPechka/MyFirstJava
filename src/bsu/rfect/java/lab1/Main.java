package bsu.rfect.java.lab1;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception  {
        Food[] breakfast = new Food[20];
        int itemsSoFar = 0;
        boolean flag1 = false, flag2 = false;
        for (String arg: args) {
            String[] parts = arg.split("/");
            try {
                Class myClass = Class.forName("bsu.rfect.java.lab1." + parts[0]);
                if (parts.length == 1) {
                    Constructor constructor = myClass.getConstructor();
                    breakfast[itemsSoFar] = (Food) constructor.newInstance();
                    itemsSoFar++;
                } else if (parts.length == 2) {
                    Constructor constructor = myClass.getConstructor(String.class);
                    breakfast[itemsSoFar] = (Food) constructor.newInstance(parts[1]);
                    itemsSoFar++;
                } else if (parts.length == 3) {
                    Constructor constructor = myClass.getConstructor(String.class, String.class);
                    breakfast[itemsSoFar] = (Food) constructor.newInstance(parts[1], parts[2]);
                    itemsSoFar++;
                }
            } catch (ClassNotFoundException | NoSuchMethodException ex) {
                if (parts[0].equals("-sort")) {
                    flag1 = true;
                } else if (parts[0].equals("-calories")) {
                    flag2 = true;
                } else if(parts[0].startsWith("-")){
                    System.out.println("Method " + arg + " not implemented!");
                }   else{
                    System.out.println("We cannot add " + arg + " to breakfast!");
                }
            }
        }
        System.out.println("Breakfast menu: ");
        for(Food item_breakfast : breakfast){
            if(item_breakfast != null){
                System.out.print(item_breakfast + ", ");
                System.out.println(" " + item_breakfast.Calculate_Calories());
            } else { break;}
        }
        if(flag1) {
            Arrays.sort(breakfast, new Comparator() {
                public int compare(Object obj1, Object obj2) {
                    if (obj1 == null || ((Food) obj1).name.length() > ((Food) obj2).name.length())
                        return 1;
                    if (obj2 == null || ((Food) obj1).name.length() < ((Food) obj2).name.length())
                        return -1;
                    else return 0;
                }
            });
            System.out.println("\n\nSort breakfast: ");
            for (Food item_breakfast : breakfast) {
                if (item_breakfast != null) {
                    if (item_breakfast.Calculate_Calories() == 0.0) {
                        continue;
                    }
                    item_breakfast.consume();
                    System.out.println(" " + item_breakfast.Calculate_Calories());
                } else break;
            }

            byte ab = 0, as = 0, ch = 0, sht = 0, shch = 0;
            for(Food item_breakfast : breakfast) {
                if (item_breakfast == null)
                    break;
                if (item_breakfast instanceof Cheese){
                    if(item_breakfast.name.equals("Cheese"))
                        ch++;
                }
                if (item_breakfast instanceof Apple){
                    if(((Apple) item_breakfast).getSize().equals("big")){
                        ab++;
                    }
                    if(((Apple) item_breakfast).getSize().equals("small")){
                        as++;
                    }
                }
                if (item_breakfast instanceof Sandwich){
                    if(((Sandwich) item_breakfast).get_filing1().equals("ham")){
                        if (((Sandwich) item_breakfast).get_filing2().equals("tomato")){
                            sht++;
                        }   else if (((Sandwich) item_breakfast).get_filing2().equals("cheese")){
                            shch++;
                        }
                    }
                }
            }
            System.out.println("Number of 'cheese' = " + ch);
            System.out.println("Number of 'Apple big' = " + ab);
            System.out.println("Number of 'Apple small' = " + as);
            System.out.println("Number of 'Sandwich ham tomato' = " + sht);
            System.out.println("Number of 'Sandwich ham cheese' = " + shch);
        }


        if(flag2){
         double calories_count = 0.0;
            for(Food item_breakfast : breakfast){
                if(item_breakfast != null)
                    calories_count += item_breakfast.Calculate_Calories();
                else break;
            }
            System.out.println("\nAll calories: " + calories_count);
        }

        System.out.println("\nGood luck!");
    }
}

