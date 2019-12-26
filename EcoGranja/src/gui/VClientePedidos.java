package gui;

import aplicacion.FachadaAplicacion;
import aplicacion.Pedido;
import aplicacion.UsuarioCliente;
import javax.swing.Box;

public class VClientePedidos extends javax.swing.JDialog
{
    private final FachadaAplicacion fachadaAplicacion;
    private UsuarioCliente usuario;
    
    public VClientePedidos(java.awt.Frame parent, FachadaAplicacion fa, UsuarioCliente usuario)
    {
        super(parent, true);
        
        initComponents();
        setLocationRelativeTo(null);
        
        fachadaAplicacion = fa;
        this.usuario = usuario;
        
        menuUsuario.setText(usuario.getNombreCuenta());
        
        if(!usuario.isProductor())
            menuCliente.remove(0);
        
        ModeloTablaPedidosCliente mTEjemplares = new ModeloTablaPedidosCliente();
        jTable1.setModel(mTEjemplares);
        mTEjemplares.setFilas(fachadaAplicacion.recuperaPedidos(usuario.getNombreCuenta()));
        
        if (mTEjemplares.getRowCount() > 0) 
        {
            jTable1.setRowSelectionInterval(0, 0);
            
            
            ModeloListaPedidosStrings mListaRC = new ModeloListaPedidosStrings();
            jList1.setModel(mListaRC);
            ModeloTablaPedidosCliente mtp = (ModeloTablaPedidosCliente) jTable1.getModel();
            Pedido nuevo=mtp.obtenerPedido(jTable1.getSelectedRow());
            mListaRC.cargaItemPedido(nuevo.getComponentes());
            if (mListaRC.getSize() > 0) {
                jList1.setSelectedIndex(0);
                jButton2.setEnabled(true);
            } else {
               jButton2.setEnabled(false);
            }
            
        } 
        else 
        {
            jButton2.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        botonDatos = new javax.swing.JMenuItem();
        botonPedidos = new javax.swing.JMenuItem();
        botonCerrarSesion = new javax.swing.JMenuItem();
        menuCliente = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cliente");
        setPreferredSize(new java.awt.Dimension(733, 400));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Pedidos:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Manzana", "Fruta", "19", "14/05/2019", "Super Frutas"}
            },
            new String [] {
                "Producto", "Categoria", "Unidades", "Caducidad", "Granja"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Solicitar Devolución");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Contenido:");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        menuUsuario.setText("NombreUsuario");

        botonDatos.setText("Datos");
        botonDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDatosActionPerformed(evt);
            }
        });
        menuUsuario.add(botonDatos);

        botonPedidos.setText("Mis pedidos");
        menuUsuario.add(botonPedidos);

        botonCerrarSesion.setText("Cerrar sesion");
        botonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarSesionActionPerformed(evt);
            }
        });
        menuUsuario.add(botonCerrarSesion);

        jMenuBar1.add(menuUsuario);

        menuCliente.setText("Cliente");

        jMenuItem4.setText("Granjero");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuCliente.add(jMenuItem4);

        jMenuBar1.add(menuCliente);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/carrito.png"))); // NOI18N
        jMenu3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenu3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu3.add(Box.createHorizontalGlue());
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(116, 116, 116))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(202, 202, 202)
                            .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDatosActionPerformed
        dispose();
        fachadaAplicacion.abrirClientePerfil((javax.swing.JFrame)getParent(), usuario);
    }//GEN-LAST:event_botonDatosActionPerformed

    private void botonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarSesionActionPerformed
        dispose();
        getParent().setVisible(false);
        fachadaAplicacion.iniciarInterfaz();
    }//GEN-LAST:event_botonCerrarSesionActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        dispose();
        ((javax.swing.JFrame)this.getParent()).dispose();
        fachadaAplicacion.abrirPrincipalGranjeros(usuario);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ModeloTablaPedidosCliente mtp = (ModeloTablaPedidosCliente) jTable1.getModel();
        Pedido nuevo=mtp.obtenerPedido(jTable1.getSelectedRow());
        (new VCantidadDevuelta(this,fachadaAplicacion,nuevo.getId(),nuevo.getComprador(),nuevo.getComponentes().get(jList1.getSelectedIndex()))).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
            ModeloListaPedidosStrings mListaRC = new ModeloListaPedidosStrings();
            jList1.setModel(mListaRC);
            ModeloTablaPedidosCliente mtp = (ModeloTablaPedidosCliente) jTable1.getModel();
            Pedido nuevo=mtp.obtenerPedido(jTable1.getSelectedRow());
            mListaRC.cargaItemPedido(nuevo.getComponentes());
            if (mListaRC.getSize() > 0) {
                jList1.setSelectedIndex(0);
                jButton2.setEnabled(true);
            } else {
               jButton2.setEnabled(false);
            }
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem botonCerrarSesion;
    private javax.swing.JMenuItem botonDatos;
    private javax.swing.JMenuItem botonPedidos;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenu menuUsuario;
    // End of variables declaration//GEN-END:variables
    public void actualizarDatos(){
        ModeloTablaPedidosCliente mTEjemplares = new ModeloTablaPedidosCliente();
        jTable1.setModel(mTEjemplares);
        mTEjemplares.setFilas(fachadaAplicacion.recuperaPedidos(usuario.getNombreCuenta()));
        
        if (mTEjemplares.getRowCount() > 0) 
        {
            jTable1.setRowSelectionInterval(0, 0);
            
            
            ModeloListaPedidosStrings mListaRC = new ModeloListaPedidosStrings();
            jList1.setModel(mListaRC);
            ModeloTablaPedidosCliente mtp = (ModeloTablaPedidosCliente) jTable1.getModel();
            Pedido nuevo=mtp.obtenerPedido(jTable1.getSelectedRow());
            mListaRC.cargaItemPedido(nuevo.getComponentes());
            if (mListaRC.getSize() > 0) {
                jList1.setSelectedIndex(0);
                jButton2.setEnabled(true);
            } else {
               jButton2.setEnabled(false);
            }
            
        } 
        else 
        {
            jButton2.setEnabled(false);
        }
    }



}


