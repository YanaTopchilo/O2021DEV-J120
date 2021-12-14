package simpleEditor;

import java.awt.*;
import java.io.File;
import java.util.Properties;
import javax.swing.*;



/**
 *
 * @author Asus
 */
public class SimpleEditor extends JFrame {
    private Container cp = getContentPane();
    private JLabel fileName;
    private JTextArea text;
    private JMenuBar bar;
    private JMenu menu;
    private JMenuItem[] commandMenu;
    private JButton[] commandButton;
    private SimpleEditorListener listener;

    protected SimpleEditor() {
        super("SimpleEditor");
        setTitle("Simple text editor");
        setSize(800, 500);
        setLocation(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setJMenuBar(initJMenuBar());
        init();
        createMenu();
        cp.setLayout(new BorderLayout());
        cp.setLayout(new BorderLayout());
        JPanel bottomPanel = new JPanel(new FlowLayout());
        cp.add(bottomPanel, BorderLayout.NORTH);
        cp.add(new JScrollPane(textArea()), BorderLayout.CENTER);
        bar.add(createMenu());

        setVisible(true);
    }
    private JTextArea textArea(){
        text = new JTextArea();
        return text;
    }

    private JButton getText (){
        JButton getText = new JButton("get Text");
        getText.addActionListener((e) -> {
            System.out.println(text.getText());
        });
        return getText;
    }
    private JMenuBar initJMenuBar (){
        bar = new JMenuBar();
        JMenu settings = new JMenu("Settings");
        JMenu save = new JMenu("Save");
        bar.add(settings);
        bar.add(save);
        return bar;
   }
    public static void main(String[] args) {
        SimpleEditor simpleEditor = new SimpleEditor();
    }

    private void init() {

    }

    private JMenu createMenu() {
        menu = new JMenu("Fale");
        JMenu file = new JMenu ("New");
        menu.add(file);
        JMenu edit  = new JMenu("Edit");
        menu.add(edit);
        return menu;
    }
    void appendText(String str, boolean append) {

    }

}
