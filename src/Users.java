import java.awt.*;
import java.util.HashMap;

public class Users {
    public String currUser;

    HashMap<String,String> loginInfo = new HashMap<String,String>();

    public Users(){
        this.currUser = "Guest";
    }

    protected HashMap getHashMap(){
        return loginInfo;
    }

    public String getCurrUser(){
        return currUser;
    }
}
