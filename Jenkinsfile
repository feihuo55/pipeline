pipeline {
  agent any
  stages {
    stage('PactBrokerDocker') {
      steps {
        dir(path: 'pact-broker') {
          sh 'sudo /usr/local/bin/docker-compose up -d'
        }

      }
    }

  }
}