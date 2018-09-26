package application;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Adatok {
	private SimpleStringProperty id;
	private SimpleStringProperty muzeum;
	private SimpleStringProperty muzCim;
	private SimpleStringProperty megnevezes;
	private SimpleStringProperty leltSzam;
	private SimpleStringProperty gyujetemeny;
	private SimpleStringProperty kor;
	private SimpleStringProperty alkoto;
	private SimpleIntegerProperty darab;
	private SimpleStringProperty leiras;
	private SimpleStringProperty lhely;
	private SimpleStringProperty tulaj;
	private SimpleStringProperty megszerzes;
	private SimpleIntegerProperty ar;
	private SimpleBooleanProperty kolcs;
	private SimpleStringProperty kiallHely;
	private SimpleBooleanProperty raktar;
	private SimpleStringProperty adatgyujt;
	private SimpleStringProperty revDate;
	private SimpleStringProperty revGyujt;

	public Adatok(String id, String muzeum, String muzCim, String megnevezes, String leltSzam, String gyujetemeny, String kor,
			String alkoto, int darab, String leiras, String lhely, String tulaj, String megszerzes, int ar,
			boolean kolcs, String kiallHely, boolean raktar, String adatgyujt, String revDate, String revGyujt) {

		this.id = new SimpleStringProperty(id);
		this.muzeum = new SimpleStringProperty(muzeum);
		this.muzCim = new SimpleStringProperty(muzCim);
		this.megnevezes = new SimpleStringProperty(megnevezes);
		this.leltSzam = new SimpleStringProperty(leltSzam);
		this.gyujetemeny = new SimpleStringProperty(gyujetemeny);
		this.kor = new SimpleStringProperty(kor);
		this.alkoto = new SimpleStringProperty(alkoto);
		this.darab = new SimpleIntegerProperty(darab);
		this.leiras = new SimpleStringProperty(leiras);
		this.lhely = new SimpleStringProperty(lhely);
		this.tulaj = new SimpleStringProperty(tulaj);
		this.megszerzes = new SimpleStringProperty(megszerzes);
		this.ar = new SimpleIntegerProperty(ar);
		this.kolcs = new SimpleBooleanProperty(kolcs);
		this.kiallHely = new SimpleStringProperty(kiallHely);
		this.raktar = new SimpleBooleanProperty(raktar);
		this.adatgyujt = new SimpleStringProperty(adatgyujt);
		this.revDate = new SimpleStringProperty(revDate);
		this.revGyujt = new SimpleStringProperty(revGyujt);
	}
	
	public final SimpleStringProperty idProperty() {
		return this.id;
	}

	public final String getId() {
		return this.idProperty().get();
	}

	public final void setId(final String id) {
		this.idProperty().set(id);
	}

	public final SimpleStringProperty muzeumProperty() {
		return this.muzeum;
	}

	public final String getMuzeum() {
		return this.muzeumProperty().get();
	}

	public final void setMuzeum(final String muzeum) {
		this.muzeumProperty().set(muzeum);
	}

	public final SimpleStringProperty muzCimProperty() {
		return this.muzCim;
	}

	public final String getMuzCim() {
		return this.muzCimProperty().get();
	}

	public final void setMuzCim(final String muzCim) {
		this.muzCimProperty().set(muzCim);
	}

	public final SimpleStringProperty megnevezesProperty() {
		return this.megnevezes;
	}

	public final String getMegnevezes() {
		return this.megnevezesProperty().get();
	}

	public final void setMegnevezes(final String megnevezes) {
		this.megnevezesProperty().set(megnevezes);
	}

	public final SimpleStringProperty leltSzamProperty() {
		return this.leltSzam;
	}

	public final String getLeltSzam() {
		return this.leltSzamProperty().get();
	}

	public final void setLeltSzam(final String leltSzam) {
		this.leltSzamProperty().set(leltSzam);
	}

	public final SimpleStringProperty gyujetemenyProperty() {
		return this.gyujetemeny;
	}

	public final String getGyujetemeny() {
		return this.gyujetemenyProperty().get();
	}

	public final void setGyujetemeny(final String gyujetemeny) {
		this.gyujetemenyProperty().set(gyujetemeny);
	}

	public final SimpleStringProperty korProperty() {
		return this.kor;
	}

	public final String getKor() {
		return this.korProperty().get();
	}

	public final void setKor(final String kor) {
		this.korProperty().set(kor);
	}

	public final SimpleStringProperty alkotoProperty() {
		return this.alkoto;
	}

	public final String getAlkoto() {
		return this.alkotoProperty().get();
	}

	public final void setAlkoto(final String alkoto) {
		this.alkotoProperty().set(alkoto);
	}

	public final SimpleIntegerProperty darabProperty() {
		return this.darab;
	}

	public final int getDarab() {
		return this.darabProperty().get();
	}

	public final void setDarab(final int darab) {
		this.darabProperty().set(darab);
	}

	public final SimpleStringProperty leirasProperty() {
		return this.leiras;
	}

	public final String getLeiras() {
		return this.leirasProperty().get();
	}

	public final void setLeiras(final String leiras) {
		this.leirasProperty().set(leiras);
	}

	public final SimpleStringProperty lhelyProperty() {
		return this.lhely;
	}

	public final String getLhely() {
		return this.lhelyProperty().get();
	}

	public final void setLhely(final String lhely) {
		this.lhelyProperty().set(lhely);
	}

	public final SimpleStringProperty tulajProperty() {
		return this.tulaj;
	}

	public final String getTulaj() {
		return this.tulajProperty().get();
	}

	public final void setTulaj(final String tulaj) {
		this.tulajProperty().set(tulaj);
	}

	public final SimpleStringProperty megszerzesProperty() {
		return this.megszerzes;
	}

	public final String getMegszerzes() {
		return this.megszerzesProperty().get();
	}

	public final void setMegszerzes(final String megszerzes) {
		this.megszerzesProperty().set(megszerzes);
	}

	public final SimpleIntegerProperty arProperty() {
		return this.ar;
	}

	public final int getAr() {
		return this.arProperty().get();
	}

	public final void setAr(final int ar) {
		this.arProperty().set(ar);
	}

	public final SimpleBooleanProperty kolcsProperty() {
		return this.kolcs;
	}

	public final boolean isKolcs() {
		return this.kolcsProperty().get();
	}

	public final void setKolcs(final boolean kolcs) {
		this.kolcsProperty().set(kolcs);
	}

	public final SimpleStringProperty kiallHelyProperty() {
		return this.kiallHely;
	}

	public final String getKiallHely() {
		return this.kiallHelyProperty().get();
	}

	public final void setKiallHely(final String kiallHely) {
		this.kiallHelyProperty().set(kiallHely);
	}

	public final SimpleBooleanProperty raktarProperty() {
		return this.raktar;
	}

	public final boolean isRaktar() {
		return this.raktarProperty().get();
	}

	public final void setRaktar(final boolean raktar) {
		this.raktarProperty().set(raktar);
	}

	public final SimpleStringProperty adatgyujtProperty() {
		return this.adatgyujt;
	}

	public final String getAdatgyujt() {
		return this.adatgyujtProperty().get();
	}

	public final void setAdatgyujt(final String adatgyujt) {
		this.adatgyujtProperty().set(adatgyujt);
	}

	public final SimpleStringProperty revDateProperty() {
		return this.revDate;
	}

	public final String getRevDate() {
		return this.revDateProperty().get();
	}

	public final void setRevDate(final String revDate) {
		this.revDateProperty().set(revDate);
	}

	public final SimpleStringProperty revGyujtProperty() {
		return this.revGyujt;
	}

	public final String getRevGyujt() {
		return this.revGyujtProperty().get();
	}

	public final void setRevGyujt(final String revGyujt) {
		this.revGyujtProperty().set(revGyujt);
	}

	@Override
	public String toString() {
		return "Adatok [id=" + id + ", muzeum=" + muzeum + ", muzCim=" + muzCim + ", megnevezes=" + megnevezes
				+ ", leltSzam=" + leltSzam + ", gyujetemeny=" + gyujetemeny + ", kor=" + kor + ", alkoto=" + alkoto
				+ ", darab=" + darab + ", leiras=" + leiras + ", lhely=" + lhely + ", tulaj=" + tulaj + ", megszerzes="
				+ megszerzes + ", ar=" + ar + ", kolcs=" + kolcs + ", kiallHely=" + kiallHely + ", raktar=" + raktar
				+ ", adatgyujt=" + adatgyujt + ", revDate=" + revDate + ", revGyujt=" + revGyujt + "]";
	}

	

}