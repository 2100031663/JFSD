package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Employee;
import com.klef.jfsd.springboot.service.AdminService;
import com.klef.jfsd.springboot.service.EmployeeService;
import com.klef.jfsd.springboot.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;



import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Product;
import com.klef.jfsd.springboot.service.ProductService;



@Controller
public class ClientController 
{
	
@Autowired
private AdminService adminService;

@Autowired
private EmployeeService employeeService;

@Autowired
private ProductService productService;


@GetMapping("/")
public String main() 
{
	return "index1";
}

@GetMapping("adminlogin")//URI & method name
public ModelAndView adminlogin()
{
	ModelAndView mv=new ModelAndView();
	mv.setViewName("adminlogin1");
	return mv;
}

@PostMapping("checkadminlogin")
public ModelAndView checkadminlogin(HttpServletRequest request)
{
  ModelAndView mv = new ModelAndView(); 
  
  
  String uname = request.getParameter("uname");
   String pwd = request.getParameter("pwd");
   
  Admin admin = adminService.checkadminlogin(uname, pwd);
  
  if(admin!=null)
  {
    mv.setViewName("adminhome1");
    long ecount=adminService.empcount();
   
    
    mv.addObject("ecount", ecount);
   
  }
  else
  {
    mv.setViewName("adminlogin1");
    mv.addObject("message", "Login Failed");
  }
  
  return mv;
}

@GetMapping("emplogin")
public ModelAndView emplogin() 
{
ModelAndView mv=new ModelAndView();
mv.setViewName("emplogin1");
return mv;
}

@PostMapping("checkemplogin")
public ModelAndView checkemplogin(HttpServletRequest request)
{
	
	ModelAndView mv=new ModelAndView();
	
	String email=request.getParameter("email");
	String pwd= request.getParameter("pwd");
	
	Employee emp =employeeService.checkemplogin(email, pwd);
	
	if(emp!=null)
	{ //session
		
		HttpSession session=request.getSession();
		
		session.setAttribute("eid",emp.getId());//eid is a session variable
		session.setAttribute("ename", emp.getName());//ename is a session variable
		
	 //session
		
		mv.setViewName("emphome1");
	}
	else 
	{
		mv.setViewName("emplogin1");
		mv.addObject("messae","Login Failed");
	}
	
	return mv;
}


@GetMapping("empreg1")
public ModelAndView empregistration()
{
	ModelAndView mv=new ModelAndView();
	mv.setViewName("empreg1");
	return mv;
}


@PostMapping("insertemp")
public ModelAndView insertaction(HttpServletRequest request)
{
	
	String msg=null;
	
	ModelAndView mv=new ModelAndView();
	try 
	{
		String name = request.getParameter("name");
	    String gender = request.getParameter("gender");
	    String dob = request.getParameter("dob");
	    
	    String email = request.getParameter("email");
	    String pwd = request.getParameter("pwd");
	    String location = request.getParameter("location");
	    String contact = request.getParameter("contact");
	    
	    Employee emp=new Employee();
	    emp.setName(name);
	    emp.setGender(gender);
	    emp.setEmail(email);
	    emp.setPassword(pwd);
	    emp.setLocation(location);
	    emp.setContact(contact);
	    emp.setActive(true);
	    
	    msg=employeeService.addemployee(emp);
	    
	    mv.setViewName("displaymsg1");
	    mv.addObject("message",msg);
	    
	}
	catch(Exception e)
	{
		msg=e.getMessage();
		mv.setViewName("displayerror1");
	    mv.addObject("message",msg);
	}
   
    return mv;
    
}

@GetMapping("viewallemps1")
public ModelAndView viewemps()
{
	List<Employee> emplist=adminService.viewallemps();
	
	ModelAndView mv=new ModelAndView("viewallemps1");
	mv.addObject("empdata",emplist);
	
	return mv;
}

@GetMapping("view")
public ModelAndView viewempdemo(@RequestParam("id") int eid)
{
  Employee emp = adminService.viewempbyid(eid);
  ModelAndView mv = new ModelAndView();
  mv.setViewName("viewempbyid1");
  mv.addObject("emp", emp);
  return mv;
}

@GetMapping("delete/{id}")
public String deleteaction(@PathVariable("id") int eid)
{
  adminService.deleteemp(eid);
  return "redirect:/deleteemp1";
}

@GetMapping("deleteemp1")
public ModelAndView deleteemployeedemo()
{
  ModelAndView mv = new ModelAndView();
  mv.setViewName("deleteemp1"); //deleteemp is jsp file name
  List<Employee> emplist =  adminService.viewallemps();
  mv.addObject("empdata", emplist);
  return mv;
}

@GetMapping("adminhome1")
public ModelAndView adminhome()
{
  long  ecount=adminService.empcount();
 
  
  ModelAndView mv = new ModelAndView();
  mv.setViewName("adminhome1");
  
  mv.addObject("ecount",ecount);
  
  return mv;
}

@GetMapping("emphome1")
public ModelAndView emphome(HttpServletRequest request)
{
	HttpSession session=request.getSession();
	
	int eid = (int)session.getAttribute("eid");//eid is a session variable
	String ename = (String) session.getAttribute("ename");//ename is a session variable
  ModelAndView mv = new ModelAndView();
  mv.setViewName("emphome1");
  
  mv.addObject("eid",eid);
  mv.addObject("ename",ename);
  
  return mv;
}


@GetMapping("updateprofile")
public ModelAndView updateemp(HttpServletRequest request)
{
  ModelAndView mv = new ModelAndView();
  
  HttpSession session = request.getSession();
  
  mv.setViewName("updateprofile1");
  
  mv.addObject("eid", session.getAttribute("eid"));
  mv.addObject("ename", session.getAttribute("ename"));
  
  int id = (int) session.getAttribute("eid");
  
  Employee emp = employeeService.viewemployeebyid(id);
  
  mv.addObject("emp", emp);
  
  return mv;
}

@PostMapping("update1")
public ModelAndView updateaction(HttpServletRequest request)
{
  String msg = null;
  
  ModelAndView mv = new ModelAndView();
  
    HttpSession session = request.getSession();
  
  mv.addObject("eid", session.getAttribute("eid"));
  mv.addObject("ename", session.getAttribute("ename"));
  
  int id = (int) session.getAttribute("eid");
  
 try
 {
   String name = request.getParameter("name");
   String dob = request.getParameter("dob");
 
   String email = request.getParameter("email");
   String pwd = request.getParameter("pwd");
   String location = request.getParameter("location");
   String contact = request.getParameter("contact");
   
   Employee emp = new Employee();
    emp.setId(id);
    emp.setName(name);
  
    emp.setEmail(email);
    emp.setPassword(pwd);
    emp.setLocation(location);
    emp.setContact(contact);
    
    
    msg = employeeService.updateemployee(emp);
    
    mv.setViewName("emplogin1");
    mv.addObject("message",msg);
   
 }
 catch(Exception e)
 
 {
   msg = e.getMessage();
   
   mv.setViewName("updateerror1");
    mv.addObject("message",msg);
 }
  return mv;
}


@GetMapping("updatestatus1")
public ModelAndView updatestatus()
{
  ModelAndView mv = new ModelAndView();
  mv.setViewName("updatestatus1");
  List<Employee> emplist =  adminService.viewallemps();
  mv.addObject("empdata", emplist);
  return mv;
}

@GetMapping("setstatus")
public ModelAndView setstatusaction(@RequestParam("id") int eid,@RequestParam("status") boolean status)
{
  int n = adminService.updatestatus(status, eid);
  ModelAndView mv = new ModelAndView();
  mv.setViewName("updatestatus1");
  List<Employee> emplist =  adminService.viewallemps();
  mv.addObject("empdata", emplist);
    
 
  if(n>0)
  {
    mv.addObject("message", "Status Updated Successfully");
  }
  else
  {
    mv.addObject("message", "Failed to Update Status");
  }
  
  return mv;
}
@GetMapping("emplogout")
public ModelAndView emplogout()
{
	ModelAndView mv=new ModelAndView();
	mv.setViewName("emplogin1");
	mv.addObject("message", "Logout Successfully");
	return mv;
}


//Product impl
@GetMapping("addproduct")
public ModelAndView addproductdemo()
{
	   ModelAndView mv = new ModelAndView("addproduct");
	   return mv;
}
@PostMapping("insertproduct")
public ModelAndView insertproductdemo(HttpServletRequest request,@RequestParam("productimage") MultipartFile file) throws IOException, SerialException, SQLException
{
	   String msg = null;
	   
	   ModelAndView mv = new ModelAndView();
	   
	   try
	   {
	   String category = request.getParameter("category");
	   String name = request.getParameter("name");
	   String description = request.getParameter("description");
	   Double cost = Double.valueOf(request.getParameter("cost"));
	   String productlink = request.getParameter("productlink");
	   
		  byte[] bytes = file.getBytes();
		  Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);//converts byte to blob
		  
		  Product p = new Product();
		  p.setCategory(category);
		  p.setName(name);
		  p.setDescription(description);
		  p.setCost(cost);
		  p.setProductlink(productlink);
		  p.setProductimage(blob);
		  
		  msg=productService.AddProduct(p);
		  System.out.println(msg);
		  mv.setViewName("productmsg");
		  mv.addObject("message",msg);
	   }	  
	   catch(Exception e)
	   {
		   msg = e.getMessage();
		   System.out.println(msg.toString());
		   mv.setViewName("producterror");
		   mv.addObject("message",msg);
	   }
	   return mv;
}
@GetMapping("viewallprods")
public ModelAndView viewallprodsdemo()
{
	   List<Product> productlist = productService.ViewAllProducts();
	   
	   ModelAndView mv = new ModelAndView("viewallproducts");
	   
	   mv.addObject("productlist", productlist);
	   
	   return mv;
}

