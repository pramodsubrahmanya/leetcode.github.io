package framework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileGenerator {

    public static void main(String[] args) throws IOException {
        String title = "Binary Gap";
        String solutionFileName = "BinaryGap";
        new FileGenerator().generate(title, solutionFileName);
    }

    void generate(String title, String solutionFileName) throws IOException {
        generatePropFile(title, solutionFileName);
        generateQuestionFile(title);
        generateSolutionFile(title, solutionFileName);
        System.out.println("Done");
    }

    void generatePropFile(String title, String solutionFileName) throws IOException {
        String props = "page.title=" + title + "\n" +
                "page.solution=" + solutionFileName + ".java";
        Files.write(Paths.get(CodeGenerator.CodeConfiguration.PROPERTIES_PATH.getValue()
                + CodeGenerator.titleToFileName(title)
                + ".properties"
        ), props.getBytes());
    }

    void generateQuestionFile(String title) throws IOException {
        String fileName = CodeGenerator.titleToFileName(title) + CodeGenerator.CodeConfiguration.QUESTION_FILE_EXTENSION.getValue();
        Files.write(Paths.get(CodeGenerator.CodeConfiguration.QUESTION_BASE_PATH.getValue() + fileName), "".getBytes());
    }

    void generateSolutionFile(String title, String solutionFileName) throws IOException {
        String content = "package code;\n" +
                "\n" +
                "public class " + solutionFileName + " {\n}";
        String path = CodeGenerator.CodeConfiguration.SOLUTION_PATH.getValue() + solutionFileName + ".java";
        if (!Files.exists(Paths.get(path))) {
            Files.write(Paths.get(path), content.getBytes());
        }
    }
}
