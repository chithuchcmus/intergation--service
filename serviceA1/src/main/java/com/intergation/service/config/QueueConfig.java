package com.intergation.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class QueueConfig {
    @Value( "${kafka.topic.b1}" )
    private String b1DoubleNumberQueue;

    @Value( "${kafka.topic.b2}" )
    private String b2TripleNumberQueue;

    @Value( "${kafka.topic.a1}" )
    private String a1SumTwoNumberQueue;


    @Value( "${kafka.topic.number-partition-b1}" )
    private int numPartitionB1;


    @Value( "${kafka.topic.number-partition-b2}" )
    private int numPartitionB2;

    @Value( "${kafka.topic.number-partition-a1}" )
    private int numPartitionA1;

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapAddress;

    @Value("${kafka.a1.groupId}")
    private String groupId;


    public QueueConfig(){

    }

    public int getNumPartitionB1() {
        return numPartitionB1;
    }

    public int getNumPartitionB2() {
        return numPartitionB2;
    }

    public String getB1DoubleNumberQueue() {
        return b1DoubleNumberQueue;
    }

    public String getB2TripleNumberQueue() {
        return b2TripleNumberQueue;
    }

    public int getNumPartitionA1() {
        return numPartitionA1;
    }

    public String getA1SumTwoNumberQueue() {
        return a1SumTwoNumberQueue;
    }

    public String getBootstrapAddress() {
        return bootstrapAddress;
    }

    public String getGroupId() {
        return groupId;
    }
}
