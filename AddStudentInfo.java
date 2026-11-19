import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddStudentInfo extends JFrame implements ActionListener {
    private JTextField txtName, txtMatric;
    private JButton btnAdd, btnList;
    private JTextArea txtStudents;

    public AddStudentInfo() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(5, 5));
        ((JPanel) pane).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.add(new JLabel("Name:"));
        txtName = new JTextField(20);
        inputPanel.add(txtName);

        inputPanel.add(new JLabel("Matric:"));
        txtMatric = new JTextField(20);
        inputPanel.add(txtMatric);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnList);

        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        topPanel.add(inputPanel, BorderLayout.NORTH);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        bottomPanel.add(new JLabel("Students:"), BorderLayout.NORTH);
        txtStudents = new JTextArea(6, 35);
        txtStudents.setEditable(false);
        bottomPanel.add(new JScrollPane(txtStudents), BorderLayout.CENTER);

        pane.add(topPanel, BorderLayout.NORTH);
        pane.add(bottomPanel, BorderLayout.CENTER);

        btnAdd.addActionListener(this);
        btnList.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String name = txtName.getText().trim();
            String matric = txtMatric.getText().trim();
            if (!name.isEmpty() && !matric.isEmpty()) {
                MainMenu.students.add(new Student(name, matric));
                txtName.setText("");
                txtMatric.setText("");
            }
        } else if (e.getSource() == btnList) {
            txtStudents.setText("");
            for (Student s : MainMenu.students) {
                txtStudents.append("Name : " + s.toString() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        AddStudentInfo frame = new AddStudentInfo();
        frame.setTitle("Add Student Info");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(450, 280);
        frame.setVisible(true);
    }
}
