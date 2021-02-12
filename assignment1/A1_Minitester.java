package assignment1;

import java.util.ArrayList;
import java.util.Arrays;


class Basket_JamTax implements Runnable{
    @Override
    public void run() {
        Basket basket = new Basket();
        basket.add(new Jam("jam", 2, 475));
        int result = basket.getTotalTax();
        int expected = 142;
        if (result != expected){
            throw new AssertionError("getTotalTax() returned " + result
            + " but expected " + expected);
        }
        System.out.println("Basket tax test passed.");
    }
}


class Basket_NumOfProduct implements Runnable{
    @Override
    public void run() {
        Basket myBasket = new Basket();
        myBasket.add(new Egg("organic Eggs",5,380));
        int num = myBasket.getNumOfProducts();
        if (num != 1){
            throw new AssertionError("getNumOfProducts() returned " + num
            + " but expected " + 1);
        }
        System.out.println("Basket number of product test passed.");
    }
}


class Basket_Remove implements Runnable {
    @Override
    public void run() {
        Basket myBasket = new Basket();
        myBasket.add(new Egg("organic Eggs",5,380));
        myBasket.add(new Fruit("Blue Berry",1.5,380));
        myBasket.add(new Fruit("Green Berry",1.5,380));
        myBasket.add(new Fruit("red Berry",1.5,380));
        myBasket.add(new Fruit("Random fruit",1.1,340));
        Boolean a = myBasket.remove(new Fruit("Random fruit",1.1,340));
        Boolean b = myBasket.remove(new Egg("Green Berry",3,350));
        if(!a || b){
            throw new AssertionError("Expected: " + "a=true & b=false"
                    + " but obtained: " + "a=" + a + " & b=" + b);
        }
        System.out.println("Basket remove test passed.");
    }
}


class Basket_add implements Runnable{
    @Override
    public void run() {
        Basket basket = new Basket();
        basket.add(new Egg("brown", 24, 4));
        basket.add(new Fruit("Kiwi", 2.0, 100));
        MarketProduct[] l = basket.getProducts();
        int i = l.length -1;
        String expected = "Kiwi";
        String actual = l[i].getName();
        if(!actual.equals(expected))
            throw new AssertionError("Expected the last item to be the Fruit with name \" "
                    + expected + "\" but got the name \"" + actual + "\" instead. ");
        
        System.out.println("Basket add test passed.");
    }
}


class Basket_clear implements Runnable{
    @Override
    public void run() {
        Basket basket = new Basket();
        basket.add(new Egg("brown", 24, 4));
        basket.add(new Fruit("kiwi", 2.0, 100));
        basket.clear();
        MarketProduct[] l = basket.getProducts();
        if (l.length != 0)
            throw new AssertionError("Expected the MarketProduct array to be empty, but it was not. ");
        System.out.println("Basket clear test passed.");
    }
}


class Basket_getSubTotal implements Runnable{
    @Override
    public void run() {
        Basket basket = new Basket();
        basket.add(new Egg("brown", 24, 4));
        basket.add(new Fruit("kiwi", 2.0, 100));
        int expected = 208;
        int actual = basket.getSubTotal();
        if (actual != expected)
            throw new AssertionError("Expected the total cost to be " + expected + " cents, but got "
                    + actual + " cents instead");
        System.out.println("Basket getSubTotal test passed.");
    }
}


class Basket_toString implements Runnable{
    @Override
    public void run() {
        Basket basket = new Basket();
        basket.add(new Egg("brown", 24, 4));
        basket.add(new Fruit("kiwi", 2.0, 100));
        String expected = "brown\t0.08\n" +
                "kiwi\t2.00\n" +
                "\n" +
                "Subtotal\t2.08\n" +
                "Total Tax\t-\n" +
                "\n" +
                "Total Cost\t2.08";
        String actual = basket.toString().trim();
        if (!actual.equals(expected))
            throw new AssertionError("Incorrect format ");
        System.out.println("Basket toString test passed. ");
    }
}


