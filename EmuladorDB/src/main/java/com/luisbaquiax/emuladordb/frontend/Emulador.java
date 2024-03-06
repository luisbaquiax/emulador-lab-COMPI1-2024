/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.luisbaquiax.emuladordb.frontend;

import com.luisbaquiax.emuladordb.lexer.InstrucionesLexer;
import com.luisbaquiax.emuladordb.parser.ErrorSintactico;
import com.luisbaquiax.emuladordb.parser.InstruccionesParser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author Luis
 */
public class Emulador extends javax.swing.JFrame {

    private JTree tree;
    private DefaultTreeModel treeModel;
    private String rutaPrincipal;

    private JScrollPane scrollPane1;
    private JTabbedPane tabPaneFiles;
    private JTabbedPane tabPaneResultado;
    private JTextArea txtAreaConsole;
    private JTextArea txtAreaConsultas;
    private JScrollPane scroll2;
    private JPanel panelResultado;
    private JSplitPane splitPaneInner;
    private JSplitPane splitPaneInner2;
    private JSplitPane splitPane;
    private JTextArea txtAreaFiles;
    private String path = "";
    private String pathAbsolute;

    public static final String EXTENSION = ".csv";

    private boolean crearProyecto;

    private InstrucionesLexer lexer;
    private InstruccionesParser parser;

    /**
     * Creates new form Emulador
     */
    public Emulador() {
        initComponents();
        setLocationRelativeTo(null);
        rutaPrincipal = "";
        initTree();
        crearProyecto = false;
    }

    public void initTree() {
        tree = new JTree();
        treeModel = (DefaultTreeModel) tree.getModel();
        treeModel.setRoot(null);
        Border b1 = BorderFactory.createTitledBorder("Proyectos");
        tree.setBorder(b1);
        JScrollPane treeScrollPane = new JScrollPane(tree);

        txtAreaFiles = new JTextArea();
        JScrollPane scrollText = new JScrollPane(txtAreaFiles);

        tabPaneFiles = new JTabbedPane();
        tabPaneFiles.add(scrollText);

        txtAreaConsultas = new JTextArea();
        Border b2 = BorderFactory.createTitledBorder("<SQL> Area de consultas");
        txtAreaConsultas.setBorder(b2);
        scroll2 = new JScrollPane(txtAreaConsultas);

        panelResultado = new JPanel();

        tabPaneResultado = new JTabbedPane();
        txtAreaConsole = new JTextArea();
        JScrollPane scrolTxtResultado = new JScrollPane(txtAreaConsole);
        tabPaneResultado.addTab("Resultado consulta", scrolTxtResultado);
        tabPaneResultado.addTab("Tabla de resultadoss", new JTextArea());

        splitPaneInner = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tabPaneFiles, scroll2);
        splitPaneInner.setDividerLocation(200);

