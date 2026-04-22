package org.adafilmes.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FormatarData {
    public static String formatoBR(String dataNumerica) {

        DateTimeFormatter ENTRADA =
                DateTimeFormatter.ofPattern("ddMMyyyy");

        DateTimeFormatter SAIDA =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (dataNumerica == null || dataNumerica.length() != 8) {
            throw new IllegalArgumentException("Data inválida. Formato esperado: ddMMyyyy");
        }

        try {
            LocalDate data = LocalDate.parse(dataNumerica, ENTRADA);
            return data.format(SAIDA);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data inválida: " + dataNumerica);
        }
    }
}
