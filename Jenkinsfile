pipeline {
  agent any
  stages {
    stage('PactBrokerDocker') {
      steps {
        dir(path: 'pact-broker') {
          sh 'sudo /usr/local/bin/docker-compose up'
        }

      }
    }

    stage('BuildComsumer') {
      steps {
        dir(path: 'pact-consumer') {
          sh 'mvn test'
        }

      }
    }

    stage('PublishPact') {
      steps {
        sh 'mvn pact:publish'
      }
    }

  }
}