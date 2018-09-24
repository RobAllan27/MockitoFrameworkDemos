package carServicing;

import java.util.ArrayList;
import java.util.HashMap;

import basicEntities.Car;
import carPayments.Payment;

public class CarServicingImpl implements CarServicing {

private  HashMap <String,ArrayList<ServicePoint>> svcPointSet;

public CarServicingImpl() {
	
	int i = 0;
	
	svcPointSet = new HashMap <String,ArrayList<ServicePoint>>();
	
	ArrayList<ServicePoint> car1svpoints = new ArrayList<ServicePoint>();
	ArrayList<ServicePoint> car2svpoints = new ArrayList<ServicePoint>();
	ArrayList<ServicePoint> car3svpoints = new ArrayList<ServicePoint>();
	
	ServicePoint c1svcpt1 = new ServicePoint();
	ServicePoint c1svcpt2 = new ServicePoint();
	ServicePoint c1svcpt3 = new ServicePoint();
	
	ServicePoint c2svcpt1 = new ServicePoint();
	ServicePoint c2svcpt2 = new ServicePoint();
	ServicePoint c2svcpt3 = new ServicePoint();
	
	ServicePoint c3svcpt1 = new ServicePoint();
	ServicePoint c3svcpt2 = new ServicePoint();
	ServicePoint c3svcpt3 = new ServicePoint();
	
	c1svcpt1.setMileage(11000);
	c1svcpt1.setSvcDueDate("25/08/2016");
	c1svcpt2.setMileage(21000);
	c1svcpt2.setSvcDueDate("25/08/2017");
	c1svcpt3.setMileage(31000);
	c1svcpt3.setSvcDueDate("25/08/2018");

	car1svpoints.add(c1svcpt1);
	car1svpoints.add(c1svcpt2);
	car1svpoints.add(c1svcpt3);
	
	c2svcpt1.setMileage(12000);
	c2svcpt1.setSvcDueDate("25/09/2016");
	c2svcpt2.setMileage(22000);
	c2svcpt2.setSvcDueDate("25/09/2017");
	c2svcpt3.setMileage(32000);
	c2svcpt3.setSvcDueDate("25/09/2018");
	
	car2svpoints.add(c2svcpt1);
	car2svpoints.add(c2svcpt2);
	car2svpoints.add(c2svcpt3);
	
	c3svcpt1.setMileage(13000);
	c3svcpt1.setSvcDueDate("25/10/2016");
	c3svcpt2.setMileage(23000);
	c3svcpt2.setSvcDueDate("25/10/2017");
	c3svcpt3.setMileage(33000);
	c3svcpt3.setSvcDueDate("25/10/2018");
	
	car3svpoints.add(c3svcpt1);
	car3svpoints.add(c3svcpt2);
	car3svpoints.add(c3svcpt3);
	
	svcPointSet.put("abc 101", car1svpoints);
	svcPointSet.put("def 101", car2svpoints);
	svcPointSet.put("ghi 101", car3svpoints);
	
}

public ArrayList<ServicePoint> getServicePoints(String rego){
	
	ArrayList<ServicePoint> alsvps = svcPointSet.get(rego);
	return alsvps;
}

public void passBooking (String inString) {
	
	System.out.println("In the actual booking implementation");
}

}