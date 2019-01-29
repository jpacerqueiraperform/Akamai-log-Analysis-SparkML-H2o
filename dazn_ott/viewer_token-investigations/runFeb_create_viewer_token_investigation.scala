spark.sql("USE published_ott_dazn"); spark.sql("SHOW tables"); spark.sql("insert into table published_ott_dazn.viewer_token_investigation  SELECT split(message,' ')[0] as date , split( split(message,' ')[1] ,',')[0]  as time,  split(  split(message,':')[4], ' ')[0] as mislviewerid, split(  split(message,':')[5], ' ')[0] as misldeviceid, split(  split(message,':')[6], ' ')[0] as misluserstatus, split(split( message,':')[2] , ',')[1]  as correlationtoken  from published_ott_dazn.massive_elb_logs where dt between '20170201' and '20170228' and message like '%Misl_Viewer_Id:%Misl_Device_Id:%' ").collect(); sys.exit;
