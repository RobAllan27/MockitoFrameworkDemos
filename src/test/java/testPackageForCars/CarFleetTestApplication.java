package testPackageForCars;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import basicEntities.Car;
import businessLogicConsolidationPackage.CarFleetSystem;
import carInsurance.CarInsurance;
import carPayments.CarPayment;
import carServicing.CarServicing;
import carServicing.CarServicingImpl;
import carServicing.ServicePoint;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class CarFleetTestApplication {

	private ArrayList<ServicePoint> car1svpoints;
	private Car carToBetested;
	
	
   //@InjectMocks annotation is used to create and inject the mock object
   @InjectMocks 
   CarFleetSystem carFleetSystem = new CarFleetSystem();

   //@Mock annotation is used to create the mock object to be injected
   @Mock
   //CaCarServicinglculatorService calcService;
   CarServicing carServicing;
   
   //not sure yet if I have to annotate with @Mock each service line separately - to try
   
   @Mock
   CarPayment carPayment;
   
   @Mock
   CarInsurance carInsurance;

   @Before
   public void setUpDummyMockingData() {
	   // here we will set up our mocking data

		car1svpoints = new ArrayList<ServicePoint>();				
		
		ServicePoint c1svcpt1 = new ServicePoint();
		ServicePoint c1svcpt2 = new ServicePoint();
		ServicePoint c1svcpt3 = new ServicePoint();
		
		c1svcpt1.setMileage(11000);
		c1svcpt1.setSvcDueDate("25/08/2016");
		c1svcpt2.setMileage(21000);
		c1svcpt2.setSvcDueDate("25/08/2017");
		c1svcpt3.setMileage(31000);
		c1svcpt3.setSvcDueDate("25/08/2018");

		car1svpoints.add(c1svcpt1);
		car1svpoints.add(c1svcpt2);
		car1svpoints.add(c1svcpt3);
		
		carToBetested =  new Car();
		carToBetested.setColour("red");
	   
	   
   }
   
   @Test
   public void testfirstsvcPoint(){

		carToBetested.setRego("abc");

	// set what the mock should do		
      when(carServicing.getServicePoints("abc")).thenReturn(car1svpoints);
      
      //test the add functionality
      
     // Test the API for first service point
      
      System.out.println("In the 1st test");
      
      Assert.assertEquals(carFleetSystem.getFirstNumberKmsofServicingForCar(carToBetested),12000);
      
   }
   
   @Test
   public void testlastsvcPoint(){

		carToBetested.setRego("abc");

	// set what the mock should do		
      when(carServicing.getServicePoints("abc")).thenReturn(car1svpoints);
      
      //test the add functionality
      
     // Test the API for first service point
      
      System.out.println("In the 2nd test");
      
      Assert.assertEquals(carFleetSystem.getLastNumberKmsofServicingForCar(carToBetested),31000);
      
   }
   
   
}
