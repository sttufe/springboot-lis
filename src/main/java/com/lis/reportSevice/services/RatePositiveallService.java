package com.lis.reportSevice.services;

import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.concurrent.ExecutionException;


@Service
public interface RatePositiveallService {
    JSONArray AsynRatePositiveAll(Timestamp BeginTimestamp , Timestamp EndTimestamp)
            throws ExecutionException, InterruptedException, IOException;

    JSONArray EncounterAsynReport(Timestamp BeginTimestamp , Timestamp EndTimestamp)
            throws ExecutionException, InterruptedException, IOException;

}