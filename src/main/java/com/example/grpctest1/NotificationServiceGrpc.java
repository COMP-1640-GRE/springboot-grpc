package com.example.grpctest1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: notificationService.proto")
public final class NotificationServiceGrpc {

  private NotificationServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpctest1.NotificationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpctest1.NotificationRequest,
      com.example.grpctest1.NotificationResponse> getSendNotificationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendNotification",
      requestType = com.example.grpctest1.NotificationRequest.class,
      responseType = com.example.grpctest1.NotificationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpctest1.NotificationRequest,
      com.example.grpctest1.NotificationResponse> getSendNotificationMethod() {
    io.grpc.MethodDescriptor<com.example.grpctest1.NotificationRequest, com.example.grpctest1.NotificationResponse> getSendNotificationMethod;
    if ((getSendNotificationMethod = NotificationServiceGrpc.getSendNotificationMethod) == null) {
      synchronized (NotificationServiceGrpc.class) {
        if ((getSendNotificationMethod = NotificationServiceGrpc.getSendNotificationMethod) == null) {
          NotificationServiceGrpc.getSendNotificationMethod = getSendNotificationMethod = 
              io.grpc.MethodDescriptor.<com.example.grpctest1.NotificationRequest, com.example.grpctest1.NotificationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.example.grpctest1.NotificationService", "sendNotification"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpctest1.NotificationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpctest1.NotificationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new NotificationServiceMethodDescriptorSupplier("sendNotification"))
                  .build();
          }
        }
     }
     return getSendNotificationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpctest1.ListNotificationRequest,
      com.example.grpctest1.NotificationResponse> getGetListNotificationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getListNotifications",
      requestType = com.example.grpctest1.ListNotificationRequest.class,
      responseType = com.example.grpctest1.NotificationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpctest1.ListNotificationRequest,
      com.example.grpctest1.NotificationResponse> getGetListNotificationsMethod() {
    io.grpc.MethodDescriptor<com.example.grpctest1.ListNotificationRequest, com.example.grpctest1.NotificationResponse> getGetListNotificationsMethod;
    if ((getGetListNotificationsMethod = NotificationServiceGrpc.getGetListNotificationsMethod) == null) {
      synchronized (NotificationServiceGrpc.class) {
        if ((getGetListNotificationsMethod = NotificationServiceGrpc.getGetListNotificationsMethod) == null) {
          NotificationServiceGrpc.getGetListNotificationsMethod = getGetListNotificationsMethod = 
              io.grpc.MethodDescriptor.<com.example.grpctest1.ListNotificationRequest, com.example.grpctest1.NotificationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.example.grpctest1.NotificationService", "getListNotifications"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpctest1.ListNotificationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpctest1.NotificationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new NotificationServiceMethodDescriptorSupplier("getListNotifications"))
                  .build();
          }
        }
     }
     return getGetListNotificationsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NotificationServiceStub newStub(io.grpc.Channel channel) {
    return new NotificationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NotificationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new NotificationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NotificationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new NotificationServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class NotificationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendNotification(com.example.grpctest1.NotificationRequest request,
        io.grpc.stub.StreamObserver<com.example.grpctest1.NotificationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendNotificationMethod(), responseObserver);
    }

    /**
     */
    public void getListNotifications(com.example.grpctest1.ListNotificationRequest request,
        io.grpc.stub.StreamObserver<com.example.grpctest1.NotificationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetListNotificationsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendNotificationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpctest1.NotificationRequest,
                com.example.grpctest1.NotificationResponse>(
                  this, METHODID_SEND_NOTIFICATION)))
          .addMethod(
            getGetListNotificationsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.example.grpctest1.ListNotificationRequest,
                com.example.grpctest1.NotificationResponse>(
                  this, METHODID_GET_LIST_NOTIFICATIONS)))
          .build();
    }
  }

  /**
   */
  public static final class NotificationServiceStub extends io.grpc.stub.AbstractStub<NotificationServiceStub> {
    private NotificationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NotificationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotificationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NotificationServiceStub(channel, callOptions);
    }

    /**
     */
    public void sendNotification(com.example.grpctest1.NotificationRequest request,
        io.grpc.stub.StreamObserver<com.example.grpctest1.NotificationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendNotificationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getListNotifications(com.example.grpctest1.ListNotificationRequest request,
        io.grpc.stub.StreamObserver<com.example.grpctest1.NotificationResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetListNotificationsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class NotificationServiceBlockingStub extends io.grpc.stub.AbstractStub<NotificationServiceBlockingStub> {
    private NotificationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NotificationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotificationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NotificationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpctest1.NotificationResponse sendNotification(com.example.grpctest1.NotificationRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendNotificationMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.example.grpctest1.NotificationResponse> getListNotifications(
        com.example.grpctest1.ListNotificationRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetListNotificationsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class NotificationServiceFutureStub extends io.grpc.stub.AbstractStub<NotificationServiceFutureStub> {
    private NotificationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NotificationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotificationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NotificationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpctest1.NotificationResponse> sendNotification(
        com.example.grpctest1.NotificationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendNotificationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_NOTIFICATION = 0;
  private static final int METHODID_GET_LIST_NOTIFICATIONS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NotificationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NotificationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_NOTIFICATION:
          serviceImpl.sendNotification((com.example.grpctest1.NotificationRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpctest1.NotificationResponse>) responseObserver);
          break;
        case METHODID_GET_LIST_NOTIFICATIONS:
          serviceImpl.getListNotifications((com.example.grpctest1.ListNotificationRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpctest1.NotificationResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class NotificationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NotificationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpctest1.NotificationServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NotificationService");
    }
  }

  private static final class NotificationServiceFileDescriptorSupplier
      extends NotificationServiceBaseDescriptorSupplier {
    NotificationServiceFileDescriptorSupplier() {}
  }

  private static final class NotificationServiceMethodDescriptorSupplier
      extends NotificationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NotificationServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (NotificationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NotificationServiceFileDescriptorSupplier())
              .addMethod(getSendNotificationMethod())
              .addMethod(getGetListNotificationsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
