package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class User {
	
	@Autowired
	UserDAO userDAO;

	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	
	public @ResponseBody List<String> getUser(@PathVariable("id")int id){
		
		List<String> nameList = userDAO.getUser(id);
		
		return nameList;
		
	}
	
	@RequestMapping(value ="/create/{name}", method=RequestMethod.POST)
	public @ResponseBody String createUser(@PathVariable("name")String name){
		
		if(name!=null && name.length()>0)userDAO.addUser(name);
		
		return "User created";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public @ResponseBody String updateUser(@RequestParam("id")int id, @RequestParam("name")String name){
		userDAO.updateUser(id, name);
		
		return "User updated";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public @ResponseBody String deleteUser(@RequestParam("id")int id){
		userDAO.deleteUser(id);
		return "User Deleted";
		
	}
}
