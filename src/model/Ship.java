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
	
	public Ship(String name, int loadMaxKg) {
		this.name = name;
		this.loadMaxKg = loadMaxKg;
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



	public void addLoad(Load load) {		
		if(this.validateLoad(load)) {
			this.loads.add(load);
		}
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
		for()
	}
	
	public boolean canSetSail() {
		boolean validate = false;
		if(this.validateQunatityLoads() && this.validateWeightLoads()) {
			validate = true;
		}
		return validate;
	}
	
	private boolean validateWeightLoads() {
		boolean validate = false;
		int loadMin = 12_000;
		if(this.getWeightLoadKg()>=loadMin) {
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
					System.out.println();
					validate = false;
				}
				break;
			case Perishable:
				if(this.containsTypeLoad(TypeLoad.Danger)) {
					System.out.println();
					validate = false;
				}
				break;
		}
		return validate;
	
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
	
	public double getWeightLoadKg() {
		double weightKg =0;
		for(Load load: loads) {
			weightKg += load.getWeightKg();
		}
		return weightKg;
		
	}
	
	
	
	
}
