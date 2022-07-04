// 642115003 Kan Katpark

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        File file = new File("./QS World University Rankings 2017.csv");
        File writeFile = new File("./QS World University Rankings 2017-updated.csv");
        Vector<University> universities = new Vector<>();
        readRecord(file, universities);

        // sort the data by University name
        mergeSort(universities);
        // Save the output of sorted uni name
        writeNewData(writeFile, universities);

        System.out.println("DONE!");

    }

    public static void writeNewData(File file, Vector<University> universities) {
        try {
            FileWriter csv = new FileWriter(file);
            for (University university : universities) {
                csv.append(university.year+",");
                csv.append(university.rank+",");
                csv.append(university.name+",");
                csv.append(university.score +",");
                csv.append(university.link +",");
                csv.append(university.country + ",");
                csv.append(university.city  + ",");
                csv.append(university.region  + ",");
                csv.append(university.logo  + "\n");
            }
            csv.close();
        } catch (IOException err) {
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
                int rank;

                // Remove rank that is not a digit from the list
                try {
                    //Remove '=' in rank text
                    if (temp[1].charAt(0) == '=') {
                        temp[1] = temp[1].substring(1);
                    }
                    rank = Integer.parseInt(temp[1]);
                } catch (NumberFormatException e) {
                    //Skip line when rank is not a number
                    continue;
                }

                String name = toLowerCase(temp[2]);
                String score;
                // Replace the university that doesn’t have score with 0
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

                University university = new University(year, "" + rank, name, score, link, country, city, region, logo);
                collection.addElement(university);
            }
            sc.close();
        } catch (FileNotFoundException err) {
            System.out.println("Error can't find file" + err);
        }

    }

    // Lower case
    public static String toLowerCase(String text) {
        return text.toLowerCase();
    }

    // Sort uniData with its name by using merge sort
    public static void mergeSort(Vector<University> lists) {
        if (lists.size() <= 1)
            return;

        int middle = lists.size() / 2;

        Vector<University> leftHalf = new Vector<University>(lists.subList(0, middle));
        Vector<University> rightHalf = new Vector<University>(lists.subList(middle, lists.size()));

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(lists, leftHalf, rightHalf);

    }

    public static void merge(Vector<University> num, Vector<University> leftHalf, Vector<University> rightHalf) {
        int leftSize = leftHalf.size();
        int rightSize = rightHalf.size();

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf.elementAt(i).compareTo(rightHalf.elementAt(j)) == -1) {
                num.set(k, leftHalf.elementAt(i));
                i++;
            } else {
                num.set(k, rightHalf.elementAt(j));
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            num.set(k, leftHalf.elementAt(i));
            i++;
            k++;
        }

        while (j < rightSize) {
            num.set(k, rightHalf.elementAt(j));
            j++;
            k++;
        }

    }

}