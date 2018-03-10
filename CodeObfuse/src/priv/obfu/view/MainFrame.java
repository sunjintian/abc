package priv.obfu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.xml.stream.events.StartDocument;

import org.eclipse.ui.internal.handlers.WizardHandler.New;
import org.omg.CORBA.PUBLIC_MEMBER;

import priv.obfu.controller.StartObfuse;
import priv.obfu.model.MainFrameSource;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	private JFileChooser fileChooser;
	//原代码目录
	private File source;
	private String sourcePath = "";
	
	private MainFrameSource frameSource;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		//设置对话框标题栏
		setResizable(false);
		setTitle("CodeObfuse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 414);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//选择混淆文件
		JLabel lblNewLabel = new JLabel("选择混淆文件");
		lblNewLabel.setBounds(5, 5, 105, 18);
		getContentPane().add(lblNewLabel);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.setBounds(120, 2, 252, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		JButton button = new JButton("打开");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser.showOpenDialog(new JLabel());
				//获取选中文件目录
				source = fileChooser.getSelectedFile();
				if(source == null) return;
				if(source.isFile()){
					sourcePath = source.getAbsolutePath();
					textField.setText(sourcePath);
				}
			}
		});
		button.setBounds(434, 1, 105, 22);
		contentPane.add(button);
		
		//选择混沌映射
		JLabel label = new JLabel("选择混沌映射");
		label.setBounds(5, 52, 110, 21);
		contentPane.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(120, 53, 252, 18);
		comboBox.addItem("二维帐篷映射");
		comboBox.addItem("TDER-CS映射");
		comboBox.addItem("Arnold映射");
		comboBox.addItem("一维帐篷映射"); 
		comboBox.addItem("Henon映射");
		comboBox.addItem("Logistic映射");
		contentPane.add(comboBox);
		
		//选择二次映射
		JLabel label_1 = new JLabel("选择二次映射");
		label_1.setBounds(5, 96, 110, 21);
		contentPane.add(label_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(120, 97, 252, 18);
		comboBox_1.addItem("整值映射");
		comboBox_1.addItem("comp_1映射");
		comboBox_1.addItem("comp_2映射");
		contentPane.add(comboBox_1);
		
		//选择混淆方式
		JLabel label_2 = new JLabel("选择混淆方式");
		label_2.setBounds(5, 142, 110, 21);
		contentPane.add(label_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("数据混淆");
		chckbxNewCheckBox.setBounds(120, 139, 133, 27);
		contentPane.add(chckbxNewCheckBox);
	
		JCheckBox checkBox = new JCheckBox("不透明谓词混淆");
		checkBox.setBounds(120, 171, 133, 27);
		contentPane.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("压扁控制流混淆");
		checkBox_1.setBounds(120, 203, 133, 27);
		contentPane.add(checkBox_1);
		
		//开始混淆
		JButton button_1 = new JButton("开始混淆");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***判断混淆方式是否为空***/
				Boolean sty = false;
				frameSource = new MainFrameSource();
				if(chckbxNewCheckBox.isSelected()){
					frameSource.setDate(true);
					sty = true;
				}
				if(checkBox.isSelected()){
                	frameSource.setPredicate(true);
                	sty = true;
				}
                if(checkBox_1.isSelected()){
                	frameSource.setFlatten(true);
                	sty = true;
                }
                if(sty.equals(false)){
                	ErrorStyle errorStyle = new ErrorStyle();
                	errorStyle.setVisible(true);
                	return;
                }
                
                frameSource.setSourcePath(sourcePath);
                frameSource.setChaos(comboBox.getSelectedItem().toString());
                frameSource.setSecond(comboBox_1.getSelectedItem().toString());
                
				StartObfuse s = new StartObfuse(sourcePath);
				s.setSource();  
				s.Run(frameSource);  
				CodeCompare compare = new CodeCompare();
				//compare.asd();
				compare.setTextArea(s.getSource(),s.getObfuCode());
			}
		});
		button_1.setBounds(262, 310, 110, 27);
		contentPane.add(button_1);
		 
		//选择混淆后文件保存路径
		JLabel label_3 = new JLabel("选择混淆后文件保存路径");
		label_3.setBounds(5, 252, 173, 18);
		contentPane.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(192, 252, 252, 18);
		contentPane.add(textField_1);
		
		JButton button_2 = new JButton("打开");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser.showOpenDialog(new JLabel());
				//获取选中文件目录
				source = fileChooser.getSelectedFile();
				if(source == null) return;
				if(source.isFile()){
					sourcePath = source.getAbsolutePath();
					textField_1.setText(sourcePath);
				}
			}
		});
		button_2.setBounds(476, 248, 105, 22);
		contentPane.add(button_2);
	}
}