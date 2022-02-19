import java.util.ArrayList;
import java.util.List;

public class Lexer {
    enum Token {
        RIGHT_ARROW,
        LEFT_ARROW,
        PLUS,
        MINUS,
        PERIOD,
        COMMA,
        BRACKET_OPEN,
        BRACKET_CLOSE,
        UNKNOWN
    }

    public static Token tokenize(char ch) {
        return switch (ch) {
            case '>' -> Token.RIGHT_ARROW;
            case '<' -> Token.LEFT_ARROW;
            case '+' -> Token.PLUS;
            case '-' -> Token.MINUS;
            case '.' -> Token.PERIOD;
            case ',' -> Token.COMMA;
            case '[' -> Token.BRACKET_OPEN;
            case ']' -> Token.BRACKET_CLOSE;
            default -> Token.UNKNOWN;
        };
    }

    public static List<Token> lex(String input) {
        List<Token> operation = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            Token token = tokenize(ch);
            if (token != Token.UNKNOWN) {
                operation.add(token);
            }
        }
        return operation;
    }
}
