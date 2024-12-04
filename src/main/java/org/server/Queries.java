package org.server;

import java.sql.*;
import java.util.ArrayList;

import org.server.Products;

public class Queries {
    // Method to select all rows from the 'wine' table
    public static void selectAllWines(Connection connection) {
        String query = "SELECT * FROM wine";
        int id = 1;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Wine Table Data:");
            while (resultSet.next()) {
                float fixedAcidity = resultSet.getFloat("fixed_acidity");
                float volatileAcidity = resultSet.getFloat("volatile_acidity");
                float citricAcid = resultSet.getFloat("citric_acid");
                float residualSugar = resultSet.getFloat("residual_sugar");
                float chlorides = resultSet.getFloat("chlorides");
                float freeSulfurDioxide = resultSet.getFloat("free_sulfur_dioxide");
                float totalSulfurDioxide = resultSet.getFloat("total_sulfur_dioxide");
                float density = resultSet.getFloat("density");
                float pH = resultSet.getFloat("pH");
                float sulphates = resultSet.getFloat("sulphates");
                float alcohol = resultSet.getFloat("alcohol");
                String quality = resultSet.getString("quality");
                String color = resultSet.getString("color");

                // Print row data
                System.out.printf( "%d " +
                        "Fixed Acidity: %.2f, Volatile Acidity: %.2f, Citric Acid: %.2f, Residual Sugar: %.2f, " +
                                "Chlorides: %.2f, Free SO2: %.2f, Total SO2: %.2f, Density: %.4f, pH: %.2f, " +
                                "Sulphates: %.2f, Alcohol: %.2f, Quality: %s, Color: %s%n",++id,
                        fixedAcidity, volatileAcidity, citricAcid, residualSugar, chlorides,
                        freeSulfurDioxide, totalSulfurDioxide, density, pH, sulphates, alcohol, quality, color
                );
            }
        } catch (SQLException e) {
            System.err.println("Query execution failed: " + e.getMessage());
        }
    }

    public static void RedAndWhite(Connection connection) throws SQLException{
        String query = "select * from wine";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            int white_counter = 0,red_counter = 0;
            while (resultSet.next()) {
                String white = resultSet.getString("color");
                if (white.equalsIgnoreCase("white")){
                    white_counter++;
                }else{
                    red_counter++;
                }
            }
            int sum = red_counter+white_counter;
            System.out.println("White wine: " + white_counter + "\nRed wine: " + red_counter + "\nSum: " + sum);
        } catch(SQLException e){
            System.err.println("Query Execution Failed" + e.getMessage());
        }
    }
    public static ArrayList<Products> phSmallerThanSix(Connection connection){
        String query = "select * from wine";

        ArrayList<Products> productsList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()){
                float pH = resultSet.getFloat("pH");
                if (pH < 6){
                    float fixedAcidity = resultSet.getFloat("fixed_acidity");
                    float volatileAcidity = resultSet.getFloat("volatile_acidity");
                    float citricAcid = resultSet.getFloat("citric_acid");
                    float residualSugar = resultSet.getFloat("residual_sugar");
                    float chlorides = resultSet.getFloat("chlorides");
                    float freeSulfurDioxide = resultSet.getFloat("free_sulfur_dioxide");
                    float totalSulfurDioxide = resultSet.getFloat("total_sulfur_dioxide");
                    float density = resultSet.getFloat("density");
                    float sulphates = resultSet.getFloat("sulphates");
                    float alcohol = resultSet.getFloat("alcohol");
                    String quality = resultSet.getString("quality");
                    String color = resultSet.getString("color");

                    Products product = new Products(fixedAcidity, volatileAcidity, citricAcid, residualSugar, chlorides,
                            freeSulfurDioxide, totalSulfurDioxide, density,pH , sulphates, alcohol, quality, color);

                    productsList.add(product);
                }
            }
            return productsList;
    } catch(SQLException e){
            System.err.println("Query Execution Failed" + e.getMessage());
        }

        return productsList;
    }


    public static float findMaxValue(Connection connection){
        String query = "select * from wine";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            float max = Integer.MIN_VALUE;
            while (resultSet.next()){
                float totalSulfurDioxide = resultSet.getFloat("total_sulfur_dioxide");
                if (totalSulfurDioxide > max){
                    max = totalSulfurDioxide;
                    return max;
                }
            }
        }catch(SQLException e){
            System.err.println("Query Execution Failed" + e.getMessage());
        }
        return 0;
    }

    public static ArrayList<Products> findMinValue(Connection connection){
        String query = "SELECT * FROM wine WHERE total_sulfur_dioxide = (SELECT MIN(total_sulfur_dioxide) FROM wine) ";
        ArrayList<Products> productsList = new ArrayList<>();


        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            int i = 0;
            Products product;

            while(resultSet.next()){

                float fixedAcidity = resultSet.getFloat("fixed_acidity");
                float volatileAcidity = resultSet.getFloat("volatile_acidity");
                float citricAcid = resultSet.getFloat("citric_acid");
                float residualSugar = resultSet.getFloat("residual_sugar");
                float chlorides = resultSet.getFloat("chlorides");
                float freeSulfurDioxide = resultSet.getFloat("free_sulfur_dioxide");
                float totalSulfurDioxide = resultSet.getFloat("total_sulfur_dioxide");
                float density = resultSet.getFloat("density");
                float pH = resultSet.getFloat("pH");
                float sulphates = resultSet.getFloat("sulphates");
                float alcohol = resultSet.getFloat("alcohol");
                String quality = resultSet.getString("quality");
                String color = resultSet.getString("color");


                product = new Products(fixedAcidity, volatileAcidity, citricAcid, residualSugar, chlorides,
                        freeSulfurDioxide, totalSulfurDioxide, density,pH , sulphates, alcohol, quality, color);

                productsList.add(product);
            }

            return productsList;

        }catch(SQLException e){
            System.err.println("Query Execution Failed" + e.getMessage());
        }
        return productsList;
    }


//    public static ResultSet results(String query, Connection connection) {
//        try (Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(query)) {
//
//            int i = 0;
//            Products product;
//
//            while (resultSet.next()) {
//
//                float fixedAcidity = resultSet.getFloat("fixed_acidity");
//                float volatileAcidity = resultSet.getFloat("volatile_acidity");
//                float citricAcid = resultSet.getFloat("citric_acid");
//                float residualSugar = resultSet.getFloat("residual_sugar");
//                float chlorides = resultSet.getFloat("chlorides");
//                float freeSulfurDioxide = resultSet.getFloat("free_sulfur_dioxide");
//                float totalSulfurDioxide = resultSet.getFloat("total_sulfur_dioxide");
//                float density = resultSet.getFloat("density");
//                float pH = resultSet.getFloat("pH");
//                float sulphates = resultSet.getFloat("sulphates");
//                float alcohol = resultSet.getFloat("alcohol");
//                String quality = resultSet.getString("quality");
//                String color = resultSet.getString("color");
//
//            }
//        } catch (SQLException e) {
//            System.err.println("Query Execution Failed" + e.getMessage());
//        }
//            return;
//    }
}
