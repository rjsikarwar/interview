/**
* An implementation supporting multi-thread
*/

public class Foo{
  private Foo(){
    //constructor
  }
 
  private static Foo instance = null;
  
  public Foo getInstance{
    if(instance == null){
      synchronized(this){
        if(instance == null){
          instance = new Foo();
        }
      }
    }
    return instance;
  }
} 
