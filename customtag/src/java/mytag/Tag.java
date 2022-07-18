package mytag;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.SkipPageException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.DateFormat;
import java.time.Instant;

/**
 *
 * @author ASUS
 */
public class Tag extends SimpleTagSupport {

    private String format;
    private String date;

    public Tag() {
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @throws JspException
     * @throws IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("Date is:" + date);
        System.out.println("Format is:" + format);
        try {
            Date dt= Date.valueOf(date);
            SimpleDateFormat formatter2 = new SimpleDateFormat(format);
            String formattedDate = formatter2.format(dt);
            System.out.println("formattedDate is:" + formattedDate);
            getJspContext().getOut().write(formattedDate);
        } catch (Exception e) {
            // stop page from loading further by throwing SkipPageException
            throw new SkipPageException("Exception in formatting " + date
                    + " with format " + format);
        }
    }
}
