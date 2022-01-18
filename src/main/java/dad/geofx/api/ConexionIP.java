package dad.geofx.api;

public class ConexionIP {

	Asn connection;
    Proxy security;
	public Asn getAs() {
		return connection;
	}
	public void setAs(Asn as) {
		this.connection = as;
	}
	
	public Proxy getProxy() {
		return security;
	}
	public void setProxy(Proxy proxy) {
		this.security = proxy;
	}
	


	

}
