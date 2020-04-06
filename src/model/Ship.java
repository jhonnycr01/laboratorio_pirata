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

	public void downloadShip() {
		this.loads.clear();
	}

	public void addLoad(Load load) {		
		if(this.validateLoad(load)) {
			this.loads.add(load);
			System.out.println("the total value of the load is: " +
			this.getTotalValueByClient(load.getClientLoad()));
		} 
	}
	
	private double getTotalValueByClient(Client client) {
		double totalValue = 0;
		for(Load load: this.loads) {
			if(load.getClientLoad().equals(client)) {
				totalValue += load.getPrice();				
			}
		}
		return totalValue;
	}
	
	private boolean validateLoad(Load load) {
		boolean validate = false;
		if(this.validateTypeLoad(load) && this.validateWeightLoad(load)) {
			validate = true;
		}
		return validate;
		
	}
	
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
	
	private boolean validateWeightLoad(Load load) {
		boolean validate = true;
		double weigthTotal = this.getWeightLoadKg() + load.getWeightKg(); 
		if( weigthTotal > loadMaxKg ) {
			System.out.println("the load can not be add becuase it overcome the maximum load of the ship");
			validate = false;
		}
		return validate;
	}
	
	public double getWeightLoadKg() {
		double weightKg =0;
		for(Load load: loads) {
			weightKg += load.getWeightKg();
		}
		return weightKg;
		
	}
	
	private boolean validateWeightLoads() {
		boolean validate = false;
		int loadMin = 12_000;
		if(this.getWeightLoadKg()>=loadMin) {
			validate = true;
		}
		return validate;
	}
	
	
	
	public void setSail() {
		if(this.canSetSail()) {
			for(Load load: this.loads) {
				load.getClientLoad().updatedValues(load);
			}
		}else {
			System.out.println("can't set sail");
		}
	}
	
	public void updateLevelClients() {
		for(Client client: this.clients) {
			client.updateLevel();
		}
	}
	
	public boolean canSetSail() {
		boolean validate = false;
		if(this.validateQunatityLoads() || this.validateWeightLoads()) {
			validate = true;
		}
		return validate;
	}
	
	
	
	
	private boolean validateQunatityLoads() {
		boolean validate = false;
		if(loads.size()>=2) {
			validate = true;
		}
		return validate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
