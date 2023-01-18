import demo.demoConnect;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class mainDialog extends JDialog {
    private JPanel contentPane;
    private JButton newData;
    private JButton delData;
    private JPanel buttonPanel;
    private JButton idChange;
    private JButton getData;
    private JTextArea dataShow;

    public mainDialog(demoConnect stockExchangeDB) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(getData);

        getData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onShow(stockExchangeDB);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });//Готово

        newData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onNew(stockExchangeDB);
            }
        });

        idChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onChange(stockExchangeDB);
            }
        });

        delData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onDelete(stockExchangeDB);
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

    private void onShow(demoConnect stockExchangeDB) throws SQLException {
        dataShow.setText("");
        ArrayList<String> s = stockExchangeDB.papers.getData();
        for(String j : s) dataShow.append(j);

    }

    private void onNew(demoConnect stockExchangeDB) {
        newDataPanel j = new newDataPanel(stockExchangeDB);
        try {
            j.doThing(stockExchangeDB);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void onChange(demoConnect stockExchangeDB) {
        changeDataPanel jC = new changeDataPanel(stockExchangeDB);
        try {
            jC.doThingChange(stockExchangeDB);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void onDelete(demoConnect stockExchangeDB) {
        delDataPanel jD = new delDataPanel(stockExchangeDB);
        try {
            jD.doThingDelete(stockExchangeDB);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        demoConnect stockExchangeDB = new demoConnect();
        mainDialog dialog = new mainDialog(stockExchangeDB);

        dialog.setSize(500,500);
        dialog.setVisible(true);
        System.exit(0);
    }
}
