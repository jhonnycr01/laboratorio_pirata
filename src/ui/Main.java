package ui;
import java.util.Scanner;

import model.Client;
import model.Load;
import model.Ship;
import model.TypeLoad;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Create the ship
		Ship pirate = new Ship("El Pirata", 28_000);
		pirate.addClient(new Client(123,"Juan","10/02/2020"));
		pirate.addClient(new Client(100,"Jeniffer","08/10/2010"));
		//1. Create clients
		//2. Create loads / load ship
		//3. updated clients categories 
		//4. setSail Ship / show if the ship can set sail
		//5. Download Ship
		//6. Get Total weight of ship
		
		
		int menu=-1;
		
		while (menu != 0) {
			//======this command is used to clean the console
			cleanScreen();
			System.out.println("******************");
			System.out.println("+ "+ pirate.getName() +" +");
			System.out.println("******************\n");
			System.out.println("1.Create client ");
			System.out.println("2.Create load and load to ship");
			System.out.println("3.Updated clients categories");
			System.out.println("4.can set sail");
			System.out.println("5.Download ship");
			System.out.println("6. Get total weight of ship");
			System.out.println("7. List clients with levels");
			System.out.println("0. exit");

			
			System.out.print("enter option: ");
			menu = sc.nextInt();
			if(menu != 0 ) {
				selectOption(menu, pirate);
			}
		}		
	}
	
	public static void cleanScreen(){
		System.out.println("\n\n\n\n\n");
	}
	
	public static void selectOption(int menu, Ship ship) {
		switch(menu) {
		case 1:
			//1.Create client 
			createClient(ship);
			break;
		case 2:
			//2.Create load and load to ship
			creteLoad(ship);
			break;
		case 3:
			//3.Updated clients categories");
			updatedClientCategories(ship);
			break;
		case 4:
			//"4.can set sail"
			shipCanSetSail(ship); 
			break;
		case 5:
			//"5.Download ship"
			downloadShip(ship);
			break;
		case 6:
			//"6. Get total weight ship"
			getTotalWeightShip(ship);
			break;
		case 7: 
			//list clients and their levels
			listClientsWithLevels(ship);
			
		}
	}
	
	/**
	 * this method displays the total weight of the ship
	 * @param ship must be initialized 
	 */
	public static void getTotalWeightShip(Ship ship) {
		Scanner sc = new Scanner(System.in);
		double total = ship.getWeightLoadKg();
		System.out.println("The total weight is: "+ total +" Kg");
		sc.nextLine();
	}
	/**
	 * this method allows to download the ship checking setSail method 
	 * @param ship must be initialized 
	 */
	public static void downloadShip(Ship ship) {
		Scanner sc = new Scanner(System.in);
		ship.setSail();		
		if(ship.canSetSail()) {
			ship.downloadShip();
			System.out.println("the ship is already empty");	
		}
		
		sc.nextLine();
	}
	/**
	 * this method check that the ship is ready to sail
	 * @ param ship must be initialized
	 */
	public static void shipCanSetSail(Ship ship) {
		Scanner sc = new Scanner(System.in);
		if(ship.canSetSail()) {
			System.out.println("The ship is already for set sail");
		} else {
			System.out.println("The ship is not already for set sail");
		}
		sc.nextLine();
	}
	/**
	 * this method allows to updated the categorie of the client checking the method updateLevelClients
	 * @param ship must be initialized
	 */
	public static void updatedClientCategories(Ship ship){
		Scanner sc = new Scanner(System.in);
		ship.updateLevelClients();
		System.out.println("Clients updated successfuly");		
		sc.nextLine();
	}
	
	/**
	 * this method creates clients in the ship
	 * @param ship must be initialized
	 */
	public static void createClient(Ship ship) {
		Scanner sc = new Scanner(System.in);

		String clientName;
		int mercantil;
		String expeditionDate;
		
		System.out.println("please enter the client`s name");
		clientName= sc.nextLine();
		System.out.println("please enter the number of your mercantil registry");
		mercantil= sc.nextInt();
		System.out.println("please enter the expedition date of your registry");
		expeditionDate= sc.next();
		Client client = new Client(mercantil,clientName, expeditionDate);
		ship.addClient(client);
		System.out.println("Client add successfuly");
		sc.nextLine();
		sc.nextLine();
		
	}
	
	/**
	 * this methos alows to create a load in the ship 
	 * @param ship must be initialized
	 */
	public static void creteLoad(Ship ship) {
		Scanner sc = new Scanner(System.in);
		
		int numberBox;
		double boxesGram;
		int indexClient;
		Client clientOwner;
		TypeLoad typeLoad;
		int typeLoadIndex;
		Load load;
		
		System.out.println("please enter the number of boxes you are going to transport");
		numberBox= sc.nextInt();
		System.out.println("please enter the weight of the boxes in grams (all the boxes must weight the same)");
		boxesGram= sc.nextDouble();
		System.out.println("\n");
		listClients(ship);
		System.out.println("please select the client owner of the load: ");
		indexClient = sc.nextInt();
		clientOwner = ship.getClients().get(indexClient-1);
		System.out.println("please enter the type of load you are going to transport");
		listTypeLoads();
		typeLoadIndex = sc.nextInt();
		typeLoad = getTypeLoadByIndex(typeLoadIndex);
		load = new Load(typeLoad,numberBox, boxesGram, clientOwner);
		ship.addLoad(load);
		
	}
	/**
	 * this method return the type of load based on it index
	 */
	public static TypeLoad getTypeLoadByIndex(int index) {
		return TypeLoad.values()[index-1];
	}
	/**
	 * this method displays the list of the type of loads 
	 */
	public static void listTypeLoads() {
		System.out.println("1. Danger");
		System.out.println("2. Perishable");
		System.out.println("3. No Perishable");
		
	}
	/**
	 * this method display the list of the client showing its name and level
	 */
	public static void listClientsWithLevels(Ship ship){
		Scanner sc = new Scanner(System.in);
		listClients(ship);
		sc.nextLine();
	}
	/**
	 * this method displays the type of client and name base on its index 
	 */
	public static void listClients(Ship ship) {
		
		int index = 1;
		for(Client client: ship.getClients()) {
			System.out.println(""+ index+". " + client.getClientName()+ 
					" level: "+ client.getClientType().toString());
			index++;
		}
		
	}

}
