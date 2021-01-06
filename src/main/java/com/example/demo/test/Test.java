package com.example.demo.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static final String str = "<row><title>西安市城镇职工结算单</title><bz>正式结算打印</bz><yka054>01</yka054><yka054_mc>1</yka054_mc><dexx></dexx><yae366>201109</yae366><ykc021>12</ykc021><yka316>统筹基金支付</yka316><ykb037>西安市本级</ykb037><yab139>西安市本级</yab139><akc021>在职</akc021><ykc120>普通</ykc120><yka433>.09</yka433><yaa310>正常单位缴费比例</yaa310><ykc150>不驻外</ykc150><aac003>郝清</aac003><aac004>女</aac004><aac002>610121196204071563</aac002><aac006>1962-04-07</aac006><akc023>47</akc023><aab001>002263</aab001><aab004>陕西省人才交流服务中心（代理户）</aab004><akb021>西安市中心医院</akb021><akb020>0006</akb020><yydj>三甲特等</yydj><aac002>610121196204071563</aac002><ykc010></ykc010><yka065>           0.00</yka065><grzfje>         953.49</grzfje><aae036>2011-09-16 10:55:23</aae036><ykc141>胡志伟</ykc141><ykb065>1</ykb065><akb023>特级</akb023><ykc239>YKC239</ykc239><ykd086>YKD086</ykd086><ykb109>不享受公务员统筹待遇</ykb109><ykd105>不是门诊特病病种人员</ykd105><akc192>2010-01-28</akc192><akc194>2010-02-09</akc194><yka114>           0.00</yka114><yka412>           0.00</yka412><yka115>         550.00</yka115><yka058>         550.00</yka058><ykc022>          5</ykc022><yka308>           1.00</yka308><yka120>       15268.58</yka120><yka249>           0.00</yka249><yka119>           0.00</yka119><yka248>        3739.68</yka248><yka059>         857.49</yka059><yka122>           0.00</yka122><yka204>           0.00</yka204><yka121>           0.00</yka121><yka365>           0.00</yka365><yka062>           0.00</yka062><yka061>           0.00</yka061><yka437>           0.00</yka437><yke030>           0.00</yke030><yke031></yke031><yka373></yka373><yka372></yka372><yka055>        6191.30</yka055><dxyka055>陆仟壹佰玖拾壹元叁角零分</dxyka055><yka056>          96.00</yka056><dxyka056>玖拾陆元零角零分</dxyka056><yka056_lx>        2451.62</yka056_lx><dxyka056_lx>贰仟肆佰伍拾壹元陆角贰分</dxyka056_lx><yka057>         948.13</yka057><yka111>        4897.17</yka111><yka410>         250.00</yka410><yka420></yka420><yka430></yka430><akb063>0</akb063><fdzfqk></fdzfqk><ykc202></ykc202><yke398>0</yke398><ykc280></ykc280><ykc281></ykc281><yka445>           0.00</yka445><yka384>           0.00</yka384><yka436>        3739.68</yka436><ykc367>0</ykc367><ykc365>0</ykc365><ykd135>0</ykd135><aac001>000****295</aac001><akc190>110524100059219631</akc190><yka103>1105246189457</yka103><cxeje>550</cxeje><free>         857.49</free><aka130>普通住院</aka130><yka248_1></yka248_1><dxyka248></dxyka248><sum>        3739.68</sum><dxsum></dxsum><yka065>0</yka065><akc196>J40 03</akc196><ykc015></ykc015><JBYKA059>75</JBYKA059><JBYKA248>175</JBYKA248><JBWWKYKA059_yka430>0</JBWWKYKA059_yka430><JBWWKYKA248_yka430>0</JBWWKYKA248_yka430><JBWWKYKA430>0</JBWWKYKA430><jbwwkyka059_yka440>0</jbwwkyka059_yka440><jbwwkyka248_yka440>0</jbwwkyka248_yka440><jbwwkyka440>0</jbwwkyka440><jbwwkyka059_yka450>0</jbwwkyka059_yka450><jbwwkyka248_yka450>0</jbwwkyka248_yka450><jbwwkyka450>0</jbwwkyka450><YKA058>550</YKA058><JB1BXBL>%</JB1BXBL><JB1ZFBL>%</JB1ZFBL><JB1ZFJE>0</JB1ZFJE><JB1BXJE>0</JB1BXJE><JB2BXBL>%</JB2BXBL><JB2ZFBL>%</JB2ZFBL><JB2ZFJE>0</JB2ZFJE><JB2BXJE>0</JB2BXJE><TJTZXJ>0</TJTZXJ><TJTZZHIF>0</TJTZZHIF><TJTZTC>0</TJTZTC><TJTZTSXJ>0</TJTZTSXJ><TJTZTSZHIF>0</TJTZTSZHIF><TJTZTSTC>0</TJTZTSTC><DEZFXJ>0</DEZFXJ><DEZFJE>0</DEZFJE><DETCJE>0</DETCJE><DETCBL></DETCBL><DEZHIFBL></DEZHIFBL><CDEZF>0</CDEZF><gwybz>0</gwybz><gwybxbl>%</gwybxbl><gwyzfbl>%</gwyzfbl><desbbz>0</desbbz></row>";

    public static void main(String[] args) {
        System.out.println(str.length());
        long start = System.currentTimeMillis();
        System.out.println(start);
        String substring = str.substring(str.indexOf("row>") + 4, str.lastIndexOf("</row"));
        String[] split = substring.split("</");
        String key = null;
        String key1 = null;
        String value = null;
        Map map = new HashMap<>();
        System.out.println(Arrays.asList(split));
        for (String ss : split) {
            if (ss.startsWith("<")) {
                key = ss.substring(ss.indexOf("<") + 1, ss.indexOf(">"));
                value = ss.substring(ss.indexOf(">") + 1);
            } else if(ss.endsWith(">")){
                key = ss.substring(0, ss.indexOf(">"));
                key1 = ss.substring(ss.indexOf("<")+1, ss.lastIndexOf(">"));
                map.put(key1,"");
                value = "";
            }else{
                key = ss.substring(ss.indexOf("<")+1, ss.lastIndexOf(">"));
                value = ss.substring(ss.lastIndexOf(">")+1);
            }
            map.put(key, value);
        }
        System.out.println(map.toString());
        long end = System.currentTimeMillis();
        System.out.println(end -start);
        System.out.println(end);

    }
}
