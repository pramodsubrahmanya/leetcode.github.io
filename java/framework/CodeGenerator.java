package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;
import java.util.stream.Stream;

public class CodeGenerator {

    public CodeGenerator() {
        try {
            Files.write(Paths.get(CodeConfiguration.PROBLEMS_FILE.getValue()), "".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        CodeGenerator generator = new CodeGenerator();
        Stream<Path> list = Files.list(Paths.get(CodeConfiguration.PROPERTIES_PATH.getValue()));
        list.forEach(file -> {
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream(file.toFile().getAbsolutePath()));
                generator.generateHtml(properties);
                System.out.println("Generated : " + file.getFileName());
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

    public void generateHtml(Properties properties) throws Exception {
        Path path = Paths.get(getTemplateFile());
        String title = properties.getProperty(TemplateKeys.title.getValue());
        String filePrefix = getFilePath(title);
        String destination = getDestinationPath(filePrefix);

        String content = new String(Files.readAllBytes(path));
        content = content.replaceAll(getHandler(TemplateKeys.title.getValue()),
                properties.getProperty(TemplateKeys.title.getValue()));

        //Header
        content = content.replaceAll(getHandler(TemplateKeys.header.getValue()),
                readFile(CodeConfiguration.HEADER_FILE.getValue())
        );

        //Question
        content = content.replaceAll(getHandler(TemplateKeys.question.getValue()),
                readFile(CodeConfiguration.QUESTION_BASE_PATH.getValue() + filePrefix
                        + CodeConfiguration.QUESTION_FILE_EXTENSION.getValue())
        );

        //Solution
        String solutionPath = CodeConfiguration.SOLUTION_PATH.getValue()
                + properties.getProperty(TemplateKeys.solution.getValue());
        content = content.replaceAll(getHandler(TemplateKeys.solution.getValue()),
                readFile(solutionPath)
        );

        //Disqus
        content = content.replaceAll(getHandler(TemplateKeys.disqus.getValue()),
                filePrefix
        );

        Files.write(Paths.get(destination), content.getBytes());
        addToIndex(filePrefix + CodeConfiguration.HTML_EXTENSION.getValue(), title, "LeetCode");
    }

    public void addToIndex(String filename, String title, String website) throws IOException {
        String line = "<tr>\n" +
                "    <td><a href=\"http://code.groupsone.com/p/" + filename + "\">" + title + "</a></td>\n" +
                "    <td>" + website + "</td>\n" +
                "</tr>";
        Files.write(Paths.get(CodeConfiguration.PROBLEMS_FILE.getValue()), line.getBytes(), StandardOpenOption.APPEND);
    }


    private String getFilePath(String title) {
        return title.toLowerCase().replaceAll(" ", "-");
    }

    private String getDestinationPath(String destinationFileName) {
        return CodeConfiguration.DESTINATION_BASE_PATH.getValue()
                + destinationFileName + CodeConfiguration.HTML_EXTENSION.getValue();
    }

    private String readFile(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    private String getHandler(String header) {
        return "\\{\\{" + header + "\\}\\}";
    }

    private String getTemplateFile() {
        return CodeConfiguration.TEMPLATE_FILE.getValue();
    }

    String getHeaderFile() {
        return CodeConfiguration.HEADER_FILE.getValue();
    }

    public enum TemplateKeys {
        title("page.title"),
        header("page.header"),
        question("page.question"),
        solution("page.solution"),
        disqus("page.disqus.identifier");

        String value;

        TemplateKeys(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    static enum CodeConfiguration {
        BASE_PATH(System.getProperty("user.dir") + "/"),
        DESTINATION_BASE_PATH(BASE_PATH.getValue() + "p/"),
        TEMPLATE_FILE(BASE_PATH.getValue() + "public/templates/codetemplate.html"),
        PROBLEMS_FILE(BASE_PATH.getValue() + "public/templates/problems.html"),
        HEADER_FILE(BASE_PATH.getValue() + "header.html"),
        QUESTION_FILE_EXTENSION(".question.html"),
        SOLUTION_PATH(BASE_PATH.getValue() + "java/code/"),
        QUESTION_BASE_PATH(SOLUTION_PATH.getValue() + "questions/"),
        PROPERTIES_PATH(SOLUTION_PATH.getValue() + "properties/"),
        HTML_EXTENSION(".html");

        String value;

        CodeConfiguration(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
