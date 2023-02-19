package com.example.apirest.utils;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.Minutes;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.time.LocalTime;
import java.util.regex.Pattern;

public class HoraUtils {

    private static final String TIME24HOURS_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
    private static final String DATETIMEBR_PATTERN = "dd/MM/yyyy HH:mm:ss";

    public static boolean validarHora(String hora){
        return (Pattern.compile(TIME24HOURS_PATTERN)).matcher(hora).matches();
    }

    public static int minutesAgo(String dataHoraText){
        DateTimeFormatter formatter = DateTimeFormat.forPattern(DATETIMEBR_PATTERN);
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        LocalDateTime dataHora = formatter.parseLocalDateTime(dataHoraText);
        return Minutes.minutesBetween(dataHora, dataHoraAtual).getMinutes();
    }

    public static boolean isIn(String abertura, String fechamento){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalTime horaAtual = LocalTime.now();
            LocalTime horaInicio = LocalTime.parse(abertura);
            LocalTime horaFim = LocalTime.parse(fechamento);

            return (horaAtual.isAfter(horaInicio) && horaAtual.isBefore(horaFim));
        } else {
            org.joda.time.LocalTime horaAtual = org.joda.time.LocalTime.now();
            org.joda.time.LocalTime aberturaTime = org.joda.time.LocalTime.parse(abertura);
            org.joda.time.LocalTime fechamentoTime = org.joda.time.LocalTime.parse(fechamento);

            return (horaAtual.isAfter(aberturaTime) && horaAtual.isBefore(fechamentoTime));
        }
    }

    public static String getDiaSemana(){
        return String.format("dia_%d", LocalDate.now().getDayOfWeek());
    }

    public static boolean isBeforeNow(String hora){
        org.joda.time.LocalTime mTime = org.joda.time.LocalTime.parse(hora);
        org.joda.time.LocalTime horaAtual = org.joda.time.LocalTime.now();
        return horaAtual.isBefore(mTime);
    }
}
