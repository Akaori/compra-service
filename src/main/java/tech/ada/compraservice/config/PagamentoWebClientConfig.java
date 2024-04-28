package tech.ada.compraservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import tech.ada.compraservice.client.PagamentoClient;

@Configuration
public class PagamentoWebClientConfig {
    @Value("${negocio.pagamento.url}")
    private String pagamentoUrl;

    @Bean
    WebClient webClient(){
        return WebClient.builder().baseUrl(pagamentoUrl).build();
    }

    @Bean
    PagamentoClient pagamentoClient(WebClient webClient){
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient())).build();
        return httpServiceProxyFactory.createClient(PagamentoClient.class);
    }
}
