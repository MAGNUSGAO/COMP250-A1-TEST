package assignment1;

public class test {
  // Test the output of Basket toString
    // This method tests whether the program outputs "-" for prices when a product's price is 0 (aka Free!)
    public static void test_Basket_toString() {
        Basket basket = new Basket();
        basket.add(new Egg("NoEgg", 100, 0));
        basket.add(new Fruit("Fuji Apple", 2.0, 100));
        // Comment out the line after if you want to see what your program prints
        // System.out.println(basket.toString());
        String expected = "NoEgg\t-\n" +
                "Fuji Apple\t2.00\n" +
                "\n" +
                "Subtotal\t2.00\n" +
                "Total Tax\t-\n" +
                "\n" +
                "Total Cost\t2.00";
        String actual = basket.toString().trim();
        if (!actual.equals(expected))
            throw new AssertionError("Incorrect format ");
        System.out.println("Basket toString test passed. ");
    }
    
    public static void main(String[] args) {
        test_Basket_toString();
    }
}
