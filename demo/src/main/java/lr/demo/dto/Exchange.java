package lr.demo.dto;

public class Exchange {
    private String name;
    private double score;
    private Float volume24h;
    private Float markets;
    private Float coins;
    private float[] lastVolume;

    public Exchange(String name, Float score, Float volume24h, Float markets, Float
            coins, float last_volume[]) {
        this.name = name;
        this.score = score;
        this.volume24h = volume24h;
        this.markets = markets;
        this.coins = coins;
        this.lastVolume = last_volume;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Float getVolume24h() {
        return volume24h;
    }

    public void setVolume24h(Float volume24h) {
        this.volume24h = volume24h;
    }

    public Float getMarkets() {
        return markets;
    }

    public void setMarkets(Float markets) {
        this.markets = markets;
    }

    public Float getCoins() {
        return coins;
    }

    public void setCoins(Float coins) {
        this.coins = coins;
    }

    public float[] getLastVolume() {
        return lastVolume;
    }

    public void setLastVolume(float[] lastVolume) {
        this.lastVolume = lastVolume;
    }
}