//This key Word Refers That i belong to the Current One
// This project Has been Designed As A manager for the SIT (Considering the Name To be Supposed)COMPANY
// From Now the Pass Word is the 1111 and the Name of the User is the manager
// this  Key Word Represents that to belong to the Same Class Means as the Specific Member Belongs to the Same  House
// Card Lay out is just Like a  Shuffler 

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.util.ArrayList;
// For the Sorting Purposes
// It Will Extend the Function Which is the built in function Named Sort
import java.util.Collections;

// For the Comparisons of the Entities
import java.util.Comparator;

public class Mian extends JFrame implements ActionListener {

    JPanel panelWelcome, panelLogin, panelDashboard, panelAddEmployee, panelViewEmployees, panelUpdateDelete;

    CardLayout cardLayout;

    JButton btnGoToLogin, btnLogin, btnLoginBack, btnAdd, btnView, btnUpdateDelete, btnLogout;

    JButton btnSaveEmployee, btnBackToDashboardAdd, btnBackToDashboard, btnBackToDashboardUpdate;

    JButton btnUpdateEmployee, btnDeleteEmployee;
    // Added Here the Text Field Named textField1 for the Adding of the Email

    JTextField txtUsername, txtAddEmpID, txtAddEmpName, txtAddEmpAge, txtAddEmpPosition, textField1;

    JTextField txtUpdateEmpID, txtUpdateEmpName, txtUpdateEmpAge, txtUpdateEmpPosition, textField_11;

    JPasswordField txtPassword;

    JTextArea txtAreaEmployees;
    private JTextField textField;
    private JLabel lblNewLabel;
    private JTextField textField_1;

    public Mian() {
        setTitle("Welcome Manager");
        setSize(845, 536);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        getContentPane().setLayout(cardLayout);

        // Initialize all screens
        initWelcomeScreen();
        initLoginScreen();
        initDashboardScreen();
        initAddEmployeeScreen();
        initViewEmployeesScreen();
        initUpdateDeleteEmployeeScreen();

        // Add screens to CardLayout
        getContentPane().add(panelWelcome, "Welcome");
        getContentPane().add(panelLogin, "Login");
        getContentPane().add(panelDashboard, "Dashboard");
        getContentPane().add(panelAddEmployee, "Add Employee");
        getContentPane().add(panelViewEmployees, "View Employees");
        getContentPane().add(panelUpdateDelete, "Update/Delete");

        // Customize Add Employee Panel to include Email
        JLabel lblEmployeeEmail = new JLabel("Employee Email:");
        lblEmployeeEmail.setBounds(133, 381, 140, 30);
        panelAddEmployee.add(lblEmployeeEmail);

        textField1 = new JTextField();
        textField1.setBounds(341, 381, 200, 30);
        panelAddEmployee.add(textField1);

        // Customize Update/Delete Panel to include Updated Email
        lblNewLabel = new JLabel("Updated Email");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(132, 283, 114, 14);
        panelUpdateDelete.add(lblNewLabel);

        textField_11 = new JTextField();
        textField_11.setBounds(342, 277, 200, 29);
        panelUpdateDelete.add(textField_11);
        textField_11.setColumns(10);

        // Show Welcome Screen initially
        cardLayout.show(getContentPane(), "Welcome");

        setVisible(true);
    }

