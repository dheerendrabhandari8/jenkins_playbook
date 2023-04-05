import jenkins.model.*
import hudson.util.*

def instance = Jenkins.getInstance()
def desc = instance.getDescriptor("jenkins.install.SetupWizard")
desc.getClass().getDeclaredField("installState").with {
it.accessible = true
it.set(desc, SetupWizard.State.COMPLETED)
}
instance.save()