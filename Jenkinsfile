pipeline {
  agent any
  stages {
    stage('PactBrokerDocker') {
      steps {
        sh 'cd pact-broker && sudo docker-compose up'
      }
    }

  }
}