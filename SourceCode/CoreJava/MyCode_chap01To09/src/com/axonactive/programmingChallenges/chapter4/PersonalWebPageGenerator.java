package com.axonactive.programmingChallenges.chapter4;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class PersonalWebPageGenerator {
    public static void main(String[] args) throws IOException
    {
        String usrName, info;
        Scanner input = new Scanner(System.in);
        PrintWriter htmlFile = new PrintWriter("userBio.html");

        System.out.print("Enter your name: ");
        usrName = input.nextLine();
        System.out.print("Describe yourself: ");
        info = input.nextLine();

        htmlFile.println("<html>");
        htmlFile.println("<head>");
        htmlFile.println("</head>");
        htmlFile.println("<body>");
        htmlFile.println("<center>");
        htmlFile.println("<h1>" + usrName + "</h1>");
        htmlFile.println("</center>");
        htmlFile.println("<hr />");
        htmlFile.println(info);
        htmlFile.println("<hr />");
        htmlFile.println("</body>");
        htmlFile.println("</html>");
        htmlFile.close();
    }
}
