package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp extends JFrame {
    private JButton startButton;
    private JButton exitButton;
    private JPanel mainPanel;

    public MainApp() {
        // Khởi tạo cửa sổ
        super("Ứng dụng Java Swing");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo nút "Khởi động"
        startButton = new JButton("Khởi động");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý khi nút "Khởi động" được nhấn
                showMainPanel();
            }
        });

        // Tạo nút "Thoát"
        exitButton = new JButton("Thoát");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Xử lý khi nút "Thoát" được nhấn
                System.exit(0);
            }
        });

        // Tạo panel chứa các nút
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);

        // Tạo panel chính (ban đầu ẩn đi)
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JLabel("Đây là phần chính của ứng dụng"), BorderLayout.CENTER);

        // Thêm panel chứa các nút và panel chính vào cửa sổ
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        mainPanel.setVisible(false);
    }

    private void showMainPanel() {
        startButton.setVisible(false);
        exitButton.setVisible(false);
        mainPanel.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainApp app = new MainApp();
                app.setVisible(true);
            }
        });
    }
}
