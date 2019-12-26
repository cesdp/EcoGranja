package gui;

import aplicacion.FachadaAplicacion;
import aplicacion.UsuarioCliente;

public class VGranjeroPerfil extends javax.swing.JDialog
{
    private final FachadaAplicacion fachadaAplicacion;
    private UsuarioCliente usuario;
    private javax.swing.ImageIcon imagen;
    
    public VGranjeroPerfil(java.awt.Frame parent, FachadaAplicacion fa, UsuarioCliente usuario)
    {
        super(parent, true);
        
        initComponents();
        setLocationRelativeTo(null);
        
        fachadaAplicacion = fa;
        this.usuario = usuario;
        
        menuUsuario.setText(usuario.getNombreCuenta());
        
        if(!usuario.isConsumidor())
            menuGranjero.remove(0);
        
        if(usuario.getImagenUsuario() != null)
            imagenUsuario.setIcon(usuario.getImagenUsuario());
        else
            imagenUsuario.setIcon(new javax.swing.ImageIcon("src/gui/images/fotoCliente.png"));
        
        labelNombre.setText(usuario.getNombreCuenta());
        
        fieldNombreUsuario.setText(usuario.getNombreCuenta());
        fieldCorreo.setText(usuario.getEmail());
        fieldDireccion.setText(usuario.getDireccion());
        fieldClave.setText(usuario.getClave());
        fieldNombrePropio.setText(usuario.getNombrePropio());
        fieldApellidos.setText(usuario.getApellidos());
        fieldDni.setText(usuario.getDni());
        fieldNumeroCuenta.setText(usuario.getNumeroCuenta());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNombre = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        imagenUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fieldNombreUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fieldCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fieldDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fieldNombrePropio = new javax.swing.JTextField();
        fieldApellidos = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fieldDni = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        fieldNumeroCuenta = new javax.swing.JTextField();
        botonActualizar = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        fieldClave = new javax.swing.JPasswordField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        botonDatos = new javax.swing.JMenuItem();
        botonGranjas = new javax.swing.JMenuItem();
        botonProductos = new javax.swing.JMenuItem();
        botonPedidos = new javax.swing.JMenuItem();
        botonCerrarSesion = new javax.swing.JMenuItem();
        menuGranjero = new javax.swing.JMenu();
        botonCliente = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Perfil del granjero");
        setMinimumSize(new java.awt.Dimension(641, 348));
        setResizable(false);

        labelNombre.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        labelNombre.setText("label");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        imagenUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/fotoCliente.png"))); // NOI18N
        imagenUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagenUsuarioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagenUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagenUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Datos:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Correo electrónico:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Dirección:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Contraseña:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Datos ingresos:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Nombre:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Apellidos:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("DNI:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Número de cuenta:");

        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        botonBorrar.setText("Borrar Usuario");
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        menuUsuario.setText("NombreUsuario");

        botonDatos.setText("Datos");
        menuUsuario.add(botonDatos);

        botonGranjas.setText("Mis granjas");
        botonGranjas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGranjasActionPerformed(evt);
            }
        });
        menuUsuario.add(botonGranjas);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(fieldNombreUsuario))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(fieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(fieldNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(fieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18)
                                                .addComponent(fieldApellidos))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(fieldNombrePropio))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(fieldClave))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(fieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonBorrar)
                                .addGap(10, 10, 10))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelNombre)
                        .addGap(73, 73, 73))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNombre)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(fieldNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(fieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(fieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(fieldClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(jLabel7)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(fieldNombrePropio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(fieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(fieldNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGranjasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGranjasActionPerformed
        dispose();
        fachadaAplicacion.abrirGranjeroGranjas((javax.swing.JFrame)getParent(), usuario);
    }//GEN-LAST:event_botonGranjasActionPerformed

    private void botonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonClienteActionPerformed
        dispose();
        ((javax.swing.JFrame)this.getParent()).dispose();
        fachadaAplicacion.abrirPrincipalClientes(usuario);
    }//GEN-LAST:event_botonClienteActionPerformed

    private void botonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarSesionActionPerformed
        dispose();
        getParent().setVisible(false);
        fachadaAplicacion.iniciarInterfaz();
    }//GEN-LAST:event_botonCerrarSesionActionPerformed

    private void botonPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedidosActionPerformed
        
    }//GEN-LAST:event_botonPedidosActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        fachadaAplicacion.eliminarUsuario(usuario);
        
        fachadaAplicacion.mostrarAviso(null, "El usuario \"" + usuario.getNombreCuenta() + "\" fue borrado exitosamente.");
        
        botonCerrarSesionActionPerformed(null);
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        aplicacion.Usuario u;
        String correo;
        
        if(!fieldNombreUsuario.getText().isEmpty() && !fieldCorreo.getText().isEmpty() && !fieldDireccion.getText().isEmpty() && fieldClave.getPassword().length > 0)
            if((u = fachadaAplicacion.comprobarAutentificacion(fieldNombreUsuario.getText(), null)) == null || usuario.getNombreCuenta().equals(u.getNombreCuenta()))
                if((correo = fachadaAplicacion.comprobarEmail(fieldCorreo.getText())) == null || usuario.getEmail().equals(correo))
                {
                    usuario.setImagenUsuario(imagen);
                    fachadaAplicacion.actualizarUsuario(new aplicacion.UsuarioCliente(fieldNombreUsuario.getText(),new String(fieldClave.getPassword()), fieldCorreo.getText(), fieldDireccion.getText(), usuario.getImagenUsuario(), 0, fieldNombrePropio.getText(), fieldApellidos.getText(), fieldDni.getText(), fieldNumeroCuenta.getText()), usuario.getNombreCuenta());
                    fachadaAplicacion.mostrarAviso(null, "El usuario se actualizó correctamente.");
                }
                else
                    fachadaAplicacion.mostrarAviso(this, "El correo indicado ya está en uso, pruebe con otro por favor.");
            else
                fachadaAplicacion.mostrarAviso(null, "El nombre de usuario indicado ya está en uso, pruebe con otro.");
        else
            fachadaAplicacion.mostrarAviso(null, "Alguno de los campos de la sección \"Datos\" está vacío.");
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void imagenUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenUsuarioMouseClicked
        imagen = fachadaAplicacion.cargarImagen(this, imagenUsuario.getWidth(), imagenUsuario.getHeight());
        
        if(imagen != null)
            imagenUsuario.setIcon(imagen);
    }//GEN-LAST:event_imagenUsuarioMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JMenuItem botonCerrarSesion;
    private javax.swing.JMenuItem botonCliente;
    private javax.swing.JMenuItem botonDatos;
    private javax.swing.JMenuItem botonGranjas;
    private javax.swing.JMenuItem botonPedidos;
    private javax.swing.JMenuItem botonProductos;
    private javax.swing.JTextField fieldApellidos;
    private javax.swing.JPasswordField fieldClave;
    private javax.swing.JTextField fieldCorreo;
    private javax.swing.JTextField fieldDireccion;
    private javax.swing.JTextField fieldDni;
    private javax.swing.JTextField fieldNombrePropio;
    private javax.swing.JTextField fieldNombreUsuario;
    private javax.swing.JTextField fieldNumeroCuenta;
    private javax.swing.JLabel imagenUsuario;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JMenu menuGranjero;
    private javax.swing.JMenu menuUsuario;
    // End of variables declaration//GEN-END:variables
}
