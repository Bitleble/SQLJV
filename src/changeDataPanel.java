import demo.demoConnect;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class changeDataPanel extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextField priceTextField;
    private JTextField countTextField;
    private JTextField typeTextField;

    public changeDataPanel(demoConnect stockExchangeDB) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOKCHange(stockExchangeDB);
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

    private void onOKCHange(demoConnect stockExchangeDB) throws SQLException {
        int getID = Integer.parseInt(idTextField.getText());
        String getNameData = nameTextField.getText();
        String getTypeData = typeTextField.getText();
        int getCountData = Integer.parseInt(countTextField.getText());
        int getPriceData = Integer.parseInt(priceTextField.getText());
        stockExchangeDB.papers.changeID(getID,getNameData,getTypeData,getPriceData,getCountData);
        JOptionPane.showMessageDialog(contentPane, String.format("""
                ������ � id: %s  ��������!
                ������������: %s
                ���: %s
                ���-�� �������: %s
                ����: %s
                """,getID, getNameData,getTypeData,getCountData,getPriceData));
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public void doThingChange(demoConnect stockExchangeDB) throws SQLException, ClassNotFoundException {
        changeDataPanel dialog = new changeDataPanel(stockExchangeDB);
        dialog.pack();
        dialog.setVisible(true);

    }
}
