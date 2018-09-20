package carPayments;

import java.util.ArrayList;
import java.util.HashMap;

// Ok we are going to code up a solution based where I will shove some data ready to be queried

// I am going to stub this out though -  =but we can compare the stub to the actual version

import basicEntities.Car;

public class CarPaymentPlanImpl implements CarPayment {

	private  HashMap<String, ArrayList<Payment>> paymentsSet;
	private ArrayList<Payment> car1Payments;
	private ArrayList<Payment> car2Payments;
	private ArrayList<Payment> car3Payments;
	
	public CarPaymentPlanImpl() {
		
		// we are stuffing the implementations full of data - in reality use a database
		
		// maybe refactor and put in SQLlite
		
		paymentsSet = new HashMap<String,ArrayList<Payment>>();
		
		Payment c1payment1 = new Payment();
		Payment c1payment2 = new Payment();
		Payment c1payment3 = new Payment();
		
		Payment c2payment1 = new Payment();
		Payment c2payment2 = new Payment();
		Payment c2payment3 = new Payment();
		
		Payment c3payment1 = new Payment();
		Payment c3payment2 = new Payment();
		Payment c3payment3 = new Payment();
		
		
		
		// Car1
		c1payment1.setAmountDue("S100.00");
		c1payment1.setDueDate("15/09/2018");
		c1payment1.setReallyDueDate("25/09/2018");

		c1payment2.setAmountDue("S200.00");
		c1payment2.setDueDate("16/09/2018");
		c1payment2.setReallyDueDate("26/09/2018");
		
		c1payment3.setAmountDue("S300.00");
		c1payment3.setDueDate("17/09/2018");
		c1payment3.setReallyDueDate("27/09/2018");
		
		// Car2
		
		c2payment1.setAmountDue("S110.00");
		c2payment1.setDueDate("15/09/2008");
		c2payment1.setReallyDueDate("25/09/2008");

		c2payment2.setAmountDue("S210.00");
		c2payment2.setDueDate("16/09/2009");
		c2payment2.setReallyDueDate("26/09/2009");
		
		c2payment3.setAmountDue("S310.00");
		c2payment3.setDueDate("17/09/2010");
		c2payment3.setReallyDueDate("27/09/2010");
		
		// Car3
		
		c3payment1.setAmountDue("S111.00");
		c3payment1.setDueDate("15/09/2004");
		c3payment1.setReallyDueDate("25/09/2004");

		c3payment2.setAmountDue("S211.00");
		c3payment2.setDueDate("16/09/2005");
		c3payment2.setReallyDueDate("26/09/2005");
		
		c3payment3.setAmountDue("S311.00");
		c3payment3.setDueDate("17/09/2006");
		c3payment3.setReallyDueDate("27/09/2006");
		
		ArrayList<Payment> car1Payments = new ArrayList<Payment>();
		ArrayList<Payment> car2Payments = new ArrayList<Payment>();
		ArrayList<Payment> car3Payments = new ArrayList<Payment>();
		
		car1Payments.add(c1payment1);
		car1Payments.add(c1payment2);
		car1Payments.add(c1payment3);
		
		car2Payments.add(c2payment1);
		car2Payments.add(c2payment2);
		car2Payments.add(c2payment3);
		
		car3Payments.add(c3payment1);
		car3Payments.add(c3payment2);
		car3Payments.add(c3payment3);
		
		paymentsSet.put("abc 101", car1Payments);
		paymentsSet.put("def 101", car2Payments);
		paymentsSet.put("ghi 101", car3Payments);
	}
	
	public ArrayList<Payment> getPayments(String inRego) {
		// TODO Auto-generated method stub
		
		switch (inRego) {
			case "abc 101":
			return car1Payments;
			//break;
			case "def 101":
			return car2Payments;
			//break;
			case "ghi 101":
			return car3Payments;	
			//break;
		}
		return car3Payments;
	}
}
