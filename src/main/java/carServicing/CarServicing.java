package carServicing;

import java.util.ArrayList;

public interface CarServicing {

	public ArrayList<ServicePoint> getServicePoints(String rego);
	
	public void passBooking (String bookingRef);
	
}
