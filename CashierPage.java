package changeToYourPackageName;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HalamanKasir extends javax.swing.JFrame {

    public DBConnection dbcon = new DBConnection();
    public String idCashier, name;
    public int totalCost=0;
    public ArrayList<Integer> idFoodMenu = new ArrayList<>();
    public ArrayList<Integer> idDrinkMenu = new ArrayList<>();
    public ArrayList<Integer> listReservedIdMenu = new ArrayList<>();
    public DefaultTableModel Food = new DefaultTableModel();   
    public DefaultTableModel Drink = new DefaultTableModel();
    public DefaultTableModel Reserved = new DefaultTableModel();
    
    public HalamanKasir() {
        initComponents();
        dbcon.connectDatabase();
    }

    public HalamanKasir(int idCashier, String name) {
        initComponents();
        dbcon.connectDatabase();
        jLabel9.setText(name);
        ID=Integer.toString(idCashier);
        this.name=name;
        showFood();
        showDrink();
        showReserved();
    }
    
    public HalamanKasir(String idCashier, String name) {
        initComponents();
        dbcon.connectDatabase();
        jLabel9.setText(name);
        ID=idCashier;
        this.name=name;
        showFood();
        showDrink();
        showReserved();
    }
    
    private void tampilMakanan(){
        Makanan.addColumn("NAME");
        Makanan.addColumn("PRICE");
        jTable3.setModel(Food);
        jTable3.getColumnModel().getColumn(0).setResizable(false);
        jTable3.getColumnModel().getColumn(1).setResizable(false);
        jTable3.getColumnModel().getColumn(1).setPreferredWidth(15);
        jTable3.setCellSelectionEnabled(true);
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        try{
            Statement stmt = con.getConnection().
                    createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rslt = stmt.executeQuery("SELECT IDMENU, NAME, HARGA FROM MENU "
                    + "WHERE CATEGORY LIKE 'Food'");

            while(rslt.next()){
                idFoodMenu.add(rslt.getInt("IDMENU"));
                
                Food.addRow(new Object [] {
                    rslt.getString("NAME"),
                    rslt.getString("PRICE")
                });
            }
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, 
                "Can't fetch data",
                se.getMessage(),
                JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void tampilMinuman(){
        Minuman.addColumn("NAME");
        Minuman.addColumn("PRICE");
        jTable4.setModel(Drink);
        jTable4.setCellSelectionEnabled(true);
        jTable4.getColumnModel().getColumn(0).setResizable(false);
        jTable4.getColumnModel().getColumn(1).setResizable(false);
        jTable4.getColumnModel().getColumn(1).setPreferredWidth(15);        
        try{
            Statement stmt = con.getConnection().
                    createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rslt = stmt.executeQuery("SELECT IDMENU, NAME, HARGA FROM MENU "
                    + "WHERE CATEGORY LIKE 'Drink'");

            while(rslt.next()){
                idDrinkMenu.add(rslt.getInt("IDMENU"));
                
                Drink.addRow(new Object [] {
                    rslt.getString("NAME"),
                    rslt.getString("PRICE")
                });
            }
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, 
                "Can't fetch data",
                se.getMessage(),
                JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    private void tampilPesanan(){
        Pesanan.addColumn("MENU NAME");
        Pesanan.addColumn("PRICE");
        Pesanan.addColumn("PCS");
        Pesanan.addColumn("TOTAL PRICE");
        jTable2.setModel(Pesanan);
        jTable2.getColumnModel().getColumn(0).setResizable(false);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTable2.getColumnModel().getColumn(1).setResizable(false);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(70);        
        jTable2.getColumnModel().getColumn(2).setResizable(false);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(10);
        jTable2.getColumnModel().getColumn(3).setResizable(false);
        jTable2.getColumnModel().getColumn(3).setPreferredWidth(30);        
    }
    
    /**
     * Because this form written and designed in Netbeans, every method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 50));
        setUndecorated(true);
        setResizable(false);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable2.setCellSelectionEnabled(true);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable3.setColumnSelectionAllowed(true);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);
        jTable3.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("DAFTAR MENU");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("INPUT PESANAN PELANGGAN");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("MAKANAN");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("MINUMAN\n");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable4.setCellSelectionEnabled(true);
        jTable4.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable4);
        jTable4.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("DAFTAR PESANAN PELANGGAN");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("TOTAL");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Rp");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton1.setText("LANJUT");
        jButton1.setMaximumSize(new java.awt.Dimension(144, 23));
        jButton1.setPreferredSize(new java.awt.Dimension(103, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("HAPUS PESANAN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("HAPUS SEMUA");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setText("Kasir  :");

        jLabel9.setText("<nama>");

        jButton2.setText("TAMBAHKAN KE DAFTAR PESANAN");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(105, 105, 105))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1))
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(1, 1, 1)
                        .addComponent(jButton4)
                        .addGap(2, 2, 2)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        int ind1[],ind2[];
        ind1 = jTable3.getSelectedRows();
        ind2 = jTable4.getSelectedRows();
        
        if(ind1.length!=0 && ind2.length==0){
            for (int i = 0; i < ind1.length; i++){
                listReservedIdMenu.add(idFoodMenu.get(ind1[i]));
                
                Reserved.addRow(new Object [] {
                    jTable3.getValueAt(ind1[i], 0),
                    jTable3.getValueAt(ind1[i], 1),
                    1,
                    jTable3.getValueAt(ind1[i], 1)
                });
                totalCost=totalCost+Integer.parseInt(
                        jTable3.getValueAt(ind1[i], 1).toString()
                );
            }
            jTextField1.setText(Integer.toString(totalCost));
        }else if(ind2.length!=0 && ind1.length==0){
            for (int i = 0; i < ind2.length; i++){
                listReservedIdMenu.add(idDrinkMenu.get(ind2[i]));
                
                Reserved.addRow(new Object [] {
                    jTable4.getValueAt(ind2[i], 0),
                    jTable4.getValueAt(ind2[i], 1),
                    1,
                    jTable4.getValueAt(ind2[i], 1)
                });
                totalCost=totalCost+Integer.parseInt(
                        jTable4.getValueAt(ind2[i], 1).toString()
                );                
            }
            jTextField1.setText(Integer.toString(totalCost));
        }else if(ind1.length!=0 && ind2.length!=0){
            for (int i = 0; i < ind1.length; i++){
                listReservedIdMenu.add(idFoodMenu.get(ind1[i]));
                
                Reserved.addRow(new Object [] {
                    jTable3.getValueAt(ind1[i], 0),
                    jTable3.getValueAt(ind1[i], 1),
                    1,
                    jTable3.getValueAt(ind1[i], 1)
                });
                totalCost=totalCost+Integer.parseInt(
                        jTable3.getValueAt(ind1[i], 1).toString()
                );
            }
            
            for (int i = 0; i < ind2.length; i++){
                listIdMenuPesanan.add(idMenuMinuman.get(ind2[i]));
                
                Reserved.addRow(new Object [] {
                    jTable4.getValueAt(ind2[i], 0),
                    jTable4.getValueAt(ind2[i], 1),
                    1,
                    jTable4.getValueAt(ind2[i], 1)
                });
                totalCost=totalCost+Integer.parseInt(
                        jTable4.getValueAt(ind2[i], 1).toString()
                );
            }
            jTextField1.setText(Integer.toString(totalCost));
        }
    }                                        

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {                                   
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            int total=0,sum=0,price=0,totalTemp;
            for(int i = 0; i < jTable2.getRowCount(); i++) {
                totalTemp=0;
                sum=Integer.parseInt(jTable2.getValueAt(i,2).toString());
                price=Integer.parseInt(jTable2.getValueAt(i,1).toString());
                totalTemp=sum*price;
                jTable2.setValueAt(totalTemp, i, 3);
                total=total+totalTemp;
            }
            totalCost=total;
            jTextField1.setText(Integer.toString(total));
        }
    }                                  

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        int del[] = jTable2.getSelectedRows();
        for(int i = 0; i < hapus.length; i++) {
            int price=Integer.parseInt(jTable2.getValueAt(i,3).toString());
            totalCost=totalCost-price;
            Pesanan.removeRow(i);
            
            listIdMenuPesanan.remove(i);
        }
        jTextField1.setText(Integer.toString(totalCost));
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Pesanan.setRowCount(0);
        totalCost=0;
        jTextField1.setText("0");
        listIdMenuPesanan=null;
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Vector<Vector> listReserved=Reserved.getDataVector();
        new HalamanNotaPelanggan(listReservedIdMenu,listReserved,idCashier,name,totalCost).setVisible(true);
        this.setVisible(false);
    }                                        

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
            java.util.logging.Logger.getLogger(HalamanKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HalamanKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HalamanKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HalamanKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HalamanKasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}
