package hu.nive.ujratervezes.zarovizsga.people;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class People {


    public int getNumberOfMales(String file) {
        try (Stream<String> s = Files.lines(Path.of(file))) {
            return (int) s
                    .map(x -> x.split(",")[4])
                    .filter(x -> x.contains("Male"))
                    .count();


        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }
}
