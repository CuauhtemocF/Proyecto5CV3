package interprete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scanner {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    private static final Map<String, TipoToken> palabrasReservadas;

    static {
        palabrasReservadas = new HashMap<>();
        palabrasReservadas.put("select", TipoToken.SELECT);
        palabrasReservadas.put("from", TipoToken.FROM);
        palabrasReservadas.put("distinct", TipoToken.DISTINCT);
    }

    Scanner(String source) {
        //  this.carac = ' ';
        this.source = source + "";
    }

    List<Token> scanTokens() {
        int estado = 0;
        char caracter = 0;
        String lexema = "";
        int inicioLexema = 0;

        for (int i = 0; i < source.length(); i++) {
            caracter = source.charAt(i);
//System.out.println("\nya pase "+num_c);

            switch (estado) {
                case 0:

                    if (caracter == '*') {
                        tokens.add(new Token(TipoToken.ASTERISCO, "*", i + 1));
                    } else if (caracter == ',') {
                        tokens.add(new Token(TipoToken.COMA, ",", i + 1));
                    } else if (caracter == '.') {
                        tokens.add(new Token(TipoToken.PUNTO, ".", i + 1));
                    } else if (Character.isAlphabetic(caracter)) {
                        estado = 1;
                        lexema = lexema + caracter;
                        inicioLexema = i;
                    }
                    break;

                case 1:
                    if (Character.isAlphabetic(caracter) || Character.isDigit(caracter)) {
                        lexema = lexema + caracter;
                    } else {
                        TipoToken tt = palabrasReservadas.get(lexema);
                        if (tt == null) {
                            tokens.add(new Token(TipoToken.IDENTIFICADOR, lexema, inicioLexema + 1));
                        } else {
                            tokens.add(new Token(tt, lexema, inicioLexema + 1));
                        }

                        estado = 0;
                        i--;
                        lexema = "";
                        inicioLexema = 0;
                    }
                    break;
            }
        }
        tokens.add(new Token(TipoToken.EOF, "", source.length()));
        return tokens;
    }
}
        /*
        Analizar el texto de entrada para extraer todos los tokens
        y al final agregar el token de fin de archivo
         */
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
