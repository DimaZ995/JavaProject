import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;

public class Main extends CRUD{
	public static Connection connect = null;
	
	public static void main(String[] args) {
		try {
			String Url = "jdbc:mysql://localhost/college";
			String UsName = "root";
			String Password = "";
			connect = DriverManager.getConnection(Url, UsName, Password);
			System.out.println(" --->>> Connection Succesfull!");
			int select = 0;
			do {
				Scanner in = new Scanner(System.in);
				System.out.println("|-- To insert Enter 1 --|");
				System.out.println("|-- To update Enter 2 --|");
				System.out.println("|-- To delete Enter 3 --|");
				System.out.println("|-- To select Enter 4 --|");
				System.out.println("|-- To exit   Enter 0 --|");
				
				System.out.printf("|-- Your choise: ", select);
				select = in.nextInt();
				
				switch(select) {
				case 1:
					Insert(connect);
					break;
				case 2:
					Update(connect);
					break;
				case 3:
					Delete(connect);
					break;
				case 4: 
					Select(connect);
					break;
				}
			}while(select != 0);
		}
		catch(Exception ex){
			System.out.println("Connection failed...");
			System.out.println(ex);
		}
		finally {
			try {
				if(connect != null) connect.close();
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
		}
	}
}
