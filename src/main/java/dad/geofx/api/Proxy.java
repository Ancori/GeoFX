package dad.geofx.api;

public class Proxy {

	String is_proxy;
	String is_crawler;
	String is_tor;
	

	public String getProxy() {
		return is_proxy;
	}

	public void setProxy(String proxy) {
		this.is_proxy = proxy;
	}

	public String getVpn() {
		return is_crawler;
	}

	public void setVpn(String vpn) {
		this.is_crawler = vpn;
	}

	public String getTor() {
		return is_tor;
	}

	public void setTor(String tor) {
		this.is_tor = tor;
	}

	@Override
	public String toString() {
		return "Proxy [proxy=" + is_proxy + ", vpn=" + is_crawler + ", tor=" + is_tor + "]";
	}

	

}
