package no.knips.services
//
//import no.knips.entities.Account
//import org.slf4j.LoggerFactory
//import org.springframework.security.core.GrantedAuthority
//import org.springframework.security.core.authority.SimpleGrantedAuthority
//import org.springframework.security.core.userdetails.UserDetails
//import java.util.stream.Collectors
//
//open class AccountUserDetails : Account, UserDetails {
//
//    private val log = LoggerFactory.getLogger(AccountUserDetails::class.java)
//
//    constructor(account: Account) : super(account)
//
//    override fun getAuthorities(): Collection<GrantedAuthority> {
//        return roles
//                .stream()
//                .map { role ->
//                    log.debug("Granting Authority to user with role: " + role.toString())
//                    SimpleGrantedAuthority(role.toString())
//                }
//                .collect(Collectors.toList())
//
//    }
//
//    override fun getPassword(): String {
//        return super.passphrase!!
//    }
//
//    override fun getUsername(): String {
//        return super.accountname!!
//    }
//
//    override fun isEnabled(): Boolean {
//        return super.enabled
//    }
//
//    override fun isCredentialsNonExpired(): Boolean {
//        return super.credentialsNonExpired
//    }
//
//    override fun isAccountNonExpired(): Boolean {
//        return super.accountNonExpired
//    }
//
//    override fun isAccountNonLocked(): Boolean {
//        return super.accountNonLocked
//    }
//}