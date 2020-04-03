package ui;
import java.util.Scanner;

import model.Client;
import model.Ship;
import model.TypeLoad;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Create the ship
		Ship pirate = new Ship("El Pirata", 28_000);
		//1. Create clients
		//2. Create loads / load ship
		//3. updated clients categories 
		//4. setSail Ship / show if the ship can set sail
		//5. Download Ship
		//6. Get Total weight of ship
		
		
		int menu=-1;
		
		while (menu != 0) {
			//======this command is used to clean the console
			System.out.println("\n\n\n\n");
			System.out.println("******************");
			System.out.println("+ "+ pirate.getName() +" +");
			System.out.println("******************\n");
			System.out.println("1.Create client ");
			System.out.println("2.Create load and load to ship");
			System.out.println("3.Updated clients categories");
			System.out.println("4.can set sail");
			System.out.println("5.Download ship");
			System.out.println("6. Get total weight of ship");
			System.out.println("0. exit");

			
			System.out.print("enter option: ");
			menu = sc.nextInt();
			if(menu != 0 ) {
				selectOption(menu, pirate);
			}
		}		
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
			
			break;
		case 4:
			//"4.can set sail"
			
			break;
		case 5:
			//"5.Download ship"
			break;
		case 6:
			//"6. Get total weight ship"
			break;
			
		}
	}
	
	
	
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
		expeditionDate= sc.nextLine();
		sc.next();
		Client client = new Client(mercantil,clientName, expeditionDate);
		ship.addClient(client);
		System.out.println("Client add successfuly");
		sc.next();
		
	}
	
	
	public static void creteLoad(Ship ship) {
		Scanner sc = new Scanner(System.in);
		
		int numberBox;
		double boxesGram;
		int indexClient;
		Client clientOwner;
		TypeLoad typeLoad;
		
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
		
	}
	
	public static void listTypeLoads() {
		System.out.println("1. Perishable");
		
	}
	
	public static void listClients(Ship ship) {
		int index = 1;
		for(Client client: ship.getClients()) {
			System.out.println(""+ index+". " + client.getClientName());
		}
		System.out.println("\n");
	}

}
