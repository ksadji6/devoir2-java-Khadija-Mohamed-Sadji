package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Client;

import entities.Bien;
import entities.Zone;

public class BienRepository {
    Zone zone;
    
    public  void insert(Bien bien){
     try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/devoir_kms_iagea" 
                    , "root", "");
             Statement statement = conn.createStatement();
            
             int nbreLigne=statement.executeUpdate("INSERT INTO bien (id_bien,ref_bien,des_bien,prix,id_zone,date_creation) VALUES ('"+bien.getId()+"', '"+bien.getReference()+"', '"+bien.getDescription()+"', '"+bien.getPrix()+"', '"+zone.getId()+"', '"+bien.getDateCreation()+"')");
             conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement de Driver");
        }
       catch (SQLException e) {
          System.out.println("Erreur de Connexion a la BD");
      }
     }


     public List<Bien> selectAll(){
         List<Bien> biens=new ArrayList<>();
          try {
    
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/devoir_kms_iagea" 
                   , "root", "");
             Statement statement = conn.createStatement();
             String sql="SELECT * FROM `bien` b, zone z WHERE b.id_zone=z.id_zone ;";
             ResultSet rs=statement.executeQuery(sql);
            while (rs.next()) {
                Zone zone=new Zone();
                zone.setId(rs.getInt("id_zone"));
                Bien bien=new Bien();
                bien.setId(rs.getInt("id_bien"));
                bien.setReference(rs.getString("ref_bien"));
                bien.setDescription(rs.getString("des_bien"));
                bien.setPrix(rs.getString("prix"));
                bien.setDateCreation(rs.getString("date_creation"));
                bien.setZone(zone);
                biens.add(bien);
                 
            }
            statement.close();
            rs.close();
            conn.close();
       } catch (ClassNotFoundException e) {
           System.out.println("Erreur de chargement de Driver");
       }
       catch (SQLException e) {
         System.out.println("Erreur de Connexion a la BD");
       }
       return  biens;
      }
}
