import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorrowBook extends JFrame implements ActionListener {
    private JComboBox<Student> cmbStudent;
    private JComboBox<Book> cmbBook;
    private JButton btnBorrow;
    private JLabel lblBorrowInfo;

    public BorrowBook() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(5, 10));
        ((JPanel) pane).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel selectionPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        selectionPanel.add(new JLabel("Student Name & Matric:"));
        cmbStudent = new JComboBox<>(MainMenu.students.toArray(new Student[0]));
        selectionPanel.add(cmbStudent);

        selectionPanel.add(new JLabel("Book Title & Author:"));
        cmbBook = new JComboBox<>(MainMenu.books.toArray(new Book[0]));
        selectionPanel.add(cmbBook);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnBorrow = new JButton("Borrow");
        buttonPanel.add(btnBorrow);

        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        topPanel.add(selectionPanel, BorderLayout.NORTH);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
        bottomPanel.add(new JLabel("Borrow Information :"));
        lblBorrowInfo = new JLabel(" ");
        bottomPanel.add(lblBorrowInfo);

        pane.add(topPanel, BorderLayout.NORTH);
        pane.add(bottomPanel, BorderLayout.SOUTH);

        btnBorrow.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBorrow) {
            Student selectedStudent = (Student) cmbStudent.getSelectedItem();
            Book selectedBook = (Book) cmbBook.getSelectedItem();

            if (selectedStudent != null && selectedBook != null) {
                String message = selectedBook.borrowBy(selectedStudent);
                lblBorrowInfo.setText(message);
            }
        }
    }

    public static void main(String[] args) {
        BorrowBook frame = new BorrowBook();
        frame.setTitle("Borrow Book");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(520, 260);
        frame.setVisible(true);
    }
}
