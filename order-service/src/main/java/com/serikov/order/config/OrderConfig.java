package com.serikov.order.config;

import com.serikov.dto.OrchestratorRequestDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.FluxSink;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class OrderConfig {

    @Bean
    public DirectProcessor<OrchestratorRequestDTO> publisher(){
        return DirectProcessor.create();
    }

    @Bean
    public FluxSink<OrchestratorRequestDTO> sink(DirectProcessor<OrchestratorRequestDTO> publisher){
        return publisher.sink();
    }

}
