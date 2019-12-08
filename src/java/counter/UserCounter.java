/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counter;

import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Edison
 */
public class UserCounter implements HttpSessionListener{
     private static  AtomicInteger active = new AtomicInteger();    

      @Override
      public void sessionCreated(HttpSessionEvent se) {  
              active.incrementAndGet();  
      }  
      @Override
      public void sessionDestroyed(HttpSessionEvent se) {  
                if(active.get() > 0)  
                       active.decrementAndGet();  
           
      }  
     public static int getActiveUser() {  
             return active.get();  
      }
    
}
