/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp.project1;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Priyansh
 */
public class manageSuppliers extends javax.swing.JInternalFrame {

    /**
     * Creates new form manageSuppliers
     */
    public manageSuppliers() {
        initComponents();
        SelectSupplier();
    }
    Connection Con= null;
    Statement St= null;
    ResultSet Rs=null;
    public void SelectSupplier()
    {
        try{
            Con=DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
            St=Con.createStatement();
            Rs=St.executeQuery("Select * from User1.MANAGESUPPLIERSTB");
            SupTable.setModel(DbUtils.resultSetToTableModel(Rs));
             theader();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        SupLastName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        SupAddress = new javax.swing.JTextArea();
        SupEmail = new javax.swing.JTextField();
        SupContact = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        SupFirstName = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        SupSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        SupTable = new javax.swing.JTable();

        setFrameIcon(null);
        setPreferredSize(new java.awt.Dimension(1491, 1000));
        setVisible(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1421, 928));

        jLabel1.setBackground(new java.awt.Color(0, 0, 102));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cpp/project1/icons/icons8_supplier_52px_2.png"))); // NOI18N
        jLabel1.setText("MANAGE SUPPLIER");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(333, 712));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        SupLastName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SupLastName.setForeground(new java.awt.Color(153, 153, 153));
        SupLastName.setText("  Enter Last Name");
        SupLastName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        SupLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SupLastNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SupLastNameFocusLost(evt);
            }
        });
        SupLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupLastNameActionPerformed(evt);
            }
        });

        SupAddress.setColumns(20);
        SupAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SupAddress.setForeground(new java.awt.Color(153, 153, 153));
        SupAddress.setRows(5);
        SupAddress.setText("  Enter Address");
        SupAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        SupAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SupAddressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SupAddressFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(SupAddress);

        SupEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SupEmail.setForeground(new java.awt.Color(153, 153, 153));
        SupEmail.setText("  Enter Email");
        SupEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        SupEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SupEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SupEmailFocusLost(evt);
            }
        });
        SupEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupEmailActionPerformed(evt);
            }
        });

        SupContact.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SupContact.setForeground(new java.awt.Color(153, 153, 153));
        SupContact.setText("  Enter Contact No");
        SupContact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        SupContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SupContactFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SupContactFocusLost(evt);
            }
        });

        Add.setBackground(new java.awt.Color(0, 0, 102));
        Add.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Add.setForeground(new java.awt.Color(255, 255, 255));
        Add.setText("ADD");
        Add.setContentAreaFilled(false);
        Add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Add.setPreferredSize(new java.awt.Dimension(115, 29));
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Update.setBackground(new java.awt.Color(0, 0, 102));
        Update.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setText("UPDATE");
        Update.setContentAreaFilled(false);
        Update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Update.setPreferredSize(new java.awt.Dimension(115, 29));
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Clear.setBackground(new java.awt.Color(0, 0, 102));
        Clear.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Clear.setForeground(new java.awt.Color(255, 255, 255));
        Clear.setText("CLEAR");
        Clear.setContentAreaFilled(false);
        Clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        Delete.setBackground(new java.awt.Color(0, 0, 102));
        Delete.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("DELETE");
        Delete.setContentAreaFilled(false);
        Delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SupLastName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SupContact, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SupEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Update, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Clear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SupLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SupEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SupContact, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 337, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        SupFirstName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SupFirstName.setForeground(new java.awt.Color(153, 153, 153));
        SupFirstName.setText("  Enter First Name");
        SupFirstName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        SupFirstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SupFirstNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SupFirstNameFocusLost(evt);
            }
        });
        SupFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupFirstNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(SupFirstName)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(SupFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        SupSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SupSearch.setForeground(new java.awt.Color(153, 153, 153));
        SupSearch.setText("  Search Suppliers ");
        SupSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        SupSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SupSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SupSearchFocusLost(evt);
            }
        });
        SupSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupSearchActionPerformed(evt);
            }
        });
        SupSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SupSearchKeyReleased(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(153, 153, 153));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SupTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "Address", "Email", "Conttact"
            }
        ));
        SupTable.setPreferredSize(new java.awt.Dimension(333, 712));
        SupTable.setRowHeight(35);
        SupTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(SupTable);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SupSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(SupSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1475, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void theader()
         {
             JTableHeader thead =SupTable.getTableHeader();
             thead.setForeground(new Color(0,0,102));
             thead.setFont(new Font("Tahoma",Font.BOLD,14));
         }
    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        SupFirstName.setText("  Enter First Name");
        SupFirstName.setForeground(new Color(153,153,153));
        SupLastName.setText("  Enter Last Name");
        SupLastName.setForeground(new Color(153,153,153));        
        SupAddress.setText("  Enter Address");
        SupAddress.setForeground(new Color(153,153,153));
        SupEmail.setText("  Enter Email");
        SupEmail.setForeground(new Color(153,153,153));
        SupContact.setText("  Enter Contact No");
        SupContact.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_ClearActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        if(SupFirstName.getText().isEmpty()||"  Enter First Name".equals(SupFirstName.getText()))
        {
            JOptionPane.showMessageDialog(this, "Enter the Supplier Name to be Delete the Supplier");
        }
        else{
            try{
                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
                String SFN=SupFirstName.getText();
                String Query="Delete from User1.MANAGESUPPLIERSTB where FIRST_NAME='"+SFN+"'";
                Statement Add=Con.createStatement();
                Add.executeUpdate(Query);
                SelectSupplier();
                JOptionPane.showMessageDialog(this, "Supplier Deleted Successfully");
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        if(SupFirstName.getText().isEmpty()||SupLastName.getText().isEmpty()||SupAddress.getText().isEmpty()||SupEmail.getText().isEmpty()||SupContact.getText().isEmpty()||"  Enter First Name".equals(SupFirstName.getText())||"  Enter Last Name".equals(SupLastName.getText())||"  Enter Address".equals(SupAddress.getText())||"  Enter Email".equals(SupEmail.getText())||"  Enter Contact No".equals(SupContact.getText()))
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }
        else{
            try {
                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
                String Query = "Update User1.MANAGESUPPLIERSTB set LAST_NAME='"+SupLastName.getText()+"'"+",ADDRESS='"+SupAddress.getText()+"'"+",EMAIL='"+SupEmail.getText()+"'"+",CONTACT="+SupContact.getText()+"where FIRST_NAME='"+SupFirstName.getText()+"'";
                Statement Add=Con.createStatement();
                Add.executeUpdate(Query);
                SelectSupplier();
                JOptionPane.showMessageDialog(this, "Supplier Updated");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        if(SupFirstName.getText().isEmpty()||SupLastName.getText().isEmpty()||SupAddress.getText().isEmpty()||SupEmail.getText().isEmpty()||SupContact.getText().isEmpty()||"  Enter First Name".equals(SupFirstName.getText())||"  Enter Last Name".equals(SupLastName.getText())||"  Enter Address".equals(SupAddress.getText())||"  Enter Email".equals(SupEmail.getText())||"  Enter Contact No".equals(SupContact.getText()))
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }
        else{
            try {
                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
                PreparedStatement add = Con.prepareStatement("insert into MANAGESUPPLIERSTB values (?,?,?,?,?)");
                add.setString(1,SupFirstName.getText());
                add.setString(2,SupLastName.getText());
                add.setString(3,SupAddress.getText());
                add.setString(4,SupEmail.getText());
                add.setInt(5,Integer.valueOf(SupContact.getText()));
                int row;
                row = add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Supplier Added Successfully");
                Con.close();
                SelectSupplier();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_AddActionPerformed

    private void SupContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SupContactFocusLost
        if(SupContact.getText().equals(""))
        {
            SupContact.setText("  Enter Contact No");
            SupContact.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_SupContactFocusLost

    private void SupContactFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SupContactFocusGained
        if(SupContact.getText().equals("  Enter Contact No"))
        {
            SupContact.setText("");
            SupContact.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_SupContactFocusGained

    private void SupEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupEmailActionPerformed

    private void SupEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SupEmailFocusLost
        if(SupEmail.getText().equals(""))
        {
            SupEmail.setText("  Enter Email");
            SupEmail.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_SupEmailFocusLost

    private void SupEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SupEmailFocusGained
        if(SupEmail.getText().equals("  Enter Email"))
        {
            SupEmail.setText("");
            SupEmail.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_SupEmailFocusGained

    private void SupLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupLastNameActionPerformed

    private void SupLastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SupLastNameFocusLost
        if(SupLastName.getText().equals(""))
        {
            SupLastName.setText("  Enter Last Name");
            SupLastName.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_SupLastNameFocusLost

    private void SupLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SupLastNameFocusGained
        if(SupLastName.getText().equals("  Enter Last Name"))
        {
            SupLastName.setText("");
            SupLastName.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_SupLastNameFocusGained

    private void SupFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupFirstNameActionPerformed

    private void SupFirstNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SupFirstNameFocusLost
        if(SupFirstName.getText().equals(""))
        {
            SupFirstName.setText("  Enter First Name");
            SupFirstName.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_SupFirstNameFocusLost

    private void SupFirstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SupFirstNameFocusGained
        if(SupFirstName.getText().equals("  Enter First Name"))
        {
            SupFirstName.setText("");
            SupFirstName.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_SupFirstNameFocusGained

    private void SupTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupTableMouseClicked
        DefaultTableModel Model=(DefaultTableModel) SupTable.getModel();
        int Myindex = SupTable.getSelectedRow();
        SupFirstName.setText(Model.getValueAt(Myindex,0).toString());
                    SupFirstName.setForeground(new Color(0,0,0));
        SupLastName.setText(Model.getValueAt(Myindex,1).toString());
                    SupLastName.setForeground(new Color(0,0,0));
        SupAddress.setText(Model.getValueAt(Myindex,2).toString());
                    SupAddress.setForeground(new Color(0,0,0));
        SupEmail.setText(Model.getValueAt(Myindex,3).toString());
                    SupEmail.setForeground(new Color(0,0,0));
        SupContact.setText(Model.getValueAt(Myindex,4).toString());
                    SupContact.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_SupTableMouseClicked

    private void SupSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SupSearchKeyReleased
        DefaultTableModel Model=(DefaultTableModel) SupTable.getModel();
        String search = SupSearch.getText();
        TableRowSorter<DefaultTableModel> tr= new TableRowSorter <DefaultTableModel>(Model);
        SupTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_SupSearchKeyReleased

    private void SupSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupSearchActionPerformed

    private void SupSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SupSearchFocusLost
        if(SupSearch.getText().equals(""))
        {
            SupSearch.setText("  Search Suppliers ");
            SupSearch.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_SupSearchFocusLost

    private void SupSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SupSearchFocusGained
        if(SupSearch.getText().equals("  Search Suppliers "))
        {
            SupSearch.setText("");
            SupSearch.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_SupSearchFocusGained

    private void SupAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SupAddressFocusLost
        if(SupAddress.getText().equals(""))
        {
            SupAddress.setText("  Enter Address");
            SupAddress.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_SupAddressFocusLost

    private void SupAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SupAddressFocusGained
        if(SupAddress.getText().equals("  Enter Address"))
        {
            SupAddress.setText("");
            SupAddress.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_SupAddressFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Clear;
    private javax.swing.JButton Delete;
    private javax.swing.JTextArea SupAddress;
    private javax.swing.JTextField SupContact;
    private javax.swing.JTextField SupEmail;
    private javax.swing.JTextField SupFirstName;
    private javax.swing.JTextField SupLastName;
    private javax.swing.JTextField SupSearch;
    private javax.swing.JTable SupTable;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
