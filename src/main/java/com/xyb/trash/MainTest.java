/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash;

/**
 * Created by xieyunbo on 2018/5/7.
 */
public class MainTest {

    public static void main(String[] args) {

        String jsonstr="{\"data\": {\"176\": [{"+
                "\"userId\": 176,"+
                " \"startTime\": \"2018-05-29 18:02:41.0\","+
                " \"endTime\": \"2018-05-29 18:27:41.0\","+
                " \"dataException\": 43.0,"+
                " \"dataRecovery\": 73.0,"+
                "\"alarmName\": \"hr\","+
                "\"alarmType\": 1,"+
                "\"reason\": 0"+
            "}, {"+
        "\"userId\": 176,"+
                " \"startTime\": \"2018-05-29 18:02:41.0\","+
                " \"endTime\": \"2018-05-29 18:27:41.0\","+
                " \"dataException\": 43.0,"+
                " \"dataRecovery\": 73.0,"+
                "\"alarmName\": \"hr\","+
                "\"alarmType\": 1,"+
                "\"reason\": 0"+
            "}],"+
            "\"689\": [{"+
        "\"userId\": 689,"+
                " \"startTime\": \"2018-05-29 18:02:41.0\","+
                " \"endTime\": \"2018-05-29 18:27:41.0\","+
                " \"dataException\": 43.0,"+
                " \"dataRecovery\": 73.0,"+
                "\"alarmName\": \"hr\","+
                "\"alarmType\": 1,"+
                "\"reason\": 0"+
        "}, {"+
        "\"userId\": 689,"+
        " \"startTime\": \"2018-05-29 18:02:41.0\","+
                " \"endTime\": \"2018-05-29 18:27:41.0\","+
                " \"dataException\": 43.0,"+
                " \"dataRecovery\": 73.0,"+
                "\"alarmName\": \"hr\","+
                "\"alarmType\": 1,"+
        "\"reason\": 0"+
        "}],"+
                "\"514\": [{"+
                "\"userId\": 514,"+
                " \"startTime\": \"2018-05-30 07:09:26.0\","+
                " \"endTime\": \"2018-05-30 07:13:26.0\","+
                " \"dataException\": 43.0,"+
                " \"dataRecovery\": 72.0,"+
                " \"alarmName\": \"hr\","+
                "\"alarmType\": 1,"+
        " \"reason\": 0"+
        "}]"+
            "},"+
        "\"result\": 0,"+
        "\"desc\": null,"+
        "\"extras\": null"+
        "}";
        System.out.println(jsonstr);


//        String root = Cryptos.aesEncrypt("root");
//        System.out.println(root);
//        String decrypt = Cryptos.aesDecrypt("3aa26cad34a49e71cf763a37b0e8862e");
//        System.out.println(decrypt);
    }
}
