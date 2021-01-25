package com.test;

import java.util.HashMap;
import java.util.Map;

public class DataMove {
    public static void main(String[] args) {
        String smp_full_licensesales_type = "0,1,2";
        String[] rangeList = smp_full_licensesales_type.split(",");
        Map map = new HashMap();
        map.put("1", "30011002");
        map.put("2", "30011001");
        String value = "";
        //直销类型默认为否 ,当
        String directType ="10021002";
        for (int i = 0; i <rangeList.length ; i++) {
            if (map.containsKey(rangeList[i])){
                value = value + map.get(rangeList[i])+",";
            }
            if(rangeList[i] == "0"){
                directType  ="10021001";
            }
        }

        String  licensesalesType= "";
        if(value.length()>1){
            licensesalesType = value.substring(0,value.length()-1);
        }
        System.out.println(licensesalesType);

        /**
         * 服务范围
         */
        String smp_scopeof_bus_iness = "0,1,2";
        String[] businessList = smp_scopeof_bus_iness.split(",");
        Map businessMap = new HashMap();
        businessMap.put("0", "20141001");
        businessMap.put("1", "20141002");
        businessMap.put("2", "20141003");
        String business = "";
        for (int i = 0; i <businessList.length ; i++) {
            if (businessMap.containsKey(businessList[i])){
                business = business + businessMap.get(businessList[i])+",";
            }
        }

        String smpscopeofBusiness ="";
        if(business.length()>1){
            smpscopeofBusiness = business.substring(0,business.length()-1);
        }
        System.out.println(smpscopeofBusiness);

    }
}
