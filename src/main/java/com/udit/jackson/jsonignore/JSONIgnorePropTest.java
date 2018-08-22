package com.udit.jackson.jsonignore;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSONIgnorePropTest {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        testMyTestClass(mapper);
        testMyTestClassWithJsonIgnore(mapper);
        testMyTestClassWithJsonIgnoreProperties(mapper);

    }

    private static void testMyTestClass(ObjectMapper mapper) {
        MyTestClass mtc = new MyTestClass();
        mtc.setId(1);
        mtc.setName("Test program");
        mtc.setNotInterstingMember("Don't care about this");
        mtc.setAnotherMember(100);
        mtc.setForgetThisField(-1);


        String s = null;
        try {
            s = mapper.writeValueAsString(mtc);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(s);

        MyTestClass mtc2 = null;
        try {
            mtc2 = mapper.readValue(s, MyTestClass.class);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(mtc2.toString());
    }

    private static void testMyTestClassWithJsonIgnoreProperties(ObjectMapper mapper) {
        MyTestClassWithJsonIgnoreProperties mtc = new MyTestClassWithJsonIgnoreProperties();
        mtc.setId(1);
        mtc.setName("Test program");
        mtc.setNotInterstingMember("Don't care about this");
        mtc.setAnotherMember(100);
        mtc.setForgetThisField(-1);


        String s = null;
        try {
            s = mapper.writeValueAsString(mtc);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(s);

        MyTestClassWithJsonIgnoreProperties mtc2 = null;
        try {
            mtc2 = mapper.readValue(s, MyTestClassWithJsonIgnoreProperties.class);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(mtc2.toString());
    }

    private static void testMyTestClassWithJsonIgnore(ObjectMapper mapper) {
        MyTestClassWithJsonIgnore mtc = new MyTestClassWithJsonIgnore();
        mtc.setId(1);
        mtc.setName("Test program");
        mtc.setNotInterstingMember("Don't care about this");
        mtc.setAnotherMember(100);
        mtc.setForgetThisField(-1);


        String s = null;
        try {
            s = mapper.writeValueAsString(mtc);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(s);

        MyTestClassWithJsonIgnore mtc2 = null;
        try {
            mtc2 = mapper.readValue(s, MyTestClassWithJsonIgnore.class);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(mtc2.toString());
    }
}
