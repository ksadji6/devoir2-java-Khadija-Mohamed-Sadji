import java.util.Date;
import java.util.List;
import java.util.Scanner;
import entities.Bien;
import entities.Zone;
import services.BienService;
import services.ZoneService;

public class App {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc=new Scanner(System.in);
  ZoneService zoneService=new ZoneService();
  BienService bienService=new BienService();
        do {
            System.out.println("1-Créer une zone");
            System.out.println("2-Lister les zones"); 
            System.out.println("3-Ajouter un bien"); 
            System.out.println("4-Lister les biens");
            System.out.println("5-Quitter"); 
             choix=sc.nextInt();
             sc.nextLine();
             switch (choix) {
                case 1:
                System.out.println("Entrez un id de zone");
                int id_zone=sc.nextInt(); 
                sc.nextLine();
                System.out.println("Entrer un Nom de zone");
                String nom_zone=sc.nextLine();  
                Zone zone=new Zone();
                zone.setId(id_zone);
                zone.setNom(nom_zone);
                zoneService.ajouterZone(zone);
                
                    break;
                case 2:
                    List<Zone> zones=  zoneService.listerZone();
                     for (Zone zon: zones) {
                          System.out.println("Id "+ zon.getId());
                          System.out.println("Nom "+ zon.getNom());
                          System.out.println("************************************");
                     }
                    break;
                case 3:
                System.out.println("Entrez l'id de la zone");
                id_zone=sc.nextInt();
                sc.nextLine();
                zone=zoneService.listerZone(nom_zone);
                if (zone==null) {
                    System.out.println("ID de zone non valide");
                } else {
                System.out.println("Entrez l'ID du bien ");
                int id_bien=sc.nextInt(); 
                sc.nextLine();
                System.out.println("Entrer la référence");
                String reference=sc.nextLine();
                System.out.println("Entrer la description");
                String description=sc.nextLine();
                System.out.println("Entrer le prix");
                String prix=sc.nextLine();
                System.out.println("Entrer la date de création");
                String dateCreation=sc.nextLine(); 
                Bien bien=new Bien();  
                bien.setId(id_bien);
                bien.setReference(reference);
                bien.setDescription(description);
                bien.setPrix(prix);
                bien.setDateCreation(dateCreation);
                bienService.ajouterBien(bien);
                
                }
                    break;
                case 4:
                    
                    break;
             
                default:
                    break;
             }
        } while (choix!=5);
    }
}
