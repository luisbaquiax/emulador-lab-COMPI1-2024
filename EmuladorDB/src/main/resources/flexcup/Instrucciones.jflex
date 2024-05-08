
/* codigo de usuario */
package com.luisbaquiax.emuladordb.lexer;
import com.luisbaquiax.emuladordb.parser.sym;
import java.util.ArrayList;

import java_cup.runtime.*;

%% //separador de area

/* opciones y declaraciones de jflex */

%class InstrucionesLexer
%public
%cup
%full
%line
%column
%char

LineTerminator = \r|\n|\r\n

WhiteSpace = {LineTerminator} | [ \t\f]

/* expresiones regulares */
numero = [0-9]
entero = [0-9]+
decimal = [0-9]+(\.[0-9]+)?
letra = [A-Za-z]
simbolo =[\-\_\@\+\*\#]
nombreArchivo = ({numero}|{simbolo}|{letra})+
//([\-\_\@\+\*\#]|[a-zA-Z0-9])+([\-\_\@\+\*\#]|[a-zA-Z0-9])*

identificador =  [a-zA-Z]+([0-9a-zA-Z])*
cadena=\"[^\"]*\"

//cadena = \".*\"

%{
public ArrayList<Symbol> tokens = new ArrayList<>();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }

  private Symbol symbol(int type, Object value, int row, int col) {
      return new Symbol(type, row+1, col+1, value);
    }


  private void error(String message) {
    System.out.println("Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
  }
%}

%% // separador de areas

/* reglas lexicas */

        "SELECCIONAR"	{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                         tokens.add(new Symbol(sym.SELECCIONAR, yytext()));
                         return symbol(sym.SELECCIONAR, yytext()); }

	    "INSERTAR"	    { System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
	                     tokens.add(new Symbol(sym.INSERTAR, yytext()));
                         return symbol(sym.INSERTAR, yytext()); }

        "ACTUALIZAR"	{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                          tokens.add(new Symbol(sym.ACTUALIZAR, yytext()));
                         return symbol(sym.ACTUALIZAR, yytext()); }

        "ELIMINAR"  	{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                         tokens.add(new Symbol(sym.ELIMINAR, yytext()));
                         return symbol(sym.ELIMINAR, yytext()); }

        "FILTRAR"       {System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                         tokens.add(new Symbol(sym.FILTRAR, yytext()));
                        return symbol(sym.FILTRAR, yytext());
                         }

        "EN"            {System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                        tokens.add(new Symbol(sym.EN, yytext()));
                        return symbol(sym.EN, yytext());
                         }

        "AND"           {System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                         tokens.add(new Symbol(sym.AND, yytext()));
                        return symbol(sym.AND, yytext());
                         }

        "OR"            {System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                         tokens.add(new Symbol(sym.OR, yytext()));
                        return symbol(sym.OR, yytext());
                         }

        "VALORES"       {System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                        tokens.add(new Symbol(sym.VALORES, yytext()));
                        return symbol(sym.VALORES, yytext());
                        }

        "ASIGNAR"       {System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                        tokens.add(new Symbol(sym.ASIGNAR, yytext()));
                        return symbol(sym.ASIGNAR, yytext());
                        }

        {cadena}	    {System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                         tokens.add(new Symbol(sym.CADENA, yytext()));
                         return symbol(sym.CADENA, yytext()); }

        {entero}		{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                         tokens.add(new Symbol(sym.ENTERO, yytext()));
                         return symbol(sym.ENTERO, yytext());}

        {decimal}	    {System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                          tokens.add(new Symbol(sym.DECIMAL, yytext()));
                         return symbol(sym.DECIMAL, yytext()); }

        {identificador}     {System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                             tokens.add(new Symbol(sym.ID, yytext()));
                            return symbol(sym.ID, yytext());

	    "="		{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
	                      tokens.add(new Symbol(sym.SIG_IGUAL, yytext()));
                         return symbol(sym.SIG_IGUAL, yytext());}

        "<"		{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                          tokens.add(new Symbol(sym.SIG_MENOR, yytext()));
                         return symbol(sym.SIG_MENOR, yytext());}

        ">"		{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                          tokens.add(new Symbol(sym.SIG_MAYOR, yytext()));
                         return symbol(sym.SIG_MAYOR, yytext());}

        "<="		{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                        tokens.add(new Symbol(sym.SIG_MENOR_QUE, yytext()));
                         return symbol(sym.SIG_MENOR_QUE, yytext());}

        ">="		{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
                    tokens.add(new Symbol(sym.SIG_MAYOR_QUE, yytext()));
                     return symbol(sym.SIG_MAYOR_QUE, yytext());}

        "<>"		{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
         tokens.add(new Symbol(sym.SIG_DIFERENTE, yytext()));
                     return symbol(sym.SIG_DIFERENTE, yytext());}

         ";"		{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
          tokens.add(new Symbol(sym.PCOMA, yytext()));
                     return symbol(sym.PCOMA, yytext());}

         "."        {System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
          tokens.add(new Symbol(sym.PUNTO, yytext()));
                    return symbol(sym.PUNTO, yytext());}

         ","        {System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
          tokens.add(new Symbol(sym.COMA, yytext()));
                    return symbol(sym.COMA, yytext());}

"*"         {
            System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
            tokens.add(new Symbol(sym.ASTERISCO, yytext()));
            return symbol(sym.ASTERISCO, yytext());
            }

"("         {System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
            tokens.add(new Symbol(sym.PARENA, yytext()));
            return symbol(sym.PARENA, yytext());}

")"         {System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
            tokens.add(new Symbol(sym.PARENC, yytext()));
            return symbol(sym.PARENC, yytext());}

{nombreArchivo}	{System.out.println("lexema:" +yytext()+  " linea: " +yyline+" columna: "+yycolumn);
	             tokens.add(new Symbol(sym.ARCHIVO, yytext()));
                 return symbol(sym.ARCHIVO, yytext()); }

	{WhiteSpace} 	{/* ignoramos */}

/* error fallback */
[^]                              /*{ throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+yyline+", column "+yycolumn); }*/
			{error("Simbolo invalido <"+ yytext()+">");}
<<EOF>>                 { return symbol(sym.EOF); }
