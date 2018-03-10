package priv.obfu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CodeCompare extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private CodeCompare frame;
	/**
	 * Launch the application.
	 */
	/*public void asd() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    frame = new CodeCompare();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public void setTextArea(String context,String ObfuCode){
		textArea = new JTextArea(context);
		scrollPane.setViewportView(textArea);
		contentPane.add(scrollPane);
		
		textArea_1 = new JTextArea(ObfuCode);
		scrollPane_1.setViewportView(textArea_1);
		contentPane.add(scrollPane_1);
		this.setVisible(true);
	}
	/**
	 * Create the frame.
	 */
	public CodeCompare() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1341, 769);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("混淆完毕，编译通过！");
		lblNewLabel.setBounds(5, 5, 165, 18);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("混淆前：");
		label.setBounds(5, 36, 72, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("混淆后：");
		label_1.setBounds(650, 36, 72, 18);
		contentPane.add(label_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 67, 636, 642);
		contentPane.add(scrollPane);
		
		/*
		textArea = new JTextArea(
	            "import java.lang.String;\n" +
	            "\n" +
	            "public class Strings {\n" +
	            "    public static String text = \"This is from public static String.\";\n" +
	            "    private static String text2 =\"This is from private static String.\";\n" +
	            "\n" +
	            "    public static void main(String[] args) {\n" +
	            "        String text3 = \"This is from main function.\";\n" +
	            "        System.out.println(text);\n" +
	            "        System.out.println(text2);\n" +
	            "        System.out.println(text3);\n" +
	            "        System.out.println(\"This is from sout.\");\n" +
	            "    }\n" +
	            "\n" +
	            "}\n");
		scrollPane.setViewportView(textArea);
		*/
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(650, 67, 659, 642);
		contentPane.add(scrollPane_1);
		/*
		JTextArea textArea_1 = new JTextArea(
	            "import java.lang.String;\n" +
	            "\n" +
	            "public class Strings {\n" +
	            "    public static String text = \"This is from public static String.\";\n" +
	            "    private static String text2 =\"This is from private static String.\";\n" +
	            "\n" +
	            "    public static void main(String[] args) {\n" +
	            "        String text3 = \"This is from main function.\";\n" +
	            "        System.out.println(text);\n" +
	            "        System.out.println(text2);\n" +
	            "        System.out.println(text3);\n" +
	            "        System.out.println(\"This is from sout.\");\n" +
	            "    }\n" +
	            "\n" +
	            "}\n");
		scrollPane_1.setColumnHeaderView(textArea_1);*/
	}
}
