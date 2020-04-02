package ui;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menu=0;
		
		while (menu != -1) {
			//======this command is used to clean the console
			System.out.print("\033[H\033[2J");
			System.out.flush();
			
			System.out.println("\n please enter the number of the option you would like to use: \n");
			System.out.println("1.enter the client information.");
			System.out.println("2.display strings legth.");

			
			System.out.print("enter option: ");
			menu = sc.nextInt();

			switch (menu) {
			
			case 1:
				clientInformation();			}
	}
	}

	public static void clientInformation() {
		Scanner sc = new Scanner(System.in);

		String clientName;
		String typeClient;
		double mercantil;
		double totalPay;
		int expeditionDate;
		int kl;
		
		System.out.println("please enter the client`s name");
		clientName= sc.nextLine();
		System.out.println("please enter the number of your mercantil registry");
		mercantil= sc.nextDouble();
		System.out.println("please enter the expedition date of your registry");
		expeditionDate= sc.nextInt();
		System.out.println("please enter the type of cliente");
		typeClient= sc.nextLine();
		System.out.println("please enter the quantity of transported kl");
		kl= sc.nextInt();
		System.out.println("please enter the value you are going to pay for the transportation of your load");
		totalPay= sc.nextDouble();
		}
	
	
	public static void load() {
		Scanner sc = new Scanner(System.in);
		
		int numberBox;
		double boxesGram;
		String clientOwner;
		String typeLoad;
		
		System.out.println("please enter the number of boxes you are going to transport");
		numberBox= sc.nextInt();
		System.out.println("please enter the weight of the boxes in grams (all the boxes must weight the same)");
		boxesGram= sc.nextDouble();
		System.out.println("please enter the client owner of the load");
		clientOwner= sc.nextLine();
		System.out.println("please enter the type of load you are going to transport");
		typeLoad= sc.nextLine();
	}

}
