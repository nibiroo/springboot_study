package io.github.nibiroo.estruturaearquitetura.montadora.configuration;

import io.github.nibiroo.estruturaearquitetura.montadora.Motor;
import io.github.nibiroo.estruturaearquitetura.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MontadoraConfiguration {

    @Bean
    public Motor motor() {
        var motor = new Motor();

        motor.setCavalos(300);
        motor.setCilindros(8);
        motor.setModelo("XPTO-8");
        motor.setLitragem(6.0);
        motor.setTipoMotor(TipoMotor.ASPIRADO);

        return motor;
    }
}
