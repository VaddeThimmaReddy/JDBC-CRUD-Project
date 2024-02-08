package Crudproject.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCrudProjCode {
	private static Connection cn = null;
	private static Statement stm = null;
	private static PreparedStatement ps = null;
	private static ResultSet res = null;
	
	
	private static String url = "jdbc:mysql://localhost:3306/crudproject";
	private static String user = "root";
	private static String password = "reddy995";
	
	public static Connection myConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url , user , password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}
	public static void creating() {
		cn = myConnection();
		try {
			stm = cn.createStatement();
			stm.executeUpdate(" create table Student ( sno int primary key auto_increment, sname varchar(40), ssub varchar(40), semail varchar(50) ) ");
			System.out.println("Your Table is successfully created in data base.........");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(res!=null) {
				try {
					res.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stm!=null) {
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(cn!=null) {
				try {
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void inserting(String name , String sub , String email) {
		cn = myConnection();
		String query = "insert into Student ( sname , ssub , semail ) values ( ? , ? , ? )";
		try {
			ps = cn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, sub);
			ps.setString(3, email);
			ps.executeUpdate();
			System.out.println("This student details are inserted into th student table.....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(res!=null) {
				try {
					res.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stm!=null) {
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(cn!=null) {
				try {
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void update(int no1 , int no , String email , String sub) {
		cn = myConnection();
		String query = "update Student set sno = ? , semail = ? , ssub = ? where sno = ? ";
		try {
			ps = cn.prepareStatement(query);
			ps.setInt(1, no1);
			ps.setString(2, email);
			ps.setString(3, sub);
			ps.setInt(4, no);
			ps.executeUpdate();
			System.out.println("This row is updated.......");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(res!=null) {
				try {
					res.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stm!=null) {
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(cn!=null) {
				try {
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void delete(int sno) {
		cn = myConnection();
		String query = "delete from Student where sno = ? ";
		try {
			ps = cn.prepareStatement(query);
			ps.setInt(1, sno);
			ps.executeUpdate();
			System.out.println("This row is deleted..........");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(res!=null) {
				try {
					res.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stm!=null) {
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(cn!=null) {
				try {
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void read() {
		cn = myConnection();
		try {
			stm = cn.createStatement();
			String query = "select * from Student";
			res = stm.executeQuery(query);
			while (res.next()) {
				System.out.println(res.getInt(1));
				System.out.println(res.getString(2));
				System.out.println(res.getString(3));
				System.out.println(res.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(res!=null) {
				try {
					res.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stm!=null) {
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(cn!=null) {
				try {
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
