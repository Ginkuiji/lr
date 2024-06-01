package lr.demo.dto;

import java.util.List;
import java.util.ArrayList;

public class Portfolio {
    public List<Coin> coins = new ArrayList<>();
    public List<Deal> deals = new ArrayList<>();
    float profile_volume_usd[];
    float profile_volume_btc[];
    float current_volume_usd;
    float current_volume_btc;

    public void add_coin(String coin_name, String coin_code, float price, float h1,
                         float h24, float d7, double market_cap, double volume, float last_price[]) {
        coins.add(new Coin(coin_name, coin_code, price, h1, h24, d7, market_cap,
                volume, last_price));
    }

    public void add_deal(Deal newDeal) {
        deals.add(newDeal);
    }

    public Portfolio() {
        this.profile_volume_usd =  new float[]{324.0f, 436.0f, 584.0f, 987.0f,
                674.0f};
        this.profile_volume_btc =  new float[]{324.0f, 436.0f, 584.0f, 987.0f,
                674.0f};
        this.current_volume_usd = 345f;
        this.current_volume_btc = 345f;
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

    public float[] getProfile_volume_usd() {
        return profile_volume_usd;
    }

    public void setProfile_volume_usd(float[] profile_volume_usd) {
        this.profile_volume_usd = profile_volume_usd;
    }

    public float[] getProfile_volume_btc() {
        return profile_volume_btc;
    }

    public void setProfile_volume_btc(float[] profile_volume_btc) {
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