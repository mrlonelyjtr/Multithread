import searcher.Display;
import searcher.Searcher;
import searcher.SearcherFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener, Display {
    private final JTextField textfield = new JTextField("word", 10);
    private final JButton button = new JButton("Search");
    private final JTextArea textarea = new JTextArea(20, 30);
    private final static String NEWLINE = System.getProperty("line.separator");
    private final Searcher searcher = SearcherFactory.createSearcher();

    public MyFrame() {
        super("ActiveObject Sample");
        getContentPane().setLayout(new BorderLayout());

        JPanel north = new JPanel();
        north.add(new JLabel("Search:"));
        north.add(textfield);
        north.add(button);
        button.addActionListener(this);

        JScrollPane center = new JScrollPane(textarea);

        getContentPane().add(north, BorderLayout.NORTH);
        getContentPane().add(center, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        searchWord(textfield.getText());
    }

    private void searchWord(final String word) {
        searcher.search(word, this);
        println("Searching " + word + "...");
    }

    private void println(String line) {
        textarea.append(line + NEWLINE);
    }

    @Override
    public void display(final String line) {
        SwingUtilities.invokeLater(
            new Runnable() {
                @Override
                public void run() {
                    MyFrame.this.println(line);
                }
        });

    }
}
