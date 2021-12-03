package day04;

public class FileReaderMain {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        System.out.println(fileReader.findSmallestTemperatureSpread("weather.dat"));
        System.out.println(fileReader.findSmallestTeamDifference("football.dat"));
    }
}