        splitPaneInner2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPaneInner, tabPaneResultado);
        splitPaneInner2.setDividerLocation(400);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScrollPane, splitPaneInner2);
        splitPane.setDividerLocation(300);

        //-------------- ACCIONES DEL AREA DE TEXTO DE CONSULTAS -------------------//
        txtAreaConsultas.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                txtAreaConsultasKyeReleased(e);
            }

        });
        //-------------- ACCIONES DEL AREA DE TEXTO DE CONSULTAS -------------------//

        tree.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    int fila = tree.getClosestRowForLocation(e.getX(), e.getY());
                    tree.setSelectionRow(fila);
                    TreePath path = tree.getSelectionPath();
                    if (path != null) {
                        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();
                        System.out.println("ruta " + rutaPrincipal + getSelectedNodePath(selectedNode));
                        pathAbsolute = "";
                        pathAbsolute += rutaPrincipal + getSelectedNodePath(selectedNode);
                        if (selectedNode != null) {
                            File file = new File(pathAbsolute);
                            System.out.println("entro");
                            if (crearProyecto == true) {
                                showFolderPopupMenu(e.getX(), e.getY());
                            } else {
                                if (file.isDirectory()) {
                                    showFolderPopupMenu(e.getX(), e.getY());
                                } else {
                                    showFilePopupMenu(e.getX(), e.getY());
                                }
                            }

                        }
                    }
                } else if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                    if (selectedNode != null && !selectedNode.getAllowsChildren()) {
                        openFile(selectedNode);
                    }
                }
            }
        });
        panelContent.setLayout(new BorderLayout());
        panelContent.add(splitPane, BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContent = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mentuItemOpenProyect = new javax.swing.JMenuItem();
        menuItemCreate = new javax.swing.JMenuItem();
        menuLexico = new javax.swing.JMenu();
        mentuItemReportTokens = new javax.swing.JMenuItem();
        menuSintáctico = new javax.swing.JMenu();
        menuItemReportSintactico = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelContentLayout = new javax.swing.GroupLayout(panelContent);
        panelContent.setLayout(panelContentLayout);
        panelContentLayout.setHorizontalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 769, Short.MAX_VALUE)
        );
        panelContentLayout.setVerticalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );

        jMenu1.setText("Proyectos");

        mentuItemOpenProyect.setText("Abrir proyecto");
        mentuItemOpenProyect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mentuItemOpenProyectActionPerformed(evt);
            }
        });
        jMenu1.add(mentuItemOpenProyect);

        menuItemCreate.setText("Crear proyecto");
        menuItemCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCreateActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemCreate);

        jMenuBar1.add(jMenu1);

        menuLexico.setText("Reporte lexico");

        mentuItemReportTokens.setText("Reporte de tokens");
        mentuItemReportTokens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mentuItemReportTokensMouseClicked(evt);
            }
        });
        mentuItemReportTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mentuItemReportTokensActionPerformed(evt);
            }
        });
        menuLexico.add(mentuItemReportTokens);

        jMenuBar1.add(menuLexico);

        menuSintáctico.setText("Reporte sintáctico");

        menuItemReportSintactico.setText("Errores sintácticos");
        menuItemReportSintactico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuItemReportSintacticoMouseClicked(evt);
            }
        });
        menuItemReportSintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemReportSintacticoActionPerformed(evt);
            }
        });
        menuSintáctico.add(menuItemReportSintactico);

        jMenuBar1.add(menuSintáctico);

        jMenu2.setText("App info");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mentuItemOpenProyectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mentuItemOpenProyectActionPerformed
        // TODO add your handling code here:
        crearProyecto = false;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showDialog(null, "Seleccionar proyecto");

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFolder = fileChooser.getSelectedFile();
            displayFolderContents(selectedFolder);
        }
    }//GEN-LAST:event_mentuItemOpenProyectActionPerformed

    private void menuItemCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCreateActionPerformed
        // TODO add your handling code here:
        crearProyecto = true;
        createProyect();
    }//GEN-LAST:event_menuItemCreateActionPerformed

    private void menuItemReportSintacticoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuItemReportSintacticoMouseClicked
        // TODO add your handling code here:
        if (parser != null) {
            Report report = new Report(parser, lexer);
            report.getTabbPane().setSelectedIndex(1);
            report.llenarTablas();
            report.setVisible(true);
        }
    }//GEN-LAST:event_menuItemReportSintacticoMouseClicked

    private void mentuItemReportTokensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mentuItemReportTokensMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_mentuItemReportTokensMouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, """
                                            Autor: Luis Baquiax
                                            Curso: Organización de lenguajes y Compiladores 1
                                            Año: 2024
                                            """);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void mentuItemReportTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mentuItemReportTokensActionPerformed
        // TODO add your handling code here:
        System.out.println("hola");
        Report report = new Report(parser, lexer);
        report.getTabbPane().setSelectedIndex(0);
        report.llenarTablas();
        report.setVisible(true);
    }//GEN-LAST:event_mentuItemReportTokensActionPerformed

    private void menuItemReportSintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemReportSintacticoActionPerformed
        // TODO add your handling code here:
        if (parser != null) {
            System.out.println("hola");
            Report report = new Report(parser, lexer);
            report.getTabbPane().setSelectedIndex(1);
            report.llenarTablas();
            report.setVisible(true);
        }
    }//GEN-LAST:event_menuItemReportSintacticoActionPerformed

    private String getSelectedNodePath(DefaultMutableTreeNode selectedNode) {
        StringBuilder path = new StringBuilder();
        TreeNode[] pathNodes = selectedNode.getPath();
        for (int i = 1; i < pathNodes.length; i++) {
            if (i > 0) {
                path.append(File.separator);
            }
            path.append(pathNodes[i].toString());
        }
        return path.toString();
    }

    private void showFolderPopupMenu(int x, int y) {

        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem createFolderItem = new JMenuItem("Crear Carpeta");
        createFolderItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFolder();
            }

        });
        popupMenu.add(createFolderItem);

        JMenuItem createFileItem = new JMenuItem("Crear Archivo");
        createFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFile();
            }

        });
        popupMenu.add(createFileItem);

        popupMenu.show(tree, x, y);

    }

    private void showFilePopupMenu(int x, int y) {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem openItem = new JMenuItem("Abrir");
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (selectedNode != null) {
                    openFile(selectedNode);
                }
            }
        });
        popupMenu.add(openItem);

        popupMenu.show(tree, x, y);
    }

    private void openFile(DefaultMutableTreeNode selectedNode) {
        String filePath = selectedNode.getUserObject().toString();
        txtAreaFiles.setText(""); // Limpiar el área de texto
        BufferedReader br;
        getSelectedNodePath(selectedNode);
        try {
            StringBuffer buffer = new StringBuffer();
            br = new BufferedReader(new FileReader(pathAbsolute));
            while (br.ready()) {
                buffer.append(br.readLine());
            }
            txtAreaFiles.setText(new String(buffer));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Emulador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Emulador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void createFolder() {
        crearProyecto = false;
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            String folderName = JOptionPane.showInputDialog("Ingrese el nombre de la carpeta:");
            if (!folderName.isBlank() || folderName != null) {
                String path = "";
                path += rutaPrincipal + getSelectedNodePath(selectedNode) + File.separator + folderName;
                System.out.println(" FOLDER PATH " + getSelectedNodePath(selectedNode));
                System.out.println(path);
                File directorio = new File(path);
                if (!directorio.exists()) {
                    if (directorio.mkdirs()) {
                        System.out.println("Directorio creado");
                        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(folderName);
                        newNode.setAllowsChildren(true);
                        treeModel.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());
                    } else {
                        System.out.println("Error al crear directorio");
                    }
                }
            }
        }
    }

    private void createProyect() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showDialog(null, "Selecionar ruta");
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFolder = fileChooser.getSelectedFile();
            String folderName = JOptionPane.showInputDialog("Ingrese el nombre de proyecto:");
            path = "";
            path += selectedFolder.getAbsolutePath() + File.separator + folderName;
            rutaPrincipal = path;
            System.out.println(" path del proyecto creado " + path);
            if (!folderName.isBlank()) {
                System.out.println(path);
                File directorio = new File(path);
                if (!directorio.exists()) {
                    if (directorio.mkdirs()) {
                        try {
                            System.out.println("Directorio creado");
                            File newFile = new File(path + File.separator + ".ide");
                            newFile.createNewFile();

                            DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(directorio.getName());
                            treeModel.setRoot(rootNode);
                            addFilesAndSubfoldersToNode(directorio, rootNode);
                            crearProyecto = true;
                        } catch (IOException ex) {
                            Logger.getLogger(Emulador.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        System.out.println("Error al crear directorio");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El proyecto ya existe.");
                }
            }
        }
    }

    private String getFolderPath(DefaultMutableTreeNode node) {
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) node.getParent();
        StringBuilder path = new StringBuilder();
        while (parent != null) {
            System.out.println(parent.getPath().length);
            path.insert(0, parent.getUserObject().toString() + File.separator);
            parent = (DefaultMutableTreeNode) parent.getParent();
        }
        return path.toString();
    }

    private void createFile() {
        crearProyecto = false;
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (selectedNode != null && selectedNode.getAllowsChildren()) {
            String folderPath = getFolderPath(selectedNode);
            System.out.println(folderPath);
            System.out.println(File.separator);

            String fileName = JOptionPane.showInputDialog("Ingrese el nombre del archivo:");
            if (!fileName.isBlank()) {
                path = "";
                path += rutaPrincipal + getSelectedNodePath(selectedNode) + File.separator + fileName + EXTENSION;
                try {
                    System.out.println(path);
                    File newFile = new File(path);
                    if (newFile.createNewFile()) {
                        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(fileName + EXTENSION);
                        treeModel.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo crear el archivo.");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void displayFolderContents(File folder) {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(folder.getName());
        treeModel.setRoot(rootNode);
        addFilesAndSubfoldersToNode(folder, rootNode);
        rutaPrincipal = folder.getAbsolutePath();
        System.out.println("Path de la carpeta seleccionada: " + folder.getAbsolutePath());
    }

    private void addFilesAndSubfoldersToNode(File folder, DefaultMutableTreeNode rootNode) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(file.getName());
                rootNode.add(node);
                if (file.isDirectory()) {
                    node.setAllowsChildren(true);
                    addFilesAndSubfoldersToNode(file, node);
                }
            }
        }
    }

    private void txtAreaConsultasKyeReleased(KeyEvent e) {
        try {
            if (e.getKeyCode() == 10) {
                String txt = txtAreaConsultas.getText().strip();
                if (txt.substring(txt.length() - 1).equals(";")) {
                    System.out.println("bien");
                    lexer = new InstrucionesLexer(new StringReader(txtAreaConsultas.getText()));
                    parser = new InstruccionesParser(lexer);
                    try {
                        parser.parse();
                    } catch (Exception ex) {
                        Logger.getLogger(Emulador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (!parser.errores.isEmpty()) {
                        String info = "";
                        for (ErrorSintactico es : parser.errores) {
                            info += es.toString();
                        }
                        txtAreaConsole.setForeground(Color.red);
                        txtAreaConsole.setText(info);
                    } else {
                        txtAreaConsole.setForeground(Color.black);
                        txtAreaConsole.setText("Todo bien.");
                    }
                }
            }
        } catch (Exception xe) {
            System.out.println(xe.getMessage());
        }

    }

//    public static void main(String[] args) {
//        new Emulador().setVisible(true);
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mentuItemOpenProyect;
    private javax.swing.JMenuItem mentuItemReportTokens;
    private javax.swing.JMenuItem menuItemCreate;
    private javax.swing.JMenuItem menuItemReportSintactico;
    private javax.swing.JMenu menuLexico;
    private javax.swing.JMenu menuSintáctico;
    private javax.swing.JPanel panelContent;
    // End of variables declaration//GEN-END:variables

}
