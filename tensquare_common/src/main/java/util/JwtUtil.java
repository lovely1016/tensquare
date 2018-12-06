package util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;

/**
 * Description:
 * date: 2018/12/4 9:35
 * author: loveLy
 */
@ConfigurationProperties("jwt.config")
public class JwtUtil {

    private String key;//密钥
    private long ttl;//过期时间


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }

    //创建JWT
    public String createJWT(String id,String subject,String roles){
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder().setId(id)
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, key)
                .claim("roles", roles);
        if (ttl>0) {
            builder.setExpiration(new Date(nowMillis+ttl));
        }
        return builder.compact();
    }


    //解析JWT
    public Claims parseJWT(String jwtStr){
        return (Claims) Jwts.parser().setSigningKey(key).parse(jwtStr).getBody();
    }
}
