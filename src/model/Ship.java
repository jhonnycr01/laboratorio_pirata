package model;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 */

public class Ship {

	private String name;
	private double loadMaxKg;
	private ArrayList<Load> loads;
	private ArrayList<Client> clients;
	
	
	public ArrayList<Client> getClients() {
		return clients;
	}
	
	public void addClient(Client client) {
		this.clients.add(client);
	}



	public Ship(String name, int loadMaxKg) {
		this.name = name;
		this.loadMaxKg = loadMaxKg;
		this.loads = new ArrayList<>();
		this.clients = new ArrayList<>();
	}
	
	
	
	public void setName(String name) {
		this.name = name;
	}



	public void setLoadMaxKg(double loadMaxKg) {
		this.loadMaxKg = loadMaxKg;
	}



	public String getName() {
		return name;
	}



	public double getLoadMaxKg() {
		return loadMaxKg;
	}



	public ArrayList<Load> getLoads() {
		return loads;
	}
  
	/**
	 * this method clears all the elements in the list loads
	 */
	public void downloadShip() {
		this.loads.clear();
	}
    
	/**
	 * this method adds a load in the arrayList loads checking the method validateLoad
	 * @param load must be initialized
	 */
	public void addLoad(Load load) {		
		if(this.validateLoad(load)) {
			this.loads.add(load);
			System.out.println("the total value of the load is: " +
			this.getTotalValueByClient(load.getClientLoad()));
		} 
	}
	/**
	 * this method returns the total value of all the loads from a same client 
	 * @param client must be initialized
	 */
	private double getTotalValueByClient(Client client) {
		double totalValue = 0;
		for(Load load: this.loads) {
			if(load.getClientLoad().equals(client)) {
				totalValue += load.getPrice();				
			}
		}
		return totalValue;
	}
	/**
	 * this method validates if a load is able to be add to the ship
	 * @param load must be initialized
	 */
	private boolean validateLoad(Load load) {
		boolean validate = false;
		if(this.validateTypeLoad(load) && this.validateWeightLoad(load)) {
			validate = true;
		}
		return validate;
		
	}
	/**
	 * this method validates the type of loads of the ship are correct
	 * @param load must be initialized
	 */
	private boolean validateTypeLoad(Load load) {
		boolean validate = true;
		
		switch(load.getTypeLoad()) {
			case Danger:
				if(this.containsTypeLoad(TypeLoad.Perishable)) {
					System.out.println("don't add the load because already load type of Perishable");
					validate = false;
				}
				break;
			case Perishable:
				if(this.containsTypeLoad(TypeLoad.Danger)) {
					System.out.println("don't add the load because already load type of Danger");
					validate = false;
				}
				break;
		}
		return validate;
	
	}
	/**
	 * this method returns a boolean value that checks the type of loads are not the same
	 * @param typeLoad must be initialized 
	 * @return boolean if the ship contains a Type specific load
	 */
	public boolean containsTypeLoad(TypeLoad typeLoad) {
		boolean containTypeLoad = false;
		for(Load load: loads) {
			if(load.getTypeLoad() == typeLoad) {
				containTypeLoad = true;
				break;
			}
		}
		return containTypeLoad;
	}
	/**
	 * this method return validated the weigth of the load is enough to add the load 
	 * @param load must be initialized
	 */
	private boolean validateWeightLoad(Load load) {
		boolean validate = true;
		double weigthTotal = this.getWeightLoadKg() + load.getWeightKg(); 
		if( weigthTotal > loadMaxKg ) {
			System.out.println("the load can not be add becuase it overcome the maximum load of the ship");
			validate = false;
		}
		return validate;
	}
	/**
	 * this method return the weightKg of the loads 
	 * @return total weight of loads
	 */
	public double getWeightLoadKg() {
		double weightKg =0;
		for(Load load: loads) {
			weightKg += load.getWeightKg();
		}
		return weightKg;
		
	}
	/**
	 * this method returns validated that the weight of the load is enought 
	 */
	private boolean validateWeightLoads() {
		boolean validate = false;
		int loadMin = 12_000;
		if(this.getWeightLoadKg()>=loadMin) {
			validate = true;
		}
		return validate;
	}
	
	
	/**
	 * this method validates if the ship can sail by checking the method canSetSail
	 */
	public void setSail() {
		if(this.canSetSail()) {
			for(Load load: this.loads) {
				load.getClientLoad().updatedValues(load);
			}
		}else {
			System.out.println("can't set sail");
		}
	}
	/**
	 * this methos allows the user to updated the level of the client 
	 */
	public void updateLevelClients() {
		for(Client client: this.clients) {
			client.updateLevel();
		}
	}
	/**
	 * this method validates if the ship can sail checking the methods validateQuantityLoads and validateWeigthLoads
	 * @return boolean that determines if the ship can set sail
	 */
	public boolean canSetSail() {
		boolean validate = false;
		if(this.validateQunatityLoads() || this.validateWeightLoads()) {
			validate = true;
		}
		return validate;
	}
	
	
	
	/**
	 * this method return validate if quantity of the loads is enougth
	 */
	private boolean validateQunatityLoads() {
		boolean validate = false;
		if(loads.size()>=2) {
			validate = true;
		}
		return validate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
