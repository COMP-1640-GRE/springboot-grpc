// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: notificationService.proto

package com.example.grpctest1;

public interface ListNotificationRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.example.grpctest1.ListNotificationRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 page = 1;</code>
   */
  int getPage();

  /**
   * <code>int32 pageSize = 2;</code>
   */
  int getPageSize();

  /**
   * <code>int64 studentUserid = 3;</code>
   */
  long getStudentUserid();

  /**
   * <code>bool seen = 4;</code>
   */
  boolean getSeen();
}
