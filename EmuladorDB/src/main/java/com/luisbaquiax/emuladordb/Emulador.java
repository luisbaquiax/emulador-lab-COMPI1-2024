/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.luisbaquiax.emuladordb;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
    private JTabbedPane tabPane;
    private JTabbedPane tabPaneResultado;
    private JTextArea txtResultado;
    private JTextArea jTextArea1;
    private JScrollPane scroll2;
    private JPanel panelResultado;
    private JSplitPane splitPaneInner;
    private JSplitPane splitPaneInner2;
    private JSplitPane splitPane;
    private JTextArea textArea;
    private String path = "";
    
    public static final String EXTENSION=".csv";

    private boolean crearProyecto;

    /**
     * Creates new form Emulador
     */
    public Emulador() {
        initComponents();
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

        textArea = new JTextArea();
        JScrollPane scrollText = new JScrollPane(textArea);

        tabPane = new JTabbedPane();
        tabPane.add(scrollText);

        jTextArea1 = new JTextArea();
        scroll2 = new JScrollPane(jTextArea1);

        panelResultado = new JPanel();

        tabPaneResultado = new JTabbedPane();
        txtResultado = new JTextArea();
        JScrollPane scrolTxtResultado = new JScrollPane(txtResultado);
        tabPaneResultado.addTab("Resultado consulta", scrolTxtResultado);
        tabPaneResultado.addTab("Tabla de resultadoss", new JTextArea());

        splitPaneInner = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tabPane, scroll2);
        splitPaneInner.setDividerLocation(200);

        splitPaneInner2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPaneInner, tabPaneResultado);
        splitPaneInner2.setDividerLocation(400);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScrollPane, splitPaneInner2);
        splitPane.setDividerLocation(300);

        tree.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    int fila = tree.getClosestRowForLocation(e.getX(), e.getY());
                    tree.setSelectionRow(fila);
                    TreePath path = tree.getSelectionPath();
                    if (path != null) {
                        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();
                        System.out.println("ruta " + rutaPrincipal + getSelectedNodePath(selectedNode));
                        String pathAbsolute = "";
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
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelContentLayout = new javax.swing.GroupLayout(panelContent);
        panelContent.setLayout(panelContentLayout);
        panelContentLayout.setHorizontalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
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
        jMenuBar1.add(menuLexico);

        jMenu2.setText("App info");
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
        jTextArea1.setText(""); // Limpiar el área de texto
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jTextArea1.append(line + "\n");
            }
            System.out.println("Ruta absoluta del archivo: " + filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void createFolder() {
        crearProyecto=false;
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

    public static void main(String[] args) {
        new Emulador().setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mentuItemOpenProyect;
    private javax.swing.JMenuItem menuItemCreate;
    private javax.swing.JMenu menuLexico;
    private javax.swing.JPanel panelContent;
    // End of variables declaration//GEN-END:variables

}
