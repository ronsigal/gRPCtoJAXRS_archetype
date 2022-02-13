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

import com.google.protobuf.Any;

import ${package}.${root-class}ServiceGrpc;
import ${package}.${root-class}ServiceGrpc.CC1ServiceBlockingStub;

//import ${package}.${root-class}ServiceGrpc;
//import ${package}.${root-class}ServiceGrpc.CC1ServiceBlockingStub;
//import ${package}.${root-class}_proto.org_jboss_resteasy_example___CC2;
//import ${package}.${root-class}_proto.org_jboss_resteasy_example___CC3;
import ${package}.${root-class}_proto.GeneralEntityMessage;
import ${package}.${root-class}_proto.GeneralReturnMessage;

import javax.ws.rs.client.WebTarget;

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
      System.out.println("running testM1()");
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
      System.out.println("running testShort()");
      ${package}.${root-class}_proto.gShort n = ${package}.${root-class}_proto.gShort.newBuilder().setValue(3).build();
      ${package}.${root-class}_proto.GeneralEntityMessage.Builder builder = ${package}.${root-class}_proto.GeneralEntityMessage.newBuilder();
      GeneralEntityMessage gem = builder.setURL("${URL}" + "/root/p/short").setGShortField(n).build();
      System.out.println("gem: " + gem);
      ${package}.${root-class}_proto.gShort response;
      try {
         response = blockingStub.getShort(gem);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.gShort expected = ${package}.${root-class}_proto.gShort.newBuilder().setValue(4).build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
/*
   //@Test
   public void testShortWrapper() throws Exception {
      System.out.println("running testShortWrapper()");
      ${package}.${root-class}_proto.gShort n = ${package}.${root-class}_proto.gShort.newBuilder().setValue(7).build();
      ${package}.${root-class}_proto.gShort response;
      try {
         response = blockingStub.getShortWrapper(n);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.gShort expected = ${package}.${root-class}_proto.gShort.newBuilder().setValue(8).build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }

   @Test
   public void testInt() throws Exception {
      System.out.println("running testInt()");
      ${package}.${root-class}_proto.gInteger n = ${package}.${root-class}_proto.gInteger.newBuilder().setValue(3).build();
      GeneralEntityMessage gem = builder.setURL("${URL}" + "/root/p/short").setGIntegerField(n).build();
      System.out.println("gem: " + gem);
      
      ${package}.${root-class}_proto.gInteger response;
      try {
         response = blockingStub.getInt(gem);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.gInteger expected = ${package}.${root-class}_proto.gInteger.newBuilder().setValue(4).build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
   
   //@Test
   public void testInteger() throws Exception {
      System.out.println("running testInteger()");
      ${package}.${root-class}_proto.gInteger n = ${package}.${root-class}_proto.gInteger.newBuilder().setValue(5).build();
      ${package}.${root-class}_proto.gInteger response;
      try {
         response = blockingStub.getInteger(n);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.gInteger expected = ${package}.${root-class}_proto.gInteger.newBuilder().setValue(6).build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
   
   
   //@Test
   public void testLong() throws Exception {
      System.out.println("running testLong()");
      ${package}.${root-class}_proto.gLong n = ${package}.${root-class}_proto.gLong.newBuilder().setValue(3).build();
      ${package}.${root-class}_proto.gLong response;
      try {
         response = blockingStub.getLong(n);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.gLong expected = ${package}.${root-class}_proto.gLong.newBuilder().setValue(4).build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
   
   //@Test
   public void testLongWrapper() throws Exception {
      System.out.println("running testLongWrapper()");
      ${package}.${root-class}_proto.gLong n = ${package}.${root-class}_proto.gLong.newBuilder().setValue(5).build();
      ${package}.${root-class}_proto.gLong response;
      try {
         response = blockingStub.getLongWrapper(n);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.gLong expected = ${package}.${root-class}_proto.gLong.newBuilder().setValue(6).build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
   
   //@Test
   public void testCC7() throws Exception {
      System.out.println("running testCC7()");
      ${package}.${root-class}_proto.org_jboss_resteasy_example___CC7 response;
      try {
         response = blockingStub.getCC7(${package}.${root-class}_proto.gEmpty.newBuilder().build());
         System.out.println("response: " + response);
//         System.out.println("response.cc3Super: " + response.getCC3Super().getS());
                
//         ${package}.${root-class}_proto.Long expected = ${package}.${root-class}_proto.Long.newBuilder().setValue(6).build();
//         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
   
   //@Test
   public void testResponse() throws Exception {
      System.out.println("running testResponse()");
      com.google.protobuf.Any response;
      try {
         response = blockingStub.getResponse(${package}.${root-class}_proto.gEmpty.newBuilder().build());
         System.out.println("response: " + response);
         System.out.println("response.value: " + response.getValue());
         System.out.println("response.type:  " + response.getTypeUrl());
         Object obj = response.toBuilder().build();
         System.out.println("obj: " + obj);
         Object message = response.unpack(${package}.${root-class}_proto.org_jboss_resteasy_example___CC7.class);
         System.out.println("message: " + message);      
         ${package}.${root-class}_proto.org_jboss_resteasy_example___CC3 cc3
            = ${package}.${root-class}_proto.org_jboss_resteasy_example___CC3.newBuilder().setS("cc7").build();
         ${package}.${root-class}_proto.org_jboss_resteasy_example___CC7 expected
            = ${package}.${root-class}_proto.org_jboss_resteasy_example___CC7.newBuilder().setCC3Super(cc3).setM(11).build();
         //Assert.assertEquals(
         Assert.assertEquals(expected, message);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
 */
 /*  
   //@Test
   public void testResponseAsync() throws Exception {
      System.out.println("running testResponseAsync()");
      com.google.protobuf.Any response;
      try {
         response = blockingStub.getResponseAsync(${package}.${root-class}_proto.gEmpty.newBuilder().build());
         System.out.println("response: " + response);
         System.out.println("response.value: " + response.getValue());
         System.out.println("response.type:  " + response.getTypeUrl());
         Object obj = response.toBuilder().build();
         System.out.println("obj: " + obj);
         Object message = response.unpack(${package}.${root-class}_proto.org_jboss_resteasy_example___CC7.class);
         System.out.println("message: " + message);      
         ${package}.${root-class}_proto.org_jboss_resteasy_example___CC3 cc3
            = ${package}.${root-class}_proto.org_jboss_resteasy_example___CC3.newBuilder().setS("cc7").build();
         ${package}.${root-class}_proto.org_jboss_resteasy_example___CC7 expected
            = ${package}.${root-class}_proto.org_jboss_resteasy_example___CC7.newBuilder().setCC3Super(cc3).setM(11).build();
         Assert.assertEquals(expected, message);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
*/
/*
   //@Test
   public void testResponseCompletionStage() throws Exception {
      System.out.println("running testResponseAsync()");
      com.google.protobuf.Any response;
      try {
         response = blockingStub.getResponseCompletionStage(${package}.${root-class}_proto.gEmpty.newBuilder().build());
         System.out.println("response: " + response);
         System.out.println("response.value: " + response.getValue());
         System.out.println("response.type:  " + response.getTypeUrl());
         Object obj = response.toBuilder().build();
         System.out.println("obj: " + obj);
         Object message = response.unpack(${package}.${root-class}_proto.org_jboss_resteasy_example___CC7.class);
         System.out.println("message: " + message);      
         ${package}.${root-class}_proto.org_jboss_resteasy_example___CC3 cc3
            = ${package}.${root-class}_proto.org_jboss_resteasy_example___CC3.newBuilder().setS("cc7").build();
         ${package}.${root-class}_proto.org_jboss_resteasy_example___CC7 expected
            = ${package}.${root-class}_proto.org_jboss_resteasy_example___CC7.newBuilder().setCC3Super(cc3).setM(11).build();
         Assert.assertEquals(expected, message);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }

   //@Test
   public void testPathparam() throws Exception {
      System.out.println("running testInteger()");
      ${package}.${root-class}_proto.gInteger n = ${package}.${root-class}_proto.gInteger.newBuilder().setValue(5).build();
      ${package}.${root-class}_proto.gInteger response;
      try {
         response = blockingStub.getInteger(n);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.gInteger expected = ${package}.${root-class}_proto.gInteger.newBuilder().setValue(6).build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
   */
   
   @Test
   public void testInt() throws Exception {
      System.out.println("running testInt()");
      ${package}.${root-class}_proto.gInteger n = ${package}.${root-class}_proto.gInteger.newBuilder().setValue(3).build();
      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder builder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
      GeneralEntityMessage gem = builder.setURL("${URL}" + "/root/p/int").setGIntegerField(n).build();
      System.out.println("gem: " + gem);
      ${package}.${root-class}_proto.gInteger response;
      try {
         response = blockingStub.getInt(gem);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.gInteger expected = ${package}.${root-class}_proto.gInteger.newBuilder().setValue(4).build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
   
   @Test
   public void testProduces() throws Exception {
      System.out.println("running testProduces()");
      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder builder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
      GeneralEntityMessage gem = builder.setURL("${URL}" + "/root/p/produces").build();
      System.out.println("gem: " + gem);
      ${package}.${root-class}_proto.gString response;
      try {
         response = blockingStub.produces(gem);
         System.out.println("produces: " + response);
         ${package}.${root-class}_proto.gString expected = ${package}.${root-class}_proto.gString.newBuilder().setValue("produces").build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
   
   @Test
   public void testPathParams() throws Exception {
      System.out.println("running testPathParams()");
      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder builder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
      GeneralEntityMessage gem = builder.setURL("${URL}" + "/root/p/path/aa/param/bb").build();
      System.out.println("gem: " + gem);
      ${package}.${root-class}_proto.gString response;
      try {
         response = blockingStub.pathParams(gem);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.gString expected = ${package}.${root-class}_proto.gString.newBuilder().setValue("xaaybbz").build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }

   @Test
   public void testQueryParams() throws Exception {
      System.out.println("running testQueryParams()");
      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder builder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
      GeneralEntityMessage gem = builder.setURL("${URL}" + "/root/p/query?q1=a&q2=b").build();
      System.out.println("gem: " + gem);
      ${package}.${root-class}_proto.gString response;
      try {
         response = blockingStub.queryParams(gem);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.gString expected = ${package}.${root-class}_proto.gString.newBuilder().setValue("xaybz").build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }

   @Test
   public void testMatrixParams() throws Exception {
      System.out.println("running testMatrixParams()");
      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder builder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
      GeneralEntityMessage gem = builder.setURL("${URL}" + "/root/p/matrix;m1=a;m2=b/more;m3=c").build();
      System.out.println("gem: " + gem);
      ${package}.${root-class}_proto.gString response;
      try {
         response = blockingStub.matrixParams(gem);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.gString expected = ${package}.${root-class}_proto.gString.newBuilder().setValue("waxbycz").build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
/*
message Cookie {
    string name;
    string value;
    int32 version;
    string path;
    string domain;
}
*/
   @Test
   public void testCookieParams() throws Exception {
      System.out.println("running testCookieParams()");
      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder messageBuilder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
      messageBuilder.setURL("${URL}" + "/root/p/cookieParams");
      jaxrs.example.CC1_proto.Cookie.Builder cookieBuilder1 = jaxrs.example.CC1_proto.Cookie.newBuilder();
      jaxrs.example.CC1_proto.Cookie.Builder cookieBuilder2 = jaxrs.example.CC1_proto.Cookie.newBuilder();
      jaxrs.example.CC1_proto.Cookie cookie1 = cookieBuilder1.setName("c1").setValue("v1").setVersion(7).setPath("a/b").setDomain("d1").build();
      jaxrs.example.CC1_proto.Cookie cookie2 = cookieBuilder2.setName("c2").setValue("v2").build();
      messageBuilder.addCookies(cookie1).addCookies(cookie2);
      GeneralEntityMessage gem = messageBuilder.build();
      System.out.println("gem: " + gem);
      ${package}.${root-class}_proto.gString response;
      try {
         response = blockingStub.cookieParams(gem);
         System.out.println("response: " + response.getValue());
         Assert.assertEquals("xc1=v1;d1,a/b,7yc2=v2;,,0z", response.getValue());
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }

   @Test
   public void testHeaderParams() throws Exception {
      System.out.println("running testHeaderParams()");
      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder messageBuilder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
      messageBuilder.setURL("${URL}" + "/root/p/headerParams");
      jaxrs.example.CC1_proto.Header.Builder headerBuilder1 = jaxrs.example.CC1_proto.Header.newBuilder();
      jaxrs.example.CC1_proto.Header header1 = headerBuilder1.addValues("v1.1").addValues("v1.2").build();
      messageBuilder.putHeaders("h1", header1);
      jaxrs.example.CC1_proto.Header.Builder headerBuilder2 = jaxrs.example.CC1_proto.Header.newBuilder();
      jaxrs.example.CC1_proto.Header header2 = headerBuilder2.addValues("v2").build();
      messageBuilder.putHeaders("h2", header2);
      GeneralEntityMessage gem = messageBuilder.build();
      System.out.println("gem: " + gem);
      ${package}.${root-class}_proto.gString response;
      try {
         response = blockingStub.headerParams(gem);
         System.out.println("response: " + response.getValue());
         Assert.assertEquals("xv1.1yv2z", response.getValue());
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
   
   @Test
   public void testSuspend() throws Exception {
      System.out.println("running testSuspend()");
      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder messageBuilder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
      messageBuilder.setURL("${URL}" + "/root/p/suspend");
      GeneralEntityMessage gem = messageBuilder.build();
      System.out.println("gem: " + gem);
      try {
         com.google.protobuf.Any response = blockingStub.suspend(gem);
         jaxrs.example.CC1_proto.gString gS = response.unpack(jaxrs.example.CC1_proto.gString.class);
         String s = gS.getValue();
         System.out.println("response: " + response);
             System.out.println("unpacked response: " + gS);
             System.out.println("s: " + s);
         Assert.assertEquals("suspend", s);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
   
   @Test
   public void testCompletionStage() throws Exception {
      System.out.println("running testCompletionStage()");
      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder messageBuilder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
      messageBuilder.setURL("${URL}" + "/root/p/async/cs");
      GeneralEntityMessage gem = messageBuilder.build();
      System.out.println("gem: " + gem);
      try {
         ${package}.${root-class}_proto.gString response = blockingStub.getResponseCompletionStage(gem);
         System.out.println("response: " + response.getValue());
         Assert.assertEquals("cs", response.getValue());
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
   
   @Test
   public void testServletContext() throws Exception {
      System.out.println("running testServletContext()");
      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder messageBuilder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
      messageBuilder.setURL("${URL}" + "/root/p/context");
      GeneralEntityMessage gem = messageBuilder.build();
      System.out.println("gem: " + gem);
      ${package}.${root-class}_proto.gString response;
      try {
         response = blockingStub.context(gem);
         System.out.println("response: " + response.getValue());
         Assert.assertEquals("/jaxrs.example.grpc-0.0.1-SNAPSHOT", response.getValue());
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
   
//   @Test
//   public void testSSE() throws Exception {
//      System.out.println("running testSSE()");
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder messageBuilder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      messageBuilder.setURL("${URL}" + "/root/p/sse");
//      GeneralEntityMessage gem = messageBuilder.build();
//      System.out.println("gem: " + gem);
//      
//      java.util.Iterator<jaxrs.example.CC1_proto.org_jboss_resteasy_plugins_protobuf_sse___SseEvent> events;
//      try {
//         events = blockingStub.sse(gem);
//         System.out.println("events: " + events);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//      while (events.hasNext()) {
//         
//      }
//   }
}
