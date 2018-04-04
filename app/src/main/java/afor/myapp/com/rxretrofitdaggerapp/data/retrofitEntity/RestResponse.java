package afor.myapp.com.rxretrofitdaggerapp.data.retrofitEntity;

import java.util.ArrayList;

import afor.myapp.com.rxretrofitdaggerapp.data.Pays;

/**
 * Created by Mahdi Dammak on 27/02/2018.
 */

public class RestResponse {
    ArrayList<Pays> result;
    ArrayList<String> messages;

    public RestResponse() {
    }

    public ArrayList<Pays> getResult() {
        return result;
    }

    public void setResult(ArrayList<Pays> result) {
        this.result = result;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "RestResponse{" +
                "result=" + result +
                ", messages=" + messages +
                '}';
    }
}
