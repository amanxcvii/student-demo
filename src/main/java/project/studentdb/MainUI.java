package project.studentdb;

import com.studentdb.jdbcspring.messages.MessageSerialization;
import com.studentdb.jdbcspring.messages.serverRequest;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aman Malik
 */
public class MainUI extends javax.swing.JFrame {

    private ArrayList<ArrayList<Object>> tableData;
    private Vector data;
    private dataController controller;
    private SocketChannel socketChannel;
    private DataInputStream dataInputStream;
    private final static Logger LOGGER = Logger.getLogger(MainUI.class.getName());

    /**
     * Creates new form MainUI
     */
    public MainUI() {
//        getConnection();
//        getSocketChannel();
        this.initClient();
        this.listenForResponses();

        // Create and send a request to the server
        serverRequest req = new serverRequest();
        req.setKey("GET_ALL_STUDENTS");
        sendRequest(req);
        initComponents();
        clearBtn.setEnabled(false);
    }

    private Vector getData() {
        return data;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        NameField = new javax.swing.JTextField();
        AgeField = new javax.swing.JTextField();
        FatherField = new javax.swing.JTextField();
        AddressField = new javax.swing.JTextField();
        MotherField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SexField = new javax.swing.JComboBox<>();
        ClassField = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        SearchField = new javax.swing.JTextField();
        exportBtn = new javax.swing.JButton();
        importBtn1 = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Regd No.", "Name ", "Age ", "Sex ", "Class", "Father's Name", "Mother's Name", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(100);
        }

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        delBtn.setText("Delete");
        delBtn.setToolTipText("");
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });

        NameField.setMaximumSize(null);
        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });

        FatherField.setMaximumSize(null);

        MotherField.setMaximumSize(null);

        jLabel1.setText("Name");

        jLabel2.setText("Age");

        jLabel3.setText("Sex");

        jLabel4.setText("Father's Name");

        jLabel5.setText("Mother's Name");

        jLabel6.setText("Address");

        jLabel7.setText("Class");

        SexField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        SexField.setMaximumSize(null);

        ClassField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1A", "1B", "2A", "2B", "3A", "3B", "4A", "4B", "5A", "5B", "6A", "6B", "7A", "7B", "8A", "8B", "9A", "9B", "10A", "10B" }));

        jLabel8.setText("Search Name/RegdNo");

        SearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFieldActionPerformed(evt);
            }
        });

        exportBtn.setText("Export");
        exportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBtnActionPerformed(evt);
            }
        });

        importBtn1.setText("Import");
        importBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importBtn1ActionPerformed(evt);
            }
        });

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addBtn)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(AgeField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ClassField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(SexField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(NameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(45, 45, 45)
                                        .addComponent(AddressField))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(MotherField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(FatherField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(delBtn)
                                .addGap(18, 18, 18)
                                .addComponent(exportBtn)
                                .addGap(18, 18, 18)
                                .addComponent(importBtn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearBtn)
                        .addGap(16, 16, 16)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {FatherField, MotherField});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {NameField, SexField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FatherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(MotherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5))
                    .addComponent(SexField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AgeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(ClassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(AddressField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(importBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        com.studentdb.jdbcspring.entity.student stu = new com.studentdb.jdbcspring.entity.student();
        String chkName = NameField.getText();
        
        Object[] NameList = getColumnDataToArray(1);
        boolean test = Arrays.asList(NameList).contains(chkName);

        if (test == true) {
            JOptionPane.showMessageDialog(null, "Name already exists");
            return;
        } else {
            stu.setName(NameField.getText());
        }
        
        stu.setSex((String) SexField.getSelectedItem());
        stu.setStdClass((String) ClassField.getSelectedItem());
        stu.setFname(FatherField.getText());
        stu.setMname(MotherField.getText());
        stu.setAddress(AddressField.getText());

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        clearField();
        addStudentAction(stu);
    }//GEN-LAST:event_addBtnActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        // TODO add your handling code here:
        int selRow = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.removeRow(selRow);
    }//GEN-LAST:event_delBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
//        try {
//             if jTable1.getValueAt(1, NORMAL)
//        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Vector<Vector> tData = model.getDataVector();

        if (tData != null) {
            try {
                FileOutputStream file = new FileOutputStream("file.bin");
                ObjectOutputStream output = new ObjectOutputStream(file);
                output.writeObject(tData);
                output.close();
                file.close();
            } catch (IOException ex) {
                //nothing as of now
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        try {
//         FileInputStream file = new FileInputStream("file.bin");
//         ObjectInputStream input = new ObjectInputStream(file);
//         Vector <Vector> tData = (Vector<Vector>)input.readObject();
//         input.close();
//         file.close();
//        Vector tData = new Vector();

            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            for (Iterator iterator = data.iterator(); iterator.hasNext();) {
                com.studentdb.jdbcspring.entity.student next = (com.studentdb.jdbcspring.entity.student) iterator.next();
                tableModel.addRow(new Object[]{next.getStudentId(), next.getName(), next.getAge(),
                    next.getSex(), next.getClass(), next.getFname(), next.getMname(), next.getAddress()});
            }
            FetchDataFromMySQL dbcon = new FetchDataFromMySQL();
            dbcon.fetchData("SELECT * FROM students");

//         DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
//         for ( int i=0; i < tData.size(); i++){
//            Vector row = tData.get(i);
//            model.addRow(new Object []{row.get(0),row.get(1),row.get(2),row.get(3),row.get(4),row.get(5),row.get(6),row.get(7)});
//        }
//<editor-fold defaultstate="collapsed" desc="To Fetch Data From API">
            /**
             * HttpURLConnection connection = null; try { //Create connection
             * URL url = new URL("http://localhost:8080/students/get/all");
             * connection = (HttpURLConnection) url.openConnection();
             * connection.setRequestMethod("GET");
             * connection.setRequestProperty("Content-Type",
             * "application/json"); connection.setDoOutput(true);
             *
             * // //Send request // DataOutputStream wr = new
             * DataOutputStream(connection.getOutputStream()); //
             * wr.writeBytes(urlParameters); // wr.close(); int responseCode =
             * connection.getResponseCode();
             *
             * } catch (Exception e) { e.printStackTrace(); } finally { if
             * (connection != null) { connection.disconnect(); } } *
             */
//</editor-fold>
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

    private void SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFieldActionPerformed
        // TODO add your handling code here:
        performSearch();
    }//GEN-LAST:event_SearchFieldActionPerformed

    private void exportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBtnActionPerformed
        // TODO add your handling code here:
        exportTableToCSV();
    }//GEN-LAST:event_exportBtnActionPerformed

    private void importBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importBtn1ActionPerformed
        // TODO add your handling code here:
        importCSVData();

    }//GEN-LAST:event_importBtn1ActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel restoreTable = (DefaultTableModel) jTable1.getModel();
        restoreTable.setRowCount(0);
        for (ArrayList<Object> rowData : tableData) {
            restoreTable.addRow(rowData.toArray());
        }
    }//GEN-LAST:event_clearBtnActionPerformed

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameFieldActionPerformed

//     // Add a mouse listener to the table to allow row selection
//        jTable1.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int selectedRow = table.getSelectedRow();
//                // You can use this selectedRow value if you want to work with the selected row's data.
//            }
//        });
    /**
     * @param args the command line arguments
     */
    public void clearField() {
        NameField.setText("");
        AgeField.setText("");
        SexField.setSelectedIndex(0);
        ClassField.setSelectedIndex(0);
        FatherField.setText("");
        MotherField.setText("");
        AddressField.setText("");
    }

//     Method to get data from a specific column of the JTable into an array
    private Object[] getColumnDataToArray(int columnIndex) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        ArrayList<Object> columnarray = new ArrayList<>();
        for (int row = 0; row < model.getRowCount(); row++) {
            Object cellValue = model.getValueAt(row, columnIndex);
            columnarray.add(cellValue);
        }
        return columnarray.toArray();
    }

//    private int findRowIndexByValue(int columnIndex, String value) {
//        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        ArrayList<Object> columnDataList = new ArrayList<>();
//        for (int row = 0; row < model.getRowCount(); row++) {
//            Object cellValue = model.getValueAt(row, columnIndex);
//            columnDataList.add(cellValue);
//            if (cellValue != null && cellValue.toString().equals(value)) {
//                return row; // Found the value, return the row index
//            }
//        }
//        return -1; // Value not found
//    }
    private void performSearch() {
        String query = SearchField.getText();//.toLowerCase();
        Object[] columnData = getColumnDataToArray(1);
        Object[] regdData = getColumnDataToArray(0);
        boolean test = Arrays.asList(columnData).contains(query);
        boolean test2 = Arrays.asList(regdData).contains(query);

        DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
        tableData = new ArrayList<>();
        for (int row = 0; row < temp.getRowCount(); row++) {
            ArrayList<Object> rowData = new ArrayList<>();
            for (int col = 0; col < temp.getColumnCount(); col++) {
                Object cellValue = temp.getValueAt(row, col);
                rowData.add(cellValue);
            }
            tableData.add(rowData);
        }

        if (test == true) {
            System.out.println("yes");

            for (int i = 0; i < columnData.length; i++) {
                if (columnData[i].equals(query)) {
                    int xyz = i;
                    //JOptionPane.showMessageDialog(null, "Exists at " + xyz);
                    Object[] searchResult = new Object[]{temp.getValueAt(i, 0), temp.getValueAt(i, 1), temp.getValueAt(i, 2), temp.getValueAt(i, 3), temp.getValueAt(i, 4), temp.getValueAt(i, 5), temp.getValueAt(i, 6), temp.getValueAt(i, 7)};

                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0);
                    model.addRow(searchResult);
                    clearBtn.setEnabled(true);
//               model.addColumn(tableData.get(xyz));
                    break; // Exit the loop once the string is found
                }
            }

        } else {
            if (test2 == true) {
                for (int i = 0; i < regdData.length; i++) {
                    if (regdData[i].equals(query)) {
                        int abc = i;
                        Object[] searchResult = new Object[]{temp.getValueAt(i, 0), temp.getValueAt(i, 1), temp.getValueAt(i, 2), temp.getValueAt(i, 3), temp.getValueAt(i, 4), temp.getValueAt(i, 5), temp.getValueAt(i, 6), temp.getValueAt(i, 7)};

                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                        model.setRowCount(0);
                        model.addRow(searchResult);
                        clearBtn.setEnabled(true);
                    }

                }
            } else {
                System.out.println("no");
                JOptionPane.showMessageDialog(null, "Doesn't Exist");
            }
        }

//        DefaultTableModel temp = (DefaultTableModel) jTable1.getModel();
//        ArrayList<ArrayList<Object>> QData = new ArrayList<ArrayList<Object>>();
//        
//        for (ArrayList<Object> obj : temp) {
//            
//                    for (Object cell : row) {
//                        row.add(cell);
//                    }
//                    QData.add(row);
//                }        
//        Vector<Vector> tData = model.getDataVector();
//        
//        for (Vector<Object> row : tData) {
//            String name = row.get(1).toString().toLowerCase();
//            if (name.contains(query)) {
//                model.addRow(row);
//            }
//        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
//        </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressField;
    private javax.swing.JTextField AgeField;
    private javax.swing.JComboBox<String> ClassField;
    private javax.swing.JTextField FatherField;
    private javax.swing.JTextField MotherField;
    private javax.swing.JTextField NameField;
    private javax.swing.JTextField SearchField;
    private javax.swing.JComboBox<String> SexField;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton delBtn;
    private javax.swing.JButton exportBtn;
    private javax.swing.JButton importBtn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void exportTableToCSV() {

        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (FileWriter writer = new FileWriter(fileToSave + ".csv")) {
                int rowCount = tableModel.getRowCount();
                int columnCount = tableModel.getColumnCount();

                // Write column headers
                for (int i = 0; i < columnCount; i++) {
                    writer.write(tableModel.getColumnName(i));
                    if (i < columnCount - 1) {
                        writer.write(",");
                    }
                }
                writer.write("\n");

                // Write table data
                for (int row = 0; row < rowCount; row++) {
                    for (int col = 0; col < columnCount; col++) {
                        Object cellValue = tableModel.getValueAt(row, col);
                        writer.write(cellValue.toString());
                        if (col < columnCount - 1) {
                            writer.write(",");
                        }
                    }
                    writer.write("\n");
                }

                JOptionPane.showMessageDialog(null, "Table data exported to " + fileToSave.getAbsolutePath() + ".csv");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error exporting data.");
            }
        }

        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void importCSVData() {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showOpenDialog(null);
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try {
                // Get the selected CSV file
                String selectedFile = fileChooser.getSelectedFile().getAbsolutePath();

                // Clear the existing table data
                tableModel.setRowCount(0);

                // Create a BufferedReader to read the CSV file
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] rowData = line.split(",");
                    tableModel.addRow(rowData);
                }

                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error importing CSV data.");
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void getConnection() {
        try {
            // Creating an object of Socket class where port number same as server side program
            Socket myCsocket = new Socket("localhost", 8080);
            System.out.println("Connected to Server");
            // get the output stream from the socket.
            OutputStream outputStream = myCsocket.getOutputStream();
            // create a data output stream from the output stream so we can send data through it
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF("Student_data");
            dataOutputStream.flush(); // send the message
//            dataOutputStream.close(); // close the output stream when we're done.

            ObjectInputStream ois = new ObjectInputStream(myCsocket.getInputStream());
            if (data != null) {
                data.clear();
            }
            data = (Vector<student>) ois.readObject();
            System.out.println("Data Recieved from the Server");
            myCsocket.close();
        } // Catch block to handle exceptions
        catch (Exception e) {
            // Simply return and exit the program
            e.printStackTrace();
            System.out.println("No Response from Server");
        }
    }

    private void getSocketChannel() {
        try {
            // Open a new SocketChannel
            this.socketChannel = SocketChannel.open();
            // Connect to the server
            socketChannel.connect(new InetSocketAddress("localhost", 8081));
            System.out.println("Connected to server");
            // Create your custom serializable object
            serverRequest req = new serverRequest();
            req.setKey("GET_ALL_STUDENTS");
            // Send the object over the channel
            dataInputStream = new DataInputStream(socketChannel.socket().getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socketChannel.socket().getOutputStream());
            dataOutputStream.write(MessageSerialization.serialize(req));
            dataOutputStream.flush();
//            dataOutputStream.close();
            System.out.println("Object sent to server");
            listenForResponses();
            // Close the connection
//            socketChannel.close();
//            System.out.println("Connection closed");
        } catch (IOException e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
        }
    }


    private void handleResponse(Object obj) {
        if (obj instanceof serverRequest) {
            System.out.println("of serverRequest");
            serverRequest newReq = (serverRequest) obj;
            if (newReq.getKey().equals("GET_ALL_STUDENTS")) {
                if (data != null) {
                    data.clear();
                }
                this.data = newReq.getInfo();
            }
        }
    }

    private void listenAction() throws IOException, ClassNotFoundException {
        if (socketChannel.isOpen()) {
            dataInputStream = new DataInputStream(socketChannel.socket().getInputStream());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            if (dataInputStream.available() > 0) {
                while (dataInputStream.available() > 0) {
                    bytesRead = dataInputStream.read(buffer);
                    if (bytesRead == -1) {
                        // Handle the case when the end of the stream is reached
                        break;
                    }
                    byteArrayOutputStream.write(buffer, 0, bytesRead);
                }
                byte[] receivedData = byteArrayOutputStream.toByteArray();
                Object obj = MessageSerialization.deserialize(receivedData);
                handleResponse(obj);
            } else {
                return;
            }
        } else {
            socketChannel.connect(new InetSocketAddress("localhost", 8081));

        }
    }

    public void initClient() {
        try {
            this.socketChannel = SocketChannel.open();
            this.socketChannel.connect(new InetSocketAddress("localhost", 8081));
            this.socketChannel.configureBlocking(false);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error connecting to server", e);
        }
    }

    public void sendRequest(serverRequest req) {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.clear().put(MessageSerialization.serialize(req));
            buffer.flip();  // Prepare buffer for writing
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
            buffer.clear();
            LOGGER.info("Request sent to server");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error sending request to server", e);
        }
    }

    public void listenForResponses() {
        new Thread(() -> {
            try {
                while (true) {
                    handleResponse();
                    Thread.sleep(1000); // Adjust sleep time as needed
                }
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, "Thread interrupted", e);
            }
        }).start();
    }

    private void handleResponse() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (true) {
                int bytesRead = socketChannel.read(buffer);
                if (bytesRead <= 0) {//blocking false is complusaryhere to get 0
                    break; // End of file or connection closed
                }
                buffer.flip();
                byteArrayOutputStream.write(buffer.array(), 0, bytesRead);
                buffer.clear();
            }
            byte[] receivedData = byteArrayOutputStream.toByteArray();
            if(receivedData.length >0 ){
            Object obj = MessageSerialization.deserialize(receivedData);
            if (obj instanceof serverRequest) {
                serverRequest newReq = (serverRequest) obj;
                if (newReq.getKey().equals("GET_ALL_STUDENTS")) {
                    handleGetAllStudentsResponse(newReq.getInfo());
                }
            }
            }
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Error handling response from server", e);
            return;
        }
    }

    private void handleGetAllStudentsResponse(Vector<?> info) {
        // Handle the response containing list of students
        // You can process the list of students here
        LOGGER.info("Received response from server with student information: " + info);
        this.data = info;
        setTableInfo();
    }

    private void setTableInfo() {
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        for (Iterator iterator = data.iterator(); iterator.hasNext();) {
            com.studentdb.jdbcspring.entity.student next = (com.studentdb.jdbcspring.entity.student) iterator.next();
            tableModel.addRow(new Object[]{next.getStudentId(), next.getName(), next.getAge(),
                next.getSex(), next.getStdClass(),next.getFname(), next.getMname(), next.getAddress()});
        }
    }

    private void addStudentAction(com.studentdb.jdbcspring.entity.student stu) {
        serverRequest req = new serverRequest();
        Vector v = new Vector();
        v.add(stu);
        req.setInfo(v);
        req.setKey("ADD_STUDENT");
        sendRequest(req);
    }

}
/*---------For Resultset---------
        int columnCount = data.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    tableModel.addColumn(data.getMetaData().getColumnName(i));
                }
//                
                while (data.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        row[i - 1] = data.getObject(i);
                    }
                    tableModel.addRow(row);
                }
 */
