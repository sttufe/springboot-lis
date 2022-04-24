package com.lis.api.Test.CompletableFuture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModicationException {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(3);
            }
        };
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            list.add(4);
        }
    }

}
