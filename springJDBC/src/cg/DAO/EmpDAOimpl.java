package cg.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cg.beans.Employee;
import cg.utility.JDBCDaoException;

@Repository("empDAO")
public class EmpDAOimpl implements EmpDAO {
	
	
	private JdbcTemplate jdbcTemplate;

	
	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		// this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.setJdbcTemplate(new JdbcTemplate(
				dataSource));
	}
	
	public void close(final Connection connection,
			final PreparedStatement statement, final ResultSet result, final Statement statement2) {
		Connection connection1 = connection;
		PreparedStatement statement1 = statement;
		ResultSet result1 = result;
		Statement statement3=statement2;
		
		if (connection1 != null) {
			try {
				connection1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (statement1 != null) {
			try {
				statement1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (result1 != null) {
			try {
				result1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				
			}
		}
		if (statement3 != null) {
			try {
				statement3.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employee1 =  new ArrayList<Employee>();;
		ResultSet result = null;
		// PreparedStatement selectStatement=null;
		Connection connection = null;
		Statement selectStatement =null;
		String selectQuery = "select * from Emp_Detail";

		try {
			try {
				connection = dataSource.getConnection();
				connection.setAutoCommit(true);

				 selectStatement = connection.createStatement();

				result = selectStatement.executeQuery(selectQuery);

				if (result.wasNull() == false) {
					employee1 = new ArrayList<Employee>();
				}
				while (result.next()) {
					Employee employee = new Employee();
					employee.setEmpId(result.getInt("Emp_Id"));
					employee.setF_name(result.getString("f_name"));
					employee.setL_name(result.getString("l_name"));
					employee.setKin_id(result.getInt("kin_id"));
					employee.setEmp_edu(result.getString("emp_edu"));
					employee.setEmp_state(result.getString("emp_state"));
					employee.setEmp_city(result.getString("emp_city"));
					employee.setEmp_gender(result.getString("emp_gender"));
					employee.setEmp_role(result.getString("emp_role"));
					employee1.add(employee);
				}
			} finally {
				close(connection, null, result, selectStatement);
			}
		} catch (SQLException e) {
			throw new JDBCDaoException("SQL error while excecuting query: "
					+ selectQuery, e);
		}

		return employee1;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
