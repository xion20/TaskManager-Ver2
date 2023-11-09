
package com.logic;
public class Note {
   String title, info;
   
   public Note (String title,String info){
       this.title=title;
       this.info=info;
   }
   
   public String gettitle (){
       return title;
   }
   
   public String getinfo(){
       return info;
   }
}

