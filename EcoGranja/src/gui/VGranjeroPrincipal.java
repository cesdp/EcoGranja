package gui;

import aplicacion.FachadaAplicacion;
import aplicacion.UsuarioCliente;
import javax.swing.ImageIcon;

public class VGranjeroPrincipal extends javax.swing.JFrame 
{
    private int contador;
    private final FachadaAplicacion fachadaAplicacion;
    private UsuarioCliente usuario;
    private ImageIcon[] medallas;
    
    public VGranjeroPrincipal(FachadaAplicacion fa, UsuarioCliente usuario) 
    {
        initComponents();
        setLocationRelativeTo(null);
        
        fachadaAplicacion = fa;
        this.usuario = usuario;
        
        menuUsuario.setText(usuario.getNombreCuenta());
        
        if(!usuario.isConsumidor())
            menuGranjero.remove(0);
        
        contador = -1;
        
        medallas = new ImageIcon[5];
        
        medallas[0] = new ImageIcon("src/gui/images/medallaBronce.png");
        medallas[1] = new ImageIcon("src/gui/images/medallaPlata.png");
        medallas[2] = new ImageIcon("src/gui/images/medallaOro.png");
        medallas[3] = new ImageIcon("src/gui/images/medallaPlatino.png");
        medallas[4] = new ImageIcon("src/gui/images/medallaDiamante.png");
        
        labelNumeroSocio.setText(Integer.toString(usuario.getNumeroSocio()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        medalla = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labelNumeroSocio = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        botonDatos = new javax.swing.JMenuItem();
        botonGranjas = new javax.swing.JMenuItem();
        botonProductos = new javax.swing.JMenuItem();
        botonPedidos = new javax.swing.JMenuItem();
        botonCerrarSesion = new javax.swing.JMenuItem();
        menuGranjero = new javax.swing.JMenu();
        botonCliente = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Granjero");
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 28)); // NOI18N
        jLabel1.setText("¡Bienvenido granjero!");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/simboloGranjero.png"))); // NOI18N
        jLabel2.setText("label");

        jLabel3.setFont(new java.awt.Font("NanumBarunGothic", 0, 18)); // NOI18N
        jLabel3.setText("Socio nº ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Número pedidos:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Dinero ganado:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Incremento respecto del mes pasado:");

        medalla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/sinClasificar.png"))); // NOI18N
        medalla.setText("j");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Balance anual:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Estadísticas:");

        labelNumeroSocio.setFont(new java.awt.Font("NanumBarunGothic", 1, 18)); // NOI18N

        menuUsuario.setText("NombreUsuario");

        botonDatos.setText("Datos");
        botonDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDatosActionPerformed(evt);
            }
        });
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
        menuUsuario.add(botonPedidos);

        botonCerrarSesion.setText("Cerrar sesion");
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
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(medalla, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNumeroSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(labelNumeroSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(medalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Evento solo para comprobar las medallas
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
        contador++;
        
        medalla.setIcon(medallas[contador]);
        
        if(contador == 4)
            contador = -1;
    }//GEN-LAST:event_formKeyPressed

    private void botonGranjasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGranjasActionPerformed
        fachadaAplicacion.abrirGranjeroGranjas(this, usuario);
    }//GEN-LAST:event_botonGranjasActionPerformed

    private void botonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarSesionActionPerformed
        dispose();
        fachadaAplicacion.iniciarInterfaz();
    }//GEN-LAST:event_botonCerrarSesionActionPerformed

    private void botonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonClienteActionPerformed
        dispose();
        fachadaAplicacion.abrirPrincipalClientes(usuario);
    }//GEN-LAST:event_botonClienteActionPerformed

    private void botonDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDatosActionPerformed
        fachadaAplicacion.abrirGranjeroPerfil(this, usuario);
    }//GEN-LAST:event_botonDatosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem botonCerrarSesion;
    private javax.swing.JMenuItem botonCliente;
    private javax.swing.JMenuItem botonDatos;
    private javax.swing.JMenuItem botonGranjas;
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
    private javax.swing.JLabel labelNumeroSocio;
    private javax.swing.JLabel medalla;
    private javax.swing.JMenu menuGranjero;
    private javax.swing.JMenu menuUsuario;
    // End of variables declaration//GEN-END:variables
}
