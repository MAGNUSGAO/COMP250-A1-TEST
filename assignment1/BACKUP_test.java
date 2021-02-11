package assignment1;
import java.util.Arrays;

public class BACKUP_test {
  // Test the output of Basket toString
    // This method tests whether the program outputs "-" for prices when a product's price is 0 (aka Free!)
    public static void test_Basket_toString() {
        Basket basket = new Basket();
        basket.add(new Egg("FreeEgg", 100, 0));
        basket.add(new Fruit("Fuji Apple", 2.0, 100));
        // Comment out the line after if you want to see what your program prints
        // System.out.println(basket.toString());
        String expected = "FreeEgg\t-\n" +
                "Fuji Apple\t2.00\n" +
                "\n" +
                "Subtotal\t2.00\n" +
                "Total Tax\t-\n" +
                "\n" +
                "Total Cost\t2.00";
        String actual = basket.toString().trim();
        if (!actual.equals(expected))
            throw new AssertionError("Incorrect format ");
        System.out.println("Basket toString test passed. Good job!");
    }
    
  // This method tests if the only item taxed in the basket is Jam (No tax on Egg and fruit)
    public static void test_Basket_Jam_toString() {
        Basket basket2 = new Basket();
        basket2.add(new Egg("Large Egg", 10, 133));
        basket2.add(new Fruit("Fuji Apple", 2.0, 100));
        basket2.add(new Jam("Apple Jam", 10, 120));
        String expected = "Large Egg\t1.10\n" +
                "Fuji Apple\t2.00\n" +
                "Apple Jam\t12.00\n" +
                "\n" +
                "Subtotal\t15.10\n" +
                "Total Tax\t1.80\n" +
                "\n" +
                "Total Cost\t16.90";
        String actual = basket2.toString().trim();
        // Comment out the next line to see what your basket printed
        // System.out.println(basket2.toString());
        if (!actual.equals(expected))
            throw new AssertionError("Incorrect format ");
        System.out.println("Basket toString test2 passed. Treat yourself with a shot of Java Coffee!");
    }
  
    //equals() test for Jam, testing if two Jams of the same price match
    public static void Jam_Equal1(){
        Jam tomatoJam = new Jam("tomatoJam", 12, 120);
        Jam expensiveTomatoJam = new Jam("tomatoJam", 6, 240);
        if(tomatoJam.equals(expensiveTomatoJam)){
            throw new AssertionError("The two have the same cost, but they aren't equal.");
        }else{
            System.out.println("Jam_Equal1 Passed successfully! Good Job Future Steve Jobs!");
        }

    }

    //equals() test for Jam, testing with Jam and a random Object
    public static void Jam_Equal2() {
        Jam tomatoJam = new Jam("tomatoJam", 12, 120);
        Object randomObject = new Object();
        if (tomatoJam.equals(randomObject)) {
            throw new AssertionError("Equal2 failed. You can't compare Jam with another RandomObject!");
        } else {
            System.out.println("Jam_Equal2 Passed successfully! You'll get that FAANG internship!");
        }
    }
    
    // this basket_remove checks these things: whether the items were removed, how many items are left
    public static void Basket_Remove2() {
        Basket myBasket = new Basket();
        myBasket.add(new Egg("organic Eggs",5,380));
        myBasket.add(new Fruit("Fruit1",1.2,380));
        myBasket.add(new Fruit("Fruit1",1.2,380));
        myBasket.add(new Fruit("red Berry",1.5,380));
        myBasket.add(new Fruit("Random fruit",1.1,340));
        int originalNumberOfProducts = myBasket.getProducts().length;
        Boolean a = myBasket.remove(new Fruit("Fruit1",1.2,380));
        Boolean b = myBasket.remove(new Egg("organic Eggs",5,380));
        //System.out.println(Arrays.toString(myBasket.getProducts()));

        // check how many items there are left
        int numberOfProducts = 0;
        for (int i = 0; i < (myBasket.getProducts().length); i++){
            if (myBasket.getProducts()[i] != null){
                numberOfProducts ++;
            }
        }
        int difference = originalNumberOfProducts - numberOfProducts;
        if(!a || !b){

            throw new AssertionError("Expected: " + "a=true & b=false"
                    + " but obtained: " + "a=" + a + " & b=" + b);
            //test if there are nulls in the array
        } else if (numberOfProducts < (myBasket.getProducts().length)){
          System.out.println(Arrays.toString(myBasket.getProducts()));
          throw new AssertionError("There is a null in your array. If it is at the end, don't worry. If not, check if there's empty slot in your array");
            // tells you how many products are left
        } else if ((difference) != 2){
            throw new AssertionError("There were " + originalNumberOfProducts + " Products, the tester removed 2. You have" + numberOfProducts);
        }

        System.out.println("Basket remove test passed. I'm sure Prof.Alberini will be proud of you.");
    }
  
    public static void main(String[] args) {
        test_Basket_toString();
        test_Basket_Jam_toString();
        Jam_Equal1();
        Jam_Equal2();
        // Basket_remove2 assumes there's no empty space in your array at the end. If you have empty slots at the end, they are allowed, but not preferred
        Basket_Remove2();
     
    }
}
