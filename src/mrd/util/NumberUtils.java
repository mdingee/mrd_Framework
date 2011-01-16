package mrd.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;


public class NumberUtils {

	public static BigDecimal round(Number number, int precision) {
		if(number == null) return null;
		if(precision < 0) return null;
			
		BigDecimal bd = new BigDecimal(number.doubleValue());
		
		return bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
	}
	
	public static String formatCurrency(Number number) {
		NumberFormat formatter = new DecimalFormat("###,###,###,##0.00");
		return formatter.format(number);
	}
	
	public static Number mean(Collection <Number> collection) {
		if(collection == null) return null;
		if(collection.size() == 0) return null;
		
		double rslt = 0.0;
		int count = 0;
		
		
		Iterator <Number> i = collection.iterator();
		
		while(i.hasNext()) {
			Number value = i.next();
			if(value != null) {
				rslt += value.doubleValue();
				count++;
			}
		}
		
		return (count == 0 ? null : rslt / count);
	}
	
	/**
	 * Variance for a sample
	 * @param collection
	 * @return
	 */
	public static Number variance(Collection <Number> collection) {
		if(collection == null) return null;
		if(collection.size() == 0) return null;
		
		double rslt = 0.0;
		double mean = mean(collection).doubleValue();
		
		Iterator <Number> i = collection.iterator();
		
		while(i.hasNext()) {
			Number value = i.next();
			if(value != null) {
				rslt += Math.pow((value.doubleValue() - mean),2);
			}
		}
		
		rslt *= (1.0 / (collection.size() - 1));
		
		return rslt;
	}
	
	/**
	 * Standard deviation for a sample
	 * 
	 * @param collection
	 * @return
	 */
	public static Number standardDeviation(Collection <Number> collection) {
		if(collection == null) return null;
		if(collection.size() == 0) return null;
		
		return Math.sqrt(variance(collection).doubleValue());
	}
	
	public static Number correlation(Collection <Point> points) {
		if(points == null) return null;
		if(points.size() <= 1) return null;
		
		Vector <Number> vX = new Vector <Number> ();
		Vector <Number> vY = new Vector <Number> ();
		
		Iterator <Point> iP = points.iterator();
		
		while(iP.hasNext()) {
			Point p = iP.next();
			if(p != null) {
				vX.add(p.getX());
				vY.add(p.getY());
			}
		}
		
		if(vX.size() <= 1) {
			System.out.println("vX.size() <= 1");
			return null;
		}
		
		double meanX = mean(vX).doubleValue();
		double meanY = mean(vY).doubleValue();
		double sigmaX = standardDeviation(vX).doubleValue();
		double sigmaY = standardDeviation(vY).doubleValue();
		double rslt = 0.0;
		
		if(sigmaX == 0 || sigmaY == 0) {
			System.out.println("sigmaX == 0 || sigmaY == 0");
			return null;
		}
		
		for(int i = 0; i < vX.size(); i++) {
			double x = vX.get(i).doubleValue();
			double y = vY.get(i).doubleValue();
			
			rslt += ((x - meanX) / sigmaX) * ((y - meanY) / sigmaY);
		}
		
		return rslt / (vX.size() - 1);
	}
	
	public static Number getHundreds(Number number) { 
		if(number == null) return null;
		return number.doubleValue() / 100.0;
	}
	
	public static Number getThousands(Number number) { 
		if(number == null) return null;
		return number.doubleValue() / 1000.0; 
	}
	
	public static Number getMillions(Number number) { 
		if(number == null) return null;
		return number.doubleValue() / 1000000.0;
	}
}
