package ar.com.atletismo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ariel
 */
public class DateUtils {

    public static boolean fechaValida(String s) {
       try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(s);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static Date getDate(String s) {
       try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(s);
            return new SimpleDateFormat("dd/MM/yyyy").parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
        
    /*
     * retorna un Date con anio, mes, dia, horas y minutos
     */
    public static Date getDate(int anio, int mes, int dia, int hora, int minuto) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(anio, mes-1, dia, hora, minuto, 0);
        return calendar.getTime();
    }
    
    public static Date getDate(Date fecha, int hora, int minuto) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.set(Calendar.HOUR_OF_DAY, hora);
        calendar.set(Calendar.MINUTE, minuto);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static String getHoraMinuto(Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        return  org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)), 2, "0") + ":" + 
                org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(calendar.get(Calendar.MINUTE)), 2, "0");
    }

    public static String getFecha(Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        return  org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(calendar.get(Calendar.DATE)), 2, "0") + "/" + 
                org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(calendar.get(Calendar.MONTH)+1), 2, "0") + "/" + 
                org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(calendar.get(Calendar.YEAR)), 4, "0");
    }

    /*
     * retorna la fecha actual menos 5 horas
     */
    public static Date getDatePreInscripcion() {
        Date ahora = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ahora);
        calendar.add(Calendar.HOUR_OF_DAY, -5);
        return calendar.getTime();
    }

    public static int getAniosALaFecha(Date fechaInicio) {
        LocalDate fechaInicioLd = fechaInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaHoy = (new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(fechaInicioLd, fechaHoy).getYears();
    }
    
}
