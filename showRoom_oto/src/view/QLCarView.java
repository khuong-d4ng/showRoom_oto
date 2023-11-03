package view;

import javax.swing.*;

import model.Car;
import model.HangXe;
import model.LoaiXe;
import model.QLCarModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import controller.QLCarController;

import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;

public class QLCarView {

	//Chuyển hết thành public để có thể thao tác bằng controller. có thể khắc phục
	//bằng việc đưa action qua đây nhưng để tiết kiệm thời gian nên sẽ chuyển thành public
    private JFrame frame;
    public QLCarModel model;
    private JPanel panel;  // Declare panel as a class field
    private CardLayout cardLayout;
    public JTextField textField_tenXe;
    public JTable table_quanLiXe;
    public JTextField textField_tenXe_Filter;
    public JTextField textField_giaXe;
    public JTextField textField_maLuc;
    public JTextField textField_colorXe;
    public JTextField textField_tenXe_cuaHang;
    public JTextField textField_cuaHang;
    public JTextField textField_giaTien_cuaHang;
    public JTextField textField_maLuc_cuaHang;
    public JTextField textField_colorXe_cuaHang;
    public JTable table_cuaHang;
    public JComboBox<String> comboBox_hangXe = new JComboBox<String>();
    public JComboBox<String> comboBox_loaiXe = new JComboBox<String>();
    public JComboBox<String> comboBox_hangXe_Filter = new JComboBox<String>();
    public JComboBox<String> comboBox_loaiXe_Filter = new JComboBox<String>();
    public JComboBox<String> comboBox_hangXe_Filter_cuaHang = new JComboBox<String>();
    public JComboBox<String> comboBox_loaiXe_Filter_cuaHang = new JComboBox<String>();
    public JComboBox<String> comboBox_loaiXe_cuaHang = new JComboBox<String>();
    public JComboBox<String> comboBox_hangXe_cuaHang = new JComboBox<String>();
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QLCarView window = new QLCarView();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public QLCarView() {
    	initialize();
    
    }

