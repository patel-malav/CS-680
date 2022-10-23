package edu.umb.cs680.hw03;

import java.util.HashMap;

public class EmailProxy {
    private static EmailProxy instance = null;

    private HashMap<Integer, String> cache = null;
    private String[] domainsToProxy = null;
    private String selfEmail = null;

    private EmailProxy(String selfEmail, String[] domainsToProxy) {
        cache = new HashMap<>();
        this.selfEmail = selfEmail;
        this.domainsToProxy = domainsToProxy;
    }

    public static EmailProxy getInstance(String selfEmail, String[] domainsToProxy) {
        if (instance == null) {
            instance = new EmailProxy(selfEmail, domainsToProxy);
        }
        return instance;
    }

    public String getEmail(int id) {
        return cache.get(id);
    }

    // Check's if the email in question is
    public boolean setEmail(int id, String email) {
        boolean wasProxied = false;
        if (selfEmail != null && domainsToProxy != null) {
            for (int i = 0; i < domainsToProxy.length; i++) {
                if (email.endsWith(domainsToProxy[i])) {
                    email = email.replace(domainsToProxy[i], selfEmail);
                    wasProxied = true;
                }
            }
        }

        cache.put(id, email);
        return wasProxied;
    }
}
