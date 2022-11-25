package com.shuzijun.plantumlparser.core;

import org.junit.ClassRule;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Test {
    @ClassRule
    public static TemporaryFolder temporaryFolder = new TemporaryFolder();

    @org.junit.Test
    public void test() throws IOException {
        File outputFile = outputApacheCommonsCsvPUml();
        File expect = new File("src/test/java/com/shuzijun/plantumlparser/core/ApacheCommonsCsv_original.puml");

        assertArrayEquals(Files.readAllLines(expect.toPath(), StandardCharsets.UTF_8).toArray(String[]::new),
                Files.readAllLines(outputFile.toPath(), StandardCharsets.UTF_8).toArray(String[]::new));
    }

    private static File outputApacheCommonsCsvPUml() throws IOException {
        File outputFile = temporaryFolder.newFile();

        ParserConfig parserConfig=new ParserConfig();
        parserConfig.addFilePath("D:\\git\\commons-csv\\src\\main\\java\\org\\apache\\commons\\csv");
        parserConfig.addExcludeClassRegex("Test");
        parserConfig.setOutFilePath(outputFile.getAbsolutePath());

        // メソッド、フィールドは全て出力
        List<String> modifiers = List.of("public", "default", "protected", "private");
        modifiers.stream().forEach(parserConfig::addFieldModifier);
        modifiers.stream().forEach(parserConfig::addMethodModifier);

        ParserProgram parserProgram=new ParserProgram(parserConfig);
        parserProgram.execute();

        return outputFile;
    }

}
