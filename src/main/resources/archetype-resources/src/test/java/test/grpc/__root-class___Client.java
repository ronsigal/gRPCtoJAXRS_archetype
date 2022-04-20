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
import jaxrs.example.CC1_proto.org_jboss_resteasy_example___CC2;
import jaxrs.example.CC1_proto.org_jboss_resteasy_example___CC3;
import jaxrs.example.CC1_proto.org_jboss_resteasy_example___CC4;
import jaxrs.example.CC1_proto.org_jboss_resteasy_example___CC5;

import com.google.protobuf.Any;

import ${package}.${root-class}ServiceGrpc;
import ${package}.${root-class}ServiceGrpc.CC1ServiceBlockingStub;

import javax.ws.rs.client.WebTarget;

public class CC1_Client
{
   //   private static String target = "localhost:9555";
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

   @Test
   public void testBoolean() throws Exception {
      System.out.println("running testBoolean()");
      ${package}.${root-class}_proto.MessageExtension messageExtension = jaxrs.example.CC1_proto.MessageExtension.newBuilder().setURL("${URL}/p/boolean").build();
      ${package}.${root-class}_proto.gBoolean n = ${package}.${root-class}_proto.gBoolean.newBuilder().setValue(false).build();
      ${package}.${root-class}_proto.gBoolean_Extension extension = ${package}.${root-class}_proto.gBoolean_Extension.newBuilder().setMessageExtension(messageExtension).setValue(n).build();
//      ${package}.${root-class}_proto.GeneralEntityMessage.Builder builder = ${package}.${root-class}_proto.GeneralEntityMessage.newBuilder();
//      GeneralEntityMessage gem = builder.setURL("${URL}" + "/p/boolean").setGBooleanField(n).build();
      System.out.println("extension: " + extension);
      ${package}.${root-class}_proto.gBoolean response;
      try {
         response = blockingStub.getBoolean(extension);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.gBoolean expected = ${package}.${root-class}_proto.gBoolean.newBuilder().setValue(true).build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }

   @Test
   public void testBooleanWrapper() throws Exception {
      System.out.println("running testBooleanWrapper()");
      ${package}.${root-class}_proto.MessageExtension messageExtension = jaxrs.example.CC1_proto.MessageExtension.newBuilder().setURL("${URL}/p/Boolean").build();
      ${package}.${root-class}_proto.gBoolean n = ${package}.${root-class}_proto.gBoolean.newBuilder().setValue(false).build();
      ${package}.${root-class}_proto.gBoolean_Extension extension = ${package}.${root-class}_proto.gBoolean_Extension.newBuilder().setMessageExtension(messageExtension).setValue(n).build();
      System.out.println("extension: " + extension);
      ${package}.${root-class}_proto.gBoolean response;
      try {
         response = blockingStub.getBooleanWrapper(extension);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.gBoolean expected = ${package}.${root-class}_proto.gBoolean.newBuilder().setValue(true).build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }

   @Test
   public void testByte() throws Exception {
      System.out.println("running testByte()");
      ${package}.${root-class}_proto.MessageExtension messageExtension = jaxrs.example.CC1_proto.MessageExtension.newBuilder().setURL("${URL}/p/byte").build();
      ${package}.${root-class}_proto.gByte n = ${package}.${root-class}_proto.gByte.newBuilder().setValue(3).build();
      ${package}.${root-class}_proto.gByte_Extension extension = ${package}.${root-class}_proto.gByte_Extension.newBuilder().setMessageExtension(messageExtension).setValue(n).build();
      System.out.println("extension: " + extension);
      ${package}.${root-class}_proto.gByte response;
      try {
         response = blockingStub.getByte(extension);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.gByte expected = ${package}.${root-class}_proto.gByte.newBuilder().setValue(4).build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }

   @Test
   public void testByteWrapper() throws Exception {
      System.out.println("running testByteWrapper()");
      ${package}.${root-class}_proto.MessageExtension messageExtension = jaxrs.example.CC1_proto.MessageExtension.newBuilder().setURL("${URL}/[Byte").build();
      ${package}.${root-class}_proto.gByte n = ${package}.${root-class}_proto.gByte.newBuilder().setValue(7).build();
      ${package}.${root-class}_proto.gByte_Extension extension = ${package}.${root-class}_proto.gByte_Extension.newBuilder().setMessageExtension(messageExtension).setValue(n).build();
      System.out.println("extension: " + extension);
      ${package}.${root-class}_proto.gByte response;
      try {
         response = blockingStub.getByteWrapper(extension);
         System.out.println("response: " + response.getValue());
         ${package}.${root-class}_proto.gByte expected = ${package}.${root-class}_proto.gByte.newBuilder().setValue(8).build();
         Assert.assertEquals(expected, response);
      } catch (StatusRuntimeException e) {
         e.printStackTrace();
         Assert.fail("fail");
         return;
      }
   }
//
//   @Test
//   public void testShort() throws Exception {
//      System.out.println("running testShort()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      ${package}.${root-class}_proto.gShort n = ${package}.${root-class}_proto.gShort.newBuilder().setValue(3).build();
//      ${package}.${root-class}_proto.GeneralEntityMessage.Builder builder = ${package}.${root-class}_proto.GeneralEntityMessage.newBuilder();
//      GeneralEntityMessage gem = builder.setURL("${URL}" + "/p/short").setGShortField(n).build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gShort response;
//      try {
//         response = blockingStub.getShort(gem);
//         System.out.println("response: " + response.getValue());
//         ${package}.${root-class}_proto.gShort expected = ${package}.${root-class}_proto.gShort.newBuilder().setValue(4).build();
//         Assert.assertEquals(expected, response);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testShortWrapper() throws Exception {
//      System.out.println("running testShortWrapper()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      ${package}.${root-class}_proto.gShort n = ${package}.${root-class}_proto.gShort.newBuilder().setValue(7).build();
//      ${package}.${root-class}_proto.GeneralEntityMessage.Builder builder = ${package}.${root-class}_proto.GeneralEntityMessage.newBuilder();
//      GeneralEntityMessage gem = builder.setURL("${URL}" + "/p/Short").setGShortField(n).build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gShort response;
//      try {
//         response = blockingStub.getShortWrapper(gem);
//         System.out.println("response: " + response.getValue());
//         ${package}.${root-class}_proto.gShort expected = ${package}.${root-class}_proto.gShort.newBuilder().setValue(8).build();
//         Assert.assertEquals(expected, response);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testInt() throws Exception {
//      System.out.println("running testInt()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      ${package}.${root-class}_proto.gInteger n = ${package}.${root-class}_proto.gInteger.newBuilder().setValue(3).build();
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder builder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      GeneralEntityMessage gem = builder.setURL("${URL}" + "/p/int").setGIntegerField(n).build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gInteger response;
//      try {
//         response = blockingStub.getInt(gem);
//         System.out.println("response: " + response.getValue());
//         ${package}.${root-class}_proto.gInteger expected = ${package}.${root-class}_proto.gInteger.newBuilder().setValue(4).build();
//         Assert.assertEquals(expected, response);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testInteger() throws Exception {
//      System.out.println("running testInteger()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      ${package}.${root-class}_proto.gInteger n = ${package}.${root-class}_proto.gInteger.newBuilder().setValue(3).build();
//      ${package}.${root-class}_proto.GeneralEntityMessage.Builder builder = ${package}.${root-class}_proto.GeneralEntityMessage.newBuilder();
//      GeneralEntityMessage gem = builder.setURL("${URL}" + "/p/Integer").setGIntegerField(n).build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gInteger response;
//      try {
//         response = blockingStub.getInteger(gem);
//         System.out.println("response: " + response.getValue());
//         ${package}.${root-class}_proto.gInteger expected = ${package}.${root-class}_proto.gInteger.newBuilder().setValue(4).build();
//         Assert.assertEquals(expected, response);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testLong() throws Exception {
//      System.out.println("running testLong()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      ${package}.${root-class}_proto.gLong n = ${package}.${root-class}_proto.gLong.newBuilder().setValue(3L).build();
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder builder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      GeneralEntityMessage gem = builder.setURL("${URL}" + "/p/long").setGLongField(n).build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gLong response;
//      try {
//         response = blockingStub.getLong(gem);
//         System.out.println("response: " + response.getValue());
//         ${package}.${root-class}_proto.gLong expected = ${package}.${root-class}_proto.gLong.newBuilder().setValue(4L).build();
//         Assert.assertEquals(expected, response);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testLongWrapper() throws Exception {
//      System.out.println("running testLongWrapper()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      ${package}.${root-class}_proto.gLong n = ${package}.${root-class}_proto.gLong.newBuilder().setValue(3L).build();
//      ${package}.${root-class}_proto.GeneralEntityMessage.Builder builder = ${package}.${root-class}_proto.GeneralEntityMessage.newBuilder();
//      GeneralEntityMessage gem = builder.setURL("${URL}" + "/p/Long").setGLongField(n).build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gLong response;
//      try {
//         response = blockingStub.getLongWrapper(gem);
//         System.out.println("response: " + response.getValue());
//         ${package}.${root-class}_proto.gLong expected = ${package}.${root-class}_proto.gLong.newBuilder().setValue(4L).build();
//         Assert.assertEquals(expected, response);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testFloat() throws Exception {
//      System.out.println("running testFloat()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      ${package}.${root-class}_proto.gFloat n = ${package}.${root-class}_proto.gFloat.newBuilder().setValue(3.0f).build();
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder builder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      GeneralEntityMessage gem = builder.setURL("${URL}" + "/p/float").setGFloatField(n).build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gFloat response;
//      try {
//         response = blockingStub.getFloat(gem);
//         System.out.println("response: " + response.getValue());
//         ${package}.${root-class}_proto.gFloat expected = ${package}.${root-class}_proto.gFloat.newBuilder().setValue(4.0f).build();
//         Assert.assertEquals(expected, response);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testFloatWrapper() throws Exception {
//      System.out.println("running testFloatWrapper()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      ${package}.${root-class}_proto.gFloat n = ${package}.${root-class}_proto.gFloat.newBuilder().setValue(3.0f).build();
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder builder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      GeneralEntityMessage gem = builder.setURL("${URL}" + "/p/Float").setGFloatField(n).build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gFloat response;
//      try {
//         response = blockingStub.getFloat(gem);
//         System.out.println("response: " + response.getValue());
//         ${package}.${root-class}_proto.gFloat expected = ${package}.${root-class}_proto.gFloat.newBuilder().setValue(4.0f).build();
//         Assert.assertEquals(expected, response);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testDouble() throws Exception {
//      System.out.println("running testDouble()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      ${package}.${root-class}_proto.gDouble n = ${package}.${root-class}_proto.gDouble.newBuilder().setValue(3.0d).build();
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder builder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      GeneralEntityMessage gem = builder.setURL("${URL}" + "/p/double").setGDoubleField(n).build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gDouble response;
//      try {
//         response = blockingStub.getDouble(gem);
//         System.out.println("response: " + response.getValue());
//         ${package}.${root-class}_proto.gDouble expected = ${package}.${root-class}_proto.gDouble.newBuilder().setValue(4.0d).build();
//         Assert.assertEquals(expected, response);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testDoubleWrapper() throws Exception {
//      System.out.println("running testDoubleWrapper()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      ${package}.${root-class}_proto.gDouble n = ${package}.${root-class}_proto.gDouble.newBuilder().setValue(3.0d).build();
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder builder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      GeneralEntityMessage gem = builder.setURL("${URL}" + "/p/Double").setGDoubleField(n).build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gDouble response;
//      try {
//         response = blockingStub.getDouble(gem);
//         System.out.println("response: " + response.getValue());
//         ${package}.${root-class}_proto.gDouble expected = ${package}.${root-class}_proto.gDouble.newBuilder().setValue(4.0d).build();
//         Assert.assertEquals(expected, response);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testChar() throws Exception {
//      System.out.println("running testChar()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      ${package}.${root-class}_proto.gCharacter n = ${package}.${root-class}_proto.gCharacter.newBuilder().setValue("a").build();
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder builder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      GeneralEntityMessage gem = builder.setURL("${URL}" + "/p/char").setGCharacterField(n).build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gCharacter response;
//      try {
//         response = blockingStub.getChar(gem);
//         System.out.println("response: " + response.getValue());
//         ${package}.${root-class}_proto.gCharacter expected = ${package}.${root-class}_proto.gCharacter.newBuilder().setValue("A").build();
//         Assert.assertEquals(expected, response);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testCharacter() throws Exception {
//      System.out.println("running testCharacter()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      ${package}.${root-class}_proto.gCharacter n = ${package}.${root-class}_proto.gCharacter.newBuilder().setValue("a").build();
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder builder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      GeneralEntityMessage gem = builder.setURL("${URL}" + "/p/Character").setGCharacterField(n).build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gCharacter response;
//      try {
//         response = blockingStub.getChar(gem);
//         System.out.println("response: " + response.getValue());
//         ${package}.${root-class}_proto.gCharacter expected = ${package}.${root-class}_proto.gCharacter.newBuilder().setValue("A").build();
//         Assert.assertEquals(expected, response);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testString() throws Exception {
//      System.out.println("running testString()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      ${package}.${root-class}_proto.gString n = ${package}.${root-class}_proto.gString.newBuilder().setValue("abc").build();
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder builder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      GeneralEntityMessage gem = builder.setURL("${URL}" + "/p/string").setGStringField(n).build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gString response;
//      try {
//         response = blockingStub.getString(gem);
//         System.out.println("response: " + response.getValue());
//         ${package}.${root-class}_proto.gString expected = ${package}.${root-class}_proto.gString.newBuilder().setValue("ABC").build();
//         Assert.assertEquals(expected, response);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testProduces() throws Exception {
//      System.out.println("running testProduces()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder builder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      GeneralEntityMessage gem = builder.setURL("${URL}" + "/p/produces").build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gString response;
//      try {
//         response = blockingStub.produces(gem);
//         System.out.println("produces: " + response);
//         ${package}.${root-class}_proto.gString expected = ${package}.${root-class}_proto.gString.newBuilder().setValue("produces").build();
//         Assert.assertEquals(expected, response);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testConsumes() throws Exception {
//      System.out.println("running testConsumes()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder builder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      GeneralEntityMessage gem = builder.setURL("${URL}" + "/p/consumes").build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gString response;
//      try {
//         response = blockingStub.produces(gem);
//         System.out.println("consumes: " + response);
//         ${package}.${root-class}_proto.gString expected = ${package}.${root-class}_proto.gString.newBuilder().setValue("consumes").build();
//         Assert.assertEquals(expected, response);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testPathParams() throws Exception {
//      System.out.println("running testPathParams()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder builder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      GeneralEntityMessage gem = builder.setURL("${URL}" + "/p/path/aa/param/bb").build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gString response;
//      try {
//         response = blockingStub.pathParams(gem);
//         System.out.println("response: " + response.getValue());
//         ${package}.${root-class}_proto.gString expected = ${package}.${root-class}_proto.gString.newBuilder().setValue("xaaybbz").build();
//         Assert.assertEquals(expected, response);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testQueryParams() throws Exception {
//      System.out.println("running testQueryParams()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder builder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      GeneralEntityMessage gem = builder.setURL("${URL}" + "/p/query?q1=a&q2=b").build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gString response;
//      try {
//         response = blockingStub.queryParams(gem);
//         System.out.println("response: " + response.getValue());
//         ${package}.${root-class}_proto.gString expected = ${package}.${root-class}_proto.gString.newBuilder().setValue("xaybz").build();
//         Assert.assertEquals(expected, response);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testMatrixParams() throws Exception {
//      System.out.println("running testMatrixParams()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder builder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      GeneralEntityMessage gem = builder.setURL("${URL}" + "/p/matrix;m1=a;m2=b/more;m3=c").build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gString response;
//      try {
//         response = blockingStub.matrixParams(gem);
//         System.out.println("response: " + response.getValue());
//         ${package}.${root-class}_proto.gString expected = ${package}.${root-class}_proto.gString.newBuilder().setValue("waxbycz").build();
//         Assert.assertEquals(expected, response);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testCookieParams() throws Exception {
//      System.out.println("running testCookieParams()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder messageBuilder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      messageBuilder.setURL("${URL}" + "/p/cookieParams");
//      jaxrs.example.CC1_proto.Cookie.Builder cookieBuilder1 = jaxrs.example.CC1_proto.Cookie.newBuilder();
//      jaxrs.example.CC1_proto.Cookie.Builder cookieBuilder2 = jaxrs.example.CC1_proto.Cookie.newBuilder();
//      jaxrs.example.CC1_proto.Cookie cookie1 = cookieBuilder1.setName("c1").setValue("v1").setVersion(7).setPath("a/b").setDomain("d1").build();
//      jaxrs.example.CC1_proto.Cookie cookie2 = cookieBuilder2.setName("c2").setValue("v2").build();
//      messageBuilder.addCookies(cookie1).addCookies(cookie2);
//      GeneralEntityMessage gem = messageBuilder.build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gString response;
//      try {
//         response = blockingStub.cookieParams(gem);
//         System.out.println("response: " + response.getValue());
//         Assert.assertEquals("xc1=v1;d1,a/b,7yc2=v2;,,0z", response.getValue());
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testHeaderParams() throws Exception {
//      System.out.println("running testHeaderParams()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder messageBuilder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      messageBuilder.setURL("${URL}" + "/p/headerParams");
//      jaxrs.example.CC1_proto.Header.Builder headerBuilder1 = jaxrs.example.CC1_proto.Header.newBuilder();
//      jaxrs.example.CC1_proto.Header header1 = headerBuilder1.addValues("v1.1").addValues("v1.2").build();
//      messageBuilder.putHeaders("h1", header1);
//      jaxrs.example.CC1_proto.Header.Builder headerBuilder2 = jaxrs.example.CC1_proto.Header.newBuilder();
//      jaxrs.example.CC1_proto.Header header2 = headerBuilder2.addValues("v2").build();
//      messageBuilder.putHeaders("h2", header2);
//      GeneralEntityMessage gem = messageBuilder.build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gString response;
//      try {
//         response = blockingStub.headerParams(gem);
//         System.out.println("response: " + response.getValue());
//         Assert.assertEquals("xv1.1yv2z", response.getValue());
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testSuspend() throws Exception {
//      System.out.println("running testSuspend()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder messageBuilder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      messageBuilder.setURL("${URL}" + "/p/suspend");
//      GeneralEntityMessage gem = messageBuilder.build();
//      System.out.println("gem: " + gem);
//      try {
//         com.google.protobuf.Any response = blockingStub.suspend(gem);
//         jaxrs.example.CC1_proto.gString gS = response.unpack(jaxrs.example.CC1_proto.gString.class);
//         String s = gS.getValue();
//         System.out.println("response: " + response);
//         System.out.println("unpacked response: " + gS);
//         System.out.println("s: " + s);
//         Assert.assertEquals("suspend", s);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testCompletionStage() throws Exception {
//      System.out.println("running testCompletionStage()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder messageBuilder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      messageBuilder.setURL("${URL}" + "/p/async/cs");
//      GeneralEntityMessage gem = messageBuilder.build();
//      System.out.println("gem: " + gem);
//      try {
//         ${package}.${root-class}_proto.gString response = blockingStub.getResponseCompletionStage(gem);
//         System.out.println("response: " + response.getValue());
//         Assert.assertEquals("cs", response.getValue());
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testServletContext() throws Exception {
//      System.out.println("running testServletContext()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder messageBuilder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//      messageBuilder.setURL("${URL}" + "/p/context");
//      GeneralEntityMessage gem = messageBuilder.build();
//      System.out.println("gem: " + gem);
//      ${package}.${root-class}_proto.gString response;
//      try {
//         response = blockingStub.context(gem);
//         System.out.println("response: " + response.getValue());
//         Assert.assertEquals("/jaxrs.example.grpc-0.0.1-SNAPSHOT", response.getValue());
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   //   @Test
//   //   public void testSSE() throws Exception {
//   //      System.out.println("running testSSE()");
//   //      jaxrs.example.CC1_proto.GeneralEntityMessage.Builder messageBuilder = jaxrs.example.CC1_proto.GeneralEntityMessage.newBuilder();
//   //      messageBuilder.setURL("${URL}" + "/p/sse");
//   //      GeneralEntityMessage gem = messageBuilder.build();
//   //      System.out.println("gem: " + gem);
//   //      
//   //      java.util.Iterator<jaxrs.example.CC1_proto.org_jboss_resteasy_plugins_protobuf_sse___SseEvent> events;
//   //      try {
//   //         events = blockingStub.sse(gem);
//   //         System.out.println("events: " + events);
//   //      } catch (StatusRuntimeException e) {
//   //         e.printStackTrace();
//   //         Assert.fail("fail");
//   //         return;
//   //      }
//   //      while (events.hasNext()) {
//   //         
//   //      }
//   //   }
//
//   @Test
//   public void testReferenceField() throws Exception {
//      System.out.println("running testReferenceField()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      org_jboss_resteasy_example___CC5 cc5 = org_jboss_resteasy_example___CC5.newBuilder().setK(11).build();
//      org_jboss_resteasy_example___CC4 cc4 = org_jboss_resteasy_example___CC4.newBuilder().setS("grog").setCc5(cc5).build();
////    org_jboss_resteasy_example___CC4 cc4 = org_jboss_resteasy_example___CC4.newBuilder().setS(11).setCc5(cc5).build();
//      
//      GeneralEntityMessage.Builder messageBuilder = GeneralEntityMessage.newBuilder();
//      messageBuilder.setURL("http://localhost:8080/p/reference").setOrgJbossResteasyExampleCC4Field(cc4);
//      GeneralEntityMessage gem = messageBuilder.build();
//      System.out.println("gem: " + gem);
//      org_jboss_resteasy_example___CC4 response;
//      try {
//         response = blockingStub.referenceField(gem);
//         System.out.println("response: " + response.toString());
//         cc5 = org_jboss_resteasy_example___CC5.newBuilder().setK(12).build();
//         cc4 = org_jboss_resteasy_example___CC4.newBuilder().setS("xgrogy").setCc5(cc5).build();
////         cc4 = org_jboss_resteasy_example___CC4.newBuilder().setS(12).setCc5(cc5).build();
//
//         Assert.assertTrue(cc4.equals(response));
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
//
//   @Test
//   public void testInheritance() throws Exception {
//      System.out.println("running testInheritance()");
//      ${package}.${root-class}_proto.MessageExtension extension = MessageExtension.Builder.newBuilder().setURL("${URL}").build();
//      org_jboss_resteasy_example___CC3 cc3 = org_jboss_resteasy_example___CC3.newBuilder().setS("thag").build();
//      org_jboss_resteasy_example___CC2 cc2 = org_jboss_resteasy_example___CC2.newBuilder().setJ(17).setCC3Super(cc3).build();
//      GeneralEntityMessage.Builder messageBuilder = GeneralEntityMessage.newBuilder();
//      messageBuilder.setURL("http://localhost:8080/p/inheritance").setOrgJbossResteasyExampleCC2Field(cc2);
//      GeneralEntityMessage gem = messageBuilder.build();
//      System.out.println("gem: " + gem);
//      org_jboss_resteasy_example___CC2 response;
//      try {
//         response = blockingStub.inheritance(gem);
//         System.out.println("response: " + response);
//         cc3 = org_jboss_resteasy_example___CC3.newBuilder().setS("xthagy").build();
//         cc2 = org_jboss_resteasy_example___CC2.newBuilder().setJ(18).setCC3Super(cc3).build();
//         cc2.equals(response);
//      } catch (StatusRuntimeException e) {
//         e.printStackTrace();
//         Assert.fail("fail");
//         return;
//      }
//   }
}
