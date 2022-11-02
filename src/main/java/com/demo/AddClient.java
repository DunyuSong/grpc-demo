package com.demo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AddClient {

    AddServiceGrpc.AddServiceBlockingStub stub;
    ManagedChannel managedChannel;

    public static void main(String[] args) {
        int a = 101;
        int b = 102;
        AddClient client = new AddClient();

        AddReply reply = client.stub.add(AddRequest.newBuilder().setA(a).setB(b).build());
        System.out.println(reply.getRes());

    }

    public AddClient(){
        managedChannel = ManagedChannelBuilder
                .forAddress("localhost",9991)
                .usePlaintext()
                .build();
        stub = AddServiceGrpc.newBlockingStub(managedChannel);
    }
}
