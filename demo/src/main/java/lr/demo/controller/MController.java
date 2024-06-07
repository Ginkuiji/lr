package lr.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lr.demo.models.*;
import lr.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.stream.StreamSupport;

@Controller
public class MController {
    @Autowired
    private CoinRep coin_repository;
    @Autowired
    private ExchangeRep exchange_repository;
    @Autowired
    private DealRep deal_repository;
    @Autowired
    private PortfolioRep portfolio_repository;
    @Autowired
    private TrendRep trend_repository;

    @Autowired
    private BTCRep btc_repository;

    @GetMapping("/current-bitcoin")
    @ResponseBody
    public BTC getBitcoin(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("https://api.coindesk.com/v1/bpi/currentprice.json", String.class);
        String json = response.getBody();
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(json).getAsJsonObject();
        String time = jsonObject.getAsJsonObject("time").get("updated").getAsString();
        Double usd = jsonObject.getAsJsonObject("bpi").getAsJsonObject("USD").get("rate_float").getAsDouble();
        BTC newBitcoin = new BTC(time, usd);
        if (btc_repository.count() == 10) {
            Iterable<BTC> bitcoins = btc_repository.findAll();
            BTC[] bitcoinArray = StreamSupport.stream(bitcoins.spliterator(), false).toArray(BTC[]::new);
            BTC oldBitcoin = bitcoinArray[0];
            btc_repository.deleteById(oldBitcoin.getId());
        }
        btc_repository.save(newBitcoin);
        return newBitcoin;
    }
    @GetMapping("/bitcoins")
    @ResponseBody
    public Iterable<BTC> getBitcoins(){
        Iterable<BTC> bitcoins = btc_repository.findAll();
        return bitcoins;
    }
    @GetMapping("/coins")
    @ResponseBody
    public Iterable<Coin> GET_Coins() {
        Iterable<Coin> coins = coin_repository.findAll();
        return coins;
    }
    @PostMapping("/coin/add")
    @ResponseBody
    public Coin ADD_Coin(@RequestBody Coin coin) {
        coin_repository.save(coin);
        return coin;
    }

    @GetMapping("/exchanges")
    @ResponseBody
    public Iterable<Exchange> GET_Exchanges() {
        Iterable<Exchange> exchanges = exchange_repository.findAll();
        return exchanges;
    }
    @PostMapping("/exchange/add")
    @ResponseBody
    public Exchange ADD_Exchange(@RequestBody Exchange exchange) {
        exchange_repository.save(exchange);
        return exchange;
    }

    @GetMapping("/portfolio/{id}")
    @ResponseBody
    public Portfolio GET_Portfolio(@PathVariable Long id) {
        return portfolio_repository.findById(id).orElse(null);
    }
    @PostMapping("/portfolio/add")
    @ResponseBody
    public Portfolio ADD_Portfolio(@RequestBody Portfolio portfolio){
        portfolio_repository.save(portfolio);
        return portfolio;
    }

    @GetMapping("/trends")
    @ResponseBody
    public Iterable<Trend> GET_Trends() {
        Iterable<Trend> trends = trend_repository.findAll();
        return trends;
    }
    @PostMapping("/trend/add")
    @ResponseBody
    public Trend ADD_Trend(@RequestBody Coin COIN) {
        Coin coin = coin_repository.findById(COIN.getId()).orElse(null);
        if (coin != null) {
            Trend trend = new Trend(coin.getCoin_name(), coin.getCoin_code(),
                    coin.getH24());
            trend_repository.save(trend);
            return trend;
        } else {
            return null;
        }
    }

    @PostMapping("/portfolio/{id}/add-deal")
    @ResponseBody
    public Deal ADD_Deal(@PathVariable Long id, @RequestBody Deal DEAL) {
        Portfolio portfolio = portfolio_repository.findById(id).orElse(null);
        if (portfolio != null) {
            portfolio.getDeals().add(DEAL);
            deal_repository.save(DEAL);
            portfolio_repository.save(portfolio);
            return DEAL;
        } else {
            return null;
        }
    }
    @PostMapping("/portfolio/{id}/add-coin")
    @ResponseBody
    public Coin ADD_Coin(@PathVariable Long id, @RequestBody Coin COIN) {
        Portfolio portfolio = portfolio_repository.findById(id).orElse(null);
        if (portfolio != null) {
            Coin coin = coin_repository.findById(COIN.getId()).orElse(null);
            if (coin != null) {
                portfolio.getCoins().add(coin);
                portfolio_repository.save(portfolio);
                return coin;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}