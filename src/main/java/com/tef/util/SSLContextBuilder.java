package com.tef.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class SSLContextBuilder {

    public  SSLContext SSLContext (String certFilePath, String certPassword, String alias) throws Exception {
        // Carregar o certificado do arquivo de keystore
        loadCertificateFromKeystore(certFilePath, certPassword, alias);

        // Carregar a CA raiz
        X509Certificate rootCACertificate = loadRootCACertificate();

        // Configurar o gerenciador de chaves
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
        keyManagerFactory.init(loadKeyStore(certFilePath, certPassword), certPassword.toCharArray());

        // Configurar o gerenciador de confiança
        TrustManager[] trustManagers = { new X509TrustManager() {
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }

            @Override
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
                // Implementar a lógica de verificação do cliente, se necessário.
                // Pode lançar CertificateException se a verificação falhar.
                if (certs == null || certs.length == 0) {
                    throw new IllegalArgumentException("Certificado do cliente ausente");
                }

                // Realizar verificações no certificado do cliente, se necessário
                for (X509Certificate clientCert : certs) {
                    try {
                        clientCert.checkValidity();
                        clientCert.verify(rootCACertificate.getPublicKey());
                        // Outras verificações, se necessário
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Falha na verificação do certificado do cliente", e);
                    }
                }
            }

            @Override
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
                // Implementar a lógica de verificação do servidor.
                // Pode lançar CertificateException se a verificação falhar.
                if (certs == null || certs.length == 0) {
                    throw new IllegalArgumentException("Certificado do servidor ausente");
                }

                // Verificar o certificado do servidor em relação à CA raiz
                for (X509Certificate serverCert : certs) {
                    try {
                        serverCert.checkValidity();
                        serverCert.verify(rootCACertificate.getPublicKey());
                        // Outras verificações, se necessário
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Falha na verificação do certificado do servidor", e);
                    }
                }
            }
        } };

        // Configurar o contexto SSL
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagers, null);

        return sslContext;
    }

    private static X509Certificate loadRootCACertificate() throws Exception {
        // Carregar o certificado da CA raiz a partir de um arquivo ou recurso
        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");

        URL resourceUrl = SSLContextBuilder.class.getResource("/com/tef/Aditum-GerenciadorPadraoTEF-RootCA.crt");
        if (resourceUrl == null) {
            throw new IllegalArgumentException("Arquivo de certificado CA raiz não encontrado");
        }

        try (InputStream is = resourceUrl.openStream()) {
            return (X509Certificate) certFactory.generateCertificate(is);
        }
    }

    private static X509Certificate loadCertificateFromKeystore(String certFilePath, String certPassword, String alias) throws Exception {
        KeyStore keystore = KeyStore.getInstance("PKCS12");

        // Certifique-se de que certFilePath representa um caminho absoluto ou relativo correto
        File file = new File(certFilePath);
        if (!file.exists()) {
            // Se o arquivo não existe, tente considerar certFilePath como um caminho relativo ao diretório de execução
            file = new File(System.getProperty("user.dir"), certFilePath);
            if (!file.exists()) {
                throw new FileNotFoundException("Arquivo de keystore não encontrado: " + certFilePath);
            }
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            keystore.load(fis, certPassword.toCharArray());
        }
        return (X509Certificate) keystore.getCertificate(alias);
    }

    private static KeyStore loadKeyStore(String certFilePath, String certPassword) throws Exception {
        KeyStore keystore = KeyStore.getInstance("PKCS12");
        try (FileInputStream fis = new FileInputStream(certFilePath)) {
            keystore.load(fis, certPassword.toCharArray());
        }
        return keystore;
    }
}