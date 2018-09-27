package testPackageForCars;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
//import static org.mockito.Mockito.thenAnswer;
//import static org.mockito.Mockito.answer;

import static org.mockito.Mockito.timeout;
//import static org.mockito.Mockito.doThrow();
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

///
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import basicEntities.Car;
import basicEntities.Home;
import businessLogicConsolidationPackage.CarFleetSystem;
import carInsurance.CarInsurance;
import carPayments.CarPayment;
import carPayments.Payment;
import carServicing.CarServicing;
import carServicing.ServicePoint;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class CarFleetTestApplication {

	private ArrayList<ServicePoint> car1svpoints;
	private ArrayList<Payment> payments;
	private Car carToBetested;
	
	private CarInsurance carInsur;
	
	// we create the following entities to allow us to create a home and then spy on it
	private Home home;
	private Home spyHome;
	
	
	//private CarFleetSystem carFleetSystemInstance;
	
	
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
		carToBetested.setRego("abc");
		
		payments = new ArrayList<Payment>();
		Payment payment1 = new Payment();
		Payment payment2 = new Payment();
		Payment payment3 = new Payment();
		payment1.setAmountDue("145");
		payment2.setAmountDue("245");
		payment3.setAmountDue("345");
		payment1.setDueDate("01/01/2018");
		payment2.setDueDate("01/02/2018");
		payment3.setDueDate("01/03/2018");
		payment1.setReallyDueDate("02/01/2018");
		payment2.setReallyDueDate("02/02/2018");
		payment3.setReallyDueDate("02/03/2018");
		payments.add(payment1);
		payments.add(payment2);
		payments.add(payment3);
		
		// we will create a mock of the actual car Insurance.
		// carFleetSystemInstance = new CarFleetSystem();
		//carInsur = mock(CarInsurance.class);
		//carFleetSystemInstance.set
		
		// we will also set up a real home
		home  = new Home("42, The Cresent","Mortdale","2223");
		spyHome = spy(home);
   }
   
   @Test
   public void testfirstsvcPoint(){

	// set what the mock should do		
      when(carServicing.getServicePoints("abc")).thenReturn(car1svpoints);
      
      //test the add functionality
      
     // Test the API for first service point
      
      System.out.println("In the 1st test");
      
      Assert.assertEquals(carFleetSystem.getFirstNumberKmsofServicingForCar(carToBetested),11000);
   }
   
   @Test
   public void verifySpyEffectOnRealInstance() {
	   spyHome.setPostcode("2500");
   	  	assertFalse(home.getPostcode().equals(spyHome.getPostcode()));
   }


   @Test
   public void spySkillUsingWhenThenReturn() {
        when(spyHome.getAddress1()).thenReturn("SPY");
        assertEquals("SPY", spyHome.getAddress1());
   }


   @Test
   public void testCarHomeUsingdoReturn () {
         doReturn("SPY").when(spyHome).getAddress2();
         assertEquals("SPY", spyHome.getAddress2());
   }
   
   @Test
   public void testlastsvcPoint(){


	// set what the mock should do		
      when(carServicing.getServicePoints("abc")).thenReturn(car1svpoints);
      
      //test the add functionality
      
     // Test the API for first service point
      
      System.out.println("In the 2nd test");
      
      Assert.assertEquals(carFleetSystem.getLastNumberKmsofServicingForCar(carToBetested),31000);
      
      verify(carServicing).getServicePoints("abc");
      verify(carServicing, times(1)).getServicePoints("abc");
      verify(carInsurance, never()).getQuote("abc");
      
      Assert.assertEquals(carFleetSystem.getLastNumberKmsofServicingForCar(carToBetested),31000);
      Assert.assertEquals(carFleetSystem.getLastNumberKmsofServicingForCar(carToBetested),31000);
      verify(carServicing, times(3)).getServicePoints("abc");
   }
   
   
   @Test
   public void testCarPaymentsNextDueDate(){

	// set what the mock should do		
      when(carPayment.getPayments("abc")).thenReturn(payments);
      
      //test the add functionality
      
     // Test the API for first service point
      
      System.out.println("In the 3rd test");
      
      Assert.assertEquals(carFleetSystem.getNextPaymentPlanDueDate(carToBetested),"01/01/2018");
      
      verify(carPayment, atLeastOnce()).getPayments("abc");
       
      Assert.assertEquals(carFleetSystem.getNextPaymentPlanDueDate(carToBetested),"01/01/2018");
      Assert.assertEquals(carFleetSystem.getNextPaymentPlanDueDate(carToBetested),"01/01/2018");
      
      verify(carPayment, atLeast(2)).getPayments("abc");
      verify(carPayment, atMost(3)).getPayments("abc");
      
   }
   
   @Test
   public void testCarPaymentsNextReallyDueDate(){

	// set what the mock should do		
      when(carPayment.getPayments("abc")).thenReturn(payments);
      
      //test the add functionality
      
     // Test the API for first service point
      
      System.out.println("In the 4th test");
      
      Assert.assertEquals(carFleetSystem.getNextPaymentPlanReallyDueDate(carToBetested),"02/01/2018");
   }
   
   
   @Test
   public void testCarInsuranceStartswithA(){

	// set what the mock should do		
      when(carInsurance.getQuote("abc")).thenReturn(100);
      
      //test the add functionality
      
     // Test the API for first service point
      
      carToBetested.setRego("abc");
      
      System.out.println("In the 5th test");
      
      Assert.assertEquals(carFleetSystem.getInsuranceQuote(carToBetested),"90.0");
   }
   
   @Test
   public void testCarInsuranceStartswithB(){

	// set what the mock should do		
      when(carInsurance.getQuote("bcd")).thenReturn(100);
      
      //test the add functionality
      
     // Test the API for first service point
     
      carToBetested.setRego("bcd");
      
      System.out.println("In the 6th test");
      
      Assert.assertEquals(carFleetSystem.getInsuranceQuote(carToBetested),"80.0");
   }
   
   @Test
   public void testCarInsuranceStartswithC(){

	// set what the mock should do		
      when(carInsurance.getQuote("cde")).thenReturn(100);
      
      //test the add functionality
      
     // Test the API for first service point
      
      carToBetested.setRego("cde");
      
      System.out.println("In the 7th test");
      
      Assert.assertEquals(carFleetSystem.getInsuranceQuote(carToBetested),"70.0");
   }
   
   @Test
   public void testCarInsuranceStartswithD(){

	// set what the mock should do		
      when(carInsurance.getQuote("def")).thenReturn(100);
      
      //test the add functionality
      
     // Test the API for first service point
      
      carToBetested.setRego("def");
      System.out.println("In the 8th test");
      
      Assert.assertEquals(carFleetSystem.getInsuranceQuote(carToBetested),"100.0");
   }

   
   /*
   @Test(expected = RuntimeException.class)
   public void testAdd(){
      //add the behavior to throw exception
	   carToBetested.setRego("efg");
	   
	   doThrow(new RuntimeException("InsuranceQuote Not added not fully implemented"))
         .when(carInsurance).getQuote("efg");

	   System.out.println("In the 9th test");
	   
      //test the add functionality
      Assert.assertEquals(carFleetSystem.getInsuranceQuote(carToBetested),"200"); 
   }
   */
   
   @Test
   public void testCarMethodOrder(){
	   carToBetested.setRego("abc");
	// set what the mock should do	
	   
	   when(carServicing.getServicePoints("abc")).thenReturn(car1svpoints); 
      
      System.out.println("In the 10th test");
      
      InOrder inOrder = inOrder(carServicing);

      //following will make sure that add is first called then subtract is called
      
      Assert.assertEquals(carFleetSystem.getFirstNumberKmsofServicingForCar(carToBetested),11000);
      
      inOrder.verify(carServicing).getServicePoints("abc");
      inOrder.verify(carServicing).passBooking("Hello String");
   }
   
   
   @Test
   public void testCarInsuranceStartswithCandthenD() {

	// set what the mock should do		
      when(carInsurance.getQuote("cde")).thenReturn(100);
      
      
      carToBetested.setRego("cde");      
      
      Assert.assertEquals(carFleetSystem.getInsuranceQuote(carToBetested),"70.0");
		
      verify(carInsurance, times(1)).getQuote("cde");
           
      reset(carInsurance);
      
      when(carInsurance.getQuote("cde")).thenReturn(100);
      
      when(carInsurance.getQuote("def")).thenReturn(100);

      carToBetested.setRego("cde");
      
      Assert.assertEquals(carFleetSystem.getInsuranceQuote(carToBetested),"70.0");
      
      verify(carInsurance, times(1)).getQuote("cde");
      
      carToBetested.setRego("def");
      
      Assert.assertEquals(carFleetSystem.getInsuranceQuote(carToBetested),"100.0");
      
      verify(carInsurance, times(1)).getQuote("def");
   }
   
   @Test
   public void testGetQuoteGetsCalledQuickly(){

	// set what the mock should do		
      when(carInsurance.getQuote("abc")).thenReturn(100);
      
      carToBetested.setRego("abc");
      
      Assert.assertEquals(carFleetSystem.getInsuranceQuote(carToBetested),"90.0");
      verify(carInsurance, timeout(5)).getQuote("abc");
   }

   
   // final case -  we use the Answer interface to provide more of stub, ie where we will actually return something.
   
   @Test
   public void testCarInsuranceAnswerAsStub(){

	// set what the mock should do		
      //when(carInsurance.getQuote("bcd")).thenReturn(100);
      
      when(carInsurance.getQuote("bcd")).thenAnswer(new Answer() {
    	   @Override
    	   public Integer answer(InvocationOnMock invocation) throws Throwable {
    	      //get the arguments passed to mock
    	      Object[] args = invocation.getArguments();
    	      //get the mock 
    	      Object mock = invocation.getMock();	
    	      //return the result - more logic could be run here if required.
    	      return 100;
    	   }
    	});
      
      
      //test the add functionality
      
     // Test the API for first service point
     
      carToBetested.setRego("bcd");
      
      Assert.assertEquals(carFleetSystem.getInsuranceQuote(carToBetested),"80.0");
   }
   
   
}