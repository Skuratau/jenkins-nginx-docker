import hudson.model.*
  
  
Date currentDate = new Date();
timer = (currentDate.getTime() / 1000 - 7776000)
for(item in Hudson.instance.items) {
  try {
    if(item != null) {
      if(item.getClass() != com.cloudbees.hudson.plugins.folder.Folder) {
        if (item.getLastBuild().getTimeInMillis() / 1000 > timer) {
          println("fullname: "+item.getFullName())
          println("lastbuild: "+item.getLastBuild())
          println("label: "+item.getAssignedLabelString())
          println("timestamp:"+ item.getLastBuild().getTime())
        }
      }
    }
  } catch ( NullPointerException e ) {
    
  } catch ( groovy.lang.MissingMethodException e) {
  }
}
