package gui;

import aplicacion.FachadaAplicacion;
import aplicacion.ItemPedido;
import aplicacion.UsuarioAdministrador;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class VAdministradorPendientes extends javax.swing.JDialog 
{
    private final FachadaAplicacion fachadaAplicacion;
    private UsuarioAdministrador usuario;
    
    public VAdministradorPendientes(java.awt.Frame parent, FachadaAplicacion fa, UsuarioAdministrador usuario) 
    {
        super(parent, true);
        
        initComponents();
        setLocationRelativeTo(null);
        
        fachadaAplicacion = fa;
        this.usuario = usuario;
        
        menuUsuario.setText(usuario.getNombreCuenta());
        
         
        ModeloTablaPedidosAdmin mTPedidos = new ModeloTablaPedidosAdmin();
        tablaDevoluciones.setModel(mTPedidos);
        mTPedidos.setFilas(fachadaAplicacion.itemsADevolver("",null,null));
        
        if (mTPedidos.getRowCount() > 0) 
        {
            tablaDevoluciones.setRowSelectionInterval(0, 0);
            
            
            ModeloListaPedidosAdminStrings mListaRC = new ModeloListaPedidosAdminStrings();
            listaContenido.setModel(mListaRC);
            ModeloTablaPedidosAdmin mtp = (ModeloTablaPedidosAdmin) tablaDevoluciones.getModel();
            ItemPedido nuevo=mtp.obtenerPedido(tablaDevoluciones.getSelectedRow());
            mListaRC.cargaItemPedido(nuevo);
            if (mListaRC.getSize() > 0) {
                listaContenido.setSelectedIndex(0);
                botonTramitar.setEnabled(true);
                botonDenegar.setEnabled(true);
            } else {
               botonTramitar.setEnabled(false);
               botonDenegar.setEnabled(false);
            }
            
        } 
        else 
        {
            botonTramitar.setEnabled(false);
            botonDenegar.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane1 = new java.awt.ScrollPane();
        labelNumeroAdmin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDevoluciones = new javax.swing.JTable();
        botonDenegar = new javax.swing.JButton();
        botonTramitar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fieldUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fieldFecha = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaContenido = new javax.swing.JList();
        botonBuscar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        botonDatos = new javax.swing.JMenuItem();
        botonPendientes = new javax.swing.JMenuItem();
        botonTotal = new javax.swing.JMenuItem();
        botonCerrarSesion = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrador");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        labelNumeroAdmin.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Devoluciones pendientes:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Usuario:");

        tablaDevoluciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Usuario", "Fecha devolución"
            }
        ));
        tablaDevoluciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDevolucionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDevoluciones);

        botonDenegar.setText("Denegar");
        botonDenegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDenegarActionPerformed(evt);
            }
        });

        botonTramitar.setText("Tramitar");
        botonTramitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTramitarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Contenido");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Fecha:");

        jScrollPane3.setViewportView(listaContenido);

        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/lupa.png"))); // NOI18N
        botonBuscar.setPreferredSize(new java.awt.Dimension(25, 25));
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        menuUsuario.setText("NombreUsuario");

        botonDatos.setText("Mis datos");
        botonDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDatosActionPerformed(evt);
            }
        });
        menuUsuario.add(botonDatos);

        botonPendientes.setText("Devoluciones pendientes");
        botonPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPendientesActionPerformed(evt);
            }
        });
        menuUsuario.add(botonPendientes);

        botonTotal.setText("Total devoluciones");
        botonTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTotalActionPerformed(evt);
            }
        });
        menuUsuario.add(botonTotal);

        botonCerrarSesion.setText("Cerrar sesion");
        botonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarSesionActionPerformed(evt);
            }
        });
        menuUsuario.add(botonCerrarSesion);

        jMenuBar1.add(menuUsuario);

        jMenu2.setText("Administrador");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addGap(75, 75, 75))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(botonDenegar)
                                        .addGap(18, 18, 18)
                                        .addComponent(botonTramitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(7, 7, 7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(fieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelNumeroAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(fieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(labelNumeroAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonDenegar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonTramitar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPendientesActionPerformed
        dispose();
        fachadaAplicacion.abrirAdministradorPendientes(null, usuario);
    }//GEN-LAST:event_botonPendientesActionPerformed

    private void botonDenegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDenegarActionPerformed

        ModeloTablaPedidosAdmin mtp = (ModeloTablaPedidosAdmin) tablaDevoluciones.getModel();
        ItemPedido nuevo=mtp.obtenerPedido(tablaDevoluciones.getSelectedRow());
        fachadaAplicacion.efectuaDevolucion(nuevo, usuario.getNombreCuenta(), false);
        actualizarDatos();
    }//GEN-LAST:event_botonDenegarActionPerformed

    private void botonDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDatosActionPerformed
        dispose();
        fachadaAplicacion.abrirAdministradorPerfil((javax.swing.JFrame)getParent(), usuario);
        
        ((VAdministradorPrincipal)getParent()).actualizarEstadisticas();
    }//GEN-LAST:event_botonDatosActionPerformed

    private void botonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarSesionActionPerformed
        dispose();
        getParent().setVisible(false);
        fachadaAplicacion.iniciarInterfaz();
    }//GEN-LAST:event_botonCerrarSesionActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        try
        {   
            
            ModeloTablaPedidosAdmin mTPedidos = new ModeloTablaPedidosAdmin();
            if(fieldFecha.getText().equals("")){
                
                tablaDevoluciones.setModel(mTPedidos);
                mTPedidos.setFilas(fachadaAplicacion.itemsADevolver(fieldUsuario.getText(), null, null));
            }else{
                DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Timestamp fecha = new Timestamp(formato.parse(fieldFecha.getText()).getTime());
                tablaDevoluciones.setModel(mTPedidos);
                mTPedidos.setFilas(fachadaAplicacion.itemsADevolver(fieldUsuario.getText(), null, fecha));
            }
            if (mTPedidos.getRowCount() > 0) 
            {
                tablaDevoluciones.setRowSelectionInterval(0, 0);

                ModeloListaPedidosAdminStrings mListaRC = new ModeloListaPedidosAdminStrings();
                listaContenido.setModel(mListaRC);
                ModeloTablaPedidosAdmin mtp = (ModeloTablaPedidosAdmin) tablaDevoluciones.getModel();
                ItemPedido nuevo=mtp.obtenerPedido(tablaDevoluciones.getSelectedRow());
                mListaRC.cargaItemPedido(nuevo);
                
                if (mListaRC.getSize() > 0) 
                {
                    listaContenido.setSelectedIndex(0);
                    botonTramitar.setEnabled(true);
                } 
                else
                   botonTramitar.setEnabled(false);
            } 
            else 
                botonTramitar.setEnabled(false);
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
            //fachadaAplicacion.mostrarAviso(this, "No se ha introducido un formato de fecha valido");
        } 
        catch (ParseException ex) 
        {
            fachadaAplicacion.mostrarAviso(this, "La fecha no es valida");
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTotalActionPerformed
        dispose();
        fachadaAplicacion.abrirAdministradorTotal((javax.swing.JFrame)getParent(), usuario);
        
        ((VAdministradorPrincipal)getParent()).actualizarEstadisticas();
    }//GEN-LAST:event_botonTotalActionPerformed

    private void botonTramitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTramitarActionPerformed

        ModeloTablaPedidosAdmin mtp = (ModeloTablaPedidosAdmin) tablaDevoluciones.getModel();
        ItemPedido nuevo=mtp.obtenerPedido(tablaDevoluciones.getSelectedRow());
        fachadaAplicacion.efectuaDevolucion(nuevo, usuario.getNombreCuenta(), true);
        this.actualizarDatos();
    }//GEN-LAST:event_botonTramitarActionPerformed

    private void tablaDevolucionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDevolucionesMouseClicked

        ModeloListaPedidosAdminStrings mListaRC = new ModeloListaPedidosAdminStrings();
        listaContenido.setModel(mListaRC);
        ModeloTablaPedidosAdmin mtp = (ModeloTablaPedidosAdmin) tablaDevoluciones.getModel();
        ItemPedido nuevo=mtp.obtenerPedido(tablaDevoluciones.getSelectedRow());
        mListaRC.cargaItemPedido(nuevo);
            
        if (mListaRC.getSize() > 0)
        {
            listaContenido.setSelectedIndex(0);
            botonTramitar.setEnabled(true);
        } 
        else
            botonTramitar.setEnabled(false);
    }//GEN-LAST:event_tablaDevolucionesMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ((VAdministradorPrincipal)getParent()).actualizarEstadisticas();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JMenuItem botonCerrarSesion;
    private javax.swing.JMenuItem botonDatos;
    private javax.swing.JButton botonDenegar;
    private javax.swing.JMenuItem botonPendientes;
    private javax.swing.JMenuItem botonTotal;
    private javax.swing.JButton botonTramitar;
    private javax.swing.JTextField fieldFecha;
    private javax.swing.JTextField fieldUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelNumeroAdmin;
    private javax.swing.JList listaContenido;
    private javax.swing.JMenu menuUsuario;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JTable tablaDevoluciones;
    // End of variables declaration//GEN-END:variables
    
    public void actualizarDatos()
    {
        ModeloTablaPedidosAdmin mTPedidos = new ModeloTablaPedidosAdmin();
        tablaDevoluciones.setModel(mTPedidos);
        mTPedidos.setFilas(fachadaAplicacion.itemsADevolver("",null,null));
        ModeloListaPedidosAdminStrings mListaRC = new ModeloListaPedidosAdminStrings();
        listaContenido.setModel(mListaRC);
        
        if (mTPedidos.getRowCount() > 0) 
        {
            tablaDevoluciones.setRowSelectionInterval(0, 0);
            
            
            ModeloTablaPedidosAdmin mtp = (ModeloTablaPedidosAdmin) tablaDevoluciones.getModel();
            ItemPedido nuevo = mtp.obtenerPedido(tablaDevoluciones.getSelectedRow());
            mListaRC.cargaItemPedido(nuevo);
            
            if (mListaRC.getSize() > 0) 
            {
                listaContenido.setSelectedIndex(0);
                botonTramitar.setEnabled(true);
                botonDenegar.setEnabled(true);
            }
            else
            {
               botonTramitar.setEnabled(false);
               botonDenegar.setEnabled(false);
            }
        } 
        else 
        {
            botonTramitar.setEnabled(false);
            botonDenegar.setEnabled(false);
        }
    }
}
