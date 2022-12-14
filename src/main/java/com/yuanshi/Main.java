package com.yuanshi;

import com.yuanshi.App.OnlineStore;

public class Main {
    public static void main(String[] args) {
        OnlineStore os = new OnlineStore();
        os.buildConnection();
        os.executeInstructions();
    }
}