package day05;

import day04.DataWithDifference;
import day04.Position;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFileReader {

    public String findSmallestDifferenceName() {
        List<String> lines;
        lines = readLines(Path.of("src/main/resources/datamunging/" + getFilename()));
        lines = filterLines(lines, getFilteredIndexes());

        List<DataWithDifference> data = extractData(lines,getNamePosition(), getValue1Position(), getValue2Position());
        return findMin(data).getName();
    }

    public abstract String getFilename();
    public abstract List<Integer> getFilteredIndexes();
    public abstract Position getNamePosition();
    public abstract Position getValue1Position();
    public abstract Position getValue2Position();

    private List<String> readLines(Path path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file!", ioe);
        }
        return lines;
    }

    private List<String> filterLines(List<String> lines, List<Integer> filtered) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            if (!filtered.contains(i)) {
                result.add(lines.get(i));
            }
        }
        return result;
    }

    private List<DataWithDifference> extractData(List<String> lines, Position namePosition, Position value1Position, Position value2Position) {
        List<DataWithDifference> result = new ArrayList<>();
        for (String line : lines) {
            String name = namePosition.getAsString(line);
            int value1 = value1Position.getAsInt(line);
            int value2 = value2Position.getAsInt(line);
            result.add(new DataWithDifference(name, value1, value2));
        }
        return result;
    }

    private DataWithDifference findMin(List<DataWithDifference> data) {
        DataWithDifference min = data.get(0);
        for (DataWithDifference item: data) {
            if (item.getDifference() <  min.getDifference()) {
                min = item;
            }
        }
        return min;
    }
}
