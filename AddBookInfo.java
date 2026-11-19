import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBookInfo extends JFrame implements ActionListener {
    private JTextField txtTitle, txtAuthor;
    private JButton btnAdd, btnList;
    private JTextArea txtBooks;

    public AddBookInfo() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(5, 5));
        ((JPanel) pane).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.add(new JLabel("Book Title:"));
        txtTitle = new JTextField(20);
        inputPanel.add(txtTitle);

        inputPanel.add(new JLabel("Author:"));
        txtAuthor = new JTextField(20);
        inputPanel.add(txtAuthor);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnList);

        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        topPanel.add(inputPanel, BorderLayout.NORTH);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        bottomPanel.add(new JLabel("Books:"), BorderLayout.NORTH);
        txtBooks = new JTextArea(6, 35);
        txtBooks.setEditable(false);
        bottomPanel.add(new JScrollPane(txtBooks), BorderLayout.CENTER);

        pane.add(topPanel, BorderLayout.NORTH);
        pane.add(bottomPanel, BorderLayout.CENTER);

        btnAdd.addActionListener(this);
        btnList.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String title = txtTitle.getText().trim();
            String author = txtAuthor.getText().trim();
            if (!title.isEmpty() && !author.isEmpty()) {
                MainMenu.books.add(new Book(title, author));
                txtTitle.setText("");
                txtAuthor.setText("");
            }
        } else if (e.getSource() == btnList) {
            txtBooks.setText("");
            for (Book b : MainMenu.books) {
                txtBooks.append("Book title : " + b.getTitle() + " (Author : " + b.getAuthor() + ")\n");
            }
        }
    }

    public static void main(String[] args) {
        AddBookInfo frame = new AddBookInfo();
        frame.setTitle("Add Book Info");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(450, 280);
        frame.setVisible(true);
    }
}
