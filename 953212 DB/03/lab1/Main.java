// 642115003 Kan Katpark

import java.util.*;
import java.io.*;

// What are the meta data for the given data? please list all.
// rank_display 
// university
// link
// country
// city
// region

// List all the data type of each attribute.
// year Date
// rank String 
// university String
// score number
// link String
// country String
// city String
// region String
// logo String

// What problem have you found when you are dealing with the tradition database files? Explain in detail?
// Some data are empty or missing 
// Example university score data
// Some of them are missing 
// I have to set it to 0 before use it.

class Main {
    public static void main(String[] args) {
        File file = new File("./QS World University Rankings 2017.csv");
        Vector<University> universities = new Vector<>();

        readRecord(file, universities);
        
        University cmu = new University("2017", "601-650", "Chiang Mai University", "0" , "https://www.topuniversities.com/universities/chiang-mai-university", "Thailand", "Chiang Mai", "Asia", "https://www.topuniversities.com/sites/default/files/profiles/logos/chiang-mai-university_118_large.jpg");

        appendUniversity(file , cmu) ;

        for(University i : universities) {
            System.out.println(i);
        }

    }

    public static void appendUniversity(File file,University university) {
        try {
            FileWriter csv = new FileWriter(file,true); 
            csv.append(university.year);
            csv.append(",");
            csv.append(university.rank);
            csv.append(",");
            csv.append(university.name);
            csv.append(",");
            csv.append(""+university.score);
            csv.append(",");
            csv.append(university.link);
            csv.append(",");
            csv.append(university.country);
            csv.append(",");
            csv.append(university.city);
            csv.append(",");
            csv.append(university.region);
            csv.append(",");
            csv.append(university.logo);
       
            csv.close();
        }
        catch(IOException err) {
            System.out.println("Error can't find file" + err);
        }
    }

    public static void readRecord(File file, Vector<University> collection) {

        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            int count = 0;
            while (sc.hasNextLine()) {
                if (count == 3)
                    break;
                String[] temp = sc.nextLine().split("\"?(,|$)(?=(([^\"]*\"){2})*[^\"]*$) *\"?");
                String year = temp[0];
                String rank = temp[1];
                String name = temp[2];
                String score;
                if (temp[3] == "" || temp[3] == null) {
                    score = "0";

                } else {
                    score = temp[3];
                }
                String link = temp[4];
                String country = temp[5];
                String city = temp[6];
                String region = temp[7];
                String logo = temp[8];

                University university = new University(year, rank, name, score, link, country, city, region, logo);
                collection.addElement(university);
            }
            sc.close();
        } catch (FileNotFoundException err) {
            System.out.println("Error can't find file" + err);
        }

    }

}