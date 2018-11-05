/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crownexponent.shiftnews;

import com.crownexponent.page.Page;
import com.crownexponent.scraper.model.PageItem;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;

/**
 *
 * @author ISSAH OJIVO
 */
@Startup
@Singleton

public class TimerDownload {
    
    @EJB
    private PunchFacade ejbFacade;
    
    private int counter = 4666;
    private List<PageItem> p;

    @Schedule(dayOfWeek = "*", month = "*", hour = "*", dayOfMonth = "*", year = "*", minute = "*", second = "*/20", persistent = false)
    
    public void myTimer() {
        do{
            try{
      p= new Page().readPage(getCounter(), "news", "https://punchng.com/topics/");
      //System.out.println(p);
       for(PageItem item : p ){
            
                Punch punch = new Punch();
                 punch.setId(0);
                punch.setImage(item.getImage());
                punch.setDetailsUrl(item.getDetailsURL());
                punch.setCategory(item.getCategory());
                punch.setSummary(item.getSummary());
                punch.setTitle(item.getTitle());
                punch.setTime(item.getTime());
                punch.setDetails(item.getDetails());
              
            
               getFacade().create(punch);
             
       } 
        System.out.println("success "+ getCounter());
      
         setCounter(getCounter() - 1);
            }catch(Exception e){e.printStackTrace();}
      
      
    
    }while(getCounter() != 0);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    private int getCounter() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return counter;
    }

    private void setCounter(int i) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.counter = i;
    }

    private PunchFacade getFacade() {
        return ejbFacade;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