class Customer_addFunds implements Runnable{
    @Override
    public void run() {
        try{
            Customer cust  = new Customer("Alice",890);
            int newFund = cust.addFunds(10);
            int expectedFund = 900;

            if (newFund != expectedFund){
                throw new AssertionError("addFunds returned " + newFund
                + " but expected " + expectedFund);
            }
        }
        catch(IllegalArgumentException e){
            throw new AssertionError("Unexpected IllegalArgumentException raised.");
        }
        System.out.println("Test passed.");
    }
}


class Customer_addFundsException implements Runnable{
    @Override
    public void run() {
        try {
            Customer cust = new Customer("Alice", 890);
            int newFund = cust.addFunds(-10);
            throw new AssertionError("Negative funds added. IllegalArgumentException no raised.");
        }
        catch (IllegalArgumentException e){
            System.out.println("Test passed.");
        }
    }
}


class Customer_addToBasket implements Runnable{
    @Override
    public void run() {
        Customer cust  = new Customer("Alice",900);
        cust.addToBasket(new Egg("Brown Eggs",5,380));
        cust.addToBasket(new Egg("White Eggs",10,400));

        if (cust.getBasket().getNumOfProducts() != 2){
            throw new AssertionError("Products were not added to basket.");
        }

        System.out.println("Test passed.");
    }
}


class Customer_checkOutBalance implements Runnable{
    @Override
    public void run() {
        try{
            Customer cust  = new Customer("Alice",900);
            cust.addToBasket(new Egg("organic Eggs",5,380));
            System.out.println("Balance before checkout: " + cust.getBalance());
            cust.checkOut();
            int newBalance = cust.getBalance();
            System.out.println("Balance after checkout: " + newBalance);
            if (newBalance != 742){
                throw new AssertionError("checkOut did not return correct receipt.");
            }
        }catch (IllegalStateException e){
            throw new AssertionError("Unexpected IllegalStateException raised.");
        }
        System.out.println("Test passed.");
    }
}

class Customer_checkOutBalance2 implements Runnable{
    @Override
    public void run() {
        try{
            Customer cust  = new Customer("Alice",380);
            cust.addToBasket(new Egg("organic Eggs",12,380));
            System.out.println("Balance before checkout: " + cust.getBalance());
            cust.checkOut();
            int newBalance = cust.getBalance();
            System.out.println("Balance after checkout: " + newBalance);
            if (newBalance != 0){
                throw new AssertionError("checkOut did not return correct receipt.");
            }
        }catch (IllegalStateException e){
            throw new AssertionError("Unexpected IllegalStateException raised.");
        }
        System.out.println("Test passed.");
    }
}


class Customer_checkOutException implements Runnable{
    @Override
    public void run() {
        try {
            Customer cust = new Customer("Alice", 10);
            cust.addToBasket(new Fruit("Blue Berry", 1.5, 380));
            cust.checkOut();
            throw new AssertionError("Checkout allowed when insufficient funds. IllegalStateException not raised.");
        }
        catch (IllegalStateException e){
            System.out.println("Test passed.");
        }
    }
}


class Customer_checkOutReceipt implements Runnable{
    @Override
    public void run() {
        try{
            Customer cust  = new Customer("Alice",900);
            cust.addToBasket(new Fruit("Blue Berry",1.5,380));
            String basketBefore = cust.getBasket().toString();
            String receipt = cust.checkOut();
            System.out.println("Receipt:\n" + receipt);
            if (!basketBefore.equals(receipt)){
                throw new AssertionError("checkOut did not return correct receipt.");
            }
        }catch (IllegalStateException e){
            throw new AssertionError("Unexpected IllegalStateException raised.");
        }
        System.out.println("Test passed.");
    }
}


class Customer_getBalance implements Runnable{
    @Override
    public void run() {
        Customer cust  = new Customer("Jane",123);

        if (cust.getBalance() != 123){
            throw new AssertionError("getBalance() did not return correct value.");
        }
        System.out.println("Test passed.");
    }
}


class Customer_getBasket implements Runnable{
    @Override
    public void run() {
        Customer cust  = new Customer("Jane",123);

        if (cust.getBasket() == null){
            throw new AssertionError("getBasket() must not be null.");
        }
        System.out.println("Test passed.");
    }
}


class Customer_getName implements Runnable{
    @Override
    public void run() {
        Customer cust  = new Customer("Jane",123);

        if (!cust.getName().equals(("Jane"))){
            throw new AssertionError("getName() did not return correct value.");
        }
        System.out.println("Test passed.");
    }
}


