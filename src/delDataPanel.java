import demo.demoConnect;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class delDataPanel extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField offTextField;

    public delDataPanel(demoConnect stockExchangeDB) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK(stockExchangeDB);
            }
        });


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK(demoConnect stockExchangeDB) {
        String nameDeleteInfo = offTextField.getText();
        try {
            String g = stockExchangeDB.papers.soldID(nameDeleteInfo);
            JOptionPane.showMessageDialog(contentPane,g);
            dispose();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void doThingDelete(demoConnect stockExchangeDB) throws SQLException, ClassNotFoundException {
        delDataPanel dialog = new delDataPanel(stockExchangeDB);
        dialog.setSize(450,150);
        dialog.setVisible(true);

    }
}
