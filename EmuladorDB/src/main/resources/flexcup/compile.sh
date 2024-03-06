#! /bin/bashecho "STARTING JFLEX COMPILING"
echo "STARTING JFLEX COMPILING"
java -jar "C:\Users\Usuario\Desktop\Lenguajes y compiladores\jflex-full-1.9.1.jar" -d "C:\Users\Usuario\Desktop\Lenguajes y compiladores\emulador-lab-COMPI1-2024\EmuladorDB\src\main\java\com\luisbaquiax\emuladordb\lexer" "C:\Users\Usuario\Desktop\Lenguajes y compiladores\emulador-lab-COMPI1-2024\EmuladorDB\src\main\resources\flexcup\EmuladorDBlexer.jflex"

echo "STARTING CUP COMPILING"
java -jar "C:\Users\Usuario\Desktop\Lenguajes y compiladores\java-cup-11.jar" -parser EmuladorDBparser "C:\Users\Usuario\Desktop\Lenguajes y compiladores\emulador-lab-COMPI1-2024\EmuladorDB\src\main\resources\flexcup\EmuladorDBparser.cup"
move EmuladorDBparser.java "C:\Users\Usuario\Desktop\Lenguajes y compiladores\emulador-lab-COMPI1-2024\EmuladorDB\src\main\java\com\luisbaquiax\emuladordb\parser\EmuladorDBparser.java"
move sym.java "C:\Users\Usuario\Desktop\Lenguajes y compiladores\emulador-lab-COMPI1-2024\EmuladorDB\src\main\java\com\luisbaquiax\emuladordb\parser\sym.java"

#! /bin/bashecho "STARTING JFLEX COMPILING"
echo "STARTING JFLEX COMPILING"
java -jar "C:\Users\Usuario\Desktop\Lenguajes y compiladores\jflex-full-1.9.1.jar" -d "C:\Users\Usuario\Desktop\Lenguajes y compiladores\emulador-lab-COMPI1-2024\EmuladorDB\src\main\java\com\luisbaquiax\emuladordb\lexer" "C:\Users\Usuario\Desktop\Lenguajes y compiladores\emulador-lab-COMPI1-2024\EmuladorDB\src\main\resources\flexcup\Instrucciones.jflex"

echo "STARTING CUP COMPILING"
java -jar "C:\Users\Usuario\Desktop\Lenguajes y compiladores\java-cup-11.jar" -parser InstruccionesParser "C:\Users\Usuario\Desktop\Lenguajes y compiladores\emulador-lab-COMPI1-2024\EmuladorDB\src\main\resources\flexcup\Instrucciones.cup"

move InstruccionesParser.java "C:\Users\Usuario\Desktop\Lenguajes y compiladores\emulador-lab-COMPI1-2024\EmuladorDB\src\main\java\com\luisbaquiax\emuladordb\parser\InstruccionesParser.java"
move sym.java "C:\Users\Usuario\Desktop\Lenguajes y compiladores\emulador-lab-COMPI1-2024\EmuladorDB\src\main\java\com\luisbaquiax\emuladordb\parser\sym.java"
