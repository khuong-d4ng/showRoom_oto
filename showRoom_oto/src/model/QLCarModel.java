package model;

import java.util.ArrayList;

public class QLCarModel {
	private ArrayList<Car> dsCar;
	private String luaChon;
	
	public QLCarModel() {
		this.dsCar = new ArrayList<Car>();
		this.luaChon = "";
	}

	public ArrayList<Car> getDsCar() {
		return dsCar;
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public QLCarModel(ArrayList<Car> dsCar) {
		this.dsCar = dsCar;
	}
	
	public void setDsCar(ArrayList<Car> dsCar) {
		this.dsCar = dsCar;
	}
	
	public void addCar(Car car) {
		this.dsCar.add(car);
	}
	
	public void deleteCar(Car car) {
		this.dsCar.remove(car);
	}
}
	