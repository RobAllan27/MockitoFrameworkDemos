package testPackageForCars;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.Computer;
import org.junit.experimental.ParallelComputer;
//import org.junit.*;


public class LocalTestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("In the jar runner again");
		runOnce();
		//runSerial();
		//runParallel();
	}
	
	  private static void runOnce() {
	      System.out.println("--------\nRunning Once");
	      JUnitCore jUnitCore = new JUnitCore();
	      Result run = jUnitCore.run(Computer.serial(), CarFleetTestApplication.class);
	      //Util.printResult(run);
	      
	      for (Failure failure : run.getFailures()) {
	          System.out.println(failure.toString());
	       }
	       
	       System.out.println(run.wasSuccessful());
	      
	  }
	  
	  /*
	  private static void runSerial() {
	      System.out.println("--------\nRunning Serial");
	      JUnitCore jUnitCore = new JUnitCore();
	      Result run = jUnitCore.run(Computer.serial(), CarFleetTestApplication.class);
	      //Util.printResult(run);
	      
	      long startTime = System.nanoTime();
	      
	      run = jUnitCore.run(Computer.serial(), CarFleetTestApplication.class);
	      
	      run = jUnitCore.run(Computer.serial(), CarFleetTestApplication.class);
	      
	      run = jUnitCore.run(Computer.serial(), CarFleetTestApplication.class);
	      
	      long endTime = System.nanoTime();
	      
	      long duration = (endTime - startTime); // translate nanoseconds to microseconds
	      
	      System.out.println("Serial Times " + duration);
	      
	  }
	  
	  private static void runParallel() {
	      System.out.println("--------\nRunning Parallel");
	      JUnitCore jUnitCore = new JUnitCore();
	      //Util.printResult(run);
	      
	      long startTime = System.nanoTime(); 
	      
	      Result run = jUnitCore.run(ParallelComputer.methods(), CarFleetTestApplication.class);
	      
	      run = jUnitCore.run(ParallelComputer.methods(), CarFleetTestApplication.class);
	      
	      run = jUnitCore.run(ParallelComputer.methods(), CarFleetTestApplication.class);
	      
	      long endTime = System.nanoTime();
	      
	      long duration = (endTime - startTime); // translate nanoseconds to microseconds
	      
	      System.out.println("Parallel Times " + duration);
	  }
	  */
}
