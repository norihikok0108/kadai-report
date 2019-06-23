package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Client;

public class ClientValidator {
    public static List<String> validate(Client c) {
        List<String> errors = new ArrayList<String>();

        String client_name = _validateClient_name(c.getClient_name());
        if(!client_name.equals("")) {
            errors.add(client_name);
        }

        String client_address = _validateClient_address(c.getClient_address());
        if(!client_address.equals("")) {
            errors.add(client_address);
        }

        String partner_name = _validatePartner_name(c.getPartner_name());
        if(!partner_name.equals("")) {
            errors.add(partner_name);
        }

        String client_content = _validateClient_content(c.getClient_content());
        if(!client_content.equals("")) {
            errors.add(client_content);
        }

        return errors;
    }

    private static String _validateClient_name(String client_name) {
        if(client_name == null || client_name.equals("")) {
            return "訪問先企業名を入力してください。";
        }
    return "";
    }

    private static String _validateClient_address(String client_address) {
        if(client_address == null || client_address.equals("")) {
            return "訪問先住所を入力してください。";
        }
    return "";
    }

    private static String _validatePartner_name(String partner_name) {
        if(partner_name == null || partner_name.equals("")) {
            return "訪問先担当者名を入力してください。";
        }
    return "";
    }

    private static String _validateClient_content(String client_content) {
        if(client_content == null || client_content.equals("")) {
            return "商談内容を入力してください。";
        }
    return "";
    }
}
