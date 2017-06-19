package dongting.bwei.com.examtwob.bean;

/**
 * 作者:${董婷}
 * 日期:2017/6/19
 * 描述:
 */

public class Bean {
    public String text;
    public boolean ischecked ;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean ischecked() {
        return ischecked;
    }

    public void setIschecked(boolean ischecked) {
        this.ischecked = ischecked;
    }

    public Bean(String text, boolean ischecked) {
        this.text = text;
        this.ischecked = ischecked;
    }
}