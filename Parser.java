package mx.ipn.escom.compiladores;
import java.util.List;
import java.util.Stack;

public class Parser {

    private final ParsingTable parsingTable;
    private final List<Token> tokens;
    private Token preanalisis;

    private final Token finCadena = new Token(TipoToken.EOF, "");

    public Parser(List<Token> tokens, ParsingTable parsingTable) {
        this.tokens = tokens;
        this.parsingTable = parsingTable;
    }




    private int i = 0;
    private boolean hayErrores = false;


    private final Stack<String> pila = new Stack<>();









    public void parse() {
        i = 0;
        preanalisis = tokens.get(i);
        pila.push("EOF");
        pila.push("Q");

        while (!pila.peek().equals("EOF")) {
            String simbolo = pila.peek();
            if (isTerminal(simbolo)) {
                //System.out.println("COMPARO SI EL SIMBOLO DE LA PILA ES UN TERMINAL "+preanalisis.tipo+" "+simbolo+"\n");
                if (simbolo.equals(preanalisis.tipo.toString())) {
                    // System.out.println("VEO SI EL TIPO DE TOKEN EN PILA COINCIDE CON EL DE LA TABLA, POR LO QUE ELIMINO EL DE LA CIMA \n");
                    pila.pop();

                    i++;
                    preanalisis = tokens.get(i);
                } else {
                    //  System.out.println("paso por 1 else \n");
                    hayErrores = true;
                    System.out.println("Error en la posición " + preanalisis.posicion + ". Se esperaba el token " + simbolo);
                    break;
                }
            } else {
                String accion = parsingTable.getAction(simbolo, String.valueOf(preanalisis.tipo));
                //System.out.println("CHECO LA TABLA PARA "+simbolo+" y "+preanalisis.tipo.toString()+" y realizo "+accion+"\n");

                if (accion != null) {
                    // System.out.println("existe la accion  \n");
                    pila.pop();
                    String[] produccion = accion.split(" ");
                    for (int j = produccion.length - 1; j >= 0; j--) {
                        if (!produccion[j].equals("Ɛ")) {
                            // System.out.println("paso por 4 if \n");
                            // System.out.println(produccion[j]);
                            pila.push(produccion[j]);
                        }
                    }
                } else {
                    //  System.out.println("paso por 3 else \n");
                    hayErrores = true;
                    System.out.println("Error en la posición " + preanalisis.posicion + ". No se encontró una acción en la tabla de análisis para el símbolo " + simbolo + " y el token " + preanalisis.tipo);
                    break;
                }
            }
        }

        if (!hayErrores && preanalisis.equals(finCadena)) {
            System.out.println("Consulta válida");
        }
    }

    private boolean isTerminal(String simbolo) {
        return simbolo.equals("SELECT") || simbolo.equals("DISTINCT") || simbolo.equals("ASTERISCO") || simbolo.equals("IDENTIFICADOR") || simbolo.equals("COMA") || simbolo.equals("PUNTO") ||  simbolo.equals("FROM") ||simbolo.equals("EOF");
    }
}

