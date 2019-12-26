package gui;

import aplicacion.FachadaAplicacion;
import aplicacion.ItemPedido;
import aplicacion.UsuarioAdministrador;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;

public class VAdministradorPrincipal extends javax.swing.JFrame
{
    private int contador;
    private final FachadaAplicacion fachadaAplicacion;
    private UsuarioAdministrador usuario;
    private final ImageIcon[] medallas;
    
    public VAdministradorPrincipal(FachadaAplicacion fa, UsuarioAdministrador usuario) 
    {
        initComponents();
        setLocationRelativeTo(null);
        
        fachadaAplicacion = fa;
        this.usuario = usuario;
        
        menuUsuario.setText(usuario.getNombreCuenta());
        
        contador = -1;
        
        medallas = new ImageIcon[5];
        
        medallas[0] = new ImageIcon("src/gui/images/medallaBronce.png");
        medallas[1] = new ImageIcon("src/gui/images/medallaPlata.png");
        medallas[2] = new ImageIcon("src/gui/images/medallaOro.png");
        medallas[3] = new ImageIcon("src/gui/images/medallaPlatino.png");
        medallas[4] = new ImageIcon("src/gui/images/medallaDiamante.png");
        
        labelNumeroAdmin.setText(Integer.toString(usuario.getNumeroAdmin()));
        
        fieldComprador.setEditable(false);
        fieldProducto.setEditable(false);
        fieldPedido.setEditable(false);
        fieldFecha.setEditable(false);
        
        actualizarEstadisticas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelNumeroAdmin = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        medalla = new javax.swing.JLabel();
        labelPendientes = new javax.swing.JLabel();
        labelAntiguo = new javax.swing.JLabel();
        labelPorcentaje = new javax.swing.JLabel();
        labelPedido = new javax.swing.JLabel();
        labelComprador = new javax.swing.JLabel();
        fieldComprador = new javax.swing.JTextField();
        fieldPedido = new javax.swing.JTextField();
        labelProducto = new javax.swing.JLabel();
        fieldProducto = new javax.swing.JTextField();
        labelFecha = new javax.swing.JLabel();
        fieldFecha = new javax.swing.JTextField();
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
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 28)); // NOI18N
        jLabel1.setText("¡Bienvenido administrador!");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/simboloAdministrador.png"))); // NOI18N
        jLabel2.setText("label");

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel3.setText("Administrador nº ");

        labelNumeroAdmin.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Pedidos con devoluciones pendientes:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Item pendiente mas antiguo:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Porcentaje items devueltos:");

        jLabel7.setFont(new java.awt.Font("Lucida Handwriting", 0, 18)); // NOI18N
        jLabel7.setText("¡Mira por la justicia!");

        medalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/sinClasificar.png"))); // NOI18N
        medalla.setText("j");

        labelPendientes.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        labelAntiguo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelAntiguo.setText("no hay items pendientes");

        labelPorcentaje.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        labelPedido.setText("ID pedido:");

        labelComprador.setText("Comprador:");

        labelProducto.setText("Producto:");

        labelFecha.setText("Fecha:");

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
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelComprador)
                                    .addComponent(labelProducto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldComprador)
                                    .addComponent(fieldProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelPedido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fieldPedido))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelFecha)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fieldFecha))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelAntiguo)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(medalla, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNumeroAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(labelPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(labelNumeroAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(medalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(labelAntiguo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelComprador)
                                    .addComponent(fieldComprador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelProducto)
                                    .addComponent(fieldProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelPedido)
                                        .addComponent(fieldPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(labelFecha)
                                            .addComponent(fieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPendientesActionPerformed
        fachadaAplicacion.abrirAdministradorPendientes(this, usuario);
    }//GEN-LAST:event_botonPendientesActionPerformed

    //Evento solo para comprobar las medallas
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
        contador++;
        
        medalla.setIcon(medallas[contador]);
        
        if(contador == 4)
            contador = -1;
    }//GEN-LAST:event_formKeyPressed

    private void botonDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDatosActionPerformed
        fachadaAplicacion.abrirAdministradorPerfil(this, usuario);
    }//GEN-LAST:event_botonDatosActionPerformed

    private void botonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarSesionActionPerformed
        dispose();
        fachadaAplicacion.iniciarInterfaz();
    }//GEN-LAST:event_botonCerrarSesionActionPerformed

    private void botonTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTotalActionPerformed
        fachadaAplicacion.abrirAdministradorTotal(this, usuario);
    }//GEN-LAST:event_botonTotalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem botonCerrarSesion;
    private javax.swing.JMenuItem botonDatos;
    private javax.swing.JMenuItem botonPendientes;
    private javax.swing.JMenuItem botonTotal;
    private javax.swing.JTextField fieldComprador;
    private javax.swing.JTextField fieldFecha;
    private javax.swing.JTextField fieldPedido;
    private javax.swing.JTextField fieldProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel labelAntiguo;
    private javax.swing.JLabel labelComprador;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelNumeroAdmin;
    private javax.swing.JLabel labelPedido;
    private javax.swing.JLabel labelPendientes;
    private javax.swing.JLabel labelPorcentaje;
    private javax.swing.JLabel labelProducto;
    private javax.swing.JLabel medalla;
    private javax.swing.JMenu menuUsuario;
    // End of variables declaration//GEN-END:variables

    public final void actualizarEstadisticas()
    {
        ItemPedido ip;
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        
        labelPendientes.setText(Integer.toString(fachadaAplicacion.contarPedidosPendientes()));
        
        ip = fachadaAplicacion.itemMasAntiguo();
        
        if(ip != null)
        {
            fieldComprador.setText(ip.getComprador());
            fieldProducto.setText(ip.getProducto());
            fieldPedido.setText(ip.getPedido() + "");
            fieldFecha.setText(ip.getFechaDevolucion().toString());
            
            labelComprador.setVisible(true);
            labelProducto.setVisible(true);
            labelPedido.setVisible(true);
            labelFecha.setVisible(true);
            
            fieldComprador.setVisible(true);
            fieldProducto.setVisible(true);
            fieldPedido.setVisible(true);
            fieldFecha.setVisible(true);
            
            labelAntiguo.setVisible(false);
        }
        else
        {
            labelComprador.setVisible(false);
            labelProducto.setVisible(false);
            labelPedido.setVisible(false);
            labelFecha.setVisible(false);
            
            fieldComprador.setVisible(false);
            fieldProducto.setVisible(false);
            fieldPedido.setVisible(false);
            fieldFecha.setVisible(false);
            
            labelAntiguo.setVisible(true);
        }
        
        labelPorcentaje.setText(df.format(fachadaAplicacion.porcentajeItemsDevueltos(usuario.getNombreCuenta())) + " %");
    }
}
