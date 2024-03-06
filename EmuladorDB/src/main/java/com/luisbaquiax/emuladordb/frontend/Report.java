/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.luisbaquiax.emuladordb.frontend;

import com.luisbaquiax.emuladordb.lexer.InstrucionesLexer;
import com.luisbaquiax.emuladordb.parser.ErrorSintactico;
import com.luisbaquiax.emuladordb.parser.InstruccionesParser;
import java_cup.runtime.Symbol;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public final class Report extends javax.swing.JFrame {

    private InstruccionesParser parser;
    private InstrucionesLexer lexer;
    private DefaultTableModel dfm;
    private DefaultTableModel dfm1;

    /**
     *
     * @param parser
     * @param lexer
     */
    public Report(InstruccionesParser parser, InstrucionesLexer lexer) {
        initComponents();
        setLocationRelativeTo(null);
        this.lexer = lexer;
        this.parser = parser;
        for (int i = 0; i < lexer.tokens.size(); i++) {
            System.out.println(lexer.tokens.get(i).value.toString());
        }
        for (int i = 0; i < parser.errores.size(); i++) {
            System.out.println(parser.errores.get(i).getLexema());
        }
        llenarTablas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbPane = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTokens = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableErroresSintactico = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        tabbPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Reportes léxico y sintáctico"));

        tableTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexema", "Fila - Columna", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableTokens);

        tabbPane.addTab("", jScrollPane1);

        tableErroresSintactico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexema", "Fila - Columna", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableErroresSintactico);

        tabbPane.addTab("", jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbPane, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbPane, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tabbPane;
    private javax.swing.JTable tableErroresSintactico;
    private javax.swing.JTable tableTokens;
    // End of variables declaration//GEN-END:variables

    public void llenarTablas() {
        dfm = (DefaultTableModel) tableTokens.getModel();
        dfm.setRowCount(0);
        for (Symbol token : lexer.tokens) {
            String[] data = {
                token.value.toString(),
                token.left + "  " + token.right,
                token.value.toString()
            };
            dfm.addRow(data);
        }
        dfm1 = (DefaultTableModel) tableErroresSintactico.getModel();
        dfm1.setRowCount(0);
        for (ErrorSintactico token : parser.errores) {
            String[] data = {
                token.getLexema(),
                token.getRow() + "  " + token.getCol(),
                token.getDescription()
            };
            dfm1.addRow(data);
        }
    }

    public JTabbedPane getTabbPane() {
        return tabbPane;
    }
}