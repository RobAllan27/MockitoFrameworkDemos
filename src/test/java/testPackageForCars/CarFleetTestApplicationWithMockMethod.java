package testPackageForCars;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;

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
import carInsurance.CarInsuranceImpl;
import carPayments.CarPayment;
import carPayments.Payment;
import carServicing.CarServicing;
import carServicing.CarServicingImpl;
import carServicing.ServicePoint;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class CarFleetTestApplicationWithMockMethod {

	private Car carToBeTested;
	private CarInsurance carInsur;
	private CarFleetSystem carFleetSystem;
	   
   //not sure yet if I have to annotate with @Mock each service line separately - to try


   @Before
   public void setUpDummyMockingData() {
	   // here we will set up our mocking data
		
		carToBeTested =  new Car();
		carToBeTested.setColour("red");
		carToBeTested.setRego("abc");
		

		// we will create a mock of the actual car Insurance.
		carFleetSystem = new CarFleetSystem();
		carInsur = mock(CarInsurance.class);
		carFleetSystem.setCarInsurance(carInsur);
   }
   
   
   
   @Test
   public void testCarInsuranceStartswithA(){

	// set what the mock should do		
      when(carInsur.getQuote("abc")).thenReturn(100);
      
      //test the add functionality
      
     // Test the API for first service point
      
      carToBeTested.setRego("abc");
      
      System.out.println("In the 5th test - with Mock()");
      
      Assert.assertEquals(carFleetSystem.getInsuranceQuote(carToBeTested),"90.0");
   }
   
   @Test
   public void testCarInsuranceStartswithB(){

	// set what the mock should do		
      when(carInsur.getQuote("bcd")).thenReturn(100);
      
      //test the add functionality
      
     // Test the API for first service point
     
      carToBeTested.setRego("bcd");
      
      System.out.println("In the 6th test - with Mock()");
      
      Assert.assertEquals(carFleetSystem.getInsuranceQuote(carToBeTested),"80.0");
   }
}
