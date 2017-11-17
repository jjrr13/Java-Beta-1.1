
package demoproyecto;

import java.sql.*;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Mario W
 */
public class NotasXestudiante extends javax.swing.JInternalFrame {
     ConexionBD cone;
     DefaultTableModel modelo;
     int minutes, hour;
    /**
     * Creates new form NotasXestudiante
     */
    public NotasXestudiante() {
        initComponents();
        cone= new ConexionBD();
        cargarCombo();
        GregorianCalendar fecha= new GregorianCalendar();
        
        int day= fecha.getTime() .getDate();
        int month= fecha.getTime() .getMonth()+1;
        int year= fecha.getTime() . getYear()+1900;
        
        hour= fecha.getTime() .getHours();
        minutes= fecha.getTime() .getMinutes();
        int seconds= fecha.getTime() .getSeconds();
        
        fechaIngresa.setText(day+"-"+month+"-"+year);
        horaIngresa.setText(hour+":"+minutes+":"+seconds);
    }
     public void cargarCombo() {
        try {
            ResultSet rs= cone.consultaBD("SELECT codEst FROM estudiantes");
            while(rs.next()){
                jComboBox1.addItem(rs.getString("codEst"));
                }
        } catch (SQLException ex) {
            Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void consultar(){
        
        String columnNames[]={"Código","Nombre", "Notas"};
        modelo= new DefaultTableModel (null, columnNames);
        
        try {
        ConexionBD cone3=new ConexionBD();
        
        ResultSet rs = cone3.consultaBD("select * from cursos, matriculas "
                + "where cursos.codCurso=matriculas.codCurso "
                + "and matriculas.codEst="+jComboBox1.getSelectedItem());
        String fila[]= new String[3];
            while(rs.next()){
                fila[0]=rs.getString("codCurso");
                fila[1]=rs.getString("nombCurso");
                fila[2]=rs.getString("nota");
                
                modelo.addRow(fila);
            }
            jTable1.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        fecha = new javax.swing.JLabel();
        fechaIngresa = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        horaIngresa = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Notas por Estudiante");

        jLabel5.setText("Nombre Alumno:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Generar PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        fecha.setText("Fecha:");

        hora.setText("Hora:");

        jLabel4.setText("Código Alumno:");

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(fecha)
                                .addComponent(jLabel4)
                                .addComponent(hora)))))
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(fechaIngresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(horaIngresa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(fechaIngresa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(horaIngresa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(fecha)
                        .addGap(18, 18, 18)
                        .addComponent(hora)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(79, 79, 79))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demoproyecto", "root", "");
            //coneccion de otro tipo
            Map parametro = new HashMap();
            String cod=(String)jComboBox1.getSelectedItem();
            parametro.put("cod_est", cod);

            JasperReport report = JasperCompileManager.compileReport ("src/demoproyecto/pdf/Especificos/NotasXestudiante.jrxml");
            //lo compila y genera desde librerias
            JasperPrint print = JasperFillManager.fillReport(report, parametro, conn);
            //toma jasper ripor y lo llena con datos despues debido a una consulta
            JasperExportManager.exportReportToPdfFile(print,"Reportes/Especificos/Notas por Estudiantes_"+fechaIngresa.getText()+"_"+hour+"."+minutes+".pdf");
            //toma el archivo y lo convierte en pdf // sino se quiere guardar se quita esta linea

            JasperViewer jviewer= new JasperViewer(print,false);
            jviewer.setTitle("Reporte de Notas por Estudiantes");
            jviewer.setVisible(true);
            // con estas 3 ultimas lineas se muestra se en una vista previa
        } catch (Exception ex) {
            Logger.getLogger(ListadoEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        try {
            ConexionBD cone2= new ConexionBD();
            ResultSet rs= cone2.consultaBD("SELECT nomEst FROM estudiantes where codEst="+jComboBox1.getSelectedItem());
            while(rs.next()){
                jLabel6.setText(rs.getString("nomEst"));
                consultar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel fechaIngresa;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel horaIngresa;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
