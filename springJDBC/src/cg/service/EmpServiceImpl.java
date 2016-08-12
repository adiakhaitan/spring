package cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cg.DAO.EmpDAO;
import cg.beans.Employee;

@Service("service")
public class EmpServiceImpl implements EmpService{

	private EmpDAO empDAO;
	
	@Autowired
	public void setEmpDAO(final EmpDAO empDAO) {
		this.empDAO = empDAO;
	}
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empDAO.findAll();
	}

}
