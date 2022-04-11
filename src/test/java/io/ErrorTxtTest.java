package io;

public class ErrorTxtTest {
    public static void main(String[] args) {
        ErrorTxt.setFilePath("/Users/yswu/IdeaProjects/IndividualProject/src/test/play_ground/test.txt");
        ErrorTxt.write("Person 1", "Credit Card Error");
        ErrorTxt.write("Person 2", "Lack of Seat");
    }
}
