package afor.myapp.com.rxretrofitdaggerapp.data;

/**
 * Created by Mahdi Dammak on 27/02/2018.
 */

public class Pays {
    String name;
    String alpha2_code;
    String alpha3_code;

    public Pays() {
    }

    public Pays(String name, String alpha2_code, String alpha3_code) {
        this.name = name;
        this.alpha2_code = alpha2_code;
        this.alpha3_code = alpha3_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha2_code() {
        return alpha2_code;
    }

    public void setAlpha2_code(String alpha2_code) {
        this.alpha2_code = alpha2_code;
    }

    public String getAlpha3_code() {
        return alpha3_code;
    }

    public void setAlpha3_code(String alpha3_code) {
        this.alpha3_code = alpha3_code;
    }

    @Override
    public String toString() {
        return "Pays{" +
                "name='" + name + '\'' +
                ", alpha2_code='" + alpha2_code + '\'' +
                ", alpha3_code='" + alpha3_code + '\'' +
                '}';
    }
}
