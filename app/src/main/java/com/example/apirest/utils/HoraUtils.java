package com.example.apirest.utils;

import android.util.Log;
import android.util.Pair;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.Minutes;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
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

    public Pair<String,String> getWeekRange(int year, int week_no) {
        DateTime startOfWeek = new DateTime().withYear(year).withWeekOfWeekyear(week_no);

        DateTime endOfWeek = startOfWeek.plusDays(6);

        return new Pair<String,String>(startOfWeek.toString(), endOfWeek.toString());
    }



    public static String getDiaSemana(){
        return String.format("dia_%d", LocalDate.now().getDayOfWeek());
    }

    public static boolean isBeforeNow(String hora){
        org.joda.time.LocalTime mTime = org.joda.time.LocalTime.parse(hora);
        org.joda.time.LocalTime horaAtual = org.joda.time.LocalTime.now();
        return horaAtual.isBefore(mTime);
    }

    public static boolean isDateInBetweenIncludingEndPoints(final Date min, final Date max, final Date date){
        return !(date.before(min) || date.after(max));
    }
}
