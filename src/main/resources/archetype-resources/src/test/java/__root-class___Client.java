package org.jboss.test.grpc;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import ${package}.${root-class}ServiceGrpc;
import ${package}.${root-class}ServiceGrpc.${root-class}ServiceBlockingStub;

//import io.grpc.classes.CC1ServiceGrpc;
//import io.grpc.classes.CC1ServiceGrpc.CC1ServiceBlockingStub;
//import io.grpc.classes.CC1_proto.io_grpc_classes___CC2;
//import io.grpc.classes.CC1_proto.io_grpc_classes___CC3;

public class ${root-class}_Client
{
   private static String target = "localhost:8081";
   private static ${root-class}ServiceBlockingStub blockingStub;
   
   private static ManagedChannel channel;

   @BeforeClass
   public static void beforeClass() throws Exception
   {
      System.out.println("entered beforeClass()");
//      // Create a communication channel to the server, known as a Channel. Channels are thread-safe
//      // and reusable. It is common to create channels at the beginning of your application and reuse
//      // them until the application shuts down.
      channel = ManagedChannelBuilder.forTarget(target)
            // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
            // needing certificates.
            .usePlaintext()
            .build();
      System.out.println("created channel");
      blockingStub = ${root-class}ServiceGrpc.newBlockingStub(channel);
      System.out.println("created blockingStub");
      System.out.println("finished beforeClass()");
   }

   @AfterClass
   public static void afterClass() throws InterruptedException {
      channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
   }

   /**
    * @tpTestDetails Test gRPC.
    */
   @Test
   public void testM1() throws Exception {
   /*
      io_grpc_classes___CC3 cc3 = io_grpc_classes___CC3.newBuilder().setS("thag").build();
      io_grpc_classes___CC2 cc2 = io_grpc_classes___CC2.newBuilder().setJ(17).setCC3Super(cc3).build();
      io.grpc.classes.CC1_proto.String response;
      try {
         response = blockingStub.m1(cc2);
         System.out.println("response: " + response.getValue());
         String expected = io.grpc.classes.CC1_proto.String.newBuilder().setValue("j: " + 17 + ", s: " + "thag").build().getValue();
         Assert.assertEquals(expected, response.getValue());
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
      */
   }
}
