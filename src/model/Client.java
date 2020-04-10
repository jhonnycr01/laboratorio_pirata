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
	/**
	 * this method updates the values of totalKg and totalValue
	 * @param load must be initialized 
	 */
	public void updatedValues(Load load) {
		this.totalKg += load.getWeightKg();
		this.totalValue += load.getPrice();
	}
	/**
	 * this methid allows to update the level of the client based on the total value and totalKg
	 */
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

	public int getMercantilSerial() {
		return mercantilSerial;
	}

	public void setMercantilSerial(int mercantilSerial) {
		this.mercantilSerial = mercantilSerial;
	}

	public int getTotalKg() {
		return totalKg;
	}

	public void setTotalKg(int totalKg) {
		this.totalKg = totalKg;
	}

	public int getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getExpeditionDate() {
		return expeditionDate;
	}

	public void setExpeditionDate(String expeditionDate) {
		this.expeditionDate = expeditionDate;
	}

	public ClientType getClientType() {
		return clientType;
	}

	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() == Client.class) {
			Client client_compare = (Client) obj;
			if(client_compare.getMercantilSerial() == this.getMercantilSerial()
					&&
			client_compare.getClientName().equalsIgnoreCase(this.getClientName())
					) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	

}