class Customer_removeFromBasket implements Runnable{
    @Override
    public void run() {
        Customer cust  = new Customer("Alice",900);
        cust.addToBasket(new Egg("Brown Eggs",5,380));
        Fruit product = new Fruit("Blue Berry", 1.5, 500);
        cust.addToBasket(product);
        cust.removeFromBasket(product);
        if (cust.getBasket().getNumOfProducts() != 1){
            throw new AssertionError("Product was not removed from basket.");
        }
        System.out.println("Test passed.");
    }
}


class Egg_Cost implements Runnable {
    @Override
    public void run() {
        Egg fancyEggs = new Egg("Fancy Eggs", 4, 380);
        int costOffancyEggs = fancyEggs.getCost();
        if (costOffancyEggs != 126) {
            throw new AssertionError("getCost() returned " +
                    costOffancyEggs + " but expected " + 126);
        }
        System.out.println("Egg cost test passed.");
    }
}


class Egg_Equal implements Runnable{
    @Override
    public void run() {
        Egg egg1 = new Egg("Fancy Eggs", 4, 380);
        Egg egg2 = new Egg("Fancy Eggs", 4, 380);
        if (!egg1.equals(egg2)){
            throw new AssertionError("equals() doesn't compare two Eggs correctly.");
        }
        System.out.println("Egg equals test passed.");
    }
}


class Egg_Name implements Runnable{
    @Override
    public void run() {
        Egg fancyEggs = new Egg("Fancy Eggs", 4, 380);
        String nameOffancyEggs = fancyEggs.getName();
        if(! nameOffancyEggs.equals("Fancy Eggs")){
            throw new AssertionError("getName() returned " +
                    nameOffancyEggs + " but expected " + "Fancy Eggs");
        }
        System.out.println("Egg name test passed.");
    }
}


class Fruit_Cost implements Runnable {
    @Override
    public void run() {
        Fruit myFruits = new Fruit("Asian Pear",1.25,530);
        int costOfMyFruits = myFruits.getCost();
        int expectedCost = 662;
        if(costOfMyFruits != expectedCost){
            throw new AssertionError("getCost() returned " +
                    costOfMyFruits + " but expected " + expectedCost);
        }
        System.out.println("Fruit cost test passed.");
    }
}


class Fruit_Equal implements Runnable{
    @Override
    public void run() {
        Egg egg = new Egg("Fancy Eggs", 4, 380);
        Fruit fruit = new Fruit("Fancy Eggs", 4, 380);
        if (egg.equals(fruit)){
            throw new AssertionError("equals() doesn't compare Egg with Fruit correctly.");
        }
        System.out.println("Fruit equals test passed.");
    }
}


class Jam_Cost implements Runnable {
    @Override
    public void run() {
        Jam myJam = new Jam("Quince Marmalade",2,475);
        int costOfmyJam = myJam.getCost();
        if(costOfmyJam != 950) {
            throw new AssertionError("getCost() returned " +
                    costOfmyJam + " but expected " + 950);
        }
        System.out.println("Jam cost test passed.");
    }
}


class SeasonalFruit_Cost implements Runnable {
    @Override
    public void run() {
        SeasonalFruit fancyFruit = new SeasonalFruit("Burzul Walnut", 0.5, 480);
        int costOffancyFruit = fancyFruit.getCost();
        if(costOffancyFruit != 204){
            throw new AssertionError("getCost() returned " +
                    costOffancyFruit + " but expected " + 204);
        }
        System.out.printf("SeasonalFruit cost test passed.");
    }
}



//#################################
class oneEggCost implements Runnable {
    @Override
    public void run() {
        Egg fancyEggs = new Egg("Fancy Eggs", 1, 120);
        int costOffancyEggs = fancyEggs.getCost();
        if (costOffancyEggs != 10) {
            throw new AssertionError("getCost() returned " +
                    costOffancyEggs + " but expected " + 10);
        }
        System.out.println("Egg cost test passed.");
    }
}