    private void initWelcomeScreen() {
        panelWelcome = new JPanel(null);
        JLabel lbl = new JLabel("Welcome Manager", SwingConstants.CENTER);
        lbl.setBackground(new Color(0, 255, 255));
        lbl.setForeground(new Color(0, 255, 255));
        lbl.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 50));
        lbl.setBounds(99, 45, 599, 176);
        panelWelcome.add(lbl);

        btnGoToLogin = new JButton("Login");
        btnGoToLogin.setBackground(new Color(0, 255, 255));
        btnGoToLogin.setForeground(new Color(128, 64, 0));
        btnGoToLogin.setFont(new Font("Arial", Font.BOLD, 24));
        btnGoToLogin.setBounds(280, 288, 276, 76);
        btnGoToLogin.addActionListener(this);
        panelWelcome.add(btnGoToLogin);
    }

    private void initLoginScreen() {
        panelLogin = new JPanel(null);
        JLabel lblTitle = new JLabel("Login", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 36));
        lblTitle.setBounds(210, 11, 385, 107);
        panelLogin.add(lblTitle);

        panelLogin.add(new JLabel("UserName:")).setBounds(185, 164, 100, 30);
        txtUsername = new JTextField();
        txtUsername.setBounds(333, 167, 200, 30);
        panelLogin.add(txtUsername);

        panelLogin.add(new JLabel("PassWord:")).setBounds(185, 223, 100, 30);
        txtPassword = new JPasswordField();
        txtPassword.setBounds(333, 226, 200, 30);
        panelLogin.add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBackground(new Color(0, 255, 255));
        btnLogin.setBounds(140, 313, 111, 40);
        btnLogin.addActionListener(this);
        panelLogin.add(btnLogin);

        btnLoginBack = new JButton("Back");
        btnLoginBack.setBackground(new Color(0, 255, 255));
        btnLoginBack.setBounds(542, 313, 111, 40);
        btnLoginBack.addActionListener(this);
        panelLogin.add(btnLoginBack);
    }

    private void initDashboardScreen() {
        panelDashboard = new JPanel(null);
        JLabel lblDashboard = new JLabel("Dashboard", SwingConstants.CENTER);
        lblDashboard.setFont(new Font("Tahoma", Font.BOLD, 43));
        lblDashboard.setBounds(10, 11, 739, 90);
        panelDashboard.add(lblDashboard);

        btnAdd = new JButton("Add Employee");
        btnAdd.setBackground(new Color(0, 255, 255));
        btnAdd.setBounds(259, 132, 257, 59);
        btnAdd.addActionListener(this);
        panelDashboard.add(btnAdd);

        btnView = new JButton("View Employee");
        btnView.setBackground(new Color(0, 255, 255));
        btnView.setBounds(259, 202, 257, 59);
        btnView.addActionListener(this);
        panelDashboard.add(btnView);

        btnUpdateDelete = new JButton("Update/Delete");
        btnUpdateDelete.setBackground(new Color(0, 255, 255));
        btnUpdateDelete.setBounds(259, 272, 257, 59);
        btnUpdateDelete.addActionListener(this);
        panelDashboard.add(btnUpdateDelete);

        btnLogout = new JButton("Logout");
        btnLogout.setBackground(new Color(0, 255, 255));
        btnLogout.setBounds(259, 342, 257, 59);
        btnLogout.addActionListener(this);
        panelDashboard.add(btnLogout);
    }

    private void initAddEmployeeScreen() {
        panelAddEmployee = new JPanel(null);

        txtAddEmpID = createField(panelAddEmployee, "Employee ID:", 60);
        txtAddEmpName = createField(panelAddEmployee, "Employee Name:", 127);
        txtAddEmpAge = createField(panelAddEmployee, "Employee Age:", 199);
        txtAddEmpPosition = createField(panelAddEmployee, "Employee Position:", 288);

        btnSaveEmployee = new JButton("Save Employee");
        btnSaveEmployee.setBackground(new Color(0, 255, 255));
        btnSaveEmployee.setBounds(550, 432, 209, 54);
        btnSaveEmployee.addActionListener(this);
        panelAddEmployee.add(btnSaveEmployee);

        btnBackToDashboardAdd = new JButton("Back to Dashboard");
        btnBackToDashboardAdd.setBackground(new Color(0, 255, 255));
        btnBackToDashboardAdd.setBounds(64, 432, 209, 54);
        btnBackToDashboardAdd.addActionListener(this);
        panelAddEmployee.add(btnBackToDashboardAdd);
    }

    private void initViewEmployeesScreen() {
        panelViewEmployees = new JPanel(null);
        txtAreaEmployees = new JTextArea();
        txtAreaEmployees.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(txtAreaEmployees);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        if We Want to Set them Horizantolly And Vertically 
        scrollPane.setBounds(22, 11, 728, 339);

        panelViewEmployees.add(scrollPane);

        btnBackToDashboard = new JButton("Back to Dashboard");
        btnBackToDashboard.setBackground(new Color(0, 255, 255));
        btnBackToDashboard.setBounds(282, 397, 200, 40);
        btnBackToDashboard.addActionListener(this);
        panelViewEmployees.add(btnBackToDashboard);
    }

    private void initUpdateDeleteEmployeeScreen() {

        panelUpdateDelete = new JPanel(null);

        txtUpdateEmpID = createField(panelUpdateDelete, "Employee ID:", 50);
        txtUpdateEmpName = createField(panelUpdateDelete, "Updated Name:", 109);
        txtUpdateEmpAge = createField(panelUpdateDelete, "Updated Age:", 160);
        txtUpdateEmpPosition = createField(panelUpdateDelete, "Updated Position:", 216);

        btnUpdateEmployee = new JButton("Update Employee");
        btnUpdateEmployee.setBackground(new Color(0, 255, 255));
        btnUpdateEmployee.setBounds(586, 372, 189, 49);
        btnUpdateEmployee.addActionListener(this);
        panelUpdateDelete.add(btnUpdateEmployee);

        btnDeleteEmployee = new JButton("Delete Employee");
        btnDeleteEmployee.setBackground(new Color(0, 255, 255));
        btnDeleteEmployee.setBounds(44, 372, 169, 49);
        btnDeleteEmployee.addActionListener(this);
        panelUpdateDelete.add(btnDeleteEmployee);

        btnBackToDashboardUpdate = new JButton("Back to Dashboard");
        btnBackToDashboardUpdate.setBackground(new Color(0, 255, 255));
        btnBackToDashboardUpdate.setBounds(325, 372, 189, 49);
        btnBackToDashboardUpdate.addActionListener(this);
        panelUpdateDelete.add(btnBackToDashboardUpdate);

    }

    private JTextField createField(JPanel panel, String label, int y) {
        JLabel lbl = new JLabel(label);
        lbl.setBounds(133, y, 140, 30);
        panel.add(lbl);
        JTextField field = new JTextField();
        field.setBounds(341, y, 200, 30);
        panel.add(field);
        return field;

    }

    //   JOptionPane.showMessageDialog(this, "Employee updated!"); JoptionPane is for the Showing the Statement in the Dialogue  Box
