pipeline {
    agent any
    stages {
        stage('clone') {
            steps {
                git branch: 'feature', credentialsId: 'gitlab-token', url: 'https://gitlab.com/snaatak/avengers-p2/devops-repos/scm/roles/jenkins-role.git'
            }
        }
        stage('build') {
            steps {
            
              ansiblePlaybook credentialsId: 'ansible-token', disableHostKeyChecking: true, installation: 'ansible', inventory: 'role/hosts', playbook: 'role/jenkins.yml'
            }
             
         }

    }
}
