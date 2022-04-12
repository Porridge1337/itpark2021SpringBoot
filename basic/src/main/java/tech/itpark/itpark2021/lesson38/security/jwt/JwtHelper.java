package tech.itpark.itpark2021.lesson38.security.jwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;
import tech.itpark.itpark2021.lesson38.security.dto.AuthorizedUser;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

@Component
public class JwtHelper {

    private static final JWSHeader JWT_HEADER = new JWSHeader(JWSAlgorithm.HS256);//алгоритм, с которым будетм использовать
    // наш JWT

    private final JWSSigner jwtSigner;
    private final JWSVerifier jwsVerifier;

    public JwtHelper() throws JOSEException {
        //формирование jwtSigner_a, который будет использоваться в моменте генерации самого jwt
        this.jwtSigner = new MACSigner("theStrongestPasswordAllOverTheWorld");
        // формирование jwsVerifier_а, который будет в дальнейшем проверять тот JWT который мы захотим запарсить
        this.jwsVerifier = new MACVerifier("theStrongestPasswordAllOverTheWorld");
    }

    @SneakyThrows
    public String generateToken(String issuer, String login, String[] rights) {
        Pair<Date, Date> issueAndExpirationTimes = getIssueAndExpirationTimes();
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .issuer(issuer) //тот кто выдал JWT, можно указать названия приложения и прочее
                .subject(login) //тот кому выдан токе
                .claim("login", login) // специализированный кастомный атрибут, в котором хранится какое-то своё значение
                .claim("rights", rights)
                .issueTime(issueAndExpirationTimes.getLeft())//дата выдачи токена
                .expirationTime(issueAndExpirationTimes.getRight())//время его истечения
                .build();
        SignedJWT signedJWT = new SignedJWT(JWT_HEADER, claimsSet);
        signedJWT.sign(jwtSigner);
        return signedJWT.serialize(); //получаем из объекта строку
    }

    @SneakyThrows
    public AuthorizedUser parseToken(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        final JWTClaimsSet jwtClaims;
        final SignedJWT decodedJWT = SignedJWT.parse(token);
        if (decodedJWT.verify(jwsVerifier) && isValid(jwtClaims = decodedJWT.getJWTClaimsSet())) {
            final String login = this.<String>getClaim(jwtClaims, "login")
                    .filter(StringUtils::isNotEmpty).orElseThrow();
            final String[] userRights = this.<JSONArray>getClaim(jwtClaims, "rights")
                    .map(list -> list.stream().toArray(String[]::new)).orElse(new String[]{});
            return new AuthorizedUser(login, userRights);
        }
        throw new IllegalArgumentException();
    }

    private Pair<Date, Date> getIssueAndExpirationTimes() {
        Instant issuedAt = Instant.now().truncatedTo(ChronoUnit.MILLIS);
        Instant expirationAt = issuedAt.plus(Duration.ofMinutes(10));
        return Pair.of(Date.from(issuedAt), Date.from(expirationAt));
    }

    private <T> Optional<T> getClaim(JWTClaimsSet jwtClaims, String claim) {
        return Optional.ofNullable((T) jwtClaims.getClaim(claim));
    }

    public boolean isValid(JWTClaimsSet jwtClaims) {
        Date referenceTime = new Date();
        Date expirationTime = jwtClaims.getExpirationTime();
        Date notBeforeTime = jwtClaims.getNotBeforeTime();
        boolean expired = expirationTime != null && expirationTime.before(referenceTime);
        boolean yetValid = notBeforeTime == null || notBeforeTime.before(referenceTime);
        return !expired && yetValid;
    }
}
