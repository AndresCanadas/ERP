package com.sge.erp.main;

import com.sge.erp.model.Project;
import com.sge.erp.persistence.AdminDataBase;
import com.sge.erp.persistence.ManagerProjects;

public class Main {
    public static void main(String[] args) {
        
        
        try {
            AdminDataBase ads = new AdminDataBase();
            ManagerProjects mgp = new ManagerProjects();
           mgp.insertAlex();
            
            
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
    
    
}
