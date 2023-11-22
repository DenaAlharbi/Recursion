// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path for the directory:... ");
        String p = scanner.nextLine();

        File dir = new File(p);
        //this is the recursive method
        //boolean check = True;
        if (!dir.exists()) {
            System.out.println("Does not exist. Try again...");
        }
        printFiles(dir);


        scanner.close();
    }

    public static int helper(File FF) {
        int hel = 0;
        File p = FF.getParentFile();
        while (p != null) {
            hel= hel+1;
            p = p.getParentFile();
        }
        return hel;

    }

    public static void printFiles(File fi) {
                if (fi.isFile()) {
                    System.out.println(fi.getName());
                }

                else if (fi.isDirectory()) {
                    File[] allTheFiles = fi.listFiles();

                    for (File f : allTheFiles) {
                        for (int i = 0; i < helper(fi); i++) {
                            System.out.print("\t");
                        }
                        if (f.isFile()) {
                            System.out.println(f.getName());
                        }
                        else if (f.isDirectory()) {
                            System.out.println(f.getName());
                            printFiles(f);
                        }

                      //  else{

                        //}
                    }
                }
            }


}