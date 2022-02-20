import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Parser {
    enum InstructionCode {
        IncrementPointer,
        DecrementPointer,
        Increment,
        Decrement,
        Write,
        Read,
        Loop,
    }
//    public static final int Comment = 0;
//    public static final int IncrementPointer = 1;
//    public static final int DecrementPointer = 2;
//    public static final int Increment = 3;
//    public static final int Decrement = 4;
//    public static final int Write = 5;
//    public static final int Read = 6;

    class Instruction {
        InstructionCode singleInstruction;
        List<InstructionCode> multipleInstructions = new ArrayList<>();

        public Instruction(Lexer.Token token) {
            singleInstruction = switch (token) {
                case RIGHT_ARROW -> InstructionCode.IncrementPointer;
                case LEFT_ARROW -> InstructionCode.DecrementPointer;
                case PLUS -> InstructionCode.Increment;
                case MINUS -> InstructionCode.Decrement;
                case PERIOD -> InstructionCode.Write;
                case COMMA -> InstructionCode.Read;
                default -> {
                    yield Parser.Comment;
                }
            };
        }

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
