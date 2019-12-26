package gui;

import aplicacion.FachadaAplicacion;
import aplicacion.UsuarioAdministrador;

public class VAdministradorPerfil extends javax.swing.JDialog
{
    private final FachadaAplicacion fachadaAplicacion;
    private UsuarioAdministrador usuario;
    private javax.swing.ImageIcon imagen;
    
    public VAdministradorPerfil(java.awt.Frame parent, FachadaAplicacion fa, UsuarioAdministrador usuario)
    {
        super(parent, true);
        
        initComponents();
        setLocationRelativeTo(null);
        
        fachadaAplicacion = fa;
        this.usuario = usuario;
        
        menuUsuario.setText(usuario.getNombreCuenta());
        
        if(usuario.getImagenUsuario() != null)
            imagenUsuario.setIcon(usuario.getImagenUsuario());
        else
            imagenUsuario.setIcon(new javax.swing.ImageIcon("src/gui/images/fotoAdmin.png"));
        
        labelNombre.setText(usuario.getNombreCuenta());
        
        fieldNombreUsuario.setText(usuario.getNombreCuenta());
        fieldCorreo.setText(usuario.getEmail());
        fieldDireccion.setText(usuario.getDireccion());
        fieldClave.setText(usuario.getClave());
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
        botonActualizar = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        fieldClave = new javax.swing.JPasswordField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        botonDatos = new javax.swing.JMenuItem();
        botonPendientes = new javax.swing.JMenuItem();
        botonTotal = new javax.swing.JMenuItem();
        botonCerrarSesion = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Perfil del administrador");
        setMinimumSize(new java.awt.Dimension(682, 239));
        setResizable(false);

        labelNombre.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        labelNombre.setText("Label");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        imagenUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/fotoAdmin.png"))); // NOI18N
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

        botonDatos.setText("Mis datos");
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

        botonCerrarSesion.setText("Cerrar sesión");
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
                                .addComponent(fieldNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(fieldCorreo))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(fieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldClave))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(botonBorrar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelNombre)
                        .addGap(51, 51, 51)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(labelNombre))
                        .addGap(5, 5, 5)
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
                            .addComponent(fieldClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPendientesActionPerformed
        dispose();
        fachadaAplicacion.abrirAdministradorPendientes((javax.swing.JFrame) getParent(), usuario);
    }//GEN-LAST:event_botonPendientesActionPerformed

    private void botonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarSesionActionPerformed
        dispose();
        getParent().setVisible(false);
        fachadaAplicacion.iniciarInterfaz();
    }//GEN-LAST:event_botonCerrarSesionActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        aplicacion.Usuario u;
        String correo;
        
        if(!fieldNombreUsuario.getText().isEmpty() && !fieldCorreo.getText().isEmpty() && !fieldDireccion.getText().isEmpty() && fieldClave.getPassword().length > 0)
            if((u = fachadaAplicacion.comprobarAutentificacion(fieldNombreUsuario.getText(), null)) == null || usuario.getNombreCuenta().equals(u.getNombreCuenta()))
                if((correo = fachadaAplicacion.comprobarEmail(fieldCorreo.getText())) == null || usuario.getEmail().equals(correo))
                {
                    usuario.setImagenUsuario(imagen);
                    fachadaAplicacion.actualizarUsuario(new aplicacion.UsuarioAdministrador(fieldNombreUsuario.getText(), new String(fieldClave.getPassword()), fieldCorreo.getText(), fieldDireccion.getText(), usuario.getImagenUsuario(), 0), usuario.getNombreCuenta());
                    fachadaAplicacion.mostrarAviso(null, "El usuario se actualizó correctamente.");
                }
                else
                    fachadaAplicacion.mostrarAviso(this, "El correo indicado ya está en uso, pruebe con otro por favor.");
            else
                fachadaAplicacion.mostrarAviso(null, "El nombre de usuario indicado ya está en uso, pruebe con otro.");
        else
            fachadaAplicacion.mostrarAviso(null, "Alguno de los campos de la sección \"Datos\" está vacío.");
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        fachadaAplicacion.eliminarUsuario(usuario);
        
        fachadaAplicacion.mostrarAviso(null, "El usuario \"" + usuario.getNombreCuenta() + "\" fue borrado exitosamente.");
        
        botonCerrarSesionActionPerformed(null);
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTotalActionPerformed

        fachadaAplicacion.abrirAdministradorTotal((javax.swing.JFrame)getParent(), usuario);
    }//GEN-LAST:event_botonTotalActionPerformed

    private void imagenUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenUsuarioMouseClicked
        imagen = fachadaAplicacion.cargarImagen(this, imagenUsuario.getWidth(), imagenUsuario.getHeight());
        
        if(imagen != null)
            imagenUsuario.setIcon(imagen);
    }//GEN-LAST:event_imagenUsuarioMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JMenuItem botonCerrarSesion;
    private javax.swing.JMenuItem botonDatos;
    private javax.swing.JMenuItem botonPendientes;
    private javax.swing.JMenuItem botonTotal;
    private javax.swing.JPasswordField fieldClave;
    private javax.swing.JTextField fieldCorreo;
    private javax.swing.JTextField fieldDireccion;
    private javax.swing.JTextField fieldNombreUsuario;
    private javax.swing.JLabel imagenUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JMenu menuUsuario;
    // End of variables declaration//GEN-END:variables
}
