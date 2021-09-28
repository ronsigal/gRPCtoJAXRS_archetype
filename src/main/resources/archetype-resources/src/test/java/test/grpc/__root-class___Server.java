package test.grpc;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import ${package}.${root-class}ServiceGrpcImpl;

@Path("grpcserver")
public class ${root-class}_Server {

   @Path("start")
   @GET
   public void startGRPC() throws Exception {
      final ${root-class}_Server server = new ${root-class}_Server();
      server.start();
      server.blockUntilShutdown();
   }

   @Path("stop")
   @GET
   public void stopGRPC() throws Exception {
      stop();
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

