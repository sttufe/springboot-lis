/*
//任务队列
        List<CompletableFuture<List<ReportOut>>> Specimenfutures = new ArrayList<>();
        //CompletableFuture 提交任务 多线程并行处理
        for (Integer i: specimenRecList) {
        Specimenfutures.add(CompletableFuture.supplyAsync(()-> GetReportOut(i,itemsList),pool).whenComplete(
        (r,result)->{
        for (ReportOut ro:r) {

        if(SelfUtil.IsNull(ro.getValue()).substring(0,1).equals("<") ||SelfUtil.IsNull(ro.getValue()).contains("阴")
        ){r.remove(ro);}

        if(!SelfUtil.IsNull(ro.getValue()).contains("阳")&&!(Float.parseFloat(SelfUtil.IsNull(ro.getValue()).substring(0,3))>1.00))
        {r.remove(ro);}

        }

        }
        )
        );
        };*/

//thenApply 异步  ReportOut

 /*  .thenApply((r)->{
                        if (!r.isEmpty()){
                            for (ReportOut ro:r) {
                                if(SelfUtil.IsNull(ro.getValue()).substring(0,1).equals("<") ||SelfUtil.IsNull(ro.getValue()).contains("阴")
                                ){r.remove(ro);continue;}
                                if(!SelfUtil.IsNull(ro.getValue()).contains("阳")&&!(Float.parseFloat(SelfUtil.IsNull(ro.getValue()).substring(0,3))>1.00))
                                {r.remove(ro);continue;}
                            }
                        }

                     return r;
                    })*/
