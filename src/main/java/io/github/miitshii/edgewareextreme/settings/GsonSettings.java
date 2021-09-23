package io.github.miitshii.edgewareextreme.settings;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import lombok.Getter;

import java.io.*;

public class GsonSettings {

    private static final String FILENAME = "edgewareExtreme.json";

    @Getter
    private GsonSettingsModel model;

    public GsonSettings() {
        loadConfig();
    }

    private void loadConfig() {
        try {
            File f = new File(FILENAME);
            if (f.exists()) {
                JsonReader reader = new JsonReader(new FileReader(f));
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                model = gson.fromJson(reader, GsonSettingsModel.class);
                if (model == null) {
                    model = new GsonSettingsModel();
                }
                reader.close();
            } else {
                model = new GsonSettingsModel();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveConfig() {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter fw = new FileWriter(new File(FILENAME));
            gson.toJson(model, GsonSettingsModel.class, fw);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
