package no.knips.util

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Function
import kotlin.collections.HashMap

@Service
class JWTUtil{
    private val SECRET_KEY = "Hemmelig"

    fun extractUsername(token: String): String = extractClaim(token, Function { obj: Claims -> obj.subject })

    fun extractExpiration(token: String): Date = extractClaim(token, Function { obj: Claims -> obj.expiration })

    fun <T> extractClaim(token: String, claimsResolver: Function<Claims, T>): T = claimsResolver.apply(extractAllClaims(token))

    fun extractAllClaims(token : String) : Claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).body

    fun isTokenExpired(token : String) : Boolean = extractExpiration(token).before(Date())

    fun generateToken(userDetails : UserDetails) : String = createToken(HashMap<String, Any>(), userDetails.username)

    fun createToken(claims: MutableMap<String, Any>, subject : String): String = Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 *60 * 10))
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact()

    fun validateToken(token: String, userDetails: UserDetails) : Boolean = extractUsername(token).equals(userDetails.username) && !isTokenExpired(token)
}