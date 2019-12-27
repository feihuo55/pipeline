pipeline {
  agent any
  stages {
    stage('Compile') {
      steps {
        sh 'mvn clean compile'
      }
    }

    stage('PactBroker') {
      steps {
        dir(path: 'pact-broker') {
          sh 'sudo /usr/local/bin/docker-compose up -d'
        }

      }
    }

    stage('ContractTesting') {
      steps {
        dir(path: 'pact-consumer') {
          sh 'mvn test'
        }

      }
    }

    stage('PublishPact') {
      steps {
        dir(path: 'pact-consumer') {
          sh 'mvn pact:publish'
        }

      }
    }

  }
}