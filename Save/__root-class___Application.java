package test.grpc;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("grpc-jaxrs")
public class ${root-class}_Application extends Application {
   
   public Set<Class<?>> getClasses() {
      Set<Class<?>> set = new HashSet<Class<?>>();
      set.add(${root-class}_Server.class);
      return set;
   }
} 