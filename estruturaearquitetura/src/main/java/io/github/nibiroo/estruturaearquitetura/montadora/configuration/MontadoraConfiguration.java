package io.github.nibiroo.estruturaearquitetura.montadora.configuration;

import io.github.nibiroo.estruturaearquitetura.montadora.Motor;
import io.github.nibiroo.estruturaearquitetura.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MontadoraConfiguration {

    @Bean(name = "motorAspirado")
    public Motor motorAspirado() {
        var motor = new Motor();

        motor.setCavalos(300);
        motor.setCilindros(8);
        motor.setModelo("XPTO-8");
        motor.setLitragem(6.0);
        motor.setTipoMotor(TipoMotor.ASPIRADO);

        return motor;
    }

    @Bean(name = "motorEletrico")
    public Motor motorEletrico() {
        var motor = new Motor();

        motor.setCavalos(450);
        motor.setCilindros(3);
        motor.setModelo("TH-80");
        motor.setLitragem(2.4);
        motor.setTipoMotor(TipoMotor.ELETRICO);

        return motor;
    }

    @Bean(name = "motorTurbo")
    public Motor motorTurbo() {
        var motor = new Motor();

        motor.setCavalos(700);
        motor.setCilindros(16);
        motor.setModelo("VRAU-7");
        motor.setLitragem(16.0);
        motor.setTipoMotor(TipoMotor.TURBO);

        return motor;
    }
}
