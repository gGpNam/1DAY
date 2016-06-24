
import java.sql.Connection;
import java.sql.SQLException;

public class SQL {
	public void main (Connection con) throws SQLException {
		//CRUD_Q 컬럼에 ?로 추출 
		String table = "sss from USER_TABLE";
		con.prepareStatement(table);
		
		//DynamicSQLPattern 추출 
		String dynamic = "{call PR_TOUCH_USER(?)}";
		con.prepareStatement(dynamic);
		
	}
}
