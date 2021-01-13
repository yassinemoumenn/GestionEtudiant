//package application;
//
//import java.sql.*;
//
//
//
//
//import static java.lang.Class.forName;
//
//public class Connexion extends Configs {
//    Connection dbConnection;
//
//    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
//        String connectionString = "jdbc:mysql://" + dbHost + "/"
//                + dbName;
//
//        forName("com.mysql.cj.jdbc.Driver");
//
//        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
//
//
//        return dbConnection;
//    }
//
//    public void addetudiant(Etudiant etudiant) {
//    
//        String insert = "INSERT INTO etudiant (nom,prenom,email,telephone,specialite) VALUES (?,?,?,?,?)";
//
//        try {
//            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
//            preparedStatement.setString(1, etudiant.getNom());
//            preparedStatement.setString(2, etudiant.getPrenom());
//            preparedStatement.setString(3, etudiant.getEmail());
//            preparedStatement.setString(4, etudiant.getTelephone());
//            preparedStatement.setString(5, etudiant.getSpecialite());
//            preparedStatement.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("error" + e);
//        }
//
//}
//}