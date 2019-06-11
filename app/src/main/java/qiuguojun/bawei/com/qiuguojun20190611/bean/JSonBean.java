package qiuguojun.bawei.com.qiuguojun20190611.bean;

import java.util.List;

public class JSonBean {
    private List<datas> data;

    public List<datas> getData() {
        return data;
    }

    public void setData(List<datas> data) {
        this.data = data;
    }

    public class datas{
        private String name;
        private String text;
        private String cdn_img;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getCdn_img() {
            return cdn_img;
        }

        public void setCdn_img(String cdn_img) {
            this.cdn_img = cdn_img;
        }
    }
}
