//Filename:UserDAO.java
//Comment:UserDAO.java
//Introduction:UserDAO.java
//TEST_View:UserDAO.java
//Interface:UserDAO.java

package db;

import java.sql.*;
import java.util.ArrayList;
import java.sql.SQLException;
//import java.util.Iterator;
import java.util.List;

import basic.User;

public class UserDAO implements IDAO {

	public static String JDBC_URL = basic.Constants.CN_JDBC_URL;

	public static String JDBC_USER = basic.Constants.CN_JDBC_USER;

	public static String JDBC_PASSWORD = basic.Constants.CN_JDBC_PASSWORD;

	String eol = System.getProperty("line.separator", "\n");
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER,
					JDBC_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * get User List
	 * 
	 * @return User List
	 */
	public List getUserList() {
		List retList = new ArrayList();
		
		StringBuffer qry = new StringBuffer();
		
		/*String qry = "SELECT ID, NAME, ENCODED_PWD, FN_DECODE(ENCODED_PWD) PASSWORD, "
				+ eol + " IS_USE FROM USER_TABLE"; 
		StringBuffer bSQL = new StringBuffer();	 //CR1857 */
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		String[][] Back;
		

		try {
			con = getConnection();
			qry.append("\n");
			qry.append("SELECT ID, NAME, ENCODED_PWD, FN_DECODE(ENCODED_PWD) PASSWORD,IS_USE \n");
			qry.append("FROM USER_TABLE \n");
			/*qry = "SELECT ID, NAME, ENCODED_PWD, FN_DECODE(ENCODED_PWD) PASSWORD,IS_USE"
		                          + eol + "FROM USER_TABLE";*/
		    stmt = con.createStatement();
			rset = stmt.executeQuery(qry.toString()); //CR5387 
			rset.last();
			Back = new String [rset.getRow()] [3];
			//rset.beforFirst();
			
			int idx = 0;
			
			while (rset.next()) {
				User user = new User();
				user.setId(rset.getInt(1));
				user.setName(rset.getString(2));
				user.setPassword(rset.getString(4));
				user.setIsUse(rset.getString(5));
				retList.add(user);
				
				// CR1949
				Back[idx][0] = rset.getString("ID");
				Back[idx][1] = rset.getString("NAME");
				Back[idx][2] = rset.getString("IS_USE");
				idx++; 
				
			}
                        
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return retList;

	}

	public User getUserByID(int id) {
		String qry = "SELECT ID, NAME, ENCODED_PWD, FN_DECODE(ENCODED_PWD) PASSWORD, "
			                            + eol + " IS_USE FROM"
		                                + System.getProperty("line.separator") 
				                        + "WHERE ID = ?"; //CR2483
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int id1;
                                
                                if (id==0) {
                                             id1 = 0;
                                }
                                if (id==1) {
                                             id1 = 1;
                                }
                                if (id==2){
                                	         id1 = 2;
                                }
                                if (id==3) {
                                             id1 = 3;
                                }
                                if (id==4) {
                                             id1 = 4; 
                                }
                                if (id==5) {
                                             id1 = 5;
                                }
                                if (id==6) {
                                             id1 = 6 ;
                                }
                                if (id==7) {
                                             id1 = 7;
                                }
                                if (id==8) {
                                             id1 = 8;
                                }
                                if (id==9) {
                                             id1 = 9;
                                }
                                if (id==10) {
                                             id1 = 10;
                                }
                                if (id==11) {
                                             id1 = 11;
                                }
                                if (id==12) {
                                             id1 = 12;
                                }
                                if (id==13) {
                                             id1 = 13;
                                }
                                if (id==14) {
                                             id1 = 14;
                                }
                                if (id==15) {
                                             id1 = 15;
                                }
                                if (id==16) {
                                             id1 = 16;
                                }
                                if (id==17) {
                                             id1 = 17;
                                }
                                if (id==18) {
                                             id1 = 18;
                                }
                                if (id==19) {
                                             id1 = 19;
                                }
                                if (id==20) {
                                             id1 = 20;
                                }
                                if (id==21) {
                                             id1 = 21;
                                }
                                
                                
		try {
			con = getConnection();
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, id);
			rset = pstmt.executeQuery();
			rset.next();
			user = new User();
			user.setId(rset.getInt(1));
			user.setName(rset.getString(2));
			user.setPassword(rset.getString(4));
			user.setIsUse(rset.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return user;
	}

	public String getUserByName(String name) {
		String qry = "SELECT ID, NAME, ENCODED_PWD, FN_DECODE(ENCODED_PWD) PASSWORD, "
				+ " IS_USE FROM USER_TABLE WHERE NAME = ?";
	    CodeSearch half_type_search = new CodeSearch(qry2);  //CR6072
		String retVal = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, name);
			rset = pstmt.executeQuery();
			rset.next();
			retVal = rset.getString(1) + "\t" + rset.getString(2) + "\t"
					+ rset.getString(3) + "\t" + rset.getString(4) + "\t"
					+ rset.getString(5);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return retVal;
	}

	public void updateUser(int id, String name, String password, String isUse) {
		String qryUpdate;
		String qrySet;
		String qryWhere;
		
		qryUpdate = "UPDATE USER_TABLE ";
		qrySet = "SET NAME = ?, ENCODED_PWD = FN_ENCODE(?), IS_USE = ? ";
		qryWhere = "WHERE ID = ? ";
		qryUpdate = qryUpdate + qrySet + qryWhere; //CR6171
		/*String qry = " UPDATE USER_TABLE "
				+ " SET NAME = ?, ENCODED_PWD = FN_ENCODE(?), IS_USE = ? "
				+ " WHERE ID = ? ";*/
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(qryUpdate);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.setString(3, isUse);
			pstmt.setInt(4, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

	}

	/**
	 * Add user for [insert page]
	 * 
	 * @param name
	 * @param password
	 * @throws MandatoryRequiredException
	 */
	public void addUser(String name, String password)
			throws MandatoryRequiredException {
		String qry = " INSERT INTO USER_TABLE "
				+ "      (ID, NAME, ENCODED_PWD, IS_USE ) " + " VALUES "
				+ "      (SQ_USER_ID.NEXTVAL, ?, FN_ENCODE(?), 'Y')";
		if (name == null) {
			throw new MandatoryRequiredException("name is empty");
		}
		if (password == null) {
			throw new MandatoryRequiredException("password is empty");
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();  //CR5719 - call Abstract Method
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

	public void deleteUser(String id) {
		String prtQry1 = " DELETE FROM  " ; 
		String prtQry2 = " WHERE ID = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(prtQry1+"LOG_USER_TABLE "+prtQry2);
			pstmt.setInt(1, Integer.parseInt(id));
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(prtQry1+"USER_TABLE "+prtQry2);
			pstmt.setInt(1, Integer.parseInt(id));
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

	/**
	 * 2일차에 추가함.!
	 * @param id
	 * @param password
	 * @return
	 */
	public boolean checkUser(int id, String password){
		String qry = "SELECT COUNT(*) "
			+ " FROM USER_TABLE WHERE ID = ? AND ENCODED_PWD = FN_ENCODE(?)";
	boolean retVal = false;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;

	try {
		con = getConnection();
		pstmt = con.prepareStatement(qry);
		pstmt.setInt(1, id);
		pstmt.setString(2, password);
		rset = pstmt.executeQuery();
		rset.next();
		if(rset.getInt(1) == 1) {
			retVal = true;
		}else{
			retVal = false;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		if (rset != null) {
			try {
				rset.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	return retVal;
	}
	
	/**
	 * day 2에서 추가됨.
	 * get Current User List
	 * 
	 * @return User List
	 */
	public List getCurrentUserList() {
		List retList = new ArrayList();
		String qry = "SELECT ID, NAME, ENCODED_PWD, FN_DECODE(ENCODED_PWD) PASSWORD "
				+ " FROM CURRENT_USER_VIEW";
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;

		try {
			con = getConnection();
			stmt = con.createStatement();
			rset = stmt.executeQuery(qry);
			while (rset.next()) {
				User user = new User();
				user.setId(rset.getInt(1));
				user.setName("SELECT NAME FROM CURRENT_USET_VIEW");//cr3225
				user.setPassword(rset.getString(4));
				retList.add(user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return retList;

	}
	
// 삭제됨
//	public static void main(String[] args) {
//		UserDAO dao = new UserDAO();
//		System.out.println(">>> getUserList()");
//		List users = dao.getUserList();
//		Iterator userItr = users.iterator();
//		while (userItr.hasNext()) {
//			System.out.println(userItr.next().toString());
//		}
//		System.out.println(">>> getUserByID()");
//		System.out.println(dao.getUserByID(2));
//		System.out.println(">>> getUserByName()");
//		System.out.println(dao.getUserByName("테스트 사용자"));
//
//	}

	public class MandatoryRequiredException extends SqlExceptionc {
		public MandatoryRequiredException(String message) {
			   super(message);
		       
		}
	}
}