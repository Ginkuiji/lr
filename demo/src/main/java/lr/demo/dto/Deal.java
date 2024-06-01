package lr.demo.dto;

public class Deal {
    private String date;
    private String type;
    private Double price;
    private Double volume;
    private String coinName;
    private String coinCode;

    public Deal(String date, String type, float price, float volume, String
            coin_name, String coin_code) {
        this.date = date;
        this.type = type;
        this.price = (double) price;
        this.volume = (double) volume;
        this.coinName = coin_name;
        this.coinCode = coin_code;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public void setCoinCode(String coinCode) {
        this.coinCode = coinCode;
    }
}