package model.PIM;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract interface DateOperation {
    public void SetDate(Date s);

    public void SetDate();

    public Date getDate() throws ParseException;

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
}


