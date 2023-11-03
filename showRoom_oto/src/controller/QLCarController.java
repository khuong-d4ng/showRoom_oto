package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Car;
import model.HangXe;
import model.LoaiXe;
import view.QLCarView;

public class QLCarController implements Action {

	public QLCarView view;
	
	
	public QLCarController(QLCarView view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		JFrame frame = new JFrame("");
		JOptionPane.showMessageDialog(frame, "bạn vừa nhấn " + actionCommand);
		if(actionCommand.equals("Thêm xe")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Thêm xe");
		}
		if(actionCommand.equals("Lưu")) {
			//------Lấy data từ GUI về----------
			try {
				String tenXe = this.view.textField_tenXe.getText();
				String mauXe = this.view.textField_colorXe.getText();
				int hangXeTemp = this.view.comboBox_hangXe.getSelectedIndex();
				HangXe hangXe = HangXe.getHangXeByID(hangXeTemp);
				int loaiXeTemp = this.view.comboBox_loaiXe.getSelectedIndex();
				LoaiXe loaiXe = LoaiXe.getLoaiXeByID(loaiXeTemp);
				double giaXe = Double.valueOf(this.view.textField_giaXe.getText());
				float maLuc = Float.valueOf(this.view.textField_maLuc.getText());
				//-----------------------------------
				
				//lưu các dữ liệu vừa lấy được vào carTemp
				Car carTemp = new Car(tenXe, mauXe, hangXe, loaiXe, giaXe, 0, maLuc);
				
				
				
				if(this.view.model.getLuaChon().equals("") || this.view.model.getLuaChon().equals("Thêm xe")) {
					this.view.themCar(carTemp);
				}else if(this.view.model.getLuaChon().equals("Edit")) {
					this.view.editCar(carTemp);
				}
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

}
