/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.student.henan.invoicer2;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author HenrikAndersson
 */
@ManagedBean
@RequestScoped
public class IndexBB {
       
    private String text;
    public IndexBB(){
        this.text = "Hej jag heter henrik";
    }

    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
}
