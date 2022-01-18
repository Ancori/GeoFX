package dad.geofx.api;

public class Asn {
	
	String asn;
	String isp;
	String domain;
	public String getAsn() {
		return asn;
	}
	public void setAsn(String asn) {
		this.asn = asn;
	}
	public String getName() {
		return isp;
	}
	public void setName(String name) {
		this.isp = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public String getIsp() {
		return isp;
	}
	public void setIsp(String isp) {
		this.isp = isp;
	}
	@Override
	public String toString() {
		return "Asn [asn=" + asn + "]";
	}
	
	
	
	
	

}
