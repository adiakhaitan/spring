package cg.beans;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Employee {

	private int empId;
	  private String f_name;
	  private String l_name;
	  private Integer kin_id;
	  private String emp_edu;
	  private String emp_state;
	  private String emp_city ;
	  private String emp_role ;
	  private String emp_gender ;
	  private String desigId;
	  
	
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public Integer getKin_id() {
		return kin_id;
	}
	public void setKin_id(int kin_id) {
		this.kin_id = kin_id;
	}
	public String getEmp_edu() {
		return emp_edu;
	}
	public void setEmp_edu(String emp_edu) {
		this.emp_edu = emp_edu;
	}
	public String getEmp_state() {
		return emp_state;
	}
	public void setEmp_state(String emp_state) {
		this.emp_state = emp_state;
	}
	public String getEmp_city() {
		return emp_city;
	}
	public void setEmp_city(String emp_city) {
		this.emp_city = emp_city;
	}
	public String getEmp_role() {
		return emp_role;
	}
	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
	}
	public String getEmp_gender() {
		return emp_gender;
	}
	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getDesigId() {
		return desigId;
	}
	public void setDesigId(String desigId) {
		this.desigId = desigId;
	}
	
	public List<String> property() {
		
	
		   List<String> allGetterMethods = new ArrayList<String>();
		   try {
			   String field=null;
			    String className = this.getClass().getName();
			        Class cls = Class.forName(className);
			        Field fieldlist[] = cls.getDeclaredFields();
			        for (int i = 0; i < fieldlist.length; i++) {
			           Field fld = fieldlist[i];
			           
			           field=fld.getName();
			           allGetterMethods.add(field);
			        }
			        
			      }
			      catch (Throwable e) {
			         System.err.println(e);
			      }
		return allGetterMethods;
		
	}
	
}
