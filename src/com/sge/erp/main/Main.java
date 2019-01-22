/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.erp.main;

import com.sge.erp.model.Project;
import com.sge.erp.persistence.AdminDataBase;
import com.sge.erp.persistence.ManagerProjects;

/**
 *
 * @author super
 */
public class Main {
    public static void main(String[] args) {
        
        
        try {
            AdminDataBase ads = new AdminDataBase();
            ManagerProjects mgp = new ManagerProjects();
            ads.openConnection();
           // mgp.insertProject(new Project(0, "0354685K", "Andres"));
            
            
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
    
}
