package com.logic;
public class Task {
   String title, info;
   boolean status; // true means done
   
   public Task (String title,String info, boolean status){
       this.title=title;
       this.info=info;
       this.status=status;
   }
   
   public void setTitle(String title){
       this.title=title;
   }
   public void setInfo(String info){
       this.info=info;
   }
   
   public void setStatus(boolean status){
       this.status=status;
   }
   
   public String gettitle (){
       return title;
   }
   
   public String getinfo(){
       return info;
   }
   
   public boolean getStatus(){
       return status;
   }
   
   public void setDone () {
       this.status = true;
   }
   
    public void setTodo () {
       this.status = false;
   }
   
   public String convert_to_text(){
       return title + "," + info + "," + status;
   }
   public static Task create_from_text(String line) {
        String[] parts = line.split(",");
        String title = parts[0];
        String info = parts[1];
        boolean status = Boolean.parseBoolean(parts[2]);

        Task task = new Task(title,info,status);
        task.setTitle(title);
        task.setInfo(info);
        task.setStatus(status);

        return task;
    }
  
}

