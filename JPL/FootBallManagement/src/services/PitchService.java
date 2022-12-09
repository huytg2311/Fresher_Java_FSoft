package services;

import entities.ArtificialPitch;
import entities.NaturalPitch;
import entities.Pitch;
import entities.WoodPitch;
import main.Main;
import utils.DataAllException;
import utils.DataNotMatchException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PitchService {
    String jdbcUrl = "jdbc:mysql://localhost:3306/pitch";
    String username = "root";
    String password = "huytg2311";

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String filePath = "C:\\Users\\84898\\Desktop\\Data_Dummy.csv";
    int batchSize = 20;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    DataAllException dataAllException = new DataAllException();
    Scanner scanner = new Scanner(System.in);

    public void readPitchIntoDB() {
        try {
            connection = DriverManager.getConnection(jdbcUrl,username,password);
            connection.setAutoCommit(false);

            String INSERT_PITCH = "insert into pitch values (?,?,?,?,?,?,?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(INSERT_PITCH);

            BufferedReader lineReader = new BufferedReader(new FileReader(filePath));

            String lineText = null;
            int count = 0;

            lineReader.readLine();
            while ((lineText=lineReader.readLine())!= null) {

                String[] data = lineText.split(",", 12);

                String type = data[0];
                String pitchID = data[1];
                String name = data[2];
                String size = data[3];

                String cost = data[4];
                String status = data[5];
                String startDate = data[6];
                String cuttingTime = data[7];
                String enduringYear = data[8];
                String typeOfGrass = data[9];
                String productionCountry = data[10];
                String warrantYear = data[11];

                LocalDate localDate = LocalDate.parse(startDate, formatter);



//                if (dataAllException.checkID(pitchID)) {
//                    if (dataAllException.checkDuplicateID(pitchID)) {
                        preparedStatement.setString(1, pitchID);
//                    }
//                }
                preparedStatement.setString(2, name);
                preparedStatement.setInt(3, Integer.parseInt(size));
                preparedStatement.setInt(4, Integer.parseInt(cost));
//                if (dataAllException.checkStatus(status)) {
                    preparedStatement.setString(5, status);
//                }
                preparedStatement.setObject(6, localDate);
                preparedStatement.setString(7, type);
                preparedStatement.setString(8, cuttingTime);
                preparedStatement.setString(9, enduringYear);
                preparedStatement.setString(10, typeOfGrass);
                preparedStatement.setString(11, warrantYear);
                preparedStatement.setString(12, productionCountry);



                preparedStatement.addBatch();
                if (count%batchSize==0) {
                    preparedStatement.executeBatch();
                }
            }
            lineReader.close();
            preparedStatement.executeBatch();
            connection.commit();
            connection.close();
            System.out.println("Data has been inserted successfully");

        } catch (Exception e) {
//            System.out.println("“Program have an unexpected error occurred !!!");
            e.printStackTrace();
        }
    }

    public void listCustomer() {
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            String SQL_LIST = "select * from pitch";

            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL_LIST);

            List<Pitch> pitchList = new ArrayList<>();

            while (resultSet.next()) {
                if (resultSet.getInt("type") == 1) {
                    pitchList.add(new NaturalPitch(
                            resultSet.getString("pitchID"),
                            resultSet.getString("name"),
                            resultSet.getInt("size"),
                            resultSet.getInt("cost"),
                            resultSet.getString("status"),
                            resultSet.getDate("start_date").toLocalDate(),
                            resultSet.getInt("type"),
                            Integer.parseInt(resultSet.getString("cutting_time"))
                    ));
                } else if (resultSet.getInt("type") == 2) {
                    pitchList.add(new ArtificialPitch(
                            resultSet.getString("pitchID"),
                            resultSet.getString("name"),
                            resultSet.getInt("size"),
                            resultSet.getInt("cost"),
                            resultSet.getString("status"),
                            resultSet.getDate("start_date").toLocalDate(),
                            resultSet.getInt("type"),
                            Integer.parseInt(resultSet.getString("enduring_year")),
                            resultSet.getString("type_of_grass")
                    ));
                } else if (resultSet.getInt("type") == 3) {
                    pitchList.add(new WoodPitch(
                            resultSet.getString("pitchID"),
                            resultSet.getString("name"),
                            resultSet.getInt("size"),
                            resultSet.getInt("cost"),
                            resultSet.getString("status"),
                            resultSet.getDate("start_date").toLocalDate(),
                            resultSet.getInt("type"),
                            Integer.parseInt(resultSet.getString("warrant_year")),
                            resultSet.getString("production_country")
                    ));
                }

            }

            for (Pitch c: pitchList
            ) {
                c.showInformation();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //B3. Close connection
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void updateCost() {
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            String SQL_LIST = "select * from pitch";
            String SQL_UPDATE = "update pitch set cost = ? where pitchID = ?";

            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL_LIST);

            List<Pitch> pitchList = new ArrayList<>();

            while (resultSet.next()) {
                if (resultSet.getInt("type") == 1) {
                    pitchList.add(new NaturalPitch(
                            resultSet.getString("pitchID"),
                            resultSet.getString("name"),
                            resultSet.getInt("size"),
                            resultSet.getInt("cost"),
                            resultSet.getString("status"),
                            resultSet.getDate("start_date").toLocalDate(),
                            resultSet.getInt("type"),
                            Integer.parseInt(resultSet.getString("cutting_time"))
                    ));
                } else if (resultSet.getInt("type") == 2) {
                    pitchList.add(new ArtificialPitch(
                            resultSet.getString("pitchID"),
                            resultSet.getString("name"),
                            resultSet.getInt("size"),
                            resultSet.getInt("cost"),
                            resultSet.getString("status"),
                            resultSet.getDate("start_date").toLocalDate(),
                            resultSet.getInt("type"),
                            Integer.parseInt(resultSet.getString("enduring_year")),
                            resultSet.getString("type_of_grass")
                    ));
                } else if (resultSet.getInt("type") == 3) {
                    pitchList.add(new WoodPitch(
                            resultSet.getString("pitchID"),
                            resultSet.getString("name"),
                            resultSet.getInt("size"),
                            resultSet.getInt("cost"),
                            resultSet.getString("status"),
                            resultSet.getDate("start_date").toLocalDate(),
                            resultSet.getInt("type"),
                            Integer.parseInt(resultSet.getString("warrant_year")),
                            resultSet.getString("production_country")
                    ));
                }

            }

            System.out.println("Enter ID: ");
            String id = scanner.nextLine();
            System.out.println("Enter Type");
            for (Pitch p: pitchList
                 ) {

                int type = scanner.nextInt();
                if (type == 1) {
                    int costNatural = p.getCost() * 5/100;
                    preparedStatement = connection.prepareStatement(SQL_UPDATE);
                    preparedStatement.setInt(1, costNatural);
                    preparedStatement.setString(2, id);
                    preparedStatement.executeUpdate();
                } else if (type == 2) {
                    int costArtificialPitch = p.getCost() * 10/100;
                    preparedStatement = connection.prepareStatement(SQL_UPDATE);
                    preparedStatement.setInt(1, costArtificialPitch);
                    preparedStatement.setString(2, id);
                    preparedStatement.executeUpdate();
                } else if (type == 3) {
                    int costWoodPitch = p.getCost() * 15/100;
                    preparedStatement = connection.prepareStatement(SQL_UPDATE);
                    preparedStatement.setInt(1, costWoodPitch);
                    preparedStatement.setString(2, id);
                    preparedStatement.executeUpdate();
                }
                System.out.println("Update Successfully !");

            }


            pitchList.sort(Comparator.comparing(Pitch::getSize));
            Collections.reverse(pitchList);

//            pitchList.sort(Comparator.comparing(Pitch::getPitchID));

            for (Pitch c: pitchList) {
                c.showInformation();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //B3. Close connection
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void deleteCustomer() {
        String DELETE_PITCH = "delete from pitch where type = ?";
        String SELECTBYID = "select * from pitch where type = ?";

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            String SQL_LIST = "select * from pitch";

            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL_LIST);

            List<Pitch> pitchList = new ArrayList<>();
            List<WoodPitch> woodPitchList = new ArrayList<>();

            while (resultSet.next()) {
                if (resultSet.getInt("type") == 1) {
                    pitchList.add(new NaturalPitch(
                            resultSet.getString("pitchID"),
                            resultSet.getString("name"),
                            resultSet.getInt("size"),
                            resultSet.getInt("cost"),
                            resultSet.getString("status"),
                            resultSet.getDate("start_date").toLocalDate(),
                            resultSet.getInt("type"),
                            Integer.parseInt(resultSet.getString("cutting_time"))
                    ));
                } else if (resultSet.getInt("type") == 2) {
                    pitchList.add(new ArtificialPitch(
                            resultSet.getString("pitchID"),
                            resultSet.getString("name"),
                            resultSet.getInt("size"),
                            resultSet.getInt("cost"),
                            resultSet.getString("status"),
                            resultSet.getDate("start_date").toLocalDate(),
                            resultSet.getInt("type"),
                            Integer.parseInt(resultSet.getString("enduring_year")),
                            resultSet.getString("type_of_grass")
                    ));
                } else if (resultSet.getInt("type") == 3) {
                    pitchList.add(new WoodPitch(
                            resultSet.getString("pitchID"),
                            resultSet.getString("name"),
                            resultSet.getInt("size"),
                            resultSet.getInt("cost"),
                            resultSet.getString("status"),
                            resultSet.getDate("start_date").toLocalDate(),
                            resultSet.getInt("type"),
                            Integer.parseInt(resultSet.getString("warrant_year")),
                            resultSet.getString("production_country")
                    ));
                }

            }
            int setType = 3;
            preparedStatement = connection.prepareStatement(SELECTBYID);
            preparedStatement.setInt(1, setType);
            ResultSet resultSet1 = preparedStatement.executeQuery();

            while (resultSet.next()) {
                woodPitchList.add(new WoodPitch(
                        resultSet.getString("pitchID"),
                        resultSet.getString("name"),
                        resultSet.getInt("size"),
                        resultSet.getInt("cost"),
                        resultSet.getString("status"),
                        resultSet.getDate("start_date").toLocalDate(),
                        resultSet.getInt("type"),
                        Integer.parseInt(resultSet.getString("warrant_year")),
                        resultSet.getString("production_country")));
            }

            for (WoodPitch w: woodPitchList
            ) {
                if (w.getStartDate().getYear() < 2019 && w.getProductionCountry().equals("Italia")) {
                    preparedStatement = connection.prepareStatement(DELETE_PITCH);
                    preparedStatement.setInt(1, setType);
                    preparedStatement.executeUpdate();
                }
            }

            System.out.println("Delete Successfully !");
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //B3. Close connection
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void sort() {

    }
}