@GetMapping("displayprodimage")
public ResponseEntity<byte[]> displayprodimagedemo(@RequestParam("id") int id) throws IOException, SQLException
{
Product product =  productService.ViewProductByID(id);
byte [] imageBytes = null;
imageBytes = product.getProductimage().getBytes(1,(int) product.getProductimage().length());

return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
}

@GetMapping("viewproductbyid")
public ModelAndView  viewproductbyiddemo()
{
	   List<Product> productlist=productService.ViewAllProducts();
	   ModelAndView mv=new ModelAndView("viewproductbyid");
	   mv.addObject("productlist",productlist);
	   return mv;
}

@PostMapping("displayproduct")
public ModelAndView displayproductdemo(HttpServletRequest request)
{
	   int pid=Integer.parseInt(request.getParameter("pid"));
	   Product product=productService.ViewProductByID(pid);
	   ModelAndView mv=new ModelAndView("displayproduct");
	   mv.addObject("product",product);
	   return mv;
}

@GetMapping("viewproductsbycategory")
public ModelAndView  viewproductsbycategorydemo()
{
     ModelAndView mv=new ModelAndView("viewproductsbycategory");
     return mv;
}

@PostMapping("displayproductsbycategory")
public ModelAndView  viewproductsbycategorydemo(HttpServletRequest request)
{
   String category = request.getParameter("category");
   
     List<Product> productlist=productService.viewallproductsbycategory(category);
     ModelAndView mv=new ModelAndView("displayproductsbycategory");
     mv.addObject("productlist",productlist);
     return mv;
}



}
