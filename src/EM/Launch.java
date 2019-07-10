package EM;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.DropMode;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import org.openqa.selenium.NoAlertPresentException;

//import com.sun.xml.internal.ws.api.Component;

//public class newLaunch extends newversion{
	
	public class Launch extends MainScript{

	public JFrame frmEmAutomation;
	public JTextField textField;
	public JTextField textField_1;
	public JTable table_1;
	public int i;
	public Component comp;
	
	/**
	 * Launch the application.
	 */
public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Launch window = new Launch();
					window.frmEmAutomation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws BiffException 
	 */
	public Launch() throws BiffException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() throws BiffException {
		frmEmAutomation = new JFrame();
		frmEmAutomation.setTitle("EM Automation");
		frmEmAutomation.setBounds(0, 0, 1150, 600);
		frmEmAutomation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmAutomation.getContentPane().setLayout(null);
		DefaultTableModel model;
		model=new DefaultTableModel();
		final JTable table_1 = new JTable(model);
		model.addColumn("TestScenarioRow");
		model.addColumn("TestScenario");
		model.addColumn("Status");
		table_1.getColumnModel().getColumn(0).setPreferredWidth(15);
		table_1.getColumnModel().getColumn(0).setMaxWidth(200);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(15);
		table_1.getColumnModel().getColumn(1).setMaxWidth(200);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(15);
		table_1.getColumnModel().getColumn(2).setMaxWidth(100);
		table_1.setFont(new Font("Miriam Fixed",Font.PLAIN,15));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(38, 48, 1300, 580);
		frmEmAutomation.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Execution", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(61, 40, 518, 421);
		panel_1.add(panel_2);
		
		final JComboBox comboBox = new JComboBox();
	
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Enhancement Setup-ON", "Enhancement Setup-OFF", "RegPack-1", "RegPack-2","CIS","Selenium Execution","CRF"}));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select","CIS","Selenium Execution","CRF","Build Acceptance Testing","12.10.1"}));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
		comboBox.setBounds(287, 40, 180, 30);
		panel_2.add(comboBox);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
			}
		});
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select","WebLogic-EM11XSUT"}));
		comboBox_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		comboBox_1.setBounds(287, 112, 180, 30);
		panel_2.add(comboBox_1);
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
			}
		});
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		
		textField.setSelectionColor(Color.WHITE);
		textField.setSelectedTextColor(Color.WHITE);
		textField.setColumns(2);
		textField.setBounds(287, 188, 91, 30);
		panel_2.add(textField);


		textField_1 = new JTextField();		
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(287, 274, 91, 30);
		panel_2.add(textField_1);
		

		
		JLabel label_1 = new JLabel("Regression Pack");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_1.setBounds(10, 40, 121, 30);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Site_Name");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_2.setBounds(10, 112, 74, 30);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Test Scenario Start Row");
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_3.setBounds(10, 188, 188, 30);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Test Scenario End Row");
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_4.setBounds(10, 274, 188, 30);
		panel_2.add(label_4);
		
		JLabel lblResponsibility = new JLabel("Responsibility");
		lblResponsibility.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblResponsibility.setBounds(10, 348, 121, 30);
		panel_2.add(lblResponsibility);
		
		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			}
		});
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Select", "Master Patient Index", "Medical Records", "Inpatient Management", "Outpatient Management", "Clinician Access", "Pharmacy Management", "Appointment Scheduling", "Materials Base","Accident and Emergency","Patient File Tracking","Operating Theatre","Inventory Management","Order Entry and Result Reporting","Dietary Services","System Manager","CIS TRANSACTION","Duplicate Registration Check","Application master"}));
		comboBox_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		comboBox_2.setBounds(287, 348, 180, 30);
		panel_2.add(comboBox_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBounds(710, 159, 372, 112);
		panel_1.add(panel_3);
		
		JButton button = new JButton("Execute");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					launch(comboBox,comboBox_1,comboBox_2,textField,textField_1,comp,table_1);
				} catch (NoAlertPresentException | BiffException
						| WriteException | IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		
		});
		button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button.setBounds(32, 31, 106, 40);
		panel_3.add(button);
		
		/*JButton button_1 = new JButton("Exit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmEmAutomation.dispose();
				
				}
		});
		button_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button_1.setBounds(226, 31, 106, 40);
		panel_3.add(button_1);*/
		
		/*JPanel panel = new JPanel();
		tabbedPane.addTab("Results", null, panel, null);
		panel.setLayout(null);*/
		
		table_1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
		{
	@Override
	public Component getTableCellRendererComponent(JTable table_1,Object value,boolean isselected,boolean hasFocus,int row,int col)
	{
	comp=super.getTableCellRendererComponent(table_1, value, isselected, hasFocus, row, col);
	
		/*String status=(String)table_1.getModel().getValueAt(row, 2);
		if("Pass".equalsIgnoreCase(status))
		{
			comp.setBackground(Color.GREEN);
		}
		else
		{
			comp.setBackground(Color.RED);
		}*/
		//Frameresultprint(table_1,comp);
	
	return(comp);
	}	
	
	
	});
		JScrollPane sc1;
		sc1=new JScrollPane(table_1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
		sc1.setBounds(0,0,1135,562);
	try{
		//excel(model);
	}
	catch(Exception e){
	}
	/*panel.add(sc1);*/
		
		JLabel lblEmRegressionPacks = new JLabel("EM Regression Packs Execution");
		lblEmRegressionPacks.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblEmRegressionPacks.setBounds(311, 11, 558, 53);
		frmEmAutomation.getContentPane().add(lblEmRegressionPacks);
		
}
	

	public void textfieldevent(final JTextField textField)
	{
		textField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				try{
					String text=textField.getText();
					i=Integer.parseInt(text);
				
				}
				catch(NumberFormatException e)
				{
					//System.out.println(e.getMessage());
				}
				System.out.print("****  "+i);
			}
			
		});
	}

	
}
