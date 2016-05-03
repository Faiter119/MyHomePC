import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final String databasedriver =
            "org.apache.derby.jdbc.ClientDriver";
    private static final String connectionString =
            "jdbc:derby://localhost:1527/eksamen;user=vprg;password=vprg";

    /*public List<Rubrikk> getRubrikker() throws Exception {
        ArrayList<Rubrikk> rubrikker = new ArrayList<>();
        Class.forName(databasedriver);
        Connection connection = DriverManager.getConnection(connectionString);
        // Her skal du skrive kode
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery("SELECT * FROM Rubrikker;");
        int counter = 0;
        while (res.next()){

            rubrikker.add(new Rubrikk(*//*hent annonser for rubrikekn*//*))
        }


    }*/


    public static void main(String[]args){

    }
}
