package model;

import java.util.ArrayList;

public class Car {
	private String tenXe, mauXe;
	private HangXe hangXe;
	private double giaXe;
	private float dungTich, maLuc; 
	private LoaiXe loaiXe;
	
	public Car() {
		//
	}
	
	public Car(String tenXe, String mauXe, HangXe hangXe, LoaiXe loaiXe, double giaXe, float dungTich, float maLuc) {
		this.tenXe = tenXe;
		this.mauXe = mauXe;
		this.hangXe = hangXe;
		this.loaiXe = loaiXe;
		this.giaXe = giaXe;
		this.dungTich = dungTich;
		this.maLuc = maLuc;
	}


	public String getTenXe() {
		return tenXe;
	}

	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}


	public double getGiaXe() {
		return giaXe;
	}

	public void setGiaXe(int giaXe) {
		this.giaXe = giaXe;
	}

	public float getDungTich() {
		return dungTich;
	}

	public void setDungTich(float dungTich) {
		this.dungTich = dungTich;
	}

	public float getMaLuc() {
		return maLuc;
	}

	public void setMaLuc(float maLuc) {
		this.maLuc = maLuc;
	}

	public String getMauXe() {
		return mauXe;
	}

	public void setMauXe(String mauXe) {
		this.mauXe = mauXe;
	}

	public HangXe getHangXe() {
		return hangXe;
	}

	public void setHangXe(HangXe hangXe) {
		this.hangXe = hangXe;
	}

	public void setGiaXe(double giaXe) {
		this.giaXe = giaXe;
	}

	public LoaiXe getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(LoaiXe loaiXe) {
		this.loaiXe = loaiXe;
	}

	
	
	
}	
