/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp.project1;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Priyansh
 */
public class manageEmployees extends javax.swing.JInternalFrame {

    /**
     * Creates new form manageEmployees
     */
    public manageEmployees() {
        initComponents();
        SelectSeller();
    }
    
Connection Con= null;
Statement St= null;
ResultSet Rs=null;
public void SelectSeller()
{
    try{
        Con=DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
        St=Con.createStatement();
        Rs=St.executeQuery("Select * from User1.MANAGEEMPLOYEETB");
        EmpTable.setModel(DbUtils.resultSetToTableModel(Rs));
        theader();
    }catch(Exception e)
    {
        e.printStackTrace();
    }
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        EmpLoginId = new javax.swing.JTextField();
        EmpLastName = new javax.swing.JTextField();
        Clear = new javax.swing.JButton();
        EmpAdd = new javax.swing.JButton();
        EmpSecurityQ = new javax.swing.JTextField();
        EmpAnswer = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        EmpAddress = new javax.swing.JTextArea();
        EmpContact = new javax.swing.JTextField();
        Delete = new javax.swing.JButton();
        EmpEmail = new javax.swing.JTextField();
        Update = new javax.swing.JButton();
        EmpFirstName = new javax.swing.JTextField();
        EmpPassword = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        EmpTable = new javax.swing.JTable();
        EmpSearch = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1491, 1000));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1187, 717));

        jLabel1.setBackground(new java.awt.Color(0, 0, 102));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cpp/project1/icons/icons8_management_52px.png"))); // NOI18N
        jLabel1.setText("MANAGE EMPLOYEE");
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(262, 28));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        EmpLoginId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EmpLoginId.setForeground(new java.awt.Color(153, 153, 153));
        EmpLoginId.setText("  Enter Login Id");
        EmpLoginId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        EmpLoginId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmpLoginIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmpLoginIdFocusLost(evt);
            }
        });
        EmpLoginId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpLoginIdActionPerformed(evt);
            }
        });

        EmpLastName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EmpLastName.setForeground(new java.awt.Color(153, 153, 153));
        EmpLastName.setText("  Enter Last Name");
        EmpLastName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        EmpLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmpLastNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmpLastNameFocusLost(evt);
            }
        });
        EmpLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpLastNameActionPerformed(evt);
            }
        });

        Clear.setBackground(new java.awt.Color(0, 0, 102));
        Clear.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Clear.setForeground(new java.awt.Color(255, 255, 255));
        Clear.setText("CLEAR");
        Clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Clear.setPreferredSize(new java.awt.Dimension(115, 29));
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        EmpAdd.setBackground(new java.awt.Color(0, 0, 102));
        EmpAdd.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        EmpAdd.setForeground(new java.awt.Color(255, 255, 255));
        EmpAdd.setText("ADD");
        EmpAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EmpAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpAddActionPerformed(evt);
            }
        });

        EmpSecurityQ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EmpSecurityQ.setForeground(new java.awt.Color(153, 153, 153));
        EmpSecurityQ.setText("  Enter the Security Question");
        EmpSecurityQ.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        EmpSecurityQ.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmpSecurityQFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmpSecurityQFocusLost(evt);
            }
        });
        EmpSecurityQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpSecurityQActionPerformed(evt);
            }
        });

        EmpAnswer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EmpAnswer.setForeground(new java.awt.Color(153, 153, 153));
        EmpAnswer.setText("  Enter the Answer");
        EmpAnswer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        EmpAnswer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmpAnswerFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmpAnswerFocusLost(evt);
            }
        });
        EmpAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpAnswerActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));

        EmpAddress.setColumns(20);
        EmpAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EmpAddress.setForeground(new java.awt.Color(153, 153, 153));
        EmpAddress.setRows(5);
        EmpAddress.setText("  Enter the Address");
        EmpAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        EmpAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        EmpAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmpAddressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmpAddressFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(EmpAddress);

        EmpContact.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EmpContact.setForeground(new java.awt.Color(153, 153, 153));
        EmpContact.setText("  Enter Contact no");
        EmpContact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        EmpContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmpContactFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmpContactFocusLost(evt);
            }
        });

        Delete.setBackground(new java.awt.Color(0, 0, 102));
        Delete.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("DELETE");
        Delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        EmpEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EmpEmail.setForeground(new java.awt.Color(153, 153, 153));
        EmpEmail.setText("  Enter the Email");
        EmpEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        EmpEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmpEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmpEmailFocusLost(evt);
            }
        });
        EmpEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpEmailActionPerformed(evt);
            }
        });

        Update.setBackground(new java.awt.Color(0, 0, 102));
        Update.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setText("UPDATE");
        Update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Update.setPreferredSize(new java.awt.Dimension(115, 29));
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        EmpFirstName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EmpFirstName.setForeground(new java.awt.Color(153, 153, 153));
        EmpFirstName.setText("  Enter First Name");
        EmpFirstName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        EmpFirstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmpFirstNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmpFirstNameFocusLost(evt);
            }
        });
        EmpFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpFirstNameActionPerformed(evt);
            }
        });

        EmpPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EmpPassword.setForeground(new java.awt.Color(153, 153, 153));
        EmpPassword.setText("  Enter Password");
        EmpPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        EmpPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmpPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmpPasswordFocusLost(evt);
            }
        });
        EmpPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EmpLastName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmpPassword)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(EmpAnswer)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(EmpAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(14, 14, 14))
                                    .addComponent(EmpSecurityQ)))
                            .addComponent(EmpFirstName, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmpEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmpContact, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmpLoginId, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(EmpFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EmpLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EmpEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EmpContact, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EmpLoginId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EmpPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EmpSecurityQ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EmpAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmpAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        EmpTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "Address", "Email", "LoginId", "Password", "Contact", "Security Question", "Answer"
            }
        ));
        EmpTable.setRowHeight(35);
        EmpTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmpTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(EmpTable);

        EmpSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EmpSearch.setForeground(new java.awt.Color(153, 153, 153));
        EmpSearch.setText("  Search Employee");
        EmpSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        EmpSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmpSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmpSearchFocusLost(evt);
            }
        });
        EmpSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EmpSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EmpSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1042, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(EmpSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void EmpEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpEmailActionPerformed

    private void EmpFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpFirstNameActionPerformed

    private void EmpPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpPasswordActionPerformed

    private void EmpLoginIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpLoginIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpLoginIdActionPerformed
 
    
    private void theader()
        {
            JTableHeader thead =EmpTable.getTableHeader();
            thead.setForeground(new Color(0,0,102));
            thead.setFont(new Font("Tahoma",Font.BOLD,14));
        }
     
    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
    if(EmpFirstName.getText().isEmpty()||EmpLastName.getText().isEmpty()||EmpAddress.getText().isEmpty()||EmpEmail.getText().isEmpty()||EmpLoginId.getText().isEmpty()||EmpPassword.getText().isEmpty()||EmpContact.getText().isEmpty()||EmpSecurityQ.getText().isEmpty()||EmpAnswer.getText().isEmpty()||"  Enter First Name".equals(EmpFirstName.getText())||"  Enter Last Name".equals(EmpLastName.getText())||"  Enter the Address".equals(EmpAddress.getText())||"  Enter the Email".equals(EmpEmail.getText())||"  Enter Login Id".equals(EmpLoginId.getText())||"  Enter Password".equals(EmpPassword.getText())||"  Enter Contact no".equals(EmpContact.getText())||"  Enter the Security Question".equals(EmpSecurityQ.getText())||"  Enter the Answer".equals(EmpAnswer.getText()))
    {
        JOptionPane.showMessageDialog(this, "Missing Information");
    }
    else{
        try {
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
            String Query = "Update User1.MANAGEEMPLOYEETB set FIRST_NAME='"+EmpFirstName.getText()+"'"+",LAST_NAME='"+EmpLastName.getText()+"'"+",ADDRESS='"+EmpAddress.getText()+"'"+",EMAIL='"+EmpEmail.getText()+"'"+",PASSWORD='"+EmpPassword.getText()+"'"+",CONTACT="+(EmpContact.getText())+",SECURITYQ='"+EmpSecurityQ.getText()+"'"+",ANSWER='"+EmpAnswer.getText()+"'"+"where LOGIN_ID="+EmpLoginId.getText();
            Statement Add=Con.createStatement();
            Add.executeUpdate(Query);
            SelectSeller();
            JOptionPane.showMessageDialog(this, "Employee Details Updated Successfully");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
      
    }//GEN-LAST:event_UpdateActionPerformed

    private void EmpAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpAddActionPerformed
      if(EmpFirstName.getText().isEmpty()||EmpLastName.getText().isEmpty()||EmpAddress.getText().isEmpty()||EmpEmail.getText().isEmpty()||EmpLoginId.getText().isEmpty()||EmpPassword.getText().isEmpty()||EmpContact.getText().isEmpty()||EmpSecurityQ.getText().isEmpty()||EmpAnswer.getText().isEmpty()||"  Enter First Name".equals(EmpFirstName.getText())||"  Enter Last Name".equals(EmpLastName.getText())||"  Enter the Address".equals(EmpAddress.getText())||"  Enter the Email".equals(EmpEmail.getText())||"  Enter Login Id".equals(EmpLoginId.getText())||"  Enter Password".equals(EmpPassword.getText())||"  Enter Contact no".equals(EmpContact.getText())||"  Enter the Security Question".equals(EmpSecurityQ.getText())||"  Enter the Answer".equals(EmpAnswer.getText()))
      {
           JOptionPane.showMessageDialog(this, "Missing Information");
      }
      else{
          try {
        Con = DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
        PreparedStatement add = Con.prepareStatement("insert into MANAGEEMPLOYEETB values (?,?,?,?,?,?,?,?,?)");
        add.setString(1,EmpFirstName.getText());// TODO add your handling code here:
        add.setString(2,EmpLastName.getText());
        add.setString(3,EmpAddress.getText());
        add.setString(4,EmpEmail.getText());
        add.setInt(5,Integer.valueOf(EmpLoginId.getText()));
        add.setString(6,EmpPassword.getText());
        add.setInt(7,Integer.valueOf(EmpContact.getText()));
        add.setString(8,EmpSecurityQ.getText());
        add.setString(9,EmpAnswer.getText());
        int row;
        row = add.executeUpdate();
        JOptionPane.showMessageDialog(this, "Employee Details Added Successfully");
        Con.close();
        SelectSeller();      
      }
      catch (Exception e){
    e.printStackTrace();
}
      }
  // TODO add your handling code here:
    }//GEN-LAST:event_EmpAddActionPerformed

    private void EmpTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmpTableMouseClicked
        DefaultTableModel Model=(DefaultTableModel) EmpTable.getModel();
        int Myindex = EmpTable.getSelectedRow(); 
        EmpFirstName.setText(Model.getValueAt(Myindex,0).toString());
        EmpFirstName.setForeground(new Color(0,0,0));
        EmpLastName.setText(Model.getValueAt(Myindex,1).toString());
        EmpLastName.setForeground(new Color(0,0,0));
        EmpAddress.setText(Model.getValueAt(Myindex,2).toString());
        EmpAddress.setForeground(new Color(0,0,0));
        EmpEmail.setText(Model.getValueAt(Myindex,3).toString());
        EmpEmail.setForeground(new Color(0,0,0));
        EmpLoginId.setText(Model.getValueAt(Myindex,4).toString());
        EmpLoginId.setForeground(new Color(0,0,0));
        EmpPassword.setText(Model.getValueAt(Myindex,5).toString());
        EmpPassword.setForeground(new Color(0,0,0));
        EmpContact.setText(Model.getValueAt(Myindex,6).toString());
        EmpContact.setForeground(new Color(0,0,0));
        EmpSecurityQ.setText(Model.getValueAt(Myindex,7).toString());
        EmpSecurityQ.setForeground(new Color(0,0,0));
        EmpAnswer.setText(Model.getValueAt(Myindex,8).toString());
        EmpAnswer.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_EmpTableMouseClicked

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        EmpFirstName.setText("  Enter First Name");
        EmpFirstName.setForeground(new Color(153,153,153));
        EmpLastName.setText("  Enter Last Name");
        EmpLastName.setForeground(new Color(153,153,153));
        EmpAddress.setText("  Enter the Address");
        EmpAddress.setForeground(new Color(153,153,153));
        EmpEmail.setText("  Enter the Email");
        EmpEmail.setForeground(new Color(153,153,153));
        EmpLoginId.setText("  Enter Login Id");
        EmpLoginId.setForeground(new Color(153,153,153));
        EmpPassword.setText("  Enter Password");
        EmpPassword.setForeground(new Color(153,153,153));
        EmpContact.setText("  Enter Contact no");
        EmpContact.setForeground(new Color(153,153,153));
        EmpSecurityQ.setText("  Enter the Security Question");
        EmpSecurityQ.setForeground(new Color(153,153,153));
        EmpAnswer.setText("  Enter the Answer");
        EmpAnswer.setForeground(new Color(153,153,153));
    }//GEN-LAST:event_ClearActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
      if("  Enter Login Id".equals(EmpLoginId.getText()))
      {
           JOptionPane.showMessageDialog(this, "Enter the Employee Login ID to be delete the Employee");
      }
      else{
          try{
               Con = DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
               String SId=EmpLoginId.getText();
               String Query="Delete from User1.MANAGEEMPLOYEETB where LOGIN_ID="+SId;
               Statement Add=Con.createStatement();
               Add.executeUpdate(Query);
               SelectSeller();
               JOptionPane.showMessageDialog(this, "Employee Details Deleted Successfully");
          }catch(Exception e)
          {
              e.printStackTrace();
          }
      }
    }//GEN-LAST:event_DeleteActionPerformed

    private void EmpFirstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpFirstNameFocusGained
        // TODO add your handling code here:
        if(EmpFirstName.getText().equals("  Enter First Name"))
        {
            EmpFirstName.setText("");
            EmpFirstName.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_EmpFirstNameFocusGained

    private void EmpFirstNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpFirstNameFocusLost
        // TODO add your handling code here:
         if(EmpFirstName.getText().equals(""))
        {
            EmpFirstName.setText("  Enter First Name");
            EmpFirstName.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_EmpFirstNameFocusLost

    private void EmpLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpLastNameFocusGained
        // TODO add your handling code here:
         if(EmpLastName.getText().equals("  Enter Last Name"))
        {
            EmpLastName.setText("");
            EmpLastName.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_EmpLastNameFocusGained

    private void EmpLastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpLastNameFocusLost
        // TODO add your handling code here:
        if(EmpLastName.getText().equals(""))
        {
            EmpLastName.setText("  Enter Last Name");
            EmpLastName.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_EmpLastNameFocusLost

    private void EmpAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpAddressFocusGained
          if(EmpAddress.getText().equals("  Enter the Address"))
        {
            EmpAddress.setText("");
            EmpAddress.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_EmpAddressFocusGained

    private void EmpAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpAddressFocusLost
        if(EmpAddress.getText().equals(""))
        {
           EmpAddress.setText("  Enter the Address");
           EmpAddress.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_EmpAddressFocusLost

    private void EmpEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpEmailFocusGained
         if(EmpEmail.getText().equals("  Enter the Email"))
        {
            EmpEmail.setText("");
            EmpEmail.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_EmpEmailFocusGained

    private void EmpEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpEmailFocusLost
         if(EmpEmail.getText().equals(""))
        {
           EmpEmail.setText("  Enter the Email");
           EmpEmail.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_EmpEmailFocusLost

    private void EmpLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpLastNameActionPerformed

    private void EmpContactFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpContactFocusGained
         if(EmpContact.getText().equals("  Enter Contact no"))
        {
           EmpContact.setText("");
            EmpContact.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_EmpContactFocusGained

    private void EmpLoginIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpLoginIdFocusLost
        if(EmpLoginId.getText().equals(""))
        {
           EmpLoginId.setText("  Enter Login Id");
           EmpLoginId.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_EmpLoginIdFocusLost

    private void EmpContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpContactFocusLost
        if(EmpContact.getText().equals(""))
        {
           EmpContact.setText("  Enter Contact no");
           EmpContact.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_EmpContactFocusLost

    private void EmpLoginIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpLoginIdFocusGained
        if(EmpLoginId.getText().equals("  Enter Login Id"))
        {
           EmpLoginId.setText("");
           EmpLoginId.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_EmpLoginIdFocusGained

    private void EmpPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpPasswordFocusGained
        if(EmpPassword.getText().equals("  Enter Password"))
        {
           EmpPassword.setText("");
          EmpPassword.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_EmpPasswordFocusGained

    private void EmpPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpPasswordFocusLost
        // TODO add your handling code here:
        if(EmpPassword.getText().equals(""))
        {
           EmpPassword.setText("  Enter Password");
           EmpPassword.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_EmpPasswordFocusLost

    private void EmpSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmpSearchKeyReleased
        DefaultTableModel Model=(DefaultTableModel) EmpTable.getModel();
        String search = EmpSearch.getText();
        TableRowSorter<DefaultTableModel> tr= new TableRowSorter <DefaultTableModel>(Model);
        EmpTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_EmpSearchKeyReleased

    private void EmpSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpSearchFocusGained
        if(EmpSearch.getText().equals("  Search Employee"))
        {
           EmpSearch.setText("");
          EmpSearch.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_EmpSearchFocusGained

    private void EmpAnswerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpAnswerFocusGained
        if(EmpAnswer.getText().equals("  Enter the Answer"))
        {
           EmpAnswer.setText("");
          EmpAnswer.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_EmpAnswerFocusGained

    private void EmpAnswerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpAnswerFocusLost
        if(EmpAnswer.getText().equals(""))
        {
           EmpAnswer.setText("  Enter the Answer");
           EmpAnswer.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_EmpAnswerFocusLost

    private void EmpAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpAnswerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpAnswerActionPerformed

    private void EmpSecurityQFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpSecurityQFocusGained
        if(EmpSecurityQ.getText().equals("  Enter the Security Question"))
        {
           EmpSecurityQ.setText("");
          EmpSecurityQ.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_EmpSecurityQFocusGained

    private void EmpSecurityQFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpSecurityQFocusLost
        if(EmpSecurityQ.getText().equals(""))
        {
           EmpSecurityQ.setText("  Enter the Security Question");
           EmpSecurityQ.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_EmpSecurityQFocusLost

    private void EmpSecurityQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpSecurityQActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpSecurityQActionPerformed

    private void EmpSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmpSearchFocusLost
        if(EmpSearch.getText().equals(""))
        {
           EmpSearch.setText("  Search Employee");
           EmpSearch.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_EmpSearchFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton Delete;
    private javax.swing.JButton EmpAdd;
    private javax.swing.JTextArea EmpAddress;
    private javax.swing.JTextField EmpAnswer;
    private javax.swing.JTextField EmpContact;
    private javax.swing.JTextField EmpEmail;
    private javax.swing.JTextField EmpFirstName;
    private javax.swing.JTextField EmpLastName;
    private javax.swing.JTextField EmpLoginId;
    private javax.swing.JTextField EmpPassword;
    private javax.swing.JTextField EmpSearch;
    private javax.swing.JTextField EmpSecurityQ;
    private javax.swing.JTable EmpTable;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
