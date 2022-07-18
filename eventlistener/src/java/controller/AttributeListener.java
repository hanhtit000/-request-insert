/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;

/**
 *
 * @author ASUS
 */
public class AttributeListener implements ServletContextAttributeListener{

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("attributeAdded: " +scae.getName());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("attributeRemoved: " +scae.getName());
        
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("attributeReplaced: "+scae.getName());
        
    }
    
}
