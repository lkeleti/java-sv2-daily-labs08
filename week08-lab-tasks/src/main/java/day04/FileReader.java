package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReader {

    public String findSmallestTeamDifference(String fileName) {
        List<String> lines;
        lines = readLines(Path.of("src/main/resources/datamunging/" + fileName));
        lines = filterLines(lines, Arrays.asList(0, 18));

        List<DataWithDifference> data = extractData(lines, new Position(6, 22), new Position(43, 45), new Position(50, 52));
        return findMin(data).getName();
    }

    public int findSmallestTemperatureSpread(String fileName) {
        List<String> lines;
        lines = readLines(Path.of("src/main/resources/datamunging/" + fileName));
        lines = filterLines(lines, Arrays.asList(0, 1, 32));

        List<DataWithDifference> data = extractData(lines, new Position(2, 4), new Position(6, 8), new Position(12, 14));

        return Integer.parseInt(findMin(data).getName());
    }

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
