package dispatch;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTools {

    /**
     * ����ת����
     * 
     * @param datetime
     * @return
     */
    public static String dateToWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "����", "��һ", "�ܶ�", "����", "����", "����", "����" };
        Calendar cal = Calendar.getInstance(); // ���һ������
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // ָʾһ�������е�ĳ�졣
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
}
