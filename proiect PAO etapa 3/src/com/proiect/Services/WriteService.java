package com.proiect.Services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteService<T> {
    private static final WriteService<?> instance = new WriteService<Object>();

    private WriteService() {
    }

    public static WriteService<?> getInstance() {
        return instance;
    }

    public static void scrieCsv(String path, String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length - 1; i++) {
            sb.append(args[i]).append(",");
        }
        sb.append(args[args.length - 1]);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            writer.write(sb.toString());
            writer.newLine();
            writer.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
