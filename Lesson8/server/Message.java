package Lesson8.server;

public class Message {
    private String nick;
    private String msg;
    private String time;

    public Message(){

    }

    public Message(String nick, String msg, String time){
        this.nick = nick;
        this.msg = msg;
        this.time = time;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return  (nick + "  " + time + "  " + msg);
    }
}
