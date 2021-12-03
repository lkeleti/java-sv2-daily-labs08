package day05;

import day04.FileReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReaderTest {

    @Test
    void findSmallestTeamsDifferenceTest(){
        String name = new TeamsFileReader().findSmallestDifferenceName();
        assertEquals("Aston_Villa", name);
    }

    @Test
    void findSmallestTemperatureSpreadTest() {
        String day = new TemperatureFileReader().findSmallestDifferenceName();
        assertEquals("14", day);
    }
}
