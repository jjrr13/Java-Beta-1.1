package demoproyecto;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mario W
 */
public class ListadoCursos extends javax.swing.JInternalFrame {
    DefaultTableModel modelo;
    ConexionBD cone;
    int hour, minutes;
    /**
     * Creates new form ListadoCursos
     */
    public ListadoCursos() {
        initComponents();
        cone= new ConexionBD();
        cargarCursos();
        
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
    public void cargarCursos(){
        String columnNames[]={"Código","Nombre"};
        modelo= new DefaultTableModel (null, columnNames);
        
        ResultSet rs = cone.consultaBD("SELECT codCurso, nombCurso FROM cursos");
        String fila[]= new String[2];
        try {
            while(rs.next()){
                fila[0]=rs.getString("codCurso");
                fila[1]=rs.getString("nombCurso");
                
                modelo.addRow(fila);
            }
            jTable1.setModel(modelo);
        } catch (Exception ex) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        fecha = new javax.swing.JLabel();
        fechaIngresa = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        horaIngresa = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listas de Cursos");

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

        fecha.setText("Fecha");

        hora.setText("Hora");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha)
                            .addComponent(hora))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fechaIngresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(horaIngresa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(60, 60, 60))))
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
            JasperReport report = JasperCompileManager.compileReport ("src/demoproyecto/pdf/Generales/ListadoCursos.jrxml");
            //lo compila y genera desde librerias
            JasperPrint print = JasperFillManager.fillReport(report, new HashMap(), conn);
            //toma jasper ripor y lo llena con datos despues debido a una consulta
            JasperExportManager.exportReportToPdfFile(print,"Reportes/Generales/Informe Cursosc_"+fechaIngresa.getText()+"_"+hour+"."+minutes+".pdf");
            //toma el archivo y lo convierte en pdf // sino se quiere guardar se quita esta linea

            JasperViewer jviewer= new JasperViewer(print,false);
            jviewer.setTitle("Reporte de Cursos");
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