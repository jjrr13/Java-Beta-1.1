package demoproyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperCompileManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ListadoEstudiantes extends javax.swing.JInternalFrame {
    DefaultTableModel modelo;
    ConexionBD cone;
    int hour, minutes;
    
    public ListadoEstudiantes() {
        initComponents();
        cone= new ConexionBD();
        cargarEstudiantes();
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

    public void cargarEstudiantes(){
        String columnNames[]={"Código","Nombre"};
        modelo= new DefaultTableModel (null, columnNames);
        
        ResultSet rs = cone.consultaBD("SELECT *FROM estudiantes");
        String fila[]= new String[2];
        try {
            while(rs.next()){
                fila[0]=rs.getString("codEst");
                fila[1]=rs.getString("nomEst");
                
                modelo.addRow(fila);
            }
            jTable1.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fecha = new javax.swing.JLabel();
        fechaIngresa = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        horaIngresa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listado de Estudiantes");

        fecha.setText("Fecha");

        hora.setText("Hora");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha)
                            .addComponent(hora))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fechaIngresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(horaIngresa, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha)
                    .addComponent(fechaIngresa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hora)
                    .addComponent(horaIngresa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demoproyecto", "root", "");
            //coneccion de otro tipo
            JasperReport report = JasperCompileManager.compileReport ("src/demoproyecto/pdf/Generales/listas.jrxml");
            //lo compila y genera desde librerias
            JasperPrint print = JasperFillManager.fillReport(report, new HashMap(), conn);
            //toma jasper ripor y lo llena con datos despues debido a una consulta
            JasperExportManager.exportReportToPdfFile(print,"Reportes/Generales/Listado Estudiantes_"+fechaIngresa.getText()+"_"+hour+"."+minutes+".pdf");
            //toma el archivo y lo convierte en pdf // sino se quiere guardar se quita esta linea
            
            JasperViewer jviewer= new JasperViewer(print,false);
            jviewer.setTitle("Reporte de Prueba");
            jviewer.setVisible(true);
            // con estas 3 ultimas lineas se muestra se en una vista previa 
        } catch (Exception ex) {
            Logger.getLogger(ListadoEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel fechaIngresa;
    private javax.swing.JLabel hora;
    private javax.swing.JLabel horaIngresa;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
