package service;

import entities.Customer;
import entities.Foreigner;
import entities.LocalPeople;
import entities.OutLocalPeople;
import main.Main;
import utils.DataNotMatchException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//import static utils.DBContext.getConnection;

public class CustomerService {
    String jdbcUrl = "jdbc:mysql://localhost:3306/jbdc_javacore";
    String username = "root";
    String password = "huytg2311";

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String filePath = "C:\\Users\\84898\\Desktop\\customer.csv";
    int batchSize = 20;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String para = "";
    DataNotMatchException dataNotMatchException = new DataNotMatchException();

    public void readCustomerIntoDB() {
        try {
            connection = DriverManager.getConnection(jdbcUrl,username,password);
            connection.setAutoCommit(false);

            String INSERT_CUSTOMER = "insert into customer values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);

            BufferedReader lineReader = new BufferedReader(new FileReader(filePath));

            String lineText = null;
            int count = 0;

            lineReader.readLine();
            while ((lineText=lineReader.readLine())!= null) {

                String[] data = lineText.split(",", 13);

                String type = data[0];
                String cusID = data[1];
                String name = data[2];
                String birthdate = data[3];

                String sex = data[4];
                String indentifyID = data[5];
                String vaccineTimes = data[6];
                String travelDate = data[7];
                String address = data[8];
                String province = data[9];
                String passport = data[10];
                String travelTimes = data[11];
                String TicketPrice = data[12];
                LocalDate localDate = LocalDate.parse(birthdate, formatter);
                LocalDate localDate2 = LocalDate.parse(travelDate, formatter);


                if (dataNotMatchException.checkID(cusID)) {
                    preparedStatement.setString(1, cusID);
                }
                preparedStatement.setString(2, name);
                if (dataNotMatchException.checkBirthday(localDate)) {
                    preparedStatement.setObject(3, localDate);
                }
                preparedStatement.setString(4, sex);
                if (dataNotMatchException.checkIndentifyID(indentifyID)) {
                    preparedStatement.setString(5, indentifyID);
                }
                preparedStatement.setInt(6, Integer.parseInt(vaccineTimes));
                preparedStatement.setObject(7, localDate2);
                preparedStatement.setString(8, address);
                preparedStatement.setString(9, province);
                preparedStatement.setString(10, passport);
                preparedStatement.setString(11, travelTimes);
                preparedStatement.setString(12, TicketPrice);
                preparedStatement.setInt(13, Integer.parseInt(type));

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

    public void voidListCustomer() {
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            String SQL_LIST = "select * from customer";

            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL_LIST);

            List<Customer> customerList = new ArrayList<>();

            while (resultSet.next()) {
                if (resultSet.getInt("type") == 1) {
                    customerList.add(new LocalPeople(
                            resultSet.getString("cusID"),
                            resultSet.getString("name"),
                            resultSet.getDate("birthdate").toLocalDate(),
                            resultSet.getString("sex"),
                            resultSet.getString("indentifyID"),
                            resultSet.getInt("vaccine_times"),
                            resultSet.getDate("travel_date").toLocalDate(),
                            resultSet.getInt("TicketPrice"),
                            resultSet.getInt("type"),
                            resultSet.getString("address")
                    ));
                } else if (resultSet.getInt("type") == 2) {
                    customerList.add(new OutLocalPeople(
                            resultSet.getString("cusID"),
                            resultSet.getString("name"),
                            resultSet.getDate("birthdate").toLocalDate(),
                            resultSet.getString("sex"),
                            resultSet.getString("indentifyID"),
                            resultSet.getInt("vaccine_times"),
                            resultSet.getDate("travel_date").toLocalDate(),
                            resultSet.getInt("TicketPrice"),
                            resultSet.getInt("type"),
                            resultSet.getString("province")
                    ));
                } else if (resultSet.getInt("type") == 3) {
                    customerList.add(new Foreigner(
                            resultSet.getString("cusID"),
                            resultSet.getString("name"),
                            resultSet.getDate("birthdate").toLocalDate(),
                            resultSet.getString("sex"),
                            resultSet.getString("indentifyID"),
                            resultSet.getInt("vaccine_times"),
                            resultSet.getDate("travel_date").toLocalDate(),
                            resultSet.getInt("TicketPrice"),
                            resultSet.getInt("type"),
                            resultSet.getString("passport"),
                            resultSet.getInt("travel_times")
                            ));
                }

            }

            for (Customer c: customerList
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

    public void updateTicketPrice() {
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            String SQL_LIST = "select * from customer";
            String SQL_UPDATE = "update customer set TicketPrice = ? where cusID = ?";

            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL_LIST);

            List<Customer> customerList = new ArrayList<>();

            while (resultSet.next()) {
                if (resultSet.getInt("type") == 1) {
                    customerList.add(new LocalPeople(
                            resultSet.getString("cusID"),
                            resultSet.getString("name"),
                            resultSet.getDate("birthdate").toLocalDate(),
                            resultSet.getString("sex"),
                            resultSet.getString("indentifyID"),
                            resultSet.getInt("vaccine_times"),
                            resultSet.getDate("travel_date").toLocalDate(),
                            resultSet.getInt("TicketPrice"),
                            resultSet.getInt("type"),
                            resultSet.getString("address")
                    ));
                } else if (resultSet.getInt("type") == 2) {
                    customerList.add(new OutLocalPeople(
                            resultSet.getString("cusID"),
                            resultSet.getString("name"),
                            resultSet.getDate("birthdate").toLocalDate(),
                            resultSet.getString("sex"),
                            resultSet.getString("indentifyID"),
                            resultSet.getInt("vaccine_times"),
                            resultSet.getDate("travel_date").toLocalDate(),
                            resultSet.getInt("TicketPrice"),
                            resultSet.getInt("type"),
                            resultSet.getString("province")
                    ));
                } else if (resultSet.getInt("type") == 3) {
                    customerList.add(new Foreigner(
                            resultSet.getString("cusID"),
                            resultSet.getString("name"),
                            resultSet.getDate("birthdate").toLocalDate(),
                            resultSet.getString("sex"),
                            resultSet.getString("indentifyID"),
                            resultSet.getInt("vaccine_times"),
                            resultSet.getDate("travel_date").toLocalDate(),
                            resultSet.getInt("TicketPrice"),
                            resultSet.getInt("type"),
                            resultSet.getString("passport"),
                            resultSet.getInt("travel_times")
                    ));
                }

            }

            for (Customer c: customerList
            ) {
                int priceLocal = 230000;
                int outPriceLocal = 430000;
                int Foreigner = 630000;
                if (c.getType() == 1 && 2022 - c.getBirthday().getYear() < 18) {
                    int priceLocalSale = priceLocal * 70/100;
                    preparedStatement = connection.prepareStatement(SQL_UPDATE);

                    preparedStatement.setInt(1, priceLocalSale);
                    preparedStatement.setString(2, c.getCusID());
                    preparedStatement.executeUpdate();

                } else if (c.getType() == 2 && 2022 - c.getBirthday().getYear() < 18) {
                    int priceOutLocalSale = outPriceLocal * 70/100;
                    preparedStatement = connection.prepareStatement(SQL_UPDATE);

                    preparedStatement.setInt(1, priceOutLocalSale);
                    preparedStatement.setString(2, c.getCusID());
                    preparedStatement.executeUpdate();
                } else if (c.getType() == 3 && 2022 - c.getBirthday().getYear() < 18) {
                    int priceForeigner = Foreigner * 70/100;
                    preparedStatement = connection.prepareStatement(SQL_UPDATE);

                    preparedStatement.setInt(1, priceForeigner);
                    preparedStatement.setString(2, c.getCusID());
                    preparedStatement.executeUpdate();
                }
            }

//            customerList.sort(new Comparator<Customer>() {
//                @Override
//                public int compare(Customer o1, Customer o2) {
//                    return  o2.getTravelDate().getYear() - o1.getTravelDate().getYear();
//                }
//            });

            customerList.sort(Comparator.comparing(Customer::getTravelDate));
            Collections.reverse(customerList);
//            customerList.sort(Comparator.comparing(Customer::getCusID));

            for (Customer c: customerList
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

    public void deleteCustomer() {
        String DELETE_CUSTOMER = "delete from customer where cusID = ?";

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            String SQL_LIST = "select * from customer";

            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL_LIST);

            List<Customer> customerList = new ArrayList<>();

            while (resultSet.next()) {
                if (resultSet.getInt("type") == 1) {
                    customerList.add(new LocalPeople(
                            resultSet.getString("cusID"),
                            resultSet.getString("name"),
                            resultSet.getDate("birthdate").toLocalDate(),
                            resultSet.getString("sex"),
                            resultSet.getString("indentifyID"),
                            resultSet.getInt("vaccine_times"),
                            resultSet.getDate("travel_date").toLocalDate(),
                            resultSet.getInt("TicketPrice"),
                            resultSet.getInt("type"),
                            resultSet.getString("address")
                    ));
                } else if (resultSet.getInt("type") == 2) {
                    customerList.add(new OutLocalPeople(
                            resultSet.getString("cusID"),
                            resultSet.getString("name"),
                            resultSet.getDate("birthdate").toLocalDate(),
                            resultSet.getString("sex"),
                            resultSet.getString("indentifyID"),
                            resultSet.getInt("vaccine_times"),
                            resultSet.getDate("travel_date").toLocalDate(),
                            resultSet.getInt("TicketPrice"),
                            resultSet.getInt("type"),
                            resultSet.getString("province")
                    ));
                } else if (resultSet.getInt("type") == 3) {
                    customerList.add(new Foreigner(
                            resultSet.getString("cusID"),
                            resultSet.getString("name"),
                            resultSet.getDate("birthdate").toLocalDate(),
                            resultSet.getString("sex"),
                            resultSet.getString("indentifyID"),
                            resultSet.getInt("vaccine_times"),
                            resultSet.getDate("travel_date").toLocalDate(),
                            resultSet.getInt("TicketPrice"),
                            resultSet.getInt("type"),
                            resultSet.getString("passport"),
                            resultSet.getInt("travel_times")
                    ));
                }

            }

            for (Customer c: customerList
            ) {
                if (2022 - c.getTravelDate().getYear() > 5) {
                    preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
                    preparedStatement.setString(1, c.getCusID());
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
}
