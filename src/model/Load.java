package model;

public class Load {
	
	
	private TypeLoad typeLoad;
	private int numberBoxes;
	private int weigthBoxesGrams;
	private Client clientLoad;
	private double price;
	
	public Load(double totalValue, int totalKg, TypeLoad typeLoad, int numberBoxes, int weigthBoxesGrams,
			Client clientLoad) {
		super();
		this.typeLoad = typeLoad;
		this.numberBoxes = numberBoxes;
		this.weigthBoxesGrams = weigthBoxesGrams;
		this.clientLoad = clientLoad;
		
		switch(typeLoad) {
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
	}
	
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

	public int getWeigthBoxesGrams() {
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