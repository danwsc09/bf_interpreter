import java.util.List;

public class Instruction {
    Parser.InstructionCode instructionCode;
    List<Instruction> instructions;

    public Instruction(Lexer.Token token) {
        instructionCode = tokenToCode(token);
    }

    public Instruction(Lexer.Token token, List<Instruction> instructionList) {
        instructionCode = tokenToCode(token);
        instructions = instructionList;
    }

    private Parser.InstructionCode tokenToCode(Lexer.Token token) {
        return switch (token) {
            case RIGHT_ARROW -> Parser.InstructionCode.IncrementPointer;
            case LEFT_ARROW -> Parser.InstructionCode.DecrementPointer;
            case PLUS -> Parser.InstructionCode.Increment;
            case MINUS -> Parser.InstructionCode.Decrement;
            case PERIOD -> Parser.InstructionCode.Write;
            case COMMA -> Parser.InstructionCode.Read;
            default -> Parser.InstructionCode.Loop;
        };
    }

    public String toString() {
        return "Code " + this.instructionCode;
    }
}