class oneEggCostRoundDown implements Runnable {
    @Override
    public void run() {
        Egg fancyEggs = new Egg("Fancy Eggs", 1, 126);
        int costOffancyEggs = fancyEggs.getCost();
        if (costOffancyEggs != 10) {
            throw new AssertionError("getCost() returned " +
                    costOffancyEggs + " but expected " + 10);
        }
        System.out.println("Egg cost test passed.");
    }
}

class SeasonalFruit_Cost_1 implements Runnable {
    @Override
    public void run() {
        SeasonalFruit fancyFruit = new SeasonalFruit("Burzul Walnut", 1, 100);
        int costOffancyFruit = fancyFruit.getCost();
        if(costOffancyFruit != 85){
            throw new AssertionError("getCost() returned " +
                    costOffancyFruit + " but expected " + 85);
        }
        System.out.printf("SeasonalFruit cost test passed.");
    }
}

class fullBasket implements Runnable{
    @Override
    public void run() {

        //
        Egg egg3 = new Egg("egg3",12,100);
        Fruit fruit3 = new Fruit("Fruit3",1,100);
        Jam jam3 = new Jam("jam3",1,100);
        SeasonalFruit seasonalFruit2 = new SeasonalFruit("seasonal3", 1, 100);


        Basket basket1 = new Basket();
        basket1.add(egg3);
        basket1.add(fruit3);
        basket1.add(jam3);
        basket1.add(seasonalFruit2);
        int num=basket1.getNumOfProducts();
        if ( num != 4){
            throw new AssertionError("getNumOfProducts() returned " + num
                    + " but expected " + 4);
        }
        System.out.println(" Add product to basket Test passed.");
        String expected = "egg3\t1.00\n" +
                "Fruit3\t1.00\n" +
                "jam3\t1.00\n" +
                "seasonal3\t0.85\n" +
                "\n" +
                "Subtotal\t3.85\n" +
                "Total Tax\t0.15\n" +
                "\n" +
                "Total Cost\t4.00";
        String actual = basket1.toString().trim();
        System.out.println("Expected: \n" + expected + "\n" + "\nReceived: \n" + actual);
        if (!actual.equals(expected))
            throw new AssertionError("Incorrect format ");
        System.out.println("Basket toString test passed. ");
        Boolean a = basket1.remove(jam3);
        Boolean b = basket1.remove(jam3);
        if(!a || b){
            throw new AssertionError("Expected: " + "a=true & b=false"
                    + " but obtained: " + "a=" + a + " & b=" + b);
        }
        System.out.println("Basket remove test passed.");
        expected = "egg3\t1.00\n" +
                "Fruit3\t1.00\n" +
                "seasonal3\t0.85\n" +
                "\n" +
                "Subtotal\t2.85\n" +
                "Total Tax\t-\n" +
                "\n" +
                "Total Cost\t2.85";
       actual = basket1.toString().trim();
        System.out.println("Expected: \n" + expected + "\n" + "\nReceived: \n" + actual);
        if (!actual.equals(expected))
            throw new AssertionError("Incorrect format ");
        System.out.println("Basket toString test passed. ");

        basket1.clear();
        MarketProduct[] l = basket1.getProducts();
        if (l.length != 0)
            throw new AssertionError("Expected the MarketProduct array to be empty, but it was not. ");
        System.out.println("Basket clear test passed.");

        expected =
                "Subtotal\t-\n" +
                "Total Tax\t-\n" +
                "\n" +
                "Total Cost\t-";
        actual = basket1.toString().trim();
        System.out.println("Expected: \n" + expected + "\n" + "\nReceived: \n" + actual);
        if (!actual.equals(expected))
            throw new AssertionError("Incorrect format ");
        System.out.println("Empty Basket toString test passed. ");

    }
}


//###############
class fullBasket_2 implements Runnable {
    @Override
    public void run() {
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
        System.out.println("Expected: \n" + expected + "\n" + "\nReceived: \n" + actual);
        if (!actual.equals(expected))
            throw new AssertionError("Incorrect format ");
        System.out.println("Basket toString test passed. ");

    }
}

/*class fullBasket_2 implements Runnable {
    @Override
    public void run() {
    }
}*/

