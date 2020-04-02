package model;

public class Client {
	
	private int mercantilSerial;
	private int totalKg;
	private int totalValue;
	private String clientName;
	private String expeditionDate;
	private ClientType clientType;

	public Client( int mercantilSerial, String clientName, String expeditionDate) {
		this.mercantilSerial= mercantilSerial;
		this.totalKg= 0;
		this.totalValue= 0;
		this.clientName= clientName;
		this.expeditionDate= expeditionDate;
		this.clientType= ClientType.Normal;
	}
	
	public void updatedValues(Load load) {
		this.totalKg += load.getWeightKg();
		this.totalValue += load.getPrice();
	}
	
	public void updateLevel() {
		//conditions for level up 
		if(this.totalKg >= 35_000 && this.totalKg < 55_000 ) {
			this.clientType = ClientType.Silver;
		} else if( this.totalKg >= 55_000 || (this.totalValue >= 2_000_000 && this.totalValue < 5_000_000)) {
			this.clientType = ClientType.Gold;
		} else if( this.totalValue >= 5_000_000 ) {
			this.clientType = ClientType.Platinum;
		}
	}

}
