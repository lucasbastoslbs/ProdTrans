
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormLista extends javax.swing.JFrame {

    MySQLR mysqlr = new MySQLR();
    DefaultTableModel modelDisp, modelSep;
    String numero;
    
    public FormLista() {
        initComponents();
        setLocationRelativeTo(this);
        jButtonFinalizar.setVisible(false);
        boolean x = mysqlr.connect("localhost", "3306", "ProdTrans", "root", "1234rewq");
        listarcombo();
        
        modelDisp = (DefaultTableModel)(jTableDisponiveis.getModel());
        modelSep = (DefaultTableModel)(jTableSeparados.getModel());
        listarprodutos();
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jComboMercado = new javax.swing.JComboBox<>();
        jButtonSeparar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonFinalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDisponiveis = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSeparados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonConfirmarMercado = new javax.swing.JButton();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NOVA LISTA");

        jButtonSeparar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonSeparar.setText("-->");
        jButtonSeparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSepararActionPerformed(evt);
            }
        });

        jButtonRemover.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonRemover.setText("<--");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Produtos disponíveis");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Produtos separados");

        jButtonFinalizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonFinalizar.setText("Finalizar");
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });

        jTableDisponiveis.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jTableDisponiveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDisponiveis);

        jTableSeparados.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jTableSeparados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableSeparados);

        jButtonConfirmarMercado.setText("Confirmar mercado");
        jButtonConfirmarMercado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarMercadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel3)
                        .addGap(412, 412, 412))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jComboMercado, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(223, 223, 223)))
                .addGroup(layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButtonSeparar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(43, 43, 43)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButtonFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(40, 40, 40)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonConfirmarMercado)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboMercado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConfirmarMercado))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jButtonFinalizar)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jButtonSeparar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSepararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSepararActionPerformed
        int linha = jTableDisponiveis.getSelectedRow();
        modelSep.addRow(new String[]{modelDisp.getValueAt(linha, 0)+""});
    }//GEN-LAST:event_jButtonSepararActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        int linha = jTableSeparados.getSelectedRow();
        modelSep.removeRow(linha);
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        ResultSet rs;
        String IDProduto=null;
        
        for(int i=0; i < jTableSeparados.getRowCount();i++){
            rs = mysqlr.executeQuery("SELECT id FROM produto WHERE nome ='"+modelSep.getValueAt(i, 0)+"'");
            try{
                IDProduto = rs.getString("id");
            }catch(SQLException e) {
                JOptionPane.showMessageDialog(this, "Erro ao ler mercado: " + e);
            }
            mysqlr.inserirPedido(numero,IDProduto);
        }
        
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

    private void jButtonConfirmarMercadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarMercadoActionPerformed
        String IDMercado=null;
        ResultSet rs = mysqlr.executeQuery("SELECT * FROM mercado WHERE nome ='"+jComboMercado.getSelectedItem().toString()+"'");
        try{
            IDMercado = rs.getString("id");
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao ler mercado: " + e);
        }
        int ok = mysqlr.criarLista(IDMercado);
        if(ok == 1){
            JOptionPane.showMessageDialog(null, jComboMercado.getSelectedItem()+" selecionado!");
            //jLabel1.setText("Lista: "+numero);
            jButtonFinalizar.setVisible(true);
        }
    }//GEN-LAST:event_jButtonConfirmarMercadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public void listarcombo(){
        ResultSet rs = mysqlr.executeQuery("SELECT nome FROM mercado ORDER BY nome ASC");
        if( rs != null){
            try{
                while(rs.next()){
                    jComboMercado.addItem(rs.getString("nome"));
                }
            }catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Erro ao carregar lista de mercados: " + e);
            }
        }
    }
    
    public void listarprodutos(){
        ResultSet rs = mysqlr.executeQuery("SELECT nome FROM produto ORDER BY nome ASC");
        if( rs != null){
            try{
                while(rs.next()){
                    modelDisp.addRow(new String[]{rs.getString("nome")});
                }
            }catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Erro ao carregar lista de produtos: " + e);
            }
        }
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
            java.util.logging.Logger.getLogger(FormLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonConfirmarMercado;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonSeparar;
    private javax.swing.JComboBox<String> jComboMercado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableDisponiveis;
    private javax.swing.JTable jTableSeparados;
    // End of variables declaration//GEN-END:variables

}
