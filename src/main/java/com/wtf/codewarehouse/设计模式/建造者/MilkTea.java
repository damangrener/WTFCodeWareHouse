package com.wtf.codewarehouse.设计模式.建造者;


import lombok.Builder;
import lombok.Data;

/**
 * @author wangtengfei
 * @since 2020/10/15 15:22
 */
@Builder
@Data
public class MilkTea {

    private String type;
    private String size;
    private boolean pearl;
    private boolean ice;


//    private MilkTea(Builder builder) {
//        this.type = builder.type;
//        this.size = builder.size;
//        this.pearl = builder.pearl;
//        this.ice = builder.ice;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public String getSize() {
//        return size;
//    }
//
//    public boolean isPearl() {
//        return pearl;
//    }
//
//    public boolean isIce() {
//        return ice;
//    }

//    public static class Builder {
//        private String type;
//        private String size = "中杯";
//        private boolean pearl = true;
//        private boolean ice = false;
//
//        public String getType() {
//            return type;
//        }
//
//        public String getSize() {
//            return size;
//        }
//
//        public boolean isPearl() {
//            return pearl;
//        }
//
//        public boolean isIce() {
//            return ice;
//        }
//
//        public void setType(String type) {
//            this.type = type;
//        }
//
//        public void setSize(String size) {
//            this.size = size;
//        }
//
//        public void setPearl(boolean pearl) {
//            this.pearl = pearl;
//        }
//
//        public void setIce(boolean ice) {
//            this.ice = ice;
//        }
//
//        public MilkTea build() {
//            return new MilkTea(this);
//        }
//    }

}