class Customer_checkOutReceipt_products_0 implements Runnable{
    @Override
    public void run() {
        try{
            Egg egg3 = new Egg("egg3",12,0);
            Fruit fruit3 = new Fruit("Fruit3",1,0);
            Jam jam3 = new Jam("jam3",1,0);
            SeasonalFruit seasonalFruit2 = new SeasonalFruit("seasonal3", 1, 0);

            Customer cust  = new Customer("Alice",900);
            cust.addToBasket(new Fruit("Blue Berry",1.5,0));
            cust.addToBasket(egg3);
            cust.addToBasket(fruit3);
            cust.addToBasket(jam3);
            cust.addToBasket(seasonalFruit2);
            String basketBefore = cust.getBasket().toString();
            //System.out.println(basketBefore);
            String receipt = cust.checkOut();
            //System.out.println(receipt);
            //System.out.println("Receipt:\n" + receipt);
            if (!basketBefore.equals(receipt)){
                throw new AssertionError("checkOut did not return correct receipt.");
            }
        }catch (IllegalStateException e){
            throw new AssertionError("Unexpected IllegalStateException raised.");
        }
        System.out.println("Test passed.");
    }
}

class Basket_toString_two_decimals implements Runnable{
    @Override
    public void run() {
        Basket basket = new Basket();
        basket.add(new Egg("brown", 12, 1200));
        basket.add(new Fruit("kiwi", 2.0, 100));
        basket.add(new Jam("jam3",1,10000));
        String expected = "brown\t12.00\n" +
                "kiwi\t2.00\n" +
                "jam3\t100.00\n" +
                "\n" +
                "Subtotal\t114.00\n" +
                "Total Tax\t15.00\n" +
                "\n" +
                "Total Cost\t129.00";
        String actual = basket.toString().trim();
        System.out.println("Expected: \n" + expected + "\n" + "\nReceived: \n" + actual);
        if (!actual.equals(expected))
            throw new AssertionError("Incorrect format ");
        System.out.println("Basket toString test passed. ");
    }
}

class  test_Basket_toString implements Runnable {
    @Override

    public void run() {
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
        System.out.println("Expected: \n" + expected + "\n" + "\nReceived: \n" + actual);
        if (!actual.equals(expected)){
            throw new AssertionError("Incorrect format ");}
        System.out.println("Basket toString test passed. ");
    }
}

class  test_Basket_Jam_toString implements Runnable {
    @Override
    public void run() {
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
        System.out.println("Basket toString test passed. ");
    }
}

class Jam_Equal1 implements Runnable {
    @Override
    public void run() {
        Jam tomatoJam = new Jam("tomatoJam", 12, 120);
        Jam expensiveTomatoJam = new Jam("tomatoJam", 6, 240);
        if(tomatoJam.equals(expensiveTomatoJam)){
            throw new AssertionError("The two have the same cost, but they aren't equal.");
        }else{
            System.out.println("Jam_Equal1 Passed successfully! Good Job Future Steve Jobs!");
        }
    }
}

class Jam_Equal2 implements Runnable {
    @Override
    public void run() {
        Jam tomatoJam = new Jam("tomatoJam", 12, 120);
        Object randomObject = new Object();
        if (tomatoJam.equals(randomObject)) {
            throw new AssertionError("Equal2 failed. You can't compare Jam with another RandomObject!");
        } else {
            System.out.println("Jam_Equal2 Passed successfully! You'll get that FAANG internship!");
        }
    }
}

