package pl.parser.nbp.fileService;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExchangeCounter {


	/**
	 * 
	 * @param array array of doubles
	 * @return arithmetic average of values in array
	 */
	public static double getAverage(double[] array) {
		double sum = 0.0;
		double avg = 0.0;
		for(double v: array) {
			sum +=v;
		}
		avg = sum/array.length;
		
		return round(avg, 4);
	}
	
	
	/**
	 * 
	 * @param array array of doubles
	 * @return standard deviation of values in array
	 */
	public static double getStardardDeviation(double[] array) {
		double sum = 0.0;
		double avg = getAverage(array);
		double stDev = 0.0;
		
		for(double v: array) {
			sum += Math.pow((v-avg), 2.0);
		}
		
		stDev = Math.sqrt(sum/array.length);
		
		return round(stDev, 4);
	}
		
	
	/**
	 * 
	 * @see java.math.RoundingMode
	 * 
	 * @param value double to round
	 * @param places number of places behind the comma to round to
	 * @return rounded value
	 */
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	
	
	

}
