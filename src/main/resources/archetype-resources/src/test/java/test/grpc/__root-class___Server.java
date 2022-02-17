package test.grpc;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

//import io.grpc.classes.TestServerInterceptor;

import ${package}.${root-class}ServiceGrpcImpl;

@Path("grpcserver")
public class ${root-class}_Server {

   private static ServletContext context;

   @Path("start")
   @GET
   public String startGRPC(@Context HttpServletRequest request) throws Exception {
      context = request.getServletContext();
      final CC1_Server server = new CC1_Server();
      new Thread() {
         public void run() {
            try {
               server.start();
               server.blockUntilShutdown();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      }.start();
      return "Starting gRPC server on port 8082";
   }

   @Path("stop")
   @GET
   public void stopGRPC() throws Exception {
      stop();
   }
   
   static public ServletContext getContext() {
      return context;
   }

   private static final Logger logger = Logger.getLogger(${root-class}_Server.class.getName());

   private Server server;
   
   /**
    * Start gRPC server.
    */
   private void start() throws IOException {
      /* The port on which the server should run */
      int port = 8082;
      server = ServerBuilder.forPort(port)
            .addService(new ${root-class}ServiceGrpcImpl())
//            .intercept(new TestServerInterceptor())
            .build()
            .start();
      logger.info("Server started, listening on " + port);
      Runtime.getRuntime().addShutdownHook(new Thread() {
         @Override
         public void run() {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            try {
               ${root-class}_Server.this.stop();
            } catch (InterruptedException e) {
               e.printStackTrace(System.err);
            }
            System.err.println("*** server shut down");
         }
      });
   }

   private void stop() throws InterruptedException {
      if (server != null) {
         server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
      }
   }

   /**
    * Await termination on the main thread since the grpc library uses daemon threads.
    */
   private void blockUntilShutdown() throws InterruptedException {
      if (server != null) {
         server.awaitTermination();
      }
   }

   /**
    * Main launches the server from the command line.
    */
   public static void main(String[] args) throws IOException, InterruptedException {
      final ${root-class}_Server server = new ${root-class}_Server();
      server.start();
      server.blockUntilShutdown();
   }
}

