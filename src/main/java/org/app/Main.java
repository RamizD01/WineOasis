package org.app;
import org.server.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Get a connection from DBConnection class
        Connection connection = DBConnection.getConnection();

        Scanner input = new Scanner(System.in);

        if (connection != null) {
            boolean flag = true;
            while(flag){
                System.out.println("\nPick an option:");
                System.out.println("1. print everything in wine.");
                System.out.println("2. print red and white with sum.");
                System.out.println("3. Prints fields when ph < 6");
                System.out.println("4. print the max and min of one of the integers");
                System.out.println("5. ");
                System.out.println("6.");
                System.out.println("0. exit.");


                String option = input.next();
                switch(option){
                    case "1":
                        Queries.selectAllWines(connection);
                        break;
                    case "2":
                        Queries.RedAndWhite(connection);
                        break;
                    case "3":
                        for (Products products : Queries.phSmallerThanSix(connection)){
                            System.out.println(products);
                        }
                        break;
                    case "4":
                        float max = Queries.findMaxValue(connection);

                            if (max == 0){
                                System.out.println("Failed to find the max");
                            }else{
                                System.out.println("Maximum Value \n" + max + "\n");
                            }
                                int i = 0;
                        System.out.println("                1Minimum Value:");

                        for (Products min : Queries.findMinValue(connection)) {
                                    System.out.println(min);
                                }
                        break;
                    case "0":
                        flag = false;
                        break;

                    default:
                        System.out.println("Pick one of the options above");
                        break;
                }
            }


            // Close the connection
            try {
                connection.close();
            } catch (Exception e) {
                System.err.println("Failed to close connection: " + e.getMessage());
            }
        }
    }
}
