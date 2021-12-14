package simpleEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**

 /**
 *
 * @author Asus
 */
class SimpleEditorListener extends WindowAdapter
        implements ActionListener, AutoCloseable {

    private SimpleEditor editor;
    private File file;
    private FileReader reader;
    private FileWriter writer;
    public SimpleEditorListener(SimpleEditor editor) {
        this.editor = editor;
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "open":
                break;
            case "save":
                // if(ae.getSource().equels(miOpen))
                //  save(file);

                break;
            case "cancel":
                break;
            case "exit":
        }
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void save(File file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
