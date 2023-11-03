package model;

import java.util.ArrayList;
import java.util.Objects;

public class LoaiXe {
	private int maLoaiXe; //mã hãng xe
	private String tenLoaiXe;
	
	public LoaiXe(int maLoaiXe, String tenLoaiXe) {
		this.tenLoaiXe = tenLoaiXe;
		this.maLoaiXe = maLoaiXe;
	}

	public String getTenLoaiXe() {
		return tenLoaiXe;
	}

	public void setTenLoaiXe(String tenLoaiXe) {
		this.tenLoaiXe = tenLoaiXe;
	}

	public int getMaLoaiXe() {
		return maLoaiXe;
	}

	public void setMaLoaiXe(int maLoaiXe) {
		this.maLoaiXe = maLoaiXe;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLoaiXe, tenLoaiXe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiXe other = (LoaiXe) obj;
		return maLoaiXe == other.maLoaiXe && Objects.equals(tenLoaiXe, other.tenLoaiXe);
	}
	
	//Hàm static để không cần tạo đối tượng vẫn gọi ra được list hãng xe;
	public static ArrayList<LoaiXe> getDSLoaiXe(){
		String[] arr_LoaiXe = {
				"Sedan",
				"SUV",
				"Van",
		};
		
		int i = 0;
		ArrayList<LoaiXe> listLoaiXe = new ArrayList<LoaiXe>();
		for (String tenLoaiXe : arr_LoaiXe) {
			LoaiXe lXe = new LoaiXe(i, tenLoaiXe);
			listLoaiXe.add(lXe);
		}
		return listLoaiXe;
	}

	public static LoaiXe getLoaiXeByID(int LoaiXeID) {
		return LoaiXe.getDSLoaiXe().get(LoaiXeID);
	}
}	

