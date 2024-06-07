package lr.demo.models;
import jakarta.persistence.*;
@Entity
public class Trend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coin_name, coin_code;
    private Float h24;
    public Trend() {
    }
    public Trend(String coin_name, String coin_code, Float h24) {
        this.coin_name = coin_name;
        this.coin_code = coin_code;
        this.h24 = h24;
    }

    public String getCoin_name() {
        return coin_name;
    }

    public void setCoin_name(String coin_name) {
        this.coin_name = coin_name;
    }

    public String getCoin_code() {
        return coin_code;
    }

    public void setCoin_code(String coin_code) {
        this.coin_code = coin_code;
    }

    public float getH24() {
        return h24;
    }

    public void setH24(Float h24) {
        this.h24 = h24;
    }
}