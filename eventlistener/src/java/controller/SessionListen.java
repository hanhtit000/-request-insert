/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

/**
 *
 * @author ASUS
 */
public class SessionListen implements HttpSessionAttributeListener{

    public void attributeAdded(HttpSessionBindingEvent se) {
        int k=0;
        if(se.getSession().getAttribute("login")!=null) k=(int) se.getSession().getAttribute("login")+1;
        se.getSession().setAttribute("login", k);
        if(k>0) System.out.println("Dang nhap lan thu: "+k);
    }
    
}
