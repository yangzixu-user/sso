package com.sso.config;

import com.sso.utils.RsaUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.security.PublicKey;

/**
 * @author yangzx
 */
@Data
@ConfigurationProperties("rsa.key")
public class RsaKeyProperties {

        private String pubKeyPath;

        private PublicKey publicKey;

        @PostConstruct
        public void createKey() throws Exception {
            this.publicKey =  RsaUtils.getPublicKey(pubKeyPath);
        }


    }


