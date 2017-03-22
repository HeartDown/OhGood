/**
 * Copyright (c) 2016- https://github.com/beiyoufx
 *
 * Licensed under the GPL-3.0
 */
package core.support;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author yongjie.teng
 * @version 1.0
 * @date 16-10-28
 * @email yongjie.teng@foxmail.com
 * @package core.support
 * @project teemo
 */
public class CustomDateEditor extends PropertyEditorSupport {

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final DateFormat[] ACCEPT_DATE_FORMATS = { new SimpleDateFormat(DEFAULT_DATETIME_FORMAT), new SimpleDateFormat(DEFAULT_DATE_FORMAT) };

    /**
     * Parse the Date from the given text, using the specified DateFormat.
     */

    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.trim().equals(""))
            setValue(null);
        for (DateFormat format : ACCEPT_DATE_FORMATS) {
            try {
                setValue(format.parse(text));
                return;
            } catch (ParseException e) {
                continue;
            } catch (RuntimeException e) {
                continue;
            }
        }
    }

    /**
     * Format the Date as String, using the specified DateFormat.
     */

    public String getAsText() {
        return (String) getValue();
    }
}