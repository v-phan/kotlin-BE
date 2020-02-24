package no.knips.repositories

import no.knips.entities.Account
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : CrudRepository<Account, Int> {

    fun findByAccountID(accountID: Int): Account?{
        var accountList = findAll()
        for(account in accountList){
            if(account.accountID == accountID){
                return account
            }
        }
        return null
    }
}