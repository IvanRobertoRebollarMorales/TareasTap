/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Practica8 extends javax.swing.JFrame {

    Connection conn = null;
    private DefaultTableModel dtm;
    private ArrayList<respuesta> aListaRespuestas;

    public Practica8() {
        initComponents();
         aListaRespuestas = new ArrayList();
        dtm = (DefaultTableModel) this.jTable1.getModel();
    }
    
    //Este metodo lo llamo en el boton actualizar
   private void consultarBD() {
        Statement stmt;
        String sQuery;
        ResultSet rset;
        sQuery = "Select * from respuestas";
        System.out.println(sQuery);
        try {
            if (conn == null) {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/encuesta?"
                        + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=encuesta&password=encuesta");
//                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/encuesta", "encuesta", "encuesta");
            }
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sQuery);
            while (rset.next()) {
                System.out.println(rset.getString("sisoper"));
//con la variable res guardo los datos que devuelve el ResulSet(rset) y posteriormente lo almaceno en el arraylist(aListaRespuestas)
                respuesta res = new respuesta(rset.getInt("id"), rset.getString("sisoper"), rset.getString("prog"), rset.getString("diseno"), rset.getString("admon"), rset.getInt("horas"));
                aListaRespuestas.add(res);
            }
            //con este metodo se muestra en la tabla que supimos en el JFrame
            mostrarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(Encuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarTabla() {
        /*
        le dijo a la tabla cuantas filas tentra que sera igual ala 
        longitud del arraylist(aListaRespuestas) que es igual a la cantidad de registros que devolvio 
        el resulSet(rset)
         */
        dtm.setRowCount(this.aListaRespuestas.size());
        /*
            recorro la cantidad de datos en el arraylist y los voy mostrando en la tabla con el metodo
        setValueAt el cual resive 3 parametros(lo que quiero poner, la fila, la columna) lo puse 6 veces porque son
        6 columnas y en cada columna va un dato diferente
         */
        for (int i = 0; i < this.aListaRespuestas.size(); i++) {
            respuesta res = this.aListaRespuestas.get(i);
            this.dtm.setValueAt(res.getiID(), i, 0);
            this.dtm.setValueAt(res.getsSistem(), i, 1);
            this.dtm.setValueAt(res.getsProgra(), i, 2);
            this.dtm.setValueAt(res.getsDisen(), i, 3);
            this.dtm.setValueAt(res.getsAdmon(), i, 4);
            this.dtm.setValueAt(res.getiHoras(), i, 5);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Sistema", "Programacion", "Diseño", "Administracion", "Horas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jButton1)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        consultarBD();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Practica8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Practica8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Practica8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Practica8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            // handle the error
            System.out.println(ex.getMessage());
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Practica8().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
