package tech.ada.compraservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import tech.ada.compraservice.client.CarrinhoClient;

@Configuration
public class CarrinhoWebClientConfig {
    @Value("${negocio.carrinho.url}")
    private String carrinhoUrl;

    @Bean
    WebClient webClient(){
        return WebClient.builder().baseUrl(carrinhoUrl).build();
    }

    @Bean
    CarrinhoClient carrinhoClient(WebClient webClient){
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient())).build();
        return httpServiceProxyFactory.createClient(CarrinhoClient.class);
    }
}