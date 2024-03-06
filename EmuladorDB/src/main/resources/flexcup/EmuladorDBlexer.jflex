
/* codigo de usuario */
package com.luisbaquiax.emuladordb.lexer;
import java.util.ArrayList; 

import java_cup.runtime.*;

%% //separador de area

/* opciones y declaraciones de jflex */

%class EmuladorDBLexer
%public
%cup
%full
%line
%column
%char

LineTerminator = \r|\n|\r\n

WhiteSpace = {LineTerminator} | [ \t\f]

/* integer literals */
numero = [0-9]
letra = [A-Za-z]
simbolo =[-_@+*#]
nombreArchivo = ({simbolo} | {letra} | {numero})+

%{

  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }

  private void error(String message) {
    System.out.println("Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
  }
   
%}

%% // separador de areas

/* reglas lexicas */

        "PROYECTO"	{
                         System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                         return symbol(sym.PROYECTO, yytext()); }

	"CARPETA"	{ System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                          return symbol(sym.CARPETA, yytext()); }

        "ARCHIVO"	{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                         return symbol(sym.ARCHIVO, yytext()); }

        "nombre"	{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                         return symbol(sym.NOMBRE, yytext()); }

        "\""		{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                         return symbol(sym.COMILLA, yytext());}

        "ubicacion"	{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                         return symbol(sym.UBICACION, yytext()); }

        "\/"            {System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                         return symbol(sym.DIAGONAL, yytext()); }

	{nombreArchivo}	{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                         return symbol(sym.NOMBRE_ARCHIVO, yytext()); }

	"="		{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                         return symbol(sym.SIGNO_IGUAL, yytext());}

        "<"		{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                         return symbol(sym.MENOR, yytext());}

        ">"		{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                         return symbol(sym.MAYOR, yytext());}
        
	{WhiteSpace} 	{/* ignoramos */}



/* error fallback */
[^]                              /*{ throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+yyline+", column "+yycolumn); }*/
			{
                        lexError = new LexerError(yytext(),"Error léxico.",(yyline+1),(yycolumn+1));
                        errores.add(lexError); 
                        error("Simbolo invalido <"+ yytext()+">");
                        }
<<EOF>>                 { return symbol(sym.EOF); }