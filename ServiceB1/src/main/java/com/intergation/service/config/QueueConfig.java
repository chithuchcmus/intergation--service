package com.intergation.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class QueueConfig {
    @Value( "${kafka.topic.b1}" )
    private String b1DoubleNumberQueue;

    @Value( "${kafka.topic.b2}" )
    private String b2TripleNumberQueue;


    @Value( "${kafka.topic.number-partition-b1}" )
    private int numPartitionB1;


    @Value( "${kafka.topic.number-partition-b2}" )
    private int numPartitionB2;

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
}
