package framework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class CodeGenerator {

    public void generateHtml(Properties properties) throws Exception {
        Path path = Paths.get(getTemplateFile());
        String destination = getDestinationPath(properties.getProperty(TemplateKeys.title.getValue()));

        String content = new String(Files.readAllBytes(path));
        content = content.replaceAll(getHandler(TemplateKeys.title.getValue()),
                properties.getProperty(TemplateKeys.title.getValue()));

        //Header
        content = content.replaceAll(getHandler(TemplateKeys.header.getValue()),
                readFile(CodeConfiguration.HEADER_FILE.getValue())
        );

        //Question
        content = content.replaceAll(getHandler(TemplateKeys.question.getValue()),
                readFile(CodeConfiguration.QUESTION_BASE_PATH.getValue() + destination
                        + CodeConfiguration.QUESTION_FILE_EXTENSION)
        );

        content = content.replaceAll(getHandler(TemplateKeys.solution.getValue()),
                properties.getProperty(TemplateKeys.solution.getValue()));

        Files.write(Paths.get(destination), content.getBytes());
    }

    private String getFilePath(String title) {
        return title.toLowerCase().replaceAll(" ", "-");
    }

    private String getDestinationPath(String title) {
        String destinationFileName = null;
        return CodeConfiguration.DESTINATION_BASE_PATH.getValue() + destinationFileName;
    }

    private String readFile(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    private String getHandler(String header) {
        return "{{" + header + "}}";
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
        solution("page.solution");

        String value;

        TemplateKeys(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum CodeConfiguration {
        BASE_PATH("./"),
        DESTINATION_BASE_PATH(BASE_PATH.getValue() + ""),
        TEMPLATE_FILE(BASE_PATH.getValue() + ""),
        HEADER_FILE(BASE_PATH.getValue() + "header.html"),
        QUESTION_BASE_PATH(BASE_PATH.getValue() + "questions/"),
        QUESTION_FILE_EXTENSION(".html");

        String value;

        CodeConfiguration(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
