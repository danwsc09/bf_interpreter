import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Parser {

    enum Instruction {
        IncrementPointer,
        DecrementPointer,
        Increment,
        Decrement,
        Write,
        Read,
        Loop
    }

    public static List<Instruction> parse(List<Lexer.Token> tokens) {
        List<Instruction> program = new ArrayList<>();
        Stack<Integer> bracketIndices = new Stack<>();

        for (int i = 0; i < tokens.size(); i++) {
            Lexer.Token token = tokens.get(i);
            switch (token) {
                case RIGHT_ARROW -> program.add(Instruction.IncrementPointer);
                case LEFT_ARROW -> program.add(Instruction.DecrementPointer);
                case PLUS -> program.add(Instruction.Increment);
                case MINUS -> program.add(Instruction.Decrement);
                case PERIOD -> program.add(Instruction.Write);
                case COMMA -> program.add(Instruction.Read);
                case BRACKET_OPEN -> bracketIndices.push(i);
                case BRACKET_CLOSE -> {
                    if (bracketIndices.isEmpty()) {
                        System.err.println("Bracket ending at #" + i + " has no matching bracket.");
                        System.exit(1);
                    } else {

                    }
                }
                case UNKNOWN -> {}
            }
        }

        return program;
    }
}
