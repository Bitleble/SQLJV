import demo.demoConnect;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class newDataPanel extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField nameTextField;
    private JTextField priceTextField;
    private JTextField countTextField;
    private JTextField typeTextField;

    public newDataPanel(demoConnect stockExchangeDB) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK(stockExchangeDB);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK(demoConnect stockExchangeDB) throws SQLException {
        String getNameData = nameTextField.getText();
        String getTypeData = typeTextField.getText();
        int getCountData = Integer.parseInt(countTextField.getText());
        int getPriceData = Integer.parseInt(priceTextField.getText());
        stockExchangeDB.papers.createData(getNameData,getTypeData,getPriceData,getCountData);
        JOptionPane.showMessageDialog(contentPane, String.format("""
                Запись создана!
                Наименование: %s
                Тип: %s
                Кол-во страниц: %s
                Цена: %s
                """, getNameData,getTypeData,getCountData,getPriceData));
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public void doThing(demoConnect stockExchangeDB) throws SQLException, ClassNotFoundException {
        newDataPanel dialog = new newDataPanel(stockExchangeDB);
        dialog.pack();
        dialog.setVisible(true);

    }
}
