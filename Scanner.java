/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interprete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scanner {

    private final String source;

    private final List<Token> tokens = new ArrayList<>();

    private int linea = 1;

    private char carac;

    private static final Map<String, TipoToken> palabrasReservadas;

    static {
        palabrasReservadas = new HashMap<>();
        palabrasReservadas.put("y", TipoToken.Y);
        palabrasReservadas.put("clase", TipoToken.CLASE);
        palabrasReservadas.put("ademas", TipoToken.ADEMAS);
        palabrasReservadas.put("falso", TipoToken.FALSO);
        palabrasReservadas.put("para", TipoToken.PARA);
        palabrasReservadas.put("fun", TipoToken.FUN); //definir funciones
        palabrasReservadas.put("si", TipoToken.SI);
        palabrasReservadas.put("nulo", TipoToken.NULO);
        palabrasReservadas.put("o", TipoToken.O);
        palabrasReservadas.put("imprimir", TipoToken.IMPRIMIR);
        palabrasReservadas.put("retornar", TipoToken.RETORNAR);
        palabrasReservadas.put("super", TipoToken.HIPER);
        palabrasReservadas.put("este", TipoToken.ESTE);
        palabrasReservadas.put("verdadero", TipoToken.VERDADERO);
        palabrasReservadas.put("var", TipoToken.VAR); //definir variables
        palabrasReservadas.put("mientras", TipoToken.MIENTRAS);
        //- PAREN_IZQ, PAREN_DER, LLAVE_IZQ, LLAVE_DER, COMILLA, PUNTO, PUNTO_COMA,
        //GUION, MAS, ESTRELLA, DIAGONAL, NEGACION, DIFERENTE, IGUAL, ASIGNAR, 
        //MENOR_QUE, MAYOR_QUE, MENOR_IGUAL, MAYOR_IGUAL,
        palabrasReservadas.put("(", TipoToken.PAREN_IZQ);
        palabrasReservadas.put(")", TipoToken.PAREN_DER);
        palabrasReservadas.put("{", TipoToken.LLAVE_IZQ);
        palabrasReservadas.put("}", TipoToken.LLAVE_DER);
        palabrasReservadas.put("'", TipoToken.COMILLA);
        palabrasReservadas.put(".", TipoToken.PUNTO);
        palabrasReservadas.put(";", TipoToken.PUNTO_COMA);
        palabrasReservadas.put("-", TipoToken.GUION);
        palabrasReservadas.put("+", TipoToken.MAS);
        palabrasReservadas.put("*", TipoToken.ESTRELLA);
        palabrasReservadas.put("/", TipoToken.DIAGONAL);
        palabrasReservadas.put("!", TipoToken.NEGACION);
        palabrasReservadas.put("!=", TipoToken.DIFERENTE);
        palabrasReservadas.put("==", TipoToken.IGUAL);
        palabrasReservadas.put("=", TipoToken.ASIGNAR);
        palabrasReservadas.put("<", TipoToken.MENOR_QUE);
        palabrasReservadas.put(">", TipoToken.MAYOR_QUE);
        palabrasReservadas.put("<=", TipoToken.MENOR_IGUAL);
        palabrasReservadas.put(">=", TipoToken.MAYOR_IGUAL);

    }

    Scanner(String source) {
        //  this.carac = ' ';
        this.source = source;
    }

    List<Token> scanTokens() {
        //Aquí va el corazón del scanner.
        boolean otro=false;
        int num_c = 0, estado = 0, lguardado =0;

//        for (int i = 0; i < source.length(); i++) {
//            carac = source.charAt(i);
//            if (carac == 'a') {
//                tokens.add(new Token(TipoToken.MIENTRAS, "FERF", null, 5));
//            }
//        }
        while (num_c < source.length()) {
//System.out.println("\nya pase "+num_c);

            switch (estado) {
                case 0:
                    
                    lguardado=num_c;
                    
                    if (source.charAt(num_c) == '<') {
                        num_c++;
                        estado = 1;
                        break;
                    }
                    
                    if (source.charAt(num_c) == '>') {
                        num_c++;
                        estado = 2;
                        break;
                    }  
                    
                    if (source.charAt(num_c) == '=') {
                        num_c++;
                        estado = 3;
                        break;
                    }  

                    if (source.charAt(num_c) == '!') {
                        num_c++;
                        estado = 4;
                        break;
                    }                     

                    if (source.charAt(num_c) == '(') {
                        tokens.add(new Token(TipoToken.PAREN_IZQ, "", null, linea));
                        num_c++;
                        break;
                    } 

                    if (source.charAt(num_c) == ')') {
                        tokens.add(new Token(TipoToken.PAREN_DER, "", null, linea));
                        num_c++;
                        break;
                    } 

                    if (source.charAt(num_c) == '{') {
                        tokens.add(new Token(TipoToken.LLAVE_IZQ, "", null, linea));
                        num_c++;
                        break;
                    } 

                    if (source.charAt(num_c) == '}') {
                        tokens.add(new Token(TipoToken.LLAVE_DER, "", null, linea));
                        num_c++;
                        break;
                    } 

                    if (source.charAt(num_c) == '\'') {
                        tokens.add(new Token(TipoToken.COMILLA, "", null, linea));
                        num_c++;
                        break;
                    } 

                    if (source.charAt(num_c) == ';') {
                        tokens.add(new Token(TipoToken.PUNTO_COMA, "", null, linea));
                        num_c++;
                        break;
                    } 

                    if (source.charAt(num_c) == 'y') {
                        num_c++;
                        estado = 5;
                        break;
                    } 

                    

                    break;

                   case 1:
                    
                    if (source.charAt(num_c) == '=') {
                        tokens.add(new Token(TipoToken.MENOR_IGUAL, "", null, linea));
                        num_c++;
                        estado = 0;
                        break;
                    }    
                    

                    
                    if (source.charAt(num_c) == '>') {
                        tokens.add(new Token(TipoToken.DIFERENTE, "", null, linea));                        
                        estado = 0;
                        num_c++;                        
                        otro=false;
                        break;
                    } 
                    
                    else otro=true;
                    
                    if (otro) {
                        tokens.add(new Token(TipoToken.MENOR_QUE, "", null, linea));                        
                        estado = 0;
                        otro=false;
                        break;
                    }  
                    
                    break;                    
                    
                   case 2:
                    
                    if (source.charAt(num_c) == '=') {
                        tokens.add(new Token(TipoToken.MAYOR_IGUAL, "", null, linea));
                        num_c++;
                        estado = 0;
                        otro=false;
                        break;
                    }    
                    
                    else otro=true;                      

                    if (otro) {
                        tokens.add(new Token(TipoToken.MAYOR_QUE, "", null, linea));                        
                        estado = 0;
                        otro=false;
                        break;
                    } 
                    
                  
                    
                    break;                    
                    
                   case 3:
                    
                    if (source.charAt(num_c) == '=') {
                        tokens.add(new Token(TipoToken.IGUAL, "", null, linea));
                        num_c++;
                        otro=false;
                        estado = 0;
                        break;
                    }    
                    
                    else otro=true;                    
                    

                    if (otro) {
                        tokens.add(new Token(TipoToken.ASIGNAR, "", null, linea));                        
                        estado=0;
                        otro=false;
                        break;
                    }   
                    
                    break;                    
                    
                   case 4:
                    
                    if (source.charAt(num_c) == '=') {
                        tokens.add(new Token(TipoToken.DIFERENTE, "", null, linea));
                        num_c++;
                        otro=false;
                        estado = 0;
                        break;
                    }  
                    
                    else otro=true;                    
                    

                    if (otro) {
                        tokens.add(new Token(TipoToken.NEGACION, "", null, linea));                        
                        estado = 0;
                        otro=false;
                        break;
                    }        
                    
                    break;                    
                                        
                 
                    
                    
                            

        
            }}

            
        

        /*
        Analizar el texto de entrada para extraer todos los tokens
        y al final agregar el token de fin de archivo
         */
        tokens.add(new Token(TipoToken.EOF, "", null, linea));

        return tokens;
    }
}

/*
Signos o símbolos del lenguaje:
(
)
{
}
,
.
;
-
+
*
/
!
!=
=
==
<
<=
>
>=
// -> comentarios (no se genera token)
/* ... * / -> comentarios (no se genera token)
Identificador,
Cadena
Numero
Cada palabra reservada tiene su nombre de token

 */
