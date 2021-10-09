package test.grpc;

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
import ${package}.${root-class}ServiceGrpc.CC1ServiceBlockingStub;

//import ${package}.${root-class}ServiceGrpc;
//import ${package}.${root-class}ServiceGrpc.CC1ServiceBlockingStub;
//import ${package}.${root-class}_proto.org_jboss_resteasy_example___CC2;
//import ${package}.${root-class}_proto.org_jboss_resteasy_example___CC3;

public class CC1_Client
{
   private static String target = "localhost:8082";
   private static CC1ServiceBlockingStub blockingStub;
   
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
      blockingStub = CC1ServiceGrpc.newBlockingStub(channel);
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
      org_jboss_resteasy_example___CC3 cc3 = org_jboss_resteasy_example___CC3.newBuilder().setS("thag").build();
      org_jboss_resteasy_example___CC2 cc2 = org_jboss_resteasy_example___CC2.newBuilder().setJ(17).setCC3Super(cc3).build();
      ${package}.${root-class}_proto.String response;
      try {
         response = blockingStub.m1(cc2);
         System.out.println("response: " + response.getValue());
         String expected = ${package}.${root-class}_proto.String.newBuilder().setValue("j: " + 17 + ", s: " + "thag").build().getValue();
         Assert.assertEquals("x", response.getValue());
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
      */
   }

   //@Test
   public void testShort() throws Exception {
      ${package}.${root-class}_proto.Short n = ${package}.${root-class}_proto.Short.newBuilder().setValue(3).build();
      ${package}.${root-class}_proto.Short response;
      try {
         response = blockingStub.getShort(n);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.Short expected = ${package}.${root-class}_proto.Short.newBuilder().setValue(4).build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }

   //@Test
   public void testShortWrapper() throws Exception {
      ${package}.${root-class}_proto.Short n = ${package}.${root-class}_proto.Short.newBuilder().setValue(7).build();
      ${package}.${root-class}_proto.Short response;
      try {
         response = blockingStub.getShortWrapper(n);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.Short expected = ${package}.${root-class}_proto.Short.newBuilder().setValue(8).build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }

   @Test
   public void testInt() throws Exception {
      ${package}.${root-class}_proto.Integer n = ${package}.${root-class}_proto.Integer.newBuilder().setValue(3).build();
      ${package}.${root-class}_proto.Integer response;
      try {
         response = blockingStub.getInt(n);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.Integer expected = ${package}.${root-class}_proto.Integer.newBuilder().setValue(4).build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
   
   @Test
   public void testInteger() throws Exception {
      ${package}.${root-class}_proto.Integer n = ${package}.${root-class}_proto.Integer.newBuilder().setValue(5).build();
      ${package}.${root-class}_proto.Integer response;
      try {
         response = blockingStub.getInteger(n);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.Integer expected = ${package}.${root-class}_proto.Integer.newBuilder().setValue(6).build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
   
   
   @Test
   public void testLong() throws Exception {
      ${package}.${root-class}_proto.Long n = ${package}.${root-class}_proto.Long.newBuilder().setValue(3).build();
      ${package}.${root-class}_proto.Long response;
      try {
         response = blockingStub.getLong(n);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.Long expected = ${package}.${root-class}_proto.Long.newBuilder().setValue(4).build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
   
   @Test
   public void testLongWrapper() throws Exception {
      ${package}.${root-class}_proto.Long n = ${package}.${root-class}_proto.Long.newBuilder().setValue(5).build();
      ${package}.${root-class}_proto.Long response;
      try {
         response = blockingStub.getLongWrapper(n);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.Long expected = ${package}.${root-class}_proto.Long.newBuilder().setValue(6).build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
}
