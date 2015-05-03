package pl.parser.nbp.fileService;

public class PricesTablesGenerator {

	
	private String initialDate;
	private String finalDate;
	private String currencyCode;
	private double buyingPricesTable[];
	private double sellingPricesTable[];
	
	
	public PricesTablesGenerator(String currencyCode, String initDate, String finalDate) {
		this.initialDate = initDate;
		this.finalDate = finalDate;
		this.currencyCode = currencyCode;
		this.generatePricesTables(currencyCode, initDate, finalDate);
	}

	
	
	
	
	public String getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(String initialDate) {
		this.initialDate = initialDate;
	}
	public String getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(String finalDate) {
		this.finalDate = finalDate;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public double[] getBuyingPricesTable() {
		return buyingPricesTable;
	}
	public void setBuyingPricesTable(double[] buyingPricesTable) {
		this.buyingPricesTable = buyingPricesTable;
	}
	public double[] getSellingPricesTable() {
		return sellingPricesTable;
	}
	public void setSellingPricesTable(double[] sellingPricesTable) {
		this.sellingPricesTable = sellingPricesTable;
	}




	/**
	 * 
	 * This method sets up the buyingPricesTable and sellingPricesTable, filling them with 
	 * prices from each day between initialDate and finalDate INCLUDING both dates. Prices
	 * are also parsed from strings to doubles
	 * 
	 * @param currencyCode currencyCode code representing currency e.g. USD, EUR, GBP etc.
	 * @param initDate first day to check prices (YYYY-MM-DD)
	 * @param finalDate last day to check prices (YYYY-MM-DD)
	 */
	private void generatePricesTables(String currencyCode, String initDate, String finalDate) {
		
		CalendarManager cm = new CalendarManager(initDate, finalDate);
		XMLFileReader xmlReader = new XMLFileReader();
		buyingPricesTable = new double[cm.getDatesFromInitToFin().size()];
		sellingPricesTable = new double[cm.getDatesFromInitToFin().size()];
			
		for(int i = 0; i < cm.getDatesFromInitToFin().size(); i++) {
			try {
				String bRate = xmlReader.getCurrencyBuingRate(currencyCode, cm.getDatesFromInitToFin().get(i));
				String sRate =xmlReader.getCurrencySellingRate(currencyCode, cm.getDatesFromInitToFin().get(i));
					
				buyingPricesTable[i] = Parsers.parseStringToDouble(bRate);
				sellingPricesTable[i] = Parsers.parseStringToDouble(sRate);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
