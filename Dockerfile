FROM openjdk:17
COPY ./out/production/grpc-test/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","GrpcTest1Application"]
