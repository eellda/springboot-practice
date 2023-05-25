package com.example.demo.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;

public class JasyptConfig {
    @Bean(name = "jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        String key = "demo";
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor(); // 알고리즘
        SimpleStringPBEConfig config = new SimpleStringPBEConfig(); // encryptor 설정
        config.setPassword(key); // 암호화할때 키
        config.setAlgorithm("PBEWithMD5AndDES"); // 암호화 알고리즘
        config.setKeyObtentionIterations("1000"); // 해싱 회수
        config.setPoolSize("1"); // 인스턴스 풀
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator"); // salt 생성
        //config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64"); // 인코딩
        encryptor.setConfig(config); // 설정 적용
        return encryptor;
    }
}