class Basket_Remove2 implements Runnable {
    @Override
    public void run() {
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

            throw new AssertionError("Expected: " + "a=true & b=true"
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
}

class Basket_NullComparison implements Runnable{

	@Override
	public void run() {
		Fruit f = null;
		Fruit f1 = new Fruit("suwoop", 2.3, 400);
		Fruit f2 = new SeasonalFruit("suwoop", 2.3, 400);
		if (f2.equals(f1)) {
			System.out.println("Interesting...");
		}
		else {
			System.out.println("Normal");
		}
		if (f1.equals(f)) {
			throw new AssertionError("Comparing fruit to null returns equal");
		}
		System.out.println("Successfully compared fruit to null.");
	}
	
}

class Basket_getProducts implements Runnable{
	@Override
	public void run() {
		Basket basket = new Basket();
        basket.add(new Egg("brown", 24, 4));
        basket.add(new Fruit("Kiwi", 2.0, 100));
        basket.add(new Jam("jam", 2, 475));
        basket.add(new SeasonalFruit("Kiwi", 2.0, 100));
        MarketProduct[] tmp = basket.getProducts();
        tmp[0] = new Fruit("Grape", 22, 100);
        MarketProduct[] tmp2 = basket.getProducts();
        if (tmp[0] == tmp2[0]) {
        	throw new AssertionError("Basket.getProducts() returns live reference to underlying array!");
        }
        System.out.println("Basket.getProducts() returns at least a shallow copy");
	}
	
}

class Basket_DifferentComparison implements Runnable{
	@Override
	public void run() {
		Basket basket = new Basket();
        basket.add(new Egg("brown", 24, 4));
        basket.add(new Fruit("Kiwi", 2.0, 100));
        basket.add(new Jam("jam", 2, 475));
        basket.add(new SeasonalFruit("Kiwi", 2.0, 100));
        for (int i = 0; i < basket.getNumOfProducts(); i++) {
        	for (int j = i + 1; j < basket.getNumOfProducts(); j++) {
        		if (basket.getProducts()[i] == basket.getProducts()[j]) {
        			throw new AssertionError("Object " + basket.getProducts()[i] + " and " + basket.getProducts()[j] + 
        					" are said to be equal, but they aren't.");
        		}
        	}
        }
        System.out.println("All combinations of different MarketProducts are compared successfully!");
	}
}

class Basket_Remove_Enhanced implements Runnable {
    @Override
    public void run() {
        Basket myBasket = new Basket();
        myBasket.add(new Egg("organic Eggs",5,380));
        myBasket.add(new Fruit("Random fruit",1.1,340));
        myBasket.add(new Fruit("Blue Berry",1.5,380));
        myBasket.add(new Fruit("Green Berry",1.5,380));
        myBasket.add(new Fruit("Random fruit",1.1,340));
        myBasket.add(new Fruit("red Berry",1.5,380));
        myBasket.add(new Fruit("Random fruit",1.1,340));
        Boolean a = myBasket.remove(new Fruit("Random fruit",1.1,340));
        Boolean b = myBasket.remove(new Egg("Green Berry",3,350));
        if(!a || b){
            throw new AssertionError("Expected: " + "a=true & b=false"
                    + " but obtained: " + "a=" + a + " & b=" + b);
        }
        else 
        {
        	myBasket.remove(new Fruit("Random fruit",1.1,340));
        	for (int i = 0; i < 5; i++) {
        		if (myBasket.getProducts()[i] == null) {
        			throw new AssertionError("There was a problem with removing an element near the middle of the basket");
        		}
        	}
        	if (myBasket.getProducts()[1].equals(new Fruit("Random fruit",1.1,340))){
        		throw new AssertionError("Did not remove first occurence of given MarketProduct!");
        	}
        }
        System.out.println("Basket enhanced remove tests passed.");
    }
}

class BasketRemoveOnEmpty implements Runnable {
	public void run() {
		try {
			Basket myBasket = new Basket();
			Fruit apple = new Fruit("Apple", 3, 150);
			myBasket.remove(apple);
		} catch (NegativeArraySizeException e) {
			throw new NegativeArraySizeException("\n" + "Cannot create an array of negative size" + "\n" + "Expected value: false");
		}
		System.out.println("Basket remove on empty test passed!");
	}
}

class SeasonalFruit_Equals1 implements Runnable {
	public void run() {
		// Different price per weight, same final cost
		SeasonalFruit fruit1 = new SeasonalFruit("Apples", 1, 177);
		Fruit fruit2 = new Fruit("Apples", 1, 150);
		
		boolean comp = fruit2.equals(fruit1);
		if (!comp) {
			throw new AssertionError("Expected SeasonalFruit and Fruit with same name and cost to be equal");
		}
		else
			System.out.println("SeasonalFruit_Equals1 test passed!");
	}
}

class SeasonalFruit_Equals2 implements Runnable {
	public void run() {
		// Same price per weight, different final cost
		SeasonalFruit fruit1 = new SeasonalFruit("Apples", 1, 150);
		Fruit fruit2 = new Fruit("Apples", 1, 150);
		
		boolean comp = fruit2.equals(fruit1);
		if (comp) {
			throw new AssertionError("Expected SeasonalFruit and Fruit with different final cost to be NOT equal");
		}
		else 
			System.out.println("SeasonalFruit_Equals2 test passed. Your attention to detail is bananas!");
	}
}

class Customer_CheckOutClear implements Runnable {
	public void run() {
		Customer bob = new Customer("Bob", 2000);
		bob.addToBasket(new Egg("Brown eggs", 12, 350));
		bob.addToBasket(new Fruit("Apples", 1, 200));
		bob.addToBasket(new Jam("Apricot Jam", 1, 500));
		
		bob.checkOut();
		int numProducts = bob.getBasket().getNumOfProducts();
		if (numProducts != 0) {
			throw new AssertionError("After checkout: expected 0 products in basket, found " + numProducts + " products");
		}
		else
			System.out.println("Customer_CheckOutClear test passed.");
	}
}

public class A1_Minitester {
    // To skip running some tests, just comment them out below.
    static String[] tests = {
		"assignment1.Basket_Remove_Enhanced",
		"assignment1.Basket_NullComparison",
		"assignment1.Basket_getProducts",
		"assignment1.Basket_DifferentComparison",
		"assignment1.Basket_JamTax",
		"assignment1.Basket_NumOfProduct",
		"assignment1.Basket_Remove",
		"assignment1.Basket_add",
		"assignment1.Basket_clear",
		"assignment1.Basket_getSubTotal",
		"assignment1.Basket_toString",
		"assignment1.Customer_addFunds",
		"assignment1.Customer_addFundsException",
		"assignment1.Customer_addToBasket",
		"assignment1.Customer_checkOutBalance",
        "assignment1.Customer_checkOutBalance2",
		"assignment1.Customer_checkOutException",
		"assignment1.Customer_checkOutReceipt",
		"assignment1.Customer_getBalance",
		"assignment1.Customer_getBasket",
		"assignment1.Customer_getName",
		"assignment1.Customer_removeFromBasket",
		"assignment1.Egg_Cost",
		"assignment1.Egg_Equal",
		"assignment1.Egg_Name",
		"assignment1.Fruit_Cost",
		"assignment1.Fruit_Equal",
		"assignment1.Jam_Cost",
		"assignment1.SeasonalFruit_Cost",
		"assignment1.oneEggCost",
		"assignment1.oneEggCostRoundDown",
		"assignment1.SeasonalFruit_Cost_1",
		"assignment1.fullBasket",
		"assignment1.Customer_checkOutReceipt_products_0",
		"assignment1.Basket_toString_two_decimals",
		"assignment1.fullBasket_2",
		"assignment1.test_Basket_toString",
		"assignment1.test_Basket_Jam_toString",
		"assignment1.Jam_Equal1",
		"assignment1.Jam_Equal2",
		"assignment1.Basket_Remove2",
		"assignment1.BasketRemoveOnEmpty",
		"assignment1.SeasonalFruit_Equals1",
		"assignment1.SeasonalFruit_Equals2",
		"assignment1.Customer_CheckOutClear"
    };
    
    public static void main(String[] args) {
        int numPassed = 0;
        ArrayList<String> failedTests = new ArrayList<String>(tests.length);
        for(String className: tests)    {
            System.out.printf("%n======= %s =======%n", className);
            System.out.flush();
            try {
                Runnable testCase = (Runnable) Class.forName(className).getDeclaredConstructor().newInstance();
                testCase.run();
                numPassed++;
            } catch (AssertionError e) {
                System.out.println(e);
                failedTests.add(className);
            } catch (Exception e) {
                e.printStackTrace(System.out);
                failedTests.add(className);
            }
        }
        System.out.printf("%n%n%d of %d tests passed.%n", numPassed, tests.length);
        if (failedTests.size() > 0) {
        	System.out.println("Failed test(s):");
	        for (String className : failedTests) {
	        	int dotIndex = className.indexOf('.');
	        	System.out.println("  " + className.substring(dotIndex+1));
	        }
        }

        if(numPassed == tests.length){
            System.out.println("All clear! Now get some rest.");
        }
    }
}