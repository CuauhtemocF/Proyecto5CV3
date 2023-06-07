package mx.ipn.escom.compiladores;
import java.util.Hashmap;
import java.util.Map;

public class ParsingTable()
{
table = new Hashmap<>();
initializeTable();
}

private void initializeTable()
{
    //Reglas de la gramatica
    addAction("Q","SELECT", "SELECT D FROM T");
    addAction("Q","FROM", "FROM T");
    addAction("D","DISTINCT", "DISTINCT P");
    addAction("D","ASTERISCO", "P");
    addAction("Q","SELECT", "SELECT D FROM T");
    addAction("Q","SELECT", "SELECT D FROM T");
    addAction("Q","SELECT", "SELECT D FROM T");
    addAction("Q","SELECT", "SELECT D FROM T");
}
