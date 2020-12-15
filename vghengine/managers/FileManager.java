/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vghengine.managers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileManager {
    private BufferedReader br;
    private BufferedWriter bw;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private String nome;
    private String modalita;
    private boolean feof;
    
    public FileManager(String n, String m) throws IOException {
        setNome(n);
        setModalita(m);
        if(m.equals("w")) {
            bw = new BufferedWriter(new FileWriter(n));
        }
        else if(m.equals("wb")) {
            oos = new ObjectOutputStream(new FileOutputStream(n));
        }
        else if(m.equals("r")) {
            br = new BufferedReader(new FileReader(n));
        }
        else if(m.equals("rb")) {
            ois = new ObjectInputStream(new FileInputStream(n));
        }
        feof=false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModalita() {
        return modalita;
    }

    public void setModalita(String modalita) {
        this.modalita = modalita;
    }
    
    public void toFile(String line) {
        if(this.modalita.equals("w")) {
            try {
                bw.write(line);
                bw.close();
            }
            catch(IOException e) {
            }
        }
        else if(modalita.equals("a")) {
            try {
                bw.write(line);
                bw.close();
            }
            catch(IOException e) {
            }
        }
        else {
            System.out.println("Modalità di apertura errata!");
        }
    }
    
    public String readLine() throws FileNotFoundException, IOException {
        String line="";
        if(modalita.equals("r")) {
            line=br.readLine();
        }
        else {
            System.out.println("Modalità di apertura errata!");
            line=null;
        }
        return line;
    }
    
    public String fromFile() throws FileNotFoundException, IOException {
        String line = "";
        String content="";
        
        if(modalita.equals("r")) {
            br = new BufferedReader(new FileReader(getNome()));
                while(feof != true) {
                    line=br.readLine();
                    if(line == null) {
                        feof=true;
                    }
                    else {
                        line += '\n';
                        content += line;
                    }
                }
        }
        else {
            System.out.println("Modalità di apertura errata!");
            content=null;
        }
        return content;
    }
    
    public void closeFile() {
        if(this.br != null) {
            try {
                br.close();
            }
            catch(IOException e) {
                
            }
        }
        if(this.bw != null) {
            try {
                bw.close();
            }
            catch(IOException e) {
                
            }
        }
        if(this.oos != null) {
            try {
                oos.close();
            }
            catch(IOException e) {
                
            }
        }
        if(this.ois != null) {
            try {
                ois.close();
            }
            catch(IOException e) {
                
            }
        }
    }
    
    public void serialize(Object obj) {
        if(modalita.equals("wb")) {
            try {
                oos = new ObjectOutputStream(new FileOutputStream(getNome()));
                oos.writeObject(obj);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Modalità di apertura errata!");
        }
    }
    
    public Object deserialize() {
        Object oggetto=null;
        if(modalita.equals("rb")) {
            try {
                ois = new ObjectInputStream(new FileInputStream(getNome()));
                oggetto = ois.readObject();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Modalità di apertura errata!");
            oggetto = null;
        }
        return oggetto;
    }
    
    public void toJson(JSONObject jobj) {
        if(modalita.equals("w")) {
            try {
                this.bw.write(jobj.toJSONString());
                System.out.println("JSON salvato con successo!");
            }
            catch(Exception e) {
                System.out.println("JSON non salvato!");
            }
        }
    }
    
    public void toJson(JSONArray jArray) {
        if(modalita.equals("w")) {
            try {
                this.bw.write(jArray.toJSONString());
                System.out.println("JSON salvato con successo!");
            }
            catch(Exception e) {
                System.out.println("JSON non salvato!");
            }
        }
    }
    
    public JSONObject fromJson() {
        JSONObject jobj = null;
        try {
            if(modalita.equals("r")) {
                JSONParser jsParser = new JSONParser();
                jobj = (JSONObject)jsParser.parse(new FileReader(this.nome));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return jobj;
    }
    
    public JSONArray readJsonArray() {
        JSONArray jArray = null;
        try {
            if(modalita.equals("r")) {
                JSONParser jsParser = new JSONParser();
                jArray = (JSONArray)jsParser.parse(new FileReader(this.nome));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return jArray;
    }
}
