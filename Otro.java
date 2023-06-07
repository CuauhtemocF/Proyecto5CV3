package mx.ipn.escom.compiladores;



import java.util.HashMap;
import java.util.Map;

public class ParsingTable {
    private final Map<String, Map<String, String>> table;

    public ParsingTable() {
        table = new HashMap<>();
        initializeTable();
    }

    private void initializeTable() {
        // Reglas de la gramática
        addAction("Q", "SELECT", "SELECT D FROM T");
        addAction("D", "DISTINCT", "DISTINCT P");
        addAction("A1", "FROM", "Ɛ");
        addAction("A3", "FROM", "Ɛ");
        addAction("D", "ASTERISCO", "P");
        addAction("P", "ASTERISCO", "ASTERISCO");

        addAction("D", "IDENTIFICADOR", "P");//

        addAction("P", "IDENTIFICADOR", "A");//
        addAction("A", "IDENTIFICADOR", "A2 A1");//
        addAction("A1", "COMA", "COMA A");//
        addAction("A2", "IDENTIFICADOR", "IDENTIFICADOR A3");//
        addAction("A3", "PUNTO", "PUNTO IDENTIFICADOR");//
        addAction("A3", "COMA", "EOF");//
        addAction("T3", "COMA", "EOF");//
        addAction("T", "IDENTIFICADOR", "T2 T1");//
        addAction("T1", "COMA", "COMA T");//
        addAction("T2", "IDENTIFICADOR", "IDENTIFICADOR T3");//
        addAction("T3", "IDENTIFICADOR", "IDENTIFICADOR");//

        addAction("T1", "EOF", "Ɛ");
        addAction("T3", "EOF", "Ɛ");



    }

    public void addAction(String nonTerminal, String terminal, String action) {
        if (!table.containsKey(nonTerminal)) {
            table.put(nonTerminal, new HashMap<>());
        }
        table.get(nonTerminal).put(terminal, action);
    }

    public String getAction(String nonTerminal, String terminal) {
        if (table.containsKey(nonTerminal)) {
            Map<String, String> row = table.get(nonTerminal);
            if (row.containsKey(terminal)) {
                return row.get(terminal);
            }
        }
        return null; // No action found for the given non-terminal and terminal
    }

}