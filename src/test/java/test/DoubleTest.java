package test;

import java.text.DecimalFormat;

public class DoubleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double aa = new Double("0.56");
		double bb = 0.57;
		System.out.println(formatFloatNumber(aa));
		System.out.println(formatFloatNumber(bb));
		System.out.println(convertDoubleFormat(bb,"##########0.00"));
	}

	public static String convertDoubleFormat(double d, String f) {
		DecimalFormat df = new DecimalFormat(f);
		String s = df.format(d);
		return s;
	}
	
	 public static String formatFloatNumber(double value) {
	        if(value != 0.00){
	            java.text.DecimalFormat df = new java.text.DecimalFormat("########.00");
	            return df.format(value);
	        }else{
	            return "0.00";
	        }

	    }
	    public static String formatFloatNumber(Double value) {
	        if(value != null){
	            if(value.doubleValue() != 0.00){
	                java.text.DecimalFormat df = new java.text.DecimalFormat("########.00");
	                return df.format(value.doubleValue());
	            }else{
	                return "0.00";
	            }
	        }
	        return "";
	    }
}
