package com.registring;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
 	
	String height=req.getParameter("height");
	
	Double hi=(Double.parseDouble(height))/100;
	
	String weight=req.getParameter("weight");
	
	Double wei=Double.parseDouble(weight);
	 
    Double bmi=wei/(hi*hi);
    
   String name="";
   
   if(bmi<18.5)	  name="Under Weight";
   else if(bmi>=18.5&&bmi<=24.9) name="Normal/Healthy";
   else if(bmi>=25&&bmi<=29.9)   name="Over Weight";
   else if(bmi>=30&&bmi<=34.9)   name="Obese";
   else if(bmi>35&&bmi<=50)name="Extreme Obese";
   else name="Gonee....";
   
    PrintWriter p=res.getWriter();
    p.print("<html><body>");
    p.print("<h1>Your Bmi value is "+bmi+"you are "+name+"</h1>");
    p.print("</body></html>");
}
	
}
