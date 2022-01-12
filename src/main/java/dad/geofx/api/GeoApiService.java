package dad.geofx.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class GeoApiService {

	public DireccionIP obtener(String ip) {
		DireccionIP obj = new DireccionIP();
		ConexionIP obj2 = new ConexionIP();

		try {
			String json = "";
			URL ipapi = new URL("https://ipapi.co/" + ip + "/json/");
			URLConnection c = ipapi.openConnection();
			c.setRequestProperty("User-Agent", "java-ipapi-v1.02");
			BufferedReader reader = new BufferedReader(new InputStreamReader(c.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				json += line;
			}
			reader.close();
			obj = new Gson().fromJson(json, DireccionIP.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String url2 = "https://geo.ipify.org/api/v2/country,city,vpn?apiKey=at_1kZZC1tcH2d0Aqcvxm03jrVGADYMy&ipAddress="
				+ ip;
		String json = "";
		try (java.util.Scanner s = new java.util.Scanner(new java.net.URL(url2).openStream())) {
			json += s.useDelimiter("\\A").next();
			obj2 = new Gson().fromJson(json, ConexionIP.class);
			obj.setAsn(obj2.getAs().getAsn());
			obj.setHostname(obj2.getIsp());
			boolean[] vector = comprobarProxy(obj2.getProxy().getProxy(), obj2.getProxy().getTor(),
					obj2.getProxy().getVpn());
			obj.setProxybooelan(vector[0]);
			obj.setTorbooelan(vector[1]);
			obj.setVpnbooelan(vector[2]);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return obj;

	}

	public String obtenermiIp() {
		String ip = "";
		try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(),
				"UTF-8").useDelimiter("\\A")) {
			ip = s.next();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		return ip;

	}

	private boolean[] comprobarProxy(String proxy, String tor, String vpn) {
		boolean[] vector = new boolean[3];
		if (proxy.equals("true")) {
			vector[0] = true;
		} else {
			vector[0] = false;
		}
		if (tor.equals("true")) {
			vector[1] = true;
		} else {
			vector[1] = false;
		}
		if (vpn.equals("true")) {
			vector[2] = true;
		} else {
			vector[2] = false;
		}

		return vector;

	}

}