    private void initialize() {
    	Action action = new QLCarController(this);
    	//Khai báo listHangXe (list hãng xe) để tất cả các combobox ở dưới dùng dần, đỡ phải khai báo từng cái 1
    	ArrayList<HangXe> listHangXe = HangXe.getDSHangXe();
    	ArrayList<LoaiXe> listLoaiXe = LoaiXe.getDSLoaiXe();
    	
        frame = new JFrame();
        frame.setBounds(100, 100, 1175, 752);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btn_quanLiXe = new JButton("Quản lí xe");
        btn_quanLiXe.setBounds(975, 203, 176, 49);
        frame.getContentPane().add(btn_quanLiXe);
        
        JButton btn_cuaHang = new JButton("Cửa hàng");
        btn_cuaHang.setBounds(975, 263, 176, 49);
        frame.getContentPane().add(btn_cuaHang);
        
        panel = new JPanel();  // Initialize panel
        panel.setBounds(10, 10, 955, 703);
        frame.getContentPane().add(panel);
        cardLayout = new CardLayout();
        panel.setLayout(cardLayout);
        
        JPanel panel_QuanLiXe = new JPanel();
        panel_QuanLiXe.setBackground(new Color(192, 192, 192));
        panel.add(panel_QuanLiXe, "name_135914605263900");
        
        JPanel panel_CuaHang = new JPanel();
        panel_CuaHang.setBackground(Color.LIGHT_GRAY);
        panel.add(panel_CuaHang, "name_135986760485800");
        
	        panel_QuanLiXe.setEnabled(false);
	        panel_QuanLiXe.setLayout(null);
	        
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(31, 205, 894, 231);
	        panel_QuanLiXe.add(scrollPane);
	        
	        table_quanLiXe = new JTable();
	        table_quanLiXe.setModel(new DefaultTableModel(
	        	new Object[][] {
	        		{"STT", "H\u00E3ng xe", "T\u00EAn xe", "Lo\u1EA1i xe", "M\u00E0u xe", "Gi\u00E1 (VND)", "CC/HP"},
	        	},
	        	new String[] {
	        		"", "", "", "", "", "", ""
	        	}
	        ));
	        table_quanLiXe.getColumnModel().getColumn(0).setPreferredWidth(60);
	        table_quanLiXe.getColumnModel().getColumn(0).setMaxWidth(60);
	        table_quanLiXe.getColumnModel().getColumn(1).setPreferredWidth(100);
	        table_quanLiXe.getColumnModel().getColumn(1).setMinWidth(100);
	        table_quanLiXe.getColumnModel().getColumn(1).setMaxWidth(120);
	        table_quanLiXe.getColumnModel().getColumn(2).setPreferredWidth(140);
	        table_quanLiXe.getColumnModel().getColumn(2).setMinWidth(140);
	        table_quanLiXe.getColumnModel().getColumn(2).setMaxWidth(250);
	        table_quanLiXe.getColumnModel().getColumn(3).setPreferredWidth(80);
	        table_quanLiXe.getColumnModel().getColumn(3).setMaxWidth(120);
	        table_quanLiXe.getColumnModel().getColumn(4).setPreferredWidth(80);
	        table_quanLiXe.getColumnModel().getColumn(4).setMinWidth(80);
	        table_quanLiXe.getColumnModel().getColumn(4).setMaxWidth(80);
	        table_quanLiXe.getColumnModel().getColumn(5).setPreferredWidth(140);
	        table_quanLiXe.getColumnModel().getColumn(5).setMinWidth(130);
	        table_quanLiXe.getColumnModel().getColumn(5).setMaxWidth(200);
	        table_quanLiXe.getColumnModel().getColumn(6).setMaxWidth(80);
	        scrollPane.setColumnHeaderView(table_quanLiXe);
	        
	        JPanel panel_table_container = new JPanel();
	        panel_table_container.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	        panel_table_container.setBounds(10, 158, 935, 294);
	        panel_QuanLiXe.add(panel_table_container);
	        
	        JPanel panel_addCar_container = new JPanel();
	        panel_addCar_container.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	        panel_addCar_container.setBounds(10, 462, 935, 231);
	        panel_QuanLiXe.add(panel_addCar_container);
	        panel_addCar_container.setLayout(null);
	        
	        JLabel lbl_tenXe = new JLabel("Tên xe:");
	        lbl_tenXe.setBounds(288, 38, 78, 34);
	        panel_addCar_container.add(lbl_tenXe);
	        lbl_tenXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        
	        textField_tenXe = new JTextField();
	        textField_tenXe.setBounds(352, 38, 174, 34);
	        panel_addCar_container.add(textField_tenXe);
	        textField_tenXe.setColumns(10);
	        
	        JLabel lbl_giaXe = new JLabel("Giá tiền:");
	        lbl_giaXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lbl_giaXe.setBounds(288, 104, 78, 34);
	        panel_addCar_container.add(lbl_giaXe);
	        
	        textField_giaXe = new JTextField();
	        textField_giaXe.setColumns(10);
	        textField_giaXe.setBounds(352, 107, 174, 34);
	        panel_addCar_container.add(textField_giaXe);
	        
	        JLabel lbl_hangXe = new JLabel("Hãng xe:");
	        lbl_hangXe.setBounds(46, 38, 78, 34);
	        panel_addCar_container.add(lbl_hangXe);
	        lbl_hangXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        
	        JLabel lbl_maLuc = new JLabel("Mã lực");
	        lbl_maLuc.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lbl_maLuc.setBounds(560, 38, 78, 34);
	        panel_addCar_container.add(lbl_maLuc);
	        
	        textField_maLuc = new JTextField();
	        textField_maLuc.setColumns(10);
	        textField_maLuc.setBounds(621, 38, 88, 34);
	        panel_addCar_container.add(textField_maLuc);
	        
	        JLabel lbl_loaiXe = new JLabel("Loại xe");
	        lbl_loaiXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lbl_loaiXe.setBounds(46, 108, 78, 34);
	        panel_addCar_container.add(lbl_loaiXe);
	        
	        for (LoaiXe loaiXe : listLoaiXe) {
				comboBox_loaiXe.addItem(loaiXe.getTenLoaiXe());
			}
	        comboBox_loaiXe.setBounds(114, 107, 144, 34);
	        panel_addCar_container.add(comboBox_loaiXe);
	       
	        textField_colorXe = new JTextField();
	        textField_colorXe.setColumns(10);
	        textField_colorXe.setBounds(797, 38, 115, 34);
	        panel_addCar_container.add(textField_colorXe);
	        
	        JLabel lbl_colorXe = new JLabel("Màu xe");
	        lbl_colorXe.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lbl_colorXe.setBounds(736, 38, 78, 34);
	        panel_addCar_container.add(lbl_colorXe);
	        
	        JButton btn_addXe = new JButton("Thêm xe");
	        //actionbtn_addXe.addActionListener(new ActionListener() {
            
	        btn_addXe.addActionListener(action);
	        btn_addXe.setBounds(69, 187, 123, 34);
	        panel_addCar_container.add(btn_addXe);
	        
	        JButton btn_xoaXe = new JButton("Xóa xe");
	        
	        //action
	        btn_xoaXe.addActionListener(action);
	        btn_xoaXe.setBounds(231, 187, 123, 34);
	        panel_addCar_container.add(btn_xoaXe);
	        
	        JButton btn_editXe = new JButton("Edit");
	        
	        //action
	        btn_editXe.addActionListener(action);
	        btn_editXe.setBounds(403, 187, 123, 34);
	        panel_addCar_container.add(btn_editXe);
	        
	        JButton btn_huyBo = new JButton("Hủy bỏ");
	      
	        //action
	        btn_huyBo.addActionListener(action);
	        btn_huyBo.setBounds(736, 187, 123, 34);
	        panel_addCar_container.add(btn_huyBo);
	        
	        
	        //ArrayList<HangXe> listHangXe = HangXe.getDSHangXe();
	        //lấy từ cái list khai báo ở trên đầu ra
	        for (HangXe hangXe : listHangXe) {
				comboBox_hangXe.addItem(hangXe.getTenHangXe());
			}
	        comboBox_hangXe.setBounds(114, 38, 144, 34);
	        panel_addCar_container.add(comboBox_hangXe);
	        
	        JButton btn_luuXe = new JButton("Lưu");
	      //action
	        btn_luuXe.addActionListener(action);
	        btn_luuXe.setBounds(570, 187, 123, 34);
	        panel_addCar_container.add(btn_luuXe);
	        
	        
	        
	        JPanel panel_filter_container = new JPanel();
	        panel_filter_container.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	        panel_filter_container.setBounds(10, 75, 935, 73);
	        panel_QuanLiXe.add(panel_filter_container);
	        panel_filter_container.setLayout(null);
	        
	        JLabel lbl_hangXe_Filter = new JLabel("Hãng xe:");
	        lbl_hangXe_Filter.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lbl_hangXe_Filter.setBounds(107, 20, 78, 34);
	        panel_filter_container.add(lbl_hangXe_Filter);
	        
	        
	        comboBox_hangXe_Filter.setBounds(169, 22, 144, 34);
	        panel_filter_container.add(comboBox_hangXe_Filter);
	      //ArrayList<HangXe> listHangXe = HangXe.getDSHangXe();
	        //lấy từ cái list khai báo ở trên đầu ra
	        for (HangXe hangXe : listHangXe) {
				comboBox_hangXe_Filter.addItem(hangXe.getTenHangXe());
			}
	        
	        JLabel lbl_tenXe_Filter = new JLabel("Tên xe:");
	        lbl_tenXe_Filter.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lbl_tenXe_Filter.setBounds(347, 22, 78, 34);
	        panel_filter_container.add(lbl_tenXe_Filter);
	        
	        textField_tenXe_Filter = new JTextField();
	        textField_tenXe_Filter.setColumns(10);
	        textField_tenXe_Filter.setBounds(408, 22, 174, 34);
	        panel_filter_container.add(textField_tenXe_Filter);
	        
	        JLabel lbl_filterHeader = new JLabel("FILTER");
	        lbl_filterHeader.setBounds(10, 10, 78, 51);
	        panel_filter_container.add(lbl_filterHeader);
	        lbl_filterHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        
	        JLabel lbl_loaiXe_Filter = new JLabel("Loại xe");
	        lbl_loaiXe_Filter.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lbl_loaiXe_Filter.setBounds(614, 19, 78, 34);
	        panel_filter_container.add(lbl_loaiXe_Filter);
	        
	        for (LoaiXe loaiXe : listLoaiXe) {
				comboBox_loaiXe_Filter.addItem(loaiXe.getTenLoaiXe());
			}
	        comboBox_loaiXe_Filter.setBounds(682, 18, 144, 34);
	        panel_filter_container.add(comboBox_loaiXe_Filter);
	        
	        JLabel lbl_headerQuanLiXe = new JLabel("Quản Lí Xe\r\n");
	        lbl_headerQuanLiXe.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        lbl_headerQuanLiXe.setHorizontalAlignment(SwingConstants.CENTER);
	        lbl_headerQuanLiXe.setBounds(212, 10, 516, 34);	
	        panel_QuanLiXe.add(lbl_headerQuanLiXe);
	        panel_CuaHang.setEnabled(false);
	        panel_CuaHang.setLayout(null);
	        
	        JScrollPane scrollPane_1 = new JScrollPane();
	        scrollPane_1.setBounds(31, 205, 894, 231);
	        panel_CuaHang.add(scrollPane_1);
	        
	        table_cuaHang = new JTable();
	        table_cuaHang.setModel(new DefaultTableModel(
		        	new Object[][] {
		        		{"STT", "H\u00E3ng xe", "T\u00EAn xe", "Lo\u1EA1i xe", "M\u00E0u xe", "Gi\u00E1 (VND)", "CC/HP"},
		        	},
		        	new String[] {
		        		"", "", "", "", "", "", ""
		        	}
		        ));
		        table_cuaHang.getColumnModel().getColumn(0).setPreferredWidth(60);
		        table_cuaHang.getColumnModel().getColumn(0).setMaxWidth(60);
		        table_cuaHang.getColumnModel().getColumn(1).setPreferredWidth(100);
		        table_cuaHang.getColumnModel().getColumn(1).setMinWidth(100);
		        table_cuaHang.getColumnModel().getColumn(1).setMaxWidth(120);
		        table_cuaHang.getColumnModel().getColumn(2).setPreferredWidth(140);
		        table_cuaHang.getColumnModel().getColumn(2).setMinWidth(140);
		        table_cuaHang.getColumnModel().getColumn(2).setMaxWidth(250);
		        table_cuaHang.getColumnModel().getColumn(3).setPreferredWidth(80);
		        table_cuaHang.getColumnModel().getColumn(3).setMaxWidth(120);
		        table_cuaHang.getColumnModel().getColumn(4).setPreferredWidth(80);
		        table_cuaHang.getColumnModel().getColumn(4).setMinWidth(80);
		        table_cuaHang.getColumnModel().getColumn(4).setMaxWidth(80);
		        table_cuaHang.getColumnModel().getColumn(5).setPreferredWidth(140);
		        table_cuaHang.getColumnModel().getColumn(5).setMinWidth(130);
		        table_cuaHang.getColumnModel().getColumn(5).setMaxWidth(200);
		        table_cuaHang.getColumnModel().getColumn(6).setMaxWidth(80);
	        scrollPane_1.setColumnHeaderView(table_cuaHang);
	        
	        JPanel panel_filter_container_1 = new JPanel();
	        panel_filter_container_1.setLayout(null);
	        panel_filter_container_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	        panel_filter_container_1.setBounds(10, 75, 935, 73);
	        panel_CuaHang.add(panel_filter_container_1);
	        
	        JLabel lbl_hangXe_Filter_cuaHang = new JLabel("Hãng xe:");
	        lbl_hangXe_Filter_cuaHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lbl_hangXe_Filter_cuaHang.setBounds(107, 20, 78, 34);
	        panel_filter_container_1.add(lbl_hangXe_Filter_cuaHang);
	        
	        
	        //ArrayList<HangXe> listHangXe = HangXe.getDSHangXe();
	        //lấy từ cái list khai báo ở trên đầu ra
	        for (HangXe hangXe : listHangXe) {
				comboBox_hangXe_Filter_cuaHang.addItem(hangXe.getTenHangXe());
			}
	        comboBox_hangXe_Filter_cuaHang.setBounds(169, 22, 144, 34);
	        panel_filter_container_1.add(comboBox_hangXe_Filter_cuaHang);
	        
	        JLabel lbl_tenXe_Filter_cuaHang = new JLabel("Tên xe:");
	        lbl_tenXe_Filter_cuaHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lbl_tenXe_Filter_cuaHang.setBounds(347, 22, 78, 34);
	        panel_filter_container_1.add(lbl_tenXe_Filter_cuaHang);
	        
	        textField_tenXe_cuaHang = new JTextField();
	        textField_tenXe_cuaHang.setColumns(10);
	        textField_tenXe_cuaHang.setBounds(408, 22, 174, 34);
	        panel_filter_container_1.add(textField_tenXe_cuaHang);
	        
	        JLabel lbl_filterHeader_cuaHang = new JLabel("FILTER");
	        lbl_filterHeader_cuaHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lbl_filterHeader_cuaHang.setBounds(10, 10, 78, 51);
	        panel_filter_container_1.add(lbl_filterHeader_cuaHang);
	        
	        JLabel lbl_loaiXe_Filter_cuaHang = new JLabel("Loại xe");
	        lbl_loaiXe_Filter_cuaHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lbl_loaiXe_Filter_cuaHang.setBounds(614, 19, 78, 34);
	        panel_filter_container_1.add(lbl_loaiXe_Filter_cuaHang);
	        
	        
	        comboBox_loaiXe_Filter_cuaHang.setBounds(682, 18, 144, 34);
	        panel_filter_container_1.add(comboBox_loaiXe_Filter_cuaHang);
	        
	        JPanel panel_addCar_container_1 = new JPanel();
	        panel_addCar_container_1.setLayout(null);
	        panel_addCar_container_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	        panel_addCar_container_1.setBounds(10, 462, 935, 231);
	        panel_CuaHang.add(panel_addCar_container_1);
	        
	        JLabel lbl_tenXe_cuaHang = new JLabel("Tên xe:");
	        lbl_tenXe_cuaHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lbl_tenXe_cuaHang.setBounds(288, 38, 78, 34);
	        panel_addCar_container_1.add(lbl_tenXe_cuaHang);
	        
	        textField_cuaHang = new JTextField();
	        textField_cuaHang.setColumns(10);
	        textField_cuaHang.setBounds(352, 38, 174, 34);
	        panel_addCar_container_1.add(textField_cuaHang);
	        
	        JLabel lbl_giaXe_cuaHang = new JLabel("Giá tiền:");
	        lbl_giaXe_cuaHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lbl_giaXe_cuaHang.setBounds(288, 104, 78, 34);
	        panel_addCar_container_1.add(lbl_giaXe_cuaHang);
	        
	        textField_giaTien_cuaHang = new JTextField();
	        textField_giaTien_cuaHang.setColumns(10);
	        textField_giaTien_cuaHang.setBounds(352, 107, 174, 34);
	        panel_addCar_container_1.add(textField_giaTien_cuaHang);
	        
	        JLabel lbl_hangXe_cuaHang = new JLabel("Hãng xe:");
	        lbl_hangXe_cuaHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lbl_hangXe_cuaHang.setBounds(46, 38, 78, 34);
	        panel_addCar_container_1.add(lbl_hangXe_cuaHang);
	        
	        JLabel lbl_maLuc_1 = new JLabel("Mã lực");
	        lbl_maLuc_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lbl_maLuc_1.setBounds(560, 38, 78, 34);
	        panel_addCar_container_1.add(lbl_maLuc_1);
	        
	        textField_maLuc_cuaHang = new JTextField();
	        textField_maLuc_cuaHang.setColumns(10);
	        textField_maLuc_cuaHang.setBounds(621, 38, 88, 34);
	        panel_addCar_container_1.add(textField_maLuc_cuaHang);
	        
	        Checkbox checkbox_xeOto_cuaHang = new Checkbox("Ô tô");
	        checkbox_xeOto_cuaHang.setBounds(643, 104, 72, 34);
	        panel_addCar_container_1.add(checkbox_xeOto_cuaHang);
	        
	        Checkbox checkbox_xeMay_cuaHang = new Checkbox("Xe máy");
	        checkbox_xeMay_cuaHang.setBounds(766, 104, 64, 34);
	        panel_addCar_container_1.add(checkbox_xeMay_cuaHang);
	        
	        JLabel lbl_loaiXe_cuaHang = new JLabel("Loại xe");
	        lbl_loaiXe_cuaHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lbl_loaiXe_cuaHang.setBounds(46, 108, 78, 34);
	        panel_addCar_container_1.add(lbl_loaiXe_cuaHang);
	       
	        comboBox_loaiXe_cuaHang.setBounds(114, 107, 144, 34);
	        panel_addCar_container_1.add(comboBox_loaiXe_cuaHang);
	        
	        textField_colorXe_cuaHang = new JTextField();
	        textField_colorXe_cuaHang.setColumns(10);
	        textField_colorXe_cuaHang.setBounds(797, 38, 115, 34);
	        panel_addCar_container_1.add(textField_colorXe_cuaHang);
	        
	        JLabel lbl_colorXe_cuaHang = new JLabel("Màu xe");
	        lbl_colorXe_cuaHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lbl_colorXe_cuaHang.setBounds(736, 38, 78, 34);
	        panel_addCar_container_1.add(lbl_colorXe_cuaHang);
	        
	        JButton btn_muaXe = new JButton("Mua Xe");
	        btn_muaXe.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	}
	        });
	        btn_muaXe.setBounds(306, 187, 123, 34);
	        panel_addCar_container_1.add(btn_muaXe);
	        
	        JButton btn_huyBo_1 = new JButton("Hủy bỏ");
	        btn_huyBo_1.setBounds(439, 187, 123, 34);
	        panel_addCar_container_1.add(btn_huyBo_1);
	        
	        
	        comboBox_hangXe_cuaHang.setBounds(114, 38, 144, 34);
	        panel_addCar_container_1.add(comboBox_hangXe_cuaHang);
	        
	        JLabel lbl_headerCuaHang = new JLabel("Cửa Hàng Xe");
	        lbl_headerCuaHang.setHorizontalAlignment(SwingConstants.CENTER);
	        lbl_headerCuaHang.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        lbl_headerCuaHang.setBounds(212, 10, 516, 34);
	        panel_CuaHang.add(lbl_headerCuaHang);
	        
	        JPanel panel_table_container_1 = new JPanel();
	        panel_table_container_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	        panel_table_container_1.setBounds(10, 158, 935, 294);
	        panel_CuaHang.add(panel_table_container_1);

        btn_quanLiXe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "name_135914605263900");
            }
        });

        btn_cuaHang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "name_135986760485800");
            }
        });
    }

    //Hàm xóa form khi bấm nút
	public void xoaForm() {
		
		textField_colorXe.setText("");
		textField_colorXe_cuaHang.setText("");
		textField_cuaHang.setText("");
		textField_giaTien_cuaHang.setText("");
		textField_giaXe.setText("");
		textField_maLuc.setText("");
		textField_maLuc_cuaHang.setText("");
		textField_tenXe.setText("");
		textField_tenXe_cuaHang.setText("");
		textField_tenXe_Filter.setText("");
		comboBox_hangXe.setSelectedIndex(-1);
		comboBox_hangXe_cuaHang.setSelectedIndex(-1);
		comboBox_hangXe_Filter.setSelectedIndex(-1);
		comboBox_hangXe_Filter_cuaHang.setSelectedIndex(-1);
		comboBox_loaiXe.setSelectedIndex(-1);
		comboBox_loaiXe_cuaHang.setSelectedIndex(-1);
		comboBox_loaiXe_Filter.setSelectedIndex(-1);
		comboBox_loaiXe_Filter_cuaHang.setSelectedIndex(-1);
	}

	public void themCar(Car carTemp) {
		this.model.addCar(carTemp);
		DefaultTableModel model = (DefaultTableModel) table_quanLiXe.getModel();
		model.addRow(
				new Object[] {
						"1", carTemp.getHangXe()+"", carTemp.getTenXe()+"", 
						carTemp.getLoaiXe()+"", carTemp.getMauXe()+"", 
						carTemp.getGiaXe()+"", carTemp.getMaLuc()+"",
				}
		);
	}

	public void editCar(Car carTemp) {
		// TODO Auto-generated method stub
		
	}
}
