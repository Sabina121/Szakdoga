package application;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class SampleController implements Initializable {

	@FXML
	private TableView<Adatok> table;

	@FXML
	private TextField inputMegnevezes;

	@FXML
	private TextField inputLeltSzam;

	@FXML
	private TextField inputGyujtemeny;

	@FXML
	private TextField inputKor;

	@FXML
	private TextField inputMuzCim;

	@FXML
	private TextField inputMuzeum;

	@FXML
	private TextField inputAlkoto;

	@FXML
	private TextField inputDarab;

	@FXML
	private TextArea inputLeiras;

	@FXML
	private TextField inputMegszerzes;

	@FXML
	private TextField inputAr;

	@FXML
	private TextField inputTulaj;

	@FXML
	private TextField inputLhely;

	@FXML
	private TextField inputKolcs;

	@FXML
	private TextField inputRaktar;

	@FXML
	private TextField inputKiallHely;

	@FXML
	private TextField inputRevGyujt;

	@FXML
	private TextField inputAdatgyujt;

	@FXML
	private DatePicker inputRevDate;

	@FXML
	private Pane menuPane;

	@FXML
	private AnchorPane previewPane;
	
//	@FXML
//	void addFelvesz(ActionEvent event) {
//		database.addAdatok(
//				addGyarto.getText(), addTipus.getSelectionModel().getSelectedItem(),
//				addSzelesseg.getSelectionModel().getSelectedItem().intValue(),
//				addMagassag.getSelectionModel().getSelectedItem().intValue(),
//				addAtmero.getSelectionModel().getSelectedItem(),
//				addSulyindex.getSelectionModel().getSelectedItem().intValue(),
//				addSebessegindex.getSelectionModel().getSelectedItem(),
//				addUzemanyag.getSelectionModel().getSelectedItem(), 
//				addFekut.getSelectionModel().getSelectedItem(),
//				addZaj.getSelectionModel().getSelectedItem());
//		tableRefresh();
//	}	
//    
    SQLlite database = new SQLlite();
    

	private ObservableList<Adatok> data = FXCollections.observableArrayList(database.getAdatok());



	private void setTableDataLambda() {
		TableColumn<Adatok, String> muzeum = new TableColumn("Múzeum");
		TableColumn<Adatok, String> muzCim = new TableColumn("Cím");
		TableColumn<Adatok, String> megnevezes = new TableColumn("Megnevezés");
		TableColumn<Adatok, String> leltSzam = new TableColumn("Leltár szám");
		TableColumn<Adatok, String> gyujetemeny = new TableColumn("Gyüjtemény");
		TableColumn<Adatok, String> kor = new TableColumn("Kor");
		TableColumn<Adatok, String> alkoto = new TableColumn("Alkoto");
		TableColumn<Adatok, Number> darab = new TableColumn("Darab");
		TableColumn<Adatok, String> leiras = new TableColumn("Leírás");
		TableColumn<Adatok, String> lhely = new TableColumn("Lelőhely");
		TableColumn<Adatok, String> tulaj = new TableColumn("Tulajdonos");
		TableColumn<Adatok, String> megszerzes = new TableColumn("Megszerzés");
		TableColumn<Adatok, Number> ar = new TableColumn("Ár");
		TableColumn<Adatok, Boolean> kolcs = new TableColumn("Kölcsönzési Státusz");
		TableColumn<Adatok, String> kiallHely = new TableColumn("Kiallítasihely");
		TableColumn<Adatok, Boolean> raktar = new TableColumn("Raktár Státusz");
		TableColumn<Adatok, String> adatgyujt = new TableColumn("Adat gyüjtő");
		TableColumn<Adatok, String> revDate = new TableColumn("Revízió dátuma");
		TableColumn<Adatok, String> revGyujt = new TableColumn("Revíziót készítette");

		muzeum.setCellValueFactory(cellData -> cellData.getValue().muzeumProperty());
		muzCim.setCellValueFactory(cellData -> cellData.getValue().muzCimProperty());
		megnevezes.setCellValueFactory(cellData -> cellData.getValue().megnevezesProperty());
		leltSzam.setCellValueFactory(cellData -> cellData.getValue().leltSzamProperty());
		gyujetemeny.setCellValueFactory(cellData -> cellData.getValue().gyujetemenyProperty());
		kor.setCellValueFactory(cellData -> cellData.getValue().korProperty());
		alkoto.setCellValueFactory(cellData -> cellData.getValue().alkotoProperty());
		darab.setCellValueFactory(cellData -> cellData.getValue().arProperty());
		leiras.setCellValueFactory(cellData -> cellData.getValue().leirasProperty());
		lhely.setCellValueFactory(cellData -> cellData.getValue().lhelyProperty());
		tulaj.setCellValueFactory(cellData -> cellData.getValue().tulajProperty());
		ar.setCellValueFactory(cellData -> cellData.getValue().arProperty());
		megszerzes.setCellValueFactory(cellData -> cellData.getValue().megszerzesProperty());
		kolcs.setCellValueFactory(cellData -> cellData.getValue().kolcsProperty());
		kiallHely.setCellValueFactory(cellData -> cellData.getValue().kiallHelyProperty());
		raktar.setCellValueFactory(cellData -> cellData.getValue().raktarProperty());
		adatgyujt.setCellValueFactory(cellData -> cellData.getValue().adatgyujtProperty());
		revDate.setCellValueFactory(cellData -> cellData.getValue().revDateProperty());
		revGyujt.setCellValueFactory(cellData -> cellData.getValue().revGyujtProperty());

		kolcs.setCellFactory(p -> new TableCell<Adatok, Boolean>() {
			@Override
			public void updateItem(Boolean item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? null : item ? "Kikölcsönözve" : "Nincs kikölcsönözve");
			}
		});

		raktar.setCellFactory(p -> new TableCell<Adatok, Boolean>() {
			@Override
			public void updateItem(Boolean item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? null : item ? "Raktáron" : "Nincs raktáron");
			}
		});

