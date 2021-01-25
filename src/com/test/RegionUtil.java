package com.test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author CHL
 */
public class RegionUtil {


    public static void main(String[] args) {
//        XX省XX市XX区；XX省XX市XX市；XX省XX市XX县；XX市XX区；XX市XX县
//        1.浙江省杭州市滨江区
//        2.上海上海市金山区
//        3.浙江省台州市玉环县
//        4.湖北省潜江市潜江经济开发区
        String[] placeList = new String[]{
                "浙江省杭州市",
                "上海市辖区金山区",
                "浙江省台州市玉环县",
                "湖北省潜江市潜江经济开发区",
                "湖北省潜江市江汉石油管理局",
                "湖北省天门市马湾镇",
                "湖北省武汉市汉阳区二桥街",
                "上海市辖区浦东新区",
                "武汉市硚口区",
                "香港特别行政区湾仔区博览道1号",
                "内蒙古自治区兴安盟科尔沁右翼前旗",
                "湖北省恩施土家族苗族自治州神农架林区",
                "湖南省邵阳市城步苗族自治县",
                "新疆维吾尔自治区阿克苏地区新和县",
                "上海市上海市辖区",
                "上海市辖区",
                "上海市城区",
                "北京市"
        };
        for (String place : placeList) {
            System.out.println(addressResolution(place));
        }
    }

    /**
     * 解析地址
     * 拆分为 省 市 区
     *
     * @param address
     * @return
     */
    public static List<Map<String, String>> addressResolution(String address) {
//        String regex="((?<province>[^省]+省|.+自治区)|上海|北京|天津|重庆)((?<city>[^市]+市|.+自治州))(?<county>[^县]+县|.+区|.+镇|.+局)";
        String regex = "(?<province>[^省]+自治区|.*?省|上海市|北京市|天津市|重庆市)?(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|.*市辖区|.*市城区|.*?市|.*?县|.*?行政区)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛|.+局|.+镇)?";
//        String regex="(?<province>[^省]+省|.+自治区)?(?<city>[^市]+市|.+自治州)?(?<county>[^县]+县|.+区|.+镇|.+局)";
        Matcher m = Pattern.compile(regex).matcher(address);
        String province = null, city = null, county = null, town = null, village = null;
        List<Map<String, String>> table = new ArrayList<Map<String, String>>();
        Map<String, String> row = null;
        while (m.find()) {
            row = new LinkedHashMap<String, String>();
            province = m.group("province");
            row.put("province", province == null ? "" : province.trim());
            city = m.group("city");
            row.put("city", city == null ? "" : city.trim());
            county = m.group("county");
            row.put("county", county == null ? "" : county.trim());
            table.add(row);
        }
        return table;
    }
}
