package model;

public class Load {
	
	
	private TypeLoad typeLoad;
	private int numberBoxes;
	private double weigthBoxesGrams;
	private Client clientLoad;
	private double price;
	
	public Load(TypeLoad typeLoad, int numberBoxes, double weigthBoxesGrams,
			Client clientLoad) {
		this.typeLoad = typeLoad;
		this.numberBoxes = numberBoxes;
		this.weigthBoxesGrams = weigthBoxesGrams;
		this.clientLoad = clientLoad;
		this.calculatePrice();
		
	}
	/**
	 * this methos allows to calculate the price of the load by the type and the weight and include the discoun      
	 * @param typeLoad must be initialized
	 */
	private void calculatePrice() {
		switch(this.typeLoad) {
			case Danger:
				price = 390_000 * this.getWeightKg();				
			break;
			
			case Perishable:
				price = 250_000 * this.getWeightKg();				
			break;
			
			case NoPerishable:
				price = 80_000 * this.getWeightKg(); 				
			break;
		}
		
		switch(this.clientLoad.getClientType()) {
			case Silver:
				if(this.typeLoad == TypeLoad.Perishable) {
					price -= price * (1.5 / 100.0);
				}
				break;
			case Gold:
				if(this.typeLoad == TypeLoad.NoPerishable ||
				this.typeLoad == TypeLoad.Perishable) {
					price -= price * (3 / 100.0);
				}
				break;
			case Platinum:
				price -= price * (5 / 100.0);
				break;
		
		}
	}
	/**
	 * this method calculated the weight of the load in kg 
	 * @return double total weight of the load
	 */
	public double getWeightKg() {
		return (this.numberBoxes * this.weigthBoxesGrams) / 1000.0;		
	}

	public TypeLoad getTypeLoad() {
		return typeLoad;
	}

	public void setTypeLoad(TypeLoad typeLoad) {
		this.typeLoad = typeLoad;
	}

	public int getNumberBoxes() {
		return numberBoxes;
	}

	public void setNumberBoxes(int numberBoxes) {
		this.numberBoxes = numberBoxes;
	}

	public double getWeigthBoxesGrams() {
		return weigthBoxesGrams;
	}

	public void setWeigthBoxesGrams(int weigthBoxesGrams) {
		this.weigthBoxesGrams = weigthBoxesGrams;
	}

	public Client getClientLoad() {
		return clientLoad;
	}

	public void setClientLoad(Client clientLoad) {
		this.clientLoad = clientLoad;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
	

}
