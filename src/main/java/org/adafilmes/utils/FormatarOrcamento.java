package org.adafilmes.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class FormatarOrcamento {
    public static String formatarMoeda(String orcamento) {

        BigDecimal valor = new BigDecimal(orcamento);

        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("en", "US"));

        return formatoMoeda.format(valor);
    }
}
