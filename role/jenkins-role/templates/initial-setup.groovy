#!groovy
import jenkins.model.*
import hudson.security.*
import jenkins.security.*

def instance = Jenkins.getInstance()

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount("admin", "password")
instance.setSecurityRealm(hudsonRealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(false)
instance.setAuthorizationStrategy(strategy)

// def adminUser = User.getById("admin", false)
// def password = "password".getBytes()
// def passwordHash = Jenkins.get().getSecurityRealm().createDigest(password).toHexString()
// adminUser.addProperty(new hudson.security.HudsonPrivateSecurityRealm.Details(
//   new GrantedAuthority[]{SecurityRealm.AUTHENTICATED_AUTHORITY},
//   passwordHash))

// adminUser.save()

instance.save()