//		muzeum.setOnEditCommit(new EventHandler<CellEditEvent<Adatok, String>>() {
//			@Override
//			public void handle(CellEditEvent<Adatok, String> t) {
//				((Adatok) t.getTableView().getItems().get(t.getTablePosition().getRow())).setMuzeum(t.getNewValue());
//			}
//		});

//		muzeum.setOnEditCommit((CellEditEvent<Adatok, String> a) ->
//	    a.getRowValue().setMuzeum(a.getNewValue()));

		table.getColumns().addAll(muzeum, muzCim, megnevezes, leltSzam, gyujetemeny, kor, alkoto, darab, leiras, lhely,
				tulaj, megszerzes, ar, kolcs, kiallHely, raktar, adatgyujt, revDate, revGyujt);
		table.setItems(data);

	}
	
	
	public static final LocalDate LOCAL_DATE (String dateString){
		   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		   LocalDate localDate = LocalDate.parse(dateString, formatter);
		   return localDate;
		}


	private void getValueViaClick() {
		table.setOnMouseClicked(e -> {
			Adatok p = table.getItems().get(table.getSelectionModel().getSelectedIndex());
			inputMuzeum.setText(p.getMuzeum());
			inputMuzCim.setText(p.getMuzCim());
			inputMegnevezes.setText(p.getMegnevezes());
			inputLeltSzam.setText(p.getLeltSzam());
			inputGyujtemeny.setText(p.getGyujetemeny());
			inputKor.setText(p.getKor());
			inputAlkoto.setText(p.getAlkoto());
			inputDarab.setText(String.valueOf(p.getDarab()));
			inputLeiras.setText(p.getLeiras());
			inputLhely.setText(p.getLhely());
			inputTulaj.setText(p.getTulaj());
			inputMegszerzes.setText(p.getMegszerzes());
			inputAr.setText(String.valueOf(p.getAr()));
			inputKolcs.setText(String.valueOf(p.isKolcs()));
			inputKiallHely.setText(p.getKiallHely());
			inputRaktar.setText(String.valueOf(p.isRaktar()));
			inputAdatgyujt.setText(p.getAdatgyujt());
			inputRevDate.setValue(LOCAL_DATE(p.getRevDate()));
			inputRevGyujt.setText(p.getRevGyujt());

		});
	}

	private void setMenuData() {
		TreeItem<String> treeItemRoot1 = new TreeItem("Menü");
		TreeView<String> treeView = new TreeView<>(treeItemRoot1);
		treeView.setShowRoot(false);

		TreeItem<String> nodeItemA = new TreeItem<>("Múzeumok");
		TreeItem<String> nodeItemB = new TreeItem<>("Gyűjtemények");
		TreeItem<String> nodeItemC = new TreeItem<>("Kultúrák");
		TreeItem<String> nodeItemD = new TreeItem<>("Kilépés");
		
		TreeItem<String> nodeItemA1 = new TreeItem<>("Magyar Nemzeti Múzeum");
		TreeItem<String> nodeItemA2 = new TreeItem<>("Móra Ferenc Múzeum");
		TreeItem<String> nodeItemA3 = new TreeItem<>("Koszta József Múzeum");

		TreeItem<String> nodeItemB1 = new TreeItem<>("Őskori gyűjtemény");
		TreeItem<String> nodeItemB2 = new TreeItem<>("Római kori");
		TreeItem<String> nodeItemB3 = new TreeItem<>("Népvándorláskori gyűjtemény");
		TreeItem<String> nodeItemB4 = new TreeItem<>("Avar kori gyűjtemény");
		
		TreeItem<String> nodeItemC1 = new TreeItem<>("La Tene");
		TreeItem<String> nodeItemC2 = new TreeItem<>("Kelta");
		TreeItem<String> nodeItemC3 = new TreeItem<>("Római");
		TreeItem<String> nodeItemC4 = new TreeItem<>("Gepida");
		TreeItem<String> nodeItemC5 = new TreeItem<>("Langobárd");

		treeItemRoot1.getChildren().addAll(nodeItemA, nodeItemB, nodeItemC, nodeItemD);
		nodeItemA.getChildren().addAll(nodeItemA1,nodeItemA2,nodeItemA3);
		nodeItemB.getChildren().addAll(nodeItemB1,nodeItemB2,nodeItemB3,nodeItemB4);
		nodeItemC.getChildren().addAll(nodeItemC1,nodeItemC2,nodeItemC3,nodeItemC4,nodeItemC5);

		menuPane.getChildren().add(treeView);

	}
	
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		setTableDataLambda();
		setMenuData();
		getValueViaClick();
	}

}
