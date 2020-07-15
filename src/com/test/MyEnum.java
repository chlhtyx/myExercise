package com.test;

public class MyEnum {

    /**
     * 订单类型
     */
    public static enum orderStatus {


        //订单类型
        AGREE("1", "同意");

        private String value;

        private String code;

        orderStatus(String code, String value) {
            this.value = value;
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
