package com.estetica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Embeddable;


/**
 * *
 * Criação da classe DataConsulta.
 *
 * @author GABRIEL
 */
@Embeddable
public class DataConsulta {
       
    public  LocalDateTime gerarData(String dia, String mes, String hora, String minuto){
        LocalDateTime dataAtual = LocalDateTime.now();
        
        int mesAtual = dataAtual.getMonthValue();
        int diaAtual = dataAtual.getDayOfMonth();
        int anoAtual = dataAtual.getYear();
        int horaAtual = dataAtual.getHour();
        int minutoAtual = dataAtual.getMinute();
        
        int mesCadastrado = Integer.parseInt(mes);
        int diaCadastrado = Integer.parseInt(dia);
        int horaCadastrada = Integer.parseInt(hora);
        int minutoCadastrado = Integer.parseInt(minuto);
        
        if (mesCadastrado < mesAtual || mesCadastrado == mesAtual && diaCadastrado < diaAtual || mesCadastrado == mesAtual && diaCadastrado == diaAtual
                && horaCadastrada < horaAtual || mesCadastrado == mesAtual && diaCadastrado == diaAtual && horaCadastrada == horaAtual && minutoCadastrado < minutoAtual
                || mesCadastrado == mesAtual && diaCadastrado == diaAtual && horaCadastrada == horaAtual && minutoCadastrado == minutoAtual) {
            anoAtual += 1;
        }
        return LocalDateTime.of(anoAtual, mesCadastrado, diaCadastrado, horaCadastrada, minutoCadastrado);
    }
}
