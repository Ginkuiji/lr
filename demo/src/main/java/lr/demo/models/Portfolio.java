package lr.demo.models;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Deal> deals;
    @ManyToMany
    private List<Coin> coins;
    private List<Float> profile_volume_usd = new ArrayList<>();
    private List<Float> profile_volume_btc = new ArrayList<>();
    private Float current_volume_usd, current_volume_btc;
    public Portfolio() {
    }
    public Portfolio(List<Coin> coins, List<Deal> deals, List<Float>
            profile_volume_usd, List<Float> profile_volume_btc, Float current_volume_usd, Float
                             current_volume_btc) {
        this.coins = coins;
        this.deals = deals;
        this.profile_volume_usd = profile_volume_usd;
        this.profile_volume_btc = profile_volume_btc;
        this.current_volume_usd = current_volume_usd;
        this.current_volume_btc = current_volume_btc;
    }

    public void add_coin(String coin_name, String coin_code, float price, float h1,
                         float h24, float d7, double market_cap, double volume, List<Float> last_price) {
        coins.add(new Coin(coin_name, coin_code, price, h1, h24, d7, market_cap,
                volume, last_price));
    }

    public void add_deal(Deal newDeal) {
        deals.add(newDeal);
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public List<Deal> getDeals() {
        return deals;
    }

    public void setDeals(List<Deal> deals) {
        this.deals = deals;
    }

    public List<Float> getProfile_volume_usd() {
        return profile_volume_usd;
    }

    public void setProfile_volume_usd(List<Float> profile_volume_usd) {
        this.profile_volume_usd = profile_volume_usd;
    }

    public List<Float> getProfile_volume_btc() {
        return profile_volume_btc;
    }

    public void setProfile_volume_btc(List<Float> profile_volume_btc) {
        this.profile_volume_btc = profile_volume_btc;
    }

    public float getCurrent_volume_usd() {
        return current_volume_usd;
    }

    public void setCurrent_volume_usd(float current_volume_usd) {
        this.current_volume_usd = current_volume_usd;
    }

    public float getCurrent_volume_btc() {
        return current_volume_btc;
    }

    public void setCurrent_volume_btc(float current_volume_btc) {
        this.current_volume_btc = current_volume_btc;
    }
}
