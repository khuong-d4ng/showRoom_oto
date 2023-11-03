package model;

import java.util.ArrayList;
import java.util.Objects;

public class HangXe {
	private int maHangXe; //mã hãng xe
	private String tenHangXe;
	
	public HangXe(int maHangXe, String tenHangXe) {
		this.tenHangXe = tenHangXe;
		this.maHangXe = maHangXe;
	}

	public String getTenHangXe() {
		return tenHangXe;
	}

	public void setTenHangXe(String tenHangXe) {
		this.tenHangXe = tenHangXe;
	}

	public int getMaHangXe() {
		return maHangXe;
	}

	public void setMaHangXe(int maHangXe) {
		this.maHangXe = maHangXe;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHangXe, tenHangXe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HangXe other = (HangXe) obj;
		return maHangXe == other.maHangXe && Objects.equals(tenHangXe, other.tenHangXe);
	}
	
	//Hàm static để không cần tạo đối tượng vẫn gọi ra được list hãng xe;
	public static ArrayList<HangXe> getDSHangXe(){
		String[] arr_hangXe = {
				"Mercedes",
				"Audi",
				"BMW",
		};
		
		int i = 0;
		ArrayList<HangXe> listHangXe = new ArrayList<HangXe>();
		for (String tenHangXe : arr_hangXe) {
			HangXe hXe = new HangXe(i, tenHangXe);
			listHangXe.add(hXe);
		}
		return listHangXe;
	}

	public static HangXe getHangXeByID(int hangXe) {
		return HangXe.getDSHangXe().get(hangXe);
	}
}	
