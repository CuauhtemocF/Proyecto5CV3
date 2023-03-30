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
                    
                    if (source.charAt(num_c) == '=') {
                        num_c++;
                        estado = 5;
                        break;
                    }  
                    
                    if (source.charAt(num_c) == '>') {
                        num_c++;
                        estado = 7;
                        break;
                    }  

                    if (source.charAt(num_c) == '!') {
                        num_c++;
                        estado = 10;
                        break;
                    }                     

                    if (source.charAt(num_c) == '(') {
                        num_c++;
                        estado = 13;
                        break;
                    } 

                    if (source.charAt(num_c) == ')') {
                        num_c++;
                        estado = 14;
                        break;
                    } 

                    if (source.charAt(num_c) == '{') {
                        num_c++;
                        estado = 15;
                        break;
                    } 

                    if (source.charAt(num_c) == '}') {
                        num_c++;
                        estado = 16;
                        break;
                    } 

                    if (source.charAt(num_c) == '\'') {
                        num_c++;
                        estado = 17;
                        break;
                    } 

                    if (source.charAt(num_c) == ';') {
                        num_c++;
                        estado = 18;
                        break;
                    } 

                    if (source.charAt(num_c) == '/') {
                        num_c++;
                        estado = 19;
                        break;
                    } 

                    if (source.charAt(num_c) == '>') {
                        num_c++;
                        estado = 23;
                        break;
                    } 

                    if (source.charAt(num_c) == '>') {
                        num_c++;
                        estado = 6;
                        break;
                    } 

                    if (source.charAt(num_c) == '>') {
                        num_c++;
                        estado = 6;
                        break;
                    } 


                    if (source.charAt(num_c) == '>') {
                        num_c++;
                        estado = 6;
                        break;
                    } 

                    if (source.charAt(num_c) == '>') {
                        num_c++;
                        estado = 6;
                        break;
                    } 

                    if (source.charAt(num_c) == '>') {
                        num_c++;
                        estado = 6;
                        break;
                    } 

                    if (source.charAt(num_c) == '>') {
                        num_c++;
                        estado = 6;
                        break;
                    } 


                    if (source.charAt(num_c) == '>') {
                        num_c++;
                        estado = 6;
                        break;
                    } 
                    

                    break;

                case 1:
                    System.out.println("chi ");

                    tokens.add(new Token(TipoToken.PUNTO, ".", null, linea));

                    if (source.charAt(num_c) == '.') {

                        estado = 1;
                    }
                    if (source.charAt(num_c) == '(') {
                        tokens.add(new Token(TipoToken.PAREN_IZQ, ".", null, linea));
                        estado = 2;
                    }

                    if (source.charAt(num_c) == ')') {
                        tokens.add(new Token(TipoToken.PAREN_DER, ".", null, linea));
                        estado = 3;
                        break;
                    }

                    if (source.charAt(num_c) == '{') {
                        tokens.add(new Token(TipoToken.LLAVE_IZQ, ".", null, linea));
                        estado = 4;
                    }

                    if (source.charAt(num_c) == '}') {
                        tokens.add(new Token(TipoToken.LLAVE_DER, ".", null, linea));
                        estado = 5;

                    }

                    if (source.charAt(num_c) == ';') {
                        tokens.add(new Token(TipoToken.PUNTO_COMA, ".", null, linea));
                        estado = 7;
                    }

                    if (source.charAt(num_c) == '-') {
                        tokens.add(new Token(TipoToken.GUION, ".", null, linea));
                        estado = 8;
                    }

                    if (source.charAt(num_c) == '+') {
                        tokens.add(new Token(TipoToken.MAS, ".", null, linea));
                        estado = 9;
                    }

                    if (source.charAt(num_c) == '*') {
                        tokens.add(new Token(TipoToken.ESTRELLA, ".", null, linea));
                        estado = 10;
                    }

                    if (source.charAt(num_c) == '/') {
                        tokens.add(new Token(TipoToken.GUION, ".", null, linea));
                        estado = 11;
                    }

                    if (source.charAt(num_c) == '!') {
                        tokens.add(new Token(TipoToken.NEGACION, ".", null, linea));
                        estado = 12;
                    }

                    if (source.charAt(num_c) == '=') {
                        tokens.add(new Token(TipoToken.ASIGNAR, ".", null, linea));
                        estado = 14;
                    }

                    if (source.charAt(num_c) == '<') {
                        tokens.add(new Token(TipoToken.MENOR_QUE, ".", null, linea));
                        estado = 16;
                    }

                    if (source.charAt(num_c) == '>') {
                        tokens.add(new Token(TipoToken.MAYOR_QUE, ".", null, linea));
                        estado = 18;
                    }
                    estado = 0;
                    break;

                case 3:
                    if (source.charAt(num_c) == 'a') {
                        num_c++;
                        estado = n+1;
                            if (source.charAt(num_c) == 'd') {
                                num_c++;
                                estado = n+1;
                                if (source.charAt(num_c) == 'e') {
                                    num_c++;
                                    estado = n+1;
                                    if (source.charAt(num_c) == 'm') {
                                        num_c++;
                                        estado = n+1;
                                        if (source.charAt(num_c) == 'a') {
                                            num_c++;
                                            estado = n+1;
                                            if (source.charAt(num_c) == 's') {
                                                num_c++;
                                                estado = n+1;
                                                break;
                                        }
                                            break;
                                    }
                                        break;
                                }
                                    break;
                            }
                                break;
                        }
                            break;
                    }
                    break;
                case 4:
                    if (source.charAt(num_c) == 'b') {
                        num_c++;
                        estado = n+1;
                    }
                    break;
                case 5:
                    if (source.charAt(num_c) == 'c') {
                        num_c++;
                        estado = n+1;
                        if (source.charAt(num_c) == 'l') {
                            num_c++;
                            estado = n+1;
                            if (source.charAt(num_c) == 'a') {
                                num_c++;
                                estado = n+1;
                                if (source.charAt(num_c) == 's') {
                                    num_c++;
                                    estado = n+1;
                                    if (source.charAt(num_c) == 'e') {
                                        num_c++;
                                        estado = n+1;
                                        break;
                                    }
                                    break;
                                }
                                
                            }

                        }

                    }
                    break;
                case 6:
                    if (source.charAt(num_c) == 'd') {
                        num_c++;
                        estado = n+1;
                    }
                    break;
                case 7:
                    if (source.charAt(num_c) == 'e') {
                        num_c++;
                        estado = n+1;
                        if (source.charAt(num_c) == 's') {
                            num_c++;
                            estado = n+1;
                            if (source.charAt(num_c) == 't') {
                                num_c++;
                                estado = n+1;
                                if (source.charAt(num_c) == 'e') {
                                    num_c++;
                                    estado = n+1;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 8:
                    if (source.charAt(num_c) == 'f') {
                        num_c++;
                        estado = n+1;
                        if (source.charAt(num_c) == 'a') {
                            num_c++;
                            estado = n+1;
                            if (source.charAt(num_c) == 'l') {
                                num_c++;
                                estado = n+1;
                                if (source.charAt(num_c) == 's') {
                                    num_c++;
                                    estado = n+1;
                                    if (source.charAt(num_c) == 'o') {
                                        num_c++;
                                        estado = n+1;
                                        break;
                                    }
                                }
                            }
                        }
                        if (source.charAt(num_c) == 'u') {
                            num_c++;
                            estado = n+1;
                            if (source.charAt(num_c) == 'n') {
                                num_c++;
                                estado = n+1;
                            }
                        }
                    }
                    break;
                case 9:
                    if (source.charAt(num_c) == 'g') {
                        num_c++;
                        estado = n+1;
                    }
                    break;
                case 10:
                    if (source.charAt(num_c) == 'h') {
                        num_c++;
                        estado = n+1;
                        if (source.charAt(num_c) == 'i') {
                            num_c++;
                            estado = n+1;
                            if (source.charAt(num_c) == 'p') {
                                num_c++;
                                estado = n+1;
                                if (source.charAt(num_c) == 'e') {
                                    num_c++;
                                    estado = n+1;
                                    if (source.charAt(num_c) == 'r') {
                                        num_c++;
                                        estado = n+1;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 11:
                    if (source.charAt(num_c) == 'i') {
                        num_c++;
                        estado = n+1;
                        if (source.charAt(num_c) == 'm') {
                            num_c++;
                            estado = n+1;
                            if (source.charAt(num_c) == 'p') {
                                num_c++;
                                estado = n+1;
                                if (source.charAt(num_c) == 'r') {
                                    num_c++;
                                    estado = n+1;
                                    if (source.charAt(num_c) == 'i') {
                                        num_c++;
                                        estado = n+1;
                                        if (source.charAt(num_c) == 'm') {
                                            num_c++;
                                            estado = n+1;
                                            if (source.charAt(num_c) == 'i') {
                                                num_c++;
                                                estado = n+1;
                                                if (source.charAt(num_c) == 'r') {
                                                    num_c++;
                                                    estado = n+1;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 12:
                    if (source.charAt(num_c) == 'j') {
                        num_c++;
                        estado = n+1;
                    }
                    break;
                case 13:
                    if (source.charAt(num_c) == 'k') {
                        num_c++;
                        estado = n+1;
                    }
                    break;
                case 14:
                    if (source.charAt(num_c) == 'l') {
                        num_c++;
                        estado = n+1;
                    }
                    break;
                case 15:
                    if (source.charAt(num_c) == 'm') {
                        num_c++;
                        estado = n+1;
                        if (source.charAt(num_c) == 'i') {
                            num_c++;
                            estado = n+1;
                            if (source.charAt(num_c) == 'e') {
                                num_c++;
                                estado = n+1;
                                if (source.charAt(num_c) == 'n') {
                                    num_c++;
                                    estado = n+1;
                                    if (source.charAt(num_c) == 't') {
                                        num_c++;
                                        estado = n+1;
                                        if (source.charAt(num_c) == 'r') {
                                            num_c++;
                                            estado = n+1;
                                            if (source.charAt(num_c) == 'a') {
                                                num_c++;
                                                estado = n+1;
                                                if (source.charAt(num_c) == 's') {
                                                    num_c++;
                                                    estado = n+1;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 16:
                    if (source.charAt(num_c) == 'n') {
                        num_c++;
                        estado = n+1;
                        if (source.charAt(num_c) == 'u') {
                            num_c++;
                            estado = n+1;
                            if (source.charAt(num_c) == 'l') {
                                num_c++;
                                estado = n+1;
                                if (source.charAt(num_c) == 'o') {
                                    num_c++;
                                    estado = n+1;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 17:
                    if (source.charAt(num_c) == 'o') {
                        num_c++;
                        estado = n+1;
                    }
                    break;
                case 18:
                    if (source.charAt(num_c) == 'p') {
                        num_c++;
                        estado = n+1;
                        if (source.charAt(num_c) == 'a') {
                            num_c++;
                            estado = n+1;
                            if (source.charAt(num_c) == 'r') {
                                num_c++;
                                estado = n+1;
                                if (source.charAt(num_c) == 'a') {
                                    num_c++;
                                    estado = n+1;
                                }
                            }
                        }
                    }
                    break;
                case 19:
                    if (source.charAt(num_c) == 'q') {
                        num_c++;
                        estado = n+1;
                    }
                    break;
                case 20:
                    if (source.charAt(num_c) == 'r') {
                        num_c++;
                        estado = n+1;
                        if (source.charAt(num_c) == 'e') {
                            num_c++;
                            estado = n+1;
                            if (source.charAt(num_c) == 't') {
                                num_c++;
                                estado = n+1;
                                if (source.charAt(num_c) == 'o') {
                                    num_c++;
                                    estado = n+1;
                                    if (source.charAt(num_c) == 'r') {
                                        num_c++;
                                        estado = n+1;
                                        if (source.charAt(num_c) == 'n') {
                                            num_c++;
                                            estado = n+1;
                                            if (source.charAt(num_c) == 'a') {
                                                num_c++;
                                                estado = n+1;
                                                if (source.charAt(num_c) == 'r') {
                                                    num_c++;
                                                    estado = n+1;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 21:
                    if (source.charAt(num_c) == 's') {
                        num_c++;
                        estado = n+1;
                        if (source.charAt(num_c) == 'i') {
                            num_c++;
                            estado = n+1;
                        }
                    }
                    break;
                case 22:
                    if (source.charAt(num_c) == 't') {
                        num_c++;
                        estado = n+1;
                    }
                    break;
                case 23:
                    if (source.charAt(num_c) == 'v') {
                        num_c++;
                        estado = n+1;
                        if (source.charAt(num_c) == 'e') {
                            num_c++;
                            estado = n+1;
                            if (source.charAt(num_c) == 'r') {
                                num_c++;
                                estado = n+1;
                                if (source.charAt(num_c) == 'd') {
                                    num_c++;
                                    estado = n+1;
                                    if (source.charAt(num_c) == 'a') {
                                        num_c++;
                                        estado = n+1;
                                        if (source.charAt(num_c) == 'd') {
                                            num_c++;
                                            estado = n+1;
                                            if (source.charAt(num_c) == 'e') {
                                                num_c++;
                                                estado = n+1;
                                                if (source.charAt(num_c) == 'r') {
                                                    num_c++;
                                                    estado = n+1;
                                                    if (source.charAt(num_c) == 'o') {
                                                        num_c++;
                                                        estado = n+1;
                                                        if (source.charAt(num_c) == ' ') {
                                                            num_c++;
                                                            estado = n+1;
                                                            if (source.charAt(num_c) == 'v') {
                                                                num_c++;
                                                                estado = n+1;
                                                                if (source.charAt(num_c) == 'a') {
                                                                    num_c++;
                                                                    estado = n+1;
                                                                    if (source.charAt(num_c) == 'r') {
                                                                        num_c++;
                                                                        estado = n+1;
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    else {
                                                        num_c++;
                                                        estado = n+1;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 24:
                    if (source.charAt(num_c) == 'w') {
                        num_c++;
                        estado = n+1;
                    }
                    break;
                case 25:
                    if (source.charAt(num_c) == 'x') {
                        num_c++;
                        estado = n+1;
                    }
                    break;
                case 26:
                    if (source.charAt(num_c) == 'y') {
                        num_c++;
                        estado = n+1;
                    }
                    break;
                case 27:
                    if (source.charAt(num_c) == 'z') {
                        num_c++;
                        estado = n+1;
                    }
                    break;
            }

            num_c++;
        }

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
