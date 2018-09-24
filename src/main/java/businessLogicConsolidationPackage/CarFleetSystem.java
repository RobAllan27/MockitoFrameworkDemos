package businessLogicConsolidationPackage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import basicEntities.Car;
import basicEntities.Home;
import carInsurance.CarInsurance;
import carInsurance.CarInsuranceImpl;
import carPayments.CarPayment;
import carPayments.CarPaymentPlanImpl;
import carPayments.Payment;
import carServicing.CarServicing;
import carServicing.CarServicingImpl;
import carServicing.ServicePoint;

public class CarFleetSystem {

	Car car1, car2, car3, car4;
	Home home1, home2;
	CarServicing csvc;
	CarInsurance cins;
	CarPayment cpay;
	
	public CarFleetSystem() {
		
		/*
		home1 = new Home();
		home1.setAddress1("home1_address1");
		home1.setAddress2("home1_address2");
		home1.setPostcode("11223344");

		home2 = new Home();
		home2.setAddress1("home2_address1");
		home2.setAddress2("home2_address2");
		home2.setPostcode("22334455");
		
		car1 = new Car();
		car2 = new Car();
		car3 = new Car();
		car4 = new Car();
		
		car1.setColour("red");
		car2.setColour("green");
		car3.setColour("blue");
		car4.setColour("white");
		
		car1.setRego("abc 101");
		car2.setRego("def 101");
		car3.setRego("ghi 101");
		car4.setRego("jkl 101");
		
		car1.setHome(home1);
		car2.setHome(home1);
		car3.setHome(home2);
		car4.setHome(home2);
		*/
		
		csvc = new CarServicingImpl();
		cins = new CarInsuranceImpl();
		cpay = new CarPaymentPlanImpl();
	}
	
	
	//we will use this later for the case where we have created mock.
	public void setCarInsurance(CarInsurance inCarInsurance) {
		cins =  inCarInsurance;
		
	}
	
	public int getNumberofServicingForCar(Car inCar){
		int numberofServicePoints = csvc.getServicePoints(car1.getRego()).size();

		return numberofServicePoints;
	}
	
	public int getFirstNumberKmsofServicingForCar(Car inCar){
		// 2 stage operation  -  we will check the order 
		
		List<ServicePoint> ListSortedbyKMs = csvc.getServicePoints(inCar.getRego()).stream().sorted(Comparator.comparing(sp -> sp.getMileage())).collect(Collectors.toList()); 
		int kmsfforFirstServicePoint = ListSortedbyKMs.get(0).getMileage();
		csvc.passBooking("Hello String");
		return kmsfforFirstServicePoint;
	
	}
	
	public int getLastNumberKmsofServicingForCar(Car inCar){
		List<ServicePoint> ListSortedbyKMs = csvc.getServicePoints(inCar.getRego()).stream().sorted(Comparator.comparing(sp -> sp.getMileage())).collect(Collectors.toList()); 
		int kmsfforFirstServicePoint = ListSortedbyKMs.get(ListSortedbyKMs.size() - 1 ).getMileage();
		return kmsfforFirstServicePoint;
	}
	
	public void getQuoteCar(Car inCar){
		cins.getQuote(inCar.getRego());
	}
		
	public int getPaymentPlanNumberofPayments(Car inCar){
		return cpay.getPayments(inCar.getRego()).size();
	}
	
	public String getNextPaymentPlanDueDate(Car inCar){
		List<Payment> PlansSortedByDueDate = cpay.getPayments(inCar.getRego()).stream().sorted(Comparator.comparing(sp -> sp.getDueDate())).collect(Collectors.toList()); 
		String nextPaymentDate = PlansSortedByDueDate.get(0).getDueDate();
		return nextPaymentDate;
	}
	
	
	public String getNextPaymentPlanReallyDueDate(Car inCar){
		List<Payment> PlansSortedByReallyDueDate = cpay.getPayments(inCar.getRego()).stream().sorted(Comparator.comparing(sp -> sp.getReallyDueDate())).collect(Collectors.toList()); 
		String nextPaymentReallyDueDate = PlansSortedByReallyDueDate.get(0).getReallyDueDate();
		return nextPaymentReallyDueDate;
	}
	
	public String getInsuranceQuote(Car inCar){
		
		//ok we have some business logic here wher we apply 10 or 20% deoneding on the car rego -  srtas A 10%, sarts B 20% starts C 30 %  - otherwise no disucount.
	
		int fullquote = cins.getQuote(inCar.getRego());
		
		String regoStart = inCar.getRego().substring(0, 1);
		
		double rate = 1.0;
		
		switch(regoStart) {
		case "a":
			rate = 0.9;
			break;
		case "b":
			rate = 0.8;
			break;
		case "c":
			rate = 0.7;
			break;	
		default:		
		}
		double reducedQuote = rate * fullquote;
		return Double.toString(reducedQuote);
	}
}
