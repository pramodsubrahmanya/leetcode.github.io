package framework;

import com.sun.tools.javac.jvm.Code;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class CodeGenerator {

    public void generateHtml(Properties properties) throws Exception {
        Path path = Paths.get(getTemplateFile());
        String destination = getDestinationPath(getFilePath(properties.getProperty(TemplateKeys.title.getValue())));

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

    private String getDestinationPath(String destinationFileName) {
        return CodeConfiguration.DESTINATION_BASE_PATH.getValue() + destinationFileName;
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
        solution("page.solution");

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
        HEADER_FILE(BASE_PATH.getValue() + "header.html"),
        QUESTION_BASE_PATH(BASE_PATH.getValue() + "questions/"),
        QUESTION_FILE_EXTENSION(".question.html"),
        SOLUTION_PATH(BASE_PATH.getValue() + "java/code/"),
        PROPERTIES_PATH(SOLUTION_PATH.getValue() + "properties/");

        String value;

        CodeConfiguration(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Prop File: ");
            String propFile = br.readLine();
            Properties properties = new Properties();
            String props = CodeConfiguration.PROPERTIES_PATH.getValue() + propFile;
            properties.load(new FileInputStream(props));
            new CodeGenerator().generateHtml(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
