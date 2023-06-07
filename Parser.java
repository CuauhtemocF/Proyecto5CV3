package mx.ipn.escom.compiladores;
import java.util.List;
import java.util.Stack;

public class Parser
{
    private final ParsingTable parsingTable;
    private final List<Token> tokens;
    private Token prenanalisis;
    private final Token finCadena = new Token(TipoToken.EOF, "");
    public Parser(List<Token> tokens, ParsingTable parsingTable)
    {
     this.tokens = tokens;
     this.parsingTable = parsingTable;
    }
    private int i =0;
    private boolean hayErrores = false;
    private Stack<String> pila = new Stack<>();

    public void parse()
    {
        i=0;
        prenanalisis = tokens.get(i);
        pila.push("EOF");
        pila.push("Q");
        while (!pila.empty())
        {
            String simbolo = pila.peek();
            if (isTerminal(simbolo))
            {
                System.out.println("Comparo si el simbolo de la pila es un terminal"+prenanalisis.tipo+" "+simbolo+"\n");
            if (simbolo.equals(prenanalisis.tipo.toString()))
            {
                System.out.println("Veo si el tipo de token en la pila coincide con el de la tabla, por lo que se elimina la cima \n");
                pila.pop();
                if(!simbolo.equals("EOF"))
                {
                    i++;
                    prenanalisis = tokens.get(i);
                }
                else
                {
                    System.out.println("paso por 1 else \n");
                    hayErrores = true;
                    System.out.println("Error en la posición " + prenanalisis.posicion + ". Se esperaba el token " + simbolo);
                break;
                }
            }else
            {
                String accion = parsingTable.getAction(simbolo, String.valueOf(prenanalisis.tipo));
                System.out.println("Checo la tabla para "+simbolo+" y "+prenanalisis.tipo.toString()+" y se realizo "+accion+"\n");
                if(accion != null)
                {
                    System.out.println("existe la accion \n");
                    pila.pop();
                    String[] produccion = accion.split(" ");
                    for(int j= produccion.length - 1; j>=0; j--)
                    {
                        if (!produccion[j].equals("Ɛ"))
                        {
                        System.out.println("paso por 4 if \n");
                        System.out.println(produccion[j]);
                        pila.push(produccion[j]);
                        }
                    }
                }
                else {
                    System.out.println("paso por 3 else");
                    hayErrores=true;
                    System.out.println("Error en la posición" +prenanalisis.posicion +". No se encontro una accion en la tabla de analisis para el simbolo"+simbolo+" y el token "+preanalisis.tipo);
                    break;
                }
            }
            }
            if()
            {

            }
        }
    }
    ><
}