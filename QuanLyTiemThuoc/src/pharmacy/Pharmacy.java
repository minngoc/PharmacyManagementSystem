package pharmacy;

public class Pharmacy {
	String id;
	String tensanpham, dvt, cachdung;
	double gia;
	int soluong;

	public Pharmacy() {
	}

	public Pharmacy(String id, String tensanpham, String dvt, double gia, int soluong, String cachdung) {
		this.id = id;
		this.tensanpham = tensanpham;
		this.dvt = dvt;
		this.gia = gia;
		this.soluong = soluong;
		this.cachdung = cachdung;
	}
	public Pharmacy(String tensanpham, String dvt, double gia, int soluong, String cachdung) {
		this.tensanpham = tensanpham;
		this.dvt = dvt;
		this.gia = gia;
		this.soluong = soluong;
		this.cachdung = cachdung;
	}
	public Pharmacy(String tensanpham, double gia, int soluong, String cachdung) {
		this.tensanpham = tensanpham;
		this.gia = gia;
		this.soluong = soluong;
		this.cachdung = cachdung;
	}
	
	public Pharmacy( String dvt) {
		this.dvt = dvt;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTensanpham() {
		return tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public String getDvt() {
		return dvt;
	}

	public void setDvt(String dvt) {
		this.dvt = dvt;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getCachdung() {
		return cachdung;
	}

	public void setCachdung(String Cachdung) {
		this.cachdung = Cachdung;
	}
}


