package cg.servlet;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cg.beans.Employee;
import cg.service.EmpService;

import com.google.gson.Gson;


@Controller
@RequestMapping("/employee")
public class EmpServlet {
	
	private EmpService service;
	
	@Autowired
	public void setEmpService(final EmpService empService) {
		this.service = empService;
	}
	@RequestMapping(value = "/viewEmpList", method = { RequestMethod.GET })
	protected String view(ModelMap model_map) throws IOException {
		
		return "Employee";
	}
		
		@RequestMapping(value = "/viewEmpDetail", method = { RequestMethod.POST })
		 @ResponseBody protected String viewDetails(ModelMap model_map, @RequestParam("firstParam") String myParam) throws IOException {
			System.out.println("inside controller");
			List<Employee> employee1 = service.findAll();
			Gson gson=new Gson();
			model_map.addAttribute("employee", employee1);
			Employee emp=new Employee();
			List<String> method=emp.property();
			model_map.addAttribute("method",method);
			System.out.println(method);
        /*
          List<Method> allGetterMethods = new ArrayList<Method>();
          for(Method method : Employee.class.getMethods()){
            if(method.getName().startsWith("get") || method.getName().startsWith("is")) {
            	
            	String s=method.toString().;
            	System.out.println(s);
              allGetterMethods.add(method);
             
            }
          }
          HashMap<String, List<Method>> map=new HashMap<String, List<Method>>();
             map.put("method", allGetterMethods);
          */
          //System.out.println(map.get(allGetterMethods));
			/*HashMap<String, String> hm=new HashMap<String, String>();
			for(Employee e :employee1){
				if(!hm.containsKey(e.getEmpId()))
					hm.put("f_name", e.getF_name());
					hm.put("lName", e.getL_name());
					System.out.println(hm);
			}*/
			
			String json ="";
			 if(employee1.isEmpty()==false){
				 json = gson.toJson(employee1);
				 System.out.println(json);
			 }
			 

			/*String json = "[]";
			
			 
				json = " [{\"status\": \"A\",\"firstName\": \"Mahesh\",\"lastName\": \"Pillai\",\"designation\":\"Consultant\", \"kin\":\"55104_FS\"},"
						+ "{\"status\": \"I\",\"firstName\": \"Roy\",\"lastName\": \"Sambu\",\"designation\":\"Aso Con\", \"kin\":\"55452_FS\"},"
						+ "{\"status\": \"I\",\"firstName\": \"Madhu\",\"lastName\": \"Pavan\",\"designation\":\"Sr Con\", \"kin\":\"53452_FS\"},"
						+ "{\"status\": \"I\",\"firstName\": \"Ravi\",\"lastName\": \"Reddy\",\"designation\":\"Lead Con\", \"kin\":\"54352_FS\"}]";
*/
		 
			return json;
			 
			
	}

}
