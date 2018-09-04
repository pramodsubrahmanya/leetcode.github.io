package framework;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class CodeGenerator {

    public void generateHtml(String destinationFileName, Properties properties) throws Exception {
        Path path = Paths.get(getTemplateFile());
        String content = new String(Files.readAllBytes(path));
        content = content.replaceAll(getHandler(TemplateKeys.title.getValue()),
                properties.getProperty(TemplateKeys.title.getValue()));
        content = content.replaceAll(getHandler(TemplateKeys.header.getValue()),
                properties.getProperty(TemplateKeys.header.getValue()));
        content = content.replaceAll(getHandler(TemplateKeys.question.getValue()),
                properties.getProperty(TemplateKeys.question.getValue()));
        content = content.replaceAll(getHandler(TemplateKeys.solution.getValue()),
                properties.getProperty(TemplateKeys.solution.getValue()));
        String destination = getDestinationPath(destinationFileName);
        Files.write(Paths.get(destination), content.getBytes());
    }

    private String getDestinationPath(String destinationFileName) {
        return CodeConfiguration.DESTINATION_BASE_PATH.getValue() + destinationFileName;
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
        HEADER_FILE(BASE_PATH.getValue() + "");

        String value;

        CodeConfiguration(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
