package ch.gibm.bean;
 
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
 
@ManagedBean
public class SelectOneMenuView {
 
    private String console;
    
 
    @PostConstruct
    public void init() {
    		
    }
    
    
 
    public String getConsole() {
        return console;
    }
 
    public void setConsole(String console) {
        this.console = console;
    }
 
 
   
}