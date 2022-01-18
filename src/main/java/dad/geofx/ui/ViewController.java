package dad.geofx.ui;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import dad.geofx.api.DireccionIP;
import dad.geofx.api.GeoApiService;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.fxml.Initializable;

public class ViewController implements Initializable {

	GeoApiService api = new GeoApiService();

	private ObjectProperty<DireccionIP> direccion = new SimpleObjectProperty<>();
	private StringProperty ip = new SimpleStringProperty();
	private StringProperty latitude = new SimpleStringProperty();
	private StringProperty longitud = new SimpleStringProperty();
	private StringProperty localizacion = new SimpleStringProperty();
	private StringProperty city = new SimpleStringProperty();
	private StringProperty code = new SimpleStringProperty();
	private StringProperty lenguaje = new SimpleStringProperty();
	private StringProperty zonahoraria = new SimpleStringProperty();
	private StringProperty callcode = new SimpleStringProperty();
	private StringProperty currency = new SimpleStringProperty();
	private StringProperty asn = new SimpleStringProperty();
	private StringProperty type = new SimpleStringProperty();
	private StringProperty registered = new SimpleStringProperty();
	private StringProperty hostname = new SimpleStringProperty();
	private BooleanProperty proxy=new SimpleBooleanProperty();
	private BooleanProperty tor=new SimpleBooleanProperty();
	private BooleanProperty vpn=new SimpleBooleanProperty();

	@FXML
	private Label calllabel;

	@FXML
	private Label citylabel;

	@FXML
	private Label codelabel;

	@FXML
	private Label currrencylabel;

	@FXML
	private ImageView image;

	@FXML
	private Button ipbutton;

	@FXML
	private TextField iptext;

	@FXML
	private Label latitudelabel;

	@FXML
	private Label lenguajelabel;

	@FXML
	private Label localitationlabel;

	@FXML
	private Label longitudelabel;

	@FXML
	private Label timezonelabel;

	@FXML
	private Label asnlabel;

	@FXML
	private Label hostnamelabel;

	@FXML
	private Label iplabel;

	@FXML
	private Label registeredIspLabel;

	@FXML
	private Label typelabel;
	
	@FXML
    private CheckBox crawlercheck;
	

    @FXML
    private CheckBox proxycheck;
    
    @FXML
    private CheckBox torcheck;
	

	@FXML
	private BorderPane view;

	public ViewController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ViewPrincipal.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// bindeos
		iptext.textProperty().bindBidirectional(ip);
		iplabel.textProperty().bind(ip);
		latitudelabel.textProperty().bind(latitude);
		longitudelabel.textProperty().bind(longitud);
		localitationlabel.textProperty().bind(localizacion);
		citylabel.textProperty().bind(city);
		codelabel.textProperty().bind(code);
		lenguajelabel.textProperty().bind(lenguaje);
		timezonelabel.textProperty().bind(zonahoraria);
		calllabel.textProperty().bind(callcode);
		currrencylabel.textProperty().bind(currency);
		typelabel.textProperty().bind(type);
		registeredIspLabel.textProperty().bind(registered);
		asnlabel.textProperty().bind(asn);
		hostnamelabel.textProperty().bind(hostname);
		proxycheck.selectedProperty().bind(proxy);
		torcheck.selectedProperty().bind(tor);
		crawlercheck.selectedProperty().bind(vpn);

		Task<String> iptask = new Task<String>() {
			@Override
			protected String call() throws Exception {
				return api.obtenermiIp();

			}
		};
		iptask.setOnSucceeded(event -> {
			direccion.set(api.obtener(iptask.getValue()));
			// asignamos valores
			meterdatos();
			// listener
			direccion.addListener((o, ov, nv) -> ondireccionchanged(o, ov, nv));
		});
		iptask.setOnFailed(event -> {
			event.getSource().getException().printStackTrace();
		});
		new Thread(iptask).start();

		// 94.80.188.102 .. 193.146.93.30

	}

	private void ondireccionchanged(ObservableValue<? extends DireccionIP> o, DireccionIP ov, DireccionIP nv) {
		// cuando cambia la direccion se asigna nuevos valores
		Task<Void> task = new Task<Void>() {
	        @Override protected Void call() throws Exception {
	        	meterdatos();
	            return null;
	        }
	    };

	 
	    task.run();
		
	}

	@FXML
	void onipbutton(ActionEvent event) {
		Task<DireccionIP> buttontask = new Task<DireccionIP>() {
			@Override
			protected DireccionIP call() throws Exception {
				return api.obtener(ip.get());
			}
		};
		buttontask.setOnSucceeded(event2 -> {
			direccion.set(buttontask.getValue());

		});
		buttontask.setOnFailed(event2 -> {
			event2.getSource().getException().printStackTrace();
		});
		new Thread(buttontask).start();

	}
	
	private void meterdatos() {
		ip.set(direccion.get().getIp());
		latitude.set(direccion.get().getLatitude());
		longitud.set(direccion.get().getLongitude());
		localizacion.set(direccion.get().getCountry_name() + " (" + direccion.get().getCountry_code() + ")");
		image.setImage(new Image("file:src/main/resources/images/64x42/" + direccion.get().getCountry_code() + ".png"));
		city.set(direccion.get().getCity());
		code.set(direccion.get().getPostal());
		lenguaje.set(direccion.get().getLanguages());
		zonahoraria.set(direccion.get().getTime_zone().getCode());
		callcode.set(direccion.get().getLocation().getCalling_code());
		currency.set(direccion.get().getCurrency().getName()+" ("+direccion.get().getCurrency().getCode()+")");
		type.set(direccion.get().getType());
		registered.set(direccion.get().getOrg());
		asn.set(direccion.get().getAsn());
		hostname.set(direccion.get().getHostname());
		proxy.set(direccion.get().isProxybooelan());
		tor.set(direccion.get().isTorbooelan());
		vpn.set(direccion.get().isVpnbooelan());
	}

	public BorderPane getView() {
		return view;
	}

}
