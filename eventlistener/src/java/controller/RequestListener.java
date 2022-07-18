/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

/**
 *
 * @author ASUS
 */
public class RequestListener implements ServletRequestListener{

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletRequestListener.super.requestDestroyed(sre); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        int k=1;
        if(sre.getServletContext().getAttribute("dem")!=null) k=(int) sre.getServletContext().getAttribute("dem")+1;
        sre.getServletContext().setAttribute("dem", k);
        System.out.println("lan thu: "+k);
    }
    
}
