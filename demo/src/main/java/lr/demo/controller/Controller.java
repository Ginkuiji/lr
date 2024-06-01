package lr.demo.controller;

import org.springframework.web.bind.annotation.*;
import lr.demo.dto.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    List<Coin> coins = new ArrayList<>();
    List<Trend> trends = new ArrayList<>();
    List<Exchange> exchanges = new ArrayList<>();
    Portfolio PORTFOLIO = new Portfolio();

    public Controller () {
        coins.add(new Coin("Bitcoin", "BTC", 50000f, -25f, 23f, 56f, 2303534050432.0,
                4395723867.0, new float[]{324f, 436f, 584f, 987f, 674f}));

        PORTFOLIO.add_coin("Bitcoin", "BTC", 50.087876f, -25f, 23f, 56f,
                2303534050432.0, 4395723867.0, new float[]{324f, 436f, 584f, 987f, 674f});

        exchanges.add(new Exchange("Binance", 9.0f, 364578658725f, 67f, 45f, new
                float[]{324f,436f,584f,987f,674f}));

        trends.add(new Trend("Bitcoin", "BTC", 23.0f));
    }

    @GetMapping("/coins")
    public List<Coin> GET_coins() {
        return coins;
    }

    @GetMapping("/trends")
    public List<Trend> GET_trends() {
        return trends;
    }

    @GetMapping("/exchanges")
    public List<Exchange> GET_exchanges() {
        return exchanges;
    }

    @GetMapping("/portfolio")
    public Portfolio GET_portfolio() {
        return PORTFOLIO;
    }

    @PostMapping("/add-deal")
    public Deal POST_deal(@RequestBody Deal newDeal) {
        PORTFOLIO.add_deal(newDeal);
        return PORTFOLIO.deals.getLast();
    }
}