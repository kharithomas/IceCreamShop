import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Store {

    // attributes
    private final static List<IceCream> store = new ArrayList<IceCream>();

    public void runStore() {
        System.out.println("Hello, welcome to My IceCream store\n");
            
        // Add dummy data
        addFlavor("vanilla", 3.29);
        addFlavor("chocolate", 4.92);
        addFlavor("cookies_n_cream", 3.11);
        addFlavor("peanut_butter", 2.45);
        addFlavor("sorbet", 3.20);

        //int choice = 1;
        while (store.size() > 0) {
            int choice = shopMenu();
            try { 
                IceCream flavor = store.get(choice);
                System.out.printf("You have choosen %s\n", flavor.name);

                // consume flavor
                removeFlavor(flavor.id);
            } 
            catch (Exception e) { 
                System.out.println(e); 
            }
        }

        System.out.println("\nYou have eaten all the flavors!");
    }

    // print shop menu
    public int shopMenu() {    
        // print store
        printFlavors();
        Scanner sc = new Scanner(System.in);
    
        System.out.println("\nPlease choose a flavor to eat:");
        int choice = sc.nextInt();
        //sc.close();
        
        return choice-1;
    }

    // add new ice cream flavor
    public void addFlavor(String name, double price) {
        LocalDateTime currentDate = LocalDateTime.now();
        IceCream flavor = new IceCream(currentDate.toString(), name, price);
        store.add(flavor);
        //System.out.println("Flavor added successfully!");
    }

    // remove ice cream flavor
    public void removeFlavor(String id) {
        if (store.removeIf(flavor -> flavor.id == id)) {
            System.out.println("Flavor removed successfully!\n");
            //return;
        } else {
            System.out.println("An error occured! Flavor not present\n");
        }
        //return;
    }

    // print all flavors
    public void printFlavors() {
        for(int i = 0; i < store.size(); i++) {
            IceCream flavor = store.get(i);
            System.out.printf("(%s). %s\t\tPrice: $%.2f\n", i+1, flavor.name, flavor.price);
        }
    }
}