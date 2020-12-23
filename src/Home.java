import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Home extends javax.swing.JFrame {

    MySQLR mysqlr;
    Connection conn;
    Statement stmt;
    ResultSet rs = null;
    DefaultTableModel model;
    int ID;
    int ok;
    
    public Home() {
        initComponents();
        setLocationRelativeTo(this);
        mysqlr = new MySQLR();
        model = (DefaultTableModel)(jTableLista.getModel());
        conectar();
        listas();
    }
    
    
    public void conectar(){
        boolean connected = mysqlr.connect("localhost", "3306", "ProdTrans", "root", "1234rewq");
        if (connected) {
            jLabelBD.setText("ON");
        } else {
            jLabelBD.setText("OFF");
        }
    }
    
    public void listas(){
        model.setNumRows(0); // limpar tabela
        ResultSet rs = mysqlr.executeQuery("SELECT lista.id, mercado.nome, situacao FROM lista,mercado where (lista.id_mercado = mercado.id) ORDER BY lista.id DESC");
        if (rs != null) {
            try {
                while (rs.next()) {                    
                    model.addRow(new String[]{rs.getString("lista.id"),rs.getString("mercado.nome"),rs.getString("situacao")});
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Erro ao listar: " + e);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLista = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabelBD = new javax.swing.JLabel();
        jButtonAlterarSituacao = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuCadastroMercado = new javax.swing.JMenuItem();
        jMenuCadastroProduto = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuListaNova = new javax.swing.JMenuItem();
        jMenuListaConsulta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Produtos Transporte");

        jTableLista.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jTableLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro da lista", "Destino", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableLista);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setText("Base de dados:");

        jLabelBD.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabelBD.setText("OFF");

        jButtonAlterarSituacao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonAlterarSituacao.setText("Alterar Situação");
        jButtonAlterarSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarSituacaoActionPerformed(evt);
            }
        });

        jMenu1.setText("Cadastro");

        jMenuCadastroMercado.setText("Mercado");
        jMenuCadastroMercado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroMercadoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCadastroMercado);

        jMenuCadastroProduto.setText("Produto");
        jMenuCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCadastroProduto);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Lista");

        jMenuListaNova.setText("Nova lista");
        jMenuListaNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListaNovaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuListaNova);

        jMenuListaConsulta.setText("Visualizar produtos da lista");
        jMenuListaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuListaConsultaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuListaConsulta);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAlterarSituacao)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(260, 260, 260)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabelBD))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addComponent(jButtonAlterarSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelBD))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuCadastroMercadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastroMercadoActionPerformed
        new FormMercadoView().setVisible(true);
    }//GEN-LAST:event_jMenuCadastroMercadoActionPerformed

    private void jMenuCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastroProdutoActionPerformed
        new FormProdutoView().setVisible(true);
    }//GEN-LAST:event_jMenuCadastroProdutoActionPerformed

    private void jMenuListaNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListaNovaActionPerformed
        new FormLista().setVisible(true);
    }//GEN-LAST:event_jMenuListaNovaActionPerformed

    private void jMenuListaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuListaConsultaActionPerformed
        //tabela com produtos da lista
    }//GEN-LAST:event_jMenuListaConsultaActionPerformed

    private void jButtonAlterarSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarSituacaoActionPerformed
        int linha = jTableLista.getSelectedRow();
        ID = Integer.parseInt(jTableLista.getValueAt(linha, 0)+"");
        String[] situacao = {"Aberta", "Em Separação", "Separada" , "Concluída" , "Cancelada"};
        JComboBox jcb = new JComboBox();
        for (int i = 0; i < situacao.length; i++) {
            jcb.addItem(situacao[i]);
        }
        JOptionPane.showMessageDialog(null, jcb, "Situação da lista", JOptionPane.QUESTION_MESSAGE);
        String sit = jcb.getSelectedItem()+"";
        String query = "UPDATE lista SET situacao='"+sit+"' where id="+ID;
        if (linha != -1) ok = mysqlr.executeUpdate(query);
        if(ok == 1){
            JOptionPane.showMessageDialog(null, "Alterado para "+sit);
            listas();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao alterar status da lista"+ID);
        }
    }//GEN-LAST:event_jButtonAlterarSituacaoActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterarSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelBD;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCadastroMercado;
    private javax.swing.JMenuItem jMenuCadastroProduto;
    private javax.swing.JMenuItem jMenuListaConsulta;
    private javax.swing.JMenuItem jMenuListaNova;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLista;
    // End of variables declaration//GEN-END:variables
}
