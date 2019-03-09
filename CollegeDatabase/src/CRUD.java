import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;


public class CRUD {
	public static void Insert(Connection connect) {
		ResultSet result = null;
		Statement statement = null;
		try {
			statement = connect.createStatement();
			int Cod_Stud = 0;
			int Cod_Group = 0;
			String Group = "";
			String IDNP = "";
			String Name = "";
			String SurName = "";
			String MiddleName = "";
			String City = "";
			int Cod_City = 0;
			String Street = "";
			String House = "";
			
			result = statement.executeQuery("SELECT Cod_Student FROM student");
			
			while(result.next())
			{
				Cod_Stud = result.getInt("Cod_Student");
			}
			Cod_Stud++;
			Scanner in = new Scanner(System.in);
			
			System.out.printf("|--|-- Enter Group: ", Group);
			Group = in.nextLine();
			
			PreparedStatement GroupSearch = connect.prepareStatement("SELECT Cod_Group FROM groupc WHERE groupc.Name_Group = ?");
			GroupSearch.setString(1, Group);
			result = GroupSearch.executeQuery();
			while(result.next())
			{
				Cod_Group = result.getInt("Cod_Group");
			}
			
			System.out.printf("|--|-- Enter IDNP: ", IDNP);
			IDNP = in.nextLine();
			
			System.out.printf("|--|-- Enter Name: ", Name);
			Name = in.nextLine();
			
			System.out.printf("|--|-- Enter SurName: ", SurName);
			SurName = in.nextLine();
			
			System.out.printf("|--|-- Enter MiddleName: ", MiddleName);
			MiddleName = in.nextLine();
			
			System.out.printf("|--|-- Enter City: ", City);
			City = in.nextLine();
			
			PreparedStatement ps = connect.prepareStatement("SELECT Cod_City FROM city WHERE city.City = ?");
			ps.setString(1, City);
			result = ps.executeQuery();
			
			while(result.next())
			{
				Cod_City = result.getInt("Cod_City");
			}
			
			System.out.printf("|--|-- Enter Street: ", Street);
			Street = in.nextLine();
			
			System.out.printf("|--|-- Enter House: ", House);
			House = in.nextLine();
			
			
			String Quary = "INSERT INTO `student`(`Cod_Student`, `Cod_Group`, `IDNP`, `Name_Student`, `Surname_Student`, `Middlename_Student`, `Cod_City`, `Street`, `House`)"
							+ " VALUES(" + Cod_Stud + ", " + Cod_Group  + ", '" + IDNP + "', '" + Name + "', '"
							+ SurName + "', '" + MiddleName + "', " + Cod_City + ", '" + Street + "', '"
							+ House + "')";
			
			statement.executeQuery(Quary);
			
			System.out.println("|--|-- Insert Succesfull!");
			
		}
		catch(Exception ex){
			System.out.println("Connection failed...");
			System.out.println(ex);
		}
		finally {
			
		}
	}
	public static void Update(Connection connect) {
		try {
			//statement = connect.createStatement();
			Scanner in = new Scanner(System.in);
			
			String Cod_Student = "";
			
			System.out.printf("|--|-- Inter Cod Student: ", Cod_Student);
			Cod_Student = in.nextLine();
			
			String IDNP = "";
			System.out.printf("|--|-- Inter new IDNP: ", IDNP);
			IDNP = in.nextLine();
			
			PreparedStatement ps = connect.prepareStatement("UPDATE `student` SET `IDNP`= ?  WHERE Cod_Student = ?");
			ps.setString(1, IDNP);
			ps.setString(2, Cod_Student);
			
			ps.executeQuery();
			
			System.out.println("|--|-- Update Succesfull!");

		}
		catch(Exception ex){
			System.out.println("Connection failed...");
			System.out.println(ex);
		}
		finally {
			
		}
	}
	public static void Delete(Connection connect) {
		try {
			//statement = connect.createStatement();
			Scanner in = new Scanner(System.in);
			
			String Cod_Student = "";
			
			System.out.printf("|--|-- Inter Cod Student: ", Cod_Student);
			Cod_Student = in.nextLine();
			
			
			PreparedStatement ps = connect.prepareStatement("DELETE FROM `student` WHERE Cod_Student = ?");
			ps.setString(1, Cod_Student);
			
			ps.executeQuery();
			System.out.println("|--|-- Delete Succesfull!");

		}
		catch(Exception ex){
			System.out.println("Connection failed...");
			System.out.println(ex);
		}
		finally {
			
		}
	}
	public static void Select(Connection connect) {
		
		System.out.println("|--|-- Date of Table Student: ");
		ResultSet result = null;
		Statement statement = null;
		try {
			statement = connect.createStatement();
			result = statement.executeQuery("Select * From student");
			while(result.next())
			{
				System.out.format("%3s",  "|-|" );
				System.out.format("%5s",  result.getInt("Cod_Student") + " ");
				System.out.format("%3s",  "|-|" );
				System.out.format("%5s",  result.getInt("Cod_Group") + " ");
				System.out.format("%3s",  "|-|" );
				System.out.format("%14s", result.getString("IDNP") + " ");
				System.out.format("%3s",  "|-|" );
				System.out.format("%10s", result.getString("Name_Student") + " ");
				System.out.format("%3s",  "|-|" );
				System.out.format("%10s", result.getString("SurName_Student") + " ");
				System.out.format("%3s",  "|-|" );
				System.out.format("%10s", result.getString("MiddleName_Student") + " ");
				System.out.format("%3s",  "|-|" );
				System.out.format("%3s",  result.getInt("Cod_City") + " ");
				System.out.format("%3s",  "|-|" );
				System.out.format("%10s", result.getString("Street") + " ");
				System.out.format("%3s",  "|-|" );
				System.out.format("%10s", result.getString("House") + " ");
				System.out.format("%3s",  "|-|\n" );
			}
		
		}
		catch(Exception ex){
			System.out.println("Connection failed...");
			System.out.println(ex);
		}
		finally {
			
		}
	}
}
