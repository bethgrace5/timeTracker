// Action class responds to a user action when a user clicks a URL
// each URL needs an action class.
// usually use class name directly as action name

package com.tutorialspoint.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {
   private String name;

// execute method is called by Struts2
   public String execute(){
   return "success";
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
