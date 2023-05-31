/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author CubeMora
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LexicalAnalizer {

    public static void main(String[] args) {
        String sourceFile = "source_code.txt";
        String outputFile = "token_output.txt";

        try {
            List<String> tokenLines = analyzeTokens(sourceFile);
            writeTokenOutput(outputFile, tokenLines);
            System.out.println("Token analysis completed. Output written to " + outputFile);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private static List<String> analyzeTokens(String sourceFile) throws IOException {
        List<String> tokenLines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        String line;

        while ((line = reader.readLine()) != null) {
            List<String> tokens = identifyTokens(line);
            String tokenLine = String.join(", ", tokens);
            tokenLines.add(tokenLine);
        }

        reader.close();
        return tokenLines;
    }

    private static List<String> identifyTokens(String line) {
        List<String> tokens = new ArrayList<>();
        String[] words = line.split("\\s+"); // Split line by whitespace

        for (String word : words) {
            // Check for different token patterns
            if (word.matches("^\\$[A-Za-z0-9]+$")) {
                tokens.add("Identifier: " + word);

            } else if (word.matches("^[0-9]+$")) {
                tokens.add("Whole Number: " + word);
            } else if (word.matches("^[0-9]+\\.[0-9]+$")) {
                tokens.add("Decimal Number: " + word);
            } else if (word.matches("^'[^']*'$")) {
                tokens.add("String: " + word);
            } else if (word.matches("^/\\*.*\\*/$")) {
                tokens.add("Comment: " + word);
            } else if (isReservedWord(word)) {
                tokens.add("Reserved Word: " + word);
            } else if (isOperator(word)) {
                tokens.add("Operator: " + word);
            } else if (isDelimitator(word)) {
                tokens.add("Delimitator: " + word);
            } else {
                tokens.add("Invalid Token: " + word);
            }
        }

        return tokens;
    }

    private static boolean isReservedWord(String word) {
        String[] reservedWords = {
            "init", "end!", "array", "then", "var", "endif", "integer", "repeat", "else", "until",
            "string", "for", "while", "do", "if", "char", "while", "bool", "read", "true", "false",
            "of", "decimal"
        };

        for (String reserved : reservedWords) {
            if (reserved.equals(word)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isOperator(String word) {
        String[] operators = {
            "=", ">", "<", ">=", "<=", "!=", "==", "+", "-", "*", "/", "||", "&&", "!"
        };

        for (String operator : operators) {
            if (operator.equals(word)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isDelimitator(String word) {
        String[] delimitators = {
            "{", "}", "(", ")", "[", "]", ";", ":"
        };

        for (String delimitator : delimitators) {
            if (delimitator.equals(word)) {
                return true;
            }
        }

        return false;
    }

    private static void writeTokenOutput(String outputFile, List<String> tokenLines) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        for (String tokenLine : tokenLines) {
            writer.write(tokenLine);
            writer.newLine();
        }

        writer.close();
    }
}
