/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.luisbaquiax.emuladordb;

import com.luisbaquiax.emuladordb.frontend.Emulador;
import com.luisbaquiax.emuladordb.frontend.Report;
import com.luisbaquiax.emuladordb.lexer.InstrucionesLexer;
import com.luisbaquiax.emuladordb.parser.InstruccionesParser;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class EmuladorDB {

    public static void main(String[] args) {
        new Emulador().setVisible(true);
        //String sql = "SELECCIONAR columna1,columna2 EN proyecto.archivo1 FILTRAR columna1=\"valor\" ;";
        //String sql = "SELECCIONAR columna1,columna2 EN proyecto.archivo1 FILTRAR columna1=\"valor\" OR columna1=\"valor\"  OR columna1=\"valor\";";
        //String sql = "SELECCIONAR columna1,columna2 EN proyecto.archivo1 FILTRAR columna1=\"valor\" AND columna1=\"valor\"  AND columna1=\"valor\";";
        //String sql = "SELECCIONAR * EN proyecto.archivo1 FILTRAR nombre=\"nombre\";";
        //String sql = "SELECCIONAR columna1,columna2 EN proyecto.archivo1;";

        //String sql = "INSERTAR EN proyecto.archivo1 (columna1,columna2) VALORES (\"al1\",2);";
        //String sql = "INSERTAR EN proyecto.archivo1 VALORES (\"val1\",2);";
        //String sql = "ACTUALIZAR EN proyecto.archivo1 ASIGNAR columna1=\"Valor\",columna2=2 FILTRAR columna2=1 AND columna3>=5;";
        //String sql = "ACTUALIZAR EN proyecto.archivo1 ASIGNAR columna1=\"Valor\",columna2=2;";
        //String sql = "ELIMINAR EN proyecto.archivo1 FILTRAR columna1>2;";
        //String sql = "ELIMINAR EN proyecto.archivo1; dafdadd";

//        InstrucionesLexer lexer = new InstrucionesLexer(new StringReader(sql));
//        InstruccionesParser parser = new InstruccionesParser(lexer);
//        try {
//            parser.parse();
//            System.out.println("tokes");
//            for (int i = 0; i < lexer.tokens.size(); i++) {
//                System.out.println(lexer.tokens.get(i).value.toString());
//            }
//            System.out.println("errores");
//            for (int i = 0; i < parser.errores.size(); i++) {
//                System.out.println(parser.errores.get(i).getLexema());
//            }
//
//        } catch (Exception ex) {
//            System.out.println("error en: ");
//            Logger.getLogger(EmuladorDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
