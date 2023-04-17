/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpp.project1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Priyansh
 */
public class Billing_pointt extends javax.swing.JFrame {

    /**
     * Creates new form Billing_pointt
     */
    String Recommendation;
    double ProdTot=0,GrandTotal=0;
    int i; 
    Connection Con= null;
    Statement St= null;
    ResultSet Rs=null;
    
    public void getRec(){
        try{
            Con=DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
            St=Con.createStatement();
            String query="Select * from User1.MANAGEITEMTTB where ITEM_CODE='"+ItemCode.getText()+"'";
            Rs=St.executeQuery(query);
            while(Rs.next()){
                Recommendation=Rs.getString("RECOMMENDATION");
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void SetBillNo(){
        try{
            Con=DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
            St=Con.createStatement();
            String query="Select * from User1.BILLS";
            Rs=St.executeQuery(query);
            if(Rs.next()){
                do{
                    int Temp=Rs.getInt("BILL_NO");
                    BillNo.setText(Integer.toString(Temp+1));
                }while(Rs.next());
            }
            else{
                BillNo.setText("1");
            }
            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void savebill(){
        try{
            FileWriter Writer=new FileWriter("Bill No."+BillNo.getText()+".txt",true);
            Writer.write(BillText.getText());
            Writer.close();
            JOptionPane.showMessageDialog(this, "Bill Saved");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        try {
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
            PreparedStatement add = Con.prepareStatement("insert into BILLS values (?,?,?)");
            add.setInt(1,Integer.valueOf(BillNo.getText()));// TODO add your handling code here:
            add.setString(2,CustomerName.getText());
            add.setString(3,CustomerPhone.getText());   
            add.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void SelectedItem(){
        try{
            Con=DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
            St=Con.createStatement();
            Rs=St.executeQuery("Select * from User1.CUSTOMER");
            SelectedItems.setModel(DbUtils.resultSetToTableModel(Rs));
            theader();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void CustomerBill(){
        i++;
        Date obj=new Date();
        String date=obj.toString();
        if(i==1){     
            BillText.setText(BillText.getText()+"\t"+"                   Grocery Store\n"+"*******************************************************\n"+"   Name-"+CustomerName1.getText()+"\t"+"Ph. No."+CustomerPhone1.getText()+"\n*******************************************************\n"+date+"\t"+"Bill No."+BillNo.getText()+"\n*******************************************************\n"+"   Product"+"\t"+"Price"+"\t"+"Quantity"+"\t"+"Amount\n");
            DefaultTableModel model=(DefaultTableModel) SelectedItems.getModel();
            for(int i=0;i<SelectedItems.getRowCount();i++)
            {
                String Name=SelectedItems.getValueAt(i,1).toString();
                String Price=SelectedItems.getValueAt(i,3).toString();
                String Quantity=SelectedItems.getValueAt(i,4).toString();
                Double ProdTotal=Double.valueOf(Price)*Integer.valueOf(Quantity);
                GrandTotal=GrandTotal+ProdTotal;
                TotalAmount.setText(Double.toString(GrandTotal));
                BillText.setText(BillText.getText()+Name+"\t"+Price+"\t"+Quantity+"\t"+ProdTotal.toString()+"\n");
            }
        }
        else{
            DefaultTableModel model=(DefaultTableModel) SelectedItems.getModel();
            for(int i=0;i<SelectedItems.getRowCount();i++)
            {
                String Name=SelectedItems.getValueAt(i,1).toString();
                String Price=SelectedItems.getValueAt(i,3).toString();
                String Quantity=SelectedItems.getValueAt(i,4).toString();
                Double ProdTotal=Double.valueOf(Price)*Integer.valueOf(Quantity);
                GrandTotal=GrandTotal+ProdTotal;
                TotalAmount.setText(Double.toString(GrandTotal));
                BillText.setText(BillText.getText()+Name+"\t"+Price+"\t"+Quantity+"\t"+ProdTotal.toString()+"\n");
            }
            try{
                Con=DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
                St=Con.createStatement();
                St.executeUpdate("delete from User1.CUSTOMER");
                JOptionPane.showMessageDialog(this, "All Items are Added");
                SelectedItem();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public void SelectItem(){
        try{
            Con=DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
            St=Con.createStatement();
            Rs=St.executeQuery("Select ITEM_CODE,ITEM_NAME,ITEM_CATEGORY,SELLING_PRICE,QUANTITY,DESCRIPTION  from User1.MANAGEITEMTTB");
            ItemTable.setModel(DbUtils.resultSetToTableModel(Rs));
            theader();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void Update(){
        try {
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
            String Query = "Update User1.MANAGEITEMTTB set QUANTITY=(QUANTITY-"+ItemQuantity.getValue().toString()+")"+"where ITEM_CODE='"+ItemCode.getText()+"'";
            Statement Add=Con.createStatement();
            Add.executeUpdate(Query);
            SelectItem();
            String left=Integer.toString(Integer.valueOf(AvailableQuantity.getText())-Integer.valueOf(ItemQuantity.getValue().toString()));
            AvailableQuantity.setText(left);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    
    }
    
    public void GetCat(){
        try{
            Con=DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
            St=Con.createStatement();
            String query="Select * from User1.MANAGECATEGORYTB";
            Rs=St.executeQuery(query);
            while(Rs.next()){
                String MyCat=Rs.getString("CATEGORY_NAME");
                ItemCategory.addItem(MyCat);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void FilterItems(){
        if(ItemCategory.getSelectedItem()=="All")
        {
            SelectItem();
        }
        else
        {
            try{
                Con=DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
                St=Con.createStatement();
                Rs=St.executeQuery("Select ITEM_CODE,ITEM_NAME,ITEM_CATEGORY,SELLING_PRICE,QUANTITY,DESCRIPTION from User1.MANAGEITEMTTB where ITEM_CATEGORY='"+ItemCategory.getSelectedItem()+"'");
                ItemTable.setModel(DbUtils.resultSetToTableModel(Rs));
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public Billing_pointt() {
        initComponents();
        SelectItem();
        GetCat();
        SelectedItem();
        SetBillNo();
        BillText.setFont(new Font("Serif", Font.BOLD, 22));
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
        jLabel5 = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        BillText = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        TotalAmount = new javax.swing.JTextField();
        BalanceAmount = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        PaidAmount = new javax.swing.JTextField();
        Print = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ItemTable = new javax.swing.JTable();
        ItemCategory = new javax.swing.JComboBox<>();
        ItemSearch = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        ItemName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ItemCode = new javax.swing.JTextField();
        ItemPrice = new javax.swing.JTextField();
        AvailableQuantity = new javax.swing.JTextField();
        ItemQuantity = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Clear = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        CustomerPhone = new javax.swing.JTextField();
        CustomerName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        CustomerPhone1 = new javax.swing.JTextField();
        CustomerName1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        SelectedItems = new javax.swing.JTable();
        Add1 = new javax.swing.JButton();
        BillNo = new javax.swing.JTextField();
        ClearBill = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Billing ");

        Logout.setBackground(new java.awt.Color(0, 0, 102));
        Logout.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Logout.setForeground(new java.awt.Color(255, 255, 255));
        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cpp/project1/icons/icons8_logout_rounded_left_30px.png"))); // NOI18N
        Logout.setText("LOGOUT");
        Logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logout)
                .addGap(478, 478, 478)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Logout))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        BillText.setColumns(20);
        BillText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BillText.setRows(5);
        BillText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 2));
        jScrollPane3.setViewportView(BillText);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setText("BILL NO:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Balance Amount");

        TotalAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TotalAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        TotalAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalAmountActionPerformed(evt);
            }
        });

        BalanceAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BalanceAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Total Amount");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Paid Amount");

        PaidAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PaidAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));

        Print.setBackground(new java.awt.Color(0, 0, 102));
        Print.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        Print.setForeground(new java.awt.Color(255, 255, 255));
        Print.setText("Print");
        Print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });

        Save.setBackground(new java.awt.Color(0, 0, 102));
        Save.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        Save.setForeground(new java.awt.Color(255, 255, 255));
        Save.setText("SAVE");
        Save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PaidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BalanceAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Print, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TotalAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(PaidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BalanceAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Print, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        ItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Code", "Name", "Category", "Selling Price", "Quantity", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ItemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ItemTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ItemTable);

        ItemCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        ItemCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ItemCategoryItemStateChanged(evt);
            }
        });
        ItemCategory.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ItemCategoryFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ItemCategoryFocusLost(evt);
            }
        });
        ItemCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ItemCategoryMouseClicked(evt);
            }
        });
        ItemCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemCategoryActionPerformed(evt);
            }
        });

        ItemSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ItemSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        ItemSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ItemSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ItemSearchFocusLost(evt);
            }
        });
        ItemSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemSearchActionPerformed(evt);
            }
        });
        ItemSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ItemSearchKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Select Category");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Search Item ");

        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 0, new java.awt.Color(0, 0, 102)));

        ItemName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ItemName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        ItemName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ItemNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ItemNameFocusLost(evt);
            }
        });
        ItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemNameActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Item Name");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText(" Quantity");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Item Code");

        ItemCode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ItemCode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        ItemCode.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                ItemCodeInputMethodTextChanged(evt);
            }
        });
        ItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemCodeActionPerformed(evt);
            }
        });
        ItemCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ItemCodeKeyReleased(evt);
            }
        });

        ItemPrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ItemPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));

        AvailableQuantity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AvailableQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Selling Price");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Available Quantity");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel11)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel9))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel13)))
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AvailableQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(jLabel10)
                .addGap(35, 35, 35)
                .addComponent(ItemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(ItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(ItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(AvailableQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(ItemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        Clear.setBackground(new java.awt.Color(0, 0, 102));
        Clear.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        Clear.setForeground(new java.awt.Color(255, 255, 255));
        Clear.setText("clear");
        Clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        Add.setBackground(new java.awt.Color(0, 0, 102));
        Add.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        Add.setForeground(new java.awt.Color(255, 255, 255));
        Add.setText("add to bill");
        Add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(ItemSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(jLabel7)
                .addGap(33, 33, 33)
                .addComponent(ItemCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ItemSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(ItemCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        CustomerPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CustomerPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        CustomerPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CustomerPhoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CustomerPhoneFocusLost(evt);
            }
        });
        CustomerPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerPhoneActionPerformed(evt);
            }
        });

        CustomerName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CustomerName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        CustomerName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CustomerNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CustomerNameFocusLost(evt);
            }
        });
        CustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerNameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("PHONE NO");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("NAME");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("    Product details:-");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(jLabel4)
                .addGap(28, 28, 28)
                .addComponent(CustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(CustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(CustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("    Customer Details:-");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Employee", jPanel7);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setText("    Customer Details:-");
        jLabel17.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));

        CustomerPhone1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CustomerPhone1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        CustomerPhone1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CustomerPhone1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CustomerPhone1FocusLost(evt);
            }
        });
        CustomerPhone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerPhone1ActionPerformed(evt);
            }
        });

        CustomerName1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CustomerName1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        CustomerName1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CustomerName1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CustomerName1FocusLost(evt);
            }
        });
        CustomerName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerName1ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("PHONE NO");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("NAME");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel20.setText("    Product details:-");
        jLabel20.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CustomerName1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(jLabel18)
                .addGap(28, 28, 28)
                .addComponent(CustomerPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 279, Short.MAX_VALUE))
            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(CustomerName1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(CustomerPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        SelectedItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Code", "Name", "Category", "Selling Price", "Quantity", "Description"
            }
        ));
        SelectedItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelectedItemsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(SelectedItems);

        Add1.setBackground(new java.awt.Color(0, 0, 102));
        Add1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        Add1.setForeground(new java.awt.Color(255, 255, 255));
        Add1.setText("add to bill");
        Add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(560, 560, 560)
                        .addComponent(Add1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Add1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Customer", jPanel8);

        BillNo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        BillNo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 102)));
        BillNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BillNoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BillNoFocusLost(evt);
            }
        });
        BillNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillNoActionPerformed(evt);
            }
        });

        ClearBill.setBackground(new java.awt.Color(0, 0, 102));
        ClearBill.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        ClearBill.setForeground(new java.awt.Color(255, 255, 255));
        ClearBill.setText("CLEAR BILL");
        ClearBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClearBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BillNo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(ClearBill)
                        .addGap(13, 13, 13))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BillNo)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(ClearBill, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTabbedPane1)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BillNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BillNoFocusGained
    
    }//GEN-LAST:event_BillNoFocusGained

    private void BillNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BillNoFocusLost
       
    }//GEN-LAST:event_BillNoFocusLost
  private void theader()
        {
            JTableHeader thead =ItemTable.getTableHeader();
            thead.setForeground(new Color(0,0,102));
            thead.setFont(new Font("Tahoma",Font.BOLD,14));
        }
    private void BillNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BillNoActionPerformed

    private void CustomerNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CustomerNameFocusGained
       
    }//GEN-LAST:event_CustomerNameFocusGained

    private void CustomerNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CustomerNameFocusLost
      
    }//GEN-LAST:event_CustomerNameFocusLost

    private void CustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerNameActionPerformed

    private void CustomerPhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CustomerPhoneFocusGained
       
    }//GEN-LAST:event_CustomerPhoneFocusGained

    private void CustomerPhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CustomerPhoneFocusLost
        
    }//GEN-LAST:event_CustomerPhoneFocusLost

    private void CustomerPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerPhoneActionPerformed

    private void ItemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemTableMouseClicked
        DefaultTableModel Model=(DefaultTableModel) ItemTable.getModel();
        int Myindex = ItemTable.getSelectedRow();
        ItemName.setText(Model.getValueAt(Myindex,1).toString());
        ItemCode.setText(Model.getValueAt(Myindex,0).toString());
        ItemPrice.setText(Model.getValueAt(Myindex,3).toString());
        AvailableQuantity.setText(Model.getValueAt(Myindex,4).toString());
        getRec();
        ItemQuantity.setValue(0);
    }//GEN-LAST:event_ItemTableMouseClicked

    private void ItemNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ItemNameFocusGained
        
    }//GEN-LAST:event_ItemNameFocusGained

    private void ItemNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ItemNameFocusLost
        
    }//GEN-LAST:event_ItemNameFocusLost

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        if(ItemName.getText().isEmpty()||"0".equals(ItemQuantity.getValue().toString())||ItemCode.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }
        else{
            if(Integer.valueOf(AvailableQuantity.getText())<Integer.valueOf(ItemQuantity.getValue().toString())){
                JOptionPane.showMessageDialog(this, "Not Enough in the Stock\n"+"Available Stock="+AvailableQuantity.getText());
            }
            else{
                ProdTot=Double.valueOf(ItemPrice.getText())*Integer.valueOf(ItemQuantity.getValue().toString());
                GrandTotal=GrandTotal+ProdTot;
                TotalAmount.setText(Double.toString(GrandTotal));
                i++;
                Date obj=new Date();
                String date=obj.toString();
                if(i==1){
                    BillText.setText(BillText.getText()+"\t"+"                   Grocery Store\n"+"*******************************************************\n"+"   Name-"+CustomerName.getText()+"\t"+"Ph. No."+CustomerPhone.getText()+"\n*******************************************************\n"+"   Date-"+date+"\t"+"Bill No."+BillNo.getText()+"\n*******************************************************\n"+"   Product"+"\t"+"Quantity"+"\t"+"Price"+"\t"+"Amount\n"+ItemName.getText()+"\t"+ItemPrice.getText()+"\t"+ItemQuantity.getValue().toString()+"\t"+ProdTot+"\n");
                }
                else{

                    BillText.setText(BillText.getText()+ItemName.getText()+"\t"+ItemPrice.getText()+"\t"+ItemQuantity.getValue().toString()+"\t"+ProdTot+"\n");
                }
                Update();
            try{
            Con=DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
            St=Con.createStatement();
            String query="Select * from User1.MANAGEITEMTTB where ITEM_CODE='"+Recommendation+"'";
            Rs=St.executeQuery(query);
            if(Rs.next()){
                int answer=JOptionPane.showConfirmDialog(this,"Do you also want to add "+Rs.getString("ITEM_NAME"),"Recommendation",JOptionPane.YES_NO_CANCEL_OPTION);
                if(answer==0){
                    ItemCode.setText(Rs.getString("ITEM_CODE"));
                    ItemCode.requestFocus();
                    ItemName.setText("");
                    ItemPrice.setText("");
                    AvailableQuantity.setText("");
                    ItemQuantity.setValue(0);
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
            }       
    }//GEN-LAST:event_AddActionPerformed
    }
    
    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        ItemName.setText("");
        ItemQuantity.setValue(0);
        ItemCode.setText("");
        ItemPrice.setText("");
        AvailableQuantity.setText("");
    }//GEN-LAST:event_ClearActionPerformed

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        try{
            BillText.print();
        }
        catch(Exception e){

        }
    }//GEN-LAST:event_PrintActionPerformed

    private void ItemCategoryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ItemCategoryFocusGained

    }//GEN-LAST:event_ItemCategoryFocusGained

    private void ItemCategoryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ItemCategoryFocusLost

    }//GEN-LAST:event_ItemCategoryFocusLost

    private void ItemCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemCategoryActionPerformed
       FilterItems();   
    }//GEN-LAST:event_ItemCategoryActionPerformed

    private void ItemSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ItemSearchFocusGained
       
    }//GEN-LAST:event_ItemSearchFocusGained

    private void ItemSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ItemSearchFocusLost
       
    }//GEN-LAST:event_ItemSearchFocusLost

    private void ItemSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemSearchActionPerformed

    private void ItemSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ItemSearchKeyReleased
        DefaultTableModel Model=(DefaultTableModel) ItemTable.getModel();
        String search = ItemSearch.getText();
        TableRowSorter<DefaultTableModel> tr= new TableRowSorter <DefaultTableModel>(Model);
        ItemTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_ItemSearchKeyReleased

    private void ItemCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ItemCategoryItemStateChanged

    }//GEN-LAST:event_ItemCategoryItemStateChanged

    private void ItemCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemCategoryMouseClicked
      
    }//GEN-LAST:event_ItemCategoryMouseClicked

    private void TotalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalAmountActionPerformed

    private void ItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemNameActionPerformed

    private void CustomerPhone1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CustomerPhone1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerPhone1FocusGained

    private void CustomerPhone1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CustomerPhone1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerPhone1FocusLost

    private void CustomerPhone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerPhone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerPhone1ActionPerformed

    private void CustomerName1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CustomerName1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerName1FocusGained

    private void CustomerName1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CustomerName1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerName1FocusLost

    private void CustomerName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerName1ActionPerformed

    private void SelectedItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectedItemsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SelectedItemsMouseClicked

    private void Add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add1ActionPerformed
        CustomerBill();
    }//GEN-LAST:event_Add1ActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        if(PaidAmount.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Enter the Paid Amount");
        }
        else{
            double Balance=Double.valueOf(PaidAmount.getText())-Double.valueOf(TotalAmount.getText());
            BalanceAmount.setText(Double.toString(Balance));
            BillText.setText(BillText.getText()+"*******************************************************\n"+"\t\t"+"Total="+GrandTotal+"\n"+"\t\t"+"Paid Amount="+PaidAmount.getText()+"\n"+"\t\t"+"Balance="+Balance+"\n");
            BillText.setText(BillText.getText()+"******************Thank You Visit Again******************\n"+"\t\t\t");
            savebill();
        }
    }//GEN-LAST:event_SaveActionPerformed

    private void ItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemCodeActionPerformed
        String ItemId=ItemCode.getText();
        try{
            Con=DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
            St=Con.createStatement();
            String query="Select * from User1.MANAGEITEMTTB where ITEM_CODE='"+ItemId+"'";
            Rs=St.executeQuery(query);
            if(Rs.next()){
                ItemName.setText(Rs.getString(2));
                ItemPrice.setText(String.valueOf(Rs.getInt(4)));
                AvailableQuantity.setText(String.valueOf(Rs.getInt(5)));
            }
            else{
                ItemName.setText("");
                ItemPrice.setText("");
                AvailableQuantity.setText("");
                ItemQuantity.setValue(0);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        getRec();
    }//GEN-LAST:event_ItemCodeActionPerformed

    private void ItemCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ItemCodeKeyReleased
        String ItemId=ItemCode.getText();
        try{
            Con=DriverManager.getConnection("jdbc:derby://localhost:1527/grocerystoredb","User1","1234");
            St=Con.createStatement();
            String query="Select * from User1.MANAGEITEMTTB where ITEM_CODE='"+ItemId+"'";
            Rs=St.executeQuery(query);
            if(Rs.next()){
                ItemName.setText(Rs.getString(2));
                ItemPrice.setText(String.valueOf(Rs.getInt(4)));
                AvailableQuantity.setText(String.valueOf(Rs.getInt(5)));
            }
            else{
                ItemName.setText("");
                ItemPrice.setText("");
                AvailableQuantity.setText("");
                ItemQuantity.setValue(0);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        getRec();
    }//GEN-LAST:event_ItemCodeKeyReleased

    private void ItemCodeInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_ItemCodeInputMethodTextChanged
        
    }//GEN-LAST:event_ItemCodeInputMethodTextChanged

    private void ClearBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBillActionPerformed
        BillText.setText("");
        i=0;
        GrandTotal=0;
        TotalAmount.setText(Double.toString(GrandTotal));
        PaidAmount.setText("");
        BalanceAmount.setText("");
        SetBillNo();
    }//GEN-LAST:event_ClearBillActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        int answer=JOptionPane.showConfirmDialog(this,"Are you sure you want to logout?");
        if(answer==0){
            this.dispose();
            Login lgn=new Login();
            lgn.setExtendedState(Login.MAXIMIZED_BOTH);
            lgn.setVisible(true);
        }
    }//GEN-LAST:event_LogoutActionPerformed
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Billing_pointt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Billing_pointt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Billing_pointt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Billing_pointt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Billing_pointt Bp=new Billing_pointt();
                Bp.setExtendedState(StartPage.MAXIMIZED_BOTH);
                Bp.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Add1;
    private javax.swing.JTextField AvailableQuantity;
    private javax.swing.JTextField BalanceAmount;
    private javax.swing.JTextField BillNo;
    private javax.swing.JTextArea BillText;
    private javax.swing.JButton Clear;
    private javax.swing.JButton ClearBill;
    private javax.swing.JTextField CustomerName;
    private javax.swing.JTextField CustomerName1;
    private javax.swing.JTextField CustomerPhone;
    private javax.swing.JTextField CustomerPhone1;
    private javax.swing.JComboBox<String> ItemCategory;
    private javax.swing.JTextField ItemCode;
    private javax.swing.JTextField ItemName;
    private javax.swing.JTextField ItemPrice;
    private javax.swing.JSpinner ItemQuantity;
    private javax.swing.JTextField ItemSearch;
    private javax.swing.JTable ItemTable;
    private javax.swing.JButton Logout;
    private javax.swing.JTextField PaidAmount;
    private javax.swing.JButton Print;
    private javax.swing.JButton Save;
    private javax.swing.JTable SelectedItems;
    private javax.swing.JTextField TotalAmount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
