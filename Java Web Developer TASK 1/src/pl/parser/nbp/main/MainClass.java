package pl.parser.nbp.main;



import pl.parser.nbp.fileService.ExchangeCounter;
import pl.parser.nbp.fileService.InputDataValidator;
import pl.parser.nbp.fileService.PricesTablesGenerator;


public class MainClass {

	public static void main(String[] args) {
			
		String currCode = args[0];
		String initDate = args[1];
		String finDate = args[2];
		
		if(new InputDataValidator().validate(currCode, initDate, finDate)) {
			PricesTablesGenerator ptg = new PricesTablesGenerator(currCode, initDate, finDate);
			double[] buy = ptg.getBuyingPricesTable();
			double[] sell = ptg.getSellingPricesTable();
			
			
		
			System.out.println("Badany okres - od "+ptg.getInitialDate()+" do "+ptg.getFinalDate());
			System.out.println();
			System.out.println("Œrednia cena kupna:\t "+ExchangeCounter.getAverage(buy));
			
			
			System.out.println();
			System.out.println("Odchylenie standardowe cen sprzeda¿y:\t "+ExchangeCounter.getStardardDeviation(sell));
			
		}
	}

}
