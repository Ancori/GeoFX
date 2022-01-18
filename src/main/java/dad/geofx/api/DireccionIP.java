package dad.geofx.api;

public class DireccionIP {

	private String ip;
	private String latitude;
	private String longitude;
	private String country_name;
	private String country_code;
	private String city;
	private String region_name;
	private String zip;
	private String languages;
	private Timezone time_zone;
    private Currency currency;
	private String org;
	private String version;
	private String asn;
	private String hostname;
	private String type;
	private boolean proxybooelan;
	private boolean torbooelan;
	private boolean vpnbooelan;
	private Location location;
	

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region_name;
	}

	public void setRegion(String region) {
		this.region_name = region;
	}

	public String getPostal() {
		return zip;
	}

	public void setPostal(String postal) {
		this.zip = postal;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAsn() {
		return asn;
	}

	public void setAsn(String asn) {
		this.asn = asn;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public boolean isProxybooelan() {
		return proxybooelan;
	}

	public void setProxybooelan(boolean proxybooelan) {
		this.proxybooelan = proxybooelan;
	}

	public boolean isTorbooelan() {
		return torbooelan;
	}

	public void setTorbooelan(boolean torbooelan) {
		this.torbooelan = torbooelan;
	}

	public boolean isVpnbooelan() {
		return vpnbooelan;
	}

	public void setVpnbooelan(boolean vpnbooelan) {
		this.vpnbooelan = vpnbooelan;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timezone getTime_zone() {
		return time_zone;
	}

	public void setTime_zone(Timezone time_zone) {
		this.time_zone = time_zone;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	

}
