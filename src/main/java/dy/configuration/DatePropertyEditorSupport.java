package dy.configuration;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;

public class DatePropertyEditorSupport extends PropertyEditorSupport {
    private String format = "yyyy-MM-dd";

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            this.setValue(sdf.parse(text));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }

}
