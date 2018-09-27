package basicEntities;

public class Home {
	private String address1;
	private String address2;
	private String postcode;

	public Home(String address1, String address2, String postcode) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.postcode = postcode;
	}
	
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
}
