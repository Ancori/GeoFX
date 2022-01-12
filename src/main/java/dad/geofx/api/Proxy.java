package dad.geofx.api;

public class Proxy {

	String proxy;
	String vpn;
	String tor;

	public String getProxy() {
		return proxy;
	}

	public void setProxy(String proxy) {
		this.proxy = proxy;
	}

	public String getVpn() {
		return vpn;
	}

	public void setVpn(String vpn) {
		this.vpn = vpn;
	}

	public String getTor() {
		return tor;
	}

	public void setTor(String tor) {
		this.tor = tor;
	}

	@Override
	public String toString() {
		return "Proxy [proxy=" + proxy + ", vpn=" + vpn + ", tor=" + tor + "]";
	}

	

}
