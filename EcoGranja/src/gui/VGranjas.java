package gui;

import aplicacion.FachadaAplicacion;
import aplicacion.Granja;
import aplicacion.UsuarioCliente;

public class VGranjas extends javax.swing.JDialog 
{
    private final FachadaAplicacion fachadaAplicacion;
    private UsuarioCliente usuario;
    
    public VGranjas(java.awt.Frame parent, FachadaAplicacion fa, UsuarioCliente usuario) 
    {
        super(parent, true);
        
        initComponents();
        setLocationRelativeTo(null);
        
        fachadaAplicacion = fa;
        this.usuario = usuario;
        
        menuUsuario.setText(usuario.getNombreCuenta());
        
        if(!usuario.isConsumidor())
            menuGranjero.remove(0);
        
        ModeloTablaGranjas mTEjemplares = new ModeloTablaGranjas();
        jTable1.setModel(mTEjemplares);
        mTEjemplares.setFilas(fachadaAplicacion.buscaGranjas(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), jTextField4.getText(), jTextField5.getText(), jTextField6.getText(),usuario.getNombreCuenta()));;
        
        if (mTEjemplares.getRowCount() > 0) 
        {
            jTable1.setRowSelectionInterval(0, 0);
            botonBorrar.setEnabled(true);
            botonModificar.setEnabled(true);
            
        } 
        else 
        {
            botonBorrar.setEnabled(false);
            botonModificar.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        botonBorrar = new javax.swing.JButton();
        botonAnhadir = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        botonDatos = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        botonProductos = new javax.swing.JMenuItem();
        botonPedidos = new javax.swing.JMenuItem();
        botonCerrarSesion = new javax.swing.JMenuItem();
        menuGranjero = new javax.swing.JMenu();
        botonCliente = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Granjas");
        setResizable(false);

        jTable1.setModel(new ModeloTablaGranjas());
        jScrollPane1.setViewportView(jTable1);

        botonBorrar.setText("Borrar");
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        botonAnhadir.setText("Añadir");
        botonAnhadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnhadirActionPerformed(evt);
            }
        });

        botonModificar.setText("Modificar");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        jLabel1.setText("Granja vinculada:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Provincia:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Dirección:");

        jLabel5.setText("CIF:");

        jLabel6.setText("País:");

        jLabel7.setText("Tipo:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("[i] Para acceder a los productos haga doble click sobre alguna de las filas.");

        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/lupa.png"))); // NOI18N
        botonBuscar.setMaximumSize(new java.awt.Dimension(25, 25));
        botonBuscar.setMinimumSize(new java.awt.Dimension(25, 25));
        botonBuscar.setPreferredSize(new java.awt.Dimension(25, 25));
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        menuUsuario.setText("NombreUsuario");

        botonDatos.setText("Datos");
        botonDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDatosActionPerformed(evt);
            }
        });
        menuUsuario.add(botonDatos);

        jMenuItem2.setText("Mis granjas");
        menuUsuario.add(jMenuItem2);

        botonProductos.setText("Mis productos");
        menuUsuario.add(botonProductos);

        botonPedidos.setText("Mis pedidos");
        botonPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPedidosActionPerformed(evt);
            }
        });
        menuUsuario.add(botonPedidos);

        botonCerrarSesion.setText("Cerrar sesión");
        botonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarSesionActionPerformed(evt);
            }
        });
        menuUsuario.add(botonCerrarSesion);

        jMenuBar1.add(menuUsuario);

        menuGranjero.setText("Granjero");

        botonCliente.setText("Cliente");
        botonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonClienteActionPerformed(evt);
            }
        });
        menuGranjero.add(botonCliente);

        jMenuBar1.add(menuGranjero);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(jTextField2))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField6)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonAnhadir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(botonAnhadir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonClienteActionPerformed
        dispose();
        ((javax.swing.JFrame)this.getParent()).dispose();
        fachadaAplicacion.abrirPrincipalClientes(usuario);
    }//GEN-LAST:event_botonClienteActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        Granja resultado;
        ModeloTablaGranjas me;
        int muestra;
        
        muestra = jTable1.getSelectedRow();
        me=(ModeloTablaGranjas)jTable1.getModel();        
        resultado = me.obtenerEjemplar(muestra);
        fachadaAplicacion.borrarGranjas(resultado.getNombre());
        me.setFilas(fachadaAplicacion.buscaGranjas(jTextField1.getText(), jTextField4.getText(), jTextField2.getText(), jTextField5.getText(), jTextField3.getText(), jTextField6.getText(),usuario.getNombreCuenta()));
        
        if (me.getRowCount() > 0) 
        {
            jTable1.setRowSelectionInterval(0, 0);
            botonBorrar.setEnabled(true);
            botonModificar.setEnabled(true);
            
        } 
        else 
        {
            botonBorrar.setEnabled(false);
            botonModificar.setEnabled(false);

        }
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        Granja resultado;
        ModeloTablaGranjas me;
        int muestra;
        
        muestra = jTable1.getSelectedRow();
        me=(ModeloTablaGranjas)jTable1.getModel();        
        resultado = me.obtenerEjemplar(muestra);
        fachadaAplicacion.abrirGranjeroModificarGranja(this, usuario, resultado);
    }//GEN-LAST:event_botonModificarActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        ModeloTablaGranjas m;

        m=(ModeloTablaGranjas) jTable1.getModel();
        m.setFilas(fachadaAplicacion.buscaGranjas(jTextField1.getText(), jTextField4.getText(), jTextField2.getText(), jTextField5.getText(), jTextField3.getText(), jTextField6.getText(),usuario.getNombreCuenta()));;
        
        if (m.getRowCount() > 0)
        {
            jTable1.setRowSelectionInterval(0, 0);
            botonBorrar.setEnabled(true);
            botonModificar.setEnabled(true);       
        } 
        else 
        {
            botonBorrar.setEnabled(false);
            botonModificar.setEnabled(false);
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarSesionActionPerformed
        dispose();
        getParent().setVisible(false);
        fachadaAplicacion.iniciarInterfaz();
    }//GEN-LAST:event_botonCerrarSesionActionPerformed

    private void botonPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonPedidosActionPerformed

    private void botonAnhadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnhadirActionPerformed
        fachadaAplicacion.abrirGranjeroModificarGranja(this, usuario, null);
        actualizarTabla();
    }//GEN-LAST:event_botonAnhadirActionPerformed

    private void botonDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDatosActionPerformed
        dispose();
        fachadaAplicacion.abrirGranjeroPerfil((javax.swing.JFrame)getParent(), usuario);
    }//GEN-LAST:event_botonDatosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnhadir;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JMenuItem botonCerrarSesion;
    private javax.swing.JMenuItem botonCliente;
    private javax.swing.JMenuItem botonDatos;
    private javax.swing.JButton botonModificar;
    private javax.swing.JMenuItem botonPedidos;
    private javax.swing.JMenuItem botonProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JMenu menuGranjero;
    private javax.swing.JMenu menuUsuario;
    // End of variables declaration//GEN-END:variables
    public void actualizarTabla(){
        ModeloTablaGranjas m;

        m=(ModeloTablaGranjas) jTable1.getModel();
        m.setFilas(fachadaAplicacion.buscaGranjas(jTextField1.getText(), jTextField4.getText(), jTextField2.getText(), jTextField5.getText(), jTextField3.getText(), jTextField6.getText(),usuario.getNombreCuenta()));
        
        if (m.getRowCount() > 0) {
            jTable1.setRowSelectionInterval(0, 0);
            botonBorrar.setEnabled(true);
            botonModificar.setEnabled(true);
            
        } else {
            botonBorrar.setEnabled(false);
            botonModificar.setEnabled(false);

        }
    }
}
