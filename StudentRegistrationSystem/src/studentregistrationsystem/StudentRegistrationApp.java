/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentregistrationsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationApp extends JFrame {

    // Input fields
    private JTextField txtStudentNumber;
    private JTextField txtStudentName;
    private JTextField txtCourse;

    // Student records area
    private JTextArea txtRecords;

    // Buttons
    private JButton btnRegister;
    private JButton btnClear;
    private JButton btnExit;

    // Constructor
    public StudentRegistrationApp() {

        // QUESTION 1: Creating the GUI

        setTitle("Student Registration System");
        setSize(650, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // QUESTION 2: Layout managers and colours

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(Color.WHITE);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBackground(new Color(220, 235, 250));

        // Labels
        JLabel lblStudentNumber =
                new JLabel("Student Number:");

        JLabel lblStudentName =
                new JLabel("Student Name:");

        JLabel lblCourse =
                new JLabel("Course:");

        // Text fields
        txtStudentNumber = new JTextField(15);
        txtStudentName = new JTextField(15);
        txtCourse = new JTextField(15);

        // Tooltips
        txtStudentNumber.setToolTipText(
                "Enter the student's student number");

        txtStudentName.setToolTipText(
                "Enter the student's full name");

        txtCourse.setToolTipText(
                "Enter the student's course");

        // Add components to input panel
        inputPanel.add(lblStudentNumber);
        inputPanel.add(txtStudentNumber);

        inputPanel.add(lblStudentName);
        inputPanel.add(txtStudentName);

        inputPanel.add(lblCourse);
        inputPanel.add(txtCourse);

        // Buttons
        btnRegister = new JButton("Register");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");

        btnRegister.setToolTipText(
                "Register a new student");

        btnClear.setToolTipText(
                "Clear all input fields");

        btnExit.setToolTipText(
                "Close the application");

        // Separate button panel
        JPanel buttonPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 15, 10));

        buttonPanel.setBackground(new Color(200, 220, 240));

        buttonPanel.add(btnRegister);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnExit);

        // QUESTION 4: Student list and scrolling

        txtRecords = new JTextArea(12, 40);

        txtRecords.setEditable(false);

        txtRecords.setText("STUDENT REGISTRATION RECORDS\n\n");

        JScrollPane scrollPane =
                new JScrollPane(txtRecords);

        // Add panels to main panel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // QUESTION 3: Event handling

        btnRegister.addActionListener(e -> registerStudent());

        btnClear.addActionListener(e -> clearFields());

        btnExit.addActionListener(e -> dispose());

        // QUESTION 5: Menus and mouse events

        createMenu();

        // Mouse listener for student records
        txtRecords.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                JOptionPane.showMessageDialog(
                        StudentRegistrationApp.this,
                        "You clicked the student records area.");
            }
        });

        // Centre the application
        setLocationRelativeTo(null);

    }

    // Register student method
    private void registerStudent() {

        // Retrieve entered information
        String studentNumber =
                txtStudentNumber.getText().trim();

        String studentName =
                txtStudentName.getText().trim();

        String course =
                txtCourse.getText().trim();

        // Validate input fields
        if (studentNumber.isEmpty()
                || studentName.isEmpty()
                || course.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please complete all fields.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);

            return;
        }

        // Add student details to records
        String record =
                "Student Number: " + studentNumber + "\n"
                + "Student Name: " + studentName + "\n"
                + "Course: " + course + "\n\n";

        txtRecords.append(record);

        // Display confirmation message
        JOptionPane.showMessageDialog(
                this,
                "Student registered successfully!\n\n"
                + record,
                "Registration Successful",
                JOptionPane.INFORMATION_MESSAGE);

        // Clear fields after registration
        clearFields();
    }

    // Clear input fields method
    private void clearFields() {

        txtStudentNumber.setText("");
        txtStudentName.setText("");
        txtCourse.setText("");

        // Return cursor to student number field
        txtStudentNumber.requestFocus();
    }

    // Create menu bar
    private void createMenu() {

        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");

        JMenuItem clearItem =
                new JMenuItem("Clear Fields");

        JMenuItem exitItem =
                new JMenuItem("Exit");

        // Help menu
        JMenu helpMenu = new JMenu("Help");

        JMenuItem aboutItem =
                new JMenuItem("About");

        // Add menu items
        fileMenu.add(clearItem);
        fileMenu.add(exitItem);

        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        // Menu event handling
        clearItem.addActionListener(e -> clearFields());

        exitItem.addActionListener(e -> dispose());

        aboutItem.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this,
                        "Student Registration System\n"
                        + "Developer: [Enter Your Name]",
                        "About",
                        JOptionPane.INFORMATION_MESSAGE));
    }

    // Main method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            StudentRegistrationApp app =
                    new StudentRegistrationApp();

            app.setVisible(true);

        });
    }
}