// Basically this is For the Handling of the Actions of the GUI
    // Action Performed Is the JaVA sWING built iin Function That Is used For the Tracing of the Buttons And the Text Fields
    public void actionPerformed(ActionEvent e) {
        // e.getSource() is the Tracker that Tracks Where the clicked and then inside it the cardlayout() Will tell you Where to move Now

        if (e.getSource() == btnGoToLogin) {
            cardLayout.show(getContentPane(), "Login"); 
        }// A condition that has been  passed that if we click on the Back Button it Will move to the WelCome Screen Again
        else if (e.getSource() == btnLoginBack) {
            cardLayout.show(getContentPane(), "Welcome"); 
        }// if We Click on the btn Login then
        else if (e.getSource() == btnLogin) {
            // Ye Intially Set kar dya Gya ha kay agar ye shoaib As A username And 1111 as a password dalta ha then
            if (txtUsername.getText().equals("manager") && new String(txtPassword.getPassword()).equals("1111")) {

                // It Will Show the Dialouge Box Where Login Successful will be Poped Up
                JOptionPane.showMessageDialog(this, "Successfully Logged In ");

                // And A dash Board Will be Opened
                cardLayout.show(getContentPane(), "Dashboard");

            } else {

                // but if the User Enters the Wrong then A statement of the Invalid username or password! Will be Shown here
// instead of using For the Both of them Lets Do it for the 1 time Only
                //if(txtUsername.getText()!="manager")
//{
//	  JOptionPane.showMessageDialog(this, " Dear Manager Name is Not Correct ");
//
//}
//
//if(txtUsername.getText()!="1111")
//{
//	  JOptionPane.showMessageDialog(this, " Dear Manager PassWord is not Correct! ");
//}
                JOptionPane.showMessageDialog(this, "Manager ! Invalid Name or the Pass Word ");

            }

        } // IF the Log out Button has been Clicked then A option of the Logged Out Will be Appeared THere
        else if (e.getSource() == btnLogout) {

            JOptionPane.showMessageDialog(this, "Successfully Logged Out!");
            // THen again Come on the welcome Screen
            cardLayout.show(getContentPane(), "Welcome");

        } else if (e.getSource() == btnAdd) {
            cardLayout.show(getContentPane(), "Add Employee"); 
        }else if (e.getSource() == btnView) {

            ArrayList<Employee> employees = new ArrayList<Employee>();
            employees = EmployeeDataHandler.readEmployees();
            /*
 We are Going to Sort the Data n the Basis of the IDS and Names of the Employees

             */
            // Sort the list by ID first, then by Name if IDs are equal
            /*
             * 
Employees are first sorted by their ID in ascending order.
If some employees have the same ID, they will be sorted by their Name alphabetically
Negative (<0)	  o1 chhota hai o2 se (toh o1 pehle ayega)
Zero (0)	     o1 aur o2 barabar hain (no change)
Positive (>0)	  o1 bada hai o2 se (toh o2 pehle ayega)
first of All Same ids Can not be Stored At A time in the Management System Because of the Checks But if the User Tries And Allah na Kary Ho ve jaye Then it Will Sort By the Name Alphabatically in the Order

             */

            Collections.sort(employees, new Comparator<Employee>() {

                @Override
                public int compare(Employee e1, Employee e2) {
                    // If the IDS becomes the Same then Employees With the Same IDS must be Sorted on the Basis Of the Names 
                    int idCompare = Integer.compare(e1.getId(), e2.getId());
                    if (idCompare == 0) // Means If the IDS matches 
                    {// Then Perform the Sorting On the Basis of the Names 
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        // Other Wise Rare Chences Are that It Should Compare the Ids 

                        return idCompare;

                    }
                }
            });

            // Clear the text area and display the sorted employees
            txtAreaEmployees.setText("");

            // This is For the Printing Of  the Employees Numbers I mean Number First Employee Then Second One then Third One 
            txtAreaEmployees.setText("");

            for (int i = 0; i < employees.size(); i++) {

                Employee emp = employees.get(i);

                txtAreaEmployees.append(" Employee No. " + (i + 1) + "\n" + "\n");

                // Fetching the Data From the File 
                // Basically ye Data Ko fetch kar rha ha Aur Jor raya ha 
                txtAreaEmployees.append(emp.toString());

            }

            cardLayout.show(getContentPane(), "View Employees");

        } else if (e.getSource() == btnUpdateDelete) {

            cardLayout.show(getContentPane(), "Update/Delete");
            // For the remembering of the Manager He Can Use id only To Delete the Employee Else Conditions Are Not Required 
            JOptionPane.showMessageDialog(this, "Manager ! ID is Enough to Delete Employee");
        } // Backing to the Dash Board 
        else if (e.getSource() == btnBackToDashboard || e.getSource() == btnBackToDashboardAdd || e.getSource() == btnBackToDashboardUpdate) {
            cardLayout.show(getContentPane(), "Dashboard"); 
        }// Save Employee Functionality
        // GetText() is the Built in java Swing Frame Work option And It is Being used in  this Small Level  Project that  Will Get the Text From the EMployee
        else if (e.getSource() == btnSaveEmployee) {

            try {

                // Getting the Inputs TO store in the file
                int id = Integer.parseInt(txtAddEmpID.getText());
                String name = txtAddEmpName.getText();
                int age = Integer.parseInt(txtAddEmpAge.getText());
                String position = txtAddEmpPosition.getText();

                String Email = textField1.getText();

                if (!Email.endsWith("@gmail.com")) {
                    JOptionPane.showMessageDialog(this, "Email must end with @gmail.com");
                    return; // This prevents saving invalid email
                }

                // Reading All of the Employees Once A time
                ArrayList<Employee> employees = EmployeeDataHandler.readEmployees();
                /*
 An Employee Can have Same Position and the Age but
 Not Can Have the Same Name and ID and the EMAIL
 So check for these Only the three Entities
                 */

                boolean idExists = false;

                boolean EmailExists = false;

// A for Loop  That Will Run on the Over All of the File handled Data 
                for (Employee existingEmp : employees) {
                    if (existingEmp.getId() == id) {

                        idExists = true;

                    }

                    if (existingEmp.getEmail().equalsIgnoreCase(Email)) {
                        EmailExists = true;

                    }

                }

                if (idExists) {

                    JOptionPane.showMessageDialog(this, "Employee with this ID already exists!");

                } else if (EmailExists) {
                    JOptionPane.showMessageDialog(this, "Employee With this Email Already Exits!");
                } // Other Wise PLease Add the Entities to the File
                else {

                    Employee emp = new Employee(id, name, age, position, Email);
                    EmployeeDataHandler.addEmployee(emp);
                    JOptionPane.showMessageDialog(this, "Employee saved!");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "SunShine Please enter valid data!");
            }
        } else if (e.getSource() == btnDeleteEmployee) {

            try {

                // Because In the First Of All I am Going to have the Deletion on the Basis Of the ID means if the ID matches With the Employee then it Will be Deleted other Wise Not
                int id = Integer.parseInt(txtUpdateEmpID.getText());
                boolean deleted = EmployeeDataHandler.deleteEmployee(id);
                /*
               String name=String.parseString()

               if We want to Update it On the Basis of the String name Then
                 */
                if (deleted) {
                    JOptionPane.showMessageDialog(this, "Employee deleted Successfully ");

                } else {

                    JOptionPane.showMessageDialog(this, "Employee With the Provided ID does Not Exists Here Please Try Again ");

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this, "Invalid ID");

            }

        } else if (e.getSource() == btnUpdateEmployee) {

            // Identifying the Existence of the ID ( either the present or the Not ) is in the Built in File Handling Operations
            try {

                // Gets the Inputs Then
                int id = Integer.parseInt(txtUpdateEmpID.getText());

                String name = txtUpdateEmpName.getText();

                int age = Integer.parseInt(txtUpdateEmpAge.getText());

                String position = txtUpdateEmpPosition.getText();

                // Lets Add here the Email Also
                String Email = textField1.getText();

                boolean updated = EmployeeDataHandler.updateEmployee(new Employee(id, name, age, position, Email));

                if (updated) {
                    JOptionPane.showMessageDialog(this, "Employee updated!"); 
                }else {
                    JOptionPane.showMessageDialog(this, "Dear Invalid ID");
                }
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this, " Manager! Invalid Inputs  ");
            }

        }

    }

    public static void main(String[] args) {

        // Run Whole of the Class of the Logics and the GUI part here 
        new Mian();

    }
}
