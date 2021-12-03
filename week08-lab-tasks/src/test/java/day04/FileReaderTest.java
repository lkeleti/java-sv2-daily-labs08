package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReaderTest {

    @Test
    void findSmallestTeamsDifferenceTest(){
        FileReader fileReader = new FileReader();
        assertEquals("Aston_Villa", fileReader.findSmallestTeamDifference("football.dat"));
    }

    @Test
    void findSmallestTemperatureSpreadTest() {
        FileReader fileReader = new FileReader();
        assertEquals(14, fileReader.findSmallestTemperatureSpread("weather.dat"));
    }
}
